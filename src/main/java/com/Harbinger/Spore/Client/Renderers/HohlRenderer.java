package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.CubeModel;
import com.Harbinger.Spore.Client.Special.CalamityRenderer;
import com.Harbinger.Spore.Sentities.BaseEntities.HohlMultipart;
import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HohlRenderer<Type extends Hohlfresser> extends CalamityRenderer<Type , CubeModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/blank.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/sieger.png");


    public HohlRenderer(EntityRendererProvider.Context context) {
        super(context, new CubeModel<>(context.bakeLayer(CubeModel.LAYER_LOCATION)), 4f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        super.render(type, value1, value2, stack, bufferSource, light);
        float i = type.getYHeadRot();
        for (HohlMultipart entity : type.getSubEntities()){
            i = i * 0.8f;
            renderSegment(type,entity,stack,bufferSource,light,i);
        }
    }

    @Override
    protected void scale(Type p_115314_, PoseStack stack, float p_115316_) {
        stack.scale(2,2,2);
        super.scale(p_115314_, stack, p_115316_);
    }

    private void renderSegment(Type parent ,HohlMultipart entity, PoseStack stack, MultiBufferSource bufferSource, int packedLight,float y) {
        VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityCutout(TEXTURE));
        Vec3 vec3 = parent.position().subtract(entity.position()).scale(-1).scale(0.6);
        stack.pushPose();
        stack.scale(entity.getInflation(),entity.getInflation(),entity.getInflation());
        stack.translate(vec3.x,vec3.y,vec3.z);
        stack.mulPose(Axis.YP.rotationDegrees(180.0F - y));
        stack.mulPose(Axis.ZP.rotationDegrees(180.0F));
        stack.translate(0,-1.5,0);
        this.getModel().renderToBuffer(stack,consumer,packedLight, OverlayTexture.NO_OVERLAY,1,1,1,1);
        stack.popPose();
    }
}
