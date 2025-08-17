package com.Harbinger.Spore.Screens;

import com.Harbinger.Spore.Core.SMenu;
import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.SBlockEntities.SurgeryTableBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class GraftingMenu extends AbstractContainerMenu {
    public final SurgeryTableBlockEntity blockEntity;
    private final Level level;
    public GraftingMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(25));}

    public GraftingMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(SMenu.GRAFTING_MENU.get(), pContainerId);
        checkContainerSize(inv, 25);
        blockEntity = ((SurgeryTableBlockEntity) entity);
        this.level = inv.player.level();
        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
            this.addSlot(new SlotItemHandler(iItemHandler, SurgeryTableBlockEntity.GRATING_ITEM_ONE, 25, 8));
            this.addSlot(new SlotItemHandler(iItemHandler, SurgeryTableBlockEntity.GRATING_INGREDIENT, 25, 35));
            this.addSlot(new SlotItemHandler(iItemHandler, SurgeryTableBlockEntity.GRATING_ITEM_TWO, 25, 62));
            this.addSlot(new SlotItemHandler(iItemHandler, SurgeryTableBlockEntity.GRATING_OUTPUT, 88, 35) {
                @Override
                public boolean mayPlace(ItemStack stack) { return false; }
                @Override
                public void onTake(Player player, ItemStack stack) {
                    super.onTake(player, stack);
                    blockEntity.consumeItemsGrafting();
                    blockEntity.assembleGraft(stack);
                }
            });
        });
        addDataSlots(data);
    }


    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 25;  // must be the number of slots you have!



    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        if (pIndex == 24) {
            return ItemStack.EMPTY;
        }
        Slot sourceSlot = slots.get(pIndex);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, Sblocks.SURGERY_TABLE.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public void removed(Player playerIn) {
        super.removed(playerIn);
        if (playerIn instanceof ServerPlayer serverPlayer) {
            if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
                for (int j = 0; j < blockEntity.itemHandler.getSlots(); ++j) {
                    if (j != 20 && j != 24){
                        playerIn.drop(blockEntity.itemHandler.extractItem(j, blockEntity.itemHandler.getStackInSlot(j).getCount(), false), false);
                    }
                }
            } else {
                for (int i = 0; i < blockEntity.itemHandler.getSlots(); ++i) {
                    if (i != 20 && i != 24){
                        playerIn.getInventory().placeItemBackInInventory(blockEntity.itemHandler.extractItem(i, blockEntity.itemHandler.getStackInSlot(i).getCount(), false));
                    }
                 }
            }
        }
    }
}