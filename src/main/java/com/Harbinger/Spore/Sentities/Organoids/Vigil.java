package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class Vigil extends Organoid {
    private static final EntityDataAccessor<Integer> TRIGGER = SynchedEntityData.defineId(Vigil.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Vigil.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> BORROW = SynchedEntityData.defineId(Vigil.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> EMERGE = SynchedEntityData.defineId(Vigil.class, EntityDataSerializers.INT);
    private final int emerge_tick = 180;
    private final int borrow_tick = 200;
    public Vigil(EntityType<? extends UtilityEntity> type, Level level) {
        super(type, level);
        setPersistenceRequired();
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TIMER, 0);
        this.entityData.define(TRIGGER, 0);
        this.entityData.define(BORROW, 0);
        this.entityData.define(EMERGE, 0);
    }

    public int getEmerge_tick(){
        return emerge_tick;
    }
    public  int getBorrow_tick(){return borrow_tick;}

    public boolean isEmerging(){
        return this.entityData.get(EMERGE) > 0;
    }
    public void tickEmerging(){
        int emerging = this.entityData.get(EMERGE);
        if (emerging > emerge_tick)
            emerging = -1;
        this.entityData.set(EMERGE, emerging + 1);
    }
    public boolean isBurrowing(){
        return this.entityData.get(BORROW) > 0;
    }
    private void tickBurrowing(){
        int burrowing = this.entityData.get(BORROW);
        if (burrowing > borrow_tick) {
               this.discard();
               this.TimeToLeave();
               return;
        }
        this.entityData.set(BORROW, burrowing + 1);
    }

    public int getEmerge(){
        return entityData.get(EMERGE);
    }
    public int getBorrow(){return entityData.get(BORROW);}

    @Override
    public boolean isNoAi() {
        return this.isBurrowing() || this.isEmerging();
    }

    @Override
    public void tick() {
        if (this.isEmerging()){
            this.tickEmerging();
        } else if (this.isBurrowing()){
            this.tickBurrowing();
        }
        if (this.getTarget() == null && this.entityData.get(TIMER) < 9600){
            this.entityData.set(TIMER,this.entityData.get(TIMER) + 1);
        }else if (this.entityData.get(TIMER) >= 9600){
            escape();
        }
        super.tick();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("trigger",entityData.get(TRIGGER));
        tag.putInt("timer",entityData.get(TIMER));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TRIGGER, tag.getInt("trigger"));
        entityData.set(TIMER, tag.getInt("timer"));
    }

    @Override
    public boolean hurt(DamageSource p_21016_, float p_21017_) {
        if (this.isEmerging()){
            return false;
        }
        this.escape();
        return super.hurt(p_21016_, p_21017_);
    }

    public void escape(){
        if (this.onGround()){
            this.tickBurrowing();
        }
    }

    public void TimeToLeave(){
        int i = entityData.get(TRIGGER);
        if (i == 1){
            this.SummonScent(this , this.level(),false);
        }else if (i == 2){
            this.SummonScent(this , this.level(),true);
        }else if (i <= 3){
            AABB searchbox = this.getBoundingBox().inflate(SConfig.SERVER.proto_range.get());
            List<Entity> entities = this.level().getEntities(this, searchbox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);
            for (Entity en : entities) {
                if (en instanceof Proto proto){
                    proto.setSignal(true);
                    proto.setPlace(new BlockPos((int)this.getX(),(int)this.getY(),(int)this.getZ()));
                    break;
                }}
        }
    }

    private void SummonScent(Entity entity ,Level level,boolean value){
        ScentEntity scent = new ScentEntity(Sentities.SCENT.get(),level);
        scent.moveTo(entity.getX(),entity.getY(),entity.getZ());
        scent.setOvercharged(value);
        level.addFreshEntity(scent);
    }

    private static class WatchTargetGoat extends Goal{
        private final Vigil vigil;

        public WatchTargetGoat(Vigil vigil1){
            this.vigil = vigil1;
        }
        @Override
        public boolean canUse() {
            return this.vigil.getTarget() != null;
        }

        @Override
        public void tick() {
            super.tick();
            Entity target = this.vigil.getTarget();
            if (target != null && this.vigil.hasLineOfSight(target)){
                this.vigil.getLookControl().setLookAt(target, 30.0F, 30.0F);
            }
        }
    }

    private static class WatcherMobSummon extends Goal{
        private final Vigil vigil;

        private WatcherMobSummon(Vigil vigil) {
            this.vigil = vigil;
        }

        @Override
        public boolean canUse() {
            return this.vigil.getTarget() != null && this.vigil.random.nextInt(100) == 0 && checkForInfected(this.vigil);
        }
        boolean checkForInfected(Entity entity){
            AABB boundingBox = entity.getBoundingBox().inflate(32,16,32);
            List<Entity> entities = entity.level().getEntities(entity, boundingBox ,EntitySelector.NO_CREATIVE_OR_SPECTATOR);
            for (Entity en : entities) {
                if (en instanceof Infected && entities.size() > 4){
                    return false;
                }
            }
            return true;
        }

        @Override
        public void start() {
            super.start();
            this.vigil.SummonInfected();
        }
    }

    public void SummonInfected(){
        ServerLevelAccessor world = (ServerLevelAccessor) this.level();
        List<? extends String> summons;
        int l = entityData.get(TRIGGER);
        if (l == 1){
            summons = SConfig.SERVER.inf_summon.get();
        }else if (l >= 2){
            summons = SConfig.SERVER.inf_summon.get();
        }else{
            summons = SConfig.SERVER.inf_summon.get();
        }
        LivingEntity target = this.getTarget();
        this.entityData.set(TRIGGER,entityData.get(TRIGGER)+1);
        if (target != null){
            int e = target.getMaxHealth() > 50 ? 10 : (int) (target.getMaxHealth() / 5);
            for(int a = 1;a <= e;a++){
                RandomSource rand = RandomSource.create();
                int randomIndex = rand.nextInt(summons.size());
                ResourceLocation randomElement1 = new ResourceLocation(summons.get(randomIndex));
                EntityType<?> randomElement = ForgeRegistries.ENTITY_TYPES.getValue(randomElement1);
                Mob waveentity = (Mob) randomElement.create(this.level());
                assert waveentity != null;
                waveentity.setPos(this.getX(), this.getY(), this.getZ());
                waveentity.finalizeSpawn(world, this.level().getCurrentDifficultyAt(new BlockPos((int) this.getX(),(int)  this.getY(),(int)  this.getZ())), MobSpawnType.NATURAL, null, null);
                if (waveentity.getTarget() == null && target.isAlive() && !target.isInvulnerable()){
                    waveentity.setTarget(target);
                }
                this.level().addFreshEntity(waveentity);
            }
        }

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.mound_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.mound_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }
    public void aiStep() {
        super.aiStep();
        if (this.isEmerging() || this.isBurrowing()) {
            double x = this.getX();
            double y = this.getY();
            double z = this.getZ();
            Level world = this.level();
            RandomSource randomsource = this.getRandom();
            if (!level().isClientSide) {
                int xi = randomsource.nextInt(-1,1);
                int zi = randomsource.nextInt(-1,1);
                if (world.getBlockState(new BlockPos((int) x, (int) y - 1, (int) z)).getBlock().asItem() != ItemStack.EMPTY.getItem()) {
                    ((ServerLevel) level()).sendParticles(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y - 1, (int) z))).getBlock())), x + xi, y - 0.1D, z + zi, 3,
                            ((double) randomsource.nextFloat() - 1D) * 0.08D, ((double) randomsource.nextFloat() - 1D) * 0.08D, ((double) randomsource.nextFloat() - 1D) * 0.08D, 0.15F);
                }
            }
        }
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33282_, DifficultyInstance p_33283_, MobSpawnType p_33284_, @Nullable SpawnGroupData p_33285_, @Nullable CompoundTag p_33286_) {
        this.tickEmerging();
        return super.finalizeSpawn(p_33282_, p_33283_, p_33284_, p_33285_, p_33286_);
    }

    @Override
    protected void registerGoals() {
        this.addTargettingGoals();
        this.goalSelector.addGoal(2 ,new WatchTargetGoat(this));
        this.goalSelector.addGoal(2 ,new WatcherMobSummon(this));
        this.goalSelector.addGoal(3 ,new RandomLookAroundGoal(this));
        super.registerGoals();
    }
}
