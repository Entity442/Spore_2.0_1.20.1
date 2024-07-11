package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ZoaholicBlockEntity extends BlockEntity{
    private int ticks;
    private boolean hasBrain;
    private boolean hasHeart;
    private int amountOfInnards;
    private int biomass;
    public ZoaholicBlockEntity(BlockPos pos, BlockState state) {
        super(SblockEntities.ZOAHOLIC.get(), pos, state);
    }

    public int getAmountOfInnards() {
        return amountOfInnards;
    }
    public void setAmountOfInnards(int amountOfInnards) {
        this.amountOfInnards = amountOfInnards;
    }
    public boolean HasBrain() {
        return hasBrain;
    }
    public void setBrain(boolean hasBrain) {
        this.hasBrain = hasBrain;
    }
    public boolean HasHeart() {
        return hasHeart;
    }
    public void setHasHeart(boolean hasHeart) {
        this.hasHeart = hasHeart;
    }
    public boolean hasEnoughInnards(){
        return getAmountOfInnards() >= 2;
    }
    public int getBiomass() {
        return biomass;
    }
    public void setBiomass(int biomass) {
        this.biomass = biomass;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.putInt("innards",getAmountOfInnards());
        tag.putInt("biomass",getBiomass());
        tag.putBoolean("brain",HasBrain());
        tag.putBoolean("heart",HasHeart());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        setAmountOfInnards(tag.getInt("innards"));
        setBiomass(tag.getInt("biomass"));
        setBrain(tag.getBoolean("brain"));
        setHasHeart(tag.getBoolean("heart"));
        super.load(tag);
    }

    public int getTicks() {
        return ticks;
    }
    public boolean isActive(){
        return HasHeart() && HasHeart() && hasEnoughInnards() && getBiomass() > 1;
    }

    public void tickBlockEntity(){
        if (ticks < 360){
            ticks++;
        }else{
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


    public static <E extends BlockEntity> void serverTick(Level level, BlockPos pos, BlockState state, ZoaholicBlockEntity e) {

    }

    public static <E extends BlockEntity> void clientTick(Level level, BlockPos pos, BlockState state, ZoaholicBlockEntity e) {
        e.tickBlockEntity();
    }
}
