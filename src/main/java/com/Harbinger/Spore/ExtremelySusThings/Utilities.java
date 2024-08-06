package com.Harbinger.Spore.ExtremelySusThings;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;
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
                            float destrySpeed = level.getBlockState(pos).getDestroySpeed(level,blockpos);
                            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(level, owner) && destrySpeed <= blockHardness && destrySpeed >=0){
                                level.removeBlock(blockpos,dropItems);
                            }
                            float value = source.nextFloat() * 0.05f;
                            level.sendParticles(particleTypes,blockpos.getX(),blockpos.getY(),blockpos.getZ(),1,value,0,value,1);
                        }}}}}
        AABB searchbox = AABB.ofSize(new Vec3(pos.getX(), pos.getY(), pos.getZ()), range*2, range*2, range*2);
        List<Entity> entities = level.getEntities(owner,searchbox, predicate);
        for (Entity entity : entities){
            entity.hurt(owner.damageSources().explosion(null),damage);
        }
        level.playSound(null,pos, SoundEvents.GENERIC_EXPLODE, SoundSource.MASTER);
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

}
