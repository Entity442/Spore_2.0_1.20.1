package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.CustomArmorLayer;
import com.Harbinger.Spore.Client.Models.InfectedPlayerModel;
import com.Harbinger.Spore.Client.Models.InfectedTechnoModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPlayer;
import com.Harbinger.Spore.Sentities.Variants.BraureiVariants;
import com.Harbinger.Spore.Sentities.Variants.InfPlayerSkins;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@OnlyIn(Dist.CLIENT)
public class InfectedPlayerRenderer extends BaseInfectedRenderer<InfectedPlayer , HumanoidModel<InfectedPlayer>> {
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/inf_player.png");
    private final HumanoidModel<InfectedPlayer> mainModel = this.getModel();
    private final HumanoidModel<InfectedPlayer> technoSkin;
    private final HumanoidModel<InfectedPlayer> madnessModel;
    public static final Map<InfPlayerSkins, ResourceLocation> MAIN_TEXTURES =
            Util.make(Maps.newEnumMap(InfPlayerSkins.class), (p_114874_) -> {
                p_114874_.put(InfPlayerSkins.STEVE,
                        new ResourceLocation(Spore.MODID, "textures/entity/player/inf_player_steve.png"));
                p_114874_.put(InfPlayerSkins.ALEX,
                        new ResourceLocation(Spore.MODID, "textures/entity/player/inf_player_alex.png"));
                p_114874_.put(InfPlayerSkins.EFE,
                        new ResourceLocation(Spore.MODID, "textures/entity/player/inf_player_efe.png"));
                p_114874_.put(InfPlayerSkins.MAKENA,
                        new ResourceLocation(Spore.MODID, "textures/entity/player/inf_player_makena.png"));
                p_114874_.put(InfPlayerSkins.SUNNY,
                        new ResourceLocation(Spore.MODID, "textures/entity/player/inf_player_sunny.png"));
                p_114874_.put(InfPlayerSkins.ZURI,
                        new ResourceLocation(Spore.MODID, "textures/entity/player/inf_player_zuri.png"));
                p_114874_.put(InfPlayerSkins.ARI,
                        new ResourceLocation(Spore.MODID, "textures/entity/player/inf_player_ari.png"));
                p_114874_.put(InfPlayerSkins.KAI,
                        new ResourceLocation(Spore.MODID, "textures/entity/player/inf_player_kai.png"));
                p_114874_.put(InfPlayerSkins.NO0R,
                        new ResourceLocation(Spore.MODID, "textures/entity/player/inf_player_noor.png"));
            });
    public static final Map<InfPlayerSkins, ResourceLocation> MADNESS_TEXTURES =
            Util.make(Maps.newEnumMap(InfPlayerSkins.class), (p_114874_) -> {
                p_114874_.put(InfPlayerSkins.STEVE,
                        new ResourceLocation("minecraft:textures/entity/player/wide/steve.png"));
                p_114874_.put(InfPlayerSkins.ALEX,
                        new ResourceLocation("minecraft:textures/entity/player/wide/alex.png"));
                p_114874_.put(InfPlayerSkins.EFE,
                        new ResourceLocation("minecraft:textures/entity/player/wide/efe.png"));
                p_114874_.put(InfPlayerSkins.MAKENA,
                        new ResourceLocation("minecraft:textures/entity/player/wide/makena.png"));
                p_114874_.put(InfPlayerSkins.SUNNY,
                        new ResourceLocation("minecraft:textures/entity/player/wide/sunny.png"));
                p_114874_.put(InfPlayerSkins.ZURI,
                        new ResourceLocation("minecraft:textures/entity/player/wide/zuri.png"));
                p_114874_.put(InfPlayerSkins.ARI,
                        new ResourceLocation("minecraft:textures/entity/player/wide/ari.png"));
                p_114874_.put(InfPlayerSkins.KAI,
                        new ResourceLocation("minecraft:textures/entity/player/wide/kai.png"));
                p_114874_.put(InfPlayerSkins.NO0R,
                        new ResourceLocation("minecraft:textures/entity/player/wide/noor.png"));
            });

    public static final Map<Component,ResourceLocation> SPECIAL_SKINS =new HashMap<>(){{
        put(Component.literal("Technoblade"),new ResourceLocation(Spore.MODID,
                "textures/entity/player/techno_skin.png"));
        put(Component.literal("CODATOWER"),new ResourceLocation(Spore.MODID,
                "textures/entity/player/inf_coda_skin.png"));
        put(Component.literal("Flash62724"),new ResourceLocation(Spore.MODID,
                "textures/entity/player/inf_player_slasher.png"));
        put(Component.literal("TVGuy"),new ResourceLocation(Spore.MODID,
                "textures/entity/player/inf_player_blura.png"));
    }};

    public InfectedPlayerRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedPlayerModel<>(context.bakeLayer(InfectedPlayerModel.LAYER_LOCATION)), 0.5f);
        this.madnessModel = new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER));
        this.technoSkin = new InfectedTechnoModel<>(context.bakeLayer(InfectedTechnoModel.LAYER_LOCATION));
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidArmorModel
                (context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
                new HumanoidArmorModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
        this.addLayer(new CustomArmorLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(InfectedPlayer infectedPlayer) {
        if (isTheViewerMad(infectedPlayer)){
            return MADNESS_TEXTURES.get(infectedPlayer.getVariant());
        }
        Component component = infectedPlayer.getName();
        ResourceLocation location = SPECIAL_SKINS.get(component);
        if (location != null){
            return location;
        }
        return MAIN_TEXTURES.get(infectedPlayer.getVariant());
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
        this.model = isTheViewerMad(type) ? madnessModel : Objects.equals(type.getCustomName(), Component.literal("Technoblade")) ? technoSkin : mainModel;
        super.render(type, value1, value2, stack, bufferSource, light);
    }
}
