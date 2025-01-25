package com.Harbinger.Spore.Recipes;

import com.google.gson.JsonObject;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.crafting.CraftingHelper;

public record InputEntry(ItemStack item, int count, int slot) {

    public boolean matches(ItemStack stack, int slot) {
        if (this.slot != slot) return false;
        if (!ItemStack.isSameItem(stack, this.item)) return false;
        int count = stack.getCount();
        return count == this.count;
    }

    public static InputEntry fromJson(JsonObject json) {
        ItemStack item = CraftingHelper.getItemStack(json.getAsJsonObject("item"), false);
        int minCount = json.get("count").getAsInt();
        int slot = json.get("slot").getAsInt();
        return new InputEntry(item, minCount, slot);
    }
}