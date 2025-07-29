package com.Harbinger.Spore.Sentities.MovementControls;

import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;

public class UndergroundMovementControl extends CalamityMovementControl {
    public UndergroundMovementControl(Mob mob) {
        super(mob, 30);
    }

    @Override
    public void tick() {
        moveUnderground();
        mob.setNoGravity(isInWall(mob));
    }

    boolean isInWall(LivingEntity mob){
        float f = mob.getBbWidth() * 0.8F;
        AABB aabb = AABB.ofSize(mob.getEyePosition().add(0,-0.05,0), (double)f, 1.0E-6, (double)f);
        return BlockPos.betweenClosedStream(aabb).anyMatch((p_201942_) -> {
            BlockState blockstate = mob.level().getBlockState(p_201942_);
            return !blockstate.isAir() && blockstate.isSuffocating(mob.level(), p_201942_) && Shapes.joinIsNotEmpty(blockstate.getCollisionShape(mob.level(), p_201942_).move((double)p_201942_.getX(), (double)p_201942_.getY(), (double)p_201942_.getZ()), Shapes.create(aabb), BooleanOp.AND);
        });
    }

    public void moveUnderground() {
        if (this.operation == MoveControl.Operation.MOVE_TO) {
            Vec3 vec3 = new Vec3(this.wantedX - this.mob.getX(), this.wantedY - this.mob.getY(), this.wantedZ - this.mob.getZ());
            vec3 = vec3.normalize();
            vec3 = isInWall(mob) ? vec3 : vec3.multiply(1,0,1);
            double speed = mob instanceof Hohlfresser hohlfresser && hohlfresser.isUnderground() ? 0.05D : 0.15D;
            this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(vec3.scale(speed)));
            float yaw = (float)(Mth.atan2(vec3.z, vec3.x) * (180F / Math.PI)) - 90.0F;
            mob.setYRot(yaw);
            mob.setYHeadRot(yaw);
        }else {
            operation = Operation.WAIT;
        }
        if (this.operation == Operation.WAIT){
            if (!this.hasWanted() && this.mob.getTarget() == null){
                this.mob.setDeltaMovement(Vec3.ZERO);
                mob.setYRot(0);
                mob.setYHeadRot(0);
            }
        }
    }
}
