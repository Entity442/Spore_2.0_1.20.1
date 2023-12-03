package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.SBlockEntities.CDUBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class CDUBlock extends BaseEntityBlock {
    public CDUBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CDUBlockEntity(pos,state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos blockPos, RandomSource randomSource) {
        super.animateTick(state, level, blockPos, randomSource);
        BlockEntity entity = level.getBlockEntity(blockPos);
        if (entity instanceof CDUBlockEntity blockEntity && blockEntity.getFuel() > 0){
            for (int i = 0; i < 360; i++) {
                if (i % 20 == 0) {
                    double yy = Math.sin(i) * Math.cos(i) * 0.25d;
                    level.addParticle(ParticleTypes.SNOWFLAKE,
                            blockPos.getX()+0.47, blockPos.getY() + 1, blockPos.getZ()+0.47,
                            Math.cos(i) * 0.15d, yy, Math.sin(i) * 0.15d);
                }
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        super.use(state, level, pos, player, hand, result);
        BlockEntity entity = level.getBlockEntity(pos);
        if (entity instanceof CDUBlockEntity blockEntity){
            ItemStack item = player.getItemInHand(hand);
            if (item.getItem() == Items.STICK){
                if (blockEntity.getFuel() > 0){
                    player.displayClientMessage(Component.literal("Current fuel " + blockEntity.getFuel() + "/" + blockEntity.maxFuel),true);
                }else{
                    blockEntity.setFuel(blockEntity.maxFuel);
                    item.shrink(1);
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState p_153274_, BlockEntityType<T> type) {
        return createCDUTicker(level, type, SblockEntities.CDU.get());
    }


    @javax.annotation.Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createCDUTicker(Level level, BlockEntityType<T> type, BlockEntityType<? extends CDUBlockEntity> p_151990_) {
        return level.isClientSide ? null : createTickerHelper(type, p_151990_, CDUBlockEntity::serverTick);
    }
}
