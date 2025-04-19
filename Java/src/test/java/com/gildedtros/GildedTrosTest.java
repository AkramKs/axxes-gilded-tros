package com.gildedtros;

import com.gildedtros.models.Item;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedtros.constants.ItemNames.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedTrosTest {

    private GildedTros app;
    private Item[] items;

    //Todo add tests for DefaultItemModifierTest , BackstagePassModifierTest, SmellyItemModifierTest
    //Todo add tests for ItemModifierFactoryTest

    @Nested
    class GeneralItemRules {

        @Test
        void shouldHaveSellInAndQuality() {
            Item item = new Item(RING_OF_CLEANSENING, 10, 20);
            assertEquals(10, item.sellIn);
            assertEquals(20, item.quality);
        }

        @Test
        void shouldLowersSellInAndQualityAtEndOfDay() {
            items = new Item[]{new Item(ELIXIR_OF_THE_SOLD, 5, 7)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(4, items[0].sellIn);
            assertEquals(6, items[0].quality);
        }

        @Test
        void shouldDegradeQualityTwiceAsFastAfterSellDate() {
            items = new Item[]{new Item(ELIXIR_OF_THE_SOLD, 0, 10)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(-1, items[0].sellIn);
            assertEquals(8, items[0].quality);
        }

        @Test
        void qualityIsNeverNegative() {
            items = new Item[]{new Item(ELIXIR_OF_THE_SOLD, 5, 0)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(4, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }

        @Test
        void qualityNeverExceedsFifty() {
            items = new Item[]{new Item(GOOD_WINE, 5, 50)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(4, items[0].sellIn);
            assertEquals(50, items[0].quality);
        }
    }

    @Nested
    class GoodWineItem {

        @Test
        void qualityIncreasesOverTime() {
            items = new Item[]{new Item(GOOD_WINE, 10, 10)};
            app = new GildedTros(items);

            app.updateQuality();
            assertEquals(9, items[0].sellIn);
            assertEquals(11, items[0].quality);
        }

        @Test
        void qualityIncreasesEvenAfterSellInDate() {
            items = new Item[]{new Item(GOOD_WINE, 0, 10)};
            app = new GildedTros(items);

            app.updateQuality();
            assertEquals(-1, items[0].sellIn);
            assertEquals(12, items[0].quality);
        }

        @Test
        void qualityNeverExceedsFifty() {
            items = new Item[]{new Item(GOOD_WINE, 0, 50)};
            app = new GildedTros(items);

            app.updateQuality();
            assertEquals(-1, items[0].sellIn);
            assertEquals(50, items[0].quality);
        }
    }

    @Nested
    class LegendaryItem {

        @Test
        void neverDecreasesInSellInOrQuality() {
            items = new Item[]{new Item(B_DAWG_KEYCHAIN, 0, 80)};
            app = new GildedTros(items);

            app.updateQuality();
            assertEquals(0, items[0].sellIn);
            assertEquals(80, items[0].quality);
        }
    }

    @Nested
    class BackstagePass {

        @Test
        void increasesBy1WhenMoreThan10DaysLeft() {
            items = new Item[]{new Item(BACKSTAGE_PASSES_REFACTOR, 11, 20)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(10, items[0].sellIn);
            assertEquals(21, items[0].quality);
        }

        @Test
        void increasesBy2When10OrLessDaysLeft() {
            items = new Item[]{new Item(BACKSTAGE_PASSES_REFACTOR, 10, 20)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(9, items[0].sellIn);
            assertEquals(22, items[0].quality);
        }

        @Test
        void increasesBy3When5OrLessDaysLeft() {
            items = new Item[]{new Item(BACKSTAGE_PASSES_HAXX, 5, 20)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(4, items[0].sellIn);
            assertEquals(23, items[0].quality);
        }

        @Test
        void dropsToZeroAfterConcert() {
            items = new Item[]{new Item(BACKSTAGE_PASSES_HAXX, 0, 20)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(-1, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }
    }

    @Nested
    class SmellyItems {
        @Test
        void duplicateCodeDegradesTwiceAsFast() {
            items = new Item[]{new Item(DUPLICATE_CODE, 10, 10)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(9, items[0].sellIn);
            assertEquals(8, items[0].quality);
        }

        @Test
        void longMethodsDegradesTwiceAsFast() {
            items = new Item[]{new Item(LONG_METHODS, 10, 10)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(9, items[0].sellIn);
            assertEquals(8, items[0].quality);
        }

        @Test
        void uglyVariableNamesDegradesTwiceAsFast() {
            items = new Item[]{new Item(UGLY_VARIABLE_NAMES, 10, 10)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(9, items[0].sellIn);
            assertEquals(8, items[0].quality);
        }

        @Test
        void smellyItemsDegradeTwiceAsFastAfterExpiry() {
            items = new Item[]{new Item(DUPLICATE_CODE, 0, 10)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(-1, items[0].sellIn);
            assertEquals(6, items[0].quality);
        }

        @Test
        void smellyItemDegradesToZeroQuality() {
            items = new Item[]{new Item(DUPLICATE_CODE, 5, 1)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(4, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }

        @Test
        void smellyItemsQualityNeverNegative() {
            items = new Item[]{new Item(LONG_METHODS, 5, 0)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(4, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }
    }
}
