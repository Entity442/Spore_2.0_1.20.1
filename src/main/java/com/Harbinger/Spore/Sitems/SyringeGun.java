package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

import java.util.List;

public class SyringeGun extends BaseItem2 implements CustomModelArmorData{
    private static final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/item/syringe_gun.png");
    private final List<ItemStack> clip = List.of(new ItemStack(Sitems.SYRINGE.get()),new ItemStack(Sitems.SYRINGE.get()),new ItemStack(Sitems.SYRINGE.get()),new ItemStack(Sitems.SYRINGE.get()));
    public SyringeGun() {
        super(new Properties().stacksTo(1));
    }
    public List<ItemStack> getClip(){return clip;}

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
