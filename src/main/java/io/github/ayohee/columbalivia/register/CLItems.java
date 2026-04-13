package io.github.ayohee.columbalivia.register;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Function;

import static io.github.ayohee.columbalivia.register.CLRegistries.ITEMS;
import static io.github.ayohee.columbalivia.register.CLTabs.TAB_CONTENTS;

public class CLItems {
    private static DeferredHolder<CreativeModeTab, CreativeModeTab> currentTab = CLTabs.STARDEW_DELIGHT;


    public static final DeferredItem<Item> EXAMPLE_ITEM = item(
            "example_item",
            Item::new,
            p -> p.food(new FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f).build())
    );


    /*----- UTILITY METHODS -----*/
    public static <I extends Item> DeferredItem<I> item(String name, Function<Item.Properties, I> sup, Function<Item.Properties, Item.Properties> pBuilder) {
        DeferredItem<I> i = ITEMS.registerItem(name, p -> sup.apply(pBuilder.apply(p)));
        if (currentTab != null) {
            TAB_CONTENTS.get(currentTab).add(i);
        }
        return i;
    }

    public static <I extends Item> DeferredItem<I> item(String name, Function<Item.Properties, I> sup) {
        return item(name, sup, p -> p);
    }


    /*----- STATIC INITIALIZER -----*/
    public static void register() { }
}
