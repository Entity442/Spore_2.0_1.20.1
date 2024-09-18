package com.Harbinger.Spore.Sentities.AI;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class ClimberMovement extends MoveControl {
    private final float maxClampDist;
    private final float minClampDist;
    private final float multiplier;
    public ClimberMovement(Mob mob, float maxClampDist, float minClampDist, float multiplier) {
        super(mob);
        this.maxClampDist = maxClampDist;
        this.minClampDist = minClampDist;
        this.multiplier = multiplier;
    }

    private void clampToSurfaceOrDrop() {
        float maxDistSq = maxClampDist * maxClampDist;
        float minDistSq = maxDistSq;
        Vec3 yank = Vec3.ZERO;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    if (!(i == 0 && j == 0 && k == 0)) {
                        float d = raycastDistSq(new Vec3(i, j, k));
                        if (d < maxDistSq) {
                            yank = yank.add(i, j, k);
                            if (d < minDistSq) {
                                minDistSq = d;
                            }
                        }
                    }
                }
            }
        }

        if (minDistSq > minClampDist * minClampDist){
            mob.setDeltaMovement(mob.getDeltaMovement().add(yank.scale(multiplier * minDistSq)));
        }

        mob.setNoGravity(minDistSq < maxDistSq);
    }

    private float raycastDistSq(Vec3 direction) {
        Vec3 start = mob.position().add(0.0D, mob.getBbHeight() / 2.0D, 0.0D);
        Vec3 end = start.add(direction.scale(maxClampDist));

        BlockHitResult result = mob.level().clip(new ClipContext(start, end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, mob));
        return (float)result.getLocation().distanceToSqr(start);
    }

    @Override
    public void tick() {
        super.tick();
        if (mob.getTarget() != null && mob.getTarget().getY() <= this.mob.getY()){
            mob.setNoGravity(false);
            return;
        }else {
            if ((mob.horizontalCollision || mob.verticalCollision) && !mob.onGround()) {
                this.clampToSurfaceOrDrop();
            }
        }
    }

}
