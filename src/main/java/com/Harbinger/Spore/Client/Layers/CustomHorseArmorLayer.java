package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.ArmorParts.FleshHorseArmorBit;
import com.Harbinger.Spore.Client.ArmorParts.HorseArmorBit;
import com.Harbinger.Spore.Client.ArmorParts.LivingHorseArmorBit;
import com.Harbinger.Spore.Client.ArmorParts.PlatedHorseArmorBit;
import com.Harbinger.Spore.Core.Sitems;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.animal.horse.AbstractHorse;

import java.util.ArrayList;
import java.util.List;

public class CustomHorseArmorLayer<E extends AbstractHorse,M extends HorseModel<E>> extends RenderLayer<E, M> {
    private final HorseHandlerModel<E> origin;
    public CustomHorseArmorLayer(RenderLayerParent<E, M> parent, ModelPart root) {
        super(parent);
        origin = new HorseHandlerModel<>(root);
    }
    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int light, E entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        getParentModel().copyPropertiesTo(origin);
        origin.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTick);
        origin.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        handleArmorPartsRendering(entity, poseStack, light, buffer,
                limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }
    protected void handleArmorPartsRendering(E entity,PoseStack poseStack,int light ,MultiBufferSource buffer,float limbSwing,float limbSwingAmount,float ageInTicks,float netHeadYaw,float headPitch){
        List<HorseArmorBit> parts = HORSE_ARMOR_LIST;
        if (parts.isEmpty()){
            return;
        }
        for (HorseArmorBit bit : parts){
            bit.tickMovement(entity,poseStack, (HorseHandlerModel<AbstractHorse>) origin,light,buffer);
            bit.getModel().setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks+entity.tickCount, netHeadYaw, headPitch);
        }
    }


    public static class HorseHandlerModel<T extends AbstractHorse> extends HorseModel<T>{
        private final ModelPart rightFrontLeg;
        private final ModelPart leftFrontLeg;
        private final ModelPart rightHindLeg;
        private final ModelPart leftHindLeg;
        public HorseHandlerModel(ModelPart root) {
            super(root);
            this.rightFrontLeg = root.getChild("right_front_leg");
            this.leftFrontLeg = root.getChild("left_front_leg");
            this.rightHindLeg = root.getChild("right_hind_leg");
            this.leftHindLeg = root.getChild("left_hind_leg");
        }

        public ModelPart getHead(){
            return headParts;
        }
        public ModelPart getBody(){
            return body;
        }
        public ModelPart getRightFrontLeg() {
            return this.rightFrontLeg;
        }

        public ModelPart getLeftFrontLeg() {
            return this.leftFrontLeg;
        }

        public ModelPart getRightHindLeg() {
            return this.rightHindLeg;
        }

        public ModelPart getLeftHindLeg() {
            return this.leftHindLeg;
        }
    }


    public static final HorseArmorBit FLESH_ARMOR_BIT = new FleshHorseArmorBit(Sitems.FLESH_HORSE_ARMOR.get());
    public static final HorseArmorBit PLATED_ARMOR_BIT = new PlatedHorseArmorBit(Sitems.PLATED_HORSE_ARMOR.get());
    public static final HorseArmorBit LIVING_ARMOR_BIT = new LivingHorseArmorBit(Sitems.LIVING_HORSE_ARMOR.get());

    public static final List<HorseArmorBit> HORSE_ARMOR_LIST = new ArrayList<>(){{
        add(FLESH_ARMOR_BIT);
        add(PLATED_ARMOR_BIT);
        add(LIVING_ARMOR_BIT);
    }};

}