package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.ArenaTendrilModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Utility.ArenaEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RaidTendrilRenderer<Type extends ArenaEntity> extends BaseInfectedRenderer<Type , ArenaTendrilModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/raid_tendril.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/raid_tendril.png");


    public RaidTendrilRenderer(EntityRendererProvider.Context context) {
        super(context, new ArenaTendrilModel<>(context.bakeLayer(ArenaTendrilModel.LAYER_LOCATION)), 1f);
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    @Override
    public void render(Type type, float p_115456_, float p_115457_, PoseStack stack, MultiBufferSource p_115459_, int p_115460_) {
        if (type.isBurrowing() || type.isEmerging()){
            float a = type.getBbHeight();
            float b = 0.0f;
            if (type.isBurrowing()){
                b =0 - (a / 60) * type.getBorrow();
            }else if (type.isEmerging()){
                b = -a + ((a / 60) * type.getEmerge());
            }
            stack.translate(0.0,b,0.0);
        }
        if (!type.isUnderground()){
            super.render(type, p_115456_, p_115457_, stack, p_115459_, p_115460_);
        }
    }
}
