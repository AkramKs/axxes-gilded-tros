package com.gildedtros.models.modifier;

import com.gildedtros.models.Item;

public interface ItemModifier {
    void updateQualityItem(Item item);

    void updateSellInItem(Item item);

    void updateExpiredItem(Item item);
}
