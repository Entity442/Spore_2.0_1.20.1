package com.Harbinger.Spore.Sentities.MovementControls;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.phys.Vec3;

public class WaterXlandMovement extends MoveControl {
    private final Mob mob;
    public WaterXlandMovement(Mob mob) {
        super(mob);
        this.mob = mob;
    }

    public void tick() {
        LivingEntity livingentity = this.mob.getTarget();
        if (this.mob.isInFluidType()) {
            if (livingentity != null && this.mob.getRandom().nextInt(5) == 0) {
                double d0 = livingentity.getX() - this.mob.getX();
                double d1 = livingentity.getY() - this.mob.getY();
                double d2 = livingentity.getZ() - this.mob.getZ();
                this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(new Vec3(d0, d1, d2).normalize().scale(0.06D)));
            }

            if (this.operation != MoveControl.Operation.MOVE_TO || this.mob.getNavigation().isDone()) {
                this.mob.setSpeed(0.0F);
                return;
            }

            double d0 = this.wantedX - this.mob.getX();
            double d1 = this.wantedY - this.mob.getY();
            double d2 = this.wantedZ - this.mob.getZ();
            double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
            d1 /= d3;
            float f = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), f, 90.0F));
            this.mob.yBodyRot = this.mob.getYRot();
            float f1 = (float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED));
            float f2 = Mth.lerp(0.125F, this.mob.getSpeed(), f1);
            this.mob.setSpeed(f2);
            this.mob.setDeltaMovement(this.mob.getDeltaMovement().add((double)f2 * d0 * 0.005D, (double)f2 * d1 * 0.1D, (double)f2 * d2 * 0.005D));
        } else {
            super.tick();
        }

    }
}