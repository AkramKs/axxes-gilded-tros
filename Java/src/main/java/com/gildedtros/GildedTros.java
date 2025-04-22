package com.gildedtros;

import com.gildedtros.models.Item;
import com.gildedtros.models.modifier.ItemModifier;
import com.gildedtros.models.modifier.ItemModifierFactory;

public class GildedTros {

    private GildedTros() {
    }

    public static void updateQuality(Item[] items) {
        for (Item item : items) {
            ItemModifier strategy = ItemModifierFactory.createModifier(item);
            strategy.updateQualityItem(item);
            strategy.updateSellInItem(item);
            strategy.updateExpiredItem(item);
        }
    }
}
