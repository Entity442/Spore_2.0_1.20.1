package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Sitems.BaseWeapons.DamagePiercingModifier;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

public class InfectedRapier extends SporeSwordBase implements DamagePiercingModifier {
    public InfectedRapier() {
        super(SConfig.SERVER.rapier_damage.get(), 2, 2, SConfig.SERVER.rapier_durability.get(),"rapier");
    }

    @Override
    public void doEntityHurtAfterEffects(ItemStack stack, LivingEntity victim, LivingEntity entity) {
        super.doEntityHurtAfterEffects(stack, victim, entity);
        int level = stack.getEnchantmentLevel(Senchantments.CORROSIVE_POTENCY.get()) > 0 ? 3 : 1;
        victim.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),60,level ,true,true));
    }

    @Override
    protected ChatFormatting getDesColor() {
        return ChatFormatting.GREEN;
    }

    @Override
    public float getMinimalDamage(float damage) {
        return SConfig.SERVER.rapier_damage.get() * 0.3f;
    }
}
