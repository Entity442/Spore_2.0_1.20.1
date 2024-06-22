package com.Harbinger.Spore.Sentities.Hyper;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.PullGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Slasher;
import com.Harbinger.Spore.Sentities.Variants.SlasherVariants;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.EnumSet;
import java.util.List;

public class Brot extends Hyper {
    private static final EntityDataAccessor<Integer> DATA_SWELL_DIR = SynchedEntityData.defineId(Brot.class, EntityDataSerializers.INT);
    private int swell;
    private final int maxSwell = 40;
    private boolean leapt =  false;
    public Brot(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.brot_loot.get();
    }

    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_SWELL_DIR, -1);
    }
    public void addAdditionalSaveData(CompoundTag data) {
        super.addAdditionalSaveData(data);

        data.putShort("Fuse", (short)this.maxSwell);
    }

    public int getSwellDir() {
        return this.entityData.get(DATA_SWELL_DIR);
    }


    public void setSwellDir(int data) {
        this.entityData.set(DATA_SWELL_DIR, data);
    }

    public void setLeapt(boolean value){this.leapt = value;}

    public boolean getLeapt(){return this.leapt;}

    private void chemAttack(LivingEntity pLivingEntity) {
        AABB boundingBox = pLivingEntity.getBoundingBox().inflate(12);
        List<Entity> entities = pLivingEntity.level().getEntities(pLivingEntity, boundingBox);
        for (Entity entity : entities) {
            if ((entity instanceof LivingEntity livingEntity) && !(livingEntity instanceof Infected || livingEntity instanceof UtilityEntity || livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() == Sitems.GAS_MASK.get())) {
                for (String str : SConfig.SERVER.brot_effects.get()){
                    String[] string = str.split("\\|" );
                    MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(string[0]));
                    if (effect != null && !livingEntity.hasEffect(effect)){
                        livingEntity.addEffect(new MobEffectInstance(effect , Integer.parseUnsignedInt(string[1]), Integer.parseUnsignedInt(string[2])));
                    }

                }
            }
        }
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(2, new BrotLeapGoal(this));
        this.goalSelector.addGoal(2, new PullGoal(this, 48, 32));
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this ,1.2,true, 1.2 ,5, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.brot_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.brot_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.brot_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FOLLOW_RANGE, 48)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    public void tick() {
        if (this.isAlive()) {
            if (this.tickCount % 20 == 0 && this.getLeapt() && this.onGround()){
                this.setLeapt(false);
            }
            int i = this.getSwellDir();
            if (i > 0 && this.swell == 0) {
                this.playSound(Ssounds.BRAIOMIL_ATTACK.get(), 1.0F, 0.5F);
            }
            this.swell += i;
            if (this.swell < 0) {
                this.swell = 0;
            }
            if (this.swell >= this.maxSwell) {
                this.swell = this.maxSwell;
                this.setSwellDir(-1);
                this.chemAttack(this);
            }
            if (this.tickCount % 20 == 0){
                LivingEntity target = this.getTarget();
                if (target != null && this.distanceToSqr(target) < 120.0D){
                    this.setSwellDir(1);
                }
            }
        }
        super.tick();
    }

    public void aiStep() {
        super.aiStep();
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        Level world = this.level();
        if ((swell >= 25)) {
            for (int i = 0; i < 360; i++) {
                if (i % 20 == 0) {
                    world.addParticle(ParticleTypes.SMOKE,
                            x , y + 1, z ,
                            Math.cos(i) * 0.15d, Math.sin(i) * Math.cos(i) * 0.15d, Math.sin(i) * 0.15d);
                }
            }
        }
    }

    public static class BrotLeapGoal extends Goal{
        private final Brot mob;
        private LivingEntity target;

        public BrotLeapGoal(Brot value) {
            this.mob = value;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        public boolean canUse() {
            if (this.mob.isVehicle()) {
                return false;
            } else {
                this.target = this.mob.getTarget();
                if (this.target == null) {
                    return false;
                } else {
                    double d0 = this.mob.distanceToSqr(this.target);
                    if (!(d0 < 16.0D) && !(d0 > 48.0D)) {
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
        }

        public boolean canContinueToUse() {
            return !this.mob.onGround();
        }

        public void start() {
            Vec3 vec3 = this.mob.getDeltaMovement();
            Vec3 vec31 = new Vec3(this.target.getX() - this.mob.getX(), 0.0D, this.target.getZ() - this.mob.getZ());
            if (vec31.lengthSqr() > 1.0E-7D) {
                vec31 = vec31.normalize().scale(0.8D).add(vec3.scale(0.3D));
            }
            this.mob.setDeltaMovement(vec31.x, 0.6D, vec31.z);
            this.mob.setLeapt(true);
        }
    }


    protected SoundEvent getAmbientSound() {
        return Ssounds.BROT_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }
}
