package com.gildedtros.models;

public class BackstagePassModifier implements ItemModifier {

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