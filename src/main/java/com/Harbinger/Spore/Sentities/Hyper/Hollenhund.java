package com.Harbinger.Spore.Sentities.Hyper;


import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.Projectile.BileProjectile;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Hollenhund extends Hyper implements RangedAttackMob {
    private static final EntityDataAccessor<Boolean> UNDERGROUND = SynchedEntityData.defineId(Hollenhund.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> RANGED = SynchedEntityData.defineId(Hollenhund.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> BORROW = SynchedEntityData.defineId(Hollenhund.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> EMERGE = SynchedEntityData.defineId(Hollenhund.class, EntityDataSerializers.INT);
    protected List<spikeClaw> claws = new ArrayList<>();
    private int attackAnimationTick;
    public Hollenhund(EntityType<? extends Infected> type, Level level) {
        super(type, level);
    }
    public List<spikeClaw> getClaws(){
        return claws;
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.hollen_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.hollen_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.hollen_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.hollen_loot.get();
    }


    public void setUnderground(boolean value){
        entityData.set(UNDERGROUND,value);
    }
    public boolean isUnderground(){return entityData.get(UNDERGROUND);}
    public void setRanged(boolean value){
        entityData.set(RANGED,value);
    }
    public boolean isRanged(){return entityData.get(RANGED);}
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("underground",entityData.get(UNDERGROUND));
        tag.putBoolean("ranged",entityData.get(RANGED));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(UNDERGROUND, tag.getBoolean("underground"));
        entityData.set(RANGED, tag.getBoolean("ranged"));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(UNDERGROUND,false);
        entityData.define(RANGED,false);
        entityData.define(BORROW, 0);
        entityData.define(EMERGE, 0);
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3,new HollenAoeMeleeRangedAattack(this,true,3,entity -> TARGET_SELECTOR.test(entity)));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }
    public int getAttackAnimationTick(){
        return attackAnimationTick;
    }
    @Override
    public void tick() {
        super.tick();

        if (this.tickCount % 20 == 0){
            if ((!isSoftEnough(getOnPos()) || isInFluidType()) && isUnderground() && !isEmerging()){
                tickEmerging();
            }
        }
        if (isRanged() && !isUnderground() && this.onGround()){
            this.makeStuckInBlock(getBlockStateOn(), new Vec3(0, 1, 0));
        }
        if (isEmerging() || isBurrowing()){
            SummonParticles(getOnPos());
        }
        if (this.navigation.isInProgress() && isUnderground()){
            SummonParticles(getOnPos());
        }
        if (this.isEmerging()){
            this.tickEmerging();
        } else if (this.isBurrowing()){
            this.tickBurrowing();
        }
        if (attackAnimationTick > 0){
            attackAnimationTick--;
        }
        if (tickCount % 5 == 0 && isUnderground() && !isEmerging() && onGround() && claws.size() < 2){
            claws.add(new spikeClaw(random.nextInt(-20,21),random.nextInt(360),this,random.nextInt(25,45)));
        }

        if (!claws.isEmpty()){
            Iterator<spikeClaw> it = claws.iterator();

            while (it.hasNext()) {
                spikeClaw claw = it.next();

                claw.tickClaw();

                if (claw.kill()) {
                    it.remove();
                }
            }
        }
        if (this.tickCount % 10 == 0 && !isRanged()){
            Entity target = this.getTarget();
            if (target == null){
                return;
            }
            if (target.distanceToSqr(this) > 100 && !isUnderground() && !isBurrowing() && isSoftEnough(getOnPos())){
                tickBurrowing();
            }
            if (target.distanceToSqr(this) < 50 && isUnderground() && !isEmerging()){
                tickEmerging();
            }
        }
    }
    private void SummonParticles(BlockPos pos){
        Item item = level().getBlockState(pos).getBlock().asItem();
        for (int l = 0 ;l<this.random.nextInt(3,6);l++){
            if (level() instanceof ServerLevel serverLevel) {
                int xi = random.nextInt(-1,1);
                int zi = random.nextInt(-1,1);
                if (item != ItemStack.EMPTY.getItem()) {
                    serverLevel.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(item)), getX() + xi, getY() - 0.1D, getZ() + zi, 3,
                            ((double) random.nextFloat() - 1D) * 0.08D, ((double) random.nextFloat() - 1D) * 0.08D, ((double) random.nextFloat() - 1D) * 0.08D, 0.15F);
                }
            }
        }
    }

    @Override
    public boolean isInvisible() {
        return isUnderground() && !isEmerging();
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return super.canDrownInFluidType(type) && !isUnderground();
    }

    public boolean isSoftEnough(BlockPos pos){
        return level().getBlockState(pos).getDestroySpeed(level(),pos) < 4;
    }
    public void startBurrowing() {
        if (!isBurrowing() && !isUnderground()) {
            entityData.set(BORROW, 1);
        }
    }

    public void startEmerging() {
        if (!isEmerging() && isUnderground()) {
            entityData.set(EMERGE, 1);
        }
    }
    public boolean isEmerging(){
        return this.entityData.get(EMERGE) > 0;
    }
    public void tickEmerging(){
        int emerging = this.entityData.get(EMERGE);
        if (emerging > getEmerge_tick()){
            this.setUnderground(false);
            emerging = -1;
        }
        this.entityData.set(EMERGE, emerging + 1);
    }
    public boolean isBurrowing(){
        return this.entityData.get(BORROW) > 0;
    }
    public void tickBurrowing(){
        int burrowing = this.entityData.get(BORROW);
        if (burrowing > getBorrow_tick()) {
            this.setUnderground(true);
            burrowing = -1;
        }
        this.entityData.set(BORROW, burrowing + 1);
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        if (Math.random() < 0.25) {
            entity.teleportTo(
                    entity.getX(),
                    entity.getY() - entity.getBbHeight() * 1.25,
                    entity.getZ()
            );
        }
        if (entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.HUNGER, 1200, 0));
        }
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        this.playSound(Ssounds.REAPER_ATTACK.get());
        return super.doHurtTarget(entity);
    }

    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
        }else {
            super.handleEntityEvent(value);
        }
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.IN_FIRE) || source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.EXPLOSION)){
            return super.hurt(source, amount);
        }
        if (isUnderground() || isEmerging() || isBurrowing()){
            return false;
        }
        if (isRanged()){
            setRanged(false);
        }
        return super.hurt(source, amount);
    }


    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {
        super.onSyncedDataUpdated(accessor);
        if (UNDERGROUND.equals(accessor)){
            refreshDimensions();
        }
    }
    @Override
    public EntityDimensions getDimensions(Pose pose) {
        if (isUnderground()){
            return super.getDimensions(pose).scale(1.2f,0.1f);
        }else {
            return super.getDimensions(pose);
        }
    }

    public int getEmerge(){return entityData.get(EMERGE);}
    public int getBorrow(){return entityData.get(BORROW);}

    public int getBorrow_tick() {
        return 40;
    }

    public int getEmerge_tick() {
        return 40;
    }

    protected SoundEvent getAmbientSound() {
        return isUnderground() ? null : Ssounds.HOLLEN_AMBIENT.get();
    }


    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        if (isUnderground()){
            this.playSound(state.getSoundType(level(),pos,this).getBreakSound(), 0.15F, 0.5F);
        }else
             this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        if(!level().isClientSide){
            BileProjectile tumor = new BileProjectile(level(), this,TARGET_SELECTOR);
            double dx = livingEntity.getX() - this.getX();
            double dy = livingEntity.getY() + livingEntity.getEyeHeight();
            double dz = livingEntity.getZ() - this.getZ();
            tumor.setDamage((float) (SConfig.SERVER.hollen_ranged_damage.get() * SConfig.SERVER.global_damage.get()));
            tumor.moveTo(this.getX(), this.getY()+0.5D ,this.getZ());
            tumor.shoot(dx, dy - tumor.getY() + Math.hypot(dx, dz) * 0.001F, dz, 2f, 6.0F);
            level().addFreshEntity(tumor);
        }
        this.playSound(Ssounds.HOLLEN_SPIT.get());
    }

    public static class spikeClaw{
        private final int Zspin;
        private final int Yspin;
        private final Hollenhund parent;
        private final int maxLife;
        private final Vec3 offset;
        private int life = 0;

        public spikeClaw(int zspin, int yspin, Hollenhund parent, int maxLife) {
            Zspin = zspin;
            Yspin = yspin;
            this.parent = parent;
            this.maxLife = maxLife;
            RandomSource randomSource = parent.getRandom();
            float x = (randomSource.nextFloat()-randomSource.nextFloat())/4;
            float z = (randomSource.nextFloat()-randomSource.nextFloat())/4;
            offset = new Vec3(x,0,z);
        }
        public Vec3 getOffset(){return offset;}
        public int getZspin(){return Zspin;}
        public int getYspin(){return Yspin;}

        public void tickClaw(){
            life++;
            if (life == maxLife/2){
                hurtEntities();
            }
        }
        public int getLife(){return life;}
        public int getMaxLife(){return maxLife;}
        public void hurtEntities(){
            AABB aabb = parent.getBoundingBox();
            List<Entity> entities = parent.level().getEntities(parent,aabb);
            if (entities.isEmpty() || parent.level().isClientSide()){
                return;
            }
            for (Entity entity : entities){
                if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
                    parent.doHurtTarget(living);
                }
            }
        }
        public boolean kill(){
            return life >= maxLife;
        }
    }

    public static class HollenAoeMeleeRangedAattack extends Goal {

        private enum AttackMode {
            MELEE,
            POSITIONING,
            RANGED
        }

        protected final Hollenhund mob;
        protected Predicate<LivingEntity> victims;

        private final boolean followingTargetEvenIfNotSeen;

        private Path path;
        private int ticksUntilNextPathRecalculation;
        private int ticksUntilNextAttack;

        private long lastCanUseCheck;

        public double box;

        private AttackMode mode = AttackMode.MELEE;

        private BlockPos rangedPosition;
        private int rangedShotsRemaining;
        private int rangedShotCooldown;

        public HollenAoeMeleeRangedAattack(
                Hollenhund mob,
                boolean follow,
                double hitbox,
                Predicate<LivingEntity> targets
        ) {
            this.mob = mob;
            this.followingTargetEvenIfNotSeen = follow;
            this.box = hitbox;
            this.victims = targets;

            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        protected double getAttackReachSqr(LivingEntity entity) {
            return 6.0D + entity.getBbWidth() * entity.getBbWidth();
        }

        @Override
        public boolean canUse() {

            long gameTime = mob.level().getGameTime();

            if (gameTime - lastCanUseCheck < 20L) {
                return false;
            }

            lastCanUseCheck = gameTime;

            LivingEntity target = mob.getTarget();

            if (target == null || !target.isAlive()) {
                return false;
            }

            path = mob.getNavigation().createPath(target, 0);

            return path != null ||
                    getAttackReachSqr(target) >=
                            mob.distanceToSqr(
                                    target.getX(),
                                    target.getY(),
                                    target.getZ()
                            );
        }

        @Override
        public boolean canContinueToUse() {

            LivingEntity target = mob.getTarget();

            if (target == null || !target.isAlive()) {
                return false;
            }

            if (!followingTargetEvenIfNotSeen) {
                return !mob.getNavigation().isDone();
            }

            if (!mob.isWithinRestriction(target.blockPosition())) {
                return false;
            }

            return !(target instanceof Player player)
                    || (!player.isCreative() && !player.isSpectator());
        }

        @Override
        public void start() {

            mob.setAggressive(true);

            mode = AttackMode.MELEE;

            ticksUntilNextPathRecalculation = 0;
            ticksUntilNextAttack = 0;

            mob.getNavigation().moveTo(path, 1.5);
        }

        @Override
        public void stop() {

            LivingEntity target = mob.getTarget();

            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target)) {
                mob.setTarget(null);
            }

            mob.setAggressive(false);
            mob.getNavigation().stop();

            mob.setRanged(false);

            mode = AttackMode.MELEE;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        private Vec3 getPositionBehindTarget(LivingEntity target) {

            Vec3 look = target.getLookAngle().normalize();

            double distance = 24 + mob.getRandom().nextInt(5);

            return target.position().subtract(look.scale(distance));
        }

        private void beginRangedMode(LivingEntity target) {

            Vec3 pos = getPositionBehindTarget(target);

            rangedPosition = BlockPos.containing(pos);

            rangedShotsRemaining = mob.getRandom().nextInt(5) + 2;

            rangedShotCooldown = 20;

            mob.setRanged(true);

            mode = AttackMode.POSITIONING;
        }

        @Override
        public void tick() {

            LivingEntity target = mob.getTarget();

            if (target == null) {
                return;
            }

            mob.getLookControl().setLookAt(target, 30F, 30F);

            double distanceSq = mob.distanceToSqr(target);

            switch (mode) {

                case MELEE -> tickMelee(target, distanceSq);

                case POSITIONING -> tickPositioning();

                case RANGED -> tickRanged(target);
            }
        }

        private void tickMelee(LivingEntity target, double distanceSq) {

            if (distanceSq > 150
                    && !mob.isUnderground()
                    && !mob.isBurrowing()
                    && mob.isSoftEnough(mob.blockPosition())) {

                mob.startBurrowing();
            }

            if (distanceSq < 75
                    && mob.isUnderground()
                    && !mob.isEmerging()) {

                mob.startEmerging();
            }

            if (distanceSq > 200
                    && !mob.isRanged()
                    && mob.getRandom().nextFloat() < 0.01F) {

                beginRangedMode(target);
                return;
            }

            handlePathing(target, distanceSq);

            ticksUntilNextAttack =
                    Math.max(ticksUntilNextAttack - 1, 0);

            checkAndPerformAttack(target, distanceSq);
        }

        private void tickPositioning() {

            if (rangedPosition == null) {

                mode = AttackMode.MELEE;
                mob.setRanged(false);

                return;
            }

            double distanceToPos =
                    mob.distanceToSqr(
                            rangedPosition.getCenter()
                    );

            if (mob.tickCount % 10 == 0){
                mob.getNavigation().moveTo(
                        rangedPosition.getX(),
                        rangedPosition.getY(),
                        rangedPosition.getZ(),
                        mob.isRanged() ? 2 : 1.5
                );
            }
            if (distanceToPos < 4D) {

                if (mob.isUnderground()) {
                    mob.startEmerging();
                }

                mode = AttackMode.RANGED;
            }
        }

        private void tickRanged(LivingEntity target) {

            mob.getNavigation().stop();

            mob.getLookControl().setLookAt(target, 30F, 30F);

            if (mob.isUnderground()) {
                return;
            }

            if (mob.isEmerging()) {
                return;
            }

            if (rangedShotCooldown > 0) {
                rangedShotCooldown--;
                return;
            }

            if (mob.hasLineOfSight(target)) {

                mob.performRangedAttack(target, 1.0F);

                rangedShotsRemaining--;

                rangedShotCooldown = 40;
            }

            if (rangedShotsRemaining <= 0) {

                mob.setRanged(false);

                if (!mob.isUnderground()
                        && !mob.isBurrowing()
                        && mob.isSoftEnough(mob.blockPosition())) {

                    mob.startBurrowing();
                }

                mode = AttackMode.MELEE;
            }
        }

        private void handlePathing(LivingEntity target, double distanceSq) {

            ticksUntilNextPathRecalculation =
                    Math.max(
                            ticksUntilNextPathRecalculation - 1,
                            0
                    );

            if ((followingTargetEvenIfNotSeen
                    || mob.getSensing().hasLineOfSight(target))
                    && ticksUntilNextPathRecalculation <= 0) {

                ticksUntilNextPathRecalculation =
                        4 + mob.getRandom().nextInt(7);

                if (distanceSq > 1024.0D) {
                    ticksUntilNextPathRecalculation += 10;
                } else if (distanceSq > 256.0D) {
                    ticksUntilNextPathRecalculation += 5;
                }

                mob.getNavigation().moveTo(
                        target,
                        1.5
                );
            }
        }

        protected void checkAndPerformAttack(
                LivingEntity entity,
                double distanceSq
        ) {

            if (mob.isUnderground() && !mob.isEmerging()) {
                return;
            }

            double reach = getAttackReachSqr(entity);

            if (distanceSq <= reach
                    && ticksUntilNextAttack <= 0
                    && mob.hasLineOfSight(entity)) {

                ticksUntilNextAttack = adjustedTickDelay(20);

                mob.swing(InteractionHand.MAIN_HAND);

                mob.doHurtTarget(entity);

                AABB hitbox =
                        entity.getBoundingBox().inflate(box);

                List<LivingEntity> targets =
                        entity.level().getEntitiesOfClass(
                                LivingEntity.class,
                                hitbox,
                                victims
                        );

                for (LivingEntity victim : targets) {

                    if (victim != entity) {
                        mob.doHurtTarget(victim);
                    }
                }
            }
        }
    }
}
