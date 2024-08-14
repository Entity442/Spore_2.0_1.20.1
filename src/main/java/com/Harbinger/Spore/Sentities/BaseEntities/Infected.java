package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.FloatDiveGoal;
import com.Harbinger.Spore.Sentities.AI.HurtTargetGoal;
import com.Harbinger.Spore.Sentities.AI.InfectedConsumeFromRemains;
import com.Harbinger.Spore.Sentities.AI.InfectedPanicGoal;
import com.Harbinger.Spore.Sentities.AI.LocHiv.*;
import com.Harbinger.Spore.Sentities.ArmedInfected;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import com.Harbinger.Spore.Sentities.Projectile.AcidBall;
import com.Harbinger.Spore.Sentities.Projectile.Vomit;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Infected extends Monster{
    public static final EntityDataAccessor<Integer> HUNGER = SynchedEntityData.defineId(Infected.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> KILLS = SynchedEntityData.defineId(Infected.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> EVOLUTION_POINTS = SynchedEntityData.defineId(Infected.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> EVOLUTION = SynchedEntityData.defineId(Infected.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> LINKED = SynchedEntityData.defineId(Infected.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> PERSISTENT = SynchedEntityData.defineId(Infected.class, EntityDataSerializers.BOOLEAN);
    @Nullable
    BlockPos searchPos;
    @Nullable
    protected LivingEntity  partner;
    public Infected(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1.0F);
        this.xpReward = 5;
        Sentities.INFECTED_ENTITIES.add(this);
    }
    public List<? extends String> getDropList(){
        return null;
    }
    @Nullable
    public BlockPos getSearchPos() {
        return searchPos;
    }

    public void setSearchPos(@Nullable BlockPos searchPos) {
        this.searchPos = searchPos;
    }

    public void travel(Vec3 p_32858_) {
        if (this.isEffectiveAi() && this.isInFluidType()) {
            this.moveRelative(0.1F, p_32858_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.6D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(p_32858_);
        }

    }

    public void setFollowPartner(@Nullable LivingEntity followPartner) {
        this.partner = followPartner;
    }
    public LivingEntity getFollowPartner(){
        return this.partner;
    }

    public int getMaxAirSupply() {
        return 1200;
    }
    protected int increaseAirSupply(int p_28389_) {
        return this.getMaxAirSupply();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        float f = (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
        float f1 = (float) this.getAttributeValue(Attributes.ATTACK_KNOCKBACK);
        if (entity instanceof LivingEntity) {
            f += EnchantmentHelper.getDamageBonus(this.getMainHandItem(), ((LivingEntity) entity).getMobType());
            f1 += (float) EnchantmentHelper.getKnockbackBonus(this);
        }

        int i = EnchantmentHelper.getFireAspect(this);
        if (i > 0) {
            entity.setSecondsOnFire(i * 4);
        }

        boolean flag = entity.hurt(getCustomDamage(this), f);
        if (flag) {
            if (f1 > 0.0F && entity instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),  600, 0), this);
                livingEntity.knockback((double) (f1 * 0.5F), (double) Mth.sin(this.getYRot() * ((float) Math.PI / 180F)), (double) (-Mth.cos(this.getYRot() * ((float) Math.PI / 180F))));
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.6D, 1.0D, 0.6D));
            }

            this.doEnchantDamageEffects(this, entity);
            this.setLastHurtMob(entity);
        }
        if (entity instanceof Player player) {
            this.maybeDisableShield(player, this.getMainHandItem(), player.isUsingItem() ? player.getUseItem() : ItemStack.EMPTY);
        }
        return flag;
    }

    public void maybeDisableShield(Player p_21425_, ItemStack p_21426_, ItemStack p_21427_) {
        if (!p_21426_.isEmpty() && !p_21427_.isEmpty() && p_21426_.getItem() instanceof AxeItem && p_21427_.is(Items.SHIELD)) {
            float f = 0.25F + (float)EnchantmentHelper.getBlockEfficiency(this) * 0.05F;
            if (this.random.nextFloat() < f) {
                p_21425_.getCooldowns().addCooldown(Items.SHIELD, 100);
                this.level().broadcastEntityEvent(p_21425_, (byte)30);
            }
        }

    }
    public DamageSource getCustomDamage(LivingEntity entity) {
        if (Math.random() < 0.5){
            return SdamageTypes.infected_damage1(entity);
        }else if (Math.random() < 0.5){
            return SdamageTypes.infected_damage2(entity);
        }else  if (Math.random() < 0.5) {
            return SdamageTypes.infected_damage3(entity);
        }
        return this.damageSources().mobAttack(this);
    }


    public Predicate<LivingEntity> TARGET_SELECTOR = (entity) -> {
       return Utilities.TARGET_SELECTOR.test(entity);
    };

    protected void addTargettingGoals(){
        this.goalSelector.addGoal(2, new HurtTargetGoal(this ,livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}, Infected.class).setAlertOthers(Infected.class));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> {return livingEntity instanceof Player || SConfig.SERVER.whitelist.get().contains(livingEntity.getEncodeId());}));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true, livingEntity -> {return SConfig.SERVER.at_mob.get() && TARGET_SELECTOR.test(livingEntity);}));
      }

    protected void addRegularGoals(){
        this.goalSelector.addGoal(0,new InfectedParkourGoal(this));
        this.goalSelector.addGoal(3,new LocalTargettingGoal(this));
        this.goalSelector.addGoal(4 , new BufferAI(this ));
        this.goalSelector.addGoal(4, new SearchAreaGoal(this, 1.2));
        this.goalSelector.addGoal(5 , new InfectedPanicGoal(this , 1.5));
        this.goalSelector.addGoal(6,new FloatDiveGoal(this));
        this.goalSelector.addGoal(7, new InfectedConsumeFromRemains(this));
        this.goalSelector.addGoal(10,new FollowOthersGoal(this,Infected.class,entity ->{
            return true;
        }));
        this.goalSelector.addGoal(10,new FollowOthersGoal(this,Calamity.class,entity ->{
            return this instanceof EvolvingInfected;
        }));
    }

    @Override
    protected void registerGoals() {
        addTargettingGoals();
        addRegularGoals();
    }


    public boolean canStarve(){
        return SConfig.SERVER.should_starve.get() && entityData.get(EVOLUTION_POINTS) <= 0;
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return SConfig.SERVER.daytime_spawn.get() ? 0.0F: super.getWalkTargetValue(pos, reader);
    }

    public void aiStep() {
        super.aiStep();

        if (SConfig.SERVER.weaktocold.get()){
        if (!this.level().isClientSide && this.tickCount % 20 == 0 && (this.isInPowderSnow || this.isFreazing())) {
            this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1, false, false), Infected.this);
            this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0, false, false), Infected.this);
        }}

        if (canStarve() && this.tickCount % 20 == 0){
            if (entityData.get(HUNGER) < SConfig.SERVER.hunger.get()) {
                int i = this.isInPowderSnow || this.isFreazing() ? 2:1;
                entityData.set(HUNGER, entityData.get(HUNGER) + i);
            } else if (entityData.get(HUNGER) >= SConfig.SERVER.hunger.get() && !this.hasEffect(Seffects.STARVATION.get())) {
                this.addEffect(new MobEffectInstance(Seffects.STARVATION.get(), 100, 0));
            }
        }

        if ((this.horizontalCollision || additionalBreakingTriggers()) && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
            boolean flag = false;
            AABB aabb = this.getBoundingBox().inflate(0.2D).move(0,0.5,0);
            for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState blockstate = this.level().getBlockState(blockpos);
                if (blockBreakingParameter(blockstate,blockpos)) {
                    flag = interactBlock(blockpos,this.level()) || flag;
                }
                if (!flag && this.onGround()) {
                    this.jumpFromGround();
                }
            }

        }
        if (this.horizontalCollision && this.isInWater()){
            this.jumpInFluid(ForgeMod.WATER_TYPE.get());
        }
    }
    public boolean additionalBreakingTriggers(){
        return false;
    }

    public boolean blockBreakingParameter(BlockState blockstate,BlockPos blockpos){
        return (blockstate.getBlock() instanceof AbstractGlassBlock || blockstate.getBlock() instanceof LeavesBlock) && blockstate.getDestroySpeed(level() ,blockpos) >= 0 && blockstate.getDestroySpeed(level() ,blockpos) < 2;
    }
    protected List<BlockState> biomass(){
        List<BlockState> states = new ArrayList<>();
        states.add(Sblocks.BIOMASS_BLOCK.get().defaultBlockState());
        states.add(Sblocks.SICKEN_BIOMASS_BLOCK.get().defaultBlockState());
        states.add(Sblocks.CALCIFIED_BIOMASS_BLOCK.get().defaultBlockState());
        states.add(Sblocks.MEMBRANE_BLOCK.get().defaultBlockState());
        states.add(Sblocks.ROOTED_BIOMASS.get().defaultBlockState());
        states.add(Sblocks.ROOTED_MYCELIUM.get().defaultBlockState());
        return states;
    }

    public boolean interactBlock(BlockPos blockPos, Level level) {
        BlockState state = level.getBlockState(blockPos);
        if (biomass().contains(state)){
            return level.setBlock(blockPos, Sblocks.MEMBRANE_BLOCK.get().defaultBlockState(), 3);
        }
        return level.destroyBlock(blockPos, false, this);
    }


    public boolean isStarving(){
        return entityData.get(HUNGER) >= SConfig.SERVER.hunger.get() || this.hasEffect(Seffects.STARVATION.get());
    }

    @Override
    public boolean removeWhenFarAway(double p_21542_) {
        if (this.getEvoPoints() >= SConfig.SERVER.min_kills.get() && this instanceof EvolvingInfected){
            return false;
        }
        return !this.entityData.get(PERSISTENT);
    }

    public boolean isFreazing(){
        int i = Mth.floor(this.getX());
        int j = Mth.floor(this.getY());
        int k = Mth.floor(this.getZ());
        BlockPos blockpos = new BlockPos(i, j, k);
        Biome biome = this.level().getBiome(blockpos).value();
        return (SConfig.SERVER.weaktocold.get() && this.random.nextInt(20) == 0  && biome.getBaseTemperature() <= 0.2);
    }

    @Override
    public void awardKillScore(Entity entity, int i, DamageSource damageSource) {
        this.entityData.set(KILLS,entityData.get(KILLS) + 1);
        this.entityData.set(EVOLUTION_POINTS,entityData.get(EVOLUTION_POINTS) + 1);
        setHunger(0);
        super.awardKillScore(entity, i, damageSource);
    }
    public void setHunger(Integer count){entityData.set(HUNGER,count);}
    public int getHunger(){return entityData.get(HUNGER);}
    public void setKills(Integer count){
        entityData.set(KILLS,count);
    }
    public  int getKills(){return entityData.get(KILLS);}
    public void setEvoPoints(Integer count){
        entityData.set(EVOLUTION_POINTS,count);
    }
    public  int getEvoPoints(){return entityData.get(EVOLUTION_POINTS);}
    public void setLinked(Boolean count){
        entityData.set(LINKED,count);
    }
    public boolean getLinked(){return entityData.get(LINKED);}
    public int getEvolutionCoolDown(){return this.entityData.get(EVOLUTION);}
    public void setEvolution(int u){this.entityData.set(EVOLUTION,u);}
    public void setPersistent(Boolean count){
        entityData.set(PERSISTENT,count);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("hunger",entityData.get(HUNGER));
        tag.putInt("kills",entityData.get(KILLS));
        tag.putInt("evo_points",entityData.get(EVOLUTION_POINTS));
        tag.putInt("evolution",entityData.get(EVOLUTION));
        tag.putBoolean("linked",entityData.get(LINKED));
        tag.putBoolean("persistent",entityData.get(PERSISTENT));
    }


    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(HUNGER, tag.getInt("hunger"));
        entityData.set(KILLS, tag.getInt("kills"));
        entityData.set(EVOLUTION,tag.getInt("evolution"));
        entityData.set(EVOLUTION_POINTS,tag.getInt("evo_points"));
        entityData.set(LINKED, tag.getBoolean("linked"));
        entityData.set(PERSISTENT, tag.getBoolean("persistent"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HUNGER, 0);
        this.entityData.define(KILLS, 0);
        this.entityData.define(EVOLUTION_POINTS, 0);
        this.entityData.define(LINKED,false);
        this.entityData.define(PERSISTENT,false);
        this.entityData.define(EVOLUTION,0);
    }



    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.hasEffect(Seffects.STARVATION.get()) && source == this.damageSources().generic() && this.level() instanceof ServerLevel serverLevel){
            double x0 = this.getX() - (random.nextFloat() - 0.1) * 0.1D;
            double y0 = this.getY() + (random.nextFloat() - 0.25) * 0.25D * 5;
            double z0 = this.getZ() + (random.nextFloat() - 0.1) * 0.1D;
            serverLevel.sendParticles(Sparticles.SPORE_PARTICLE.get(), x0, y0, z0, 4,0, 0, 0,1);
        }
        if (source.getDirectEntity() instanceof AcidBall || source.getDirectEntity() instanceof Vomit){
            return  false;
        }
        if (source.getDirectEntity() != null){
            this.setSearchPos(new BlockPos((int)source.getDirectEntity().getX(),(int)source.getDirectEntity().getY(),(int)source.getDirectEntity().getZ()));
        }
        return super.hurt(source, amount);
    }

    public static boolean checkMonsterInfectedRules(EntityType<? extends Infected> p_219014_, ServerLevelAccessor levelAccessor, MobSpawnType type, BlockPos pos, RandomSource source) {
        if (levelAccessor.getDifficulty() != Difficulty.PEACEFUL){
            if (SConfig.SERVER.spawn.get() && levelAccessor instanceof ServerLevel serverLevel){
                SporeSavedData data = SporeSavedData.getDataLocation(serverLevel);
                if (data != null){
                    int e = data.getMinutesBeforeSpawning();
                    int i = 1200 * SConfig.SERVER.days.get();
                    if (e >= i){
                        return furtherSpawnParameters(p_219014_,levelAccessor,type,pos,source);
                    }
                }
            }else{
                return furtherSpawnParameters(p_219014_,levelAccessor,type,pos,source);
            }
        }
        return false;
    }

    private static boolean furtherSpawnParameters(EntityType<? extends Infected> p_219014_,ServerLevelAccessor levelAccessor, MobSpawnType type, BlockPos pos, RandomSource source){
        if (SConfig.SERVER.daytime_spawn.get()){
            return checkAnyLightMonsterSpawnRules(p_219014_, levelAccessor, type, pos, source);
        }else
            return isDarkEnoughToSpawn(levelAccessor, pos, source) && checkMobSpawnRules(p_219014_, levelAccessor, type, pos, source);
    }


    @Override
    public boolean addEffect(MobEffectInstance effectInstance, @org.jetbrains.annotations.Nullable Entity entity) {
        if (entityData.get(HUNGER) >= SConfig.SERVER.hunger.get() && (effectInstance.getEffect() == MobEffects.HEAL || effectInstance.getEffect() == MobEffects.REGENERATION)){
           setHunger(0);
        }
        return super.addEffect(effectInstance, entity);
    }


    @Override
    public void die(DamageSource source) {
        if (this.hasEffect(Seffects.STARVATION.get()) && source == this.damageSources().generic()){
            AABB aabb = this.getBoundingBox().inflate(1);
            for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState blockState = level().getBlockState(blockpos);
                BlockState above = level().getBlockState(blockpos.above());
                if (!level().isClientSide() && blockState.isSolidRender(level(),blockpos) && above.isAir()){
                    if (Math.random() < 0.9){
                        if (Math.random() < 0.5) {
                            level().setBlock(blockpos.above(), Sblocks.GROWTHS_BIG.get().defaultBlockState(), 3);
                        } else {
                            level().setBlock(blockpos.above(), Sblocks.GROWTHS_SMALL.get().defaultBlockState(), 3);
                        }
                    }if (Math.random() < 0.3){
                        level().setBlock(blockpos.above(), Sblocks.REMAINS.get().defaultBlockState(), 3);
                        break;
                    }
                }
            }
        }
        super.die(source);
    }
    @org.jetbrains.annotations.Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance p_21435_, MobSpawnType p_21436_, @org.jetbrains.annotations.Nullable SpawnGroupData p_21437_, @org.jetbrains.annotations.Nullable CompoundTag p_21438_) {
        setDefaultLinkage(serverLevelAccessor);
        spawnWithPoints();
        return super.finalizeSpawn(serverLevelAccessor, p_21435_, p_21436_, p_21437_, p_21438_);
    }
    public void setDefaultLinkage(ServerLevelAccessor level){
        if (level instanceof ServerLevel serverLevel){
            SporeSavedData data = SporeSavedData.getDataLocation(serverLevel);
            if (data != null && data.getAmountOfHiveminds() >= SConfig.SERVER.proto_spawn_world_mod.get()){
                this.setLinked(true);
                if (Math.random() < 0.3 && this instanceof EvolvingInfected evolvingInfected){
                    if (evolvingInfected instanceof EvolvedInfected){
                        this.setEvoPoints(this.getEvoPoints()+SConfig.SERVER.min_kills_hyper.get());
                    }else{
                        this.setEvoPoints(this.getEvoPoints()+SConfig.SERVER.min_kills.get());
                    }
                    this.setEvolution(SConfig.SERVER.evolution_age_human.get());
                }
                enchantEquipment(this);
            }
        }
    }
    public void spawnWithPoints(){
        if (!SConfig.SERVER.at_mob.get() && Math.random() < 0.1 && this instanceof EvolvingInfected){
            this.setEvoPoints(SConfig.SERVER.min_kills.get());
        }
    }

    public void enchantEquipment(LivingEntity living){
        if (living instanceof ArmedInfected armedInfected){
            armedInfected.enchantItems(living);
        }
    }
}
