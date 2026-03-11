package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SporeHorseLivingArmor extends SporeHorseArmor implements CustomModelArmorData{
    private static final ResourceLocation LOCATION = new ResourceLocation("spore:textures/armor/living_horse_set.png");

    public SporeHorseLivingArmor() {
        super(SConfig.SERVER.living_h_protection.get());
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return LOCATION;
    }

    @Override
    public void onHorseArmorTick(ItemStack stack, Level level, Mob horse) {
        super.onHorseArmorTick(stack, level, horse);
        if (horse.isVehicle() && horse.horizontalCollision){
            Vec3 currentMovement = horse.getDeltaMovement();

            if (currentMovement.y < 0.15D) {
                Vec3 climbVec = new Vec3(currentMovement.x, 0.15D, currentMovement.z);
                horse.setDeltaMovement(climbVec);
            }
        }
        if (horse.tickCount % 20 == 0 && horse.getHealth() < horse.getMaxHealth() && !horse.hasEffect(MobEffects.REGENERATION)){
            horse.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, (false), (false)));
        }
    }

}
