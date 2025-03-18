package com.Harbinger.Spore.Screens;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;

public interface TutorialMenuMethods {
    default void renderFakeItem(Font font,GuiGraphics guiGraphics, ItemStack stack, int x, int y) {
        guiGraphics.renderItem(stack, x, y);
        guiGraphics.renderItemDecorations(font, stack, x, y);
    }
    default void renderFakeDamagedItem(Font font, GuiGraphics guiGraphics, ItemStack stack, int damage, int x, int y) {
        stack.setDamageValue(damage);
        guiGraphics.renderItem(stack, x, y);
        guiGraphics.renderItemDecorations(font, stack, x, y);
    }
}
