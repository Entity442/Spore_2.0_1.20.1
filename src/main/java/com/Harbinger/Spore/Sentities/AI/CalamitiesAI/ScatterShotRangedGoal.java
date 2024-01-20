package com.Harbinger.Spore.Sentities.AI.CalamitiesAI;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.RangedAttackMob;

import javax.annotation.Nullable;

public class ScatterShotRangedGoal extends Goal {
    protected final int minShots;
    protected final int maxShots;
    protected final Mob mob;
    protected final RangedAttackMob rangedAttackMob;
    @Nullable
    protected LivingEntity target;
    protected int attackTime = -1;
    protected final double speedModifier;
    protected int seeTime;
    protected final int attackInterval;
    protected final float attackRadius;
    protected final float attackRadiusSqr;
    public ScatterShotRangedGoal(RangedAttackMob mob, double speed, int interval, float range,int min , int max) {
        this.mob = (Mob) mob;
        this.rangedAttackMob = mob;
        this.speedModifier = speed;
        this.attackInterval=interval;
        this.attackRadius = range;
        this.attackRadiusSqr = range * range;
        this.minShots = min;
        this.maxShots = max;
    }

    public boolean canUse() {
        LivingEntity livingentity = this.mob.getTarget();
        if (livingentity != null && livingentity.isAlive()) {
            this.target = livingentity;
            return true;
        } else {
            return false;
        }
    }

    public boolean canContinueToUse() {
        return this.canUse() || this.target.isAlive() && !this.mob.getNavigation().isDone();
    }

    public void stop() {
        this.target = null;
        this.seeTime = 0;
        this.attackTime = -1;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }



    public void tick() {
        double d0 = this.mob.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());
        boolean flag = this.mob.getSensing().hasLineOfSight(this.target);
        if (flag) {
            ++this.seeTime;
        } else {
            this.seeTime = 0;
        }

        if (!(d0 > (double)this.attackRadiusSqr) && this.seeTime >= 5) {
            this.mob.getNavigation().stop();
        } else {
            this.mob.getNavigation().moveTo(this.target, this.speedModifier);
        }

        this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
        if (--this.attackTime == 0) {
            if (!flag) {
                return;
            }
            RandomSource randomSource = RandomSource.create();
            int shot = randomSource.nextInt(this.minShots,this.maxShots);

            float f = (float)Math.sqrt(d0) / this.attackRadius;
            float f1 = Mth.clamp(f, 0.1F, 1.0F);
            for (int i = 0; i<shot;++i){
                this.rangedAttackMob.performRangedAttack(this.target, f1);
            }
            this.attackTime = Mth.floor(f * (float)(attackInterval) + (float)this.attackInterval);
        } else if (this.attackTime < 0) {
            this.attackTime = Mth.floor(Mth.lerp(Math.sqrt(d0) / (double)this.attackRadius, (double)this.attackInterval, (double)this.attackInterval));
        }
    }
}
