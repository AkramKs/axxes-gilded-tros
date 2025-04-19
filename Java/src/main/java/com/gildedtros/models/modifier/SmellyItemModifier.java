package com.gildedtros.models.modifier;

import com.gildedtros.models.Item;

public class SmellyItemModifier implements ItemModifier {
    @Override
    public void updateQualityItem(Item item) {
        if (item.quality > 0) {
            item.quality = Math.max(0, item.quality - 2);
        }
    }

    @Override
    public void updateSellInItem(Item item) {
        item.sellIn--;
    }

    @Override
    public void updateExpiredItem(Item item) {
        if (item.sellIn < 0) {
            item.quality = Math.max(0, item.quality - 2);
        }
    }
}
