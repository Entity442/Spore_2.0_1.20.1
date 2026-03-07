package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.Models.GrakensenkerModel;
import com.Harbinger.Spore.Client.Models.GrakensenkerShipModel;
import com.Harbinger.Spore.Sentities.Calamities.Grakensenker;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class GrakenShipLayer<T extends Grakensenker> extends RenderLayer<T, GrakensenkerModel<T>> {
    private static final ResourceLocation SHIP = new ResourceLocation(Spore.MODID,"textures/entity/graken_ship.png");
    private static final ResourceLocation SHIP_EYE = new ResourceLocation(Spore.MODID,"textures/entity/eyes/graken_ship.png");
    private final GrakensenkerShipModel<T> model = new GrakensenkerShipModel<>();
    public GrakenShipLayer(RenderLayerParent<T, GrakensenkerModel<T>> layerParent) {
        super(layerParent);
    }


    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
        if (!t.getAdaptation()) {
            return;
        }
        this.getParentModel().copyPropertiesTo(model);
        model.prepareMobModel(t, v, v1, v5);
        model.setupAnim(t, v, v1, v2+t.tickCount, v3, v4);
        renderColoredCutoutModel(model, SHIP, poseStack, multiBufferSource, i, t, 1,1,1);
        VertexConsumer vertexconsumer = multiBufferSource.getBuffer(RenderType.eyes(SHIP_EYE));
        model.renderToBuffer(poseStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1,1,1,1);
    }
}
