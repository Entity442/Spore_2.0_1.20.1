package com.Harbinger.Spore.sEvents;

import com.Harbinger.Spore.ExtremelySusThings.CustomJsonReader.SporeConversionReloadListener;
import com.Harbinger.Spore.ExtremelySusThings.CustomJsonReader.SporeMobConversionReloadListener;
import com.Harbinger.Spore.Spore;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Spore.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ConversionInitialization {
    @SubscribeEvent
    public static void onRegisterReloadListeners(AddReloadListenerEvent event) {
        event.addListener(new SporeConversionReloadListener());
        event.addListener(new SporeMobConversionReloadListener());
    }
}
