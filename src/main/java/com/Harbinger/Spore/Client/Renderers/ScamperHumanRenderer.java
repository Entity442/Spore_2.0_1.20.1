package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.DrownedScamperModel;
import com.Harbinger.Spore.Client.Models.ScamperModel;
import com.Harbinger.Spore.Client.Models.ScamperVillagerModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Scamper;
import com.Harbinger.Spore.Sentities.Variants.ScamperVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ScamperHumanRenderer extends MobRenderer<Scamper , EntityModel<Scamper>> {
    private final EntityModel<Scamper> defaultModel = this.getModel();
    private final EntityModel<Scamper> villagerModel;
    private final EntityModel<Scamper> drownedModel;

    public static final Map<ScamperVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(ScamperVariants.class), (p_114874_) -> {
                p_114874_.put(ScamperVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/scamper.png"));
                p_114874_.put(ScamperVariants.VILLAGER,
                        new ResourceLocation(Spore.MODID, "textures/entity/villager_scamper.png"));
                p_114874_.put(ScamperVariants.DROWNED,
                        new ResourceLocation(Spore.MODID, "textures/entity/drowned_scamper.png"));
            });
    public ScamperHumanRenderer(EntityRendererProvider.Context context) {
        super(context, new ScamperModel<>(context.bakeLayer(ScamperModel.LAYER_LOCATION)), 0.5f);
        this.villagerModel = new ScamperVillagerModel<>(context.bakeLayer(ScamperVillagerModel.LAYER_LOCATION));
        this.drownedModel = new DrownedScamperModel<>(context.bakeLayer(DrownedScamperModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(Scamper scamper) {
        return TEXTURE.get(scamper.getVariant());
    }

    @Override
    public void render(Scamper scamper, float value1, float value2, PoseStack stack, MultiBufferSource source, int value3) {
        if (scamper.getVariant() == ScamperVariants.VILLAGER){
            this.model = villagerModel;
        } else if (scamper.getVariant() == ScamperVariants.DROWNED) {
            this.model = drownedModel;
        }else{
            this.model = defaultModel;
        }
        super.render(scamper, value1, value2, stack, source, value3);
    }
}
