package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.OutpostWatcherModel;
import com.Harbinger.Spore.Client.Models.ReconstructedMindModel;
import com.Harbinger.Spore.Client.Special.BaseBlockEntityRenderer;
import com.Harbinger.Spore.SBlockEntities.HiveSpawnBlockEntity;
import com.Harbinger.Spore.SBlockEntities.OutpostWatcherBlockEntity;
import com.Harbinger.Spore.Spore;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ReconMindRenderer extends BaseBlockEntityRenderer<HiveSpawnBlockEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,"textures/item/recon_mind.png");
    public ReconMindRenderer() {
        super(new ReconstructedMindModel<>());
    }
    @Override
    public ResourceLocation getTexture(HiveSpawnBlockEntity block) {
        return TEXTURE;
    }
}
