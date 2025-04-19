package com.gildedtros.models.modifier;

import com.gildedtros.models.Item;

public class GoodWineModifier implements ItemModifier {

    /**
     * Good Wine is a special item that increases in quality as it gets older.
     * The quality of the item increases by 1 as long as it is less than 50.
     * If the sellIn date is less than or equal to 0, the quality increases by 2.
     */

    @Override
    public void updateQualityItem(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    @Override
    public void updateSellInItem(Item item) {
        item.sellIn--;
    }

    @Override
    public void updateExpiredItem(Item item) {
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }
}
