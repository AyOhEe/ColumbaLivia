package io.github.ayohee.columbalivia;

import io.github.ayohee.columbalivia.datagen.CLBlockStateProvider;
import io.github.ayohee.columbalivia.datagen.CLItemModelProvider;
import io.github.ayohee.columbalivia.datagen.CLRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static io.github.ayohee.columbalivia.ColumbaLivia.MODID;

public class CLDatagen {
    public static void gatherDataHighPriority(GatherDataEvent event) {
        // Yet empty.
    }

    public static void gatherData(GatherDataEvent event) {
        if (!event.getMods().contains(MODID)) {
            return;
        }
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();


        generator.addProvider(event.includeServer(), new CLRecipeProvider(output, lookupProvider).namedWrapper());
        generator.addProvider(event.includeClient(), new CLBlockStateProvider(output, fileHelper).namedWrapper());
        generator.addProvider(event.includeClient(), new CLItemModelProvider(output, fileHelper).namedWrapper());

        System.out.println("Gathering data for Columba Livia");
        System.out.println(event.includeServer());
    }
}
