package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.BileRound;
import com.Harbinger.Spore.Client.Models.JollyPresentBombs;
import com.Harbinger.Spore.Sentities.Projectile.FleshBomb;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.time.LocalDate;

@OnlyIn(Dist.CLIENT)
public class FleshBombRenderer<T extends FleshBomb>extends EntityRenderer<T> {
    public static final ResourceLocation BASIC_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/basicround.png");
    public static final ResourceLocation FLAMMABLE_ROUND =new  ResourceLocation(Spore.MODID,"textures/entity/fireround.png");
    public static final ResourceLocation BILE_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/bileround.png");
    public static final ResourceLocation ACID_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/acidround.png");
    public static final ResourceLocation NUCLEAR_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/nuclear_round.png");
    public static final ResourceLocation BASIC_JOLLY_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/jolly_howitzer_round.png");
    public static final ResourceLocation FLAMMABLE_JOLLY_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/jolly_fire_howitzer_round.png");
    public static final ResourceLocation BILE_JOLLY_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/jolly_bile_howitzer_round.png");
    public static final ResourceLocation ACID_JOLLY_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/jolly_acid_howitzer_round.png");
    public static final ResourceLocation NUCLEAR_JOLLY_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/jolly_nuke_howitzer_round.png");
    protected final LocalDate localdate = LocalDate.now();
    protected final int j = localdate.getMonth().getValue();
    private final BileRound<T> model;
    private final JollyPresentBombs<T> presentBombs;

    public FleshBombRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new BileRound<>();
        this.presentBombs = new JollyPresentBombs<>();
    }

    public void render(T entity, float value2, float value, PoseStack stack, MultiBufferSource source, int p_116116_) {
        EntityModel<T> entityModel = isJollyTime() ? presentBombs : model;
        stack.pushPose();
        stack.mulPose(Axis.ZN.rotationDegrees(180));
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(value, entity.yRotO, entity.getYRot()) - 90.0F));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(value, entity.xRotO, entity.getXRot()) + 90.0F));
        int scaling = entity.getCarrier() ? 2 : 1;
        stack.scale(scaling,scaling,scaling);
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(source, this.model.renderType(this.getTextureLocation(entity)), false, false);
        entityModel.setupAnim(entity,0,0,entity.tickCount,0,0);
        entityModel.renderToBuffer(stack, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY, 1,1,1,1);
        stack.popPose();
        super.render(entity, value2, value, stack, source, p_116116_);
    }

    boolean isJollyTime(){
        return j == 12;
    }
    public ResourceLocation getTextureLocation(FleshBomb bileProjectile) {
        if (bileProjectile.getBombType() == 1){
            return isJollyTime() ? FLAMMABLE_JOLLY_ROUND : FLAMMABLE_ROUND;
        }else if (bileProjectile.getBombType() == 2){
            return isJollyTime() ? BILE_JOLLY_ROUND : BILE_ROUND;
        }else if (bileProjectile.getBombType() == 3){
            return isJollyTime() ? ACID_JOLLY_ROUND : ACID_ROUND;
        }else if (bileProjectile.getBombType() == 4){
            return isJollyTime() ? NUCLEAR_JOLLY_ROUND : NUCLEAR_ROUND;
        }else{
            return isJollyTime() ? BASIC_JOLLY_ROUND : BASIC_ROUND;
        }
    }
}