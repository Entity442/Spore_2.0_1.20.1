package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporePickaxeItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class InfectedMaul extends SporePickaxeItems {
    public InfectedMaul() {
        super(SConfig.SERVER.maul_damage.get(), 2f, -3F,  SConfig.SERVER.maul_durability.get(), 3);
    }

    @Override
    public boolean canMultiBreak(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity living) {
        return !living.isCrouching();
    }
}
