package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.Projectile.ThrownBoomerang;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class InfectedBoomerang extends SporeSwordBase {
    public InfectedBoomerang() {
        super(SConfig.SERVER.boomerang_damage.get(), 1f, 2f, SConfig.SERVER.boomerang_durability.get());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (player instanceof ServerPlayer && !level.isClientSide) {
            stack.hurtAndBreak(1, player, (ss) -> {
                ss.broadcastBreakEvent(player.getUsedItemHand());});
            ThrownBoomerang thrownSpear = new ThrownBoomerang(level, player, stack);
            thrownSpear.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1F , 0.75F);
            if (player.getAbilities().instabuild) {
                thrownSpear.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
            }
            level.addFreshEntity(thrownSpear);
            level.playSound(null, thrownSpear, Ssounds.INFECTED_WEAPON_THROW.get(), SoundSource.PLAYERS, 1.5F, 0.9F);
            if (!player.getAbilities().instabuild) {
                player.getInventory().removeItem(stack);
            }

            int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, stack);
            if (j > 0) {
                thrownSpear.setBaseDamage(thrownSpear.getBaseDamage() + (double)j * 0.5D + 0.5D);
            }

            int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.KNOCKBACK, stack);
            if (k > 0) {
                thrownSpear.setKnockback(k);
            }
            player.awardStat(Stats.ITEM_USED.get(this));
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }
        return super.use(level, player, hand);
    }

}
