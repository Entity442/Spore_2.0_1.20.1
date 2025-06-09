package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Client.AnimationTrackers.PCIAnimationTracker;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.WeakHashMap;

public class PCI extends BaseItem2 implements CustomModelArmorData {
    private static final String CHARGE = "charge";
    private static final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/item/pci.png");
    private static final int RELOAD_TICKS = 60;
    private static final WeakHashMap<Player, Integer> reloadTimers = new WeakHashMap<>();

    public PCI() {
        super(new Properties().stacksTo(1).durability(SConfig.SERVER.pci_durability.get()));
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return TEXTURE;
    }

    public void setCharge(ItemStack stack, int value) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt(CHARGE, value);
    }

    public int getCharge(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.getInt(CHARGE);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        if (entity.level().isClientSide && entity instanceof LocalPlayer player) {
            PCIAnimationTracker.trigger(player);
        }
        return super.onEntitySwing(stack, entity);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int charge = getCharge(stack);
        if (attacker instanceof Player player) {
            if (charge > 0) {
                float targetHP = target.getHealth();
                if (charge >= targetHP) {
                    target.hurt(target.damageSources().freeze(), targetHP);
                    setCharge(stack, charge - (int) targetHP);
                    int stunTime = (int) Math.ceil(targetHP / 5f) * 20;
                    player.getCooldowns().addCooldown(this, stunTime);
                } else {
                    target.hurt(target.damageSources().mobAttack(attacker), SConfig.SERVER.pci_damage.get());
                    startReload(player, stack);
                }
            } else {
                target.hurt(target.damageSources().mobAttack(attacker), SConfig.SERVER.pci_damage.get());
                startReload(player, stack);
            }
        } else {
            target.hurt(target.damageSources().mobAttack(attacker), SConfig.SERVER.pci_damage.get());
        }
        stack.hurtAndBreak(1, attacker, e -> e.broadcastBreakEvent(attacker.getUsedItemHand()));
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (!level.isClientSide && entity instanceof Player player) {
            if (reloadTimers.containsKey(player)) {
                int timer = reloadTimers.get(player) - 1;
                if (timer <= 0) {
                    if (lookForAmmo(player, stack)) {
                        reloadTimers.remove(player);
                        player.getCooldowns().removeCooldown(this); // remove cooldown if any
                    } else {
                        reloadTimers.put(player, RELOAD_TICKS);
                    }
                } else {
                    reloadTimers.put(player, timer);
                }
            }
        }
    }

    private boolean lookForAmmo(Player player, ItemStack itemStack) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (stack.getItem() == Sitems.ICE_CANISTER.get() && stack.getCount() > 0) {
                stack.shrink(1);
                setCharge(itemStack, SConfig.SERVER.pci_max_charge.get());
                return true;
            }
        }
        return false;
    }

    private void startReload(Player player, ItemStack stack) {
        if (!reloadTimers.containsKey(player)) {
            reloadTimers.put(player, RELOAD_TICKS);
            player.getCooldowns().addCooldown(this, RELOAD_TICKS); // optional: add visual reload cooldown
        }
    }
}
