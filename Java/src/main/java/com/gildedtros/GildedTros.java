package com.gildedtros;

import static com.gildedtros.constants.ItemNames.*;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    //Todo Split for loops into smaller methodes

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(GOOD_WINE)
                    && !items[i].name.equals(BACKSTAGE_PASSES_REFACTOR)
                    && !items[i].name.equals(BACKSTAGE_PASSES_HAXX))
            {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(B_DAWG_KEYCHAIN)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(BACKSTAGE_PASSES_REFACTOR) || items[i].name.equals(BACKSTAGE_PASSES_HAXX)) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(B_DAWG_KEYCHAIN)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(GOOD_WINE)) {
                    if (!items[i].name.equals(BACKSTAGE_PASSES_REFACTOR) && !items[i].name.equals(BACKSTAGE_PASSES_HAXX)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(B_DAWG_KEYCHAIN)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}