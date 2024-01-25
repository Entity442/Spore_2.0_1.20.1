package com.Harbinger.Spore.Client.Special;

import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.function.Function;

public abstract class BlockEntityModel<T extends BlockEntity> extends Model {
    public BlockEntityModel(Function<ResourceLocation, RenderType> p_103110_) {
        super(p_103110_);
    }
    protected BlockEntityModel() {
        this(RenderType::entityCutout);
    }

    public abstract void setupAnim(T entity, float ageInTicks);

}
