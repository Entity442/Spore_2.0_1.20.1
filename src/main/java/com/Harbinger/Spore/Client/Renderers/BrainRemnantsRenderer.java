package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.brainMatterModel;
import com.Harbinger.Spore.Client.Special.BaseBlockEntityRenderer;
import com.Harbinger.Spore.SBlockEntities.BrainRemnantBlockEntity;
import com.Harbinger.Spore.Spore;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BrainRemnantsRenderer extends BaseBlockEntityRenderer<BrainRemnantBlockEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,"textures/block/brain_bits.png");
    public BrainRemnantsRenderer() {
        super(new brainMatterModel<>());
    }
    @Override
    public int getTicks(BrainRemnantBlockEntity entity) {
        return entity.ticks;
    }
    @Override
    public ResourceLocation getTexture() {
        return TEXTURE;
    }
}
