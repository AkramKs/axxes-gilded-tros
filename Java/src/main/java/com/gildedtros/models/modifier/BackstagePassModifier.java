package com.gildedtros.models.modifier;

import com.gildedtros.models.Item;

public class BackstagePassModifier implements ItemModifier {

    /**
     * Backstage passes increase in quality as the sellIn date approaches.
     * Quality increases by 1 when there are 10 days or more, by 2 when there are 5 days or less,
     * and by 3 when the sellIn date has passed.
     */

    @Override
    public void updateQualityItem(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality++;
            }
            if (item.sellIn < 6 && item.quality < 50) {
                item.quality++;
            }
        }
    }

    @Override
    public void updateSellInItem(Item item) {
        item.sellIn--;
    }

    @Override
    public void updateExpiredItem(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}