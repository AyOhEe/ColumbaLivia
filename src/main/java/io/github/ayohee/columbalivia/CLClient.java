package io.github.ayohee.columbalivia;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import static io.github.ayohee.columbalivia.ColumbaLivia.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CLClient {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Yet empty.
    }
}
