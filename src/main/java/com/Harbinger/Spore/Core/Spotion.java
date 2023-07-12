package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Spore;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Spotion {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, Spore.MODID);
    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }


    public static RegistryObject<Potion> MYCELIUM_POTION = POTIONS.register("mycelium_potion",
            () -> new Potion(new MobEffectInstance(Seffects.MYCELIUM.get(), 3600, 1)));
    public static RegistryObject<Potion> MARKER_POTION = POTIONS.register("marker_potion",
            () -> new Potion(new MobEffectInstance(Seffects.MARKER.get(), 3600, 1)));
    public static RegistryObject<Potion> CORROSION_POTION = POTIONS.register("corrosion_potion",
            () -> new Potion(new MobEffectInstance(Seffects.CORROSION.get(), 3600, 0)));
    public static RegistryObject<Potion> CORROSION_POTION_STRONG = POTIONS.register("corrosion_potion_strong",
            () -> new Potion(new MobEffectInstance(Seffects.CORROSION.get(), 3600, 3)));
}
