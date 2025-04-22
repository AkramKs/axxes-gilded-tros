package com.gildedtros.models.modifier;

import com.gildedtros.models.Item;
import org.junit.jupiter.api.Test;

import static com.gildedtros.constants.ItemNames.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemModifierFactoryTest {

    @Test
    void ShouldReturnGoodWineModifierForGoodWine() {
        Item item = new Item(GOOD_WINE, 10, 20);
        ItemModifier modifier = ItemModifierFactory.createModifier(item);
        assertTrue(modifier instanceof GoodWineModifier);
    }

    @Test
    void ShouldReturnBackstagePassModifierForBackstagePassesRefactor() {
        Item item = new Item(BACKSTAGE_PASSES_REFACTOR, 15, 30);
        ItemModifier modifier = ItemModifierFactory.createModifier(item);
        assertTrue(modifier instanceof BackstagePassModifier);
    }

    @Test
    void ShouldReturnBackstagePassModifierForBackstagePassesHaxx() {
        Item item = new Item(BACKSTAGE_PASSES_HAXX, 15, 30);
        ItemModifier modifier = ItemModifierFactory.createModifier(item);
        assertTrue(modifier instanceof BackstagePassModifier);
    }

    @Test
    void ShouldReturnLegendaryItemModifierForBDawgKeychain() {
        Item item = new Item(B_DAWG_KEYCHAIN, 5, 80);
        ItemModifier modifier = ItemModifierFactory.createModifier(item);
        assertTrue(modifier instanceof LegendaryItemModifier);
    }

    @Test
    void ShouldReturnSmellyItemModifierForDuplicateCode() {
        Item item = new Item(DUPLICATE_CODE, 3, 10);
        ItemModifier modifier = ItemModifierFactory.createModifier(item);
        assertTrue(modifier instanceof SmellyItemModifier);
    }

    @Test
    void ShouldReturnSmellyItemModifierForLongMethods() {
        Item item = new Item(LONG_METHODS, 3, 10);
        ItemModifier modifier = ItemModifierFactory.createModifier(item);
        assertTrue(modifier instanceof SmellyItemModifier);
    }

    @Test
    void ShouldReturnSmellyItemModifierForUglyVariableNames() {
        Item item = new Item(UGLY_VARIABLE_NAMES, 3, 10);
        ItemModifier modifier = ItemModifierFactory.createModifier(item);
        assertTrue(modifier instanceof SmellyItemModifier);
    }

    @Test
    void ShouldReturnDefaultItemModifierForUnknownItem() {
        Item item = new Item("Unknown Item", 5, 10);
        ItemModifier modifier = ItemModifierFactory.createModifier(item);
        assertTrue(modifier instanceof DefaultItemModifier);
    }
}
