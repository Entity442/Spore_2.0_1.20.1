package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.BileRound;
import com.Harbinger.Spore.Sentities.Projectile.FleshBomb;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FleshBombRenderer<T extends FleshBomb>extends EntityRenderer<T> {
    public static final ResourceLocation BASIC_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/basicround.png");
    public static final ResourceLocation FLAMMABLE_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/fireround.png");
    public static final ResourceLocation BILE_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/bileround.png");
    public static final ResourceLocation ACID_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/acidround.png");
    public static final ResourceLocation NUCLEAR_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/nuclear_round.png");
    private final BileRound<T> model;

    public FleshBombRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new BileRound<>();
    }

    public void render(T entity, float value2, float value, PoseStack stack, MultiBufferSource source, int p_116116_) {
        stack.pushPose();
        stack.mulPose(Axis.ZN.rotationDegrees(180));
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(value, entity.yRotO, entity.getYRot()) - 90.0F));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(value, entity.xRotO, entity.getXRot()) + 90.0F));
        int scaling = entity.getCarrier() ? 2 : 1;
        stack.scale(scaling,scaling,scaling);
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(source, this.model.renderType(this.getTextureLocation(entity)), false, false);
        this.model.setupAnim(entity,0,0,entity.tickCount,0,0);
        this.model.renderToBuffer(stack, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        stack.popPose();
        super.render(entity, value2, value, stack, source, p_116116_);
    }

    public ResourceLocation getTextureLocation(FleshBomb bileProjectile) {
        if (bileProjectile.getBombType() == 1){
            return FLAMMABLE_ROUND;
        }else if (bileProjectile.getBombType() == 2){
            return BILE_ROUND;
        }else if (bileProjectile.getBombType() == 3){
            return ACID_ROUND;
        }else if (bileProjectile.getBombType() == 4){
            return NUCLEAR_ROUND;
        }else{
            return BASIC_ROUND;
        }
    }
}