package com.Harbinger.Spore.Sentities.Hyper;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingUseTotemEvent;

import java.util.List;

public class Hevoker extends Hyper {
    private static final EntityDataAccessor<Boolean> DEAD = SynchedEntityData.defineId(Hyper.class, EntityDataSerializers.BOOLEAN);
    private int reviveTimer = 0;
    private int particle = 0;
    private int attackAnimationTick;
    public Hevoker(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("fake_death",isFakeDead());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setFakeDead(tag.getBoolean("fake_death"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DEAD, false);
    }

    public boolean isFakeDead(){
        return entityData.get(DEAD);
    }
    public void setFakeDead(boolean value){
        this.entityData.set(DEAD,value);
    }


    @Override
    public void tick() {
        super.tick();
        if (reviveTimer > 0){
            if (reviveTimer == 1){
                reviveBody();
            }
            reviveTimer--;
        }
        if (this.isFakeDead()){
            this.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0, 1, 0));
        }
    }
    public void reviveBody(){
        float hp = (float) ((SConfig.SERVER.inquisitor_hp.get() * SConfig.SERVER.global_health.get())/4f);
        this.setHealth(hp);
        ItemStack stack = new ItemStack(Items.TOTEM_OF_UNDYING);
        LivingUseTotemEvent totemEvent = new LivingUseTotemEvent(this , this.getLastDamageSource(),stack, InteractionHand.MAIN_HAND);
        MinecraftForge.EVENT_BUS.post(totemEvent);
        setFakeDead(false);
        this.playSound(SoundEvents.TOTEM_USE);
        particle = 30;
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inquisitor_loot.get();
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.inquisitor_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.inquisitor_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.inquisitor_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this ,1.2,true, 1.2 ,3, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}){
            @Override
            public boolean canUse() {
                return super.canUse() && !isFakeDead();
            }
        });
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.8){
            @Override
            public boolean canUse() {
                return super.canUse() && !isFakeDead();
            }
        });
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this){
            @Override
            public boolean canUse() {
                return super.canUse() && !isFakeDead();
            }
        });
    }

    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
        } else {
            super.handleEntityEvent(value);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(entity);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (particle > 0){
            for (int i = 0; i < 360; i++) {
                if (i % 20 == 0) {
                    level().addParticle(ParticleTypes.TOTEM_OF_UNDYING,
                            this.getX() , this.getY() + 1.5 + this.random.nextFloat(), this.getZ() ,
                            Math.cos(i) * 0.15d, Math.sin(i) * Math.cos(i) * 0.15d, Math.sin(i) * 0.15d);
                }
            }
            particle--;
        }
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
    }

    public int getAttackAnimationTick() {
        return this.attackAnimationTick;
    }

    @Override
    public boolean isInvulnerable() {
        return super.isInvulnerable() || isFakeDead();
    }

    @Override
    public boolean isAttackable() {
        if (isFakeDead()){
            return false;
        }
        return super.isAttackable();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isInPowderSnow || source.is(DamageTypes.FREEZE)){
            return super.hurt(source, amount);
        }
        if (isFakeDead()){
            return false;
        }
        if (!isFakeDead() && amount > this.getHealth() && !this.isInPowderSnow){
            setFakeDead(true);
            this.setHealth(1f);
            reviveTimer = 200;
            return false;
        }
        return super.hurt(source, amount);
    }
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        if (DEAD.equals(dataAccessor)){
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(dataAccessor);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        if (this.isFakeDead()){
            return super.getDimensions(pose).scale(2.2F,0.25F);
        }
        return super.getDimensions(pose);
    }
}
