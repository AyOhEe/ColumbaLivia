package io.github.ayohee.columbalivia.register;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.*;

import static io.github.ayohee.columbalivia.register.CLRegistries.CREATIVE_MODE_TABS;

public class CLTabs {
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STARDEW_DELIGHT = CREATIVE_MODE_TABS.register("columba_livia", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.columbalivia"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(CLBlocks.EXAMPLE_BLOCK.getItem()::toStack)
            .displayItems((parameters, output) -> {
                CLTabs.TAB_CONTENTS.get(CLTabs.STARDEW_DELIGHT).forEach(output::accept);
            })
            .build());


    /* Keeps track of the order in which items should appear in the creative menu. Each tab needs a new empty list. */
    public static final Map<DeferredHolder<CreativeModeTab, CreativeModeTab>, List<ItemLike>> TAB_CONTENTS = new HashMap<>();
    static {
        TAB_CONTENTS.put(CLTabs.STARDEW_DELIGHT, new LinkedList<>());
    }

    /*----- STATIC INITIALIZER -----*/
    public static void register() { }
}
