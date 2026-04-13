package io.github.ayohee.columbalivia.register.lib;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DeferredBlockItem<B extends Block> implements ItemLike {
    protected DeferredBlock<B> block;
    protected DeferredItem<? extends Item> item;

    public DeferredBlockItem(DeferredBlock<B> block, DeferredRegister.Items itemRegistry) {
        this.block = block;
        this.item = itemRegistry.registerSimpleBlockItem(block);
    }

    public DeferredBlock<B> getBlock() {
        return block;
    }

    public DeferredItem<? extends Item> getItem() {
        return item;
    }

    @Override
    public Item asItem() {
        return getItem().asItem();
    }
}
