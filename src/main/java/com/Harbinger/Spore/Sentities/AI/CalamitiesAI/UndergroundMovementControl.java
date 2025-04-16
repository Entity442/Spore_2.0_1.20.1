package com.Harbinger.Spore.Sentities.AI.CalamitiesAI;

import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.phys.Vec3;

public class UndergroundMovementControl extends MoveControl {
    private final float swimspeed;
    public UndergroundMovementControl(Mob mob, float swimspeed) {
        super(mob);
        this.swimspeed = swimspeed;
    }

    @Override
    public void tick() {
        if (this.mob instanceof Hohlfresser worm && worm.canGoUnderground()) {
            Vec3 direction = new Vec3(this.wantedX - mob.getX(), this.wantedY - mob.getY(), this.wantedZ - mob.getZ());
            Vec3 normalized = direction.normalize().scale(swimspeed);
            this.mob.setDeltaMovement(normalized);
            this.mob.setYRot((float)(Mth.atan2(normalized.z, normalized.x) * (180F / Math.PI)) - 90.0F);
            this.mob.setXRot((float)(-Mth.atan2(normalized.y, Math.sqrt(normalized.x * normalized.x + normalized.z * normalized.z)) * (180F / Math.PI)));
        } else {
            super.tick(); // Fall back to normal movement
        }
    }
}
