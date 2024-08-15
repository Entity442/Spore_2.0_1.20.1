package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.ExtremelySusThings.ChunkLoaderHelper;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.SBlockEntities.BrainRemnantBlockEntity;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.CasingGenerator;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.*;

public class Proto extends Organoid implements CasingGenerator {
    private static final EntityDataAccessor<Integer> HOSTS = SynchedEntityData.defineId(Proto.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Optional<UUID>> TARGET = SynchedEntityData.defineId(Proto.class, EntityDataSerializers.OPTIONAL_UUID);
    public static final EntityDataAccessor<BlockPos> NODE = SynchedEntityData.defineId(Proto.class, EntityDataSerializers.BLOCK_POS);
    public Proto(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        setPersistenceRequired();
    }
    @Nullable
    public boolean signal;
    public BlockPos position;
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.proto_loot.get();
    }
    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }



    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.proto_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.proto_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.proto_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.FOLLOW_RANGE, 128)
                .add(Attributes.KNOCKBACK_RESISTANCE, 2);

    }

    @Override
    protected void registerGoals() {
        this.addTargettingGoals();
        this.goalSelector.addGoal(3,new ProtoScentDefense(this));
        this.goalSelector.addGoal(3,new ProtoDefense(this));
        this.goalSelector.addGoal(2,new ProtoTargeting(this));
        this.goalSelector.addGoal(2,new AOEMeleeAttackGoal(this,0,false,2.5,8,livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(4,new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    public boolean isNunny(){
        return Objects.equals(this.getCustomName(), Component.literal("Nunny"));
    }


    public AABB seachbox(){
        return this.getBoundingBox().inflate(SConfig.SERVER.proto_range.get());
    }
    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 200 == 0 && SConfig.SERVER.proto_casing.get()){
            if (this.distanceToSqr(this.entityData.get(NODE).getX(),this.entityData.get(NODE).getY(),this.entityData.get(NODE).getZ()) > 100){
                if (Math.random() < 0.01){
                    this.entityData.set(NODE,this.getOnPos());
                }
            }else{
                this.generateChasing(entityData.get(NODE),this,32,2);
                this.generateChasing(entityData.get(NODE),this,16);
            }
        }
        if (this.tickCount % 1200 == 0){
            List<Entity> entities = this.level().getEntities(this, seachbox() , EntitySelector.NO_CREATIVE_OR_SPECTATOR);
            entityData.set(HOSTS,0);
            for (Entity en : entities) {
                if (en instanceof Infected infected){
                    if (!infected.getLinked()){
                        infected.setLinked(true);
                    }
                    setHosts(getHosts() + 1);
                }
                if (en instanceof Mound mound){
                    if (!mound.getLinked()){
                        mound.setLinked(true);
                    }
                    setHosts(getHosts()+1);
                }
                if (SConfig.SERVER.proto_raid.get()){
                    if (Math.random() < (SConfig.SERVER.proto_raid_chance.get()/100f) && (en instanceof Player || SConfig.SERVER.proto_sapient_target.get().contains(en.getEncodeId()))){
                        int x = random.nextInt(-30,30);
                        int z = random.nextInt(-30,30);
                        Vigil vigil = new Vigil(Sentities.VIGIL.get(),this.level());
                        vigil.randomTeleport(en.getX() + x,en.getY(),en.getZ() + z,false);
                        vigil.setProto(this);
                        vigil.tickEmerging();
                        level().addFreshEntity(vigil);
                        break;
                    }
                }
            }
        }
        if (this.tickCount % 40 == 0){
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

        if (getSignal() && getPlace() != null && checkForCalamities(this.getPlace())){
            this.SummonConstructor(this.level(),this,this.getPlace());
        }
        if (this.tickCount % 3000 == 0){
            this.giveMadness(this);
        }
    }

    protected void giveMadness(Proto proto){
        AABB aabb = proto.getBoundingBox().inflate(128);
        List<Entity> entities = this.level().getEntities(this, aabb);
        for (Entity entity : entities){
            if (entity instanceof LivingEntity living && (SConfig.SERVER.proto_sapient_target.get().contains(living.getEncodeId()) || living instanceof Player)){
                living.addEffect(new MobEffectInstance(Seffects.MADNESS.get(),6000,0));
            }
        }
    }

    public void setSignal(boolean value){
        this.signal = value;
    }
    public boolean getSignal(){
        return this.signal;
    }


    static class ProtoScentDefense extends Goal{
        public Proto proto;
        public ProtoScentDefense(Proto proto1){
            this.proto = proto1;
        }

        @Override
        public boolean canUse() {
            Entity target = this.proto.getTarget();
            return  target != null  && this.proto.random.nextInt(20) == 0 && checkForScent() ;
        }

        private boolean checkForScent() {
            AABB hitbox = this.proto.getBoundingBox().inflate(3);
            List<ScentEntity> entities = this.proto.level().getEntitiesOfClass(ScentEntity.class, hitbox);
            if (entities.size() >= 1){
                return false;
            }
            AABB aabb = this.proto.getBoundingBox().inflate(8);
            List<Entity> entities1 = this.proto.level().getEntities(this.proto, aabb ,EntitySelector.NO_CREATIVE_OR_SPECTATOR);
            return entities1.size() < 3;
        }

        @Override
        public void start() {
            SummonScent();
            super.start();
        }

        private void SummonScent() {
            ScentEntity scent = new ScentEntity(Sentities.SCENT.get(), this.proto.level());
            scent.setOvercharged(true);
            scent.moveTo(this.proto.getX(),this.proto.getY(),this.proto.getZ());
            this.proto.level().addFreshEntity(scent);
        }
    }

     class ProtoDefense extends Goal{
        public Proto proto;
        public ProtoDefense(Proto proto1){
            this.proto = proto1;
        }

        @Override
        public boolean canUse() {
            return this.proto.getTarget() != null &&  this.proto.random.nextInt(150) == 0;
        }
        @Override
        public void start() {
            SummonDefense();
            super.start();
        }


    }
    private void SummonDefense() {
        List<? extends String> summons = SConfig.SERVER.proto_summonable_troops.get();
        LivingEntity target = this.getTarget();
        int x = random.nextInt(-10,10);
        int z = random.nextInt(-10,10);
        if (target != null && this.level() instanceof ServerLevelAccessor world){
            RandomSource rand = RandomSource.create();
            int randomIndex = rand.nextInt(summons.size());
            ResourceLocation randomElement1 = new ResourceLocation(summons.get(randomIndex));
            EntityType<?> randomElement = ForgeRegistries.ENTITY_TYPES.getValue(randomElement1);
            Mob waveentity = (Mob) randomElement.create(this.level());
            assert waveentity != null;
            waveentity.randomTeleport(target.getX() + x,target.getY(),target.getZ() + z,false);
            if (waveentity instanceof Mound mound){
                mound.setMaxAge(1);
                mound.setLinked(true);
            }
            if (waveentity instanceof Vigil vigil){
                vigil.setProto(this);
            }
            waveentity.finalizeSpawn(world, this.level().getCurrentDifficultyAt(new BlockPos((int) this.getX(),(int)  this.getY(),(int)  this.getZ())), MobSpawnType.NATURAL, null, null);
            this.level().addFreshEntity(waveentity);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isOnFire() && !hasEffect(MobEffects.FIRE_RESISTANCE)){
            this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,200,0));
        }else if (this.getLastDamageSource() == damageSources().freeze()){
            this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,400,0));
        }else if (this.getHealth() < (this.getMaxHealth()/2) && !(hasEffect(MobEffects.WEAKNESS) || hasEffect(MobEffects.DAMAGE_RESISTANCE))){
            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,100,0));
        }
    }

    static class ProtoTargeting extends Goal{
        public Proto proto;
        public ProtoTargeting(Proto p){
            this.proto = p;
        }

        @Override
        public boolean canUse() {
            return proto.getTarget() != null  && this.proto.getRandom().nextInt(0,5) == 3;
        }

        @Override
        public boolean canContinueToUse() {
            return proto.getTarget() != null;
        }

        @Override
        public void start() {
            super.start();
            Targeting(proto);
        }

        public void Targeting(Entity entity){
            AABB boundingBox = entity.getBoundingBox().inflate(SConfig.SERVER.proto_range.get());
            List<Entity> entities = entity.level().getEntities(entity, boundingBox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);

            for (Entity entity1 : entities) {
                if(entity1 instanceof Infected infected) {
                    if (infected.getTarget() == null && this.proto.getTarget() != null && this.proto.getTarget().isAlive() && !this.proto.getTarget().isInvulnerable()){
                        infected.setTarget(proto.getTarget());
                    }
                }
            }
        }
    }
    protected int calculateFallDamage(float p_149389_, float p_149390_) {
        return super.calculateFallDamage(p_149389_, p_149390_) - 60;
    }
    @Nullable
    public void addTargets(@Nullable UUID uuid) {
        this.entityData.set(TARGET, Optional.ofNullable(uuid));
    }
    @Nullable
    public UUID readTargets() {
        return this.entityData.get(TARGET).orElse((UUID)null);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("hosts",entityData.get(HOSTS));
        tag.putInt("nodeX",entityData.get(NODE).getX());
        tag.putInt("nodeY",entityData.get(NODE).getY());
        tag.putInt("nodeZ",entityData.get(NODE).getZ());

        if (this.readTargets() != null) {
            tag.putUUID("victim", this.readTargets());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(HOSTS, tag.getInt("hosts"));
        int x = tag.getInt("nodeX");
        int y = tag.getInt("nodeY");
        int z = tag.getInt("nodeZ");
        this.entityData.set(NODE,new BlockPos(x,y,z));
        if (tag.hasUUID("victim")){
            this.addTargets(tag.getUUID("victim"));
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HOSTS,0);
        this.entityData.define(NODE,this.getOnPos());
        this.entityData.define(TARGET, Optional.empty());
    }
    public int getHosts(){
        return entityData.get(HOSTS);
    }
    public void setHosts(int i){
        entityData.set(HOSTS,i);
    }


    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(amount > SConfig.SERVER.proto_dpsr.get() && SConfig.SERVER.proto_dpsr.get() > 0){
            return super.hurt(source, (float) (SConfig.SERVER.proto_dpsr.get() * 1F));
        }
        return super.hurt(source, amount);
    }
    protected SoundEvent getAmbientSound() {
        return Ssounds.PROTO_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    @Override
    public void die(DamageSource source) {
        if (this.level() instanceof ServerLevel serverLevel){
            double x0 = this.getX() - (random.nextFloat() - 0.1) * 1.2D;
            double y0 = this.getY() + (random.nextFloat() - 0.25) * 1.25D * 5;
            double z0 = this.getZ() + (random.nextFloat() - 0.1) * 1.2D;
            serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 4, 0, 0, 0, 1);
            if (SConfig.SERVER.proto_chunk.get()) {
                BlockPos pos = new BlockPos((int) this.getX(), (int) this.getY(), (int) this.getZ());
                ChunkLoaderHelper.unloadChunksInRadius(serverLevel, pos, serverLevel.getChunk(pos).getPos().x, serverLevel.getChunk(pos).getPos().z, 5);
            }
        }
        this.discard();
        AABB aabb = this.getBoundingBox().inflate(2.5);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockState = level().getBlockState(blockpos);
            BlockState above = level().getBlockState(blockpos.above());
            if (!level().isClientSide() && blockState.isSolidRender(level(), blockpos) && !above.isSolidRender(level(), blockpos)) {
                if (Math.random() < 0.9) {
                    if (Math.random() < 0.7) {
                        level().setBlock(blockpos.above(), Sblocks.MYCELIUM_VEINS.get().defaultBlockState(), 2);
                    }
                    if (Math.random() < 0.3) {
                        level().setBlock(blockpos.above(), Sblocks.BIOMASS_BLOCK.get().defaultBlockState(), 2);
                    }
                    if (Math.random() < 0.1) {
                        level().setBlock(blockpos.above(), Sblocks.ROOTED_BIOMASS.get().defaultBlockState(), 2);
                    }
                    if (Math.random() < 0.15) {
                        level().setBlock(blockpos, Sblocks.BRAIN_REMNANTS.get().defaultBlockState(), 2);
                        BlockEntity blockEntity = level().getBlockEntity(blockpos);
                        if (blockEntity instanceof BrainRemnantBlockEntity block){
                            if (source.getDirectEntity() instanceof LivingEntity living){
                                block.setUUID(living.getUUID());
                            }
                            block.setSource(source);
                        }
                    }
                }

            }
        }
        AABB searchbox = AABB.ofSize(new Vec3(this.getX(), this.getY(), this.getZ()), 300, 200, 300);
        List<Entity> entities = this.level().getEntities(this, searchbox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);
        entityData.set(HOSTS,0);
        for (Entity en : entities) {
            if (en instanceof Infected infected){
                if (infected.getLinked()){
                    infected.addEffect(new MobEffectInstance(MobEffects.WITHER,400,1));
                }
            }
        }
        super.die(source);
    }

    public void setPlace(BlockPos pos){
        this.position = pos;
    }
    public BlockPos getPlace(){
        return position;
    }


    public void SummonConstructor(Level level ,Entity entity,BlockPos pos){
        RandomSource randomSource = RandomSource.create();
        int a = randomSource.nextInt(-12,12);
        int b = randomSource.nextInt(-12,12);
        int c = randomSource.nextInt(-4,4);
        BlockPos blockPos = new BlockPos((int) entity.getX()+a,(int) entity.getY()+c,(int) entity.getZ()+b);
        BlockPos blockPosTop = blockPos.above();
        if (level instanceof  ServerLevel serverLevel && serverLevel.isEmptyBlock(blockPos) && (serverLevel.isEmptyBlock(blockPosTop) || serverLevel.getBlockState(blockPosTop).liquid())){
            if (pos != null){
                BiomassReformator.TERRAIN terrain = BiomassReformator.TERRAIN.GROUND_LEVEL;
                if (pos.getY() > 120){
                    terrain = BiomassReformator.TERRAIN.AIR_LEVEL;
                }else if (checkForLiquids(pos)){
                    terrain = BiomassReformator.TERRAIN.WATER_LEVEL;
                }else if (pos.getY()<63){
                 terrain = BiomassReformator.TERRAIN.UNDERGROUND;
                }
                BiomassReformator creature = new BiomassReformator(Sentities.RECONSTRUCTOR.get(),level,terrain,pos);
                creature.tickEmerging();
                creature.setPos(entity.getX()+a,entity.getY()+c,entity.getZ()+b);
                level.addFreshEntity(creature);
                if (level.getServer() != null && !level.isClientSide()){
                    level.getServer().getPlayerList().broadcastSystemMessage(Component.translatable("calamity_summon_message"), false);
                }
                this.setSignal(false);
            }
        }
    }

    private boolean checkForLiquids(BlockPos blockPos){
        AABB aabb = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), 14, 14, 14);
        List<BlockPos> liquids = new ArrayList<>();
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            if (level().getBlockState(blockpos).getFluidState() != Fluids.EMPTY.defaultFluidState()){
                liquids.add(blockpos);
            }
        }
        return liquids.size() > 6 && blockPos.getY() <70;
    }

    public boolean checkForCalamities(BlockPos pos){
        List<Entity> entities = this.level().getEntities(this, seachbox() , EntitySelector.NO_CREATIVE_OR_SPECTATOR);
        for (Entity en : entities) {
            if (en instanceof Calamity calamity && calamity.getSearchArea() == BlockPos.ZERO && Math.random() < 0.5){
                calamity.setSearchArea(pos);
                this.setSignal(false);
                if (level().getServer() != null && !level().isClientSide()){
                    level().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("calamity_coming_message"), false);
                }
                return false;
            }
        }
        return true;
    }

    @Override
    public int getEmerge_tick() {
        return 120;
    }

    public int getNumberOfParticles(){
        return 6;
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance p_33283_, MobSpawnType p_33284_, @Nullable SpawnGroupData p_33285_, @Nullable CompoundTag p_33286_) {
        this.loadChunks();
        this.entityData.set(NODE,this.getOnPos());
        return super.finalizeSpawn(serverLevelAccessor, p_33283_, p_33284_, p_33285_, p_33286_);
    }

    public void loadChunks(){
        if (SConfig.SERVER.proto_chunk.get() && this.level() instanceof ServerLevel serverLevel) {
            BlockPos pos = new BlockPos(this.getBlockX(),this.getBlockY(),this.getBlockZ());
            ChunkLoaderHelper.forceLoadChunk(serverLevel, pos, this.level().getChunk(pos).getPos().x, this.level().getChunk(pos).getPos().z, true);
        }
    }

    @Override
    public boolean hasLineOfSight(Entity entity) {
        if (entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(Seffects.MARKER.get())){
            return true;
        }
        return super.hasLineOfSight(entity);
    }
}
