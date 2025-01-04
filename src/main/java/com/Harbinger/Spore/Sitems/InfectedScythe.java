package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsBaseItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

public class InfectedScythe extends SporeToolsBaseItem {
    public InfectedScythe() {
        super(SConfig.SERVER.scythe_damage.get(), 3f, 3F, SConfig.SERVER.scythe_durability.get(), 3);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return toolAction == ToolActions.SWORD_SWEEP || ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction) || toolAction == ToolActions.SHEARS_DIG;
    }

    @Override
    public @NotNull AABB getSweepHitBox(@NotNull ItemStack stack, @NotNull Player player, @NotNull Entity target) {
        return target.getBoundingBox().inflate(4);
    }
}

