package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.Models.HindenXmaslightsModel;
import com.Harbinger.Spore.Client.Models.HindieModel;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.Calamities.Hinderburg;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
@OnlyIn(Dist.CLIENT)
public class HindenburgLightsLayer<T extends Hinderburg> extends RenderLayer<T, HindieModel<T>> {
    private int currentTexture;
    private static final ResourceLocation MAIN_TEXTURE = new ResourceLocation(Spore.MODID,"textures/entity/hindie_light/hindie_lights.png");
    private final HindenXmaslightsModel<T> model;
    public static final Map<activeLights, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(activeLights.class), (p_114874_) -> {
                p_114874_.put(activeLights.RED,
                        new ResourceLocation(Spore.MODID, "textures/entity/hindie_light/hindie_red.png"));
                p_114874_.put(activeLights.BLUE,
                        new ResourceLocation(Spore.MODID, "textures/entity/hindie_light/hindie_blue.png"));
                p_114874_.put(activeLights.GREEN,
                        new ResourceLocation(Spore.MODID, "textures/entity/hindie_light/hindie_green.png"));
                p_114874_.put(activeLights.YELLOW,
                        new ResourceLocation(Spore.MODID, "textures/entity/hindie_light/hindie_yellow.png"));
            });
    public HindenburgLightsLayer(RenderLayerParent<T, HindieModel<T>> p_117346_) {
        super(p_117346_);
        this.model = new HindenXmaslightsModel<>();
    }
    @Override
    public void render(PoseStack stack, MultiBufferSource bufferSource, int p_117351_, T type, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        if (SConfig.SERVER.costumes.get()){
            LocalDate localdate = LocalDate.now();
            int j = localdate.get(ChronoField.MONTH_OF_YEAR);
            if (j == 12){
                stack.pushPose();
                stack.translate(0,3.5,0);
                coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, MAIN_TEXTURE, stack, bufferSource, p_117351_, type, p_117353_, p_117354_, p_117355_, p_117356_, p_117357_, p_117358_, 1, 1, 1);
                renderActiveLight(bufferSource,stack);
                if (type.tickCount % 40 == 0){currentTexture = currentTexture == activeLights.values().length ? 0 : currentTexture+1;}
                stack.popPose();
            }
        }
    }
    public void renderActiveLight(MultiBufferSource bufferSource, PoseStack stack){
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.eyes(TEXTURE.get(activeLights.byId(currentTexture & 255))));
        model.renderToBuffer(stack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    enum activeLights{
        RED(0),
        BLUE(1),
        GREEN(2),
        YELLOW(3);
        private final int type;
        activeLights(int type){
            this.type = type;
        }
        public int getType(){
            return type;
        }
        private static final activeLights[] BY_ID = Arrays.stream(values()).sorted(Comparator.
                comparingInt(activeLights::getType)).toArray(activeLights[]::new);

        public static activeLights byId(int id) {
            return BY_ID[id % BY_ID.length];
        }
    }
}
