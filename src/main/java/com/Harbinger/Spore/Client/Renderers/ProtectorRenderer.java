package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.ProtectorModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Protector;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ProtectorRenderer<Type extends Protector> extends BaseInfectedRenderer<Type , ProtectorModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/protector.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/protector.png");
    public ProtectorRenderer(EntityRendererProvider.Context context) {
        super(context, new ProtectorModel<>(context.bakeLayer(ProtectorModel.LAYER_LOCATION),false), 0.5f);
        this.addLayer(new ProtectorArmorRenderer<>(this,context.getModelManager()));
        this.addLayer(new PearlsLayer<>(this,context.getItemInHandRenderer()));
    }
    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    private static class PearlsLayer <T extends Protector, M extends ProtectorModel<T>> extends RenderLayer<T, M>{
        private final ItemInHandRenderer itemInHandRenderer;
        private final ProtectorModel<T> model;
        public PearlsLayer(RenderLayerParent<T, M> parent, ItemInHandRenderer itemInHandRenderer) {
            super(parent);
            this.itemInHandRenderer = itemInHandRenderer;
            this.model = this.getParentModel();
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
            if (t.getPearls() > 0){
                ItemStack stack = new ItemStack(Items.ENDER_PEARL);
                poseStack.pushPose();
                this.model.LeftArm.translateAndRotate(poseStack);
                poseStack.translate(0,0.75,0);
                poseStack.scale(0.5F, 0.5F, 0.5F);
                poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
                poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
                itemInHandRenderer.renderItem(t,stack, ItemDisplayContext.FIXED,true,poseStack,multiBufferSource,i);
                poseStack.popPose();
            }
        }
    }
    private static class ProtectorArmorRenderer <T extends Protector> extends RenderLayer<T, ProtectorModel<T>> {
        public final List<ModelPart> helmetModels = new ArrayList<>();
        public final List<ModelPart> bootsModels = new ArrayList<>();
        private static final Map<String, ResourceLocation> ARMOR_LOCATION_CACHE = Maps.newHashMap();
        private final TextureAtlas armorTrimAtlas;
        private static final ResourceLocation BLOOD_LAYER1 = new ResourceLocation(Spore.MODID,
                "textures/overlay/blood_overlay.png");
        public ProtectorArmorRenderer(RenderLayerParent<T, ProtectorModel<T>> modelRenderLayerParent, ModelManager manager) {
            super(modelRenderLayerParent);
            armorTrimAtlas = manager.getAtlas(Sheets.ARMOR_TRIMS_SHEET);
            this.helmetModels.add(this.getParentModel().headWear);
            this.bootsModels.add(this.getParentModel().RightBoot);
            this.bootsModels.add(this.getParentModel().LeftBoot);
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
            renderArmorPart(t,EquipmentSlot.HEAD, helmetModels,poseStack,multiBufferSource, i,OverlayTexture.NO_OVERLAY,1,1,1,1);
            renderArmorPart(t,EquipmentSlot.FEET, bootsModels,poseStack,multiBufferSource, i,OverlayTexture.NO_OVERLAY,1,1,1,1);
        }
        private void renderArmorPart(T entity, EquipmentSlot slot , List<ModelPart> parts, PoseStack stack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
            ItemStack itemStack = entity.getItemBySlot(slot);
            boolean flag = itemStack.hasFoil();
            if (itemStack.getItem() instanceof ArmorItem armorItem){
                if (armorItem instanceof DyeableLeatherItem) {
                    int i = ((DyeableLeatherItem)armorItem).getColor(itemStack);
                    float f = (float)(i >> 16 & 255) / 255.0F;
                    float f1 = (float)(i >> 8 & 255) / 255.0F;
                    float f2 = (float)(i & 255) / 255.0F;
                    renderArmor(parts,stack,bufferSource,packedLight,OverlayTexture.NO_OVERLAY,f,f1,f2,1,this.getArmorResource(entity, itemStack, slot, (String)null),flag,slot);
                } else {
                    renderArmor(parts,stack,bufferSource,packedLight,OverlayTexture.NO_OVERLAY,1,1,1,1,this.getArmorResource(entity, itemStack, slot, (String)null),flag,slot);
                }
                ArmorTrim.getTrim(entity.level().registryAccess(), itemStack).ifPresent((p_289638_) -> {
                    this.renderTrim(armorItem.getMaterial(), stack, bufferSource, packedLight, p_289638_, parts, flag);
                });
            }
        }
        private void renderArmor(List<ModelPart> parts, PoseStack stack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, float red, float green, float blue, float alpha,ResourceLocation location,boolean glint,EquipmentSlot slot){
            VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(location));
            this.getParentModel().Protector.getAllParts().forEach(modelPart -> {setInvisible(modelPart,parts);});
            this.getParentModel().Protector.render(stack, consumer, packedLight, packedOverlay, red, green, blue, alpha);
            if (glint){
                this.getParentModel().Protector.render(stack, bufferSource.getBuffer(RenderType.entityGlint()), packedLight, packedOverlay, red, green, blue, alpha);
            }
            renderBloodLayer(this.getParentModel().Protector,stack,bufferSource,packedLight);
        }

        private void setInvisible(ModelPart part,List<ModelPart> parts){
            part.skipDraw = !parts.contains(part);
        }


        private void renderTrim(ArmorMaterial material, PoseStack stack, MultiBufferSource source, int light, ArmorTrim armorTrim, List<ModelPart> parts, boolean flag) {
            TextureAtlasSprite textureatlassprite = this.armorTrimAtlas.getSprite(flag ? armorTrim.innerTexture(material) : armorTrim.outerTexture(material));
            VertexConsumer vertexconsumer = textureatlassprite.wrap(source.getBuffer(Sheets.armorTrimsSheet()));
            this.getParentModel().Protector.getAllParts().forEach(modelPart -> {setInvisible(modelPart,parts);});
            this.getParentModel().Protector.render(stack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        }
        public ResourceLocation getArmorResource(Entity entity, ItemStack stack, EquipmentSlot slot, @Nullable String type) {
            ArmorItem item = (ArmorItem)stack.getItem();
            String texture = item.getMaterial().getName();
            String domain = "minecraft";
            int idx = texture.indexOf(58);
            if (idx != -1) {
                domain = texture.substring(0, idx);
                texture = texture.substring(idx + 1);
            }

            String s1 = String.format(Locale.ROOT, "%s:textures/models/armor/%s_layer_%d%s.png", domain, texture,slot == EquipmentSlot.LEGS ? 2 :  1, type == null ? "" : String.format(Locale.ROOT, "_%s", type));
            s1 = ForgeHooksClient.getArmorTexture(entity, stack, s1, slot, type);
            ResourceLocation resourcelocation = ARMOR_LOCATION_CACHE.get(s1);
            if (resourcelocation == null) {
                resourcelocation = new ResourceLocation(s1);
                ARMOR_LOCATION_CACHE.put(s1, resourcelocation);
            }
            return resourcelocation;
        }
        private void renderBloodLayer(ModelPart part, PoseStack stack, MultiBufferSource bufferSource, int packedLight){
            VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityTranslucent(BLOOD_LAYER1));
            part.render(stack,consumer,packedLight,OverlayTexture.NO_OVERLAY);
        }
    }

}