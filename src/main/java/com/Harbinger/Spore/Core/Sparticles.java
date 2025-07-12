package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Spore;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sparticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Spore.MODID);

    public static final RegistryObject<SimpleParticleType> SPORE_PARTICLE =
            PARTICLE_TYPES.register("spore_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> ACID_PARTICLE =
            PARTICLE_TYPES.register("acid_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> BLOOD_PARTICLE =
            PARTICLE_TYPES.register("blood_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SPORE_SLASH =
            PARTICLE_TYPES.register("spore_slash", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SPORE_IMPACT =
            PARTICLE_TYPES.register("spore_impact", () -> new SimpleParticleType(true));
    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
