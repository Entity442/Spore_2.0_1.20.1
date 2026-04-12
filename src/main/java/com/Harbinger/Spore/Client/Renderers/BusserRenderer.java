package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.BusserModel;
import com.Harbinger.Spore.Client.Models.ExplodingBusserModel;
import com.Harbinger.Spore.Client.Models.RangedBusserModel;
import com.Harbinger.Spore.Client.Models.TransporterPhayresModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Busser;
import com.Harbinger.Spore.Sentities.Variants.BusserVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class BusserRenderer extends BaseInfectedRenderer<Busser , EntityModel<Busser>> {
    private final EntityModel<Busser> normalBusser = this.getModel();
    private final EntityModel<Busser> explodingBusser;
    private final EntityModel<Busser> toxic_busser;
    private final EntityModel<Busser> carrier_busser;
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/busser.png");
    public static final Map<BusserVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(BusserVariants.class), (p_114874_) -> {
                p_114874_.put(BusserVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/busser.png"));
                p_114874_.put(BusserVariants.ENHANCED,
                        new ResourceLocation(Spore.MODID, "textures/entity/busser_aggressive.png"));
                p_114874_.put(BusserVariants.BOMBER,
                        new ResourceLocation(Spore.MODID, "textures/entity/busserbomber.png"));
                p_114874_.put(BusserVariants.TOXIC,
                        new ResourceLocation(Spore.MODID, "textures/entity/toxic_busser.png"));
                p_114874_.put(BusserVariants.TRANSPORTER,
                        new ResourceLocation(Spore.MODID, "textures/entity/transported_bussy.png"));
            });

    public BusserRenderer(EntityRendererProvider.Context context) {
        super(context, new BusserModel<>(context.bakeLayer(BusserModel.LAYER_LOCATION)), 0.5f);
        explodingBusser = new ExplodingBusserModel<>(context.bakeLayer(ExplodingBusserModel.LAYER_LOCATION));
        toxic_busser = new RangedBusserModel<>(context.bakeLayer(RangedBusserModel.LAYER_LOCATION));
        carrier_busser = new TransporterPhayresModel<>(context.bakeLayer(TransporterPhayresModel.LAYER_LOCATION));
        this.addLayer(new BusserBlockRenderer<>(this));
    }
    @Override
    public ResourceLocation getTextureLocation(Busser entity) {
        return TEXTURE.get(entity.getVariant());
    }
    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }
    @Override
    protected void scale(Busser type, PoseStack stack, float value) {
        if (type.getVariant() == BusserVariants.ENHANCED){
            float size = 1.4f;
            stack.scale(size,size,size);
        }
        super.scale(type, stack, value);
    }

    @Override
    public void render(Busser busser, float p_115456_, float p_115457_, PoseStack stack, MultiBufferSource bufferSource, int p_115460_) {
        EntityModel<Busser> entityModel = this.normalBusser;
        if (busser.getVariant() == BusserVariants.BOMBER){
            entityModel = explodingBusser;
        }if (busser.getVariant() == BusserVariants.TOXIC){
            entityModel = toxic_busser;
        }
        if (busser.getVariant() == BusserVariants.TRANSPORTER){
            entityModel = carrier_busser;
        }
        this.model = entityModel;
        super.render(busser, p_115456_, p_115457_, stack, bufferSource, p_115460_);
    }


    public static class BusserBlockRenderer<T extends Busser,M extends EntityModel<T>> extends RenderLayer<T, M>{
        private final ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        public BusserBlockRenderer(RenderLayerParent<T, M> layerParent) {
            super(layerParent);
        }
        private int getLight(Level level, BlockPos pos){
            int a = level.getBrightness(LightLayer.BLOCK,pos);
            int b = level.getBrightness(LightLayer.SKY,pos);
            return LightTexture.pack(a,b);
        }
        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int value, T t, float v, float v1, float v2, float v3, float v4, float v5) {
            BlockState state = t.getCarriedBlock();
            if (t.isInvisible() || !(getParentModel() instanceof TransporterPhayresModel<?> transporterPhayresModel) || state == null){
                return;
            }
            ItemStack itemStack = new ItemStack(state.getBlock().asItem());
            poseStack.pushPose();
            for(ModelPart part : transporterPhayresModel.tail){
                part.translateAndRotate(poseStack);
            }

            if (!itemStack.equals(ItemStack.EMPTY)) {
                renderItem(poseStack,itemStack,multiBufferSource,value,t.level(),t.blockPosition());
            }
            poseStack.popPose();
        }

        public void renderItem(PoseStack stack, ItemStack itemStack, MultiBufferSource source, float value, Level level, BlockPos pos){
            stack.pushPose();
            stack.scale(1.25f,1.25f,1.25f);
            stack.translate(0,0.5,0);
            stack.mulPose(Axis.YP.rotationDegrees(value));
            itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED,getLight(level,pos), OverlayTexture.NO_OVERLAY,stack,source,level,1);
            stack.popPose();
        }
    }
}
