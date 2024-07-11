package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.Organoids.Proto;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ZoaholicBlockEntity extends BlockEntity{
    private int ticks;
    private boolean hasBrain = false;
    private boolean hasHeart = false;
    private int amountOfInnards = 0;
    private int biomass = 0;
    private int processing = 0;
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
    public void addBiomass(int value){setBiomass(getBiomass()+value);}
    public int getProcessing() {
        return processing;
    }
    public void setProcessing(int processing) {
        this.processing = processing;
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

    public void lowerBiomass(){
        this.setBiomass(this.getBiomass()-1);
    }
    public int getTicks() {
        return ticks;
    }
    public boolean isActive(){
        return HasHeart() && HasBrain() && hasEnoughInnards() && getBiomass() > 1;
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
        if (e.isActive()){
            e.lowerBiomass();
            if (e.getProcessing() >0){
                e.setProcessing(e.getProcessing()-1);
                if (e.getProcessing() == 1){
                    e.writeDocument(level,pos);
                }
            }
        }
    }

    public static <E extends BlockEntity> void clientTick(Level level, BlockPos pos, BlockState state, ZoaholicBlockEntity e) {
        e.tickBlockEntity();
    }

    @Nullable
    protected LivingEntity getAnomaly(Level level,BlockPos blockPos){
        int range =2 * SConfig.SERVER.proto_range.get();
        AABB aabb = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), range, range, range);
        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, aabb,e -> e instanceof Proto || e instanceof Calamity);
        for(LivingEntity entity : entities) {
            return entity;
        }
        return null;
    }
    public void writeDocument(Level level,BlockPos blockPos){
        LivingEntity livingEntity = getAnomaly(level,blockPos);
        RandomSource randomSource = RandomSource.create();
        ItemStack stack = new ItemStack(Items.PAPER);
        if (livingEntity != null){
            int x = livingEntity.getBlockX() + randomSource.nextInt(-50,50);
            int z = livingEntity.getBlockZ() + randomSource.nextInt(-50,50);
            stack.setHoverName(Component.literal("Anomaly detected at X"+x + " Z"+z));
        }else{
            stack.setHoverName(Component.literal("No anomaly detected"));
        }
        ItemEntity item = new ItemEntity(level,blockPos.getX(),blockPos.getY()+0.5,blockPos.getZ(),stack);
        level.addFreshEntity(item);
    }
}
