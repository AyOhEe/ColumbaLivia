package io.github.ayohee.columbalivia.register;

import io.github.ayohee.columbalivia.register.lib.DeferredBlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Function;

import static io.github.ayohee.columbalivia.register.CLRegistries.BLOCKS;
import static io.github.ayohee.columbalivia.register.CLRegistries.ITEMS;
import static io.github.ayohee.columbalivia.register.CLTabs.TAB_CONTENTS;

public class CLBlocks {
    private static DeferredHolder<CreativeModeTab, CreativeModeTab> currentTab = CLTabs.STARDEW_DELIGHT;


    public static final DeferredBlockItem<Block> EXAMPLE_BLOCK = blockItem(
            "example_block",
            Block::new,
            p -> p.mapColor(MapColor.STONE)
    );


    /*----- UTILITY METHODS -----*/
    private static <B extends Block> DeferredBlock<B> block(String name, Function<BlockBehaviour.Properties, B> sup, Function<BlockBehaviour.Properties, BlockBehaviour.Properties> pBuilder) {
        return BLOCKS.registerBlock(name, (p) -> sup.apply(pBuilder.apply(p)));
    }

    private static <B extends Block> DeferredBlock<B> block(String name, Function<BlockBehaviour.Properties, B> sup) {
        return block(name, sup, p -> p);
    }


    private static <B extends Block> DeferredBlockItem<B> blockItem(DeferredBlock<B> block) {
        DeferredBlockItem<B> d = new DeferredBlockItem<>(block, ITEMS);
        if (currentTab != null) {
            TAB_CONTENTS.get(currentTab).add(d);
        }
        return d;
    }

    private static <B extends Block> DeferredBlockItem<B> blockItem(String name, Function<BlockBehaviour.Properties, B> sup, Function<BlockBehaviour.Properties, BlockBehaviour.Properties> pBuilder) {
        return blockItem(block(name, sup, pBuilder));
    }

    private static <B extends Block> DeferredBlockItem<B> blockItem(String name, Function<BlockBehaviour.Properties, B> sup) {
        return blockItem(block(name, sup));
    }


    /*----- STATIC INITIALIZER -----*/
    public static void register() { }
}
