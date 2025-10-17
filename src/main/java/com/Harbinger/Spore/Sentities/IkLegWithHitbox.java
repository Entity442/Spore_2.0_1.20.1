package com.Harbinger.Spore.Sentities;

import com.Harbinger.Spore.Sentities.Organoids.Tentacle;
import com.Harbinger.Spore.Sentities.Organoids.TentaclePart;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;

public class IkLegWithHitbox {
    private final PartEntity<?>[] hitBoxes;
    private final Vec3 defaultBodyOffset;
    private final Vec3 defaultLimbOffset;
    private final Entity parent;
    private final PartEntity<?> tip;
    private final float maxDistance;
    public final float length;
    private final RandomSource randomSource = RandomSource.create();
    private final int sitArea;
    private Vec3 sitPosition;
    private Vec3 lastSitPosition;

    public IkLegWithHitbox(Entity parent, PartEntity<?>[] hitBoxes, PartEntity<?> tip, Vec3 defaultBodyOffset, Vec3 defaultLimbOffset, float maxDistance, float length, int sitArea) {
        this.hitBoxes = hitBoxes;
        this.defaultBodyOffset = defaultBodyOffset;
        this.defaultLimbOffset = defaultLimbOffset;
        this.parent = parent;
        this.tip = tip;
        this.maxDistance = maxDistance;
        this.length = length;
        this.sitArea = sitArea;
    }

    public Vec3 getLegBasePos(){
        float yRotRad = -parent.getYRot() * ((float)Math.PI / 180F);
        double rotatedX = defaultLimbOffset.x * Math.cos(yRotRad) - defaultLimbOffset.z * Math.sin(yRotRad);
        double rotatedZ = defaultLimbOffset.x * Math.sin(yRotRad) + defaultLimbOffset.z * Math.cos(yRotRad);
        return parent.position().add(rotatedX, defaultLimbOffset.y, rotatedZ);
    }

    public Vec3 getBodyBasePos(){
        float yRotRad = -parent.getYRot() * ((float)Math.PI / 180F);
        double rotatedX = defaultBodyOffset.x * Math.cos(yRotRad) - defaultBodyOffset.z * Math.sin(yRotRad);
        double rotatedZ = defaultBodyOffset.x * Math.sin(yRotRad) + defaultBodyOffset.z * Math.cos(yRotRad);
        return parent.position().add(rotatedX, defaultBodyOffset.y, rotatedZ);
    }

    public void moveSegmentTowards(int index, Vec3 target, PartEntity<?>[] partArray, boolean far) {
        Vec3 currentPos = partArray[index].position();
        Vec3 newPos = currentPos.lerp(target, 0.25f);
        partArray[index].setPos(far ? target : newPos);
    }

    public PartEntity<?>[] getHitBoxes(){return hitBoxes;}

    public void applyIK() {
        if (hitBoxes == null || hitBoxes.length == 0) return;
        Vec3 defaultPosition = getLegBasePos();
        Vec3[] oldPositions = new Vec3[hitBoxes.length];
        for (int j = 0; j < hitBoxes.length; ++j) {
            oldPositions[j] = hitBoxes[j].position();
        }
        boolean tooFar = tip.distanceToSqr(defaultPosition) > maxDistance;
        Vec3 vec3 = sitPosition == null || tooFar ? defaultPosition : sitPosition;

        int midIndex = hitBoxes.length / 2;
        boolean stepping = (sitPosition != null && !sitPosition.equals(oldPositions[hitBoxes.length - 1]));
        double archHeight = stepping ? 1 : 0.15;
        double archSpread = hitBoxes.length / 2.0;

        moveSegmentTowards(hitBoxes.length - 1, vec3, hitBoxes, tooFar);

        for (int i = hitBoxes.length - 2; i >= 0; i--) {
            Vec3 nextPos = hitBoxes[i + 1].position();
            Vec3 direction = nextPos.subtract(hitBoxes[i].position()).normalize();
            Vec3 newPos = nextPos.subtract(direction.scale(length));

            double archFactor = Math.exp(-Math.pow((i - midIndex) / archSpread, 2));
            newPos = newPos.add(0, archFactor * archHeight, 0);
            moveSegmentTowards(i, newPos, hitBoxes, tooFar);
        }

        Vec3 special = (getBodyBasePos()).yRot(-parent.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        hitBoxes[0].setPos(parent.getX() + special.x, parent.getY() + special.y, parent.getZ() + special.z);

        // Forward pass - from base to tip
        for (int i = 1; i < hitBoxes.length; i++) {
            Vec3 prevPos = hitBoxes[i - 1].position();
            Vec3 direction = hitBoxes[i].position().subtract(prevPos).normalize();
            Vec3 newPos = prevPos.add(direction.scale(length));

            double archFactor = Math.exp(-Math.pow((i - midIndex) / archSpread, 2));
            newPos = newPos.add(0, archFactor * archHeight, 0);

            moveSegmentTowards(i, newPos, hitBoxes, tooFar);
        }

        // Update old positions
        for (int l = 0; l < hitBoxes.length; ++l) {
            hitBoxes[l].xo = oldPositions[l].x;
            hitBoxes[l].yo = oldPositions[l].y;
            hitBoxes[l].zo = oldPositions[l].z;
            hitBoxes[l].xOld = oldPositions[l].x;
            hitBoxes[l].yOld = oldPositions[l].y;
            hitBoxes[l].zOld = oldPositions[l].z;
        }
    }
    private Vec3 findStableFooting() {
        if (lastSitPosition != null && sitPosition.distanceTo(lastSitPosition) < sitArea) {
            return lastSitPosition;
        }
        double offsetX = (randomSource.nextDouble() - 0.5) * 2;
        double offsetZ = (randomSource.nextDouble() - 0.5) * 2;
        Vec3 randomizedBase = sitPosition.add(offsetX, 0, offsetZ);
        BlockPos searchStart = new BlockPos(
                (int) Math.floor(randomizedBase.x),
                (int) Math.floor(tip.position().y + 2),
                (int) Math.floor(randomizedBase.z)
        );
        return returnGoodSpot(searchStart,sitPosition);
    }
    private Vec3 returnGoodSpot(BlockPos searchStart,Vec3 defaultPos){
        for (int y = 0; y <4; y++) {
            BlockPos checkPos = searchStart.below(y);
            if (parent.level().getBlockState(checkPos).isSolidRender(parent.level(),checkPos)) {
                return new Vec3(
                        checkPos.getX() + 0.5,
                        checkPos.getY() - 0.5,
                        checkPos.getZ() + 0.5
                );
            }
        }
        return defaultPos;
    }
}
