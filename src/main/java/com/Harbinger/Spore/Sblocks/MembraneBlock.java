package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MembraneBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 15.9D, 16.0D);
    public MembraneBlock() {
        super(BlockBehaviour.Properties.of()
                .strength(2f,2f).sound(SoundType.SLIME_BLOCK)
                .isSuffocating((p_61036_, p_61037_, p_61038_) -> false).isViewBlocking((p_61036_, p_61037_, p_61038_) -> false));
    }
    protected boolean isAllowedToPass(LivingEntity livingEntity){
        if (livingEntity instanceof Infected || livingEntity instanceof UtilityEntity){
            return true;
        }
        return livingEntity instanceof Player player && (player.getAbilities().instabuild || player.hasEffect(Seffects.SYMBIOSIS.get()));
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }
    public VoxelShape getBlockSupportShape(BlockState p_221566_, BlockGetter p_221567_, BlockPos p_221568_) {
        return Shapes.block();
    }
    public int getLightBlock(BlockState p_54460_, BlockGetter p_54461_, BlockPos p_54462_) {
        return 1;
    }


    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext collisionContext) {
        if (collisionContext instanceof EntityCollisionContext entityCollisionContext){
            if (entityCollisionContext.getEntity() instanceof LivingEntity livingEntity){
                if (this.isAllowedToPass(livingEntity)){
                    return Shapes.empty();
                }
            }
        }
        return super.getCollisionShape(state, getter, pos, collisionContext);
    }
    public boolean isPathfindable(BlockState p_154258_, BlockGetter p_154259_, BlockPos p_154260_, PathComputationType p_154261_) {
        return true;
    }
    @Override
    public void attack(BlockState p_60499_, Level p_60500_, BlockPos p_60501_, Player player) {
        player.addEffect(new MobEffectInstance(Seffects.MARKER.get(),1200,0));
        super.attack(p_60499_, p_60500_, p_60501_, player);
    }
}
