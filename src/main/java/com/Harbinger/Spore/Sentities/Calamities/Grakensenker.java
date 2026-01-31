package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SAttributes;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.*;
import com.Harbinger.Spore.Sentities.AI.HybridPathNavigation;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkKrakenArm;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkKrakenLeg;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkVortexFunnel;
import com.Harbinger.Spore.Sentities.HitboxesForParts;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import com.Harbinger.Spore.Sentities.WaterInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.*;

public class Grakensenker extends Calamity implements TrueCalamity, WaterInfected {
    public static final EntityDataAccessor<Float> HEIGHT = SynchedEntityData.defineId(Grakensenker.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Integer> WATER_TICKS = SynchedEntityData.defineId(Grakensenker.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Vector3f> RIGHT_ARM_TIP = SynchedEntityData.defineId(Grakensenker.class, EntityDataSerializers.VECTOR3);
    public static final EntityDataAccessor<Vector3f> LEFT_ARM_TIP = SynchedEntityData.defineId(Grakensenker.class, EntityDataSerializers.VECTOR3);
    public static final EntityDataAccessor<Integer> RIGHT_ARM_ENTITY = SynchedEntityData.defineId(Grakensenker.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> LEFT_ARM_ENTITY = SynchedEntityData.defineId(Grakensenker.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> RIGHT_ARM_DELAY = SynchedEntityData.defineId(Grakensenker.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> LEFT_ARM_DELAY = SynchedEntityData.defineId(Grakensenker.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<BlockPos> VORTEX_VECTOR = SynchedEntityData.defineId(Grakensenker.class, EntityDataSerializers.BLOCK_POS);
    public static final EntityDataAccessor<Integer> VORTEX_TIMEOUT = SynchedEntityData.defineId(Grakensenker.class, EntityDataSerializers.INT);
    public static final float MIN_HEIGHT = 0f;
    public static final float MAX_HEIGHT = 4f;
    private final IkKrakenLeg BackRightTentacle;
    private final IkKrakenLeg BackLeftTentacle;
    private final IkKrakenLeg MiddleRightTentacle;
    private final IkKrakenLeg MiddleLeftTentacle;
    private final IkKrakenLeg FrontRightTentacle;
    private final IkKrakenLeg FrontLeftTentacle;
    private final IkKrakenArm RightArmTentacle;
    private final IkKrakenArm LeftArmTentacle;
    private final IkVortexFunnel VortexFunnel;
    private final IkKrakenLeg[] TickTentacles;
    private final CalamityMultipart[] subEntities;
    public final CalamityMultipart Body;
    public final CalamityMultipart Body2;
    public final CalamityMultipart RightHand;
    public final CalamityMultipart LeftHand;
    private static final Vector3f V0 = new Vector3f();
    public Grakensenker(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.Body = new CalamityMultipart(this, "body", 5F, 5F);
        this.Body2 = new CalamityMultipart(this, "body2", 3F, 3F);
        this.RightHand = new CalamityMultipart(this, "right", 1.5F, 1.5F);
        this.LeftHand = new CalamityMultipart(this, "left", 1.5F, 1.5F);
        BackRightTentacle = new IkKrakenLeg(this,7,GrakenLegsModifiers.BACK_RIGHT_TENTACLE.bodySet, GrakenLegsModifiers.BACK_RIGHT_TENTACLE.offset, 4);
        BackLeftTentacle = new IkKrakenLeg(this,7,GrakenLegsModifiers.BACK_LEFT_TENTACLE.bodySet, GrakenLegsModifiers.BACK_LEFT_TENTACLE.offset,  4);
        MiddleRightTentacle = new IkKrakenLeg(this,7,GrakenLegsModifiers.MIDDLE_RIGHT_TENTACLE.bodySet, GrakenLegsModifiers.MIDDLE_RIGHT_TENTACLE.offset,  6);
        MiddleLeftTentacle = new IkKrakenLeg(this,7,GrakenLegsModifiers.MIDDLE_LEFT_TENTACLE.bodySet, GrakenLegsModifiers.MIDDLE_LEFT_TENTACLE.offset, 6);
        FrontRightTentacle = new IkKrakenLeg(this,10,GrakenLegsModifiers.FRONT_RIGHT_TENTACLE.bodySet, GrakenLegsModifiers.FRONT_RIGHT_TENTACLE.offset, 8);
        FrontLeftTentacle = new IkKrakenLeg(this,10,GrakenLegsModifiers.FRONT_LEFT_TENTACLE.bodySet, GrakenLegsModifiers.FRONT_LEFT_TENTACLE.offset,  8);
        RightArmTentacle = new IkKrakenArm(this,16,GrakenLegsModifiers.RIGHT_ARM.bodySet, GrakenLegsModifiers.RIGHT_ARM.offset, 4,true);
        LeftArmTentacle = new IkKrakenArm(this,16,GrakenLegsModifiers.LEFT_ARM.bodySet, GrakenLegsModifiers.LEFT_ARM.offset,  4,false);
        VortexFunnel = new IkVortexFunnel(this);
        TickTentacles = new IkKrakenLeg[]{BackRightTentacle,BackLeftTentacle,MiddleRightTentacle,MiddleLeftTentacle,FrontRightTentacle,FrontLeftTentacle,RightArmTentacle,LeftArmTentacle,VortexFunnel};
        this.subEntities = new CalamityMultipart[]{ this.Body,this.Body2, this.RightHand,this.LeftHand};
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.length + 1) + 1);
        this.navigation = new HybridPathNavigation(this,this.level());
        this.setMaxUpStep(1.5f);
    }
    @Override
    public void setId(int p_20235_) {
        super.setId(p_20235_);
        for (int i = 0; i < this.subEntities.length; i++)
            this.subEntities[i].setId(p_20235_ + i + 1);
    }
    public CalamityMultipart[] getSubEntities() {
        return this.subEntities;
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public @Nullable PartEntity<?>[] getParts() {
        return subEntities;
    }

    public void recreateFromPacket(ClientboundAddEntityPacket p_218825_) {
        super.recreateFromPacket(p_218825_);
        if (true) return;
        CalamityMultipart[] calamityMultiparts = this.getSubEntities();

        for(int i = 0; i < calamityMultiparts.length; ++i) {
            calamityMultiparts[i].setId(i + p_218825_.getId());
        }

    }
    enum GrakenLegsModifiers{
        BACK_LEFT_TENTACLE(new Vec3(-3,3.5,0.75),new Vec3(-6, -1, 6),new Vec3(1, -3, 4)),
        BACK_RIGHT_TENTACLE(new Vec3(-3,3.5,-0.75),new Vec3(-6, -1, -6),new Vec3(1, -3, -4)),
        MIDDLE_LEFT_TENTACLE(new Vec3(-1,2,0.75),new Vec3(0, -1, 6),new Vec3(0, 1, 7)),
        MIDDLE_RIGHT_TENTACLE(new Vec3(-1,2,-0.75),new Vec3(0, -1, -6),new Vec3(0, 1, -7)),
        FRONT_LEFT_TENTACLE(new Vec3(-2,3,0.75),new Vec3(9, -1, 6),new Vec3(8, 1, 4)),
        FRONT_RIGHT_TENTACLE(new Vec3(-2,3,-0.75),new Vec3(9, -1, -6),new Vec3(8, 1, -4)),
        LEFT_ARM(new Vec3(0,3,1),new Vec3(8, 2.5, 6),new Vec3(16, 4.5, 8)),
        RIGHT_ARM(new Vec3(0,3,-1),new Vec3(8, 2.5, -6),new Vec3(16, 4.5, -8));
        private final Vec3 bodySet;
        private final Vec3 offset;
        private final Vec3 underwaterOffset;

        GrakenLegsModifiers(Vec3 bodySet, Vec3 offset, Vec3 underwaterOffset) {
            this.bodySet = bodySet;
            this.offset = offset;
            this.underwaterOffset = underwaterOffset;
        }
    }
    public IkKrakenLeg getBackRightTentacle(){
        return BackRightTentacle;
    }
    public IkKrakenLeg getBackLeftTentacle(){
        return BackLeftTentacle;
    }
    public IkKrakenLeg getMiddleRightTentacle(){
        return MiddleRightTentacle;
    }
    public IkKrakenLeg getMiddleLeftTentacle(){
        return MiddleLeftTentacle;
    }
    public IkKrakenLeg getFrontRightTentacle(){
        return FrontRightTentacle;
    }
    public IkKrakenLeg getFrontLeftTentacle(){
        return FrontLeftTentacle;
    }
    public IkKrakenLeg[] getTentacles(){
        return TickTentacles;
    }
    public IkKrakenArm getRightArmTentacle(){
        return RightArmTentacle;
    }
    public IkKrakenArm getLeftArmTentacle(){
        return LeftArmTentacle;
    }
    public IkVortexFunnel getVortexFunnel(){
        return VortexFunnel;
    }



    @Override
    public boolean doHurtTarget(Entity entity) {
        this.playSound(Ssounds.SIEGER_BITE.get());
        return super.doHurtTarget(entity);
    }
    public void travel(Vec3 vec) {
        if (this.isEffectiveAi() && this.isInFluidType()) {
            this.moveRelative(0.1F, vec);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D).add(0,-0.1,0));
        } else {
            super.travel(vec);
        }
    }
    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    @Override
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        if (calamityMultipart == RightHand){
            this.entityData.set(RIGHT_ARM_DELAY,100);
        }
        if (calamityMultipart == LeftHand){
            this.entityData.set(LEFT_ARM_DELAY,100);
        }
        value = calamityMultipart == this.Body ? value * 3 : value;
        return this.hurt(source,value);
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return true;
    }

    @Override
    public int chemicalRange() {
        return 16;
    }

    @Override
    public List<? extends String> buffs() {
        return SConfig.SERVER.graken_buffs.get();
    }

    @Override
    public List<? extends String> debuffs() {
        return SConfig.SERVER.graken_debuffs.get();
    }

    public float getExtendedHeight(){
        return entityData.get(HEIGHT);
    }
    public void setHeight(float value){
        entityData.set(HEIGHT,value);
    }
    public int getWaterTicks(){
        return entityData.get(WATER_TICKS);
    }
    public void setWaterTicks(int value){
        entityData.set(WATER_TICKS,value);
    }
    public boolean isInDeepWater(){
        return entityData.get(WATER_TICKS) >= 40;
    }
    public Vector3f getRightArm(){return entityData.get(RIGHT_ARM_TIP);}
    public Vector3f getLeftArm(){return entityData.get(LEFT_ARM_TIP);}
    public void setRightArm(Vector3f vector3f){ entityData.set(RIGHT_ARM_TIP,vector3f);}
    public void setLeftArm(Vector3f vector3f){ entityData.set(LEFT_ARM_TIP,vector3f);}
    public int getRightArmDelay(){return entityData.get(RIGHT_ARM_DELAY);};
    public int getLeftArmDelay(){return entityData.get(LEFT_ARM_DELAY);}
    public BlockPos getVortexVector(){return entityData.get(VORTEX_VECTOR);}
    public int getVortexTimeOut(){return entityData.get(VORTEX_TIMEOUT);}
    public void setVortexVector(BlockPos vector3f){entityData.set(VORTEX_VECTOR,vector3f);}
    public boolean hasVortex() {
        return entityData.get(VORTEX_VECTOR) != BlockPos.ZERO;
    }
    public void setVortexTimeout(int value){entityData.set(VORTEX_TIMEOUT,value);}
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(HEIGHT, 0f);
        entityData.define(WATER_TICKS, 0);
        entityData.define(RIGHT_ARM_TIP, V0);
        entityData.define(LEFT_ARM_TIP,  V0);
        entityData.define(RIGHT_ARM_ENTITY,  -1);
        entityData.define(LEFT_ARM_ENTITY,  -1);
        entityData.define(RIGHT_ARM_DELAY,  0);
        entityData.define(LEFT_ARM_DELAY,  0);
        entityData.define(VORTEX_VECTOR,   BlockPos.ZERO);
        entityData.define(VORTEX_TIMEOUT,  0);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("height", entityData.get(HEIGHT));
        tag.putInt("water", entityData.get(WATER_TICKS));
        for(int e = 0;e<TickTentacles.length;e++){
            TickTentacles[e].writeVariants(tag,e);
        }
        tag.putInt("VX",getVortexVector().getX());
        tag.putInt("VY",getVortexVector().getY());
        tag.putInt("VZ",getVortexVector().getZ());
        tag.putInt("timeOut",getVortexTimeOut());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(HEIGHT,tag.getFloat("height"));
        entityData.set(WATER_TICKS,tag.getInt("water"));
        for(int e = 0;e<TickTentacles.length;e++){
            TickTentacles[e].readVariants(tag,e);
        }
        int x = tag.getInt("VX");
        int y = tag.getInt("VY");
        int z = tag.getInt("VZ");
        this.setVortexVector(new BlockPos(x,y,z));
        setVortexTimeout(tag.getInt("timeOut"));
    }


    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return super.getDimensions(pose).scale(1,1+(getExtendedHeight() * 0.5f));
    }

