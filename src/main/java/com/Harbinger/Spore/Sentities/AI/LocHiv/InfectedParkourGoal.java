package com.Harbinger.Spore.Sentities.AI.LocHiv;

import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Optional;
import java.util.function.BiPredicate;

public class InfectedParkourGoal extends Goal {
    protected final float maxJumpVelocity;
    private final Infected mob;
    private final BiPredicate<Mob, BlockPos> acceptableLandingSpot = InfectedParkourGoal::defaultAcceptableLandingSpot;
    public JumpPhases phase;
    protected Optional<Vec3> initialPosition = Optional.empty();
    @Nullable
    protected Vec3 chosenJump;
    protected BlockPos posToJump;
    protected int findJumpTries;
    protected int failedToFindJumpCounter;
    protected long tryAgainTime;
    private int lookTime;

    public InfectedParkourGoal(Infected mob) {
        this.mob = mob;
        this.maxJumpVelocity = 1.5F;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
    }

    public static <E extends Mob> boolean defaultAcceptableLandingSpot(E mob, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return mob instanceof PathfinderMob && GoalUtils.isSolid((PathfinderMob) mob, blockpos);
    }

    @Override
    public boolean canUse() {
        if (this.mob.onGround() && mob.getLinked()) {
            Path path = this.mob.getNavigation().getPath();
            return this.mob.getNavigation().isInProgress() && path != null && !path.canReach() && (this.mob.level().getGameTime() - tryAgainTime > 30L);
        } else {
            return false;
        }
    }

    @Override
    public boolean canContinueToUse() {
        boolean flag = this.initialPosition.isPresent() && this.findJumpTries > 0 && !mob.isInWaterOrBubble() && this.chosenJump != null  && this.phase != JumpPhases.END;
        return flag && this.failedToFindJumpCounter <= 5;
    }

    @Override
    public void start() {
        this.phase = JumpPhases.NONE;
        this.chosenJump = null;
        this.findJumpTries = 20;
        this.initialPosition = Optional.of(mob.position());
        if (this.mob.getNavigation().getTargetPos() != null){
            Vec3 pos = Vec3.atCenterOf(this.mob.getNavigation().getTargetPos());
            this.mob.getLookControl().setLookAt(pos.x, this.mob.getEyeY(), pos.z, 90.0F, 90.0F);
            this.mob.setYRot(this.mob.getYHeadRot());
            this.pickCandidate(mob, this.mob.getNavigation().getTargetPos());
        }
    }

    @Override
    public void tick() {
        if (this.phase == JumpPhases.LOOK_AT_BLOCK) {
            if (this.lookTime > 0)
                --this.lookTime;
            if (this.posToJump != null) {
                Vec3 pos = Vec3.atCenterOf(posToJump);
                this.lookAt(pos, 30.0F, 30.0F);
                this.mob.setYBodyRot(this.mob.yHeadRot);
            }
            if (this.lookTime <= 0)
                this.phase = JumpPhases.JUMP;
        } else if (this.phase == JumpPhases.JUMP) {
            if (this.chosenJump != null) {
                this.leapTowards(mob, this.mob.position().add(this.chosenJump), this.chosenJump.length(), 0.0F);
                this.mob.getJumpControl().jump();
                this.phase = JumpPhases.END;
            }
        } else {
            --this.findJumpTries;
        }
    }

    public void lookAt(Vec3 vec3, float pMaxYRotIncrease, float pMaxXRotIncrease) {
        double d0 = vec3.x() - this.mob.getX();
        double d2 = vec3.z() - this.mob.getZ();
        double d1 = vec3.y() - this.mob.getEyeY();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        float f = (float) (Mth.atan2(d2, d0) * 57.2957763671875) - 90.0F;
        float f1 = (float) (-(Mth.atan2(d1, d3) * 57.2957763671875));
        this.mob.setXRot(this.rotlerp(this.mob.getXRot(), f1, pMaxXRotIncrease));
        this.mob.setYRot(this.rotlerp(this.mob.getYRot(), f, pMaxYRotIncrease));
    }

    private float rotlerp(float pAngle, float pTargetAngle, float pMaxIncrease) {
        float f = Mth.wrapDegrees(pTargetAngle - pAngle);
        if (f > pMaxIncrease) {
            f = pMaxIncrease;
        }

        if (f < -pMaxIncrease) {
            f = -pMaxIncrease;
        }

        return pAngle + f;
    }


    @Override
    public void stop() {
        this.phase = JumpPhases.END;
        this.tryAgainTime = this.mob.level().getGameTime();
        this.failedToFindJumpCounter = 0;
    }

    protected void pickCandidate(Mob pEntity, BlockPos block) {
        for (BlockPos pos : BlockPos.betweenClosed(pEntity.blockPosition(), block)) {
            BlockPos jumpPos = pEntity.blockPosition().closerThan(pos, 3.0D) ? pos : block;
            if (this.isAcceptableLandingPosition(pEntity, jumpPos)) {
                Vec3 vec3 = Vec3.atCenterOf(jumpPos);
                Vec3 vec31 = this.calculateJumpVector(pEntity, vec3);
                if (vec31 != null) {
                    this.lookAt(vec3, 30.0F, 30.0F);
                    this.mob.setYBodyRot(this.mob.yHeadRot);
                    this.posToJump = jumpPos;
                    this.chosenJump = vec31;
                    if (this.phase == JumpPhases.NONE) {
                        this.lookTime = 5;
                        this.phase = JumpPhases.LOOK_AT_BLOCK;
                    }
                }
            } else {
                this.failedToFindJumpCounter++;
            }
        }
    }

    private boolean isAcceptableLandingPosition(Mob pEntity, BlockPos pPos) {
        BlockPos blockpos = pEntity.blockPosition();
        int i = blockpos.getX();
        int j = blockpos.getZ();
        return (i != pPos.getX() || j != pPos.getZ()) && this.acceptableLandingSpot.test(pEntity, pPos);
    }


    @Nullable
    private Vec3 calculateJumpVector(Mob pMob, Vec3 pTarget) {
        Vec3 vec3 = this.mob.getDeltaMovement();
        Vec3 vec31 = new Vec3(pTarget.x() - pMob.getX(), maxJumpVelocity, pTarget.z() - pMob.getZ());
        if (vec31.lengthSqr() > 1.0E-7D) {
            vec31 = vec31.normalize().scale(0.5D).add(vec3.scale(1.5D));
        }
        return vec31;
    }

    private void leapTowards(LivingEntity entity, Vec3 target, double horzVel, double yVel) {
        Vec3 dir = target.subtract(entity.position()).normalize();
        Vec3 leap = new Vec3(dir.x, 0.0, dir.z).normalize().scale(horzVel).yRot((float) yVel);
        float clampedYVelocity = (float) (entity.getDeltaMovement().y() < 0.1D ? leap.y : 0.0D);

        Vec3 horzVelocity = entity.getDeltaMovement().add(leap.x, 0.0, leap.z);
        double scale = horzVel / horzVelocity.length();
        if (scale < 1.0D) {
            horzVelocity = horzVelocity.scale(scale);
        }
        ((Mob) entity).getLookControl().setLookAt(target);
        entity.setDeltaMovement(horzVelocity.yRot(clampedYVelocity));
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public enum JumpPhases {
        NONE,
        LOOK_AT_BLOCK,
        JUMP,
        END
    }
}
