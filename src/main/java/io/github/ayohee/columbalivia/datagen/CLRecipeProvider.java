package io.github.ayohee.columbalivia.datagen;

import io.github.ayohee.columbalivia.ColumbaLivia;
import io.github.ayohee.columbalivia.register.CLItems;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class CLRecipeProvider extends RecipeProvider {
    public CLRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CLItems.EXAMPLE_ITEM)
                .requires(CLItems.EXAMPLE_ITEM)
                .unlockedBy("get_item", hasItems(CLItems.EXAMPLE_ITEM))
                .save(recipeOutput, ColumbaLivia.modLoc("test"));
    }


    /*----- UTILITY METHODS -----*/
    public static Criterion<InventoryChangeTrigger.TriggerInstance> hasItems(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }


    /*----- NAMED WRAPPER FOR DataProvider -----*/
    public DataProvider namedWrapper() {
        return new DataProvider() {
            @Override
            public CompletableFuture<?> run(CachedOutput cachedOutput) {
                return CLRecipeProvider.this.run(cachedOutput);
            }

            @Override
            public String getName() {
                return "Columba Livia's Standard Recipes";
            }
        };
    }
}
