package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Core.Seffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class FungalClamp extends GenericFoliageBlock{
    public static final BooleanProperty OPEN = BooleanProperty.create("open");
    public FungalClamp() {
        super(Properties.of().sound(SoundType.CROP).strength(1f, 1f).randomTicks().noCollission().noOcclusion().sound(SoundType.CROP));
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        {
            return box(2, 0, 2, 14, 12, 14);
        }
    }
    public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockState blockState = levelReader.getBlockState(pos.below());
        return blockState.canOcclude();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        super.createBlockStateDefinition(stateBuilder);
        stateBuilder.add(OPEN);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
        if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)) {
            if (state.getValue(OPEN)){
                level.setBlock(pos, level.getBlockState(pos).setValue(OPEN, false), Block.UPDATE_ALL);
                AABB aabb = new AABB(
                        pos.getX() - 1, pos.getY() - 1, pos.getZ() - 1,
                        pos.getX() + 2, pos.getY() + 2, pos.getZ() + 2
                );
                living.hurt(level.damageSources().cactus(),10);
                spreadInfection(level,aabb);
            }else {
                if (living.tickCount % 200 == 0 && !level.isClientSide()){
                    injectSpores(living);
                }
            }
            entity.makeStuckInBlock(state, new Vec3((double)0.1F, 0.2D, (double)0.1F));
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        if (!state.getValue(OPEN) && isEmptyWithin(level,new AABB(pos))){
            level.setBlock(pos, level.getBlockState(pos).setValue(OPEN, true), Block.UPDATE_ALL);
        }
    }

    public void injectSpores(LivingEntity living){
        MobEffectInstance instance = living.getEffect(Seffects.MYCELIUM.get());
        if (instance == null){
            living.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),300,0));
            return;
        }
        int i = instance.getAmplifier();
        i = i <= 4 ? i+1 : i;
        living.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),300,i));
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(OPEN);
    }

    public boolean isEmptyWithin(Level level, AABB aabb){
        return level.getEntities(null,aabb).isEmpty();
    }
    public void spreadInfection(Level level, AABB aabb){
        List<Entity> entities = level.getEntities(null,aabb);
        if (entities.isEmpty()){
            return;
        }
        for (Entity entity : entities){
            if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
                living.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),200,0));
            }
        }
    }
}
