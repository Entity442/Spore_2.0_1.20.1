package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.Projectile.ThrownSickle;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.List;

public class InfectedSickle extends SporeSwordBase {
    private static final String SICKLE_THROWN = "sickle_thrown";
    private static final String THROWN = "thrown";
    public InfectedSickle() {
        super(SConfig.SERVER.sickle_damage.get(), 2f, 2, SConfig.SERVER.sickle_durability.get());
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_HOE) ? 2F:1F;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        return getThrownSickle(stack) ? ImmutableMultimap.of() : super.getAttributeModifiers(slot, stack);
    }

    @Override
    public boolean reversedKnockback() {
        return true;
    }

    public void setThrownSickle(ItemStack stack,boolean value){
        CompoundTag tag = stack.getOrCreateTagElement(SICKLE_THROWN);
        tag.putBoolean(THROWN,value);
    }
    public boolean getThrownSickle(ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(SICKLE_THROWN);
        return tag.getBoolean(THROWN);
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.SPEAR;
    }

    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (hand != InteractionHand.MAIN_HAND) {
            return InteractionResultHolder.pass(player.getItemInHand(hand));
        }
        ItemStack itemstack = player.getMainHandItem();
        if (!level.isClientSide) {
            List<ThrownSickle> projectiles = level.getEntitiesOfClass(ThrownSickle.class, player.getBoundingBox().inflate(32),
                    s -> s.getOwner() == player && !s.isRemoved());
            setThrownSickle(itemstack, false);

            if (!projectiles.isEmpty()) {
                ThrownSickle sickle = projectiles.get(0);
                if (sickle.getHookState() == ThrownSickle.SickelState.HOOKED_IN_ENTITY && sickle.getHookedEntity() != null) {
                    Entity hooked = sickle.getHookedEntity();

                    if (hooked instanceof LivingEntity le && le.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getValue() > 0.5) {
                        pullEntityToward(player, hooked.position());
                    } else {
                        pullEntityToward(hooked, player.position());
                    }

                } else if (sickle.getHookState() == ThrownSickle.SickelState.HOOKED_BLOCK && sickle.getHookedBlockPos() != null) {
                    pullEntityToward(player, sickle.getHookedBlockPos());
                }
                sickle.discard();
            } else {
                player.startUsingItem(hand);
                return InteractionResultHolder.success(itemstack);
            }
        }

        return InteractionResultHolder.pass(itemstack);
    }

    private void pullEntityToward(Entity toMove, Vec3 targetPos) {
        Vec3 direction = targetPos.subtract(toMove.position()).normalize();
        double strength = 4D;
        Vec3 velocity = direction.multiply(strength,strength/2,strength);
        toMove.setDeltaMovement(velocity);
        toMove.hurtMarked = true;
    }
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int T) {
        if (entity instanceof Player player && !getThrownSickle(stack)) {
            int i = this.getUseDuration(stack) - T;
            if (i >= 10 && !level.isClientSide) {
                stack.hurtAndBreak(1, player, (ss) -> {
                    ss.broadcastBreakEvent(entity.getUsedItemHand());});
                ThrownSickle thrownSpear = new ThrownSickle(level, player, stack,getVariant(stack).getColor());
                thrownSpear.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2F , 0.75F);
                level.addFreshEntity(thrownSpear);
                this.setThrownSickle(stack,true);
                level.playSound(null, thrownSpear, Ssounds.INFECTED_WEAPON_THROW.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
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

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) && !ImmutableSet.of(Enchantments.KNOCKBACK).contains(enchantment);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_SHEARS_ACTIONS.contains(toolAction);
    }
}
