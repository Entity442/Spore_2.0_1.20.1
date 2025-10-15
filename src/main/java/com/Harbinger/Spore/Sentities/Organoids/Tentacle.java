package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class Tentacle extends UtilityEntity {
    private Vec3 targetPosition;
    private Vec3 targetPosition2;
    private float tentacleTime = 0;
    private final TentaclePart[] partArrayRight;
    private final TentaclePart[] partArrayLeft;
    private final TentaclePart[] completeArray;
    public Tentacle(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);

        // Initialize parts
        TentaclePart part0 = new TentaclePart(this, "segment0", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part1 = new TentaclePart(this, "segment1", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part2 = new TentaclePart(this, "segment2", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part3 = new TentaclePart(this, "segment3", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part4 = new TentaclePart(this, "segment4", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part5 = new TentaclePart(this, "segment5", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        this.partArrayRight = new TentaclePart[]{part0, part1, part2, part3, part4, part5};

        TentaclePart part6 = new TentaclePart(this, "segment6", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part7 = new TentaclePart(this, "segment7", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part8 = new TentaclePart(this, "segment8", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part9 = new TentaclePart(this, "segment9", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part10 = new TentaclePart(this, "segment10", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part11 = new TentaclePart(this, "segment11", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        this.partArrayLeft = new TentaclePart[]{part6, part7, part8, part9, part10, part11};

        this.completeArray = new TentaclePart[]{
                part0, part1, part2, part3, part4, part5,
                part6, part7, part8, part9, part10, part11
        };

        // FIX: Proper ID assignment
        int baseId = ENTITY_COUNTER.getAndAdd(this.completeArray.length + 1);
        this.setId(baseId);
    }

    @Override
    public void setId(int entityId) {
        super.setId(entityId);
        for (int i = 0; i < this.completeArray.length; i++) {
            this.completeArray[i].setId(entityId + i + 1);
        }
    }
    public void setTargetPositionRight(Vec3 vec3) {
        targetPosition = vec3;
    }
    public void setTargetPositionLeft(Vec3 vec3) {
        targetPosition2 = vec3;
    }
    public TentaclePart[] getRightSegments(){return partArrayRight;}
    public TentaclePart[] getLeftSegments(){return partArrayLeft;}

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.mound_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.mound_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.MOVEMENT_SPEED, 0.1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

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
        tentacleTime += 0.05f;
        if(tickCount % 40 == 0){
            setTargetPositionLeft(Utilities.generatePositionAway(this.position().add(0,6,0),6));
            setTargetPositionRight(Utilities.generatePositionAway(this.position().add(0,6,0),6));
        }
    }
    private void moveSegmentTowards(int index, Vec3 target, float time,TentaclePart[] partArray) {
        float frequency = 0.25f;
        float amplitude = 0.1f;
        float waveOffset = (float) Math.sin(time * frequency + index * 0.5f) * amplitude;

        Vec3 currentPos = partArray[index].position();
        Vec3 newPos = currentPos.lerp(target, 0.2f)
                .add(new Vec3(waveOffset, 0, waveOffset));
        partArray[index].setPos(this.distanceToSqr(newPos) < 120 ? newPos : this.position());
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
        applyIK(partArrayRight, targetPosition);
        applyIK(partArrayLeft, targetPosition2);

        if (false){
            // Calculate actual foot positions
            Vec3 rightFootPos = this.position().add(
                    (new Vec3(1.5, 0, -2.5)).yRot(-this.getYRot() * ((float)Math.PI / 180F))
            );
            Vec3 leftFootPos = this.position().add(
                    (new Vec3(1.5, 0, 2.5)).yRot(-this.getYRot() * ((float)Math.PI / 180F))
            );

            if (targetPosition == null || targetPosition == Vec3.ZERO){
                targetPosition = this.position();
            }else {
                if (targetPosition.distanceToSqr(rightFootPos) > 16){ // Reduced threshold
                    Vec3 vec3 = processNextWalkPoint(new Vec3(2.5, 0, 0));
                    if (vec3 != null){
                        setTargetPositionRight(vec3);
                    }
                }
            }if (targetPosition2 == null || targetPosition2 == Vec3.ZERO){
                targetPosition2 = this.position();
            }else {
                if (targetPosition2.distanceToSqr(leftFootPos) > 16){
                    Vec3 vec3 = processNextWalkPoint(new Vec3(-2.5, 0, 0));
                    if (vec3 != null){
                        setTargetPositionLeft(vec3);
                    }
                }
            }
        }
    }

    private void applyIK(TentaclePart[] partArray, Vec3 targetPosition) {
        if (partArray == null || partArray.length == 0 || targetPosition == null) return;

        // Store old positions first
        Vec3[] oldPositions = new Vec3[partArray.length];
        for(int j = 0; j < partArray.length; ++j) {
            oldPositions[j] = partArray[j].position();
        }

        // IK passes
        moveSegmentTowards(partArray.length - 1, targetPosition, tentacleTime, partArray);

        // Backward pass
        for (int i = partArray.length - 2; i >= 0; i--) {
            Vec3 nextPos = partArray[i + 1].position();
            Vec3 direction = nextPos.subtract(partArray[i].position()).normalize();
            Vec3 newPos = nextPos.subtract(direction.scale(partArray[i].length));
            moveSegmentTowards(i, newPos, tentacleTime, partArray);
        }

        // Forward pass
        for (int i = 1; i < partArray.length; i++) {
            Vec3 prevPos = partArray[i - 1].position();
            Vec3 direction = partArray[i].position().subtract(prevPos).normalize();
            Vec3 newPos = prevPos.add(direction.scale(partArray[i].length));
            moveSegmentTowards(i, newPos, tentacleTime, partArray);
        }

        // Update old positions
        for(int l = 0; l < partArray.length; ++l) {
            partArray[l].xo = oldPositions[l].x;
            partArray[l].yo = oldPositions[l].y;
            partArray[l].zo = oldPositions[l].z;
            partArray[l].xOld = oldPositions[l].x;
            partArray[l].yOld = oldPositions[l].y;
            partArray[l].zOld = oldPositions[l].z;
        }
    }

    public @Nullable Vec3 processNextWalkPoint(Vec3 offset){
        Vec3 worldOffset = offset.yRot(-this.getYRot() * ((float)Math.PI / 180F));
        Vec3 searchPos = this.position().add(worldOffset);

        AABB aabb = new AABB(searchPos.x-1, searchPos.y, searchPos.z-1,
                searchPos.x+1, searchPos.y+2, searchPos.z+1);

        // Look for walkable surface
        for(BlockPos blockpos : BlockPos.betweenClosed(
                Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ),
                Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {

            if (level().getBlockState(blockpos).isSolidRender(level(), blockpos) &&
                    level().getBlockState(blockpos.above()).isAir()) {
                return new Vec3(blockpos.getX() + 0.5, blockpos.getY() + 1, blockpos.getZ() + 0.5);
            }
        }
        return null;
    }

    public boolean hurt(TentaclePart tentaclePart, DamageSource source, float amount) {
        return this.hurt(source,amount * 0.25f);
    }

}

