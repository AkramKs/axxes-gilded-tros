package com.gildedtros.models.modifier;

import com.gildedtros.models.Item;

public class DefaultItemModifier implements ItemModifier {

    /**
     * Default item modifier for items that do not fall into any special category.
     * This modifier decreases the quality by 1 each day and decreases the sellIn by 1 each day.
     * If the sellIn is less than 0, the quality decreases by an additional 1.
     */

    @Override
    public void updateQualityItem(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    @Override
    public void updateSellInItem(Item item) {
        item.sellIn--;
    }

    @Override
    public void updateExpiredItem(Item item) {
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }
}
