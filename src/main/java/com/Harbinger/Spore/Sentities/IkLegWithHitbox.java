package com.Harbinger.Spore.Sentities;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;

public class IkLegWithHitbox {
    private final Entity owner;
    private final PartEntity<?>[] entities;
    private final float maxLength;
    private final float minLength;
    private final Vec3 defaultBodyOffset;
    private final Vec3 defaultLimbOffset;
    private final float maxDistance;
    public final float length;
    private final RandomSource randomSource = RandomSource.create();
    private Vec3 sitPosition =  null;
    private Vec3 lastSitPosition = null;
    public IkLegWithHitbox(Entity owner, PartEntity<?>[] entities, Vec3 defaultBodyOffset,
                           Vec3 defaultLimbOffset,
                           float maxDistance,
                           float length,
                           float maxLength,
                           float minLength) {
        this.owner = owner;
        this.entities = entities;
        this.defaultBodyOffset = defaultBodyOffset;
        this.defaultLimbOffset = defaultLimbOffset;
        this.maxDistance = maxDistance;
        this.length = length;
        this.maxLength = maxLength;
        this.minLength = minLength;
    }

    public Vec3 getSitPosition() {
        return sitPosition;
    }

    public PartEntity<?>[] getEntities() {
        return entities;
    }

    public Vec3 getLastSitPosition() {
        return lastSitPosition;
    }


    public Vec3 getLegBasePos(){
        float yRotRad = -owner.getYRot() * ((float)Math.PI / 180F);
        double rotatedX = defaultLimbOffset.x * Math.cos(yRotRad) - defaultLimbOffset.z * Math.sin(yRotRad);
        double rotatedZ = defaultLimbOffset.x * Math.sin(yRotRad) + defaultLimbOffset.z * Math.cos(yRotRad);
        return owner.position().add(rotatedX, defaultLimbOffset.y, rotatedZ);
    }

    public Vec3 getDefaultBodyOffset(){
        float yRotRad = -owner.getYRot() * ((float)Math.PI / 180F);
        double rotatedX = defaultBodyOffset.x * Math.cos(yRotRad) - defaultBodyOffset.z * Math.sin(yRotRad);
        double rotatedZ = defaultBodyOffset.x * Math.sin(yRotRad) + defaultBodyOffset.z * Math.cos(yRotRad);
        return owner.position().add(rotatedX, defaultBodyOffset.y, rotatedZ);
    }

    private void moveSegmentTowards(int index, Vec3 target,boolean far) {
        Vec3 currentPos = entities[index].position();
        Vec3 newPos = currentPos.lerp(target, 0.25f);
        entities[index].setPos(far ? target : newPos);
    }

    public void applyIK() {
        if (entities == null || entities.length == 0) return;

        // 🧮 Cache previous positions
        Vec3[] oldPositions = new Vec3[entities.length];
        for (int j = 0; j < entities.length; ++j) {
            oldPositions[j] = entities[j].position();
        }

        Vec3 basePos = getDefaultBodyOffset();
        Vec3 defaultTipPos = getLegBasePos();
        boolean tooFar = entities[entities.length - 1].distanceToSqr(defaultTipPos) > 100;

        if (sitPosition != null) {
            sitPosition = applyLengthConstraints(defaultTipPos, sitPosition);
        }

        Vec3 targetPos = (sitPosition == null || tooFar) ? defaultTipPos : sitPosition;
        targetPos = applyLengthConstraints(defaultTipPos, targetPos);

        entities[0].setPos(basePos.x, basePos.y, basePos.z);

        // ✨ Backward pass (tip → base)
        Vec3 tipTarget = targetPos;
        moveSegmentTowards(entities.length - 1, tipTarget, tooFar);

        for (int i = entities.length - 2; i >= 0; i--) {
            Vec3 nextPos = entities[i + 1].position();
            Vec3 dir = entities[i].position().subtract(nextPos).normalize();
            Vec3 solvedPos = nextPos.add(dir.scale(length));
            moveSegmentTowards(i, solvedPos, tooFar);
        }

        // 🦴 Forward pass (base → tip)
        entities[0].setPos(basePos.x, basePos.y, basePos.z);
        for (int i = 1; i < entities.length; i++) {
            Vec3 prevPos = entities[i - 1].position();
            Vec3 dir = entities[i].position().subtract(prevPos).normalize();
            Vec3 solvedPos = prevPos.add(dir.scale(length));
            moveSegmentTowards(i, solvedPos, tooFar);
        }

        // 🧭 Update old positions to maintain smooth rendering interpolation
        for (int l = 0; l < entities.length; ++l) {
            entities[l].xo = oldPositions[l].x;
            entities[l].yo = oldPositions[l].y;
            entities[l].zo = oldPositions[l].z;
            entities[l].xOld = oldPositions[l].x;
            entities[l].yOld = oldPositions[l].y;
            entities[l].zOld = oldPositions[l].z;
        }
    }


    public void refreshLegStandingPoint(){
        sitPosition = findStableFooting(entities[entities.length-1]);
        if (!sitPosition.equals(lastSitPosition)) lastSitPosition = sitPosition;
    }

    private Vec3 applyLengthConstraints(Vec3 basePos, Vec3 targetPos) {
        double distance = basePos.distanceTo(targetPos);

        if (distance > maxLength) {
            Vec3 dir = targetPos.subtract(basePos).normalize();
            return basePos.add(dir.scale(maxLength));
        } else if (distance < minLength && distance > 0.0001) {
            Vec3 dir = targetPos.subtract(basePos).normalize();
            return basePos.add(dir.scale(minLength));
        }

        return targetPos;
    }
    private Vec3 findStableFooting(PartEntity<?> tip) {
        Level level = owner.level();
        Vec3 legBasePos = getLegBasePos();
        if (level.isClientSide){
            return legBasePos;
        }

        // Don't pick a new spot if the last one is still valid and close
        if (lastSitPosition != null && legBasePos.distanceTo(lastSitPosition) < maxDistance) {
            return lastSitPosition;
        }

        // 🧭 Random offset around base
        double randX = ((randomSource.nextDouble() - 0.5) * 2);
        double randZ = ((randomSource.nextDouble() - 0.5) * 2);
        Vec3 randomizedBase = legBasePos.add(randX, 0, randZ);

        double entityWidth = owner.getBbWidth(); // width from the bounding box
        double minDistance = entityWidth * 1.2; // you can tweak this factor (0.5–0.8 works well)

        Vec3 horizontalVec = new Vec3(
                randomizedBase.x - legBasePos.x,
                0,
                randomizedBase.z - legBasePos.z
        );

        double horizontalDist = horizontalVec.length();
        if (horizontalDist < minDistance && horizontalDist > 0.0001) {
            Vec3 direction = horizontalVec.normalize();
            randomizedBase = legBasePos.add(direction.scale(minDistance));
        }

        BlockPos searchStart = new BlockPos(
                (int) Math.floor(randomizedBase.x),
                (int) Math.floor(tip.position().y + 2),
                (int) Math.floor(randomizedBase.z)
        );

        for (int y = 0; y < 4; y++) {
            BlockPos checkPos = searchStart.below(y);
            if (owner.level().getBlockState(checkPos).isSolidRender(owner.level(), checkPos)) {
                return new Vec3(
                        checkPos.getX() + 0.5,
                        checkPos.getY() - 0.5,
                        checkPos.getZ() + 0.5
                );
            }
        }

        // If nothing found, fallback to last position or base
        return lastSitPosition == null ? legBasePos : randomizedBase;
    }
}
