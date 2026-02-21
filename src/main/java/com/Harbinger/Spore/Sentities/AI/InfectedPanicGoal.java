package com.Harbinger.Spore.Sentities.AI;

import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class InfectedPanicGoal extends Goal {
    protected final Infected mob;
    protected final double speedModifier;
    protected double posX;
    protected double posY;
    protected double posZ;

    public InfectedPanicGoal(Infected mob, double s) {
        this.mob = mob;
        this.speedModifier = s;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean canUse() {
        if (!this.shouldPanic()) {
            return false;
        } else {
            if (this.mob.isOnFire()) {
                BlockPos blockpos = this.lookForWater(this.mob.level(), this.mob, 8);
                if (blockpos != null) {
                    this.posX = blockpos.getX();
                    this.posY = blockpos.getY();
                    this.posZ = blockpos.getZ();
                    return true;
                }
            }else if (this.mob.isStarving()) {
                BlockPos blockpos = this.lookForBodies(this.mob.level(), this.mob, 10);
                if (blockpos != null) {
                    this.posX = blockpos.getX();
                    this.posY = blockpos.getY();
                    this.posZ = blockpos.getZ();
                    return true;
                }
            }

            return this.findRandomPosition();
        }
    }

    protected boolean shouldPanic() {
        return  this.mob.isFreezing() || this.mob.isOnFire() || this.mob.isStarving() || this.mob.getLastDamageSource() == mob.damageSources().inWall();
    }

    protected boolean findRandomPosition() {
        Vec3 vec3 = DefaultRandomPos.getPos(this.mob, 5, 4);
        if (vec3 == null) {
            return false;
        } else {
            this.posX = vec3.x;
            this.posY = vec3.y;
            this.posZ = vec3.z;
            return true;
        }
    }

    public void start() {
        this.mob.getNavigation().moveTo(this.posX, this.posY, this.posZ, this.speedModifier);
    }



    public boolean canContinueToUse() {
        return !this.mob.getNavigation().isDone();
    }

    @Nullable
    protected BlockPos lookForWater(BlockGetter getter, Entity entity, int distance) {
        BlockPos blockpos = entity.blockPosition();
        return !getter.getBlockState(blockpos).getCollisionShape(getter, blockpos).isEmpty() ? null : BlockPos.findClosestMatch(entity.blockPosition(), distance, 1, (p_196649_) -> {
            return getter.getFluidState(p_196649_).is(FluidTags.WATER);
        }).orElse(null);
    }

    @Nullable
    protected BlockPos lookForBodies(BlockGetter getter, Entity entity, int distance) {
        BlockPos blockpos = entity.blockPosition();
        return !getter.getBlockState(blockpos).getCollisionShape(getter, blockpos).isEmpty() ? null : BlockPos.findClosestMatch(entity.blockPosition(), distance, 1, (p_196649_) -> {
            return getter.getBlockState(p_196649_).is(Sblocks.REMAINS.get()) || getter.getBlockState(p_196649_).is(Sblocks.BIOMASS_BULB.get()) || getter.getBlockState(p_196649_).is(Sblocks.DROWNED_LUMP.get()) || getter.getBlockState(p_196649_).is(Sblocks.WALL_REMAINS.get());
        }).orElse(null);
    }
}
