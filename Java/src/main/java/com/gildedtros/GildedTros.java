package com.gildedtros;

import com.gildedtros.models.Item;
import com.gildedtros.models.modifier.ItemModifier;
import com.gildedtros.models.modifier.ItemModifierFactory;

public class GildedTros {
    private final Item[] items;
    private final ItemModifierFactory strategyFactory;

    public GildedTros(Item[] items) {
        this.items = items;
        this.strategyFactory = new ItemModifierFactory();
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemModifier strategy = strategyFactory.createStrategy(item);
            strategy.updateQualityItem(item);
            strategy.updateSellInItem(item);
            strategy.updateExpiredItem(item);
        }
    }
}
