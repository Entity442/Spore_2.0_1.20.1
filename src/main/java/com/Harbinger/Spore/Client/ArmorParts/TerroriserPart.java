package com.Harbinger.Spore.Client.ArmorParts;

import com.Harbinger.Spore.Client.Models.ToxicTerroriserModel;
import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;

public class TerroriserPart extends ComplexHandModelItem{
    public TerroriserPart(InteractionHand slot, ToxicTerroriserModel<LivingEntity> model, ModelPart part, float x, float y, float z, float expand, float xspin, float yspin, float zspin) {
        super(slot, Sitems.TERRORISER.get(), model, part, x, y, z, expand, xspin, yspin, zspin);
    }

    @Override
    public RenderType type(ResourceLocation location) {
        return RenderType.entityCutout(location);
    }
}
