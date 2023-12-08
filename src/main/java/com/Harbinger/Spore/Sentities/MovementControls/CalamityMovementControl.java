package com.Harbinger.Spore.Sentities.MovementControls;

import com.Harbinger.Spore.Sentities.WaterInfected;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class CalamityMovementControl extends MoveControl {
    private final int maxTurn;

    public CalamityMovementControl(Mob mob, int maxTurn) {
        super(mob);
        this.maxTurn = maxTurn;
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
                float f2 = (float)(-(Mth.atan2(d1, d4) * (double)(180F / (float)Math.PI)));
                this.mob.setXRot(this.rotlerp(this.mob.getXRot(), f2, (float)this.maxTurn));
                this.mob.setYya(d1 > 0.0D ? f1 : -f1);
            }
        }
        if (this.mob instanceof WaterInfected && this.mob.isInFluidType()){
            if (mob.getRandom().nextInt(10)==0 && this.mob.horizontalCollision){
                this.mob.getJumpControl().jump();
            }
            if (this.wantedY > this.mob.getY()){
                this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0,0.01,0));
            }else{
                this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0,-0.01,0));
            }
        }
    }
}
