package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.Organoids.HiveTumor;
import com.Harbinger.Spore.Sentities.Utility.ArenaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BrainRemnantBlockEntity extends BlockEntity implements AnimatedEntity{
    public int ticks;
    public int ticksActivation;
    public int ticksOnFire = 0;
    private boolean onFire = false;
    private boolean active = false;
    public BrainRemnantBlockEntity(BlockPos pos, BlockState state) {
        super(SblockEntities.BRAIN_REMNANTS.get(), pos, state);
    }
    public BrainRemnantBlockEntity(BlockPos pos, BlockState state,boolean value,boolean active) {
        super(SblockEntities.BRAIN_REMNANTS.get(), pos, state);
        setOnFire(value);
        setActive(active);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.setOnFire(tag.getBoolean("fire"));
        this.setActive(tag.getBoolean("active"));
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("fire",this.isOnFire());
        tag.putBoolean("active",this.isActive());
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean time) {
        this.active = time;
    }
    public boolean isOnFire() {
        return onFire;
    }
    public void setOnFire(boolean time) {
        this.onFire = time;
    }

    public static <E extends BrainRemnantBlockEntity> void serverTick(Level level, BlockPos pos, BlockState state, E e) {
        tickOnFire(level,pos,state,e);
        if (!level.isClientSide){
            if (e.ticksActivation <= 1200){
                e.ticksActivation++;
            }else{
                e.ticksActivation = 0;
                if (Math.random() < 0.05 && checkForBrains(level,pos) && e.isActive()){
                    summonTumor(level,pos);
                }
            }
        }
    }
    public static boolean checkForBrains(Level level, BlockPos pos) {
        int count = 0;
        int range = 8;

        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = -range; z <= range; z++) {

                    BlockPos checkPos = pos.offset(x, y, z);
                    BlockState state = level.getBlockState(checkPos);

                    if (state.is(Sblocks.BRAIN_REMNANTS.get())) {
                        count++;
                        if (count > 2) {
                            return true; // early exit
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void summonTumor(Level level, BlockPos pos) {
        HiveTumor hiveTumor = new HiveTumor(Sentities.HIVETUMOR.get(), level);
        hiveTumor.moveTo(pos.getX(), pos.getY()+1, pos.getZ());
        hiveTumor.tickEmerging();
        MinecraftServer server = level.getServer();
        if (server != null){
            for(ServerPlayer player : server.getPlayerList().getPlayers()){
                player.playNotifySound(Ssounds.TUMOR_AMBIENT.get(), SoundSource.AMBIENT,1f,1f);
                player.displayClientMessage(Component.translatable("tumor_summon_message"), false);
            }
        }

        if (level.addFreshEntity(hiveTumor)) {
            deleteNearbyBrains(level, pos, 8);
        }
    }
    public static void deleteNearbyBrains(Level level, BlockPos pos, int range) {
        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = -range; z <= range; z++) {

                    BlockPos checkPos = pos.offset(x, y, z);
                    BlockState state = level.getBlockState(checkPos);

                    if (state.is(Sblocks.BRAIN_REMNANTS.get())) {
                        level.destroyBlock(checkPos, false);
                    }
                }
            }
        }
    }
    public static <E extends BrainRemnantBlockEntity> void clientTick(Level level, BlockPos pos, BlockState state, E e) {
        if (level.isClientSide){
            if (e.ticks <= 12000){
                e.ticks++;
            }else{
                e.ticks = 0;
            }
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
