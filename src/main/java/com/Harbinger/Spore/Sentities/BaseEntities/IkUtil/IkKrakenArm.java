package com.Harbinger.Spore.Sentities.BaseEntities.IkUtil;

import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.Calamities.Grakensenker;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.Optional;

public class IkKrakenArm extends IkKrakenLeg {
    protected final boolean rightArm;
    @Nullable
    protected LivingEntity target;
    private final Vec3 RightVec = new Vec3(4,0,-16);
    private final Vec3 LeftVec = new Vec3(4,0,16);
    private final Vec3 RightMidVec = new Vec3(4, 3.5, -5);
    private final Vec3 LeftMidVec = new Vec3(4, 3.5, 5);
    private final Vec3 RightMidVec2 = new Vec3(7, 1.5, -5);
    private final Vec3 LeftMidVec2 = new Vec3(7, 1.5, 5);
    private final Vec3 MouthPosition = new Vec3(0, 1.5, 0);
    private final Vec3 RightWaterVec = new Vec3(8, 4.5, -6);
    private final Vec3 LeftWaterVec = new Vec3(8, 4.5, 6);
    private static final Vector3f nullVec = new Vector3f(0);
    public IkKrakenArm(Grakensenker owner, int amount, Vec3 defaultBodyOffset, Vec3 defaultLimbOffset, float maxDistance, boolean rightArm) {
        super(owner, amount, defaultBodyOffset, defaultLimbOffset, maxDistance);
        this.rightArm = rightArm;
    }

    @Override
    public float getWiggleAmplitude() {
        return 0.01f;
    }

    @Override
    public float getWiggleSpeed() {
        return 0.5f;
    }

    @Override
    public void refreshLegStandingPoint() {
        int hitValues = rightArm ? owner.getRightArmDelay() : owner.getLeftArmDelay();
        boolean full = rightArm ? owner.isRightArmFull() : owner.isLeftArmFull();
        Vector3f vector3f = rightArm ? owner.getRightArm() : owner.getLeftArm();
        if (owner.level().isClientSide){
            sitPosition = vector3f == nullVec || hitValues > 0 ? getLegBasePos() : new Vec3(vector3f).add(0, 1, 0);
            sitPosition = full  ? getMouthPosition() : sitPosition;
            lastSitPosition = sitPosition;
        }else {
            sitPosition = this.target == null || hitValues > 0 ? getLegBasePos() : this.target.position().add(0, 1, 0);
            sitPosition = full  ? getMouthPosition() : sitPosition;
            lastSitPosition = sitPosition;
            if (owner.tickCount % 10 == 0 && hitValues <= 0 && !full){
                setTarget();
            }
        }
    }
    @Override
    protected void moveTipTowards(Vec3 value) {
        int tip = entities.length - 1;
        Vec3 currentPos = entities[tip];
        int val = entities.length - 1;
        Vec3 newPos = currentPos.lerp(value, owner.level().isClientSide ? 0.35f : 0.2f);
        entities[val] = newPos;
    }


    public void setTarget(){
        Optional<LivingEntity> targetOp = findAndSetTarget();
        if (targetOp.isPresent()){
            this.target = targetOp.get();
        }else {
            target = null;
        }
    }


    public Optional<LivingEntity> findAndSetTarget() {
        Level level = owner.level();
        Vec3 pivot = applyYaw(rightArm ? RightVec : LeftVec);
        AABB searchBox = new AABB(
                owner.getX() - 16, owner.getY(),  owner.getZ() - 16,
                owner.getX() + 16, owner.getY() + owner.getExtendedHeight() + 4,  owner.getZ() + 16
        ).move(pivot);
        return level.getEntitiesOfClass(
                LivingEntity.class,
                searchBox,
                e -> e.isAlive() && e != owner && !(e.getVehicle() == owner) && Utilities.TARGET_SELECTOR.Test(e) && TargetingConditions.forCombat().test(owner,e)
        ).stream().findFirst();
    }
    public Vec3 getMidSecPivot(){
        Vec3 pivot = applyYaw(rightArm ? RightMidVec : LeftMidVec);
        return owner.position().add(pivot).add(0, owner.getExtendedHeight(), 0);
    }
    public Vec3 getMidSecPivot2(){
        Vec3 pivot = applyYaw(rightArm ? RightMidVec2 : LeftMidVec2);
        return owner.position().add(pivot).add(0, owner.getExtendedHeight(), 0);
    }
    public Vec3 getMidSecPivot3(){
        Vec3 pivot = applyYaw(rightArm ? RightWaterVec : LeftWaterVec);
        return owner.position().add(pivot).add(0, owner.getExtendedHeight(), 0);
    }
    public Vec3 getMouthPosition(){
        Vec3 pivot = applyYaw(MouthPosition);
        return owner.position().add(pivot).add(0, owner.getExtendedHeight(), 0);
    }

    protected void moveMidSegmentTowards(int index, Vec3 target) {
        if (this.target != null || owner.isInDeepWater()){
            return;
        }
        Vec3 currentPos = entities[index];
        Vec3 newPos = currentPos.lerp(target, 0.2f);
        entities[index] = newPos;
    }
    protected void moveMidSegmentWaterTowards(int index, Vec3 target) {
        if (this.target == null && owner.isInDeepWater()){
            Vec3 currentPos = entities[index];
            Vec3 newPos = currentPos.lerp(target, 0.45f);
            entities[index] = newPos;
        }
    }

    @Override
    public void applyIK() {
        super.applyIK();
        if (!owner.isInDeepWater()){
            moveMidSegmentTowards(entities.length/4,getMidSecPivot());
            moveMidSegmentTowards(entities.length/2,getMidSecPivot2());
            moveMidSegmentWaterTowards(entities.length/4,getMidSecPivot3());
        }
        float x = (float) entities[entities.length-1].x();
        float y = (float) entities[entities.length-1].y();
        float z = (float) entities[entities.length-1].z();
        if (!owner.level().isClientSide){
            if (rightArm){
                owner.setRightArm(new Vector3f(x,y,z));
            }else {
                owner.setLeftArm(new Vector3f(x,y,z));
            }
        }
    }
}