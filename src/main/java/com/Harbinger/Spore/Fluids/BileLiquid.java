package com.Harbinger.Spore.Fluids;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class BileLiquid extends FluidType {

    public static final ResourceLocation FLUID_STILL = new ResourceLocation("spore:block/bile_static");
    public static final ResourceLocation FLUID_FLOWING = new ResourceLocation("spore:block/bile_static");
    public static final ResourceLocation OVERLAY = new ResourceLocation("spore:textures/extra/bile_overlay.png");

    public BileLiquid(Properties properties) {
        super(properties);
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return FLUID_STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLUID_FLOWING;
            }

            @Override
            public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
                return OVERLAY;
            }
        });
    }
}
