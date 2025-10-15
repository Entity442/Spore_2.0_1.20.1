package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Tentacle extends Organoid {
    private static final int SEGMENTS = 6;
    private Vec3 targetPosition;
    private float tentacleTime = 0;
    private final TentaclePart[] partArray;
    public Tentacle(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        targetPosition = this.position();
        TentaclePart part0 = new TentaclePart(this, "segment0", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part1 = new TentaclePart(this, "segment1", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part2 = new TentaclePart(this, "segment2", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part3 = new TentaclePart(this, "segment3", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part4 = new TentaclePart(this, "segment4", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part5 = new TentaclePart(this, "segment5", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        this.partArray = new TentaclePart[]{part0, part1, part2, part3, part4, part5};
        this.setId(ENTITY_COUNTER.getAndAdd(this.partArray.length + 1) + 1);
    }
    @Override
    public void setId(int p_20235_) {
        super.setId(p_20235_);
        for (int i = 0; i < this.partArray.length; i++)
            this.partArray[i].setId(p_20235_ + i + 1);
    }
    public Vec3 getTargetPosition() {
        return targetPosition;
    }
    public TentaclePart[] getSegments(){return partArray;}
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.mound_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.mound_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }
    public void recreateFromPacket(ClientboundAddEntityPacket clientboundAddEntityPacket) {
        super.recreateFromPacket(clientboundAddEntityPacket);
        for(int i = 0; i < partArray.length; ++i) {
            partArray[i].setId(i + clientboundAddEntityPacket.getId());
        }

    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.partArray;
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
            targetPosition = this.getTarget() == null ?  Utilities.generatePositionAway(this.position().add(0,5,0),6) : this.getTarget().position();
        }
        applyIK();
    }

    @Override
    public void moveTo(double x, double y, double z, float p_20111_, float p_20112_) {
        super.moveTo(x, y, z, p_20111_, p_20112_);
    }

    private void applyIK() {
        if (getSegments() == null) return;
        partArray[SEGMENTS - 1].smoothMove(targetPosition,tentacleTime,SEGMENTS - 1);

        for (int i = SEGMENTS - 2; i >= 0; i--) {
            Vec3 nextPos = partArray[i + 1].position();
            Vec3 currentPos = partArray[i].position();

            Vec3 direction = nextPos.subtract(currentPos).normalize();
            Vec3 newPos = nextPos.subtract(direction.scale(partArray[i].length));

            partArray[i].smoothMove(newPos,tentacleTime,i);
        }
        partArray[0].smoothMove(this.position(),tentacleTime,0);
        for (int i = 1; i < SEGMENTS; i++) {
            Vec3 prevPos = partArray[i - 1].position();
            Vec3 currentPos = partArray[i].position();

            Vec3 direction = currentPos.subtract(prevPos).normalize();
            Vec3 newPos = prevPos.add(direction.scale(partArray[i].length));

            partArray[i].smoothMove(newPos,tentacleTime,i);
        }
    }

    public boolean hurt(TentaclePart tentaclePart, DamageSource source, float amount) {
        return this.hurt(source,amount * 0.25f);
    }
}

