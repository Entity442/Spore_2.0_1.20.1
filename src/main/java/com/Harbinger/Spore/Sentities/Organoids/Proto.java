package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.ExtremelySusThings.ChunkLoadRequest;
import com.Harbinger.Spore.ExtremelySusThings.ChunkLoaderHelper;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sblocks.BrainRemnants;
import com.Harbinger.Spore.Sblocks.CDUBlock;
import com.Harbinger.Spore.Sentities.*;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.NeuralProcessing.ProtoAIs.ProtoTargeting;
import com.Harbinger.Spore.Sentities.BaseEntities.*;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Scamper;
import com.Harbinger.Spore.Sentities.Utility.GastGeber;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.SectionPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.*;

public class Proto extends Organoid implements CasingGenerator, FoliageSpread, ChunkLoaderMob {
    private static final EntityDataAccessor<Integer> HOSTS = SynchedEntityData.defineId(Proto.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> BIOMASS = SynchedEntityData.defineId(Proto.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<BlockPos> NODE = SynchedEntityData.defineId(Proto.class, EntityDataSerializers.BLOCK_POS);
    private final List<String> hypers = new ArrayList<>(){{add("spore:inquisitor");add("spore:wendigo");add("spore:hvindicator");add("spore:brot");add("spore:ogre");add("spore:hevoker");}};
    private int summonDefense = 0;
    private static final int INPUT_SIZE = 4;
    private static final int OUTPUT_SIZE = 4;
    private double[] weights;
    public List<String> team_1 = new ArrayList<>();
    public List<String> team_2 = new ArrayList<>();
    public List<String> team_3 = new ArrayList<>();
    public List<String> team_4 = new ArrayList<>();
    public List<String> team_5 = new ArrayList<>();
    private final Random random = new Random();
    public Proto(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        setPersistenceRequired();
        initializeValues();
    }
    private void fillDefaultTeams(List<String> team ,List<? extends String> CONFIG){
        if (CONFIG.size() < 4) {
            throw new IllegalArgumentException("CONFIG must have at least 4 unique entries");
        }
        List<String> shuffledConfig = new ArrayList<>(CONFIG);
        Collections.shuffle(shuffledConfig, random);
        
        for (int i = 0; i < 4; i++) {
            String config = shuffledConfig.get(i);
            int add = isVariantKeeper(config);
            team.add(config + "_" + add);
        }
    }

    protected void initializeValues(){
        this.weights = new double[INPUT_SIZE * OUTPUT_SIZE];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = this.getRandom().nextDouble();
        }
        fillDefaultTeams(team_1,SConfig.SERVER.proto_summonable_troops.get());
        fillDefaultTeams(team_2,SConfig.SERVER.proto_summonable_troops.get());
        fillDefaultTeams(team_3,SConfig.SERVER.proto_summonable_troops.get());
        fillDefaultTeams(team_4,SConfig.SERVER.proto_summonable_troops.get());
    }
    private int isVariantKeeper(String s){
        ResourceLocation location = new ResourceLocation(s);
        Entity entity = ForgeRegistries.ENTITY_TYPES.getValue(location).create(level());
        return entity instanceof VariantKeeper keeper ? this.getRandom().nextInt(keeper.amountOfMutations()) : -1;
    }

    @Nullable
    public Signal signal;
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.proto_loot.get();
    }
    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }
    public double[] getWeights(){
        return weights;
    }
    public double getWeightsValue(int i){
        return weights[i];
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
        this.goalSelector.addGoal(3,new ProtoTargeting(this));
        this.goalSelector.addGoal(4,new AOEMeleeAttackGoal(this,0,false,2.5,8,livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(4,new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    public boolean isNunny(){
        return Objects.equals(this.getCustomName(), Component.literal("Nunny"));
    }

    private void generateCasing(){
        if (this.distanceToSqr(this.entityData.get(NODE).getX(),this.entityData.get(NODE).getY(),this.entityData.get(NODE).getZ()) > 100){
            if (Math.random() < 0.1){
                this.entityData.set(NODE,this.getOnPos());
            }
        }else{
            if (getBiomass() > 40){
                this.generateChasing(entityData.get(NODE),this,32,2);
                this.generateChasing(entityData.get(NODE),this,16);
                eatBiomass(5);
            }

        }
    }

    private void scanForHosts(){
        List<Entity> entities = this.level().getEntities(this, seachbox() , EntitySelector.NO_CREATIVE_OR_SPECTATOR);
        entityData.set(HOSTS,0);
        for (Entity en : entities) {
            if (en instanceof Infected infected){
                if (!infected.getLinked()){
                    infected.setLinked(true);
                }
                if (infected.getTarget() == null || infected.getY() < 0 || infected.getHealth() < infected.getMaxHealth()/2){
                    if (!level().isClientSide && harvestBiomassByDespawning(infected)){
                        setHosts(getHosts() + 1);
                    }
                }else {
                    setHosts(getHosts() + 1);
                }
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
                    vigil.setVariant(2);
                    vigil.tickEmerging();
                    level().addFreshEntity(vigil);
                    break;
                }
            }
        }
    }

    public boolean harvestBiomassByDespawning(Infected living){
        if (living instanceof GastGeber || living instanceof Scamper){
            return true;
        }
        if (living.getKills() > 0){
            addBiomass(living.getKills());
            living.setKills(0);
            return true;
        }
        if (living instanceof Hyper && Math.random() < 0.0001){
            addBiomass(30);
            living.discard();
            return false;
        }else if (living instanceof EvolvedInfected && Math.random() < 0.01){
            addBiomass(15);
            living.discard();
            return false;
        }else if (Math.random() < 0.2){
            addBiomass(5);
            living.discard();
            return false;
        }
        return true;
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
    private boolean checkForScent() {
        AABB hitbox = this.getBoundingBox().inflate(3);
        List<ScentEntity> entities = this.level().getEntitiesOfClass(ScentEntity.class, hitbox);
        return entities.isEmpty();
    }
    private void SummonScent() {
        ScentEntity scent = new ScentEntity(Sentities.SCENT.get(), this.level());
        scent.setOvercharged(true);
        scent.moveTo(this.getX(),this.getY(),this.getZ());
        this.level().addFreshEntity(scent);
    }
    public void addBiomass(int e){
        entityData.set(BIOMASS,entityData.get(BIOMASS)+e);
    }
    public void eatBiomass(int e){
        entityData.set(BIOMASS,entityData.get(BIOMASS)-e);
    }
    public int getBiomass(){
        return entityData.get(BIOMASS);
    }

    public AABB seachbox(){
        return this.getBoundingBox().inflate(SConfig.SERVER.proto_range.get());
    }
    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide){
            if (this.tickCount % 6000 == 0 && SConfig.SERVER.mound_foliage.get() && this.entityData.get(NODE) != BlockPos.ZERO){
                SpreadInfection(level(),SConfig.SERVER.mound_range_age4.get() * 2,this.entityData.get(NODE));
                loadChunks();
            }
            if (this.tickCount % 200 == 0 && SConfig.SERVER.proto_casing.get()){
                generateCasing();
            }
            if (this.tickCount % 1200 == 0){
                scanForHosts();
                moraleBoost();
            }
            if (this.tickCount % 40 == 0){
                griefBlocks();
                Entity target = this.getTarget();
                if (target != null && checkForScent()){
                    SummonScent();
                }
            }
            if (this.tickCount % 200 == 0){
                addBiomass(1);
            }

            if (getSignal()  != null && getSignal().active() && checkForCalamities(getSignal().pos())){
                this.SummonConstructor(this.level(),this,getSignal().pos());
            }
            if (this.tickCount % 3000 == 0 && SConfig.SERVER.proto_madness.get()){
                this.giveMadness(this);
            }
            if (this.summonDefense > 0){
                --summonDefense;
            }
            LivingEntity target = this.getTarget();
            if (this.tickCount % 200 == 0 && target != null){
                BlockPos pos = target.getOnPos();
                if (checkForOrganoids(target) && getBiomass() > 2 && !level().isClientSide) {
                    int e = this.getRandom().nextInt(1,5);
                    for(int o = 0; o<e;o++){
                        summonMob(this.decide(this.inputs(target)),pos);
                    }
                }
            }
        }

    }

    public double[] inputs(LivingEntity entity){
        if (entity == null){
            return new double[]{1,1,1,1};
        }
        double distance = entity.distanceToSqr(this) < 200 ? 1.0 : 0.0;
        double isOnGround = entity.onGround() ? 1.0 : 0.0;
        double hasAllotOfHealth = entity.getMaxHealth() >= 20 ? 1.0 : 0.0;
        double hasAllotOfArmor = entity.getArmorValue() >= 20 ? 1.0 : 0.0;
        return new double[]{distance,isOnGround,hasAllotOfHealth,hasAllotOfArmor};
    }
    public Entity entityResourceLocation(int decision, List<String> string){
        if (string.isEmpty()){
            return null;
        }
        String[] id = string.get(decision).split("_");
        ResourceLocation location = new ResourceLocation(id[0]);
        int variant = Integer.parseInt(id[1]);
        Entity entity = ForgeRegistries.ENTITY_TYPES.getValue(location).create(level());
        if (entity == null){
            entity = new Mound(Sentities.MOUND.get(), level());
        }
        if (entity instanceof VariantKeeper keeper && variant > 0){
            keeper.setVariant(variant);
        }
        return entity;
    }
    public List<String> getDecisionList(int decision){
        return switch (decision){
            case 0 -> team_1;
            case 1 -> team_2;
            case 2 -> team_3;
            case 3 -> team_4;
            default -> null;
        };
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
    private void summonMob(int decision, BlockPos pos) {
        if (pos.equals(BlockPos.ZERO)) {
            return;
        }
        List<String> team = getDecisionList(decision);
        int i = this.getRandom().nextInt(team.size());
        BlockPos blockPos = pos;
        Entity summoned = entityResourceLocation(i,team);
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
            organoid.finalizeSpawn(serverLevel,serverLevel.getCurrentDifficultyAt(pos),MobSpawnType.SPAWNER,null,null);
        }
        CompoundTag data = summoned.getPersistentData();
        data.putInt("hivemind",this.getId());
        data.putInt("decision",decision);
        data.putInt("member",decision);
        if (summoned instanceof LivingEntity mob){
            mob.randomTeleport(blockPos.getX(), blockPos.getY(), blockPos.getZ(),false);
        }else {
            summoned.teleportTo(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        }
        if (checkTheGround(pos,summoned.level()) && summoned.position().distanceToSqr(0,0,0) > 10){
            eatBiomass(2);
            level().addFreshEntity(summoned);
        }
    }

    public void moraleBoost(){
        int e = 0;
        for (double weight : weights) {
            if (weight < 0) {
                e++;
            }
        }
        if (e > weights.length/2){
            for (int i = 0; i < weights.length; i++) {
                weights[i] = weights[i] + this.getRandom().nextDouble();
            }
        }
    }

    protected void giveMadness(Proto proto){
        AABB aabb = proto.getBoundingBox().inflate(128);
        List<Entity> entities = this.level().getEntities(this, aabb);
        for (Entity entity : entities){
            if (entity instanceof LivingEntity living && (SConfig.SERVER.proto_sapient_target.get().contains(living.getEncodeId()) || living instanceof Player)){
                living.addEffect(new MobEffectInstance(Seffects.MADNESS.get(),6000,0,false,false));
            }
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

    protected int calculateFallDamage(float p_149389_, float p_149390_) {
        return super.calculateFallDamage(p_149389_, p_149390_) - 60;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("biomass",entityData.get(BIOMASS));
        tag.putInt("hosts",entityData.get(HOSTS));
        tag.putInt("nodeX",entityData.get(NODE).getX());
        tag.putInt("nodeY",entityData.get(NODE).getY());
        tag.putInt("nodeZ",entityData.get(NODE).getZ());
        ListTag weightsList = new ListTag();
        for (double weight : weights) {
            weightsList.add(DoubleTag.valueOf(weight));
        }
        tag.put("weights", weightsList);
        List<List<String>> teams = List.of(team_1, team_2, team_3, team_4,team_5);
        for (int i = 0; i < teams.size(); i++) {
            ListTag teamTag = new ListTag();
            for (String member : teams.get(i)) {
                teamTag.add(StringTag.valueOf(member));
            }
            tag.put("team_" + (i + 1), teamTag);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(BIOMASS, tag.getInt("biomass"));
        entityData.set(HOSTS, tag.getInt("hosts"));
        int x = tag.getInt("nodeX");
        int y = tag.getInt("nodeY");
        int z = tag.getInt("nodeZ");
        this.entityData.set(NODE,new BlockPos(x,y,z));
        ListTag weightsList = tag.getList("weights", Tag.TAG_DOUBLE);
        this.weights = new double[weightsList.size()];
        for (int i = 0; i < weightsList.size(); i++) {
            this.weights[i] = weightsList.getDouble(i);
        }
        team_1.clear();
        team_2.clear();
        team_3.clear();
        team_4.clear();
        team_5.clear();
        List<List<String>> teams = List.of(team_1, team_2, team_3, team_4,team_5);
        for (int i = 0; i < teams.size(); i++) {
            ListTag teamTag = tag.getList("team_" + (i + 1), Tag.TAG_STRING);
            for (int j = 0; j < teamTag.size(); j++) {
                teams.get(i).add(teamTag.getString(j));
            }
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BIOMASS,100);
        this.entityData.define(HOSTS,0);
        this.entityData.define(NODE,this.getOnPos());
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
        if (source.getEntity() != null && Math.random() < 0.2f && summonDefense <= 0){
            for (int i = 0;i<random.nextInt(1,4);i++)
                SummonHelpers();
            summonDefense = 160;
        }
        if (source.is(DamageTypes.FREEZE) && Math.random() < 0.2f){
            SpreadInfection(level(),SConfig.SERVER.mound_range_age4.get() * 2,this.entityData.get(NODE));
        }
        return super.hurt(source, amount);
    }
    protected SoundEvent getAmbientSound() {
        return Ssounds.PROTO_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        if (this.level() instanceof ServerLevel serverLevel) {
            spawnDeathParticles(serverLevel);
            cleanupChunkLoading();
        }
        spreadBlocksAroundDeath();
        affectNearbyEntities();
        this.discard();
    }

    private void spawnDeathParticles(ServerLevel level) {
        double x = this.getX() - (random.nextFloat() - 0.1) * 1.2D;
        double y = this.getY() + (random.nextFloat() - 0.25) * 1.25D * 5;
        double z = this.getZ() + (random.nextFloat() - 0.1) * 1.2D;
        level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 4, 0, 0, 0, 1);
    }

    private void cleanupChunkLoading() {
        ChunkPos chunk = this.chunkPosition();
        String requestId = "hivemind_" + this.getUUID() + "_" + chunk;
        ChunkLoaderHelper.removeRequest(requestId);
    }

    private void spreadBlocksAroundDeath() {
        AABB area = this.getBoundingBox().inflate(2.5);

        BlockPos.betweenClosed(
                Mth.floor(area.minX), Mth.floor(area.minY), Mth.floor(area.minZ),
                Mth.floor(area.maxX), Mth.floor(area.maxY), Mth.floor(area.maxZ)
        ).forEach(this::trySpreadBlockAt);
    }

    private void trySpreadBlockAt(BlockPos pos) {
        BlockState ground = level().getBlockState(pos);
        BlockState above = level().getBlockState(pos.above());

        if (!level().isClientSide() && ground.isSolidRender(level(), pos) && !above.isSolidRender(level(), pos)) {
            double chance = Math.random();
            if (chance < 0.9) {
                if (Math.random() < 0.7) {
                    level().setBlock(pos.above(), Sblocks.MYCELIUM_VEINS.get().defaultBlockState(), 2);
                }
                if (Math.random() < 0.3) {
                    level().setBlock(pos.above(), Sblocks.BIOMASS_BLOCK.get().defaultBlockState(), 2);
                }
                if (Math.random() < 0.1) {
                    level().setBlock(pos.above(), Sblocks.ROOTED_BIOMASS.get().defaultBlockState(), 2);
                }
                if (Math.random() < 0.15) {
                    level().setBlock(pos, Sblocks.BRAIN_REMNANTS.get().defaultBlockState().setValue(BrainRemnants.OCCUPIED,true), 2);
                }
            }
        }
    }
    private void affectNearbyEntities() {
        AABB searchBox = AABB.ofSize(new Vec3(getX(), getY(), getZ()), 300, 200, 300);
        List<Entity> nearbyEntities = this.level().getEntities(this, searchBox, EntitySelector.NO_CREATIVE_OR_SPECTATOR);

        entityData.set(HOSTS, 0);

        for (Entity entity : nearbyEntities) {
            if (entity instanceof Infected infected && infected.getLinked()) {
                infected.addEffect(new MobEffectInstance(MobEffects.WITHER, 400, 1));
            }

            if (entity instanceof Calamity calamity) {
                calamity.setSearchArea(this.getOnPos());
            }
        }
    }


    public void setSignal(@Nullable Signal signal) {
        this.signal = signal;
    }

    @Nullable
    public Signal getSignal() {
        return signal;
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
                Womb.TERRAIN terrain = Womb.TERRAIN.GROUND_LEVEL;
                if (pos.getY() > 120){
                    terrain = Womb.TERRAIN.AIR_LEVEL;
                }else if (pos.getY()<63){
                 terrain = Womb.TERRAIN.UNDERGROUND;
                }else if (checkForLiquids(pos)){
                    terrain = Womb.TERRAIN.WATER_LEVEL;
                }
                Womb creature = new Womb(Sentities.RECONSTRUCTOR.get(),level,terrain,pos);
                creature.tickEmerging();
                creature.teleportRelative(entity.getX()+a,entity.getY()+c,entity.getZ()+b);
                level.addFreshEntity(creature);
                level.getServer();
                for(ServerPlayer player : level.getServer().getPlayerList().getPlayers()){
                    player.playNotifySound(Ssounds.CALAMITY_SPAWN.get(), SoundSource.AMBIENT,1f,1f);
                    player.displayClientMessage(Component.translatable("calamity_summon_message"), false);
                }
                this.setSignal(null);
            }
        }
    }
    public void SummonHelpers(){
        int a = random.nextInt(-12,12);
        int b = random.nextInt(-12,12);
        int c = random.nextInt(4);
        if (level() instanceof ServerLevel serverLevel){
             int i = hypers.size();
            Verwa verwa = new Verwa(Sentities.VERVA.get(),serverLevel);
            verwa.setStoredMob(hypers.get(random.nextInt(i)));
            verwa.teleportRelative(this.getX()+a,this.getY()+c,this.getZ()+b);
            verwa.tickEmerging();
            level().addFreshEntity(verwa);
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
                this.setSignal(null);
                for(ServerPlayer player : this.level().getServer().getPlayerList().getPlayers()){
                    player.playNotifySound(Ssounds.CALAMITY_INCOMING.get(), SoundSource.AMBIENT,1f,1f);
                    player.displayClientMessage(Component.translatable("calamity_coming_message"), false);
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
        if (serverLevelAccessor instanceof ServerLevel serverLevel && SConfig.SERVER.teleport_hive.get()) {
            teleportToSurface(serverLevel, this);
        }
        this.entityData.set(NODE,this.getOnPos());
        return super.finalizeSpawn(serverLevelAccessor, p_33283_, p_33284_, p_33285_, p_33286_);
    }

    public void loadChunks(){
        if (SConfig.SERVER.proto_chunk.get() && this.level() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().execute(() -> {
                ChunkPos chunk = this.chunkPosition();
                UUID ownerId = this.getUUID();
                String id = "hivemind_" + ownerId + "_" + chunk.toString();

                ChunkLoadRequest request = new ChunkLoadRequest(
                        serverLevel.dimension(),
                        new ChunkPos[]{chunk},
                        1,
                        id,
                        20 * 60 * 10,
                        ownerId
                );

                if (ChunkLoaderHelper.ACTIVE_REQUESTS.containsValue(request)){
                    return;
                }
                ChunkLoaderHelper.addRequest(request);
            });
        }
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        loadChunks();
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

    public int decide(double[] inputs) {
        if (weights == null || weights.length == 0){
            initializeValues();
        }
        if (inputs == null || inputs.length == 0){
            return 0;
        }
        double[] outputs = new double[OUTPUT_SIZE];
        for (int i = 0; i < OUTPUT_SIZE; i++) {
            for (int j = 0; j < INPUT_SIZE; j++) {
                outputs[i] += inputs[j] * weights[i * INPUT_SIZE + j];
            }
        }
        return argmax(outputs);
    }
    private int argmax(double[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }

    public void punishForDecision(int decision,int member) {
        this.adjustWeightsForDecision(decision, -0.1);
        if (Math.random() < 0.05){
            punishMember(getDecisionList(decision),member);
        }
    }
    public void praisedForDecision(int decision,int member) {
        this.adjustWeightsForDecision(decision, 0.05);
        if (Math.random() < 0.2){
            awardMember(getDecisionList(decision),member);
        }
    }
    public void adjustWeightsForDecision(int decision, double penalty) {
        int startIndex = decision * INPUT_SIZE;
        int endIndex = startIndex + INPUT_SIZE;

        for (int i = startIndex; i < endIndex; i++) {
            weights[i] += penalty;
            weights[i] = Math.max(-1.0, Math.min(1.0, weights[i]));
        }
    }

    private void punishMember(List<String> team, int member) {
        if (team == null || team.isEmpty() || member < 0 || member >= team.size()) return;
        String removed = team.remove(member);
        String newMember = getUniqueReplacement(team, SConfig.SERVER.proto_summonable_troops.get());
        if (newMember != null) {
            team.add(newMember);
        } else {
            team.add(removed);
        }
    }
    private void awardMember(List<String> team, int member){
        if (team == null || team.isEmpty() || member < 0 || member >= team.size()) return;
        String s = team.get(member);
        if (!team_5.contains(s)){
            team_5.add(team.get(member));
        }
    }

    private String getUniqueReplacement(List<String> team, List<? extends String> CONFIG) {
        List<String> possibleReplacements;
        if (team_5.isEmpty()){
            possibleReplacements = new ArrayList<>(CONFIG);
        }else {
            possibleReplacements = team_5;
            possibleReplacements.removeAll(team);
            if (!possibleReplacements.isEmpty()){
                String s = possibleReplacements.get(random.nextInt(possibleReplacements.size()));
                team_5.remove(s);
                return s;
            }
        }
        List<String> mobsInTeam = new ArrayList<>();
        for (String s : team){
            String[] string = s.split("_");
            mobsInTeam.add(string[0]);
        }
        possibleReplacements.removeAll(mobsInTeam);
        if (possibleReplacements.isEmpty()) {
            return null;
        }
        String member = possibleReplacements.get(random.nextInt(possibleReplacements.size()));
        int add = isVariantKeeper(member);
        return member + "_" + add;
    }

    public static void teleportToSurface(ServerLevel level, Mob entity) {
        BlockPos startPos = entity.blockPosition();

        if (level.canSeeSky(startPos)) return;

        int surfaceY = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, startPos.getX(), startPos.getZ());
        BlockPos surfacePos = new BlockPos(startPos.getX(), surfaceY, startPos.getZ());
        if (level.canSeeSky(surfacePos)) {
            BlockPos.MutableBlockPos checkPos = new BlockPos.MutableBlockPos(surfacePos.getX(), surfacePos.getY(), surfacePos.getZ());
            for (int i = 0; i < 8; i++) {
                BlockState below = level.getBlockState(checkPos.below());
                BlockState current = level.getBlockState(checkPos);
                if (below.isSolid() && current.isAir()) {
                    entity.teleportTo(checkPos.getX() + 0.5D, checkPos.getY(), checkPos.getZ() + 0.5D);
                    return;
                }
                checkPos.move(Direction.DOWN);
            }
        }
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(startPos.getX(), startPos.getY(), startPos.getZ());
        while (pos.getY() < level.getMaxBuildHeight()) {
            pos.move(Direction.UP);
            if (level.canSeeSky(pos)) {
                entity.teleportTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D);
                return;
            }
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
    public String getChunkId() {
        UUID ownerId = this.getUUID();
        return "hivemind_" + ownerId + "_";
    }

    @Override
    public boolean shouldLoadChunk() {
        return SConfig.SERVER.proto_chunk.get();
    }

    @Override
    public int chunkLifeTicks() {
        return 20 * 60 * 10;
    }
}
