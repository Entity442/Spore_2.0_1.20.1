package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Sblocks.Cerebrum;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class CerebrumItem extends OrganItem{
    public CerebrumItem(String value, String advancementId) {
        super(value, advancementId);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        if (player == null) return InteractionResult.FAIL;

        BlockPos placePos = pos.relative(context.getClickedFace());
        BlockState state = Sblocks.CEREBRUM_BLOCK.get().defaultBlockState().setValue(Cerebrum.FACING,context.getHorizontalDirection());

        if (!level.isClientSide) {
            if (level.getBlockState(placePos).canBeReplaced()) {
                level.setBlock(placePos, state, 3);

                if (!player.getAbilities().instabuild) {
                    context.getItemInHand().shrink(1);
                }

                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }
}
