package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sblocks.CDUBlock;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.FoliageSpread;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class HiveTumor extends Organoid implements FoliageSpread {
    private static final EntityDataAccessor<Integer> BIOMASS = SynchedEntityData.defineId(HiveTumor.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> GROWTH = SynchedEntityData.defineId(HiveTumor.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SCARED = SynchedEntityData.defineId(HiveTumor.class, EntityDataSerializers.INT);
    public HiveTumor(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        setPersistenceRequired();
    }
    private void griefBlocks(){
        if (this.getLastDamageSource() == this.damageSources().inWall() && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)){
            AABB aabb = this.getBoundingBox().inflate(0.2,0,0.2);
            boolean flag = false;
            for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState blockstate = this.level().getBlockState(blockpos);
                if (blockstate.getDestroySpeed(level() ,blockpos) < 10 && blockstate.getDestroySpeed(level() ,blockpos) > 0) {
                    flag =  this.level().destroyBlock(blockpos, true, this) || flag;
                }
            }
        }
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.tumor_loot.get();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 20 == 0){
            grow(1);
        }
        if (this.tickCount % 40 == 0){
            griefBlocks();
            LivingEntity living = getTarget();
            if (living != null && checkForOrganoids(living) && entityData.get(BIOMASS) >= 10){
                summonMob(living.getOnPos());
            }
        }
        if (this.tickCount % 200 == 0 || (this.tickCount % 20 == 0 && isScared())){
            addBiomass(1);
        }
        if (this.tickCount % 3000 == 0 && SConfig.SERVER.htumor_madness.get()){
            this.giveMadness();
        }
        if (!level().isClientSide){
            if (this.tickCount % 6000 == 0 && SConfig.SERVER.mound_foliage.get()){
                SpreadInfection(level(),SConfig.SERVER.mound_range_age4.get() * 2,getOnPos());
            }
            if (entityData.get(GROWTH) >= SConfig.SERVER.htumor_timer.get() && level() instanceof ServerLevel serverLevel){
                List<Proto> protos = SporeSavedData.getHiveminds();
                if (!protos.isEmpty()) {
                    for (Proto proto : protos){
                        if (proto.distanceTo(this) <= SConfig.SERVER.proto_range.get()){
                            proto.addBiomass(1000);
                            this.discard();
                            break;
                        }
                    }
                    SummonProto(serverLevel);
                }
            }
        }
        if (this.tickCount % 1200 == 0){
            scanForHosts();
        }
        if (isScared()){
            this.entityData.set(SCARED,entityData.get(SCARED)-1);
        }
        if (isScared()){
            for (int i = 0; i < 360; i++) {
                if (i % 20 == 0) {
                    level().addParticle(ParticleTypes.SMOKE,
                            this.getX() , this.getY()  + 1.2, this.getZ() ,
                            Math.cos(i) * 0.15d, (random.nextDouble()-random.nextDouble()) * 0.3d, Math.sin(i) * 0.15d);
                }
            }
        }
    }
    public void SummonProto(ServerLevel serverLevel){
        Proto proto = new Proto(Sentities.PROTO.get(), level());
        proto.moveTo(this.getOnPos().getX(),this.getOnPos().getY(),this.getOnPos().getZ());
        proto.finalizeSpawn(serverLevel,serverLevel.getCurrentDifficultyAt(this.getOnPos()),MobSpawnType.CONVERSION,null,null);
        level().addFreshEntity(proto);
        entityData.set(GROWTH,0);
        discard();
    }
    protected void giveMadness(){
        AABB aabb = this.getBoundingBox().inflate(64);
        List<Entity> entities = this.level().getEntities(this, aabb);
        for (Entity entity : entities){
            if (entity instanceof LivingEntity living && (SConfig.SERVER.htumor_sapient_target.get().contains(living.getEncodeId()) || living instanceof Player)){
                living.addEffect(new MobEffectInstance(Seffects.MADNESS.get(),3000,0,false,false));
            }
        }
    }
    public void addBiomass(int e){
        entityData.set(BIOMASS,entityData.get(BIOMASS)+e);
    }
    public void eatBiomass(int e){
        entityData.set(BIOMASS,entityData.get(BIOMASS)-e);
    }
    public void grow(int e){
        entityData.set(GROWTH,entityData.get(GROWTH)+e);
    }
    protected boolean checkForOrganoids(Entity entity){
        AABB aabb = entity.getBoundingBox().inflate(12);
        List<Entity> entities = level().getEntities(this,aabb,entity1 -> { return entity1 instanceof Organoid;});
        return entities.size() <= 4;
    }
    private boolean checkTheGround(BlockPos pos,Level level){
        for (int i = 0;i < 3;i++){
            BlockState state = level.getBlockState(pos.below(i));
            if (state.getDestroySpeed(level,pos.below(i)) > 4 || state.isAir()){
                return false;
            }
        }
        return true;
    }
    private void summonMob(BlockPos pos) {
        if (pos.equals(BlockPos.ZERO)) {
            return;
        }
        int i = this.getRandom().nextInt(SConfig.SERVER.htumor_summonable_troops.get().size());
        BlockPos blockPos = pos;
        EntityType<?> type = ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(SConfig.SERVER.htumor_summonable_troops.get().get(i)));
        if (type == null){
            return;
        }
        Entity summoned = type.create(level());
        if (summoned instanceof Organoid organoid) {
            blockPos = organoid.isCloseCombatant() ? pos : BlockPos.containing(Utilities.generatePositionAway(new Vec3(pos.getX(),pos.getY(),pos.getZ()),random.nextInt(8,16)));
            organoid.tickEmerging();
        }
        if (summoned instanceof Vigil organoid) {
            organoid.setProto(this);
        }
        if (summoned instanceof Mound organoid) {
            organoid.setMaxAge(1);
        }
        if (summoned instanceof Verwa organoid && this.level() instanceof ServerLevel serverLevel) {
            organoid.finalizeSpawn(serverLevel,serverLevel.getCurrentDifficultyAt(pos), MobSpawnType.SPAWNER,null,null);
        }
        if (summoned instanceof LivingEntity mob){
            mob.randomTeleport(blockPos.getX(), blockPos.getY(), blockPos.getZ(),false);
        }else {
            summoned.teleportTo(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        }
        if (summoned instanceof VariantKeeper keeper){
            keeper.setVariant(random.nextInt(keeper.amountOfMutations()));
        }
        if (checkTheGround(pos,summoned.level()) && summoned.position().distanceToSqr(0,0,0) > 10){
            eatBiomass(10);
            level().addFreshEntity(summoned);
        }
    }
    @Override
    public void SpreadFoliageAndConvert(Level level, BlockState blockstate, BlockPos blockpos) {
        FoliageSpread.super.SpreadFoliageAndConvert(level, blockstate, blockpos);
        if (blockstate.getBlock().equals(Sblocks.CDU.get())){
            CDUBlock.replaceCDU(blockpos,level);
        }
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(BIOMASS,0);
        entityData.define(GROWTH,0);
        entityData.define(SCARED,0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        compound.putInt("biomass",entityData.get(BIOMASS));
        compound.putInt("growth",entityData.get(GROWTH));
        compound.putInt("scarred",entityData.get(SCARED));
    }
    public boolean isScared(){return entityData.get(SCARED) > 0;}

    public void setScaredTicks(int i){entityData.set(SCARED,i);}
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        entityData.set(BIOMASS, compound.getInt("biomass"));
        entityData.set(GROWTH, compound.getInt("growth"));
        entityData.set(SCARED, compound.getInt("scarred"));
    }
    protected SoundEvent getAmbientSound() {
        return Ssounds.TUMOR_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    @Override
    public int getEmerge_tick() {
        return 120;
    }

    public int getNumberOfParticles(){
        return 6;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.htumor_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.htumor_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.htumor_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 2);
    }

    @Override
    protected void registerGoals() {
        this.addTargettingGoals();
        this.goalSelector.addGoal(3, new HiveTumorPanicGoal(this));
        this.goalSelector.addGoal(4,new AOEMeleeAttackGoal(this,0,false,2.5,8, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(4,new RandomLookAroundGoal(this));
        super.registerGoals();
    }
    private static class HiveTumorPanicGoal extends Goal {
        private final HiveTumor hiveTumor;

        private HiveTumorPanicGoal(HiveTumor hiveTumor) {
            this.hiveTumor = hiveTumor;
        }

        @Override
        public boolean canUse() {
            if (hiveTumor.isScared()) return true;

            LivingEntity living = hiveTumor.getTarget();

            if (hiveTumor.getHealth() <= hiveTumor.getMaxHealth() / 2) {
                return true;
            }

            if (living != null) {
                return living.getMaxHealth() >= 100 || living.getArmorValue() >= 20;
            }

            return false;
        }

        @Override
        public void start() {
            hiveTumor.setScaredTicks(6000);
        }

        @Override
        public void tick() {
            super.tick();
            if (hiveTumor.tickCount % 40 == 0){
                Targeting();
            }
        }

        @Override
        public boolean canContinueToUse() {
            return hiveTumor.isScared();
        }

        private void Targeting() {
            LivingEntity target = hiveTumor.getTarget();
            if (target == null || !target.isAlive()) return;

            AABB boundingBox = hiveTumor.getBoundingBox().inflate(128);
            List<Entity> entities = hiveTumor.level().getEntities(
                    hiveTumor,
                    boundingBox,
                    EntitySelector.NO_CREATIVE_OR_SPECTATOR
            );

            for (Entity entity : entities) {
                if (entity instanceof Infected infected) {
                    if (infected.getTarget() == null && !target.isInvulnerable()) {
                        infected.setTarget(target);
                    }
                }
            }
        }
    }


    @Override
    public boolean hasLineOfSight(Entity entity) {
        if (entity instanceof LivingEntity livingEntity){
            if (livingEntity.hasEffect(Seffects.MARKER.get())){
                return true;
            }else if ((livingEntity instanceof Player || SConfig.SERVER.proto_sapient_target.get().contains(livingEntity.getEncodeId())) && !livingEntity.hasEffect(Seffects.SYMBIOSIS.get())){
                return true;
            }else if (livingEntity.getMaxHealth() > 30){
                return true;
            }
            return super.hasLineOfSight(entity);
        }
        return super.hasLineOfSight(entity);
    }
    protected int calculateFallDamage(float p_149389_, float p_149390_) {
        return super.calculateFallDamage(p_149389_, p_149390_) - 60;
    }
    public AABB seachbox(){
        return this.getBoundingBox().inflate(SConfig.SERVER.htumor_range.get());
    }
    private void scanForHosts(){
        List<Entity> entities = this.level().getEntities(this, seachbox() , EntitySelector.NO_CREATIVE_OR_SPECTATOR);
        for (Entity en : entities) {
            if (en instanceof Infected infected){
                if (!infected.getLinked()){
                    infected.setLinked(true);
                }
            }
            if (en instanceof Mound mound){
                if (!mound.getLinked()){
                    mound.setLinked(true);
                }
            }
        }
    }

}
