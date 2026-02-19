package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WallRemainsBlock extends LadderBlock {
    protected static final VoxelShape MOD_EAST_AABB = Block.box(0.0, 0.0, 0.0, 6.0, 16.0, 16.0);
    protected static final VoxelShape MOD_WEST_AABB = Block.box(10.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape MOD_SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 6.0);
    protected static final VoxelShape  MOD_NORTH_AABB = Block.box(0.0, 0.0, 10.0, 16.0, 16.0, 16.0);
    public WallRemainsBlock() {
        super(Properties.of().sound(SoundType.SLIME_BLOCK).noOcclusion().strength(3f).noCollission());
    }
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> MOD_NORTH_AABB;
            case SOUTH -> MOD_SOUTH_AABB;
            case WEST -> MOD_WEST_AABB;
            default -> MOD_EAST_AABB;
        };
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity livingEntity && !(entity instanceof Infected || entity instanceof UtilityEntity || SConfig.SERVER.blacklist.get().contains(entity.getEncodeId()) || SConfig.SERVER.mycelium.get().contains(entity.getEncodeId()))) {
            if (!livingEntity.hasEffect(Seffects.MYCELIUM.get())){
                livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),400,1));
            }
        }
    }

    @Override
    protected void tryDropExperience(ServerLevel serverLevel, BlockPos p_220824_, ItemStack p_220825_, IntProvider vak) {
        RandomSource source = RandomSource.create();
        super.tryDropExperience(serverLevel, p_220824_, p_220825_, vak);
        this.popExperience(serverLevel, p_220824_, source.nextInt(6));
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        AreaEffectCloud cloud = new AreaEffectCloud(EntityType.AREA_EFFECT_CLOUD,level);
        cloud.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),160,1));
        cloud.setDuration(160);
        cloud.setRadius(2f);
        cloud.setParticle(Sparticles.SPORE_PARTICLE.get());
        cloud.moveTo(pos.getX(),pos.getY(),pos.getZ());
        level.addFreshEntity(cloud);
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean dropExperience) {
        super.spawnAfterBreak(state, level, pos, stack, dropExperience);
        int xp = 3 + level.random.nextInt(3);
        this.popExperience(level, pos, xp);
    }
}
