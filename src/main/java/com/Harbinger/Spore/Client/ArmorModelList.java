package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Client.Models.*;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;
@OnlyIn(Dist.CLIENT)
public class ArmorModelList {
    private static final ResourceLocation psi_glow = new ResourceLocation("spore:textures/item/pci_gl.png");
    private static final TestBootModel<LivingEntity> boots = new TestBootModel<>();
    private static final GasMaskModel<LivingEntity> gasMaskModel = new GasMaskModel<>();
    private static final ElytrumModel<LivingEntity> elytrumModel = new ElytrumModel<>();
    private static final PCI_Model<LivingEntity> pci = new PCI_Model<>();
    private static final PCI_ModelL<LivingEntity> pciL = new PCI_ModelL<>();
    public record Quad(EquipmentSlot slot, Item item,ModelPart origin, EntityModel<? extends LivingEntity> model, ModelPart part,float x,float y,float z,float expand){}
    public abstract static class Quader{
        public final EquipmentSlot slot;
        public final Item item;
        public final ModelPart origin;
        public final EntityModel<? extends LivingEntity> model;
        public final ModelPart part;
        public final float x;
        public final float y;
        public final float z;
        public final float expand;
        public final float Xspin;
        public final float Yspin;
        public final float Zspin;
        public final LivingEntity livingEntity;
        protected Quader(EquipmentSlot slot, Item item, ModelPart origin, EntityModel<? extends LivingEntity> model, ModelPart part, float x, float y, float z, float expand, float xspin, float yspin, float zspin, LivingEntity livingEntity) {
            this.slot = slot;
            this.item = item;
            this.origin = origin;
            this.model = model;
            this.part = part;
            this.x = x;
            this.y = y;
            this.z = z;
            this.expand = expand;
            Xspin = xspin;
            Yspin = yspin;
            Zspin = zspin;
            this.livingEntity = livingEntity;
        }

