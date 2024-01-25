package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.OvergrownSpawnerModel;
import com.Harbinger.Spore.Client.Special.BaseBlockEntityRenderer;
import com.Harbinger.Spore.SBlockEntities.OvergrownSpawnerEntity;
import com.Harbinger.Spore.Spore;
import net.minecraft.resources.ResourceLocation;

public class OvergrownSpawnerRenderer extends BaseBlockEntityRenderer<OvergrownSpawnerEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,"textures/block/overgrown_spawner.png");
    public OvergrownSpawnerRenderer() {
        super(new OvergrownSpawnerModel<>());
    }
    @Override
    public int getTicks(OvergrownSpawnerEntity entity) {
        return entity.ticks;
    }
    @Override
    public ResourceLocation getTexture() {
        return TEXTURE;
    }
}
