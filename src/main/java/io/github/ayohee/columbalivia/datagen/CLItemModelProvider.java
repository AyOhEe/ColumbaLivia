package io.github.ayohee.columbalivia.datagen;

import io.github.ayohee.columbalivia.register.CLItems;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import static io.github.ayohee.columbalivia.ColumbaLivia.MODID;

public class CLItemModelProvider extends ItemModelProvider {
    public CLItemModelProvider(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, MODID, fileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(CLItems.EXAMPLE_ITEM.get());
    }

    /*----- NAMED WRAPPER FOR DataProvider -----*/
    public DataProvider namedWrapper() {
        return new DataProvider() {
            @Override
            public CompletableFuture<?> run(CachedOutput cachedOutput) {
                return CLItemModelProvider.this.run(cachedOutput);
            }

            @Override
            public String getName() {
                return "Columba Livia's Item Models";
            }
        };
    }
}
