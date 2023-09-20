package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class Vigil extends Organoid {
    private static final EntityDataAccessor<Integer> TRIGGER = SynchedEntityData.defineId(Vigil.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> WAVE_SIZE = SynchedEntityData.defineId(Vigil.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Vigil.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> BORROW = SynchedEntityData.defineId(Vigil.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> EMERGE = SynchedEntityData.defineId(Vigil.class, EntityDataSerializers.INT);
    private final int emerge_tick = 180;
    private final int borrow_tick = 200;
    private int summon_counter;
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
        this.entityData.define(WAVE_SIZE, 0);
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
            burrowing = -1;
        }
        this.entityData.set(BORROW, burrowing + 1);
    }

    public int getEmerge(){
        return entityData.get(EMERGE);
    }
    public int getBorrow(){return entityData.get(BORROW);}

    public int getTrigger(){
        return entityData.get(TRIGGER);
    }
    public void setTrigger(int i){
        entityData.set(TRIGGER,i);
    }
    public int getWaveSize(){
        return entityData.get(WAVE_SIZE);
    }
    public void setWaveSize(int i){
        entityData.set(WAVE_SIZE,i);
    }
    public int getTimer(){return entityData.get(TIMER);}
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
        if (this.getTarget() == null && this.entityData.get(TIMER) < 6000){
            if (this.entityData.get(TIMER) % 300 == 0){
                this.setTrigger(0);
                this.setWaveSize(0);
            }
            this.entityData.set(TIMER,this.entityData.get(TIMER) + 1);
        }else if (this.entityData.get(TIMER) >= 6000){
            escape();
        }
        if (this.getTarget() != null && this.distanceToSqr(this.getTarget()) < 300 || this.getTrigger() >= 4){
            this.setTrigger(this.getTrigger() <= 0 ? 1:this.getTrigger());
            escape();
        }
        super.tick();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("trigger",entityData.get(TRIGGER));
        tag.putInt("timer",entityData.get(TIMER));
        tag.putInt("wave_size",entityData.get(WAVE_SIZE));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TRIGGER, tag.getInt("trigger"));
        entityData.set(TIMER, tag.getInt("timer"));
        entityData.set(WAVE_SIZE, tag.getInt("wave_size"));
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
        }else if (i >= 3){
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
                if (target instanceof ServerPlayer player){
                    if (!player.hasEffect(Seffects.UNEASY.get())){
                        player.addEffect(new MobEffectInstance(Seffects.UNEASY.get(),6000,0));
                    }
                    player.displayClientMessage(Component.translatable("vigil.message"),true);
                }
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
            if (this.vigil.getWaveSize() > 0){
                return false;
            }
            return this.vigil.random.nextInt(100) == 0  && this.vigil.getTarget() != null && checkForInfected(this.vigil.getTarget());
        }
        boolean checkForInfected(Entity entity){
            AABB boundingBox = entity.getBoundingBox().inflate(16);
            List<Entity> entities = entity.level().getEntities(entity, boundingBox ,EntitySelector.NO_CREATIVE_OR_SPECTATOR);
            for (Entity en : entities) {
                if (en instanceof Infected){
                    return false;
                }
            }
            return true;
        }

        @Override
        public void start() {
            super.start();
            if (this.vigil.getTarget() != null && this.vigil.getWaveSize() <= 0){
                LivingEntity target = this.vigil.getTarget();
                int e = target.getMaxHealth() > 50 ? 10 : (int) (target.getMaxHealth() / 5);
                this.vigil.setWaveSize(e);
                this.vigil.setTrigger(this.vigil.getTrigger() +1);
            }
        }
    }

    public void SummonInfected(){
        List<? extends String> summons;
        int l = this.getTrigger();
        if (l <= 1) {
                summons = SConfig.SERVER.vigil_base_wave.get();
        } else if (l == 2) {
                summons = SConfig.SERVER.vigil_middle_wave.get();
        } else {
                summons = SConfig.SERVER.vigil_max_wave.get();
        }

        LivingEntity target = this.getTarget();
        if (target != null && this.getTrigger() > 0 && this.level() instanceof ServerLevelAccessor world){
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

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.vigil_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.vigil_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }
    public void aiStep() {
        super.aiStep();
        if (this.getWaveSize() > 0 && this.summon_counter <=20){
            this.summon_counter++;
        }else{
            if (this.getWaveSize() > 0 && this.summon_counter >= 20){
                this.summon_counter = 0;
                SummonInfected();
                this.setWaveSize(this.getWaveSize() - 1);
            }
        }

        if (this.getWaveSize() > 0){
            double x = this.getX();
            double y = this.getY();
            double z = this.getZ();
            RandomSource randomsource = this.getRandom();
            for (int l = 0 ;l<3;l++){
                int i = randomsource.nextInt(-3,3);
                int i1 = randomsource.nextInt(-3,3);
                if (level() instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(Sparticles.SPORE_PARTICLE.get(),x+i,y+random.nextDouble(),z+i1,1
                    ,0,0.3,0,0.15F);
                }
            }
        }

        if (this.isEmerging() || this.isBurrowing()) {
            double x = this.getX();
            double y = this.getY();
            double z = this.getZ();
            Level world = this.level();
            RandomSource randomsource = this.getRandom();
            for (int l = 0 ;l<6;l++){
                if (level() instanceof ServerLevel serverLevel) {
                    int xi = randomsource.nextInt(-1,1);
                    int zi = randomsource.nextInt(-1,1);
                    if (world.getBlockState(new BlockPos((int) x, (int) y - 1, (int) z)).getBlock().asItem() != ItemStack.EMPTY.getItem()) {

                        serverLevel.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y - 1, (int) z))).getBlock())), x + xi, y - 0.1D, z + zi, 3,
                                ((double) randomsource.nextFloat() - 1D) * 0.08D, ((double) randomsource.nextFloat() - 1D) * 0.08D, ((double) randomsource.nextFloat() - 1D) * 0.08D, 0.15F);
                    }
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
