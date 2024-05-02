package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Sentities.Utility.Illusion;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class IllusionRenderer extends EntityRenderer<Illusion> {
    private final EntityRenderDispatcher entityRenderer;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID, "");

    public IllusionRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.entityRenderer = context.getEntityRenderDispatcher();
    }



    @Override
    public ResourceLocation getTextureLocation(Illusion illusion) {
        return TEXTURE;
    }

    protected float getBob(Illusion illusion, float p_115306_) {
        return (float)illusion.tickCount + p_115306_;
    }

    @Override
    public void render(Illusion illusion, float value1, float value2, PoseStack stack, MultiBufferSource source, int light) {
        if (illusion.getSeeAble()){
            renderIllusions(illusion,value2,stack,source,light);
        }else{
            if (Minecraft.getInstance().cameraEntity instanceof Player player && (player.hasEffect(Seffects.MADNESS.get()) && Objects.equals(illusion.getVictim(), player.getUUID()))){
                renderIllusions(illusion,value2,stack,source,light);
            }
        }
        super.render(illusion, value1, value2, stack, source, light);
    }

    public void renderIllusions(Illusion illusion,float value2,PoseStack stack,MultiBufferSource source,int light){
        ResourceLocation location = new ResourceLocation(illusion.getBody());
        EntityType<?> entityType = ForgeRegistries.ENTITY_TYPES.getValue(location);
        LivingEntity entity = (LivingEntity) entityType.create(illusion.level());
        float f = Mth.rotLerp(value2, illusion.yBodyRotO, illusion.yBodyRot);
        float f1 = Mth.rotLerp(value2, illusion.yHeadRotO, illusion.yHeadRot);
        float f2 = f1 - f;
        float f6 = Mth.lerp(value2, illusion.xRotO, illusion.getXRot());
        float f7 = this.getBob(illusion, value2);
        float f8 = 0.0F;
        float f5 = 0.0F;
        if (illusion.isAlive()) {
            f8 = illusion.walkAnimation.speed(value2);
            f5 = illusion.walkAnimation.position(value2);
            if (illusion.isBaby()) {
                f5 *= 3.0F;
            }

            if (f8 > 1.0F) {
                f8 = 1.0F;
            }
        }
        if (entity != null){
            stack.pushPose();
            stack.mulPose(Axis.YP.rotationDegrees(-illusion.yBodyRot));
            stack.mulPose(Axis.XP.rotationDegrees(180));
            stack.translate(0,-1.5,0);
            if (entityRenderer.getRenderer(entity) instanceof MobRenderer mobRenderer){
                EntityModel model = mobRenderer.getModel();
                ResourceLocation texture = mobRenderer.getTextureLocation(entity);
                VertexConsumer consumer = source.getBuffer(RenderType.entityTranslucent(texture));
                model.prepareMobModel(entity, f5, f8, value2);
                model.setupAnim(entity, f5, f8, f7, f2, f6);
                model.renderToBuffer(stack,consumer,light, OverlayTexture.NO_OVERLAY,1,1,1,1);
            }
            stack.popPose();
        }
    }
}
