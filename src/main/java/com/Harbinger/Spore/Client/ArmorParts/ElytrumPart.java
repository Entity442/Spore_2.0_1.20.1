package com.Harbinger.Spore.Client.ArmorParts;

import com.Harbinger.Spore.Client.Models.ElytrumModel;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

public class ElytrumPart extends BodyArmorPart{
    private static final ResourceLocation elytron = new ResourceLocation("spore:textures/armor/elytron.png");
    private static final ElytrumModel<LivingEntity> elytrumModel = new ElytrumModel<>();
    public ElytrumPart(Item item) {
        super(item, () -> elytrumModel, () -> elytrumModel.body, 0f,0f,-0.1f,1f);
    }

    @Override
    protected VertexConsumer consumer(MultiBufferSource source, CustomModelArmorData data, HumanoidModel<LivingEntity> model, LivingEntity livingEntity) {
        return ItemRenderer.getFoilBufferDirect(source, model.renderType(elytron), false, stack(livingEntity).hasFoil());
    }
}
