package com.Harbinger.Spore.Client.Layers;



import com.Harbinger.Spore.Client.Models.ProtoChritsmasHat;
import com.Harbinger.Spore.Client.Models.ProtoRedesign;
import com.Harbinger.Spore.Client.Renderers.ProtoRenderer;
import com.Harbinger.Spore.Core.SConfig;

import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class ProtoHatLayer<T extends Proto> extends RenderLayer<T, EntityModel<T>> {
    private static final ResourceLocation HAT_LOCATION = new ResourceLocation(Spore.MODID,"textures/entity/proto_christmas_hat.png");
    private final ProtoChritsmasHat<T> model;

    public ProtoHatLayer(RenderLayerParent<T, EntityModel<T>> p_117346_, EntityModelSet set) {
        super(p_117346_);
        this.model = new ProtoChritsmasHat<>(set.bakeLayer(ProtoChritsmasHat.LAYER_LOCATION));
    }


    @Override
    public void render(PoseStack stack, MultiBufferSource bufferSource, int p_117351_, T type, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        if (SConfig.SERVER.costumes.get()){
            LocalDate localdate = LocalDate.now();
            int j = localdate.get(ChronoField.MONTH_OF_YEAR);
            if (j == 12 || SConfig.SERVER.costumes_active.get()){
                coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, HAT_LOCATION, stack, bufferSource, p_117351_, type, p_117353_, p_117354_, p_117355_, p_117356_, p_117357_, p_117358_, 1, 1, 1);
            }
        }
    }
}
