package com.Harbinger.Spore.Sblocks;


import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Fluids.BileLiquid;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BileLump extends GenericFoliageBlock {
    public BileLump() {
        super(Properties.of().sound(SoundType.SLIME_BLOCK).noOcclusion().strength(3f).noCollission());
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        return box(3, 0, 3, 13, 10, 13).move(offset.x, offset.y, offset.z);
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
            AreaEffectCloud cloud = new AreaEffectCloud(EntityType.AREA_EFFECT_CLOUD,level);
            for(MobEffectInstance instance : BileLiquid.bileEffects()){
                cloud.addEffect(instance);
            }
            cloud.setDuration(160);
            cloud.setRadius(2f);
            cloud.setParticle(Sparticles.SPORE_PARTICLE.get());
            cloud.moveTo(pos.getX(),pos.getY(),pos.getZ());
            level.addFreshEntity(cloud);
            level.destroyBlock(pos,false,living);
        }
    }

}
