package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.CustomArmorLayer;
import com.Harbinger.Spore.Client.Models.InfectedPlayerModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPlayer;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;

@OnlyIn(Dist.CLIENT)
public class InfectedPlayerRenderer<Type extends InfectedPlayer> extends BaseInfectedRenderer<Type , InfectedPlayerModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inf_player.png");
    private static final ResourceLocation TECHNO = new ResourceLocation(Spore.MODID,
            "textures/entity/techno_skin.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/inf_player.png");


    public InfectedPlayerRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedPlayerModel<>(context.bakeLayer(InfectedPlayerModel.LAYER_LOCATION)), 0.5f);

        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidArmorModel
                (context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
                new HumanoidArmorModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
        this.addLayer(new CustomArmorLayer<>(this));
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        if (Objects.equals(entity.getCustomName(), Component.literal("Technoblade"))) {
            return TECHNO;
        }
        return TEXTURE;
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }
}
