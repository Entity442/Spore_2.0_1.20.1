package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.SBlockEntities.CDUBlockEntity;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporePickaxeItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class InfectedPickaxe extends SporePickaxeItems {
    public InfectedPickaxe() {
        super(SConfig.SERVER.inf_pickaxe_damage.get(), 2f, 3F, SConfig.SERVER.inf_pickaxe_durability.get(), 5);
    }
    record StoreDouble(Block value1, Block value2){}
    private List<StoreDouble> getBlockChange(){
        List<StoreDouble> blocks = new ArrayList<>();
        for (String str : SConfig.DATAGEN.block_infection.get()){
            String[] string = str.split("\\|" );
            Block blockCon1 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[0]));
            Block blockCon2 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[1]));
            if (blockCon1 != null && blockCon2 != null){
                blocks.add(new StoreDouble(blockCon1,blockCon2));
            }
        }
        return blocks;
    }
    public void changeBlock(Level level, BlockPos pos) {
        List<StoreDouble> values = getBlockChange();
        if (!values.isEmpty()) {
            BlockState state = level.getBlockState(pos);
            for (StoreDouble storeDouble : values){
                if (storeDouble.value1.equals(state.getBlock()) && !storeDouble.value1.defaultBlockState().isAir()){
                    level.setBlock(pos,storeDouble.value2.defaultBlockState(),2);
                    level.sendBlockUpdated(pos, storeDouble.value1.defaultBlockState(), storeDouble.value2.defaultBlockState(), 2);
                }
            }
        }
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
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity living, LivingEntity entity) {
        entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED,200,1));
        return super.hurtEnemy(stack, living, entity);
    }
    private void lookForOres(BlockPos start, Level level, ServerPlayer player){
        AABB searchArea = AABB.ofSize(new Vec3(start.getX(), start.getY(), start.getZ()), 35, 35, 35);
        BlockPos targetOrePos = null;
        for (BlockPos pos : BlockPos.betweenClosed(
                Mth.floor(searchArea.minX), Mth.floor(searchArea.minY), Mth.floor(searchArea.minZ),
                Mth.floor(searchArea.maxX), Mth.floor(searchArea.maxY), Mth.floor(searchArea.maxZ))) {
            if (level.getBlockState(pos).is(TagKey.create(Registries.BLOCK,new ResourceLocation("forge:ores")))){
                if (player.getRandom().nextFloat() < 0.3f){
                    targetOrePos = pos;
                    break;
                }
            }
        }

        if (targetOrePos == null) {
            player.displayClientMessage(Component.translatable("inf_pickaxe_no_ores"), true);
            return;
        }else {
            Component component = Component.translatable(level.getBlockState(targetOrePos).getBlock().getDescriptionId());
            Component component1 = Component.translatable("inf_pickaxe_found_ores");
            String string = component1.getString() + component.getString();
            player.displayClientMessage(Component.literal(string),true);

            Vec3 startVec = new Vec3(start.getX(), start.getY(), start.getZ());
            Vec3 endVec = new Vec3(targetOrePos.getX(), targetOrePos.getY(), targetOrePos.getZ());
            Vec3 direction = endVec.subtract(startVec).normalize();
            double distance = startVec.distanceTo(endVec);
            for (int i = 0; i <= distance; i++) {
                Vec3 current = startVec.add(direction.scale(i));
                BlockPos pos = new BlockPos((int) current.x,(int) current.y,(int)current.z);
                changeBlock(level, pos);
            }
        }
        player.getCooldowns().addCooldown(this,40);
    }
    private List<BlockPos> getLine(BlockPos start, BlockPos end) {
        List<BlockPos> line = new ArrayList<>();

        int x1 = start.getX(), y1 = start.getY(), z1 = start.getZ();
        int x2 = end.getX(), y2 = end.getY(), z2 = end.getZ();

        int dx = Math.abs(x2 - x1), dy = Math.abs(y2 - y1), dz = Math.abs(z2 - z1);
        int xs = Integer.compare(x2, x1), ys = Integer.compare(y2, y1), zs = Integer.compare(z2, z1);

        int px, py, pz;
        int ax = dx * 2, ay = dy * 2, az = dz * 2;

        if (dx >= dy && dx >= dz) {
            py = ay - dx;
            pz = az - dx;
            while (x1 != x2) {
                line.add(new BlockPos(x1, y1, z1));
                x1 += xs;
                if (py >= 0) {
                    y1 += ys;
                    py -= ax;
                }
                if (pz >= 0) {
                    z1 += zs;
                    pz -= ax;
                }
                py += ay;
                pz += az;
            }
        } else if (dy >= dx && dy >= dz) {
            px = ax - dy;
            pz = az - dy;
            while (y1 != y2) {
                line.add(new BlockPos(x1, y1, z1));
                y1 += ys;
                if (px >= 0) {
                    x1 += xs;
                    px -= ay;
                }
                if (pz >= 0) {
                    z1 += zs;
                    pz -= ay;
                }
                px += ax;
                pz += az;
            }
        } else {
            px = ax - dz;
            py = ay - dz;
            while (z1 != z2) {
                line.add(new BlockPos(x1, y1, z1));
                z1 += zs;
                if (px >= 0) {
                    x1 += xs;
                    px -= az;
                }
                if (py >= 0) {
                    y1 += ys;
                    py -= az;
                }
                px += ax;
                py += ay;
            }
        }

        line.add(end);
        return line;
    }
}
