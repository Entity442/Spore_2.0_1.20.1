package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sitems.BaseWeapons.DamagePiercingModifier;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsBaseItem;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class InfectedMace extends SporeToolsBaseItem implements DamagePiercingModifier {
    public InfectedMace() {
        super(SConfig.SERVER.mace_damage.get(), 2f, 3, SConfig.SERVER.mace_durability.get(), 1);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity livingEntity, LivingEntity entity) {
        entity.knockback(2.2F, Mth.sin(livingEntity.getYRot() * ((float) Math.PI / 180F)), (-Mth.cos(livingEntity.getYRot() * ((float) Math.PI / 180F))));
        return super.hurtEnemy(stack, livingEntity, entity);
    }

    @Override
    public float getMinimalDamage(float damage) {
        return SConfig.SERVER.mace_damage.get() * 0.15f;
    }
}
