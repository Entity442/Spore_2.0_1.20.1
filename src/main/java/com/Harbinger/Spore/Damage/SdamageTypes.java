package com.Harbinger.Spore.Damage;

import com.Harbinger.Spore.Spore;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class SdamageTypes {
    public static final ResourceKey<DamageType> MYCELIUM_OVERTAKE = create("mycelium_overtake");

    private static ResourceKey<DamageType> create(String id) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Spore.MODID,id));
    }
}
