package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.LeftArmModel;
import com.Harbinger.Spore.Client.Models.RightArmModel;
import com.Harbinger.Spore.Sentities.FallenMultipart.HowitzerArm;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HowdiArmRenderer<Type extends HowitzerArm> extends MobRenderer<Type , EntityModel<Type>> {
    private final EntityModel<Type> rightArm = this.getModel();
    private final EntityModel<Type> leftArm;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/howitzer.png");
    private static final ResourceLocation RADIATION = new ResourceLocation(Spore.MODID,
            "textures/entity/nuclear_howitzer.png");


    public HowdiArmRenderer(EntityRendererProvider.Context context) {
        super(context, new RightArmModel<>(context.bakeLayer(RightArmModel.LAYER_LOCATION)), 1.5f);
        this.leftArm = new LeftArmModel<>(context.bakeLayer(LeftArmModel.LAYER_LOCATION));
    }

    @Override
    public void render(Type type, float p_115456_, float p_115457_, PoseStack p_115458_, MultiBufferSource p_115459_, int p_115460_) {
        if (type.getRight()){
            this.model = rightArm;
        }else{
            this.model = leftArm;
        }
        super.render(type, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return entity.getNuclear() ? RADIATION : TEXTURE;
    }

}