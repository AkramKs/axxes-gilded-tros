package com.gildedtros;

import static com.gildedtros.constants.ItemNames.*;

class GildedTros {
    private final Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
            updateSellIn(item);
            handleExpiredItem(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (isSpecialItem(item)) {
            increaseQuality(item);

            if (isBackstagePass(item)) {
                if (item.sellIn < 11) {
                    increaseQuality(item);
                }
                if (item.sellIn < 6) {
                    increaseQuality(item);
                }
            }
        } else {
            if (item.quality > 0 && !isLegendary(item)) {
                decreaseQuality(item);
            }
        }
    }

    private void updateSellIn(Item item) {
        if (!isLegendary(item)) {
            item.sellIn--;
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.sellIn >= 0) return;

        if (item.name.equals(GOOD_WINE)) {
            increaseQuality(item);
        } else if (isBackstagePass(item)) {
            item.quality = 0;
        } else {
            if (item.quality > 0 && !isLegendary(item)) {
                decreaseQuality(item);
            }
        }
    }

    private boolean isSpecialItem(Item item) {
        return item.name.equals(GOOD_WINE) || isBackstagePass(item);
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals(BACKSTAGE_PASSES_REFACTOR)
                || item.name.equals(BACKSTAGE_PASSES_HAXX);
    }

    private boolean isLegendary(Item item) {
        return item.name.equals(B_DAWG_KEYCHAIN);
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        item.quality--;
    }
}
