package com.gildedtros.models.modifier;

import com.gildedtros.models.Item;

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
            case DUPLICATE_CODE:
            case LONG_METHODS:
            case UGLY_VARIABLE_NAMES:
                return new SmellyItemModifier();
            default:
                return new DefaultItemModifier();
        }
    }
}