    public void applyYaw(CalamityMultipart part, Vec3 offset) {
        float yawRad = this.getYRot() * Mth.DEG_TO_RAD;
        float spinRad = this.getWaterTicks() * 0.05f;
        Vec3 pos = this.position().add(offset.yRot(-yawRad - Mth.HALF_PI + spinRad));
        part.setPos(pos.x, pos.y, pos.z);
    }
    @Override
    public void aiStep() {
        Vec3[] avec3 = new Vec3[this.subEntities.length];
        for(int j = 0; j < this.subEntities.length; ++j) {
            avec3[j] = new Vec3(this.subEntities[j].getX(), this.subEntities[j].getY(), this.subEntities[j].getZ());
        }
        this.applyYaw(this.Body,new Vec3 (-4.5, 5.0D+getExtendedHeight(), 0));
        this.applyYaw(this.Body2,new Vec3 (-2.5, 2.0D+getExtendedHeight(), 0));
        this.RightHand.setPos(getRightArm().x, getRightArm().y, getRightArm().z);
        this.LeftHand.setPos(getLeftArm().x, getLeftArm().y, getLeftArm().z);
        for(int l = 0; l < this.subEntities.length; ++l) {
            this.subEntities[l].xo = avec3[l].x;
            this.subEntities[l].yo = avec3[l].y;
            this.subEntities[l].zo = avec3[l].z;
            this.subEntities[l].xOld = avec3[l].x;
            this.subEntities[l].yOld = avec3[l].y;
            this.subEntities[l].zOld = avec3[l].z;
        }
        super.aiStep();
    }
    public void setRightArmEntity(int id){
        entityData.set(RIGHT_ARM_ENTITY,id);
    }
    public void setLeftArmEntity(int id){
        entityData.set(LEFT_ARM_ENTITY,id);
    }
    private void validateArms() {
        if (level().isClientSide()) return;

        int rightId = entityData.get(RIGHT_ARM_ENTITY);
        int leftId  = entityData.get(LEFT_ARM_ENTITY);

        if (rightId != -1) {
            Entity e = level().getEntity(rightId);
            if (!(e instanceof LivingEntity le) || !le.isAlive() || !le.isPassengerOfSameVehicle(this)) {
                entityData.set(RIGHT_ARM_ENTITY, -1);
            }
        }

        if (leftId != -1) {
            Entity e = level().getEntity(leftId);
            if (!(e instanceof LivingEntity le) || !le.isAlive() || !le.isPassengerOfSameVehicle(this)) {
                entityData.set(LEFT_ARM_ENTITY, -1);
            }
        }
    }
    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        if (this.onGround()){
            return SoundEvents.RAVAGER_STEP;
        }
        return SoundEvents.GENERIC_SWIM;
    }

    protected SoundEvent getAmbientSound() {
        if (this.getTarget() != null && this.distanceToSqr(this.getTarget()) > 200){
            return null;
        }
        return Ssounds.KRAKEN_GROWL.get();
    }
    @Override
    public void tick() {
        super.tick();
        if (tickCount % 1200 == 0 && getSearchArea() == BlockPos.ZERO && !isOcean(level().getBiome(this.getOnPos()))){
            BlockPos pos = findOcean(level(),this.getOnPos());
            if (pos != null){
                setSearchArea(pos);
            }
        }
        updateHeight();
        handleVortexBehavior();
        if (getVortexTimeOut() > 0) {
            setVortexTimeout(getVortexTimeOut() - 1);
        }
        for (IkKrakenLeg leg : TickTentacles) {
            leg.refreshLegStandingPoint();
            leg.applyIK();
        }
        if (tickCount % 10 == 0){
            tryGrab(getRightArm(),true,getRightArmDelay() <= 0);
            tryGrab(getLeftArm(),false,getLeftArmDelay() <= 0);
        }
        if (tickCount % 20 == 0){
            validateArms();
            if (isInDeepWater()){
                if (!hasVortex() && getVortexTimeOut() <= 0 && getTarget() == null && getSearchArea() == BlockPos.ZERO){
                    BlockPos vec3 = findVortexCenter(level());
                    if (vec3 != null){
                        setVortexVector(vec3);
                    }
                }
            }
        }
        if (hasVortex()){
            int range = 8;
            for(int i = 0; i <=2* range; ++i) {
                for(int k = 0; k <=2* range; ++k) {
                    double distance = Mth.sqrt((float) ((i-range)*(i-range) + (k-range)*(k-range)));
                    if (Math.abs(i) != 2 || Math.abs(k) != 2) {
                        if (distance<range+(0.5) && Math.random() < 0.1){
                            BlockPos vector3f = getVortexVector().offset( i- range,0,k- range);
                            level().addParticle(ParticleTypes.BUBBLE,vector3f.getX(),vector3f.getY()+1,vector3f.getZ(),0,0.05,0);
                        }}}}
            applyVortexForces();
        }
        if (getRightArmDelay() > 0){
            entityData.set(RIGHT_ARM_DELAY,getRightArmDelay()-1);
        }
        if (getLeftArmDelay() > 0){
            entityData.set(LEFT_ARM_DELAY,getLeftArmDelay()-1);
        }
        if (isInWater()){
            LivingEntity target = this.getTarget();
            Vec3 vec3 = target == null ? this.getDeltaMovement() : target.position();

            if (vec3.horizontalDistanceSqr() > 2.5E-7F) {
                double dx = vec3.x;
                double dy = vec3.y;
                double dz = vec3.z;

                double horizontal = Math.sqrt(dx * dx + dz * dz);

                float yaw = (float)(Mth.atan2(dz, dx) * (180F / Math.PI)) - 90F;

                float pitch = (float)(Mth.atan2(dy, horizontal) * (180F / Math.PI));

                this.setYRot(yaw);
                this.setXRot(pitch);

                this.yBodyRot = lerpRotation(this.yRotO, this.getYRot());
            }
        }
    }
    protected static float lerpRotation(float currentRotation, float targetRotation) {
        while(targetRotation - currentRotation < -180.0F) {
            currentRotation -= 360.0F;
        }

        while(targetRotation - currentRotation >= 180.0F) {
            currentRotation += 360.0F;
        }

        return Mth.lerp(0.2F, currentRotation, targetRotation);
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        setVortexTimeout(1200);
        setVortexVector(BlockPos.ZERO);
        return super.hurt(source, amount);
    }

    private void tryGrab(Vector3f handPos, boolean right , boolean canGrab) {
        boolean active = right ? isRightArmFull() : isLeftArmFull();
        if (active && canGrab){
            return;
        }
        AABB aabb = new AABB(
                handPos.x - 2.0, handPos.y - 2.0, handPos.z - 2.0,
                handPos.x + 2.0, handPos.y + 2.0, handPos.z + 2.0
        );

        List<LivingEntity> targets = level().getEntitiesOfClass(
                LivingEntity.class,
                aabb,
                e ->
                        e.isAlive()
                                && e != this
                                && !e.isPassenger()
                                && !e.isInvulnerable()
                                && Utilities.TARGET_SELECTOR.Test(e)
                                && TargetingConditions.forCombat().test(this, e)
        );

        if (targets.isEmpty()) return;
        LivingEntity living = targets.get(0);
        if (right){
            setRightArmEntity(living.getId());
        }else {
            setLeftArmEntity(living.getId());
        }
        living.startRiding(this);
    }
    public boolean isRightArmFull(){return entityData.get(RIGHT_ARM_ENTITY) != -1;}
    public boolean isLeftArmFull(){return entityData.get(LEFT_ARM_ENTITY) != -1;}
    public int getRightArmEntity(){return entityData.get(RIGHT_ARM_ENTITY);}
    public int getLeftArmEntity(){return entityData.get(LEFT_ARM_ENTITY);}

    @Override
    protected void positionRider(Entity passenger, MoveFunction callback) {
        float tall = passenger.getBbHeight()/2;
        passenger.setPose(Pose.STANDING);
        if (passenger.getId() == entityData.get(RIGHT_ARM_ENTITY)){
            Vector3f pos = getRightArm();
            callback.accept(passenger, pos.x, pos.y-tall, pos.z);
            strangleVictim(passenger);
            if (passenger.distanceToSqr(this.position().add(0,getExtendedHeight(),0))<=4){
                setRightArmEntity(-1);
            }
        }else if (passenger.getId() == entityData.get(LEFT_ARM_ENTITY)){
            Vector3f pos = getLeftArm();
            callback.accept(passenger, pos.x, pos.y-tall, pos.z);
            strangleVictim(passenger);
            if (passenger.distanceToSqr(this.position().add(0,getExtendedHeight(),0))<=4){
                setLeftArmEntity(-1);
            }
        }else {
            callback.accept(passenger,this.getX(),this.getY()+getExtendedHeight(),this.getZ());
            if (tickCount % 20 == 0 && passenger instanceof LivingEntity living){
                this.doHurtTarget(living);
            }
        }
    }
    public void strangleVictim(Entity entity){
        if (entity instanceof LivingEntity living){
            int air = living.getAirSupply();
            living.setAirSupply(--air);
        }
    }

    @Override
    public double getDamageCap() {
        return SConfig.SERVER.graken_dpsr.get();
    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if (passenger.getId() == entityData.get(RIGHT_ARM_ENTITY)){
            entityData.set(RIGHT_ARM_ENTITY,-1);
        }
        if (passenger.getId() == entityData.get(LEFT_ARM_ENTITY)){
            entityData.set(LEFT_ARM_ENTITY,-1);
        }
    }

    @Override
    public @NotNull Vec3 getDismountLocationForPassenger(LivingEntity passenger) {
        if (passenger.getId() == entityData.get(RIGHT_ARM_ENTITY)){
            return new Vec3(getRightArm());
        }
        if (passenger.getId() == entityData.get(LEFT_ARM_ENTITY)){
            return new Vec3(getLeftArm());
        }
        this.entityData.set(RIGHT_ARM_DELAY,100);
        this.entityData.set(LEFT_ARM_DELAY,100);
        return super.getDismountLocationForPassenger(passenger);
    }

    public void updateHeight() {
        if (level().isClientSide) return;

        float current = getExtendedHeight();
        float target = current;
        boolean deep = inDeepWater(getOnPos());
        if (deep){
            if (getWaterTicks() <= 180){
                setWaterTicks(getWaterTicks()+5);
            }
        }else {
            if (getWaterTicks() > 0){
                setWaterTicks(getWaterTicks()-5);
            }
        }
        boolean deepWater = isInDeepWater();
        double wantedY = moveControl.getWantedY() + 2;
        boolean wantsLowStance = (wantedY < this.getY() + this.getBbHeight()) && this.horizontalCollision;
        if (wantsLowStance || deepWater) {
            target -= 0.05f;
        }else {
            target += 0.08f;
        }
        target = Math.max(MIN_HEIGHT, Math.min(MAX_HEIGHT, target));
        if (Math.abs(target - current) > 0.01f) {
            setHeight(target);
        }
    }

    protected boolean inDeepWater(BlockPos pos){
        BlockPos firstPos = pos.offset(-3,2,-3);
        BlockPos secondPos = pos.offset(3,5,3);
        return BlockPos.betweenClosedStream(firstPos, secondPos).allMatch(this::checkForFluid);
    }
    boolean checkForFluid(BlockPos pos){
        BlockState state = level().getBlockState(pos);
        FluidState fluidstate = state.getFluidState();
        return state.getCollisionShape(this.level(), pos).isEmpty() && fluidstate.is(FluidTags.WATER);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.graken_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.graken_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.graken_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2)
                .add(SAttributes.REJUVENATION.get(), 0.0D)
                .add(SAttributes.LOCALIZATION.get(), 0.0D)
                .add(SAttributes.LACERATION.get(), 0.0D)
                .add(SAttributes.CORROSIVES.get(), 0.0D)
                .add(SAttributes.BALLISTIC.get(), 0.0D)
                .add(SAttributes.GRINDING.get(), 0.0D);

    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        if (HEIGHT.equals(dataAccessor)){
            this.setMaxUpStep((float) (1.5 + getExtendedHeight()));
            this.refreshDimensions();
        }
        if (SEARCH_AREA.equals(dataAccessor)){
            if (getSearchArea() != BlockPos.ZERO){
                setVortexTimeout(1200);
                setVortexVector(BlockPos.ZERO);
            }
        }
        if (WATER_TICKS.equals(dataAccessor)){
            if (hasVortex() && !isInDeepWater()){
                setVortexTimeout(1200);
                setVortexVector(BlockPos.ZERO);
            }
        }
        super.onSyncedDataUpdated(dataAccessor);
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.graken_loot.get();
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(4, new AOEMeleeAttackGoal(this, 1.5, false,2.5 ,6, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}){
            @Override
            public boolean canUse() {
                return !hasVortex() && super.canUse();
            }

            protected double getAttackReachSqr(LivingEntity entity) {
                float f = Grakensenker.this.getBbWidth();
                return (double)(f * 2F * f * 2F + entity.getBbWidth());
            }
        });
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.2));
        this.goalSelector.addGoal(6,new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7,new SummonScentInCombat(this));
        this.goalSelector.addGoal(8,new SporeBurstSupport(this));
        super.registerGoals();
    }
    private final List<HitboxesForParts> innatePartList = List.of(HitboxesForParts.GRAKEN_FRONT_MAW,
            HitboxesForParts.GRAKEN_HINGE, HitboxesForParts.GRAKEN_BODY,HitboxesForParts.GRAKEN_BACK_MAW);
    @Override
    public List<HitboxesForParts> parts() {
        List<HitboxesForParts> values = new ArrayList<>();
        for (HitboxesForParts hitboxes : innatePartList){
            HitboxesForParts part = calculateChance(hitboxes,0.85f);
            if (part != null){
                values.add(part);
            }
        }
        return values;
    }
    public Vec3 applyYaw(Vec3 offset) {
        float yawRad = this.getYRot() * Mth.DEG_TO_RAD;
        float spinRad = this.getWaterTicks() * 0.05f;

        return offset.yRot(-yawRad - Mth.HALF_PI + spinRad);
    }
    @Nullable
    public BlockPos findVortexCenter(Level level) {
        if (!isInWater()) return null;
        Vec3 random = applyYaw(new Vec3(getRandom().nextInt(3,7),0,getRandom().nextInt(-5,5)));
        Vec3 base = this.position().add(random);
        for (int dy = 0; dy <= 32; dy++) {
            BlockPos pos = BlockPos.containing(base.x, base.y + dy, base.z);

            BlockState water = level.getBlockState(pos);
            BlockState air = level.getBlockState(pos.above());

            if (water.is(Blocks.WATER) && air.isAir()) {
                if (dy <= 12) {return null;};

                return pos;
            }
        }
        return null;
    }


    public void handleVortexBehavior() {
        if (!hasVortex()) return;
        if (getVortexTimeOut() > 0) return;
        this.getNavigation().stop();
        this.setDeltaMovement(Vec3.ZERO);
        this.hasImpulse = false;

        lookAtVortex(getVortexVector());
    }

    private void lookAtVortex(BlockPos target) {
        double dx = target.getX() - this.getX();
        double dz = target.getZ() - this.getZ();
        double dy = target.getY() - this.getEyeY();

        double dist = Math.sqrt(dx * dx + dz * dz);

        float yaw = (float)(Math.atan2(dz, dx) * (180F / Math.PI)) - 90F;
        float pitch = (float)-(Math.atan2(dy, dist) * (180F / Math.PI));

        this.setYRot(yaw);
        this.setXRot(pitch);

        this.yBodyRot = yaw;
        this.yHeadRot = yaw;
    }

    public void applyVortexForces() {
        if (level().isClientSide) return;
        Vec3[] funnelPoints = getVortexFunnel().getEntities();
        if (funnelPoints == null || funnelPoints.length < 2) return;

        // Get entrance (last segment) and base (segment 0)
        Vec3 base = funnelPoints[0];
        for (int i = 0; i < funnelPoints.length; i++) {
            Vec3 segmentPos = funnelPoints[i];

            // Calculate distance from base (0 = at base, 1 = at entrance)
            double distanceFromBase = (double) i / (funnelPoints.length - 1);

            // Radius: smaller at base, larger at entrance
            double radius = 1.0 + distanceFromBase * 4.0 + ((double) i /4);
            AABB area = getAabb(distanceFromBase, segmentPos, radius);

            List<Entity> entities = level().getEntitiesOfClass(
                    Entity.class,
                    area,
                    e -> ((e instanceof LivingEntity living
                            && living != this
                            && Utilities.TARGET_SELECTOR.Test(living)
                            && TargetingConditions.forCombat().test(this, living))
                            || e instanceof Boat) && e.isInWater()
            );

            for (Entity entity : entities) {
                if (entity.isVehicle() && getVortexVector().distToCenterSqr(entity.position()) < 120){
                    entity.ejectPassengers();
                }
                applyVortexForceToEntity(entity, segmentPos, radius, i,
                        funnelPoints.length, base);
            }
        }
    }

    private static @NotNull AABB getAabb(double distanceFromBase, Vec3 segmentPos, double radius) {
        double verticalScale = 1.0 + (1.0 - distanceFromBase) * 2.0; // Taller near base
        double horizontalScale = 0.8 + distanceFromBase * 1.2; // Wider near entrance

        // Below segment
        // Above segment (for capture)
        return new AABB(
                segmentPos.x - radius * horizontalScale,
                segmentPos.y - radius * verticalScale * 0.5, // Below segment
                segmentPos.z - radius * horizontalScale,
                segmentPos.x + radius * horizontalScale,
                segmentPos.y + radius * verticalScale * 1.5, // Above segment (for capture)
                segmentPos.z + radius * horizontalScale
        );
    }

    private void applyVortexForceToEntity(
            Entity entity,
            Vec3 center,
            double radius,
            int segmentIndex,
            int totalSegments,
            Vec3 basePosition
    ) {
        Vec3 entityPos = entity.position();
        Vec3 toCenter = center.subtract(entityPos);
        double distance = toCenter.length();

        if (distance < 0.2 || distance > radius) return;

        double normalizedDistance = distance / radius;

        // Calculate position in funnel (0.0 = at base, 1.0 = at entrance)
        double funnelPosition = (double) segmentIndex / (totalSegments - 1);

        // Force multipliers based on position in funnel
        double baseMultiplier = Math.pow(1.0 - funnelPosition, 2.0); // Strong near base

        // 1. RADIAL PULL (toward segment center)
        double pullStrength;
        if (segmentIndex == 0) {
            pullStrength = 0.25 * (1.0 + normalizedDistance * 0.5);
        } else if (segmentIndex < totalSegments / 3) {
            // Lower third: strong pull
            pullStrength = 0.18 * (0.8 + normalizedDistance * 0.4);
        } else {
            // Upper segments: moderate pull
            pullStrength = 0.12 * (0.6 + normalizedDistance * 0.3);
        }

        Vec3 radialPull = toCenter.normalize().scale(pullStrength);

        // 2. SPIN FORCE (tangential)
        Vec3 spinDir = new Vec3(-toCenter.z, 0, toCenter.x).normalize();
        double spinStrength = 0.8 * (1.0 - normalizedDistance) * (0.3 + baseMultiplier * 0.7);
        Vec3 spinForce = spinDir.scale(spinStrength);

        // 3. FUNNEL FLOW FORCE (toward base - MOST IMPORTANT!)
        Vec3 toBase = basePosition.subtract(entityPos);
        double distanceToBase = toBase.length();

        double flowStrength = getFlowStrength(segmentIndex, totalSegments, distanceToBase);

        Vec3 flowForce = toBase.normalize().scale(flowStrength);

        double sinkStrength;
        if (segmentIndex > totalSegments - 4) {
            sinkStrength = 0.01 * (1.0 - funnelPosition);
        } else {
            sinkStrength = 0.01 * baseMultiplier;
        }

        Vec3 sinkForce = new Vec3(0, -sinkStrength * (1.0 - normalizedDistance), 0);
        Vec3 totalForce;
        if (segmentIndex == 0) {
            // At base: Strong radial pull dominates
            totalForce = radialPull.scale(2.0)
                    .add(flowForce.scale(0.5))
                    .add(spinForce.scale(0.3));
        } else if (segmentIndex < 4) {
            totalForce = flowForce.scale(1.5)
                    .add(radialPull)
                    .add(spinForce.scale(0.7))
                    .add(sinkForce.scale(0.5));
        } else {
            totalForce = flowForce
                    .add(radialPull.scale(0.8))
                    .add(spinForce)
                    .add(sinkForce.scale(0.8));
        }

        Vec3 motion = entity.getDeltaMovement().add(totalForce);

        double maxSpeed;
        if (segmentIndex == 0) {
            maxSpeed = entity instanceof Boat ? 0.2 : 0.4;
        } else if (segmentIndex < 4) {
            maxSpeed = entity instanceof Boat ? 0.3 : 0.6;
        } else {
            maxSpeed = entity instanceof Boat ? 0.5 : 1.0;
        }

        if (motion.length() > maxSpeed) {
            motion = motion.normalize().scale(maxSpeed);
        }

        if (segmentIndex <= 5 && shouldConsumeEntity(entity, center)) {
            consumeEntity(entity);
            return;
        }

        entity.setDeltaMovement(motion);
        entity.hurtMarked = true;
    }

    private static double getFlowStrength(int segmentIndex, int totalSegments, double distanceToBase) {
        double flowStrength;
        if (segmentIndex == 0) {
            // At base: minimal flow (they're already there)
            flowStrength = 0.02;
        } else if (segmentIndex < 3) {
            // Very close to base: strong pull into base
            flowStrength = 0.3 * (1.0 - (distanceToBase / 10.0));
        } else if (segmentIndex < totalSegments / 2) {
            // Middle segments: moderate flow
            flowStrength = 0.15;
        } else {
            // Entrance segments: gentle guidance toward funnel
            flowStrength = 0.08;
        }
        return flowStrength;
    }

    private boolean shouldConsumeEntity(Entity entity, Vec3 baseCenter) {
        if (!entity.isAlive()) return false;
        if (entity.isPassenger()) return false;
        double distSq = entity.position().distanceToSqr(baseCenter);
        return distSq < 3.2 * 3.2 && entity instanceof LivingEntity;
    }

    private void consumeEntity(Entity entity) {
        entity.setDeltaMovement(Vec3.ZERO);
        entity.fallDistance = 0;
        entity.stopRiding();

        Vec3 basePos = getVortexFunnel().getEntities()[0];
        entity.setPos(basePos.x, basePos.y, basePos.z);

        entity.startRiding(this);
    }

}
