package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.CustomArmorLayer;
import com.Harbinger.Spore.Client.Models.InfectedPlayerModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPlayer;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;

@OnlyIn(Dist.CLIENT)
public class InfectedPlayerRenderer extends BaseInfectedRenderer<InfectedPlayer , HumanoidModel<InfectedPlayer>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inf_player.png");
    private static final ResourceLocation TECHNO = new ResourceLocation(Spore.MODID,
            "textures/entity/techno_skin.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/inf_player.png");
    private static final ResourceLocation DEFAULT_SKIN = new ResourceLocation("minecraft:textures/entity/player/wide/steve.png");
    private final HumanoidModel<InfectedPlayer> mainModel = this.getModel();
    private final HumanoidModel<InfectedPlayer> madnessModel;

    public InfectedPlayerRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedPlayerModel<>(context.bakeLayer(InfectedPlayerModel.LAYER_LOCATION)), 0.5f);
        this.madnessModel = new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER));

        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidArmorModel
                (context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
                new HumanoidArmorModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
        this.addLayer(new CustomArmorLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(InfectedPlayer infectedPlayer) {
        if (isTheViewerMad(infectedPlayer)){
            return DEFAULT_SKIN;
        }
        if (Objects.equals(infectedPlayer.getCustomName(), Component.literal("Technoblade"))) {
            return TECHNO;
        }
        return TEXTURE;
    }

    public boolean isTheViewerMad(InfectedPlayer infectedPlayer){
        if (Minecraft.getInstance().cameraEntity instanceof Player player){
            MobEffectInstance instance = player.getEffect(Seffects.MADNESS.get());
            return instance != null && instance.getAmplifier() > 0 && player.distanceTo(infectedPlayer) > 30;
        }
        return false;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    @Override
    public void render(InfectedPlayer type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        this.model = isTheViewerMad(type) ? madnessModel : mainModel;
        super.render(type, value1, value2, stack, bufferSource, light);
    }
}
