package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporePickaxeItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class InfectedPickaxe extends SporePickaxeItems {
    public InfectedPickaxe() {
        super(SConfig.SERVER.inf_pickaxe_damage.get(), 2f, 3F, SConfig.SERVER.inf_pickaxe_durability.get(), 5);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        if (player instanceof ServerPlayer serverPlayer) {
            lookForOres(pos,level,serverPlayer);
        }
        return super.useOn(context);
    }
    private void lookForOres(BlockPos blockPos, Level level, ServerPlayer player){
        AABB aabb = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), 35, 35, 35);
        BlockState state = null;
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            if (level.getBlockState(blockpos).is(TagKey.create(Registries.BLOCK,new ResourceLocation("forge:ores")))){
                if (player.getRandom().nextFloat() < 0.3f){
                    state = level.getBlockState(blockpos);
                    break;
                }
            }
        }
        if (state == null){
            player.displayClientMessage(Component.translatable("inf_pickaxe_no_ores"),true);
        }else {
            Component component = Component.translatable(state.getBlock().getDescriptionId());
            Component component1 = Component.translatable("inf_pickaxe_found_ores");
            String string = component1.getString() + component.getString();
            player.displayClientMessage(Component.literal(string),true);
        }
        player.getCooldowns().addCooldown(this,40);
    }

}
