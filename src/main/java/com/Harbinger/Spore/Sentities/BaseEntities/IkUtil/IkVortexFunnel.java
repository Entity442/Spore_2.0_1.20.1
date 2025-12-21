package com.Harbinger.Spore.Sentities.BaseEntities.IkUtil;

import com.Harbinger.Spore.Sentities.Calamities.Grakensenker;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

public class IkVortexFunnel extends IkKrakenLeg{
    public IkVortexFunnel(Grakensenker owner) {
        super(owner, 25,Vec3.ZERO,Vec3.ZERO,Vec3.ZERO, 0);
    }


    @Override
    public Vec3 getBodyOffset() {
        Vec3 pivot = owner.position().add(0, owner.getExtendedHeight(), 0);
        return pivot.add(applyYaw(new Vec3(-4, 4.5, 1.5)));
    }


    @Override
    protected void moveSegmentTowards(int index, Vec3 target, boolean far) {
        entities[index] = (target);
    }

    @Override
    protected void moveTipTowards(Vec3 target) {
        entities[entities.length-1] = (target);
    }

    public void applyIK() {
        if (entities == null || entities.length == 0) return;
        BlockPos pos = owner.getVortexVector();
        Vec3 basePos = getBodyOffset();
        Vec3 defaultTipPos =  new Vec3(pos.getX(),pos.getY(),pos.getZ());

        float totalDistance = (float) basePos.distanceTo(defaultTipPos);

        float baseSegmentLength = 0.5f; // Base length when close
        float maxSegmentLength = 5.0f;  // Maximum stretch per segment
        float stretchFactor = 0.8f;     // How much segments stretch with distance

        // Calculate dynamic segment length that scales with distance but has limits
        float dynamicSegmentLength = Math.min(
                baseSegmentLength + (totalDistance * stretchFactor / entities.length),
                maxSegmentLength
        );

        // Also consider a minimum segment length to prevent compression at short distances
        float idealSegmentLength = Math.max(dynamicSegmentLength, 0.3f);

        int firstElasticSegment = 1;
        int lastElasticSegment = entities.length - 2;

        moveTipTowards(defaultTipPos);

        for (int i = entities.length - 2; i >= 0; i--) {
            Vec3 nextPos = entities[i + 1];
            Vec3 dir = entities[i].subtract(nextPos);

            boolean isElastic = (i >= firstElasticSegment && i <= lastElasticSegment);

            if (dir.lengthSqr() > 0.0001f) {
                if (isElastic) {
                    dir = dir.normalize();
                } else {
                    dir = dir.normalize().scale(idealSegmentLength);
                }
            } else {
                dir = new Vec3(idealSegmentLength, 0, 0);
            }

            Vec3 solvedPos = nextPos.add(dir);
            moveSegmentTowards(i, solvedPos, false);
        }

        moveSegmentTowards(0, basePos, false);

        for (int i = 1; i < entities.length; i++) {
            Vec3 prevPos = entities[i - 1];
            Vec3 dir = entities[i].subtract(prevPos);

            boolean isElastic = i <= lastElasticSegment;

            if (dir.lengthSqr() > 0.0001f) {
                if (isElastic) {
                    dir = dir.normalize();
                } else {
                    dir = dir.normalize().scale(idealSegmentLength);
                }
            } else {
                dir = new Vec3(idealSegmentLength, 0, 0);
            }

            Vec3 solvedPos = prevPos.add(dir);
            moveSegmentTowards(i, solvedPos, false);
        }
    }
}
