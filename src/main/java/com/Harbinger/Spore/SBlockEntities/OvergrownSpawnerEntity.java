package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class OvergrownSpawnerEntity extends BlockEntity {
    public int ticks;
    private int time;
    public  final int maxTime = 1200;
    public OvergrownSpawnerEntity(BlockPos pos, BlockState state) {
        super(SblockEntities.OVERGROWN_SPAWNER.get(), pos, state);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("time",this.getTime());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.setTime(tag.getInt("time"));
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void addTime(){
        this.setTime(this.getTime()+1);
    }

    public int getMaxTime(){
        return this.maxTime;
    }

    public static <E extends OvergrownSpawnerEntity> void serverTick(Level level, BlockPos pos, BlockState state, E e) {
        tick(level,pos,state,e);
    }

    public static <E extends OvergrownSpawnerEntity> void clientTick(Level level, BlockPos pos, BlockState state, E e) {
        tick(level,pos,state,e);
    }



    public static void tick(Level level, BlockPos pos, BlockState state,OvergrownSpawnerEntity  entity){
        if (entity.ticks <= 360){
            entity.ticks++;
        }else{
            entity.ticks = 0;
        }
        if (entity.getTime() <= entity.maxTime){
            entity.addTime();
        }else{
            entity.setTime(0);
            entity.feed(level,pos);
        }
    }


    private void feed(Level level1,BlockPos blockPos){
        int range = 2 * SConfig.DATAGEN.spawner_range.get();
        AABB aabb = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), range, range, range);
        List<LivingEntity> entities = level1.getEntitiesOfClass(LivingEntity.class, aabb);

        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockEntity blockEntity = level1.getBlockEntity(blockpos);
            if (blockEntity instanceof  LivingStructureBlocks structureBlocks){
                structureBlocks.addKills();
            }
        }

        for (Entity entity : entities){
            if (entity instanceof Infected infected){
                infected.setKills(infected.getKills()+1);
                infected.setEvolution(infected.getEvoPoints()+1);
            }
            if (entity instanceof Calamity calamity){
                calamity.setKills(calamity.getKills()+1);
            }
        }
    }


}
