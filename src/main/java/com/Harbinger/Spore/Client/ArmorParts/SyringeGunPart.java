package com.Harbinger.Spore.Client.ArmorParts;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;

public class SyringeGunPart extends ComplexHandModelItem{
    public SyringeGunPart(InteractionHand slot, EntityModel<LivingEntity> model, ModelPart part, float x, float y, float z, float expand, float xspin, float yspin, float zspin) {
        super(slot, Sitems.SYRINGE_GUN.get(), model, part, x, y, z, expand, xspin, yspin, zspin);
    }

    @Override
    public RenderType type(ResourceLocation location) {
        return RenderType.entityCutout(location);
    }
}
