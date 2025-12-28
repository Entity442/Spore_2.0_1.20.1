package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.CalamityInfectedCommand;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.ScatterShotRangedGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SporeBurstSupport;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SummonScentInCombat;
import com.Harbinger.Spore.Sentities.AI.FloatDiveGoal;
import com.Harbinger.Spore.Sentities.AI.LeapGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.FallenMultipart.HowitzerArm;
import com.Harbinger.Spore.Sentities.HitboxesForParts;
import com.Harbinger.Spore.Sentities.Projectile.FleshBomb;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import com.Harbinger.Spore.Sentities.Utility.NukeEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static com.Harbinger.Spore.ExtremelySusThings.Utilities.biomass;

public class Howitzer extends Calamity implements TrueCalamity, RangedAttackMob {
    public static final EntityDataAccessor<Float> RIGHT_ARM = SynchedEntityData.defineId(Howitzer.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Float> LEFT_ARM = SynchedEntityData.defineId(Howitzer.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Integer> ORES = SynchedEntityData.defineId(Howitzer.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> NUKE = SynchedEntityData.defineId(Howitzer.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> SELF_DETONATION = SynchedEntityData.defineId(Howitzer.class, EntityDataSerializers.INT);
    private final CalamityMultipart[] subEntities;
    public final CalamityMultipart rightArm;
    public final CalamityMultipart leftArm;
    public final CalamityMultipart mouth;
    public int getLeapTime = 0;
    @Nullable
    private BlockPos Targetpos;
    public Howitzer(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.rightArm = new CalamityMultipart(this, "rightarm", 2F, 4F);
        this.leftArm = new CalamityMultipart(this, "leftarm", 2F, 4F);
        this.mouth = new CalamityMultipart(this, "mouth", 4F, 3F);
        this.subEntities = new CalamityMultipart[]{ this.rightArm, this.leftArm,this.mouth};
        this.setMaxUpStep(1.5F);
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.length + 1) + 1);
    }
    @Override
    public void setId(int p_20235_) {
        super.setId(p_20235_);
        for (int i = 0; i < this.subEntities.length; i++)
            this.subEntities[i].setId(p_20235_ + i + 1);
    }

    @Override
    public double getDamageCap() {
        return SConfig.SERVER.howit_dpsr.get();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.howit_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.howit_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.howit_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 128)
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
    public boolean doHurtTarget(Entity entity) {
        this.playSound(Ssounds.LANDING.get(),0.5f,0.5f);
        return super.doHurtTarget(entity);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3,new LeapGoal(this,0.9f){
            @Override
            public boolean canUse() {
                return Howitzer.this.getGetLeapTime() <= 0 && Howitzer.this.hasBothArms() && Howitzer.this.isInMeleeRange() && super.canUse();
            }
            @Override
            public void start() {
                super.start();
                Howitzer.this.setLeapTicks(200);
            }
        });
        this.goalSelector.addGoal(4,new AOEMeleeAttackGoal(this,1,true,2,5,e-> {return this.TARGET_SELECTOR.test(e);}){
            @Override
            public boolean canUse() {
                return Howitzer.this.isInMeleeRange() && super.canUse();
            }
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                float f = Howitzer.this.getBbWidth();
                return (double)(f * 1.5F * f * 1.5F + entity.getBbWidth());
            }
        });
        this.goalSelector.addGoal(4, new HowitzerRangedAttackGoal(this,1,80,64,1,5){
            @Override
            public boolean canUse() {
                return !Howitzer.this.isInMeleeRange() && super.canUse();
            }
        });
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.2));
        this.goalSelector.addGoal(5, new SearchAroundGoal(this));
        this.goalSelector.addGoal(6, new FloatDiveGoal(this));
        this.goalSelector.addGoal(6,new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7,new SummonScentInCombat(this));
        this.goalSelector.addGoal(8,new SporeBurstSupport(this));
        this.goalSelector.addGoal(9,new RandomStrollGoal(this , 1));
    }
    public static class HowitzerRangedAttackGoal extends ScatterShotRangedGoal {
        public HowitzerRangedAttackGoal(RangedAttackMob mob, double speed, int interval, float range, int min, int max) {
            super(mob, speed, interval, range, min, max);
        }
        private int getBurnable(LivingEntity target){
            AABB aabb = target.getBoundingBox().inflate(4);
            List<BlockPos> burnable_material = new ArrayList<>();
            for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                if (mob.level().getBlockState(blockpos).isFlammable(mob.level(),blockpos, Direction.UP)){
                    burnable_material.add(blockpos);
                }
            }
            return burnable_material.size();
        }

        @Override
        public void tick() {
            double d0 = this.mob.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());
            boolean flag = this.mob.getSensing().hasLineOfSight(this.target);
            if (flag) {
                ++this.seeTime;
            } else {
                this.seeTime = 0;
            }

            if (!(d0 > (double)this.attackRadiusSqr) && this.seeTime >= 5) {
                this.mob.getNavigation().stop();
            } else {
                this.mob.getNavigation().moveTo(this.target, this.speedModifier);
            }

            this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
            if (--this.attackTime == 0) {
                if (!flag) {
                    return;
                }
                RandomSource randomSource = RandomSource.create();
                int shot = randomSource.nextInt(this.minShots,this.maxShots + getExtraShots());

                float f = (float)Math.sqrt(d0) / this.attackRadius;
                float f1 = getBurnable(target);
                for (int i = 0; i<shot;++i){
                    this.rangedAttackMob.performRangedAttack(this.target, f1);
                }
                this.attackTime = Mth.floor(f * (float)(attackInterval) + (float)this.attackInterval);
            } else if (this.attackTime < 0) {
                this.attackTime = Mth.floor(Mth.lerp(Math.sqrt(d0) / (double)this.attackRadius, (double)this.attackInterval, (double)this.attackInterval));
            }
        }
    }
    @Override
    public void aiStep() {
        Vec3[] avec3 = new Vec3[this.subEntities.length];
        for(int j = 0; j < this.subEntities.length; ++j) {
            avec3[j] = new Vec3(this.subEntities[j].getX(), this.subEntities[j].getY(), this.subEntities[j].getZ());
        }
        this.tickPart(this.mouth, Vec3.ZERO,5);
        if (getRightArmHp()>0){
            this.tickPart(this.rightArm, new Vec3(-3.85D,0D,4D));
        }else{
            this.tickPart(this.rightArm, Vec3.ZERO);
            rightArm.getBoundingBox().inflate(1,0.3,1);
        }
        if (getLeftArmHp() >0){
            this.tickPart(this.leftArm, new Vec3(3.85D,0D,-4D));
        }else{
            this.tickPart(this.leftArm, Vec3.ZERO);
            leftArm.getBoundingBox().inflate(1,0.3,1);
        }
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
    public void tickDetonation(){
        if (entityData.get(SELF_DETONATION) >= 30){
            NukeEntity nukeEntity = new NukeEntity(Sentities.NUKE.get(), level());
            nukeEntity.setInitRange(3f);
            nukeEntity.setRange((float) (SConfig.SERVER.nuke_range.get()*2f));
            nukeEntity.setInitDuration(0);
            nukeEntity.setDuration(SConfig.SERVER.nuke_time.get());
            nukeEntity.setDamage((float) (SConfig.SERVER.nuke_damage.get()*1f));
            nukeEntity.livingEntityPredicate = this.TARGET_SELECTOR;
            nukeEntity.setPos(this.getX(),this.getY(),this.getZ());
            level().addFreshEntity(nukeEntity);
            if (level() instanceof ServerLevel serverLevel){
                Utilities.explodeCircle(serverLevel, this,this.getOnPos(), 15.0, (float) (SConfig.SERVER.howit_damage.get() * 1f),8, entity -> {return entity instanceof LivingEntity livingEntity && TARGET_SELECTOR.test(livingEntity);});
            }
            discard();
        }else {
            entityData.set(SELF_DETONATION,entityData.get(SELF_DETONATION)+1);
        }
    }
    public int getSelfDetonation(){
        return entityData.get(SELF_DETONATION);
    }
    public boolean hasBothArms(){
        return this.getRightArmHp()>0 && this.getLeftArmHp()>0;
    }
    public boolean isInMeleeRange(){
        LivingEntity living = this.getTarget();
        return living != null && this.distanceToSqr(living) < 200;
    }
    public int getGetLeapTime(){
        return getLeapTime;
    }
    public void setLeapTicks(int i){
        getLeapTime = i;
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

    public void recreateFromPacket(ClientboundAddEntityPacket entityPacket) {
        super.recreateFromPacket(entityPacket);
        if (true) return;
        CalamityMultipart[] calamityMultiparts = this.getSubEntities();

        for(int i = 0; i < calamityMultiparts.length; ++i) {
            calamityMultiparts[i].setId(i + entityPacket.getId());
        }
    }
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        if (calamityMultipart == this.mouth){
            this.hurt(source,value*2f);
        }else if (calamityMultipart == this.rightArm){
            this.hurt(source,value *1.5f);
            float lostHealth = getRightArmHp()-this.getDamageAfterArmorAbsorb(source,value);
            this.setRightArmHp(lostHealth > 0 ? lostHealth : getRightArmHp() != 0 ? summonDetashedPart(true) : 0f);
        }else if (calamityMultipart == this.leftArm){
            this.hurt(source,value*1.5f);
            float lostHealth = getLeftArmHp()-this.getDamageAfterArmorAbsorb(source,value);
            this.setLeftArmHp(lostHealth > 0 ? lostHealth : getLeftArmHp() != 0 ? summonDetashedPart(false) : 0f);
        } else{
            this.hurt(source,value );
        }
        return true;
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getEntity() != null && this.random.nextFloat() <0.2f){setTarget(null);}
        if (source.is(DamageTypes.FREEZE)){
            entityData.set(NUKE,0);
        }
        if (getHealth() <= 50f && isRadioactive() && getSelfDetonation() <= 0){
            tickDetonation();
        }
        return super.hurt(source, amount);
    }

    @Override
    public int chemicalRange() {
        return 16;
    }

    @Override
    public List<? extends String> buffs() {
        return SConfig.SERVER.howit_buffs.get();
    }

    @Override
    public List<? extends String> debuffs() {
        return SConfig.SERVER.howit_debuffs.get();
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RIGHT_ARM, this.getMaxArmHp());
        this.entityData.define(LEFT_ARM, this.getMaxArmHp());
        this.entityData.define(ORES, 0);
        this.entityData.define(NUKE, 0);
        this.entityData.define(SELF_DETONATION, 0);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("right_arm", entityData.get(RIGHT_ARM));
        tag.putFloat("left_arm",entityData.get(LEFT_ARM));
        tag.putInt("ores",entityData.get(ORES));
        tag.putInt("nuke",entityData.get(NUKE));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(RIGHT_ARM, tag.getFloat("right_arm"));
        entityData.set(LEFT_ARM,tag.getFloat("left_arm"));
        entityData.set(ORES,tag.getInt("ores"));
        entityData.set(NUKE,tag.getInt("nuke"));
    }
    public float getRightArmHp(){
        return entityData.get(RIGHT_ARM);
    }
    public void setRightArmHp(float i){
        entityData.set(RIGHT_ARM,i);
    }
    public float getLeftArmHp(){
        return entityData.get(LEFT_ARM);
    }
    public void setLeftArmHp(float i){
        entityData.set(LEFT_ARM,i);
    }
    public float getMaxArmHp(){
        return (float) (SConfig.SERVER.howit_hp.get()/4.0f);
    }

    @Override
    public boolean hasLineOfSight(Entity entity) {
        if (canEntitySeeTheSky(entity) || entity.distanceToSqr(this) < 200){
            return true;
        }else
            return super.hasLineOfSight(entity);
    }

    private boolean canEntitySeeTheSky(Entity entity){
        return entity.level().canSeeSky(entity.getOnPos());
    }

    @Override
    protected int calculateFallDamage(float p_149389_, float p_149390_) {
        if (this.getLeapTime >140){
            damageStomp(this.level(),this.getOnPos(),12,8);
        }
        return super.calculateFallDamage(p_149389_, p_149390_)-25;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getGetLeapTime() > 0){
            getLeapTime--;
        }
        if (this.tickCount % 20 == 0 && this.getHealth() == this.getMaxHealth()){
            if (this.getRightArmHp() < this.getMaxArmHp()){
                this.setRightArmHp(getRightArmHp()+1);
            }
            if (this.getLeftArmHp() < this.getMaxArmHp()){
                this.setLeftArmHp(getLeftArmHp()+1);
            }
        }
        if (this.tickCount % 20 == 0){
            createBomb();
            if (isRadioactive()){
                spreadRadiation();
            }
        }
        if (this.tickCount % 200 == 0){
            searchBlocks();
        }
        if (isRadioactive() && getSelfDetonation() > 0){
            if (!level().isClientSide && tickCount % 20 == 0){
                tickDetonation();
            }
            for (int i = 0; i < 360; i++) {
                if (i % 40 == 0) {
                    this.level().addParticle(ParticleTypes.LARGE_SMOKE,
                            this.getX() , this.getY()+2, this.getZ() ,
                            Math.cos(i) * 0.25d, 0.25d, Math.sin(i) * 0.25d);
                    this.level().addParticle(ParticleTypes.LARGE_SMOKE,
                            this.getX() , this.getY()+2, this.getZ() ,
                            Math.sin(i) * 0.25d,  -0.25d, Math.cos(i) * 0.25d);
                }
            }
        }
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.howit_loot.get();
    }

    public float summonDetashedPart(boolean isRight){
        double offset = isRight ? 3D : -3D;
        Vec3 vec3 = (new Vec3(0.0D, 0.0D, offset)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        HowitzerArm arm = new HowitzerArm(Sentities.HOWIT_ARM.get(),this.level());
        arm.setRight(isRight);
        arm.setNuclear(this.isRadioactive());
        arm.moveTo(this.getX() + vec3.x, this.getY() + 1.6,this.getZ()+ vec3.z);
        level().addFreshEntity(arm);
        this.playSound(Ssounds.LIMB_SLASH.get());
        return 0;
    }

    protected void damageStomp(Level level, BlockPos pos, double range, double damageRange){
        AABB aabb = this.getBoundingBox().inflate(damageRange);
        List<Entity> entities = level.getEntities(this,aabb,entity -> {return entity instanceof LivingEntity living && TARGET_SELECTOR.test(living);});
        for(int i = 0; i <= 2*range; ++i) {
            for(int j = 0; j <= 2*range; ++j) {
                for(int k = 0; k <= 2*range; ++k) {
                    double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                    if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                        if (distance<range+(0.5)){
                            BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                            BlockState state = level.getBlockState(blockpos);
                            boolean airBelow = level.getBlockState(blockpos.below()).isAir();
                            if (level instanceof ServerLevel serverLevel){
                                if (airBelow && state.getDestroySpeed(level,pos) >= 0 && Math.random() < 0.3){
                                    FallingBlockEntity.fall(serverLevel,blockpos,state);
                                    serverLevel.removeBlock(blockpos,false);
                                }
                            }
                        }}}}}
        for (Entity entity : entities){
            if (entity instanceof LivingEntity living)
                for (int i = 0;i<2;i++){
                this.doHurtTarget(living);
                living.hurtTime = 0;
                living.invulnerableTime = 0;
            }
        }
        this.playSound(Ssounds.LANDING.get());
    }
    private FleshBomb.BombType compareEntity(LivingEntity living,int burnable){
        AABB aabb = living.getBoundingBox().inflate(4);
        List<Entity> extra_targets = level().getEntities(living,aabb,entity -> {return entity instanceof LivingEntity livingEntity && TARGET_SELECTOR.test(livingEntity);});
        if (this.isRadioactive() && this.hasNuke() && (living.getMaxHealth() >= 100 || living.getArmorValue() >= 20)){
            this.entityData.set(NUKE,0);
            return FleshBomb.BombType.NUCLEAR;
        }
        if (burnable > 8){
            return Math.random() < 0.3f ? FleshBomb.BombType.BILE : FleshBomb.BombType.FLAME;
        }
        if (SConfig.SERVER.corrosion.get().contains(living.getEncodeId())){
            return FleshBomb.BombType.ACID;
        }
        if (extra_targets.size() > 1 || living.getArmorValue() >=10){
            return FleshBomb.BombType.BILE;
        }
        return FleshBomb.BombType.BASIC;

    }

    public boolean isRadioactive(){
        return this.entityData.get(ORES) >= 100;
    }

    @Override
    public void ActivateAdaptation() {
        super.ActivateAdaptation();
        this.entityData.set(ORES,100);
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float val) {
        float damage = (float) (SConfig.SERVER.howit_ranged_damage.get() * SConfig.SERVER.global_damage.get());
        FleshBomb bomb = new FleshBomb(level(),this,damage,compareEntity(entity, (int) val),random.nextInt(4,7));
        bomb.setLivingEntityPredicate(TARGET_SELECTOR);
        bomb.setCarrier(Math.random() < 0.2f);
        bomb.setTarget(entity);
        double dx = entity.getX() - this.getX();
        double dz = entity.getZ() - this.getZ();
        double dy = entity.getY() - this.getY();
        float value = random.nextFloat() * 0.5f;
        bomb.moveTo(this.getX() + value,this.getY()+7,this.getZ()+ value);
        bomb.shoot(dx * 0.085F,6.5f+ Math.hypot(dx, dz) * 0.02F +(dy>0?dy:0*0.5),dz  * 0.085F, 2f, 14.0F);
        level().addFreshEntity(bomb);
        this.playSound(Ssounds.FALLING_BOMB.get());
    }
    protected SoundEvent getAmbientSound() {
        return Ssounds.HOWITZER_AMBIENT.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.RAVAGER_STEP;
    }

    @Override
    protected void grief(AABB aabb) {
        boolean flag = false;
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (blockstate.is(biomass)){
                flag = this.level().setBlock(blockpos, Sblocks.MEMBRANE_BLOCK.get().defaultBlockState(), 3) || flag;
                breakCounter = 0;
            }else{
                if (blockstate.getDestroySpeed(level(), blockpos) < getDestroySpeed() && blockstate.getDestroySpeed(level(), blockpos) >= 0 && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                    if (blockstate.is(TagKey.create(Registries.BLOCK,new ResourceLocation("forge:ores")))){
                        this.entityData.set(ORES,this.entityData.get(ORES)+1);
                    }
                    flag = this.level().destroyBlock(blockpos, false, this) || flag;
                    breakCounter = 0;
                }
            }
        }
    }

    public static class SearchAroundGoal extends Goal {
        private final Howitzer howitzer;
        public int tryTicks;

        public SearchAroundGoal(Howitzer specter){
            this.howitzer = specter;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return howitzer.getTargetPos() != null && howitzer.getTarget() == null;
        }

        protected void moveToBlock(BlockPos pos){
            if (pos != null)
                howitzer.navigation.moveTo(pos.getX()+0.5D,pos.getY()+1D,pos.getZ()+0.5D,1);
        }
        @Override
        public void start() {
            this.moveToBlock(howitzer.getTargetPos());
            this.tryTicks = 0;
            super.start();
        }


        @Override
        public boolean canContinueToUse() {
            return howitzer.getTarget() == null;
        }

        public boolean shouldRecalculatePath() {
            return this.tryTicks % 40 == 0;
        }


        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            super.tick();
            ++this.tryTicks;
            BlockPos pos = howitzer.getTargetPos();
            if (pos != null && shouldRecalculatePath()){
                moveToBlock(pos);
            }
            if (pos != null && pos.closerToCenterThan(this.howitzer.position(),7f)){
                howitzer.level().destroyBlock(pos,false,howitzer);
                howitzer.entityData.set(ORES,howitzer.entityData.get(ORES)+1);
                howitzer.setTargetPos((BlockPos) null);
                howitzer.searchBlocks();
            }
        }
    }
    public boolean hasLineOfSightBlocks(BlockPos pos) {
        BlockHitResult raytraceresult = this.level().clip(new ClipContext(this.getEyePosition(1.0F), new Vec3(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        BlockPos position = raytraceresult.getBlockPos();
        return pos.equals(position) || this.level().isEmptyBlock(pos) || this.level().getBlockEntity(pos) == this.level().getBlockEntity(position);
    }
    public void searchBlocks(){
        AABB aabb = this.getBoundingBox().inflate(32,4,32);
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState block = level().getBlockState(blockpos);
            if (block.is(TagKey.create(Registries.BLOCK,new ResourceLocation("forge:ores")))){
                if (hasLineOfSightBlocks(blockpos) && this.random.nextFloat() < 0.5f){
                    setTargetPos(blockpos);
                    break;
                }
            }
        }
    }

    @Nullable
    private BlockPos getTargetPos() {
        return Targetpos;
    }
    public void setTargetPos(@Nullable BlockPos pos) {
        this.Targetpos = pos;
    }
    public boolean hasNuke(){
        return entityData.get(NUKE) > 60;
    }

    protected void createBomb(){
        if (isRadioactive() && !hasNuke()){
            entityData.set(NUKE,entityData.get(NUKE)+1);
        }
    }

    @Override
    public String getMutation() {
        if (isRadioactive()){
            return "spore.entity.variant.irradiated";
        }
        return super.getMutation();
    }
    public void spreadRadiation(){
        List<Entity> entities = level().getEntities(this,this.getBoundingBox().inflate(12));
        for (Entity entity : entities){
            if (entity instanceof LivingEntity living && TARGET_SELECTOR.test(living)){
                addEffect(living);
            }
        }
    }

    public void addEffect(LivingEntity living){
        if (ModList.get().isLoaded("alexscaves")){
            MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation("alexscaves:irradiated"));
            if (effect != null)
                living.addEffect(new MobEffectInstance(effect,400,0));
        }else{
            living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,400,0));
        }
    }

    @Override
    public boolean getAdaptation() {
        return isRadioactive();
    }

    private final List<HitboxesForParts> innatePartList = List.of(HitboxesForParts.HOWI_CANNON1,
            HitboxesForParts.HOWI_CANNON2, HitboxesForParts.HOWI_CANNON3,HitboxesForParts.HOWI_LEFT_LEG,
            HitboxesForParts.HOWI_RIGHT_LEG,HitboxesForParts.HOWI_SACK);
    @Override
    public List<HitboxesForParts> parts() {
        List<HitboxesForParts> values = new ArrayList<>();
        if (getRightArmHp() > 0){
            values.add(HitboxesForParts.HOWI_RIGHT_ARM);
        }
        if (getLeftArmHp() > 0){
            values.add(HitboxesForParts.HOWI_LEFT_ARM);
        }
        for (HitboxesForParts hitboxes : innatePartList){
            HitboxesForParts part = calculateChance(hitboxes,0.65f);
            if (part != null){
                values.add(part);
            }
        }
        return values;
    }
}
