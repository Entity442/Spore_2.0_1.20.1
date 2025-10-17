package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Tentacle extends UtilityEntity {
    private Vec3 targetPositionFrontRight;
    private Vec3 targetPositionFrontLeft;
    private Vec3 targetPositionBackRight;
    private Vec3 targetPositionBackLeft;
    private Vec3 lastFrontRight;
    private Vec3 lastFrontLeft;
    private Vec3 lastBackRight;
    private Vec3 lastBackLeft;
    private final TentaclePart[] partArrayRight;
    private final TentaclePart[] partArrayLeft;
    private final TentaclePart[] partArrayBackRight;
    private final TentaclePart[] partArrayBackLeft;
    private final TentaclePart[] completeArray;
    private final TentaclePart part2;
    private final TentaclePart part5;
    private final TentaclePart part8;
    private final TentaclePart part11;
    public Tentacle(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);

        TentaclePart part0 = new TentaclePart(this, "segment0", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part1 = new TentaclePart(this, "segment1", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        part2 = new TentaclePart(this, "segment2", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part3 = new TentaclePart(this, "segment3", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part4 = new TentaclePart(this, "segment4", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        part5 = new TentaclePart(this, "segment5", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        this.partArrayRight = new TentaclePart[]{part0, part1, part2};
        this.partArrayLeft = new TentaclePart[]{part3, part4, part5};
        TentaclePart part6 = new TentaclePart(this, "segment6", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part7 = new TentaclePart(this, "segment7", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        part8 = new TentaclePart(this, "segment8", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part9 = new TentaclePart(this, "segment9", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part10 = new TentaclePart(this, "segment10", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        part11 = new TentaclePart(this, "segment11", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        this.partArrayBackRight = new TentaclePart[]{part6, part7, part8};
        this.partArrayBackLeft = new TentaclePart[]{part9, part10, part11};
        this.completeArray = new TentaclePart[]{
                part0, part1, part2, part3, part4, part5,
                part6, part7, part8, part9, part10, part11
        };

        int baseId = ENTITY_COUNTER.getAndAdd(this.completeArray.length + 1);
        this.setId(baseId);
        setMaxUpStep(1f);
    }
    public enum LEGS{
        RIGHT_FRONT(new Vec3(1.5, 2, -1.5), new Vec3(6.5, 0, -6.5)),   // Front right
        LEFT_FRONT(new Vec3(1.5, 2, 1.5), new Vec3(6.5, 0, 6.5)),  // Front left
        RIGHT_BACK(new Vec3(-1.5, 2, -1.5), new Vec3(-6.5, 0, -6.5)),      // Back right
        LEFT_BACK(new Vec3(-1.5, 2, 1.5), new Vec3(-6.5, 0, 6.5));     // Back left

        private final Vec3 bodySet;
        private final Vec3 offset;

        LEGS(Vec3 bodySet, Vec3 offset) {
            this.bodySet = bodySet;
            this.offset = offset;
        }

        public Vec3 getOffset(){
            return offset;
        }
        public Vec3 getBodySet(){
            return bodySet;
        }
    }

    @Override
    public void setId(int entityId) {
        super.setId(entityId);
        for (int i = 0; i < this.completeArray.length; i++) {
            this.completeArray[i].setId(entityId + i + 1);
        }
    }
    public TentaclePart[] getRightSegments(){return partArrayRight;}
    public TentaclePart[] getLeftSegments(){return partArrayLeft;}
    public TentaclePart[] getRightBackSegments(){return partArrayBackRight;}
    public TentaclePart[] getLeftBackSegments(){return partArrayBackLeft;}

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.mound_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.mound_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.MOVEMENT_SPEED, 0.2);

    }
    public Vec3 getLegBasePos(LEGS legs){
        Vec3 offset = legs.getOffset();
        // Rotate the offset around the entity's position
        float yRotRad = -this.getYRot() * ((float)Math.PI / 180F);
        double rotatedX = offset.x * Math.cos(yRotRad) - offset.z * Math.sin(yRotRad);
        double rotatedZ = offset.x * Math.sin(yRotRad) + offset.z * Math.cos(yRotRad);
        return this.position().add(rotatedX, offset.y, rotatedZ);
    }

    public Vec3 getBodyBasePos(LEGS legs){
        Vec3 bodySet = legs.getBodySet();
        // Rotate the bodySet around the entity's position
        float yRotRad = -this.getYRot() * ((float)Math.PI / 180F);
        double rotatedX = bodySet.x * Math.cos(yRotRad) - bodySet.z * Math.sin(yRotRad);
        double rotatedZ = bodySet.x * Math.sin(yRotRad) + bodySet.z * Math.cos(yRotRad);
        return this.position().add(rotatedX, bodySet.y, rotatedZ);
    }
    @Override
    public boolean isMultipartEntity() {
        return true;
    }
    public void recreateFromPacket(ClientboundAddEntityPacket clientboundAddEntityPacket) {
        super.recreateFromPacket(clientboundAddEntityPacket);
        for(int i = 0; i < completeArray.length; ++i) {
            completeArray[i].setId(i + clientboundAddEntityPacket.getId());
        }
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.completeArray;
    }

    @Override
    public void tick() {
        super.tick();
    }
    private void moveSegmentTowards(int index, Vec3 target,TentaclePart[] partArray,boolean far) {
        Vec3 currentPos = partArray[index].position();
        Vec3 newPos = currentPos.lerp(target, 0.25f);
        partArray[index].setPos(far ? target : newPos);
    }


    @Override
    protected void registerGoals() {
        this.addTargettingGoals();
        super.registerGoals();
        this.goalSelector.addGoal(1,new MeleeAttackGoal(this,1,true));
        this.goalSelector.addGoal(4,new RandomStrollGoal(this,1));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (tickCount % 5 == 0){
            targetPositionFrontRight = findStableFooting(LEGS.RIGHT_FRONT, part2, lastFrontRight);
            targetPositionFrontLeft  = findStableFooting(LEGS.LEFT_FRONT, part5, lastFrontLeft);
            targetPositionBackRight  = findStableFooting(LEGS.RIGHT_BACK, part8, lastBackRight);
            targetPositionBackLeft   = findStableFooting(LEGS.LEFT_BACK, part11, lastBackLeft);

            if (!targetPositionFrontRight.equals(lastFrontRight)) lastFrontRight = targetPositionFrontRight;
            if (!targetPositionFrontLeft.equals(lastFrontLeft)) lastFrontLeft  = targetPositionFrontLeft;
            if (!targetPositionBackRight.equals(lastBackRight)) lastBackRight  = targetPositionBackRight;
            if (!targetPositionBackLeft.equals(lastBackLeft))  lastBackLeft   = targetPositionBackLeft;
        }
        applyIK(partArrayRight, targetPositionFrontRight,LEGS.RIGHT_FRONT, part2);
        applyIK(partArrayLeft, targetPositionFrontLeft,LEGS.LEFT_FRONT, part5);
        applyIK(partArrayBackRight, targetPositionBackRight,LEGS.RIGHT_BACK,part8);
        applyIK(partArrayBackLeft, targetPositionBackLeft,LEGS.LEFT_BACK,part11);

        spawnParticlesInPlaces(targetPositionFrontRight,LEGS.RIGHT_FRONT,false);
        spawnParticlesInPlaces(targetPositionFrontLeft,LEGS.LEFT_FRONT,false);
        spawnParticlesInPlaces(targetPositionBackRight,LEGS.RIGHT_BACK,false);
        spawnParticlesInPlaces(targetPositionBackLeft,LEGS.LEFT_BACK,false);
        spawnParticlesInPlaces(targetPositionFrontRight,LEGS.RIGHT_FRONT,true);
        spawnParticlesInPlaces(targetPositionFrontLeft,LEGS.LEFT_FRONT,true);
        spawnParticlesInPlaces(targetPositionBackRight,LEGS.RIGHT_BACK,true);
        spawnParticlesInPlaces(targetPositionBackLeft,LEGS.LEFT_BACK,true);
    }
    private void spawnParticlesInPlaces(Vec3 vec3, LEGS legs,boolean fire){
        if (fire){
            Vec3 positionOnBody = getBodyBasePos(legs);
            level().addParticle(ParticleTypes.SOUL_FIRE_FLAME,positionOnBody.x,positionOnBody.y,positionOnBody.z,0,0.2,0);
        }else {
            if (vec3 != null){
                level().addParticle(ParticleTypes.FLAME,vec3.x,vec3.y,vec3.z,0,0.2,0);
            }
        }
    }

    private void applyIK(TentaclePart[] partArray, Vec3 targetPosition, LEGS legs, TentaclePart tip) {
        if (partArray == null || partArray.length == 0) return;

        Vec3 defaultPosition = getLegBasePos(legs);

        Vec3[] oldPositions = new Vec3[partArray.length];
        for (int j = 0; j < partArray.length; ++j) {
            oldPositions[j] = partArray[j].position();
        }
        boolean tooFar = tip.distanceToSqr(defaultPosition) > 100;
        Vec3 vec3 = targetPosition == null || tooFar ? defaultPosition : targetPosition;

        int midIndex = partArray.length / 2;
        boolean stepping = (targetPosition != null && !targetPosition.equals(oldPositions[partArray.length - 1]));
        double archHeight = stepping ? 0.35 : 0.15;
        double archSpread = partArray.length / 2.0;

        moveSegmentTowards(partArray.length - 1, vec3, partArray, tooFar);

        for (int i = partArray.length - 2; i >= 0; i--) {
            Vec3 nextPos = partArray[i + 1].position();
            Vec3 direction = nextPos.subtract(partArray[i].position()).normalize();
            Vec3 newPos = nextPos.subtract(direction.scale(partArray[i].length));

            double archFactor = Math.exp(-Math.pow((i - midIndex) / archSpread, 2));
            newPos = newPos.add(0, archFactor * archHeight, 0);
            moveSegmentTowards(i, newPos, partArray, tooFar);
        }

        Vec3 special = (legs.bodySet).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        partArray[0].setPos(this.getX() + special.x, this.getY() + special.y, this.getZ() + special.z);

        // Forward pass - from base to tip
        for (int i = 1; i < partArray.length; i++) {
            Vec3 prevPos = partArray[i - 1].position();
            Vec3 direction = partArray[i].position().subtract(prevPos).normalize();
            Vec3 newPos = prevPos.add(direction.scale(partArray[i].length));

            double archFactor = Math.exp(-Math.pow((i - midIndex) / archSpread, 2));
            newPos = newPos.add(0, archFactor * archHeight, 0);

            moveSegmentTowards(i, newPos, partArray, tooFar);
        }

        // Update old positions
        for (int l = 0; l < partArray.length; ++l) {
            partArray[l].xo = oldPositions[l].x;
            partArray[l].yo = oldPositions[l].y;
            partArray[l].zo = oldPositions[l].z;
            partArray[l].xOld = oldPositions[l].x;
            partArray[l].yOld = oldPositions[l].y;
            partArray[l].zOld = oldPositions[l].z;
        }
    }
    private Vec3 findStableFooting(LEGS legs, TentaclePart tip, Vec3 lastPosition) {
        Vec3 legBasePos = getLegBasePos(legs);

        if (lastPosition != null && legBasePos.distanceTo(lastPosition) < 4) {
            return lastPosition;
        }
        double offsetX = (random.nextDouble() - 0.5) * 2;
        double offsetZ = (random.nextDouble() - 0.5) * 2;
        Vec3 randomizedBase = legBasePos.add(offsetX, 0, offsetZ);
        BlockPos searchStart = new BlockPos(
                (int) Math.floor(randomizedBase.x),
                (int) Math.floor(tip.position().y + 2),
                (int) Math.floor(randomizedBase.z)
        );
        return returnGoodSpot(searchStart,legBasePos);
    }
    private Vec3 returnGoodSpot(BlockPos searchStart,Vec3 defaultPos){
        for (int y = -3; y <= 3; y++) {
            BlockPos checkPos = searchStart.below(y);
            if (level().getBlockState(checkPos).isSolidRender(level(),checkPos)) {
                return new Vec3(
                        checkPos.getX() + 0.5,
                        checkPos.getY() - 0.5,
                        checkPos.getZ() + 0.5
                );
            }
        }
        return defaultPos;
    }
    public boolean hurt(TentaclePart tentaclePart, DamageSource source, float amount) {
        return this.hurt(source,amount * 0.25f);
    }

}

