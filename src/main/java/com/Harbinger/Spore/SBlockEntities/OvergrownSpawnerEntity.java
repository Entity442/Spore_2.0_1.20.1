package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class OvergrownSpawnerEntity extends BlockEntity {
    public int ticks;
    public OvergrownSpawnerEntity(BlockPos pos, BlockState state) {
        super(SblockEntities.OVERGROWN_SPAWNER.get(), pos, state);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    public static <E extends OvergrownSpawnerEntity> void serverTick(Level level, BlockPos pos, BlockState state, E e) {
        tick(level,pos,state,e);
    }

    public static <E extends OvergrownSpawnerEntity> void clientTick(Level level, BlockPos pos, BlockState state, E e) {
        tick(level,pos,state,e);
    }



    public static void tick(Level level, BlockPos pos, BlockState state,OvergrownSpawnerEntity  entity){
        if (entity.ticks < 360){
            entity.ticks++;
        }else{
            entity.ticks = 0;
        }
    }
}
