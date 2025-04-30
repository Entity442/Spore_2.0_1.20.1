package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Screens.CabinetMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CabinetBlockEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> stacks = NonNullList.withSize(18, ItemStack.EMPTY);
    private final ContainerOpenersCounter openersCounter;
    public CabinetBlockEntity(BlockPos pos, BlockState state) {
        super(SblockEntities.CABINET_ENTITY.get(),pos , state);
        this.openersCounter = new ContainerOpenersCounter() {
            protected void onOpen(Level level, BlockPos p_155063_, BlockState state1) {
                CabinetBlockEntity.this.playSound(state1, SoundEvents.BARREL_OPEN);
                CabinetBlockEntity.this.updateBlockState(state1, true);
            }

            protected void onClose(Level level, BlockPos pos1, BlockState state1) {
                CabinetBlockEntity.this.playSound(state1, SoundEvents.BARREL_CLOSE);
                CabinetBlockEntity.this.updateBlockState(state1, false);
            }

            protected void openerCountChanged(Level level, BlockPos pos1, BlockState state1, int p_155069_, int p_155070_) {
            }

            protected boolean isOwnContainer(Player player) {
                return true;
            }
        };
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("block.spore.cabinet");
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return new CabinetMenu(i, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
    }

    @Override
    public int getContainerSize() {
        return this.stacks.size();
    }

    protected void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);
        ContainerHelper.saveAllItems(compound, this.stacks);
    }

    public void load(CompoundTag compound) {
        super.load(compound);
        this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compound, this.stacks);
    }
    @Override
    protected NonNullList<ItemStack> getItems() {
        return stacks;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> nonNullList) {
        stacks = nonNullList;
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet) {
        if (packet != null && packet.getTag() != null) {
            this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
            ContainerHelper.loadAllItems(packet.getTag(), this.stacks);
        }
    }

    public void startOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.incrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    public void stopOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.decrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    public void recheckOpen() {
        if (!this.remove) {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    void updateBlockState(BlockState p_58607_, boolean p_58608_) {
        this.level.setBlock(this.getBlockPos(), (BlockState)p_58607_.setValue(BarrelBlock.OPEN, p_58608_), 3);
    }

    void playSound(BlockState p_58601_, SoundEvent p_58602_) {
        Vec3i $$2 = ((Direction)p_58601_.getValue(BarrelBlock.FACING)).getNormal();
        double $$3 = (double)this.worldPosition.getX() + 0.5 + (double)$$2.getX() / 2.0;
        double $$4 = (double)this.worldPosition.getY() + 0.5 + (double)$$2.getY() / 2.0;
        double $$5 = (double)this.worldPosition.getZ() + 0.5 + (double)$$2.getZ() / 2.0;
        this.level.playSound((Player)null, $$3, $$4, $$5, p_58602_, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
    }
}
