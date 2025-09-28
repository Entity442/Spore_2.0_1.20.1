package com.Harbinger.Spore.Sitems;

import net.minecraft.resources.ResourceLocation;

public class SyringeGun extends BaseItem2 implements CustomModelArmorData{
    private static final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/item/syringe_gun.png");
    public SyringeGun() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return TEXTURE;
    }
}
