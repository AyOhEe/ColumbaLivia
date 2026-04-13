package io.github.ayohee.columbalivia;

import com.mojang.logging.LogUtils;
import io.github.ayohee.columbalivia.register.CLBlocks;
import io.github.ayohee.columbalivia.register.CLItems;
import io.github.ayohee.columbalivia.register.CLRegistries;
import io.github.ayohee.columbalivia.register.CLTabs;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(ColumbaLivia.MODID)
public class ColumbaLivia {
    public static final String MODID = "columbalivia";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ColumbaLivia(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(EventPriority.HIGHEST, CLDatagen::gatherDataHighPriority);
        modEventBus.addListener(EventPriority.LOWEST, CLDatagen::gatherData);

        CLTabs.register();
        CLBlocks.register();
        CLItems.register();

        CLRegistries.register(modEventBus);

        // Uncomment when we have an @SubscribeEvent callback
        //NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, CLConfig.SPEC);
    }

    public static ResourceLocation modLoc(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Yet empty.
    }
}
