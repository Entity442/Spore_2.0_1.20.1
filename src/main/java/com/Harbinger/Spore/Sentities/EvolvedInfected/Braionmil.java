package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.BraionmilSwellGoal;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import com.Harbinger.Spore.Sentities.Hyper.Brot;
import com.Harbinger.Spore.Sentities.Hyper.Inquisitor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.List;

public class Braionmil extends EvolvedInfected implements EvolvingInfected {
    public Braionmil(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    private static final EntityDataAccessor<Integer> DATA_SWELL_DIR = SynchedEntityData.defineId(Braionmil.class, EntityDataSerializers.INT);
    private int swell;
    private final int maxSwell = 40;

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_braio_loot.get();
    }
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_SWELL_DIR, -1);
    }
    public void addAdditionalSaveData(CompoundTag data) {
        super.addAdditionalSaveData(data);

        data.putShort("Fuse", (short)this.maxSwell);
    }


    public void tick() {

        if (this.isAlive()) {

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
        }
        super.tick();
        this.tickHyperEvolution(this);
    }

    public int getSwellDir() {
        return this.entityData.get(DATA_SWELL_DIR);
    }


    public void setSwellDir(int p_32284_) {
        this.entityData.set(DATA_SWELL_DIR, p_32284_);
    }

    private void chemAttack(LivingEntity pLivingEntity) {
        AABB boundingBox = pLivingEntity.getBoundingBox().inflate(8);
        List<Entity> entities = pLivingEntity.level().getEntities(pLivingEntity, boundingBox);
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity && !Utilities.helmetList().contains(livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem()) && TARGET_SELECTOR.test(livingEntity)) {
                for (String str : SConfig.SERVER.braio_effects.get()){
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
    public DamageSource getCustomDamage(LivingEntity entity) {
        if (Math.random() < 0.3){
            return SdamageTypes.braiomil_damage(this);
        }
        return super.getCustomDamage(entity);
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
                            x , y + 1.2, z ,
                            Math.cos(i) * 0.15d, Math.sin(i) * Math.cos(i) * 0.15d, Math.sin(i) * 0.15d);
                }
            }
        }
    }




    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(2, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 2 + entity.getBbWidth() * entity.getBbWidth();
            }
        });
        this.goalSelector.addGoal(3,new BraionmilSwellGoal(this, 1.1));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        super.registerGoals();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.braio_melee_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.braio_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.braio_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FOLLOW_RANGE, 28)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }


    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_GROWL.get();
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

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public void HyperEvolve() {
        Brot brot = new Brot(Sentities.BROTKATZE.get(),this.level());
        Collection<MobEffectInstance> collection = this.getActiveEffects();
        for(MobEffectInstance mobeffectinstance : collection) {
            brot.addEffect(new MobEffectInstance(mobeffectinstance));
        }
        brot.setKills(this.getKills());
        brot.setEvoPoints(this.getEvoPoints()-SConfig.SERVER.min_kills_hyper.get());
        brot.setCustomName(this.getCustomName());
        brot.setPos(this.getX(),this.getY(),this.getZ());
        if (this.level() instanceof ServerLevel serverLevel)
            brot.finalizeSpawn(serverLevel,serverLevel.getCurrentDifficultyAt(this.getOnPos()), MobSpawnType.CONVERSION,null,null);
        this.level().addFreshEntity(brot);
        if (this.level() instanceof ServerLevel serverLevel){
            double x0 = this.getX() - (random.nextFloat() - 0.1) * 0.1D;
            double y0 = this.getY() + (random.nextFloat() - 0.25) * 0.15D * 5;
            double z0 = this.getZ() + (random.nextFloat() - 0.1) * 0.1D;
            serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 2, 0, 0, 0, 1);
        }
        this.discard();
    }
}
