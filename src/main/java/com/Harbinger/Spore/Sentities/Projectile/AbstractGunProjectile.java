package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsMutations;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeWeaponData;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import java.util.List;

public abstract class AbstractGunProjectile extends AbstractArrow implements SporeWeaponData {
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(AbstractGunProjectile.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> TRAVEL = SynchedEntityData.defineId(AbstractGunProjectile.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(AbstractGunProjectile.class, EntityDataSerializers.INT);
    protected AbstractGunProjectile(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
    public Float getDamage(){return entityData.get(DAMAGE);}
    public void setDamage(Float value){entityData.set(DAMAGE,value);}
    public Float getTravel(){return entityData.get(TRAVEL);}
    public void setTravel(Float value){entityData.set(TRAVEL,value);}
    public int getVariant(){return entityData.get(VARIANT);}
    public void setVariant(Integer value){entityData.set(VARIANT,value);}
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DAMAGE, 0f);
        entityData.define(TRAVEL, 0f);
        entityData.define(VARIANT, 0);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setDamage(tag.getFloat("damage"));
        this.setTravel(tag.getFloat("travel"));
        this.setVariant(tag.getInt("variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("damage",this.getDamage());
        tag.putFloat("travel",this.getTravel());
        tag.putInt("variant",this.getVariant());
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity target = result.getEntity();
        if (target instanceof CalamityMultipart multipart){
            target = multipart.getParent();
        }
        if (target instanceof LivingEntity living && this.getOwner() instanceof LivingEntity owner) {
            float calculations =  living.getMaxHealth() * getProDamage();
            float damage = getDamage();
            if (calculations > damage){
                damage = calculations;
            }
            living.hurt(level().damageSources().mobProjectile(this,owner),damage);
            doHitAfterEffects(living,owner);
            if (living instanceof Player && owner instanceof Player player){
                player.playNotifySound(Ssounds.BIOGUN_HIT_PLAYER.get(), SoundSource.MASTER,1,1);
            }else {
                playSound(entityImpactSound());
            }
            mutationBuffs(living,owner);
        }
    }
    protected void mutationBuffs(LivingEntity victim, LivingEntity owner) {
        SporeToolsMutations mutations = this.getMutationVariant();
        if (mutations == SporeToolsMutations.TOXIC) {
            victim.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 1));
        }
        if (mutations == SporeToolsMutations.ROTTEN) {
            victim.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 1));
        }
        if (mutations == SporeToolsMutations.VAMPIRIC && owner.getHealth() < owner.getMaxHealth()) {
            owner.heal(2f);
        }
        if (mutations == SporeToolsMutations.CALCIFIED) {
            AABB aabb = victim.getBoundingBox().inflate(2f);
            List<Entity> entities = level().getEntities(this,aabb);
            for (Entity entity : entities){
                if (entity instanceof LivingEntity living && living.hurtTime == 0 && !living.equals(owner)){
                    living.hurt(level().damageSources().mobProjectile(this,owner),getDamage() * 0.5f);
                }
            }
        }
        if (mutations == SporeToolsMutations.BEZERK && Math.random() < 0.3) {
            if (Math.random() < 0.5) {
                owner.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0));
            } else if (Math.random() < 0.5) {
                owner.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0));
            } else {
                owner.addEffect(new MobEffectInstance(MobEffects.SATURATION, 60, 0));
            }
        }
    }
    public SporeToolsMutations getMutationVariant() {
        return SporeToolsMutations.byId(this.getVariant() & 255);
    }
    public void setMutationVariant(SporeToolsMutations variant) {
        setVariant(variant.getId() & 255);
    }
    public abstract SoundEvent blockImpactSound();
    public abstract SoundEvent entityImpactSound();
    public abstract float getMaxBlockRange();
    public abstract float getProDamage();
    public abstract void doHitAfterEffects(LivingEntity living,LivingEntity owner);
    public abstract ParticleOptions getParticle();
    @Override
    protected void onHitBlock(BlockHitResult result) {
        playSound(blockImpactSound());
        discard();
    }

    protected float getWaterInertia() {
        return 0.99F;
    }

    public void shootFrom(LivingEntity shooter, float velocity, float inaccuracy,float damage) {
        this.setOwner(shooter);

        float xRot = shooter.getXRot();
        float yRot = shooter.getYRot();

        double x = -Math.sin(Math.toRadians(yRot)) * Math.cos(Math.toRadians(xRot));
        double y = -Math.sin(Math.toRadians(xRot));
        double z = Math.cos(Math.toRadians(yRot)) * Math.cos(Math.toRadians(xRot));

        this.shoot(x, y, z, velocity, inaccuracy);

        this.setDamage(damage);
    }
    @Override
    public void tick() {
        super.tick();

        double dx = this.getDeltaMovement().x;
        double dy = this.getDeltaMovement().y;
        double dz = this.getDeltaMovement().z;

        float distanceThisTick = (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
        float newTravel = this.getTravel() + distanceThisTick;
        this.setTravel(newTravel);

        if (newTravel >= getMaxBlockRange()) {
            this.discard();
        }
        if (level().isClientSide){
            int i = this.getMutationVariant().getColor();
            float r = (float) (i >> 16 & 255) / 255.0F;
            float g = (float) (i >> 8 & 255) / 255.0F;
            float b = (float) (i & 255) / 255.0F;
            int tries = random.nextInt(4);
            for (int u = 0; u<tries; u++){
                float x = (random.nextFloat()-random.nextFloat()) * 0.5f;
                float z = (random.nextFloat()-random.nextFloat()) * 0.5f;
                level().addParticle(getParticle(),this.getX()+x,this.getY(),this.getZ()+z,r,g,b);
            }
        }
    }
}
