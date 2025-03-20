package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.Utility.ArenaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BrainRemnantBlockEntity extends BlockEntity implements AnimatedEntity{
    public int ticks;
    public int ticksOnFire = 0;
    private boolean onFire = false;
    public BrainRemnantBlockEntity(BlockPos pos, BlockState state) {
        super(SblockEntities.BRAIN_REMNANTS.get(), pos, state);
    }
    public BrainRemnantBlockEntity(BlockPos pos, BlockState state,boolean value) {
        super(SblockEntities.BRAIN_REMNANTS.get(), pos, state);
        setOnFire(value);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.setOnFire(tag.getBoolean("fire"));
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("fire",this.isOnFire());

    }

    public boolean isOnFire() {
        return onFire;
    }
    public void setOnFire(boolean time) {
        this.onFire = time;
    }

    public static <E extends BrainRemnantBlockEntity> void serverTick(Level level, BlockPos pos, BlockState state, E e) {
        tickOnFire(level,pos,state,e);
    }

    public static <E extends BrainRemnantBlockEntity> void clientTick(Level level, BlockPos pos, BlockState state, E e) {
        if (e.ticks <= 720){
            e.ticks++;
        }else{
            e.ticks = 0;
        }
    }
    public static void tickOnFire(Level level, BlockPos pos, BlockState state, BrainRemnantBlockEntity entity){
        if (entity.ticksOnFire > 0 && entity.isOnFire()){
            entity.ticksOnFire++;
            if (entity.ticksOnFire >= 50){
                entity.ticksOnFire = 0;
                level.removeBlock(pos,false);
                level.explode(null,pos.getX(),pos.getY(),pos.getZ(),2f, Level.ExplosionInteraction.NONE);
                ArenaEntity arenaEntity = new ArenaEntity(Sentities.ARENA_TENDRIL.get(), level);
                arenaEntity.moveTo(pos.getX(),pos.getY(),pos.getZ());
                arenaEntity.tickEmerging();
                arenaEntity.recalculateHosts();
                level.addFreshEntity(arenaEntity);
            }
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

    @Override
    public int getTicks() {
        return ticks;
    }
}
