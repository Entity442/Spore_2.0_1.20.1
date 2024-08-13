package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class OutpostWatcherBlockEntity extends BlockEntity implements AnimatedEntity{
    public int ticks;
    public OutpostWatcherBlockEntity(BlockPos pos, BlockState state) {
        super(SblockEntities.OUTPOST_WATCHER.get(), pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
    }
    public void tick(){
        if (ticks <= 720){
            ticks++;
        }else {
            ticks = 0;
        }
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }


    public static <E extends BlockEntity> void serverTick(Level level, BlockPos blockPos, BlockState blockState, OutpostWatcherBlockEntity e) {
        e.tick();
    }

    @Override
    public int getTicks() {
        return ticks;
    }

    public static <E extends BlockEntity> void clientTick(Level level, BlockPos pos, BlockState state, OutpostWatcherBlockEntity e) {
        e.tick();
    }
}
