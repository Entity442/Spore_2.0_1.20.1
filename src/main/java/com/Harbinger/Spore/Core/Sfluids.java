package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Fluids.BileLiquid;
import com.Harbinger.Spore.Spore;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sfluids {
    public static final DeferredRegister<FluidType> SPORE_FLUID_TYPE = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Spore.MODID);
    public static final DeferredRegister<Fluid> SPORE_FLUID = DeferredRegister.create(ForgeRegistries.FLUIDS, Spore.MODID);
    private static ForgeFlowingFluid.Properties bileProperties() {
        return new ForgeFlowingFluid.Properties(BILE_FLUID_TYPE, Bile_FLUID_SOURCE, BILE_FLUID_FLOWING).bucket(Sitems.BUCKET_OF_BILE).block(Sblocks.BILE);
    }

    public static final RegistryObject<FluidType> BILE_FLUID_TYPE = SPORE_FLUID_TYPE.register("bile", () -> new BileLiquid(FluidType.Properties.create().lightLevel(5).density(1024).viscosity(1024).pathType(BlockPathTypes.LAVA).adjacentPathType(BlockPathTypes.DANGER_OTHER).sound(SoundActions.BUCKET_EMPTY, SoundEvents.WATER_AMBIENT).sound(SoundActions.BUCKET_FILL, SoundEvents.WATER_AMBIENT)));
    public static final RegistryObject<FlowingFluid> Bile_FLUID_SOURCE = SPORE_FLUID.register("bile", () -> new ForgeFlowingFluid.Source(bileProperties()));
    public static final RegistryObject<FlowingFluid> BILE_FLUID_FLOWING = SPORE_FLUID.register("bile_flowing", () -> new ForgeFlowingFluid.Flowing(bileProperties()));

    public static void postInit() {
        FluidInteractionRegistry.addInteraction(BILE_FLUID_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                ForgeMod.WATER_TYPE.get(),
                fluidState -> Sblocks.BIOMASS_BLOCK.get().defaultBlockState()
        ));
        FluidInteractionRegistry.addInteraction(BILE_FLUID_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                ForgeMod.LAVA_TYPE.get(),
                fluidState -> Sblocks.ROOTED_BIOMASS.get().defaultBlockState()
        ));
    }

}
