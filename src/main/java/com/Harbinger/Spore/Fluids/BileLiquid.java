package com.Harbinger.Spore.Fluids;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BileLiquid extends FluidType {

    public static final ResourceLocation FLUID_STILL = new ResourceLocation("spore:block/bile_static");
    public static final ResourceLocation FLUID_FLOWING = new ResourceLocation("spore:block/bile_flow");
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

            @Override
            public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return new Vector3f(172,131,36);
            }
        });
    }

    @Override
    public boolean canSwim(Entity entity) {
        return entity instanceof UtilityEntity || entity instanceof Infected;
    }

    @Override
    public boolean canExtinguish(Entity entity) {
        return true;
    }

    @Override
    public boolean move(FluidState state, LivingEntity entity, Vec3 movementVector, double gravity) {
        if (entity instanceof UtilityEntity || entity instanceof Infected){
            movementVector.scale(1.2);
            entity.setDeltaMovement(entity.getDeltaMovement().add(0,0.01,0));
            gravity = 0;
        }else{
            movementVector.scale(0.7f);
            if (entity.tickCount % 40 == 0){
                for (MobEffectInstance instance:bileEffects()){
                    entity.addEffect(instance);
                }
                entity.hurt(entity.damageSources().generic(),1f);
            }
        }
        return super.move(state, entity, movementVector, gravity);
    }
    public static List<MobEffectInstance> bileEffects(){
        List<MobEffectInstance> values = new ArrayList<>();
        values.add(new MobEffectInstance(MobEffects.WEAKNESS,100,0));
        values.add(new MobEffectInstance(MobEffects.BLINDNESS,100,0));
        values.add(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,100,0));
        values.add(new MobEffectInstance(Seffects.MYCELIUM.get(),200,0));
        return values;
    }

}
