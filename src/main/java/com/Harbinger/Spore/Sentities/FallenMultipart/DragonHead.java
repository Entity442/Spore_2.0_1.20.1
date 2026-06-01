package com.Harbinger.Spore.Sentities.FallenMultipart;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.HybridPathNavigation;
import com.Harbinger.Spore.Sentities.AmbientSparks;
import com.Harbinger.Spore.Sentities.BaseEntities.FallenMultipartEntity;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkDetashedNecks;
import com.Harbinger.Spore.Sentities.Calamities.Verfalldrachen;
import com.Harbinger.Spore.Sentities.MovementControls.WaterXlandMovement;
import com.Harbinger.Spore.Sentities.Projectile.TarBall;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.DragonHeadVariants;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DragonHead extends FallenMultipartEntity implements VariantKeeper {
    public static final int SEGMENTS = 6;
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(DragonHead.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> CHARGE = SynchedEntityData.defineId(DragonHead.class, EntityDataSerializers.FLOAT);
    private final IkDetashedNecks neck;
    protected List<AmbientSparks> sparks = new ArrayList<>();
    public DragonHead(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.navigation = new HybridPathNavigation(this,level);
        this.moveControl = new WaterXlandMovement(this);
        neck = new IkDetashedNecks(this,SEGMENTS,new Vec3(-0.5,0.5,0),new Vec3(-6,0.5,0));
        this.setMaxUpStep(1F);
        this.setId(ENTITY_COUNTER.getAndAdd(this.neck.getHitboxes().length + 1) + 1);
    }
    @Override
    public void setId(int va) {
        super.setId(va);
        for (int i = 0; i < this.neck.getHitboxes().length; i++)
            this.neck.getHitboxes()[i].setId(va + i + 1);
    }
    public IkDetashedNecks getNeck(){
        return neck;
    }
    public List<AmbientSparks> getSparks(){
        return sparks;
    }
    public void setCharge(float val){
        entityData.set(CHARGE,val);
    }
    public float getCharge(){
        return entityData.get(CHARGE);
    }
    private void regenerateCharges() {
        if (isAggressive()) {
            if (getCharge() <= 20) {
                setCharge(getCharge() + 0.2f);
            }
        } else {
            if (getCharge() > 0) {
                setCharge(getCharge() - 0.1f);
            }
        }
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        this.entityData.define(CHARGE, 0f);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void tick() {
        super.tick();
        regenerateCharges();
        neck.applyIK();
        if (tickCount % 50 == 0 && neck.getSitPosition() != null){
            neck.setSitPosition(null);
        }
        if (getTypeVariant() == 1){
            if (tickCount % 5 == 0 && getCharge() > 0){
                this.playSound(Ssounds.ELECTRIC.get());
                AABB aabb = getBoundingBox().inflate(3);
                List<Entity> mobs = level().getEntities(this,aabb);
                Entity entity = null;
                for (Entity en : mobs){
                    if (en instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
                        int voltageModifier = (living instanceof IronGolem) ? 3 : 1;
                        entity = en;
                        en.hurt(level().damageSources().lightningBolt(),(float) ((SConfig.SERVER.verfa_elec_damage.get() * 0.25) *
                                SConfig.SERVER.global_damage.get() *
                                voltageModifier));
                        setCharge(getCharge() - 1);
                        break;
                    }
                }
                for (int e = 0;e<neck.getEntities().length;e++){
                    float range = Math.abs(getCharge() * 0.05f);
                    int charge = (int) range * 2;
                    Vec3 entityPositions = neck.getEntities()[e];
                    for (int i = 0;i<random.nextInt(3+charge);i++){
                        Vec3 vec3 = Utilities.generatePositionAway(entityPositions,2+range);
                        AmbientSparks ambientSparks = new AmbientSparks(vec3,entity,this,entityPositions,random.nextInt(5,10));
                        sparks.add(ambientSparks);
                    }
                }
            }
            if (!sparks.isEmpty()){
                Iterator<AmbientSparks> it = sparks.iterator();

                while (it.hasNext()) {
                    AmbientSparks spark = it.next();

                    spark.TickSpark();

                    if (spark.life > spark.maxLife) {
                        it.remove();
                    }
                }
            }
        }
        if (tickCount % 400 == 0 && getTypeVariant() == 2){
            LivingEntity target = this.getTarget();
            if (target != null && this.hasLineOfSight(target)){
                performSonicHeadAttack(target);
            }
        }
    }



    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity living && getTypeVariant() == 0){
            living.addEffect(new MobEffectInstance(Seffects.IGNITABLE.get(),200,0));
        }
        return super.doHurtTarget(entity);
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.neck.getHitboxes();
    }

    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        if (true) return;
        DragonHeadMultipart[] calamityMultiparts = this.neck.getHitboxes();

        for(int i = 0; i < calamityMultiparts.length; ++i) {
            calamityMultiparts[i].setId(i + packet.getId());
        }

    }


    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.verfa_head_loot.get();
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, (SConfig.SERVER.verfa_hp.get()*0.2) * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, (SConfig.SERVER.verfa_armor.get()*0.2) * SConfig.SERVER.global_armor.get())
                .add(Attributes.ATTACK_DAMAGE, (SConfig.SERVER.verfa_damage.get()*0.5) * SConfig.SERVER.global_damage.get())
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.MOVEMENT_SPEED, 0.15);
    }

    public DragonHeadVariants getVariant() {
        return DragonHeadVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    protected void registerGoals() {
        addTargettingGoals();
        this.goalSelector.addGoal(2,new CustomMeleeAttackGoal(this,1.1,true));
    }

    @Override
    public void setVariant(int i) {
        this.entityData.set(DATA_ID_TYPE_VARIANT,i > DragonHeadVariants.values().length || i < 0 ? 0 : i);
    }

    @Override
    public int amountOfMutations() {
        return DragonHeadVariants.values().length;
    }

    public void setVariant(DragonHeadVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    public static class DragonHeadMultipart extends PartEntity<DragonHead>{
       public final DragonHead parentMob;
       public final String name;
       protected final EntityDimensions size;
       public DragonHeadMultipart(DragonHead parent, String name) {
           super(parent);
           this.size = EntityDimensions.scalable(1, 1);
           this.refreshDimensions();
           this.parentMob = parent;
           this.name = name;
       }
       public boolean isPickable() {
           return true;
       }

       public boolean is(Entity entity) {
           return this == entity || this.parentMob == entity;
       }

       public Packet<ClientGamePacketListener> getAddEntityPacket() {
           throw new UnsupportedOperationException();
       }

        @Override
        public boolean canBeCollidedWith() {
            return false;
        }

        public EntityDimensions getDimensions(Pose p_31023_) {
           return this.size;
       }

       public boolean shouldBeSaved() {
           return false;
       }

       @Override
       protected void defineSynchedData() {

       }

       @Override
       protected void readAdditionalSaveData(CompoundTag compoundTag) {

       }

       @Override
       protected void addAdditionalSaveData(CompoundTag compoundTag) {

       }

       public boolean hurt(DamageSource source, float amount) {
           if (source.getEntity() == this.parentMob){
               return false;
           }
           return !this.isInvulnerableTo(source) && this.parentMob.hurt(source, amount);
       }
   }
    private void playSonicBoomSound() {
        this.level().playSound(
                null,
                this.getX(), this.getY(), this.getZ(),
                SoundEvents.WARDEN_SONIC_BOOM,
                SoundSource.HOSTILE,
                3.0F,
                1.0F
        );
    }
    private void spawnSonicBoomParticles(LivingEntity target) {
        if (!(level() instanceof ServerLevel serverLevel)) return;

        Vec3 start = this.position();
        Vec3 end = target.position().add(0, target.getEyeHeight() * 0.5, 0);
        Vec3 direction = end.subtract(start);

        for (int i = 0; i <= 10; i++) {
            double progress = i / 10.0;
            double px = start.x + direction.x * progress;
            double py = start.y + direction.y * progress;
            double pz = start.z + direction.z * progress;

            serverLevel.sendParticles(
                    ParticleTypes.SONIC_BOOM,
                    px, py, pz,
                    1, 0, 0, 0, 0
            );
        }
    }

    private void applySonicKnockback(LivingEntity target) {
        Vec3 pushDirection = new Vec3(
                target.getX() - this.getX(),
                target.getEyeY() - this.getEyeY(),
                target.getZ() - this.getZ()
        ).normalize();

        target.push(
                pushDirection.x * 1.5,
                pushDirection.y * 0.75,
                pushDirection.z * 1.5
        );
    }

    private void performSonicHeadAttack(LivingEntity target) {
        playSonicBoomSound();

        spawnSonicBoomParticles(target);

        target.hurt(this.damageSources().sonicBoom(this), (float) (SConfig.SERVER.verfa_sound_damage.get() * SConfig.SERVER.global_damage.get()));
        applySonicKnockback(target);
    }
}
