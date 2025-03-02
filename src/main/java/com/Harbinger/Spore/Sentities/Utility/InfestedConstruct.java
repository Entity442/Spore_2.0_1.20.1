package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.HybridPathNavigation;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.Projectile.ThrownBlockProjectile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static com.Harbinger.Spore.ExtremelySusThings.Utilities.biomass;

public class InfestedConstruct extends UtilityEntity implements RangedAttackMob, Enemy {
    public static final EntityDataAccessor<Boolean> ACTIVE = SynchedEntityData.defineId(InfestedConstruct.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> DISPENSER = SynchedEntityData.defineId(InfestedConstruct.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Float> MACHINE_HEALTH = SynchedEntityData.defineId(InfestedConstruct.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Integer> METAL_RESERVE = SynchedEntityData.defineId(InfestedConstruct.class, EntityDataSerializers.INT);
    private static final Double maXmachineHp = SConfig.SERVER.inf_machine_hp.get();
    private static final List<? extends String> metalAndValues = SConfig.SERVER.cons_blocks.get();
    @Nullable
    private BlockPos Targetpos;
    private int attackAnimationTick;
    public InfestedConstruct(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.navigation = new WallClimberNavigation(this,this.level());
        this.setMaxUpStep(1.0F);
    }

    @Override
    public List<? extends String> getDropList() {
        return isActive() ? SConfig.DATAGEN.construct_loot.get() : null;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.inf_cons_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.inf_cons_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.inf_cons_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2);
    }
    @Override
    public boolean removeWhenFarAway(double value) {
        if (this.level() instanceof ServerLevel serverLevel){
            SporeSavedData data = SporeSavedData.getDataLocation(serverLevel);
            return data != null && data.getAmountOfHiveminds() >= SConfig.SERVER.proto_spawn_world_mod.get() && value > 256;
        }
        return false;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        entity.hurtMarked = true;
        entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, 0.8, 0.0));
        this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        if (entity instanceof LivingEntity livingEntity){
            livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),600,0));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,600,0));
        }
        return super.doHurtTarget(entity);
    }

    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
            this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        } else {
            super.handleEntityEvent(value);
        }
    }

    public int getAttackAnimationTick() {
        return this.attackAnimationTick;
    }

    private boolean canRangeAttack(){
        LivingEntity livingEntity = this.getTarget();
        return isActive() && livingEntity != null && livingEntity.getY() - 2 > this.getY();
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(ACTIVE,true);
        entityData.define(DISPENSER,false);
        entityData.define(METAL_RESERVE,0);
        entityData.define(MACHINE_HEALTH,(float)(maXmachineHp * 1f));
    }
    public void setActive(boolean value){entityData.set(ACTIVE,value);}
    public boolean isActive(){return entityData.get(ACTIVE);}
    public void setDispenser(boolean value){entityData.set(DISPENSER,value);}
    public boolean isDispenser(){return entityData.get(DISPENSER);}
    public void setMachineHealth(float value){entityData.set(MACHINE_HEALTH,value);}
    public float getMachineHealth(){return entityData.get(MACHINE_HEALTH);}
    public void setMetalReserve(int value){entityData.set(METAL_RESERVE,value);}
    public int getMetalReserve(){return entityData.get(METAL_RESERVE);}
    @Nullable
    public BlockPos getTargetPos() {
        return Targetpos;
    }
    public void setTargetPos(@Nullable BlockPos pos) {
        this.Targetpos = pos;
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setActive(tag.getBoolean("active"));
        setMachineHealth(tag.getFloat("machine_hp"));
        entityData.set(DISPENSER,tag.getBoolean("dispenser"));
        entityData.set(METAL_RESERVE,tag.getInt("metal"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("active",isActive());
        tag.putFloat("machine_hp",getMachineHealth());
        tag.putBoolean("dispenser",entityData.get(DISPENSER));
        tag.putInt("metal",entityData.get(METAL_RESERVE));
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        addTargettingGoals();
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this, 1.2, false,1.5,2,livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 6.0 + entity.getBbWidth() * entity.getBbWidth();}});
        this.goalSelector.addGoal(4,new SearchAroundGoal(this));
        this.goalSelector.addGoal(5,new RandomStrollGoal(this,1));
    }

    @Override
    public boolean isNoAi() {
        return super.isNoAi() || !isActive();
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }
    private List<DamageSource> resistentSources(){
        List<DamageSource> resistentSources = new ArrayList<>();
        resistentSources.add(level().damageSources().onFire());
        resistentSources.add(level().damageSources().inFire());
        resistentSources.add(level().damageSources().lava());
        resistentSources.add(level().damageSources().hotFloor());
        return resistentSources;
    }


    @Override
    public boolean hurt(DamageSource source, float value) {
        if (this.invulnerableTime == 0){
            value = resistentSources().contains(source) ? value/2:value;
            if (getMachineHealth() > 0f){
                float damage = getDamageAfterArmorAbsorb(source,value);
                setMachineHealth(damage > getMachineHealth() ? 0 : getMachineHealth()-damage);
                this.invulnerableTime = 20;
                hurtTime = 10;
                playHurtSound(source);
            }else{
                return super.hurt(source, value);
            }
            return true;
        }
        return false;
    }
    public boolean hasLineOfSightBlocks(BlockPos pos) {
        BlockHitResult raytraceresult = this.level().clip(new ClipContext(this.getEyePosition(1.0F), new Vec3(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        BlockPos position = raytraceresult.getBlockPos();
        return pos.equals(position) || this.level().isEmptyBlock(pos) || this.level().getBlockEntity(pos) == this.level().getBlockEntity(position);
    }
    @Override
    protected int calculateFallDamage(float p_21237_, float p_21238_) {
        return 0;
    }

    @Override
    public void awardKillScore(Entity p_19953_, int p_19954_, DamageSource p_19955_) {
        super.awardKillScore(p_19953_, p_19954_, p_19955_);
        this.addEffect(new MobEffectInstance(MobEffects.REGENERATION,400,0));
    }
    @Override
    public boolean addEffect(MobEffectInstance effectInstance, @Nullable Entity entity) {
        if (effectInstance.getEffect().isBeneficial() || effectInstance.getEffect() == Seffects.CORROSION.get()){
            return super.addEffect(effectInstance, entity);
        }
        return false;
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        BlockState state = getBlock();
        if(!level().isClientSide && state != null) {
            ThrownBlockProjectile thrownBlockProjectile = new ThrownBlockProjectile(level(),this,10f,state,TARGET_SELECTOR);
            double dx = livingEntity.getX() - this.getX();
            double dy = livingEntity.getY() + livingEntity.getEyeHeight() - 1;
            double dz = livingEntity.getZ() - this.getZ();
            thrownBlockProjectile.moveTo(this.getX(),this.getY()+1.5,this.getZ());
            thrownBlockProjectile.shoot(dx, dy - thrownBlockProjectile.getY() + Math.hypot(dx, dz) * 0.05F, dz, 1f, 6.0F);
            level().addFreshEntity(thrownBlockProjectile);
        }
    }

    public BlockState getBlock(){
        AABB aabb = this.getBoundingBox().inflate(0.2);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (blockstate.getDestroySpeed(level(), blockpos) < 5 && blockstate.getDestroySpeed(level(), blockpos) >= 0 && !blockstate.isAir()) {
                level().destroyBlock(blockpos,false);
                return blockstate;
            }
        }
        return null;
    }

    public Map<Item,Integer> getValues(){
        Map<Item,Integer> values = new HashMap<>();
        for (String string : metalAndValues){
            String[] strings = string.split("\\|");
            int value = Integer.parseInt(strings[1]);
            Item stack = ForgeRegistries.ITEMS.getValue(new ResourceLocation(strings[0]));
            if (stack != null && value > 0){
                values.put(stack,value);
            }
        }
        return values;
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount % 40 == 0){
            if (ForgeEventFactory.getMobGriefingEvent(this.level(), this) && horizontalCollision){
                griefBlocks();
            }
            if (getMachineHealth() < maXmachineHp && entityData.get(METAL_RESERVE) > 0){
                this.setMachineHealth(getMachineHealth()+1);
                entityData.set(METAL_RESERVE,entityData.get(METAL_RESERVE)-1);
            }
            if (hasEffect(Seffects.CORROSION.get())){
                this.setMachineHealth(getMachineHealth()-2);
            }
        }
        if (tickCount % 200 == 0){
            if (!isActive()){
                callUponInfected();
            }
            searchBlocks();
        }
        if (tickCount % 100 == 0 && this.isDispenser() && isActive()){
            LivingEntity target = this.getTarget();
            if (target != null && this.hasLineOfSight(target)){
                performDispenserShot(target);
            }
        }
        if (tickCount % 60 == 0 && this.canRangeAttack()){
            LivingEntity target = this.getTarget();
            if (target != null && this.hasLineOfSight(target)){
                performRangedAttack(target,0);
            }
        }
    }

    private void griefBlocks(){
        AABB aabb = this.getBoundingBox().inflate(0.5D,0,0.5D).move(0,1,0);
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (blockBreakingParameter(blockstate,blockpos)) {
                interactBlock(blockpos,this.level());
            }
        }
    }

    public boolean blockBreakingParameter(BlockState blockstate, BlockPos blockpos) {
        float value = blockstate.getDestroySpeed(this.level(),blockpos);
        return this.tickCount % 20 == 0 && value > 0 && value <=getBreaking();
    }
    public int getBreaking(){
        return SConfig.SERVER.hyper_bd.get();
    }


    public boolean interactBlock(BlockPos blockPos, Level level) {
        BlockState state = level.getBlockState(blockPos);
        if (biomass().contains(state)){
            return level.setBlock(blockPos, Sblocks.MEMBRANE_BLOCK.get().defaultBlockState(), 3);
        }
        return level.destroyBlock(blockPos, false, this);
    }

    protected SoundEvent getAmbientSound() {
        return isActive() ? Ssounds.CONSTRUCT_AMBIENT.get() : null;
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return this.getMachineHealth() > 0 || !isActive() ? SoundEvents.IRON_GOLEM_HURT : Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.IRON_GOLEM_STEP;
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        if (dataAccessor.equals(ACTIVE)){
            refreshDimensions();
            if (isActive()){
                setMachineHealth((float) (maXmachineHp * 1f));
                setHealth(this.getMaxHealth());
            }
        }
    }
    public void searchBlocks(){
        AABB aabb = this.getBoundingBox().inflate(32,4,32);
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState block = level().getBlockState(blockpos);
            if (getValues().containsKey(block.getBlock().asItem())){
                if (hasLineOfSightBlocks(blockpos) && this.random.nextFloat() < 0.5f){
                    setTargetPos(blockpos);
                    break;
                }
            }
        }
    }
    @Override
    public EntityDimensions getDimensions(Pose pose) {
        if (isActive()){
            return super.getDimensions(pose);
        }else{
            return super.getDimensions(pose).scale(1f,0.4f);
        }
    }

    public void callUponInfected(){
        AABB aabb = this.getBoundingBox().inflate(8);
        List<Entity> infected = level().getEntities(this,aabb,entity -> {return entity instanceof Infected && !(entity instanceof Hyper);});
        for (Entity entity : infected){
            if (entity instanceof Infected infected1){
                infected1.setSearchPos(this.getOnPos());
                if (infected1.distanceToSqr(this) < 30){
                    setActive(true);
                    infected1.discard();
                    if (level() instanceof ServerLevel serverLevel){
                        double x0 = this.getX() - (random.nextFloat() - 0.1) * 0.1D;
                        double y0 = this.getY() + (random.nextFloat() - 0.25) * 0.15D * 5;
                        double z0 = this.getZ() + (random.nextFloat() - 0.1) * 0.1D;
                        serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 2, 0, 0, 0, 1);
                    }
                    break;
                }
            }
        }
    }

    public static class SearchAroundGoal extends Goal {
        private final InfestedConstruct construct;
        public int tryTicks;

        public SearchAroundGoal(InfestedConstruct construct){
            this.construct = construct;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return construct.getTargetPos() != null && this.construct.getTarget() == null;
        }

        protected void moveToBlock(BlockPos pos){
            if (pos != null){
                construct.navigation.moveTo(pos.getX()+0.5D,pos.getY()+1D,pos.getZ()+0.5D,1);
            }
        }
        @Override
        public void start() {
            this.moveToBlock(construct.getTargetPos());
            this.tryTicks = 0;
            super.start();
        }


        @Override
        public boolean canContinueToUse() {
            return construct.getTarget() == null;
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
            BlockPos pos = construct.getTargetPos();
            if (pos != null && shouldRecalculatePath()){
                moveToBlock(pos);
            }
            if (pos != null && pos.closerToCenterThan(this.construct.position(),3.5f)){
                assimilateMetal(pos,construct.level());
                construct.setTargetPos((BlockPos) null);
                construct.searchBlocks();
            }
        }

        public void assimilateMetal(BlockPos pos,Level level){
            Item item = level.getBlockState(pos).getBlock().asItem();
            try {
                construct.setMetalReserve(construct.getMetalReserve() + construct.getValues().get(item));
            }catch (Exception ignored){}
            level.destroyBlock(pos,false,construct);
            construct.playSound(SoundEvents.IRON_GOLEM_REPAIR);
            if (item == Items.DISPENSER){
                construct.setDispenser(true);
            }
        }
    }

    @Override
    public boolean canBeSeenAsEnemy() {
        return super.canBeSeenAsEnemy() && isActive();
    }

    public void performDispenserShot(LivingEntity entity) {
        Arrow abstractarrow = new Arrow(level(),this);
        double d0 = entity.getX() - this.getX();
        double d1 = entity.getY(0.3333333333333333D) - abstractarrow.getY();
        double d2 = entity.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        abstractarrow.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 600));
        if (Math.random() < 0.4f){abstractarrow.setSecondsOnFire(8);}
        abstractarrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
        this.playSound(SoundEvents.DISPENSER_LAUNCH, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(abstractarrow);
    }

    @Override
    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        dropIron();
    }

    private void dropIron(){
        ItemEntity itemEntity = new ItemEntity(level(),this.getX(),this.getY(),this.getZ(),new ItemStack(Items.IRON_INGOT,random.nextInt(1,5)));
        level().addFreshEntity(itemEntity);
    }
}
