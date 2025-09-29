package com.Harbinger.Spore.Sitems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class SyringeGun extends BaseItem2 implements CustomModelArmorData{
    private static final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/item/syringe_gun.png");
    public SyringeGun() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return TEXTURE;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }
}
