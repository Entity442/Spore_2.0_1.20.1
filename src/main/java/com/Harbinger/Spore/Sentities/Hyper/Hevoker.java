package com.Harbinger.Spore.Sentities.Hyper;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.PullGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import com.Harbinger.Spore.Sentities.Utility.HyperClaw;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;

import java.util.List;

public class Hevoker extends Hyper {
    private static final EntityDataAccessor<Boolean> DEAD = SynchedEntityData.defineId(Hevoker.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAS_ARM = SynchedEntityData.defineId(Hevoker.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> TIME_REGROW = SynchedEntityData.defineId(Hevoker.class, EntityDataSerializers.INT);
    private final HevokerPart[] subEntities;
    private final HevokerPart totem;
    private final HevokerPart arm1;
    private final HevokerPart arm2;
    private final HevokerPart arm3;
    private final HevokerPart arm4;
    private int reviveTimer = 0;
    private int attackAnimationTick;
    public Hevoker(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.totem = new HevokerPart(this,"totem",0.5f,0.5f);
        this.arm1 = new HevokerPart(this,"right_arm1",0.5f,0.5f);
        this.arm2 = new HevokerPart(this,"right_arm2",0.5f,0.5f);
        this.arm3 = new HevokerPart(this,"right_arm3",0.5f,0.5f);
        this.arm4 = new HevokerPart(this,"right_arm4",0.5f,0.5f);
        this.subEntities = new HevokerPart[]{totem,arm1,arm2,arm3,arm4};
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.length + 1) + 1);
    }
    @Override
    public void setId(int p_20235_) {
        super.setId(p_20235_);
        for (int i = 0; i < this.subEntities.length; i++)
            this.subEntities[i].setId(p_20235_ + i + 1);
    }
    @Override
    public boolean isMultipartEntity() {
        return true;
    }
    public HevokerPart[] getSubEntities() {
        return this.subEntities;
    }
    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.subEntities;
    }

    public void recreateFromPacket(ClientboundAddEntityPacket p_218825_) {
        super.recreateFromPacket(p_218825_);
        if (true) return;
        HevokerPart[] calamityMultiparts = this.getSubEntities();

        for(int i = 0; i < calamityMultiparts.length; ++i) {
            calamityMultiparts[i].setId(i + p_218825_.getId());
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("fake_death",isFakeDead());
        tag.putBoolean("arm",hasArm());
        tag.putInt("regrow",getTimeRegrow());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setFakeDead(tag.getBoolean("fake_death"));
        this.setArm(tag.getBoolean("arm"));
        this.setTimeRegrow(tag.getInt("regrow"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DEAD, false);
        this.entityData.define(HAS_ARM, true);
        this.entityData.define(TIME_REGROW, 0);
    }

    public boolean isFakeDead(){return entityData.get(DEAD);}
    public void setFakeDead(boolean value){
        this.entityData.set(DEAD,value);
    }
    public boolean hasArm(){return entityData.get(HAS_ARM);}
    public void setArm(boolean value){this.entityData.set(HAS_ARM,value);}
    public void setTimeRegrow(int value){
        this.entityData.set(TIME_REGROW,value);
    }
    public void tickTimeRegrow(){
        this.entityData.set(TIME_REGROW,this.entityData.get(TIME_REGROW)+1);
    }
    public int getTimeRegrow(){return this.entityData.get(TIME_REGROW);}
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
        if (!this.hasArm() && this.tickCount % 20 == 0){
            tickTimeRegrow();
            if (getTimeRegrow() >= 300){
                setArm(true);
                setTimeRegrow(0);
            }
        }
    }
    public void reviveBody(){
        float hp = (float) ((SConfig.SERVER.hevoker_hp.get() * SConfig.SERVER.global_health.get())/4f);
        this.setHealth(hp);
        ItemStack stack = new ItemStack(Items.TOTEM_OF_UNDYING);
        ForgeHooks.onLivingUseTotem(this, getLastDamageSource(), stack, InteractionHand.MAIN_HAND);
        setFakeDead(false);
        this.playSound(SoundEvents.TOTEM_USE);
        this.addEffect(new MobEffectInstance(MobEffects.REGENERATION,800,1));
        this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,800,0));
        this.addEffect(new MobEffectInstance(MobEffects.ABSORPTION,100,1));
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.hevoker_loot.get();
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.hevoker_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.hevoker_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.hevoker_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FOLLOW_RANGE, 48)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);
    }
    private boolean switchy() {
        LivingEntity living = this.getTarget();
        if (isFakeDead()){
            return false;
        }
        if (living != null && canSee(living)){
            double ze = this.distanceToSqr(living);
            return (ze > 200.0D) && (ze < 600.0D) && entityData.get(HAS_ARM);
        }
        return false;
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this ,1.2,true, 1.2 ,3, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}){
            @Override
            public boolean canUse() {
                if (isFakeDead()){
                    return false;
                }
                return super.canUse();
            }

            @Override
            protected void checkAndPerformAttack(LivingEntity entity, double p_25558_) {
                if (!isFakeDead()){
                    super.checkAndPerformAttack(entity, p_25558_);
                }
            }
        });
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.8){
            @Override
            public boolean canUse() {
                if (isFakeDead()){
                    return false;
                }
                return super.canUse();
            }
        });
        this.goalSelector.addGoal(2, new PullGoal(this, 32, 8){
            @Override
            public boolean canUse() {
                return switchy();
            }
        });
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this){
            @Override
            public boolean canUse() {
                if (isFakeDead()){
                    return false;
                }
                return super.canUse();
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
        moveHitBoxesAround();
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
    public boolean canSee(Entity entity) {
        if (entity.level() != this.level()) {
            return false;
        } else {
            Vec3 vec3 = new Vec3(this.getX(), this.getEyeY(), this.getZ());
            Vec3 vec31 = new Vec3(entity.getX(), entity.getEyeY(), entity.getZ());
            if (vec31.distanceTo(vec3) > 128.0) {
                return false;
            } else {
                return this.level().clip(new ClipContext(vec3, vec31, ClipContext.Block.COLLIDER, net.minecraft.world.level.ClipContext.Fluid.NONE, this)).getType() == HitResult.Type.MISS;
            }
        }
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
            return true;
        }
        if (Math.random() < 0.2){
            performTelekineticThrow();
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

    public boolean hurt(HevokerPart hevokerArm, DamageSource source, float amount) {
        if (Math.random() < 0.2 && hasArm() && !level().isClientSide){
            if (hevokerArm == arm1 || hevokerArm == arm2 || hevokerArm == arm3 || hevokerArm == arm4){
                SummonClaw();
                setArm(false);
            }
        }
        if (isFakeDead() && hevokerArm == totem){
            return this.hurt(this.damageSources().freeze(),Float.MAX_VALUE);
        }
        return this.hurt(source,amount);
    }
    protected void tickPart(HevokerPart part, Vec3 vec3i) {
        Vec3 vec3 = (vec3i).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        part.setPos(this.getX() + vec3.x, this.getY() + vec3.y, this.getZ() + vec3.z);
    }

    public void SummonClaw(){
        Vec3 vec3 = (new Vec3(0.3,0.5D,-0.8)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        HyperClaw claw = new HyperClaw(Sentities.HEVOKER_ARM.get(),level());
        claw.moveTo(this.getX() + vec3.x, this.getY() + vec3.y,this.getZ()+ vec3.z);
        level().addFreshEntity(claw);
        this.playSound(Ssounds.LIMB_SLASH.get());
    }
    public void moveHitBoxesAround(){
        Vec3[] avec3 = new Vec3[this.subEntities.length];
        for(int j = 0; j < this.subEntities.length; ++j) {
            avec3[j] = new Vec3(this.subEntities[j].getX(), this.subEntities[j].getY(), this.subEntities[j].getZ());
        }
        tickPart(this.arm1,isFakeDead() ? new Vec3(0.0,0,-0.5) :new Vec3(0.3,0.5D,-0.8));
        tickPart(this.arm2,isFakeDead() ? new Vec3(0.5,0,-1) :new Vec3(0.3,1D,-0.8));
        tickPart(this.arm3,isFakeDead() ? new Vec3(0.6,0,-1.5) :new Vec3(0.3,1.5D,-0.8));
        tickPart(this.arm4,isFakeDead() ? new Vec3(0.6,0,-2) :new Vec3(0.3,2D,-0.8));
        tickPart(this.totem,isFakeDead() ? new Vec3(-0.2,0.5D,0) :new Vec3(0.5,1.8D,0));

        for(int l = 0; l < this.subEntities.length; ++l) {
            this.subEntities[l].xo = avec3[l].x;
            this.subEntities[l].yo = avec3[l].y;
            this.subEntities[l].zo = avec3[l].z;
            this.subEntities[l].xOld = avec3[l].x;
            this.subEntities[l].yOld = avec3[l].y;
            this.subEntities[l].zOld = avec3[l].z;
        }
    }

    public InteractionResult interact(HevokerPart hevokerPart, Player player, InteractionHand hand) {
        if (this.isFakeDead() && hevokerPart == totem && reviveTimer > 20){
            this.hurt(this.damageSources().freeze(),Float.MAX_VALUE);
            createTotem();
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }
    public void createTotem(){
        ItemStack stack = new ItemStack(Items.TOTEM_OF_UNDYING);
        ItemEntity entity = new ItemEntity(level(),this.getX(),this.getY(),this.getZ(),stack);
        level().addFreshEntity(entity);
    }


    protected SoundEvent getAmbientSound() {
        return Ssounds.HEVOKER_AMBIENT.get();
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

    public void performTelekineticThrow(){
        AABB aabb = this.getBoundingBox().inflate(8);
        List<Entity> entities = level().getEntities(this,aabb,entity -> {return entity instanceof LivingEntity living && this.TARGET_SELECTOR.test(living);});
        if (entities.size() > 1){
            for (Entity entity : entities){
                entity.setDeltaMovement(entity.getDeltaMovement().add(0,1,0));
            }
            this.swing(InteractionHand.MAIN_HAND);
        }
    }
}
