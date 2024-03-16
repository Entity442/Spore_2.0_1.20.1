package com.Harbinger.Spore.Sblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SickenBiomassBlock extends Block {
    public SickenBiomassBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        if (!player.hasEffect(MobEffects.POISON)){
            player.addEffect(new MobEffectInstance(MobEffects.POISON,600,1));
        }
        super.attack(state, level, pos, player);
    }
}
