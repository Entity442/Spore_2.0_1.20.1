package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Fluids.BileLiquid;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class GastricBiomassBlock extends Block {
    public GastricBiomassBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        for (MobEffectInstance instance : BileLiquid.bileEffects()){
            player.addEffect(instance);
        }
        super.attack(state, level, pos, player);
    }
}
