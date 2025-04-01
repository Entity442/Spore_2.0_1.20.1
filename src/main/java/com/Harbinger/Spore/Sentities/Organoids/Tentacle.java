package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Client.TentacleSegment;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class Tentacle extends Organoid {
    private static final int SEGMENTS = 8;
    private final List<TentacleSegment> segments = new ArrayList<>();
    private Vec3 targetPosition;
    private float tentacleTime = 0;
    public Tentacle(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        targetPosition = this.position();
        for (int i = 0; i < SEGMENTS; i++) {
            segments.add(new TentacleSegment(this.position(), 1.0f));
        }
    }
    public Vec3 getTargetPosition() {
        return targetPosition;
    }
    public List<TentacleSegment> getSegments(){return segments;}
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.mound_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.mound_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    @Override
    protected void registerGoals() {
        addTargettingGoals();
        super.registerGoals();
    }

    @Override
    public void tick() {
        super.tick();
        tentacleTime += 0.05f;
        if (tickCount % 80 == 0){
            targetPosition = Utilities.generatePositionAway(this.position(),6);
        }
        applyIK();
    }

    private void applyIK() {
        if (segments.isEmpty()) return;

        segments.get(SEGMENTS - 1).smoothMove(targetPosition,tentacleTime,SEGMENTS - 1);

        for (int i = SEGMENTS - 2; i >= 0; i--) {
            Vec3 nextPos = segments.get(i + 1).position;
            Vec3 currentPos = segments.get(i).position;

            Vec3 direction = nextPos.subtract(currentPos).normalize();
            Vec3 newPos = nextPos.subtract(direction.scale(segments.get(i).length));

            segments.get(i).smoothMove(newPos,tentacleTime,i);
        }
        segments.get(0).smoothMove(this.position(),tentacleTime,0);
        for (int i = 1; i < SEGMENTS; i++) {
            Vec3 prevPos = segments.get(i - 1).position;
            Vec3 currentPos = segments.get(i).position;

            Vec3 direction = currentPos.subtract(prevPos).normalize();
            Vec3 newPos = prevPos.add(direction.scale(segments.get(i).length));

            segments.get(i).smoothMove(newPos,tentacleTime,i);
        }
    }
}

