package com.Harbinger.Spore.Sentities.AI;

import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.ScatterShotRangedGoal;
import com.Harbinger.Spore.Sentities.Calamities.Hinderburg;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.pathfinder.Path;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class AerialRangedGoal extends ScatterShotRangedGoal {
    @Nullable
    protected Path path;
    protected final PathNavigation pathNav;
    public AerialRangedGoal(Hinderburg mob, double speed, int interval, float range, int min, int max) {
        super(mob, speed, interval, range, min, max);
        this.pathNav = mob.getNavigation();
        this.setFlags(EnumSet.of(Flag.MOVE));

    }
    public BlockPos getRandomPosition(){
        int x = this.mob.getBlockX() + this.mob.getRandom().nextInt(-20,20);
        int y = this.mob.getOnPos().getY();
        int z = this.mob.getBlockZ() + this.mob.getRandom().nextInt(-20,20);
        return new BlockPos(x,y,z);
    }
    @Override
    public boolean canUse() {
        if (this.target != null){
            double d0 = this.mob.distanceToSqr(this.target);
            if (this.mob.getSensing().hasLineOfSight(this.target) && d0 < (double)this.attackRadiusSqr){
                this.path = pathNav.createPath(getRandomPosition(),16);
            }else{
                this.path = pathNav.createPath(target,16);
            }
        }
        return super.canUse();
    }

    @Override
    public void tick() {
        if (this.target != null){
            double d0 = this.mob.distanceToSqr(this.target);
            boolean flag = this.mob.getSensing().hasLineOfSight(this.target);
            if (d0/4 < (double)this.attackRadiusSqr && d0/2 > (double)this.attackRadiusSqr) {
                this.Orbit(target);
            }
            if (this.mob.getY() < target.getY()+8 || d0/2 < (double)this.attackRadiusSqr){
                this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0,0.1,0));
            }

            this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
            if (--this.attackTime == 0) {
                if (mob instanceof Hinderburg hinderburg){
                    if (hinderburg.tryToSummonNUKE(target)){
                        hinderburg.tickBomb();
                    }
                }
                if (!flag) {
                    return;
                }
                RandomSource randomSource = RandomSource.create();
                int shot = randomSource.nextInt(this.minShots,this.maxShots + getExtraShots());

                float f = (float)Math.sqrt(d0) / this.attackRadius;
                float f1 = Mth.clamp(f, 0.1F, 1.0F);
                for (int i = 0; i<shot;++i){
                    this.rangedAttackMob.performRangedAttack(this.target, f1);
                }
                this.attackTime = Mth.floor(f * (float)(attackInterval) + (float)this.attackInterval);
            } else if (this.attackTime < 0) {
                this.attackTime = Mth.floor(Mth.lerp(Math.sqrt(d0) / (double)this.attackRadius, this.attackInterval, this.attackInterval));
            }
        }
    }

    private void Orbit(LivingEntity target) {
        mob.setDeltaMovement(mob.getDeltaMovement().multiply(0, 1, 0)
                .add(target.position().subtract(mob.position()).normalize().multiply(1, 0, 1)
                        .yRot(90)).scale(mob.getAttributeValue(Attributes.MOVEMENT_SPEED) * 1.5));
    }

    @Override
    public void start() {
        if (mob.tickCount % 40 == 0)
            this.mob.getNavigation().moveTo(path, this.speedModifier);
        super.start();
    }
}
