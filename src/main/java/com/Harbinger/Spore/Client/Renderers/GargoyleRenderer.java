package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.*;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Client.Special.GargoyleBits;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Gargoyl;
import com.Harbinger.Spore.Sentities.Variants.GargoyleVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
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
import java.util.List;
import java.util.Locale;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class GargoyleRenderer<Type extends Gargoyl> extends BaseInfectedRenderer<Type , EntityModel<Type>> {
    public static final Map<GargoyleVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(GargoyleVariants.class), (p_114874_) -> {
                p_114874_.put(GargoyleVariants.DEFAULT,
                       new ResourceLocation(Spore.MODID, "textures/entity/gargoyle.png"));
                p_114874_.put(GargoyleVariants.ICHOR,
                       new ResourceLocation(Spore.MODID, "textures/entity/bile_gargoyle.png"));
                p_114874_.put(GargoyleVariants.BLOOMING,
                       new ResourceLocation(Spore.MODID, "textures/entity/blooming_gargoyle.png"));
                p_114874_.put(GargoyleVariants.BOMBER,
                       new ResourceLocation(Spore.MODID, "textures/entity/bomber_gargoyle.png"));
                p_114874_.put(GargoyleVariants.VALKYRIE,
                       new ResourceLocation(Spore.MODID, "textures/entity/valk_gargoyle.png"));
            });
    private static final ResourceLocation EYES_TEXTURE =new  ResourceLocation(Spore.MODID,
            "textures/entity/eyes/gargoyle.png");
    private final EntityModel<Type> defaultModel = this.getModel();
    private final EntityModel<Type> ichor;
    private final EntityModel<Type> blooming;
    private final EntityModel<Type> bomber;
    private final EntityModel<Type> valk;
    public GargoyleRenderer(EntityRendererProvider.Context context) {
        super(context, new gargoyleModel<>(context.bakeLayer(gargoyleModel.LAYER_LOCATION),false), 0.5f);
        ichor = new IchorGargoyleModel<>(context.bakeLayer(IchorGargoyleModel.LAYER_LOCATION),false);
        blooming = new bloomingGargoyleModel<>(context.bakeLayer(bloomingGargoyleModel.LAYER_LOCATION),false);
        bomber = new bomberGargoyleModel<>(context.bakeLayer(bomberGargoyleModel.LAYER_LOCATION),false);
        valk = new valkyrieGargoyleModel<>(context.bakeLayer(valkyrieGargoyleModel.LAYER_LOCATION),false);
        this.addLayer(new ProtectorArmorRenderer<>(this,context.getModelManager()));
    }
    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE.get(entity.getVariant());
    }
    @Override
    protected @org.jetbrains.annotations.Nullable RenderType getRenderType(Type livingEntity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return super.getRenderType(livingEntity, bodyVisible, livingEntity.getVariant() == GargoyleVariants.ICHOR, glowing);
    }
    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }
    @Override
    protected void scale(Type livingEntity, PoseStack poseStack, float partialTickTime) {
        float val = livingEntity.getVariant() == GargoyleVariants.VALKYRIE ? 1.2f : 1;
        poseStack.scale(val,val,val);
        super.scale(livingEntity, poseStack, partialTickTime);
    }
    public EntityModel<Type> getVariantModel(GargoyleVariants gargoyleVariants){
        switch (gargoyleVariants){
            case ICHOR -> {
                return ichor;
            }
            case BLOOMING -> {
                return blooming;
            }
            case BOMBER -> {
                return bomber;
            }
            case VALKYRIE -> {
                return valk;
            }
            case DEFAULT -> {
                return defaultModel;
            }
        }
        return defaultModel;
    }
    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        this.model = getVariantModel(type.getVariant());
        super.render(type, value1, value2, stack, bufferSource, light);
    }
    private static class ProtectorArmorRenderer <T extends Gargoyl> extends RenderLayer<T, EntityModel<T>> {
        private final TextureAtlas armorTrimAtlas;
        private static final Map<String, ResourceLocation> ARMOR_LOCATION_CACHE = Maps.newHashMap();
        private static final ResourceLocation BLOOD_LAYER1 =new ResourceLocation(Spore.MODID,
                "textures/overlay/blood_overlay.png");
        public ProtectorArmorRenderer(RenderLayerParent<T, EntityModel<T>> modelRenderLayerParent, ModelManager manager) {
            super(modelRenderLayerParent);
            armorTrimAtlas = manager.getAtlas(Sheets.ARMOR_TRIMS_SHEET);
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
            if (getParentModel() instanceof GargoyleBits gargoyleBits){
                renderArmorPart(t,gargoyleBits,EquipmentSlot.HEAD, gargoyleBits.Helmet(),poseStack,multiBufferSource, i);
            }
        }
        private void renderArmorPart(T entity, GargoyleBits bits, EquipmentSlot slot , List<ModelPart> arm, PoseStack stack, MultiBufferSource bufferSource, int packedLight){
            ItemStack itemStack = entity.getItemBySlot(slot);
            boolean flag = itemStack.hasFoil();
            if (itemStack.getItem() instanceof ArmorItem armorItem){
                if (armorItem instanceof DyeableLeatherItem) {
                    int i = ((DyeableLeatherItem)armorItem).getColor(itemStack);
                    float f = (float)(i >> 16 & 255) / 255.0F;
                    float f1 = (float)(i >> 8 & 255) / 255.0F;
                    float f2 = (float)(i & 255) / 255.0F;
                    renderArmor(arm,bits,stack,bufferSource,packedLight,OverlayTexture.NO_OVERLAY,f,f1,f2,1,this.getArmorResource(entity, itemStack, slot, (String)null),flag);
                } else {
                    renderArmor(arm,bits,stack,bufferSource,packedLight,OverlayTexture.NO_OVERLAY,1,1,1,1,this.getArmorResource(entity, itemStack, slot, (String)null),flag);
                }
                ArmorTrim.getTrim(entity.level().registryAccess(), itemStack).ifPresent((p_289638_) -> {
                    this.renderTrim(armorItem.getMaterial(),bits, stack, bufferSource, packedLight, p_289638_, arm, flag);
                });
            }
        }
        private void renderArmor(List<ModelPart> parts,GargoyleBits bits, PoseStack stack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, float r, float g, float b, float alpha,ResourceLocation location,boolean glint){
            VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(location));
            ModelPart root = bits.root();
            root.getAllParts().forEach(modelPart -> {setInvisible(modelPart,parts);});
            root.render(stack, consumer, packedLight, packedOverlay,  r,g,b,alpha);
            if (glint){
                root.render(stack, bufferSource.getBuffer(RenderType.entityGlint()), packedLight, packedOverlay,r,g,b,  alpha);
            }
            renderBloodLayer(root,stack,bufferSource,packedLight);
        }

        private void setInvisible(ModelPart part,List<ModelPart> parts){
            part.skipDraw = !parts.contains(part);
        }


        private void renderTrim(ArmorMaterial material,GargoyleBits bits, PoseStack stack, MultiBufferSource source, int light, ArmorTrim armorTrim, List<ModelPart> parts, boolean flag) {
            TextureAtlasSprite textureatlassprite = this.armorTrimAtlas.getSprite(flag ? armorTrim.innerTexture(material) : armorTrim.outerTexture(material));
            VertexConsumer vertexconsumer = textureatlassprite.wrap(source.getBuffer(Sheets.armorTrimsSheet()));
            ModelPart root = bits.root();
            root.getAllParts().forEach(modelPart -> {setInvisible(modelPart,parts);});
            root.render(stack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1,1,1,1);
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