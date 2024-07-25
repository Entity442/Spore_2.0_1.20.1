package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class IncubatorBlockEntity extends BlockEntity implements AnimatedEntity{
    public final int maxFuel = 12000;
    public int fuel;
    private int tick;
    private int side;
    private ItemStack weapon = ItemStack.EMPTY;
    public IncubatorBlockEntity(BlockPos pos, BlockState state) {
        super(SblockEntities.INCUBATOR.get(), pos, state);
        side = setSide(state);
    }
    private int setSide(BlockState state){
        if (state.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty directionProperty){
            return state.getValue(directionProperty).get3DDataValue();
        }
        return 2;
    }
    public void setSide(int i){this.side = i;}
    public int getSide(){return this.side;}

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        CompoundTag compoundTag = new CompoundTag();
        tag.putInt("fuel",this.getFuel());
        tag.putInt("side",getSide());
        getStack().save(compoundTag);
        tag.put("item",compoundTag);
    }
    public void setItemStack(ItemStack stack){
        this.weapon = stack;
    }
    public ItemStack getStack(){
        return this.weapon;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        CompoundTag compoundTag = tag.getCompound("item");
        this.setFuel(tag.getInt("fuel"));
        setSide(getSide());
        setItemStack(ItemStack.of(compoundTag));
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

    public void setFuel(int i){
        this.fuel = i;
    }
    public int getFuel(){
        return this.fuel;
    }
    public void addTick(){
        if (tick < 720){
            tick++;
        }else{
            tick = 0;
        }
    }
    public static <E extends BlockEntity> void serverTick(Level level, BlockPos blockPos, BlockState blockState, IncubatorBlockEntity e) {
    }

    public static <E extends BlockEntity> void clientTick(Level level, BlockPos pos, BlockState state, IncubatorBlockEntity e) {
        e.addTick();
    }

    public boolean isActive(){
        return true;
    }

    @Override
    public int getTicks() {
        return tick;
    }
}
