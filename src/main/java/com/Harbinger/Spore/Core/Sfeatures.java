package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Spore;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Sfeatures {
    public static final DeferredRegister<Feature<?>> SPORE_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Spore.MODID);
    public static void register(IEventBus eventBus) {SPORE_FEATURES.register(eventBus);}




}
