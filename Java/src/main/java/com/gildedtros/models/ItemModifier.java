package com.gildedtros.models;

public interface ItemModifier {
    void updateQualityItem(Item item);

    void updateSellInItem(Item item);

    void updateExpiredItem(Item item);
}
