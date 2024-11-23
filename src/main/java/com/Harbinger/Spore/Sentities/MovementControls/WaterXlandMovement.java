package com.Harbinger.Spore.Sentities.MovementControls;

import com.Harbinger.Spore.Sentities.WaterInfected;
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

    @Override
    public void tick() {
        super.tick();
        if (this.operation == MoveControl.Operation.MOVE_TO) {
            this.operation = MoveControl.Operation.WAIT;
            double d0 = this.wantedX - this.mob.getX();
            double d1 = this.wantedY - this.mob.getY();
            double d2 = this.wantedZ - this.mob.getZ();
            double d4 = Math.sqrt(d0 * d0 + d2 * d2);
            float f = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), f, 90.0F));
            float f1 = (float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED));

            if (Math.abs(d1) > (double)1.0E-5F || Math.abs(d4) > (double)1.0E-5F) {
                this.mob.setYya(d1 > 0.0D ? f1 : -f1);
            }
        }
        if ((this.mob instanceof WaterInfected && this.mob.isInFluidType())){
            if (this.wantedY > this.mob.getY()){
                this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0,0.01,0));
            }else{
                this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0,-0.01,0));
            }
        }
    }
}