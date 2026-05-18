package com.Harbinger.Spore.Sitems;


import com.Harbinger.Spore.Sentities.FoliageSpread;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FungalBonemeal extends BaseItem implements FoliageSpread {
    private final static RandomSource random = RandomSource.create();
    public FungalBonemeal() {
        super(new Properties());
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        ItemStack stack = context.getItemInHand();
        BlockState state = level.getBlockState(pos);
        if (state.getBlock() instanceof MushroomBlock mushroomBlock && level instanceof ServerLevel serverLevel){
            mushroomBlock.performBonemeal(serverLevel,random,pos,state);
        }else {
            SpreadInfection(level,7,pos);
        }
        stack.shrink(1);
        return InteractionResult.SUCCESS;
    }
}
