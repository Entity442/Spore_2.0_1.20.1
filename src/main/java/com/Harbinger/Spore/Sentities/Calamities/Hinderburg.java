package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SAttributes;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.AerialRangedGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.CalamityInfectedCommand;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SporeBurstSupport;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SummonScentInCombat;
import com.Harbinger.Spore.Sentities.AI.FlyingWanderAround;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.FlyingInfected;
import com.Harbinger.Spore.Sentities.HitboxesForParts;
import com.Harbinger.Spore.Sentities.Projectile.ThrownTumor;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import com.Harbinger.Spore.Sentities.Utility.TumoroidNuke;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class Hinderburg extends Calamity implements FlyingInfected , TrueCalamity , RangedAttackMob {
    public static final EntityDataAccessor<Boolean> ADAPTATION = SynchedEntityData.defineId(Hinderburg.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> DROPPED_BOMBS = SynchedEntityData.defineId(Hinderburg.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> BOMB = SynchedEntityData.defineId(Hinderburg.class, EntityDataSerializers.INT);
    private int bomb_timer = -1;
    private final CalamityMultipart[] subEntities;
    public final CalamityMultipart lowerbody;
    public final CalamityMultipart forwardbody;
    public final CalamityMultipart rightcannon;
    public final CalamityMultipart leftcannon;
    public final CalamityMultipart mouth;
    public Hinderburg(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.lowerbody = new CalamityMultipart(this, "lowerbody", 4.0F, 4.0F);
        this.forwardbody = new CalamityMultipart(this, "forwardbody", 4.0F, 4.0F);
        this.rightcannon = new CalamityMultipart(this, "rightcannon", 1.5F, 1.5F);
        this.leftcannon = new CalamityMultipart(this, "leftcannon", 1.5F, 1.5F);
        this.mouth = new CalamityMultipart(this, "mouth", 3.0F, 0.5F);
        this.subEntities = new CalamityMultipart[]{ this.lowerbody, this.forwardbody,this.rightcannon,this.leftcannon,this.mouth};
        this.moveControl = new HindenMovementController(this );
        this.lookControl = new HindenLookControl(this);
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.length + 1) + 1);
    }

    @Override
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) {
        return false;
    }
    public void travel(Vec3 vec) {
        if (this.onGround()){
            this.setDeltaMovement(this.getDeltaMovement().add(0,0.1,0));
        }
        if (this.isEffectiveAi() && !this.onGround()) {
            this.moveRelative(0.1F, vec);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.95D));
        } else {
            super.travel(vec);
        }
    }

    @Override
    public boolean canCalcify(Entity entity) {
        return false;
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    public void setId(int p_20235_) {
        super.setId(p_20235_);
        for (int i = 0; i < this.subEntities.length; i++)
            this.subEntities[i].setId(p_20235_ + i + 1);
    }

    @Override
    public double setInflation() {
        return 1.0;
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount % 20 == 0){
            if (this.getKills() >= 50 && this.getDroppedBombs() >= 5 && !this.isAdapted()){
                this.entityData.set(ADAPTATION,true);
            }
            if (this.isAdapted()){
                AABB aabb = this.getBoundingBox().inflate(8);
                List<Entity> entities = level().getEntities(this,aabb);
                for (Entity entity : entities){
                    if (entity instanceof LivingEntity living && !(living instanceof Infected || living instanceof UtilityEntity || SConfig.SERVER.blacklist.get().contains(living.getEncodeId()))){
                        living.setSecondsOnFire(5);
                    }
                }
            }
        }
        if(this.getBomb() < 2450){
            int value = this.isAdapted() ? 2 : 1;
            this.setBomb(this.getBomb() + value);
        }
        if (this.getBombTimer() >= 0){
            tickBomb();
            if (this.getBombTimer() == 1){
                Entity entity = this.getTarget() != null ? this.getTarget() : this;
                entity.playSound(Ssounds.HINDEN_NUKE.get());
            }
            if (this.getBombTimer() >= 80){
                this.SummonNuke();
                this.bomb_timer = -1;
            }
        }
    }

    public int getBombTimer(){
        return this.bomb_timer;
    }
    public void tickBomb(){
        this.bomb_timer++;
    }
    public int getDroppedBombs(){
        return this.entityData.get(DROPPED_BOMBS);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.hinden_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FLYING_SPEED, 0.2)
                .add(Attributes.ARMOR, SConfig.SERVER.hinden_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.hinden_damage.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2)
                .add(SAttributes.TOXICITY.get(), 0.0D)
                .add(SAttributes.REJUVENATION.get(), 0.0D)
                .add(SAttributes.LOCALIZATION.get(), 0.0D)
                .add(SAttributes.LACERATION.get(), 0.0D)
                .add(SAttributes.CORROSIVES.get(), 0.0D)
                .add(SAttributes.BALLISTIC.get(), 0.0D)
                .add(SAttributes.GRINDING.get(), 0.0D);

    }

    @Override
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        if (calamityMultipart == this.mouth){
            this.hurt(source,value * 2f);
        }else if(calamityMultipart == this.rightcannon || calamityMultipart == this.leftcannon){
            this.hurt(source,value * 3f);
        }else {
            this.hurt(source,value);
        }
        return true;
    }

    @Override
    public int chemicalRange() {
        return 32;
    }

    @Override
    public List<? extends String> buffs() {
        return SConfig.SERVER.hinden_buffs.get();
    }

    @Override
    public List<? extends String> debuffs() {
        return SConfig.SERVER.hinden_debuffs.get();
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.hindie_loot.get();
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, TumoroidNuke.class, 10.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(5,new AerialRangedGoal(this,1.3,this.isAdapted() ? 20 : 40,16,5,10){
            @Override
            public boolean canUse() {
                return super.canUse() && (this.target != null && (this.target.onGround() || this.target.isInFluidType()));
            }
        });
        this.goalSelector.addGoal(6, new AOEMeleeAttackGoal(this,1,true,2,6,livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(6,new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7,new SummonScentInCombat(this));
        this.goalSelector.addGoal(8,new SporeBurstSupport(this));
        this.goalSelector.addGoal(9,new FlyingWanderAround(this,0.5));
        super.registerGoals();
    }

    @Override
    public void ActivateAdaptation() {
        this.setKills(this.getKills()+50);
        this.entityData.set(DROPPED_BOMBS,entityData.get(DROPPED_BOMBS)+5);
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

        this.tickPart(this.forwardbody, (double)(f2 * -5.0F), 0.0D, (double)(f15 * 5.0F));
        this.tickPart(this.lowerbody, (double)(f2 * 5.0F), 0.0D, (double)(f15 * -5.0F));
        this.tickPart(this.mouth, (double)(f2 * -0.5F), -0.5D, (double)(f15 * 0.5F));

        this.tickPart(this.rightcannon, new Vec3(0D,0D,4D),0.3D);
        this.tickPart(this.leftcannon, new Vec3(0D,0D,-4D),0.3D);
        for(int l = 0; l < this.subEntities.length; ++l) {
            this.subEntities[l].xo = avec3[l].x;
            this.subEntities[l].yo = avec3[l].y;
            this.subEntities[l].zo = avec3[l].z;
            this.subEntities[l].xOld = avec3[l].x;
            this.subEntities[l].yOld = avec3[l].y;
            this.subEntities[l].zOld = avec3[l].z;
        }
        super.aiStep();
        if (this.isAdapted()){
            for (int i = 0; i < 360; i++) {
                if (i % 40 == 0) {
                    this.level().addParticle(ParticleTypes.LARGE_SMOKE,
                            this.getX() , this.getY(), this.getZ() ,
                            Math.cos(i) * 0.25d, 0.25d, Math.sin(i) * 0.25d);
                    this.level().addParticle(ParticleTypes.LARGE_SMOKE,
                            this.getX() , this.getY(), this.getZ() ,
                            Math.sin(i) * 0.25d,  -0.25d, Math.cos(i) * 0.25d);
                }
            }
        }
    }

    public CalamityMultipart[] getSubEntities() {
        return this.subEntities;
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.subEntities;
    }

    public void recreateFromPacket(ClientboundAddEntityPacket p_218825_) {
        super.recreateFromPacket(p_218825_);
        if (true) return;
        CalamityMultipart[] calamityMultiparts = this.getSubEntities();

        for(int i = 0; i < calamityMultiparts.length; ++i) {
            calamityMultiparts[i].setId(i + p_218825_.getId());
        }

    }
    public boolean isAdapted(){
        return this.entityData.get(ADAPTATION);
    }

    @Override
    public double getDamageCap() {
        return SConfig.SERVER.hinden_dpsr.get();
    }

    public  boolean tryToSummonNUKE(Entity entity){
        if (entity != null && this.isArmed()){
            double x = Math.abs(entity.getX())  - Math.abs(this.getX());
            double z = Math.abs(entity.getZ()) - Math.abs(this.getZ());
            return entity.getY() < this.getY() && (Math.abs(x) < 10) && (Math.abs(z) < 10);
        }
        return false;
    }
    public void SummonNuke(){
            TumoroidNuke tnt = new TumoroidNuke(this.level(),this);
            tnt.setOverclocked(this.entityData.get(ADAPTATION));
            tnt.setBuster(Math.random() < 0.2);
            this.entityData.set(DROPPED_BOMBS,entityData.get(DROPPED_BOMBS)+1);
            this.level().addFreshEntity(tnt);
            this.setBomb(0);
    }

    private static class HindenMovementController extends MoveControl{
        private final Hinderburg mob;
        private int floatDuration;

        public HindenMovementController(Hinderburg mob) {
            super(mob);
            this.mob = mob;
        }

        public void tick() {
            if (this.operation == MoveControl.Operation.MOVE_TO) {
                if (this.floatDuration-- <= 0) {
                    this.floatDuration += this.mob.getRandom().nextInt(4) + 2;
                    Vec3 vec3 = new Vec3(this.wantedX - this.mob.getX(), this.wantedY - this.mob.getY(), this.wantedZ - this.mob.getZ());
                    vec3 = vec3.normalize();
                    this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(vec3.scale(0.1D)));
                }

            }
            if (this.operation == Operation.WAIT){
                if (!this.hasWanted() && this.mob.getTarget() == null){
                    this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0,-0.01,0));
                }
            }
        }
    }

    @Override
    public int getAmbientSoundInterval() {
        return 200;
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.HINDEN_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.RAVAGER_STEP;
    }

    private static class HindenLookControl extends LookControl{
        public HindenLookControl(Mob mob) {
            super(mob);
        }

        @Override
        public void tick() {
            super.tick();
            if (this.mob.getTarget() == null) {
                if (this.mob.tickCount % 40 == 0){
                    Vec3 vec3 = this.mob.getDeltaMovement();
                    this.mob.setYRot(-((float)Mth.atan2(vec3.x, vec3.z)) * (180F / (float)Math.PI));
                    this.mob.yBodyRot = this.mob.getYRot();
                }
            } else {
                LivingEntity livingentity = this.mob.getTarget();
                if (livingentity.distanceToSqr(this.mob) < 4096.0D) {
                    double d1 = livingentity.getX() - this.mob.getX();
                    double d2 = livingentity.getZ() - this.mob.getZ();
                    this.mob.setYRot(-((float)Mth.atan2(d1, d2)) * (180F / (float)Math.PI));
                    this.mob.yBodyRot = this.mob.getYRot();
                }
            }
        }
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BOMB, 0);
        this.entityData.define(DROPPED_BOMBS, 0);
        this.entityData.define(ADAPTATION, false);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("bomb", entityData.get(BOMB));
        tag.putInt("dropped_bombs", entityData.get(DROPPED_BOMBS));
        tag.putBoolean("adaptation", entityData.get(ADAPTATION));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(BOMB, tag.getInt("bomb"));
        entityData.set(DROPPED_BOMBS, tag.getInt("dropped_bombs"));
        entityData.set(ADAPTATION, tag.getBoolean("adaptation"));
    }
    public int getBomb(){
        return entityData.get(BOMB);
    }
    public void setBomb(int i){
        entityData.set(BOMB,i);
    }


    public boolean isArmed(){
        return this.getBomb() >= 2400;
    }


    @Override
    public boolean tryToDigDown() {
        return super.tryToDigDown() || this.verticalCollision;
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float p_33318_) {
        if(!level().isClientSide){
            ThrownTumor tumor = new ThrownTumor(level(), this);
            double dx = livingEntity.getX() - this.getX();
            double dy = livingEntity.getY() + livingEntity.getEyeHeight() - 1.5;
            double dz = livingEntity.getZ() - this.getZ();
            Vec3 vec3;
            if (random.nextFloat() < 0.3f){
                vec3 = (new Vec3(2D, 1.3D, 5D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            }else if (random.nextFloat() < 0.3f){
                vec3 = (new Vec3(2D, 1.3D, -5D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            }else{
                vec3 = (new Vec3(0D, -2.0D, 0D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            }

            if (SConfig.SERVER.hinden_explosive_effects != null){
                List<? extends String> ev = SConfig.SERVER.hinden_explosive_effects.get();
                for (int i = 0; i < 1; ++i) {
                    int randomIndex = random.nextInt(ev.size());
                    ResourceLocation randomElement1 = new ResourceLocation(ev.get(randomIndex));
                    MobEffect randomElement = ForgeRegistries.MOB_EFFECTS.getValue(randomElement1);
                    tumor.setMobEffect(randomElement);
                }
            }
            tumor.setExplode(Level.ExplosionInteraction.MOB);
            tumor.moveTo(this.getX() +vec3.x(),this.getY()+vec3.y(),this.getZ() + vec3.z());
            tumor.shoot(dx, dy - tumor.getY() + Math.hypot(dx, dz) * 0.05F, dz, 1f * 2, 12.0F);
            level().addFreshEntity(tumor);
            this.setDeltaMovement(this.getDeltaMovement().add(new Vec3(dx, dy, dz).normalize().scale(0.2D)));
        }
    }


    @Override
    public boolean doHurtTarget(Entity entity) {
        this.playSound(Ssounds.SIEGER_BITE.get());
        return super.doHurtTarget(entity);
    }
    @Override
    public String getMutation() {
        if (isAdapted()){
            return "spore.entity.variant.overclocked";
        }
        return super.getMutation();
    }
    @Override
    public boolean getAdaptation() {
        return isAdapted();
    }

    private final List<HitboxesForParts> innatePartList = List.of(HitboxesForParts.HINDEN_FRONT,
            HitboxesForParts.HINDEN_BACK, HitboxesForParts.MAW,HitboxesForParts.RIGHT_CANNON, HitboxesForParts.LEFT_CANNON);
    @Override
    public List<HitboxesForParts> parts() {
        List<HitboxesForParts> values = new ArrayList<>();
        for (HitboxesForParts hitboxes : innatePartList){
            HitboxesForParts part = calculateChance(hitboxes,0.75f);
            if (part != null){
                values.add(part);
            }
        }
        return values;
    }
}
