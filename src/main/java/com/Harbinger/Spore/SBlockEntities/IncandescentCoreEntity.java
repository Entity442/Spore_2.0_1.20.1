package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class IncandescentCoreEntity extends BlockEntity {
    public int ticks;
    public IncandescentCoreEntity(BlockPos pos, BlockState state) {
        super(SblockEntities.INCANDESCENT_BIOMASS.get(), pos, state);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);

    }



    public static <E extends IncandescentCoreEntity> void serverTick(Level level, BlockPos pos, BlockState state, E e) {
        tick(level,pos,state,e);
    }

    public static <E extends IncandescentCoreEntity> void clientTick(Level level, BlockPos pos, BlockState state, E e) {
        if (e.ticks <= 720){
            e.ticks++;
        }else{
            e.ticks = 0;
        }
    }



    public static void tick(Level level, BlockPos pos, BlockState state, IncandescentCoreEntity entity){

    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

}
