package com.gildedtros.models;

import static com.gildedtros.constants.ItemNames.*;

public class ItemModifierFactory {
    public ItemModifier createStrategy(Item item) {
        switch (item.name) {
            case GOOD_WINE:
                return new GoodWineModifier();
            case BACKSTAGE_PASSES_REFACTOR:
            case BACKSTAGE_PASSES_HAXX:
                return new BackstagePassModifier();
            case B_DAWG_KEYCHAIN:
                return new LegendaryItemModifier();
            default:
                return new DefaultItemModifier();
        }
    }
}
