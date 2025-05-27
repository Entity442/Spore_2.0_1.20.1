package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.Organoids.Umarmer;
import com.Harbinger.Spore.Sentities.Organoids.Usurper;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import java.util.ArrayList;
import java.util.List;

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
        if (e.getTicks() % 200 == 0 && level instanceof ServerLevel serverLevel){
            List<ServerPlayer> players = serverLevel.players();
            if (players.isEmpty()){
                return;
            }else {
                e.checkForPotentialTargets(level,blockPos);
            }
        }
    }

    @Override
    public int getTicks() {
        return ticks;
    }

    public static <E extends BlockEntity> void clientTick(Level level, BlockPos pos, BlockState state, OutpostWatcherBlockEntity e) {
        e.tick();
    }

    public void checkForPotentialTargets(Level level,BlockPos blockPos){
        if (level.getDifficulty() != Difficulty.PEACEFUL){
            int range =2 * SConfig.DATAGEN.outpost_range.get();
            AABB aabb = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), range, range, range);
            List<LivingEntity> possibleTargets = level.getEntitiesOfClass(LivingEntity.class,aabb);
            List<ScentEntity> amountofScents = new ArrayList<>();
            for (LivingEntity entity : possibleTargets){
                if (entity instanceof ScentEntity scent){amountofScents.add(scent);}
            }
            for (LivingEntity entity: possibleTargets){
                if (Utilities.TARGET_SELECTOR.Test(entity) && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(entity) && !entity.hasEffect(Seffects.SYMBIOSIS.get()) &&  entity.onGround()){
                    if (Math.random() < 0.3f && amountofScents.size() <= SConfig.SERVER.scent_cap.get()){
                        SummonScent(entity,level,entity.getX(),entity.getY(),entity.getZ());
                    }
                    if (Math.random() < 0.1f && level instanceof ServerLevel serverLevel){
                        SummonOrganoids(serverLevel,entity.getX(),entity.getY(),entity.getZ(),Math.random()<=0.5f,blockPos);
                    }
                }
            }
        }
    }

    private void SummonScent(LivingEntity target, Level level, double x, double y, double z){
        AABB aabb = target.getBoundingBox().inflate(3);
        List<Entity> entityList = level.getEntities(target,aabb, entity -> {return  entity instanceof LivingEntity livingEntity && Utilities.TARGET_SELECTOR.Test(livingEntity);});
        ScentEntity scent = new ScentEntity(Sentities.SCENT.get(),level);
        scent.setOvercharged(entityList.size() > 2);
        scent.moveTo(x,y,z);
        level.addFreshEntity(scent);
    }
    private void SummonOrganoids(ServerLevel level, double x, double y, double z, boolean range, BlockPos pos){
        if (range){
            Umarmer umarmer = new Umarmer(Sentities.UMARMED.get(),level);
            umarmer.moveTo(x,y,z);
            umarmer.teleportTo(x,y,z);
            umarmer.finalizeSpawn(level,level.getCurrentDifficultyAt(new BlockPos(pos)), MobSpawnType.MOB_SUMMONED,null,null);
            level.addFreshEntity(umarmer);
        }else{
            Usurper usurper = new Usurper(Sentities.USURPER.get(),level);
            usurper.moveTo(x,y,z);
            usurper.teleportTo(x,y,z);
            usurper.finalizeSpawn(level,level.getCurrentDifficultyAt(new BlockPos(pos)), MobSpawnType.MOB_SUMMONED,null,null);
            level.addFreshEntity(usurper);
        }
    }


}
