package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.Projectile.ThrownSpear;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class InfectedSpearItem extends SporeSwordBase {
    public InfectedSpearItem() {
        super(SConfig.SERVER.spear_damage.get(), 2.3f, 3, SConfig.SERVER.spear_durability.get());
    }


    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.SPEAR;
    }

    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!tooHurt(itemstack)){
            return InteractionResultHolder.fail(itemstack);
        }
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int T) {
        if (entity instanceof Player player) {
            int i = this.getUseDuration(stack) - T;
            if (i >= 10 && !level.isClientSide) {
                            stack.hurtAndBreak(1, player, (ss) -> {
                            ss.broadcastBreakEvent(entity.getUsedItemHand());});

                            ThrownSpear thrownSpear = new ThrownSpear(level, player, stack);
                            thrownSpear.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F , 1.0F);
                            if (player.getAbilities().instabuild) {
                                thrownSpear.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                            }
                            level.addFreshEntity(thrownSpear);
                            level.playSound(null, thrownSpear, Ssounds.INFECTED_WEAPON_THROW.get(), SoundSource.PLAYERS, 0.5F, 1.1F);
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

            }

                    player.awardStat(Stats.ITEM_USED.get(this));


            }
    }

    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        hurtTool(stack,entity,1);
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || ImmutableSet.of(Enchantments.LOYALTY).contains(enchantment);
    }
}

