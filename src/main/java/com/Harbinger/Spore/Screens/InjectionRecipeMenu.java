package com.Harbinger.Spore.Screens;

import com.Harbinger.Spore.Core.SMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class InjectionRecipeMenu extends AbstractContainerMenu {
    public InjectionRecipeMenu(int id, Inventory inventory) {
        super(SMenu.INJECTION_MENU.get(), id);
    }

    public InjectionRecipeMenu(int id, Inventory inventory, FriendlyByteBuf buffer) {
        this(id, inventory);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}