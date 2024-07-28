package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public class IncubatorBlockEntity extends BlockEntity implements AnimatedEntity, WorldlyContainer {
    private static final int[] slotsTop = new int[]{0};
    private static final int[] slotsBottom = new int[]{0};
    private NonNullList<ItemStack> stacks = NonNullList.withSize(1, ItemStack.EMPTY);
    public int fuel;
    private int tick;
    private int side;
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

    public NonNullList<ItemStack> getStacks() {
        return stacks;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("fuel",this.getFuel());
        tag.putInt("side",getSide());
        ContainerHelper.saveAllItems(tag, this.stacks);
    }
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        setFuel(tag.getInt("fuel"));
        setSide(getSide());
        this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, this.stacks);
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
    public void HealItemStack(){
        for (ItemStack stack : stacks)
        if (stack != ItemStack.EMPTY)
        if (getFuel() > 0 && stack.isDamaged()){
            int l = stack.getDamageValue()-1;
            stack.setDamageValue(l);
            setFuel(getFuel()-1);
        }
    }
    public static <E extends BlockEntity> void serverTick(Level level, BlockPos blockPos, BlockState blockState, IncubatorBlockEntity e) {
        e.HealItemStack();
    }

    public static <E extends BlockEntity> void clientTick(Level level, BlockPos pos, BlockState state, IncubatorBlockEntity e) {
        e.addTick();
    }

    public boolean isActive(){
        return getFuel()>0;
    }

    @Override
    public int getTicks() {
        return tick;
    }

    @Override
    public int[] getSlotsForFace(Direction direction) {
        return direction == Direction.UP ? slotsTop : slotsBottom;
    }

    @Override
    public boolean canPlaceItemThroughFace(int p_19235_, ItemStack item, @Nullable Direction direction) {
        if (direction == Direction.NORTH || direction == Direction.SOUTH || direction == Direction.EAST || direction == Direction.WEST){
          if (this.getFuel() <= 750){
              setFuel(getFuel()+250);
              item.shrink(1);
          }
        }
        return direction == Direction.UP && item.is(ItemTags.create(new ResourceLocation("spore:weapons")));
    }

    @Override
    public boolean canTakeItemThroughFace(int p_19239_, ItemStack stack, Direction direction) {
        return direction == Direction.DOWN && !stack.isDamaged();
    }

    @Override
    public int getContainerSize() {
        return stacks.size();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < this.getContainerSize(); i++) {
            if (!this.getItem(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int index) {
        return this.stacks.get(index);
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        if (!this.stacks.get(index).isEmpty()) {
            ItemStack itemstack;

            if (this.stacks.get(index).getCount() <= count) {
                itemstack = this.stacks.get(index);
                this.stacks.set(index, ItemStack.EMPTY);
            } else {
                itemstack = this.stacks.get(index).split(count);

                if (this.stacks.get(index).isEmpty()) {
                    this.stacks.set(index, ItemStack.EMPTY);
                }

            }
            return itemstack;
        } else {
            return ItemStack.EMPTY;
        }
    }

    @Override
    public ItemStack removeItemNoUpdate(int p_18951_) {
        return null;
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        this.stacks.set(index, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }
        this.saveAdditional(this.getUpdateTag());
    }

    @Override
    public boolean stillValid(Player p_18946_) {
        return true;
    }

    @Override
    public void clearContent() {
        this.stacks.clear();
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet) {
        if (packet != null && packet.getTag() != null) {
            this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
            ContainerHelper.loadAllItems(packet.getTag(), this.stacks);
        }
    }
}
