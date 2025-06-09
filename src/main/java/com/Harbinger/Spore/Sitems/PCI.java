package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Client.AnimationTrackers.PCIAnimationTracker;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

public class PCI extends BaseItem2 implements CustomModelArmorData {
    private final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/item/pci.png");
    public PCI() {
        super(new Properties().stacksTo(1).durability(50));
    }
    @Override
    public ResourceLocation getTextureLocation() {
        return TEXTURE;
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        if (entity.level().isClientSide && entity instanceof LocalPlayer player) {
            PCIAnimationTracker.trigger(player);
        }
        return super.onEntitySwing(stack, entity);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity livingEntity, LivingEntity victim) {
        return super.hurtEnemy(stack, livingEntity, victim);
    }
}
