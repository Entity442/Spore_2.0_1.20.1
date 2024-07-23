package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.TestIncandescentBiomass;
import com.Harbinger.Spore.Client.Special.BaseBlockEntityRenderer;
import com.Harbinger.Spore.SBlockEntities.IncandescentCoreEntity;
import com.Harbinger.Spore.Spore;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IncandescentBiomassRenderer extends BaseBlockEntityRenderer<IncandescentCoreEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,"textures/entity/incandescent.png");
    public IncandescentBiomassRenderer() {
        super(new TestIncandescentBiomass<>());
    }
    @Override
    public int getTicks(IncandescentCoreEntity entity) {
        return entity.ticks;
    }
    @Override
    public ResourceLocation getTexture() {
        return TEXTURE;
    }

}
