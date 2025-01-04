package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InfectedRapier extends SporeSwordBase {
    public InfectedRapier() {
        super(SConfig.SERVER.rapier_damage.get(), 2.5, 2, SConfig.SERVER.rapier_durability.get());
    }

    @Override
    public void doEntityHurtAfterEffects(ItemStack stack, LivingEntity victim, LivingEntity entity) {
        super.doEntityHurtAfterEffects(stack, victim, entity);
        int level = stack.getEnchantmentLevel(Senchantments.CORROSIVE_POTENCY.get()) > 0 ? 3 : 1;
        victim.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),60,level ,true,true));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(Component.translatable("item.rapier.corrosive").withStyle(ChatFormatting.GREEN));
        super.appendHoverText(itemStack, level, components, flag);
    }
}
