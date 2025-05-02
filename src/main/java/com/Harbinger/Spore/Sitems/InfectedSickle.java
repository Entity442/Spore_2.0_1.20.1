package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class InfectedSickle extends SporeSwordBase {
    public InfectedSickle() {
        super(SConfig.SERVER.sickle_damage.get(), 3f, 2, SConfig.SERVER.sickle_durability.get());
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_HOE) ? 2F:1F;
    }

    @Override
    public boolean reversedKnockback() {
        return true;
    }
}
