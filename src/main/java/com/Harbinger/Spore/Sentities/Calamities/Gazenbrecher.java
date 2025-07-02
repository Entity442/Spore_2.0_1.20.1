package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SAttributes;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.*;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.FallenMultipart.Licker;
import com.Harbinger.Spore.Sentities.Projectile.BileProjectile;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import com.Harbinger.Spore.Sentities.WaterInfected;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;

import java.util.List;

public class Gazenbrecher extends Calamity implements WaterInfected , RangedAttackMob , TrueCalamity {
    public static final EntityDataAccessor<Integer> ADAPTATION = SynchedEntityData.defineId(Gazenbrecher.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Float> TONGUE = SynchedEntityData.defineId(Gazenbrecher.class, EntityDataSerializers.FLOAT);
    private int radar;
    private final CalamityMultipart[] subEntities;
    public final CalamityMultipart lowerbody;
    public final CalamityMultipart head;
    public final CalamityMultipart tongue;
    public Gazenbrecher(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.lowerbody = new CalamityMultipart(this, "lowerbody", 3F, 3F);
        this.tongue = new CalamityMultipart(this, "tongue", 2F, 2F);
        this.head = new CalamityMultipart(this, "head", 3F, 3F);
        this.subEntities = new CalamityMultipart[]{ this.lowerbody, this.head,this.tongue};
        this.setMaxUpStep(1.5F);
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.length + 1) + 1);
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.gazen_loot.get();
    }
    public void travel(Vec3 vec) {
        if (this.isEffectiveAi() && this.isInFluidType()) {
            this.moveRelative(0.1F, vec);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.95D));
        } else {
            super.travel(vec);
        }
    }

    @Override
    public void ActivateAdaptation() {
        entityData.set(ADAPTATION,21);
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
        if (this.getHealth() >= this.getMaxHealth() && this.getTongueHp() < this.getMaxTongueHp()){
            if (this.tickCount % 40 == 0){
                this.setTongueHp(this.getTongueHp() +1);
            }
        }
        if (this.isInFluidType()){
            if (this.getTarget() == null &&  this.radar >= 1200){
                this.playSound(Ssounds.SONAR.get());
                this.radar = 0;
                AABB boundingBox = this.getBoundingBox().inflate(64);
                List<Entity> entities = this.level().getEntities(this, boundingBox);
                for (Entity entity : entities) {
                    if (SConfig.SERVER.whitelist.get().contains(entity.getEncodeId()) || entity instanceof Player player && !player.getAbilities().instabuild){
                        if (entity instanceof LivingEntity livingEntity  && livingEntity.isAlive()){
                            this.playSound(Ssounds.SIGNAL.get(),2f,1f);
                            this.setTarget(livingEntity);
                        }
                    }
                }
            }else{
                this.radar++;
            }
        }
        if (!this.isAdaptedToFire() &&(this.tickCount % 40 == 0 && this.isOnFire())){
            this.entityData.set(ADAPTATION,this.entityData.get(ADAPTATION)+1);
        }
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TONGUE, this.getMaxTongueHp());
        this.entityData.define(ADAPTATION, 0);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("tongue_hp", entityData.get(TONGUE));
        tag.putInt("adaptation",entityData.get(ADAPTATION));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TONGUE, tag.getFloat("tongue_hp"));
        entityData.set(ADAPTATION,tag.getInt("adaptation"));
    }
    public float getTongueHp(){
        return entityData.get(TONGUE);
    }
    public void setTongueHp(float i){
        entityData.set(TONGUE,i);
    }

    public float getMaxTongueHp(){
        return (float) (SConfig.SERVER.gazen_hp.get()/4.0f);
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.gazen_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.gazen_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.gazen_armor.get() * SConfig.SERVER.global_armor.get())
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
    public void aiStep() {
        float f14 = this.getYRot() * ((float)Math.PI / 180F);
        float f2 = Mth.sin(f14);
        float f15 = Mth.cos(f14);
        Vec3[] avec3 = new Vec3[this.subEntities.length];
        for(int j = 0; j < this.subEntities.length; ++j) {
            avec3[j] = new Vec3(this.subEntities[j].getX(), this.subEntities[j].getY(), this.subEntities[j].getZ());
        }
        this.tickPart(this.lowerbody, (double)(f2 * 2.5F), 0.0D, (double)(-f15 * 2.5F));
        this.tickPart(this.head, (double)(f2 * -3F), 0.0D, (double)(-f15 * -3F));
        this.tickPart(this.tongue, (double)(f2 * -5F), 0.3D, (double)(-f15 * -5F));
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
    public boolean isAdaptedToFire(){
        return entityData.get(ADAPTATION) > 20;
    }
    public int getAdaptationCount(){
        return entityData.get(ADAPTATION);
    }

    @Override
    public boolean fireImmune() {
        return this.isAdaptedToFire();
    }

    @Override
    public double getDamageCap() {
        return SConfig.SERVER.gazen_dpsr.get();
    }


    @Override
    public void registerGoals() {


        this.goalSelector.addGoal(3, new ScatterShotRangedGoal(this,1.3,60,32,1,3){
            @Override
            public boolean canUse() {
                if (Gazenbrecher.this.getTongueHp() <= 0){
                    return false;
                }
                return super.canUse() && (calculateHeight() || calculateDistance());
            }
        });
        this.goalSelector.addGoal(4,new GazenWaterLeapGoal(this));
        this.goalSelector.addGoal(4, new AOEMeleeAttackGoal(this, 1.5, false,2.5 ,6,livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}){
            protected double getAttackReachSqr(LivingEntity entity) {
                float f = Gazenbrecher.this.getBbWidth();
                return (double)(f * 2F * f * 2F + entity.getBbWidth());
            }
        });
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.2));
        this.goalSelector.addGoal(6,new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7,new SummonScentInCombat(this));
        this.goalSelector.addGoal(8,new SporeBurstSupport(this));
        super.registerGoals();
    }

    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        if (calamityMultipart == this.tongue){
            if (this.getTongueHp() > 0 && value > this.getTongueHp()){
                if (this.getTongueHp() > 0 && value > this.getTongueHp()){
                    this.playSound(Ssounds.LIMB_SLASH.get());
                    SummonDetashedTongue();
                }
                this.playSound(Ssounds.LIMB_SLASH.get());
            }
            this.hurt(source,value * 1.5f);
            this.setTongueHp(value > this.getTongueHp() ? 0 : this.getTongueHp() - value);
        } else{
            this.hurt(source,value );
        }
        return true;
    }

    @Override
    public int chemicalRange() {
        return 16;
    }

    @Override
    public List<? extends String> buffs() {
        return SConfig.SERVER.gazen_buffs.get();
    }

    @Override
    public List<? extends String> debuffs() {
        return SConfig.SERVER.gazen_debuffs.get();
    }

    boolean calculateHeight(){
        return this.getTarget() != null && this.getTarget().getY() > this.getY() && Math.abs(Math.abs(this.getTarget().getY()) - Math.abs(this.getY())) > 5;
    }

    boolean calculateDistance(){
        return this.getTarget() != null && this.distanceToSqr(this.getTarget()) > 300.0D;
    }

    @Override
    public boolean hasLineOfSight(Entity entity) {
        if (calculateDistance() || calculateHeight()){
            return true;
        }
        return super.hasLineOfSight(entity);
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float p_33318_) {
        if(!level().isClientSide){
            BileProjectile tumor = new BileProjectile(level(), this,TARGET_SELECTOR);
            Vec3  vec3 = (new Vec3(3D, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            double dx = livingEntity.getX() - this.getX();
            double dy = livingEntity.getY() + livingEntity.getEyeHeight();
            double dz = livingEntity.getZ() - this.getZ();
            if (this.isAdaptedToFire()){tumor.setSecondsOnFire(10);}
            tumor.setDamage((float) (SConfig.SERVER.gazen_ranged_damage.get() * 1f));
            tumor.moveTo(this.getX() + vec3.x, this.getY()+1D ,this.getZ()+ vec3.z);
            tumor.shoot(dx, dy - tumor.getY() + Math.hypot(dx, dz) * 0.001F, dz, 2f, 6.0F);
            level().addFreshEntity(tumor);
        }
    }

    private void SummonDetashedTongue(){
        Licker licker = new Licker(Sentities.LICKER.get(),this.level());
        Vec3 vec3 = (new Vec3(4D, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        licker.setBurned(this.isAdaptedToFire());
        licker.moveTo(this.getX() + vec3.x, this.getY() + 1.6,this.getZ()+ vec3.z);
        licker.setYBodyRot(this.getYRot());
        this.level().addFreshEntity(licker);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (this.isAdaptedToFire()){entity.setSecondsOnFire(10);}
        this.playSound(Ssounds.SIEGER_BITE.get());
        return super.doHurtTarget(entity);
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
        return Ssounds.GAZEN_AMBIENT.get();
    }

    @Override
    public String getMutation() {
        if (isAdaptedToFire()){
            return "spore.entity.variant.crispy";
        }
        return super.getMutation();
    }
}
