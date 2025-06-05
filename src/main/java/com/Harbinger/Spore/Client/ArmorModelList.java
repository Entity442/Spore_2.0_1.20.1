package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Client.Models.ElytrumModel;
import com.Harbinger.Spore.Client.Models.GasMaskModel;
import com.Harbinger.Spore.Client.Models.TestBootModel;
import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;
@OnlyIn(Dist.CLIENT)
public class ArmorModelList {
    private static final TestBootModel<LivingEntity> boots = new TestBootModel<>();
    private static final GasMaskModel<LivingEntity> gasMaskModel = new GasMaskModel<>();
    private static final ElytrumModel<LivingEntity> elytrumModel = new ElytrumModel<>();
    public record Quad(EquipmentSlot slot, Item item,ModelPart origin, EntityModel<? extends LivingEntity> model, ModelPart part,float x,float y,float z,float expand){}

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
        return map;
    }
}
