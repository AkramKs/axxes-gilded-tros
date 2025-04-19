package com.gildedtros.models.modifier;

import com.gildedtros.models.Item;

public class LegendaryItemModifier implements ItemModifier {

    /**
     * Legendary items do not change in quality or sellIn.
     * They are never sold and do not decrease in quality.
     */

    @Override
    public void updateQualityItem(Item item) {
        // Legendary items do not change in quality
    }

    @Override
    public void updateSellInItem(Item item) {
        // Legendary items do not change in sellIn
    }

    @Override
    public void updateExpiredItem(Item item) {
        // Legendary items do not change in quality when expired
    }
}
