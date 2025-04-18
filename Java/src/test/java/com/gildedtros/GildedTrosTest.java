package com.gildedtros;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedTrosTest {

    private GildedTros app;
    private Item[] items;

    //Todo check all possible scenarios based on the Gilded Tros document.....

    @Nested
    class GeneralItemRules {

        @Test
        void shouldHaveSellInAndQuality() {
            Item item = new Item("Ring of Cleansening Code", 10, 20);
            assertEquals(10, item.sellIn);
            assertEquals(20, item.quality);
        }

        @Test
        void shouldLowersSellInAndQualityAtEndOfDay() {
            items = new Item[]{new Item("Elixir of the SOLID", 5, 7)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(4, items[0].sellIn);
            assertEquals(6, items[0].quality);
        }

        @Test
        void shouldDegradeQualityTwiceAsFastAfterSellDate() {
            items = new Item[]{new Item("Elixir of the SOLID", 0, 10)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(-1, items[0].sellIn);
            assertEquals(8, items[0].quality);
        }

        @Test
        void qualityIsNeverNegative() {
            items = new Item[]{new Item("Elixir of the SOLID", 5, 0)};
            app = new GildedTros(items);
            app.updateQuality();
            assertEquals(4, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }

        @Test
        void qualityNeverExceedsFifty() {
            items = new Item[]{new Item("Good Wine", 5, 50)};
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
            items = new Item[]{new Item("Good Wine", 10, 10)};
            app = new GildedTros(items);

            app.updateQuality();
            assertEquals(9, items[0].sellIn);
            assertEquals(11, items[0].quality);
        }
    }

    @Nested
    class LegendaryItem {

        @Test
        void neverDecreasesInSellInOrQuality() {
            items = new Item[]{new Item("B-DAWG Keychain", 0, 80)};
            app = new GildedTros(items);

            app.updateQuality();
            assertEquals(0, items[0].sellIn);
            assertEquals(80, items[0].quality);
        }
    }

}
