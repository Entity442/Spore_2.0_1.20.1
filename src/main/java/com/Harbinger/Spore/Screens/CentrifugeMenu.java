package com.Harbinger.Spore.Screens;

import com.Harbinger.Spore.Core.SMenu;
import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.SBlockEntities.CentrifugeBlockEntity;
import com.Harbinger.Spore.SBlockEntities.SurgeryTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class CentrifugeMenu extends AbstractContainerMenu {
    public final CentrifugeBlockEntity blockEntity;
    private final Level level;
    private IItemHandler internal;
    public final Player entity;
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    public CentrifugeMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(5));}

    public CentrifugeMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(SMenu.CENTRIFUGE_MENU.get(), pContainerId);
        checkContainerSize(inv, 5);
        blockEntity = ((CentrifugeBlockEntity) entity);
        this.level = inv.player.level();
        this.entity = inv.player;
        this.internal = new ItemStackHandler(5);
        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 7, 8) {
        }));
        this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 7, 26) {
        }));
        this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 25, 8) {
        }));
        this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 25, 26) {
        }));
        this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 106, 44) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }
        }));

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
    private static final int TE_INVENTORY_SLOT_COUNT = 20;  // must be the number of slots you have!



    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        if (pIndex == 20) {
            return ItemStack.EMPTY; // Prevent shift-clicking from output slot
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
                for (int j = 0; j < blockEntity.getStacks().size(); ++j) {
                    playerIn.drop(blockEntity.getItem(j), false);
                }
            } else {
                for (int i = 0; i < blockEntity.getStacks().size(); ++i) {
                    playerIn.getInventory().placeItemBackInInventory(blockEntity.getItem(i), false);
                }
            }
        }
    }
}