package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.Projectile.VomitHohlBall;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VomitRenderer<T extends VomitHohlBall>extends EntityRenderer<T> {
    private final ItemRenderer itemRenderer;
    private final ItemStack bone = new ItemStack(Items.BONE);
    private final ItemStack flesh = new ItemStack(Items.ROTTEN_FLESH);
    public static final ResourceLocation LOCATION = new ResourceLocation(Spore.MODID,"");
    public VomitRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public ResourceLocation getTextureLocation(T t) {
        return LOCATION;
    }
    protected int getBlockLightLevel(T type, BlockPos blockPos) {
        return super.getBlockLightLevel(type, blockPos);
    }

    @Override
    public void render(T type, float val1, float val2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        if (type.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(type) < 12.25)) {
            stack.pushPose();
            stack.scale(1.5f, 1.5f, 1.5f);
            stack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            stack.mulPose(Axis.YP.rotationDegrees(180.0F));

            // Seeded pseudo-random rotation
            int seed = type.getId() + type.tickCount;
            float yaw = (seed * 23) % 360;     // Horizontal spin
            float pitch = (seed * 17) % 360;   // Vertical tilt
            float roll = (seed * 11) % 360;    // Twist

            stack.mulPose(Axis.YP.rotationDegrees(yaw));
            stack.mulPose(Axis.XP.rotationDegrees(pitch));
            stack.mulPose(Axis.ZP.rotationDegrees(roll));

            // Render bone
            this.itemRenderer.renderStatic(
                    bone, ItemDisplayContext.GROUND, light,
                    OverlayTexture.NO_OVERLAY, stack, bufferSource, type.level(), seed
            );

            // Offset a bit for flesh so it doesn't overlap exactly
            stack.translate(0.2F, 0.0F, 0.2F);

            // Different rotation for flesh
            float fleshYaw = (seed * 31) % 360;
            float fleshPitch = (seed * 29) % 360;
            float fleshRoll = (seed * 19) % 360;

            stack.mulPose(Axis.YP.rotationDegrees(fleshYaw));
            stack.mulPose(Axis.XP.rotationDegrees(fleshPitch));
            stack.mulPose(Axis.ZP.rotationDegrees(fleshRoll));

            this.itemRenderer.renderStatic(
                    flesh, ItemDisplayContext.GROUND, light,
                    OverlayTexture.NO_OVERLAY, stack, bufferSource, type.level(), seed + 1
            );

            stack.popPose();
            super.render(type, val1, val2, stack, bufferSource, light);
        }
    }

}
