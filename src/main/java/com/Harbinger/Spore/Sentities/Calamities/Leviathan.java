package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SAttributes;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.CalamityInfectedCommand;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SporeBurstSupport;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SummonScentInCombat;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkLeviFin;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkLeviLeg;
import com.Harbinger.Spore.Sentities.BaseEntities.LeviathanMultipart;
import com.Harbinger.Spore.Sentities.HitboxesForParts;
import com.Harbinger.Spore.Sentities.Projectile.AcidBall;
import com.Harbinger.Spore.Sentities.Projectile.DrownedFleshBomb;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import com.Harbinger.Spore.Sentities.WaterInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import net.minecraftforge.fluids.FluidType;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Leviathan extends Calamity implements TrueCalamity, WaterInfected, RangedAttackMob {
    private static final int SEGMENT_COUNT = 2;
    private static final EntityDataAccessor<Optional<UUID>> CHILD_UUID = SynchedEntityData.defineId(Leviathan.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> SPRAY_COOLDOWN = SynchedEntityData.defineId(Leviathan.class, EntityDataSerializers.INT);
    private final CalamityMultipart[] subEntities;
    private LeviathanMultipart firstSegment;
    public final CalamityMultipart head;
    private final IkLeviLeg[] legs;
    private final IkLeviFin[] fins;
    public final float[] ringBuffer = new float[64];
    public int ringBufferIndex = -1;
    private int attackAnimationTick;
    private int rangeAttackAnimationTick;

    public Leviathan(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        IkLeviLeg frontRightLeg = new IkLeviLeg(this,6,LEG_POSITIONS.FRONT_RIGHT_TENTACLE.bodySet,LEG_POSITIONS.FRONT_RIGHT_TENTACLE.offset,6);
        IkLeviLeg frontLeftLeg = new IkLeviLeg(this,6,LEG_POSITIONS.FRONT_LEFT_TENTACLE.bodySet,LEG_POSITIONS.FRONT_LEFT_TENTACLE.offset,6);
        IkLeviLeg backRightLeg = new IkLeviLeg(this,5,LEG_POSITIONS.BACK_RIGHT_TENTACLE.bodySet,LEG_POSITIONS.BACK_RIGHT_TENTACLE.offset,4);
        IkLeviLeg backLeftLeg = new IkLeviLeg(this,5,LEG_POSITIONS.BACK_LEFT_TENTACLE.bodySet,LEG_POSITIONS.BACK_LEFT_TENTACLE.offset,4);
        legs = new IkLeviLeg[]{frontLeftLeg,frontRightLeg,backLeftLeg,backRightLeg};
        IkLeviFin rightFin = new IkLeviFin(this,4,LEG_POSITIONS.RIGHT_ARM.bodySet, LEG_POSITIONS.RIGHT_ARM.offset,5);
        IkLeviFin leftFin = new IkLeviFin(this,4,LEG_POSITIONS.LEFT_ARM.bodySet, LEG_POSITIONS.LEFT_ARM.offset,5);
        fins = new IkLeviFin[]{rightFin,leftFin};
        this.head = new CalamityMultipart(this, "head", 3F, 3F);
        this.subEntities = new CalamityMultipart[]{this.head};
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.length + 1) + 1);
        this.setMaxUpStep(1.5F);
    }

    public IkLeviLeg[] getLegs(){
        return legs;
    }
    public IkLeviFin[] getFins(){return fins;}
    /* ---------------- DATA ---------------- */
    public void travel(Vec3 vec) {
        if (this.isEffectiveAi() && this.isInFluidType()) {
            this.moveRelative(0.2F, vec);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.85D).add(0,onGround() ? 0.01f : 0,0));
        } else {
            super.travel(vec);
        }
    }
    public int getRangeAttackAnimationTick(){
        return rangeAttackAnimationTick;
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        for(int e = 0;e<legs.length;e++){
            legs[e].writeVariants(tag,e);
        }
        tag.putInt("spray_cooldown",entityData.get(SPRAY_COOLDOWN));
    }
    @Override
    public void setId(int p_20235_) {
        super.setId(p_20235_);
        for (int i = 0; i < this.subEntities.length; i++)
            this.subEntities[i].setId(p_20235_ + i + 1);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        for(int e = 0;e<legs.length;e++){
            legs[e].readVariants(tag,e);
        }
        entityData.set(SPRAY_COOLDOWN,tag.getInt("spray_cooldown"));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(CHILD_UUID, Optional.empty());
        entityData.define(SPRAY_COOLDOWN, 0);
    }
    public void setSprayCooldown(int val){entityData.set(SPRAY_COOLDOWN,val);}
    public int getSprayCooldown(){return entityData.get(SPRAY_COOLDOWN);}

    @Nullable
    public UUID getChildId() {
        return entityData.get(CHILD_UUID).orElse(null);
    }

    public void setChildId(@Nullable UUID id) {
        entityData.set(CHILD_UUID, Optional.ofNullable(id));
    }

    @Nullable
    public LeviathanMultipart getFirstSegment() {
        if (firstSegment == null && !level().isClientSide) {
            UUID id = getChildId();
            if (id != null) {
                Entity e = ((ServerLevel) level()).getEntity(id);
                if (e instanceof LeviathanMultipart part) {
                    firstSegment = part;
                }
            }
        }
        return firstSegment;
    }

    /* ---------------- ATTRIBUTES ---------------- */

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.levi_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.1D)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.levi_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.levi_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0D)
                .add(SAttributes.TOXICITY.get(), 0.0D)
                .add(SAttributes.REJUVENATION.get(), 0.0D)
                .add(SAttributes.LOCALIZATION.get(), 0.0D)
                .add(SAttributes.LACERATION.get(), 0.0D)
                .add(SAttributes.CORROSIVES.get(), 0.0D)
                .add(SAttributes.BALLISTIC.get(), 0.0D)
                .add(SAttributes.GRINDING.get(), 0.0D);
    }
    @Override
    public void aiStep() {
        float f14 = this.getYRot() * ((float)Math.PI / 180F);
        float f2 = Mth.sin(f14);
        float f15 = Mth.cos(f14);
        Vec3[] avec3 = new Vec3[this.subEntities.length];
        for(int j = 0; j < this.subEntities.length; ++j) {
            avec3[j] = new Vec3(this.subEntities[j].getX(), this.subEntities[j].getY(), this.subEntities[j].getZ());
        }
        this.tickPart(this.head, (double)(f2 * -3F), 0.0D, (double)(-f15 * -3F));
        for(int l = 0; l < this.subEntities.length; ++l) {
            this.subEntities[l].xo = avec3[l].x;
            this.subEntities[l].yo = avec3[l].y;
            this.subEntities[l].zo = avec3[l].z;
            this.subEntities[l].xOld = avec3[l].x;
            this.subEntities[l].yOld = avec3[l].y;
            this.subEntities[l].zOld = avec3[l].z;
        }
        super.aiStep();
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
        if (this.rangeAttackAnimationTick > 0) {
            --this.rangeAttackAnimationTick;
        }
    }

    public CalamityMultipart[] getSubEntities() {
        return this.subEntities;
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.leviathan_loot.get();
    }
    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.IN_WALL)  || source.is(DamageTypes.FALL);
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getEntity() != null && amount >= 10 && Math.random() < 0.2){
            explodeSegments();
            this.playSound(Ssounds.CALAMITY_DEATH.get());
        }
        return super.hurt(source, amount);
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }
    public boolean canShoot(LivingEntity living){
        if (living == null){
            return false;
        }
        if (getSprayCooldown() <= 0){
            if (this.isInWater()){
                setSprayCooldown(20);
                return false;
            }
            if (this.hasLineOfSight(living) && this.distanceToSqr(living) > 50.0D){
                rangeAttackAnimationTick = 20;
                this.level().broadcastEntityEvent(this, (byte)5);
                return true;
            }
        }
        return false;
    }

    @Override
    public @org.jetbrains.annotations.Nullable PartEntity<?>[] getParts() {
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

    @Override
    protected void onEffectAdded(MobEffectInstance instance, @Nullable Entity source) {
        super.onEffectAdded(instance, source);
        if (firstSegment == null) return;
        MobEffectInstance existing = firstSegment.getEffect(instance.getEffect());
        if (existing == null || existing.getDuration() < instance.getDuration() - 5) {
            firstSegment.addEffect(new MobEffectInstance(instance));
        }
    }

    @Override
    protected void onEffectRemoved(MobEffectInstance instance) {
        super.onEffectRemoved(instance);
        if (firstSegment == null){
            return;
        }else {
            firstSegment.removeEffect(instance.getEffect());
        }
    }

    @Override
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        value = rangeAttackAnimationTick > 0 ? value * 2 : value * 0.5f;
        hurt(source,value);
        return false;
    }

    @Override
    public int chemicalRange() {
        return 16;
    }

    @Override
    public List<? extends String> buffs() {
        return SConfig.SERVER.levi_buffs.get();
    }

    @Override
    public List<? extends String> debuffs() {
        return SConfig.SERVER.levi_debuffs.get();
    }

    @Override
    public double getDamageCap() {
        return SConfig.SERVER.levi_dpsr.get();
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        AcidBall.shoot(this, livingEntity,
                (float) (SConfig.SERVER.levi_damage.get() * 0.25 * SConfig.SERVER.global_damage.get()) * 2);
    }

    /*----------------- LEG POSITIONS --------*/
    enum LEG_POSITIONS{
        BACK_LEFT_TENTACLE(new Vec3(-2,1,0.75),new Vec3(-4, 0, 3)),
        BACK_RIGHT_TENTACLE(new Vec3(-2,1,-0.75),new Vec3(-4, 0, -3)),
        FRONT_LEFT_TENTACLE(new Vec3(0,1.5,0.75),new Vec3(4, 0, 3)),
        FRONT_RIGHT_TENTACLE(new Vec3(0,1.5,-0.75),new Vec3(4, 0, -3)),
        LEFT_ARM(new Vec3(0,1,0.75),new Vec3(-1, 0.5, 6)),
        RIGHT_ARM(new Vec3(0,1,-0.75),new Vec3(-1, 0.5, -6));
        private final Vec3 bodySet;
        private final Vec3 offset;

        LEG_POSITIONS(Vec3 bodySet, Vec3 offset) {
            this.bodySet = bodySet;
            this.offset = offset;
        }
    }
    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
        } else if (value == 5) {
            this.rangeAttackAnimationTick = 20;
        } else {
            super.handleEntityEvent(value);
        }
    }
    public int getAttackAnimationTick() {
        return attackAnimationTick;
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        this.playSound(Ssounds.SIEGER_BITE.get());
        return super.doHurtTarget(entity);
    }

    /* ---------------- TICK ---------------- */

    @Override
    public void tick() {
        super.tick();
        for (IkLeviLeg leg : legs) {
            leg.refreshLegStandingPoint();
            leg.applyIK();
        }
        for (IkLeviFin leg : fins) {
            leg.applyIK();
        }
        // Update rotation buffer
        if (++ringBufferIndex == 64) ringBufferIndex = 0;
        ringBuffer[ringBufferIndex] = getYRot();

        if (!level().isClientSide) {

            if (shouldSpawnChain()) {
                createChain();
            }

            updateChain();
        }
        if (getSprayCooldown() > 0){
            setSprayCooldown(getSprayCooldown()-1);
        }
        LivingEntity target = this.getTarget();
        if (tickCount % 5 == 0 && canShoot(target) && target != null){
            for (int i = 0;i<random.nextInt(4) + getExtraShots();i++){
                performRangedAttack(target,0);
            }
            setSprayCooldown(40);
        }
        if (tickCount % 1200 == 0 && getSearchArea() == BlockPos.ZERO && !isOcean(level().getBiome(this.getOnPos()))){
            BlockPos pos = findOcean(level(),this.getOnPos());
            if (pos != null){
                setSearchArea(pos);
            }
        }
    }

    public int getExtraShots(){
        AttributeInstance instance = this.getAttribute(SAttributes.BALLISTIC.get());
        if (instance != null){
            double level = instance.getValue();
            if (level < 1){return 0;}
            return (int) (3 * level);
        }
        return 0;
    }
    private boolean shouldSpawnChain() {
        LeviathanMultipart part = getFirstSegment();
        return part == null || !part.isAlive();
    }

    /* ---------------- CHAIN CREATION ---------------- */

    private void createChain() {
        LeviathanMultipart previous = null;

        for (int i = 0; i < SEGMENT_COUNT; i++) {
            LeviathanMultipart part =
                    new LeviathanMultipart(Sentities.LEVIATHAN_SEG.get(), level());

            part.setPos(getX(), getY(), getZ());
            part.setParent(i == 0 ? this : previous);
            part.setColor(this.getMutationColor());
            part.setTail(i == SEGMENT_COUNT - 1);

            level().addFreshEntity(part);

            if (i == 0) {
                setChildId(part.getUUID());
                firstSegment = part;
            } else {
                previous.setChildId(part.getUUID());
            }

            previous = part;
        }
    }
    /*-----------------GOALS--------------------------*/
    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this,0.4F));
        this.goalSelector.addGoal(4, new AOEMeleeAttackGoal(this, 1.5, false,2.5 ,6, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}){
            protected double getAttackReachSqr(LivingEntity entity) {
                float f = Leviathan.this.getBbWidth();
                return (double)(f * 3.0F * f * 3.0F + entity.getBbWidth());
            }
        });
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0, 10));
        this.goalSelector.addGoal(6,new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7,new SummonScentInCombat(this));
        this.goalSelector.addGoal(8,new SporeBurstSupport(this));
        super.registerGoals();
    }
    /* ---------------- POSITION UPDATES ---------------- */

    private void updateChain() {
        LeviathanMultipart part = getFirstSegment();
        if (part == null) return;

        Vec3 anchor = this.position();
        float xRot = this.getXRot();
        float yRot = this.getYRot();

        int index = 0;

        while (part != null) {

            float yaw = getRingBuffer(4 + index * 2, 1.0F);

            anchor = part.tickMultipartPosition(
                    this.getId(),
                    anchor,
                    xRot,
                    yRot,
                    yaw,
                    index == 0
            );

            xRot = part.getXRot();

            Entity child = part.getChild();
            part = child instanceof LeviathanMultipart next ? next : null;

            index++;
        }
    }

    public float getRingBuffer(int offset, float partialTicks) {
        if (isDeadOrDying()) partialTicks = 0.0F;

        partialTicks = 1.0F - partialTicks;

        int i = ringBufferIndex - offset & 63;
        int j = ringBufferIndex - offset - 1 & 63;

        float d0 = ringBuffer[i];
        float d1 = Mth.wrapDegrees(ringBuffer[j] - d0);

        return d0 + d1 * partialTicks;
    }

    /* ---------------- CLEANUP ---------------- */

    @Override
    public void remove(RemovalReason reason) {
        super.remove(reason);
        LeviathanMultipart part = getFirstSegment();
        while (part != null) {
            Entity next = part.getChild();
            part.discard();
            part = next instanceof LeviathanMultipart l ? l : null;
        }
    }
    public void explodeSegments(){
        explodeTumorsAround(this.position());
        LeviathanMultipart part = getFirstSegment();
        if (part != null){
            explodeTumorsAround(part.position());
            Entity entity = part.getChild();
            if (entity instanceof LeviathanMultipart){
                explodeTumorsAround(entity.position());
            }
        }
    }

    public void explodeTumorsAround(Vec3 pos){
        for (int i = 0;i<random.nextInt(3,7);i++){
            DrownedFleshBomb fleshBomb = new DrownedFleshBomb(level());
            int e = SConfig.SERVER.levi_explosive_effects.get().size();
            fleshBomb.setEffect(SConfig.SERVER.levi_explosive_effects.get().get(random.nextInt(e)));
            fleshBomb.moveTo(pos);
            fleshBomb.setDeltaMovement(new Vec3(
                    (random.nextDouble() - random.nextDouble()) * 0.9,
                    random.nextDouble() * 0.6 + 0.3,
                    (random.nextDouble() - random.nextDouble()) * 0.9
            ));
            level().addFreshEntity(fleshBomb);
        }
    }
    @Override
    public void die(DamageSource source) {
        super.die(source);

        LeviathanMultipart part = getFirstSegment();
        while (part != null) {
            Entity next = part.getChild();
            part.discard();
            part = next instanceof LeviathanMultipart l ? l : null;
        }
    }

    private final List<HitboxesForParts> innatePartList = List.of(HitboxesForParts.LEVI_BODY,
            HitboxesForParts.LEVI_SEGMENT, HitboxesForParts.LEVI_TAIL,HitboxesForParts.LEVI_RIGHT_JAW,HitboxesForParts.LEVI_LEFT_JAW);
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


}