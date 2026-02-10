package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.CalamityInfectedCommand;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SporeBurstSupport;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SummonScentInCombat;
import com.Harbinger.Spore.Sentities.AI.FloatDiveGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.FallenMultipart.StalhArm;
import com.Harbinger.Spore.Sentities.HitboxesForParts;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedWallMovementControl;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Stahlmorder extends Calamity implements TrueCalamity {
    public static final EntityDataAccessor<Float> SWORD_ARM = SynchedEntityData.defineId(Stahlmorder.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Integer> MELEE_STATE = SynchedEntityData.defineId(Stahlmorder.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> JUMP_OFFSET = SynchedEntityData.defineId(Stahlmorder.class, EntityDataSerializers.INT);

    private final CalamityMultipart[] subEntities;
    public final CalamityMultipart swordArm;
    public final CalamityMultipart mouth;
    public AnimationState animationState = new AnimationState();
    private int animationOffset = 0;
    public Stahlmorder(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.swordArm = new CalamityMultipart(this, "swordArm", 3.5F, 3.5F);
        this.mouth = new CalamityMultipart(this, "mouth", 2F, 2F);
        this.subEntities = new CalamityMultipart[]{this.swordArm,this.mouth};
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.length + 1) + 1);
        this.moveControl = new InfectedWallMovementControl(this);
        this.setMaxUpStep(2.5F);
    }
    @Override
    public void setId(int p_20235_) {
        super.setId(p_20235_);
        for (int i = 0; i < this.subEntities.length; i++)
            this.subEntities[i].setId(p_20235_ + i + 1);
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SWORD_ARM, this.getMaxArmHp());
        this.entityData.define(MELEE_STATE, 0);
        this.entityData.define(JUMP_OFFSET, 0);
    }

    private Float getMaxArmHp() {
        return (float) (SConfig.SERVER.sta_hp.get()/4.0f);
    }
    public int getJumpOffset(){return entityData.get(JUMP_OFFSET);}
    public void setJumpOffset(int val){entityData.set(JUMP_OFFSET,val);}

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("sword_arm", entityData.get(SWORD_ARM));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(SWORD_ARM, tag.getFloat("sword_arm"));
    }
    public float getSwordArmHp(){
        return entityData.get(SWORD_ARM);
    }
    public void setSwordtArmHp(float i){
        entityData.set(SWORD_ARM,i);
    }

    @Override
    public void aiStep() {
        Vec3[] avec3 = new Vec3[this.subEntities.length];
        for(int j = 0; j < this.subEntities.length; ++j) {
            avec3[j] = new Vec3(this.subEntities[j].getX(), this.subEntities[j].getY(), this.subEntities[j].getZ());
        }
        this.tickPart(this.mouth, new Vec3(1.5D,3.5D,0D));
        this.tickPart(this.swordArm, new Vec3(0D,4.5D,-5D));
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

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 20 == 0 && this.getHealth() == this.getMaxHealth()){
            if (this.getSwordArmHp() < this.getMaxArmHp()){
                this.setSwordtArmHp(getSwordArmHp()+1);
            }
        }
        if (this.animationOffset > 0) {
            if (level().isClientSide && animationOffset == 1){
                animationState.stop();
            }
            --this.animationOffset;
        }
        if (getJumpOffset() > 0){
            setJumpOffset(getJumpOffset()-1);
        }
    }
    public void triggerAnimation(int states){
        entityData.set(MELEE_STATE,states);
    }
    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.animationOffset = 20;
            animationState.start(this.tickCount);
        } else {
            super.handleEntityEvent(value);
        }
    }
    private int decideAnimation(LivingEntity target) {
        if (this.getSwordArmHp() > 0 &&
                (this.getRandom().nextFloat() < 0.5F ||
                        (target.getArmorValue() >= 10 && this.getRandom().nextFloat() < 0.75F))) {
            return MELEE_STATES.SLASH.getValue();
        }

        return this.getRandom().nextBoolean()
                ? MELEE_STATES.SLAP.getValue()
                : MELEE_STATES.KICK.getValue();
    }

    @Override
    protected int calculateFallDamage(float fallDistance, float p_149390_) {
        if (fallDistance > 4){
            this.playSound(Ssounds.LANDING.get());
        }
        return 0;
    }
    protected SoundEvent getAmbientSound() {
        return Ssounds.STAHL_AMBIENT.get();
    }
    public int getAmbientSoundInterval() {
        return 100;
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.sta_loot.get();
    }
    protected SoundEvent getStepSound() {
        return SoundEvents.RAVAGER_STEP;
    }
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        if (MELEE_STATE.equals(key)){
            AttributeInstance instance = this.getAttribute(Attributes.ATTACK_DAMAGE);
            if (instance != null){
                if (getMeleeState() == MELEE_STATES.SLASH){
                    instance.setBaseValue(SConfig.SERVER.sta_damage.get() * SConfig.SERVER.global_damage.get());
                } else if (getMeleeState() == MELEE_STATES.SLAP) {
                    instance.setBaseValue(SConfig.SERVER.sta_slap_damage.get() * SConfig.SERVER.global_damage.get());
                }else {
                    instance.setBaseValue(SConfig.SERVER.sta_kick_damage.get() * SConfig.SERVER.global_damage.get());
                }
            }
        }
        super.onSyncedDataUpdated(key);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.animationOffset = 20;
        this.level().broadcastEntityEvent(this, (byte)4);
        if (entity instanceof LivingEntity living){
            triggerAnimation(decideAnimation(living));
            applyAttackEffect(living,entityData.get(MELEE_STATE));
        }
        return super.doHurtTarget(entity);
    }
    private void applyAttackEffect(LivingEntity target, int animation) {
        switch (animation) {
            case 0 -> {
                     this.playSound(Ssounds.STAHL_SLASH.get());
                     target.addEffect(new MobEffectInstance(Seffects.CORROSION.get(), 600, 1));
            }



            case 1 -> {
                this.playSound(Ssounds.STAHL_SLAP.get());
                target.knockback(
                        4.0F,
                        Mth.sin(this.getYRot() * ((float) Math.PI / 180F)),
                        -Mth.cos(this.getYRot() * ((float) Math.PI / 180F))
                );
            }

            case 2 -> {
                this.playSound(Ssounds.STAHL_KICK.get());
                target.hurtMarked = true;
                target.setDeltaMovement(
                        target.getDeltaMovement().add(0.0D, 0.8D, 0.0D)
                );
            }
        }
    }
    @Override
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        if (calamityMultipart == this.mouth){
            this.hurt(source,value * 1.25f);
        } else if (calamityMultipart == this.swordArm && getSwordArmHp() > 0){
            this.hurt(source,value * 1.5f);
            float lostHealth = getSwordArmHp()-this.getDamageAfterArmorAbsorb(source,value);
            this.setSwordtArmHp(lostHealth > 0 ? lostHealth : getSwordArmHp() != 0 ? summonDetashedPart() : 0f);
        }
        return true;
    }
    public float summonDetashedPart(){
        Vec3 vec3 = (new Vec3(0D,4.5D,-5D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        StalhArm arm = new StalhArm(Sentities.STAHL_ARM.get(),this.level());
        arm.moveTo(this.getX() + vec3.x, this.getY() + vec3.y,this.getZ()+ vec3.z);
        level().addFreshEntity(arm);
        this.playSound(Ssounds.LIMB_SLASH.get());
        return 0;
    }
    @Override
    public int chemicalRange() {
        return 16;
    }

    @Override
    public List<? extends String> buffs() {
        return SConfig.SERVER.sta_buffs.get();
    }

    @Override
    public List<? extends String> debuffs() {
        return SConfig.SERVER.sta_debuffs.get();
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
    public void recreateFromPacket(ClientboundAddEntityPacket entityPacket) {
        super.recreateFromPacket(entityPacket);
        if (true) return;
        CalamityMultipart[] calamityMultiparts = this.getSubEntities();

        for(int i = 0; i < calamityMultiparts.length; ++i) {
            calamityMultiparts[i].setId(i + entityPacket.getId());
        }
    }
    @Override
    public double getDamageCap() {
        return SConfig.SERVER.sta_dpsr.get();
    }
    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(3, new StaLeapGoal(this,1.6F));
        this.goalSelector.addGoal(4, new AOEMeleeAttackGoal(this, 1.5, false,3,2,living -> {return TARGET_SELECTOR.test(living);}){
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                float f = Stahlmorder.this.getBbWidth();
                return (double)(f * 2.0F * f * 2.0F + entity.getBbWidth());
            }

            @Override
            protected void resetAttackCooldown() {
                this.ticksUntilNextAttack = this.adjustedTickDelay(40);
            }

        });
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.2));
        this.goalSelector.addGoal(6, new FloatDiveGoal(this));
        this.goalSelector.addGoal(6,new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7,new SummonScentInCombat(this){
            @Override
            public boolean canContinueToUse() {
                if (getJumpOffset()>0){
                    return false;
                }
                return super.canContinueToUse();
            }
        });
        this.goalSelector.addGoal(8,new SporeBurstSupport(this){
            @Override
            public boolean canUse() {
                if (getJumpOffset()>0){
                    return false;
                }
                return super.canUse();
            }
        });
        this.goalSelector.addGoal(9,new RandomStrollGoal(this , 1));
        super.registerGoals();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.sta_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.sta_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.sta_armor.get() * SConfig.SERVER.global_armor.get())
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
    public MELEE_STATES getMeleeState() {
        return MELEE_STATES.byId(this.entityData.get(MELEE_STATE) & 255);
    }
    public enum MELEE_STATES{
        SLASH(0),
        SLAP(1),
        KICK(2);
        private final int value;
        MELEE_STATES(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }
        private static final MELEE_STATES[] BY_ID = Arrays.stream(values()).sorted(Comparator.
                comparingInt(MELEE_STATES::getValue)).toArray(MELEE_STATES[]::new);
        public static MELEE_STATES byId(int id) {
            return BY_ID[id % BY_ID.length];
        }
    }

    public class StaLeapGoal extends Goal {
        private final Stahlmorder mob;
        private LivingEntity target;
        private final float yd;

        public StaLeapGoal(Stahlmorder p_25492_, float p_25493_) {
            this.mob = p_25492_;
            this.yd = p_25493_;
            this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
        }

        public boolean canUse() {
            if (getJumpOffset() > 0){
                return false;
            }
            this.target = this.mob.getTarget();
            if (this.target == null)
            {
                return false;
            } else if (this.mob.isInWater())
            {
                return false;
            } else
            {
                double d0 = this.mob.distanceToSqr(this.target);
                if (d0 > 32.0D) {
                    if (!this.mob.onGround()) {
                        return false;
                    } else {
                        return this.mob.getRandom().nextInt(reducedTickDelay(5)) == 0;
                    }
                } else {
                    return false;
                }
            }

        }

        public boolean canContinueToUse() {
            return this.mob.onGround();
        }

        public void start() {
            if (target == null){
                return;
            }
            Vec3 vec31 = new Vec3(this.target.getX() - this.mob.getX(), 0.0D, this.target.getZ() - this.mob.getZ());
            if (vec31.lengthSqr() > 1.0E-7D) {
                vec31 = vec31.normalize().scale(3.5D);
            }
            this.mob.getLookControl().setLookAt(target, 10.0F, (float) this.mob.getMaxHeadXRot());
            this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(vec31.x + yd, this.yd, vec31.z + yd));
            setJumpOffset(200);
        }

    }

    private final List<HitboxesForParts> innatePartList = List.of(
            HitboxesForParts.STAHL_RIGHT_LEG,
            HitboxesForParts.STAHL_LEFT_LEG,HitboxesForParts.STAHL_ARM_ARM,
            HitboxesForParts.STAHL_ARM_ARM2,HitboxesForParts.STAHL_MOUTH);
    @Override
    public List<HitboxesForParts> parts() {
        List<HitboxesForParts> values = new ArrayList<>();
        if (getSwordArmHp() > 0){
            values.add(HitboxesForParts.STAHL_BLADE_ARM);
        }
        for (HitboxesForParts hitboxes : innatePartList){
            HitboxesForParts part = calculateChance(hitboxes,0.85f);
            if (part != null){
                values.add(part);
            }
        }
        return values;
    }
}
