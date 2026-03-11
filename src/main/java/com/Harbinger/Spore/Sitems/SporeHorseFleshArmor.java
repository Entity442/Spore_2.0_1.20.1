package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SporeHorseFleshArmor extends SporeHorseArmor implements CustomModelArmorData{
    private static final ResourceLocation LOCATION =new ResourceLocation("spore:textures/armor/flesh_horse_set.png");

    public SporeHorseFleshArmor() {
        super(SConfig.SERVER.flesh_h_protection.get());
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return LOCATION;
    }


    @Override
    public void onHorseArmorTick(ItemStack stack, Level level, Mob horse) {
        super.onHorseArmorTick(stack, level, horse);
        if (horse.tickCount % 20 == 0 && horse.getHealth() < horse.getMaxHealth() && !horse.hasEffect(MobEffects.REGENERATION)) {
            horse.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, (false), (false)));
        }
    }
}
