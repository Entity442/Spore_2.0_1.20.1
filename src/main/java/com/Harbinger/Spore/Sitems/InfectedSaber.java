package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class InfectedSaber extends SporeSwordBase {
    public InfectedSaber() {
        super(SConfig.SERVER.saber_damage.get(), 1f, 2f, SConfig.SERVER.saber_durability.get());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if (!tooHurt(stack)){
            return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
        }
        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void onStopUsing(ItemStack stack, LivingEntity entity, int count) {
        if (!entity.level().isClientSide() && count < 1) {
            entity.hurtMarked = true;
            entity.knockback(4.5F, -entity.getLookAngle().x, -entity.getLookAngle().z);
            if (entity instanceof Player player){
                player.getCooldowns().addCooldown(this,20);
            }
        }
    }
}
