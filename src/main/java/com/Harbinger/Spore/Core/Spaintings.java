package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Spore;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Spaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_MOVTIES =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, Spore.MODID);
    public static void register(IEventBus eventBus) {
        PAINTING_MOVTIES.register(eventBus);
    }

    public static final RegistryObject<PaintingVariant> CHANGE = PAINTING_MOVTIES.register("change",
            () -> new PaintingVariant(16, 16));
}