        public ItemStack stack() {
            return livingEntity.getItemBySlot(slot);
        }
        public abstract RenderType type(ResourceLocation location);
    }
    public abstract static class HandDisplay{
        public final InteractionHand slot;
        public final Item item;
        public final EntityModel<? extends LivingEntity> model;
        public final ModelPart part;
        public final float x;
        public final float y;
        public final float z;
        public final float expand;
        public final float Xspin;
        public final float Yspin;
        public final float Zspin;
        protected HandDisplay(InteractionHand slot, Item item, EntityModel<? extends LivingEntity> model, ModelPart part, float x, float y, float z, float expand, float xspin, float yspin, float zspin) {
            this.slot = slot;
            this.item = item;
            this.model = model;
            this.part = part;
            this.x = x;
            this.y = y;
            this.z = z;
            this.expand = expand;
            Xspin = xspin;
            Yspin = yspin;
            Zspin = zspin;
        }
        public abstract RenderType type(ResourceLocation location);
    }
    public static List<Quad> modelItemMap(HumanoidModel<LivingEntity> humanoidModel){
        List<Quad> map = new ArrayList<>();
        map.add(new Quad(EquipmentSlot.FEET, Sitems.LIVING_BOOTS.get().asItem(),humanoidModel.leftLeg,boots,boots.leftBoot,-0.15f,-0.8f,0,1.1f));
        map.add(new Quad(EquipmentSlot.FEET, Sitems.LIVING_BOOTS.get().asItem(),humanoidModel.rightLeg,boots,boots.rightBoot,0.15f,-0.8f,0,1.1f));
        map.add(new Quad(EquipmentSlot.LEGS, Sitems.LIVING_PANTS.get().asItem(),humanoidModel.leftLeg,boots,boots.leftLeg,-0.15f,-0.8f,0,1.1f));
        map.add(new Quad(EquipmentSlot.LEGS, Sitems.LIVING_PANTS.get().asItem(),humanoidModel.rightLeg,boots,boots.rightLeg,0.15f,-0.8f,0,1.1f));
        map.add(new Quad(EquipmentSlot.LEGS, Sitems.LIVING_PANTS.get().asItem(),humanoidModel.body,boots,boots.pelvis,0,0,0,1));
        map.add(new Quad(EquipmentSlot.CHEST, Sitems.LIVING_CHEST.get().asItem(),humanoidModel.body,boots,boots.body,0,0,0,1.1f));
        map.add(new Quad(EquipmentSlot.CHEST, Sitems.LIVING_CHEST.get().asItem(),humanoidModel.rightArm,boots,boots.rightArm,0.35f,-0.125f,0,1.1f));
        map.add(new Quad(EquipmentSlot.CHEST, Sitems.LIVING_CHEST.get().asItem(),humanoidModel.leftArm,boots,boots.leftArm,-0.35f,-0.125f,0,1.1f));
        map.add(new Quad(EquipmentSlot.HEAD, Sitems.LIVING_HELMET.get().asItem(),humanoidModel.head,boots,boots.headwear,0f,0f,0,1f));
        map.add(new Quad(EquipmentSlot.HEAD, Sitems.GAS_MASK.get().asItem(),humanoidModel.head,gasMaskModel,gasMaskModel.GasMask,0f,-0.05f,0,1f));
        map.add(new Quad(EquipmentSlot.CHEST, Sitems.R_ELYTRON.get().asItem(),humanoidModel.body,elytrumModel,elytrumModel.body,0f,0f,-0.1f,1f));
        map.add(new Quad(EquipmentSlot.MAINHAND, Sitems.PCI.get().asItem(), humanoidModel.rightArm, pci, pci.PCIBODY, -0.15f, -0.35f, -0.05f, 1f));
        map.add(new Quad(EquipmentSlot.OFFHAND, Sitems.PCI.get().asItem(), humanoidModel.leftArm, pciL, pciL.PCIBODY, 0.15f, -0.35f, 0.05f, 1f));
        return map;
    }
    public static List<Quader> complexModelItemMap(HumanoidModel<LivingEntity> humanoidModel,LivingEntity livingEntity){
        List<Quader> map = new ArrayList<>();
        map.add(new Quader(EquipmentSlot.MAINHAND, Sitems.PCI.get().asItem(), humanoidModel.rightArm, pci, pci.PCIBODY, -0.15f, -0.35f, -0.05f, 1f, 0, 0, 0,
                livingEntity){
            @Override
            public RenderType type(ResourceLocation location) {
                return RenderType.eyes(psi_glow);
            }
        });
        map.add(new Quader(EquipmentSlot.OFFHAND, Sitems.PCI.get().asItem(), humanoidModel.leftArm, pciL, pciL.PCIBODY, 0.15f, -0.35f, 0.05f, 1f, 0, 0, 0,
                livingEntity){
            @Override
            public RenderType type(ResourceLocation location) {
                return RenderType.eyes(psi_glow);
            }
        });
        return map;
    }

    public static List<HandDisplay> itemDisplay(){
        List<HandDisplay> map = new ArrayList<>();
        map.add(new HandDisplay(InteractionHand.MAIN_HAND,Sitems.PCI.get().asItem(),pci,pci.PCIBODY,0.95f, -0.7f, -0.35f,1,-90,90,0){
            @Override
            public RenderType type(ResourceLocation location) {
                return RenderType.entityCutoutNoCull(location);
            }
        });
        map.add(new HandDisplay(InteractionHand.MAIN_HAND,Sitems.PCI.get().asItem(),pci,pci.PCIBODY,0.95f, -0.7f, -0.35f,1,-90,90,0){
            @Override
            public RenderType type(ResourceLocation location) {
                return RenderType.eyes(psi_glow);
            }
        });
        map.add(new HandDisplay(InteractionHand.OFF_HAND,Sitems.PCI.get().asItem(),pci,pci.PCIBODY,-1f, -0.7f, -0.35f,1,-90,90,0){
            @Override
            public RenderType type(ResourceLocation location) {
                return RenderType.entityCutoutNoCull(location);
            }
        });
        map.add(new HandDisplay(InteractionHand.OFF_HAND,Sitems.PCI.get().asItem(),pci,pci.PCIBODY,-1f, -0.7f, -0.35f,1,-90,90,0){
            @Override
            public RenderType type(ResourceLocation location) {
                return RenderType.eyes(psi_glow);
            }
        });

        return map;
    }
}
