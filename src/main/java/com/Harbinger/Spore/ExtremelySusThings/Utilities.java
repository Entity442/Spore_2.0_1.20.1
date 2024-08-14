package com.Harbinger.Spore.ExtremelySusThings;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.ai.util.RandomPos;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


public class Utilities {
    public static void explodeCircle(ServerLevel level, Entity owner, BlockPos pos, double range, float damage,double blockHardness,Predicate<Entity> predicate) {
        explodeCircle(level,owner,pos,range,damage, ParticleTypes.EXPLOSION_EMITTER,false,blockHardness,predicate);
    }

    public static void explodeCircle(ServerLevel level, Entity owner, BlockPos pos, double range, float damage, ParticleOptions particleTypes, boolean dropItems,double blockHardness,Predicate<Entity> predicate){
        for(int i = 0; i <= 2*range; ++i) {
            for(int j = 0; j <= 2*range; ++j) {
                for(int k = 0; k <= 2*range; ++k) {
                    double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                    if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                        if (distance<range+(0.5)){
                            BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                            RandomSource source = RandomSource.create();
                            BlockState state = level.getBlockState(blockpos);
                            if ((state.getDestroySpeed(level,blockpos) <= blockHardness && state.getDestroySpeed(level,blockpos) >=0) && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(level, owner)){
                                level.removeBlock(blockpos,dropItems);
                                if (Math.random() < 0.3){
                                    float value = source.nextFloat() * 0.05f;
                                    level.sendParticles(particleTypes,blockpos.getX(),blockpos.getY(),blockpos.getZ(),1,value,0,value,1);
                                }
                            }
                          }}}}}
        AABB searchbox = AABB.ofSize(new Vec3(pos.getX(), pos.getY(), pos.getZ()), range*2, range*2, range*2);
        List<Entity> entities = level.getEntities(owner,searchbox, predicate);
        for (Entity entity : entities){
            entity.hurt(level.damageSources().mobAttack((LivingEntity) owner),damage);
        }
        level.playSound(null,pos, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS);
    }
    public static void convertBlocks(ServerLevel level, Entity owner, BlockPos pos, double range, BlockState state){
        for(int i = 0; i <= 2*range; ++i) {
            for(int j = 0; j <= 2*range; ++j) {
                for(int k = 0; k <= 2*range; ++k) {
                    double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                    if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                        if (distance<range+(0.5)){
                            BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(level, owner) && Math.random() < 0.2f){
                                if (level.getBlockState(blockpos).isAir() && level.getBlockState(blockpos.below()).isSolidRender(level,blockpos)){
                                    level.setBlock(blockpos,state,3);
                                }
                            }
                        }}}}}
    }


    public static Predicate<LivingEntity> TARGET_SELECTOR = (entity) -> {
        if (entity instanceof Infected || entity instanceof UtilityEntity){
            return false;
        }else if ((entity instanceof AbstractFish || entity instanceof Animal) && !SConfig.SERVER.at_an.get()){
            return false;
        }else if (!SConfig.SERVER.blacklist.get().isEmpty()){
            for(String string : SConfig.SERVER.blacklist.get()){
                if (string.endsWith(":") && entity.getEncodeId() != null){
                    String[] mod = string.split(":");
                    String[] iterations = entity.getEncodeId().split(":");
                    if (Objects.equals(mod[0], iterations[0])){
                        return false;
                    }
                }
            }
            return !SConfig.SERVER.blacklist.get().contains(entity.getEncodeId());
        }
        return true;
    };

    public static BlockPos generateRandomPosTowardDirection(BlockPos pos1, int value, RandomSource source, BlockPos pos) {
        int i = pos.getX();
        int j = pos.getZ();
        if (value > 1) {
            if (pos1.getX() > (double) pos.getX()) {
                i -= source.nextInt(value / 2);
            } else {
                i += source.nextInt(value / 2);
            }

            if (pos1.getZ() > (double) pos.getZ()) {
                j -= source.nextInt(value / 2);
            } else {
                j += source.nextInt(value / 2);
            }
        }
        return BlockPos.containing((double)i + pos1.getX(), (double)pos.getY() + pos1.getY(), (double)j + pos1.getZ());
    }
}
