package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.ExtremelySusThings.ChunkLoaderHelper;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.CalamityVigilCall;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SporeBurstSupport;
import com.Harbinger.Spore.Sentities.AI.CalamityPathNavigation;
import com.Harbinger.Spore.Sentities.AI.FloatDiveGoal;
import com.Harbinger.Spore.Sentities.ArmorPersentageBypass;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import com.Harbinger.Spore.Sentities.HitboxesForParts;
import com.Harbinger.Spore.Sentities.MovementControls.CalamityMovementControl;
import com.Harbinger.Spore.Sentities.Organoids.Mound;
import com.Harbinger.Spore.Sentities.Utility.CorpseEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Method;
import java.util.*;

import static com.Harbinger.Spore.ExtremelySusThings.Utilities.biomass;

public class Calamity extends UtilityEntity implements Enemy, ArmorPersentageBypass {
    public static final EntityDataAccessor<Integer> KILLS = SynchedEntityData.defineId(Calamity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> MUTATION = SynchedEntityData.defineId(Calamity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<BlockPos> SEARCH_AREA = SynchedEntityData.defineId(Calamity.class, EntityDataSerializers.BLOCK_POS);
    public static final EntityDataAccessor<Boolean> ROOTED = SynchedEntityData.defineId(Calamity.class, EntityDataSerializers.BOOLEAN);
    protected int breakCounter;
    private int stun = 0;

    public Calamity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1.0F);
        this.navigation = new CalamityPathNavigation(this,level);
        this.moveControl = new CalamityMovementControl(this,20);
        this.xpReward = 50;
    }

    protected int calculateFallDamage(float p_149389_, float p_149390_) {
        return super.calculateFallDamage(p_149389_, p_149390_) - 25;
    }

    public void setStun(int i) {
        stun = i;
    }

    public boolean isStunned() {
        return stun > 0;
    }

    public boolean doHurtTarget(Entity entity) {
        if (super.doHurtTarget(entity)) {
            if (entity instanceof LivingEntity livingEntity) {
                Utilities.doCustomModifiersAfterEffects(this,livingEntity);
                livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 600, 1), this);
            }
            return true;
        } else {
            return false;
        }
    }
    @Override
    public DamageSource getCustomDamage(LivingEntity entity) {
        if (Math.random() < 0.5){
            return SdamageTypes.calamity_damage1(this);
        }else if (Math.random() < 0.5){
            return SdamageTypes.calamity_damage2(this);
        }
        return SdamageTypes.calamity_damage3(this);
    }

    @Override
    public void setTarget(@Nullable LivingEntity p_21544_) {
        super.setTarget(p_21544_);
        if (isRooted()){this.setRooted(false);}
    }

    protected void tickPart(CalamityMultipart part, double e, double i, double o) {
        part.setPos(this.getX() + e, this.getY() + i, this.getZ() + o);
    }
    protected void tickPart(CalamityMultipart part, Vec3 vec3i) {
        Vec3 vec3 = (vec3i).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        part.setPos(this.getX() + vec3.x, this.getY() + vec3.y, this.getZ() + vec3.z);
    }
    protected void tickPart(CalamityMultipart part, Vec3 vec3i,double Y) {
        Vec3 vec3 = (vec3i).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        part.setPos(this.getX() + vec3.x, this.getY() + Y, this.getZ() + vec3.z);
    }

    @Override
    public void awardKillScore(Entity entity, int i, DamageSource damageSource) {
        AttributeInstance armor = this.getAttribute(Attributes.ARMOR);
        this.entityData.set(KILLS, entityData.get(KILLS) + 1);
        if (canCalcify(entity) && armor != null){
            armor.setBaseValue(armor.getValue()+1);
        }
        super.awardKillScore(entity, i, damageSource);
    }

    public void travel(Vec3 p_32858_) {
        if (this.isEffectiveAi() && this.isInFluidType()) {
            this.moveRelative(0.1F, p_32858_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.7D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(p_32858_);
        }

    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("kills", entityData.get(KILLS));
        tag.putInt("mutation", entityData.get(MUTATION));
        tag.putBoolean("rooted", entityData.get(ROOTED));
        tag.putInt("AreaX", this.getSearchArea().getX());
        tag.putInt("AreaY", this.getSearchArea().getY());
        tag.putInt("AreaZ", this.getSearchArea().getZ());
    }

    public void setMutationColor(){
        int value =colorMap().isEmpty() ? 0 : Utilities.mixColors(colorMap());
        this.entityData.set(MUTATION,value);
    }
    public int getMutationColor(){
        return entityData.get(MUTATION);
    }
    Map<Integer, Float> colorMap(){
        Map<Integer, Float> values = new HashMap<>();
        float toxic = getAtLevel(this.getAttribute(SAttributes.TOXICITY.get()));
        float rejuvenation = getAtLevel(this.getAttribute(SAttributes.REJUVENATION.get()));
        float local = getAtLevel(this.getAttribute(SAttributes.LOCALIZATION.get()));
        float laceration = getAtLevel(this.getAttribute(SAttributes.LACERATION.get()));
        float corrosive = getAtLevel(this.getAttribute(SAttributes.CORROSIVES.get()));
        float ballistic = getAtLevel(this.getAttribute(SAttributes.BALLISTIC.get()));
        float grinding = getAtLevel(this.getAttribute(SAttributes.GRINDING.get()));
        if (toxic > 0){values.put(-16751104,toxic);}
        if (rejuvenation > 0){values.put(-10092442,rejuvenation);}
        if (local > 0){values.put(-6711040,local);}
        if (laceration > 0){values.put(-65536,laceration);}
        if (corrosive > 0){values.put(-13369549,corrosive);}
        if (ballistic > 0){values.put(-10066330,ballistic);}
        if (grinding > 0){values.put(-16764058,grinding);}
        return values;
    }
    public float getAtLevel(AttributeInstance instance){
        if (instance != null){
            return (float) instance.getValue();
        }
        return 0;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean isPushedByFluid(FluidType type) {
        return false;
    }

    public void setSearchArea(BlockPos blockPos) {
        this.entityData.set(SEARCH_AREA, blockPos);
    }

    public BlockPos getSearchArea() {
        return this.entityData.get(SEARCH_AREA);
    }

    public void setKills(Integer count) {
        entityData.set(KILLS, count);
    }

    public int getKills() {
        return entityData.get(KILLS);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(KILLS, tag.getInt("kills"));
        entityData.set(MUTATION, tag.getInt("mutation"));
        entityData.set(ROOTED, tag.getBoolean("rooted"));
        int i = tag.getInt("AreaX");
        int j = tag.getInt("AreaY");
        int k = tag.getInt("AreaZ");
        this.setSearchArea(new BlockPos(i, j, k));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ROOTED, false);
        this.entityData.define(KILLS, 0);
        this.entityData.define(MUTATION, 0);
        this.entityData.define(SEARCH_AREA, BlockPos.ZERO);
    }
    public boolean canCalcify(Entity entity){
        return entity.getType().is(EntityTypeTags.SKELETONS);
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean isRooted(){
        return entityData.get(ROOTED);
    }
    public void setRooted(boolean value){
        entityData.set(ROOTED,value);
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new GoToLocation(this, 1.1));
        this.addTargettingGoals();
        this.goalSelector.addGoal(7,new CalamityVigilCall(this));
    }
    public double getDamageCap(){
        return 0;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        setRooted(false);
        if (this.getRandom().nextInt(20) == 0){
            this.grief(this.getBoundingBox().inflate(this.setInflation(),0.0,this.setInflation()));
        }
        if(amount > getDamageCap() && getDamageCap() > 0){
            return super.hurt(source, (float) getDamageCap());
        }
        if (source.is(DamageTypes.FREEZE) && Math.random() < 0.2f){
            Calamity.forceStart(findGoal(this, SporeBurstSupport.class));
        }
        return super.hurt(source, amount);
    }
    public static void forceStart(Goal goal) {
        try {
            Method m = Goal.class.getDeclaredMethod("start");
            m.setAccessible(true);
            m.invoke(goal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static <T extends Goal> T findGoal(Mob mob, Class<T> goalClass) {
        for (WrappedGoal wrapped : mob.goalSelector.getAvailableGoals()) {
            if (goalClass.isInstance(wrapped.getGoal())) {
                return goalClass.cast(wrapped.getGoal());
            }
        }
        return null;
    }
    public  boolean tryToDigDown(){
        if (this.getSearchArea() != BlockPos.ZERO && this.verticalCollisionBelow){
            double x = Math.abs(this.getSearchArea().getX())  - Math.abs(this.getX());
            double z = Math.abs(this.getSearchArea().getZ()) - Math.abs(this.getZ());
            return this.getSearchArea().getY() < this.getY() && (Math.abs(x) < 6) && (Math.abs(z) < 6);
        }
        return false;
    }

    public void relocateExitPoint(){
        RandomSource randomSource = RandomSource.create();
        if (this.getSearchArea().getY() > this.getY()){
            if ((Math.abs(this.getSearchArea().getX())  - Math.abs(this.getX()) < 6) && (Math.abs(this.getSearchArea().getZ()) - Math.abs(this.getZ()) < 6) && (Math.abs(this.getSearchArea().getY()) - Math.abs(this.getY()) > 4)){
                int f = (int) Math.abs(Math.abs(this.getSearchArea().getY()) - Math.abs(this.getY()));
                int x = randomSource.nextInt(-f,f);
                int z = randomSource.nextInt(-f,f);
               this.setSearchArea(new BlockPos(this.getSearchArea().getX() + x,this.getSearchArea().getY(),this.getSearchArea().getZ() + z));
            }
        }

    }
    public double setInflation(){
        return 1.5;
    }

    public AABB getMiningHitbox(){
        if (this.getSearchArea() != BlockPos.ZERO && this.getTarget() == null){
            if (this.getSearchArea().getY() < this.getY()){
                return this.getBoundingBox().inflate(this.setInflation(),0.0,this.setInflation()).move(0.0,-1.0,0.0);
            }else if (this.getSearchArea().getY() > this.getY()){
                return this.getBoundingBox().inflate(this.setInflation(),0.0,this.setInflation()).move(0.0,1.0,0.0);
            }else{
                return this.getBoundingBox().inflate(this.setInflation(),0.0,this.setInflation());
            }
        }
        return this.getBoundingBox().inflate(this.setInflation(),0.0,this.setInflation()).move(0.0,1.0,0.0);
    }

    protected void grief(AABB aabb){
        boolean flag = false;
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (biomass().contains(blockstate)){
                flag = this.level().setBlock(blockpos, Sblocks.MEMBRANE_BLOCK.get().defaultBlockState(), 3) || flag;
                breakCounter = 0;
            }else{
                if (blockstate.getDestroySpeed(level(), blockpos) < getDestroySpeed() && blockstate.getDestroySpeed(level(), blockpos) >= 0 && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                    flag = this.level().destroyBlock(blockpos, false, this) || flag;
                    breakCounter = 0;
                }
            }
        }
    }
    public void ActivateAdaptation(){}

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 1200 == 0){
            setRooted(this.getTarget() == null && this.getHealth() <= (this.getMaxHealth()*0.3) && onGround());
            if (isRooted()){this.setKills(getKills()+1);}
        }
        if (isRooted()){
            this.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0, 1, 0));
        }
        if (this.getRandom().nextInt(300) == 0 && this.getSearchArea() != BlockPos.ZERO){
            relocateExitPoint();
        }
        if (breakCounter < 80) {
            breakCounter++;
        } else {
            if ((this.getLastDamageSource() == this.damageSources().cactus() || this.getLastDamageSource() == this.damageSources().inWall() || this.horizontalCollision || tryToDigDown())) {
                this.grief(getMiningHitbox());
            }
        }
        if (stun > 0 && this.onGround() && this.level() instanceof ServerLevel serverLevel) {
            --stun;
            this.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0, 1, 0));
            double x0 = this.getX() - (random.nextFloat() - 0.1) * 1.2D;
            double y0 = this.getY() + (random.nextFloat() - 0.25) * 1.25D * 5;
            double z0 = this.getZ() + (random.nextFloat() - 0.1) * 1.2D;
            serverLevel.sendParticles(Sparticles.BLOOD_PARTICLE.get(), x0, y0, z0, 4, 0, 0, 0, 1);
        }
        if (this.getHealth() < this.getMaxHealth() && !this.hasEffect(MobEffects.REGENERATION) && this.getKills() > 0){
            int level = this.getHealth() < this.getMaxHealth()/2 ? 1 : 0;
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION,600,level + calculateHealing()));
            this.setKills(this.getKills()-1);
        }
    }

    private int calculateHealing(){
        AttributeInstance toxic = this.getAttribute(SAttributes.REJUVENATION.get());
        if(toxic != null){
            double level = toxic.getValue();
            if (level < 1){
                return 0;
            }
            return (int) level;
        }
        return 0;
    }

    public int getDestroySpeed(){
        return SConfig.SERVER.calamity_bd.get();
    }

    @Override
    public float amountOfDamage(float value) {
        float extra = 0;
        AttributeInstance penetration = this.getAttribute(SAttributes.LACERATION.get());
        if (penetration != null){
            double e = penetration.getValue();
            if (e >= 1){
                extra = (float) (e * 0.1f);
            }
        }
        AttributeInstance attack = this.getAttribute(Attributes.ATTACK_DAMAGE);
        return attack == null ? value : (float) (attack.getValue() * (0.2f + extra));
    }

    public static class GoToLocation extends Goal {
        public final Calamity infected;
        public final double speed;
        public int tryTicks;

        public GoToLocation(Calamity infected1, double speed) {
            this.infected = infected1;
            this.speed = speed;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        protected void moveMobToBlock() {
            this.infected.getNavigation().moveTo((double) ((float) this.infected.getSearchArea().getX()) + 0.5D, (double) (this.infected.getSearchArea().getY() + 1), (double) ((float) this.infected.getSearchArea().getZ()) + 0.5D, 1);
        }

        @Override
        public boolean canUse() {
            if (this.infected.getSearchArea() != BlockPos.ZERO && this.infected.getSearchArea() != null && infected.getTarget() == null) {
                return this.infected.getSearchArea().distToCenterSqr(this.infected.position()) > 4.0;
            }
            return false;
        }

        @Override
        public void start() {
            this.moveMobToBlock();
            this.tryTicks = 0;
            super.start();
        }

        @Override
        public boolean canContinueToUse() {
            return infected.getTarget() == null;
        }


        @Override
        public void tick() {
            super.tick();
            ++this.tryTicks;
            if (this.infected.getSearchArea() != BlockPos.ZERO && shouldRecalculatePath()) {
                this.moveMobToBlock();
            }
            if (this.infected.getSearchArea() != BlockPos.ZERO && this.infected.getSearchArea().distToCenterSqr(this.infected.position()) < 20.0) {
                infected.setSearchArea(BlockPos.ZERO);
                infected.SummonMound(infected);
                ChunkPos chunk = infected.chunkPosition();
                UUID ownerId = infected.getUUID();
                String id = "calamity_" + ownerId + "_" + chunk.toString();
                ChunkLoaderHelper.removeRequest(id);
            }
        }

        public boolean shouldRecalculatePath() {
            return this.tryTicks % 40 == 0;
        }


        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    @Override
    public void die(DamageSource source) {

        if (this.level() instanceof ServerLevel serverLevel){
            double x0 = this.getX() - (random.nextFloat() - 0.1) * 3.2D;
            double y0 = this.getY() + (random.nextFloat() - 0.25) * 3.25D * 5;
            double z0 = this.getZ() + (random.nextFloat() - 0.1) * 3.2D;
            serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 4, 0, 0, 0, 1);
        }
        this.playSound(Ssounds.CALAMITY_DEATH.get());
        super.die(source);
        summonBiomass();
        this.discard();
    }
    private void SummonMound(Entity entity){
        Mound mound = new Mound(Sentities.MOUND.get(),entity.level());
        mound.moveTo(entity.getX(),entity.getY(),entity.getZ());
        mound.setMaxAge(4);
        entity.level().addFreshEntity(mound);
    }
    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.CALAMITY_DAMAGE.get();
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance p_21435_, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        this.setDefaultAdaptation(serverLevelAccessor);
        this.setMutationColor();
        return super.finalizeSpawn(serverLevelAccessor, p_21435_, p_21436_, p_21437_, p_21438_);
    }

    public void setDefaultAdaptation(ServerLevelAccessor level){
        if (level instanceof ServerLevel serverLevel){
            SporeSavedData data = SporeSavedData.getDataLocation(serverLevel);
            if (data != null && data.getAmountOfHiveminds() >= SConfig.SERVER.proto_spawn_world_mod.get()){
                ActivateAdaptation();
            }
        }
    }

    @Override
    public boolean addEffect(MobEffectInstance instance, @Nullable Entity entity) {
        if (instance.getEffect().getCategory() == MobEffectCategory.HARMFUL && instance.getAmplifier() < 1){
            return false;
        }
        return super.addEffect(instance, entity);
    }
    public List<ItemStack> getDroppedItems(int val) {
        List<ItemStack> drops = new ArrayList<>();

        if (getDropList() == null || getDropList().isEmpty()) {
            return drops;
        }

        for (String str : getDropList()) {
            String[] parts = str.split("\\|");
            if (parts.length < 4) continue; // Safety check

            ResourceLocation itemId = new ResourceLocation(parts[0]);
            Item item = ForgeRegistries.ITEMS.getValue(itemId);
            if (item == null) continue;

            ItemStack stack = new ItemStack(item);
            int minCount = Integer.parseUnsignedInt(parts[2]);
            int maxCount = Integer.parseUnsignedInt(parts[3]);
            int chancePercent = Integer.parseUnsignedInt(parts[1]) + (val * 10);

            int quantity;
            if (minCount == maxCount) {
                quantity = val > 0 ? random.nextInt(maxCount, maxCount + val) : maxCount;
            } else if (minCount >= 1 && maxCount >= 1) {
                float scale = 1.0f + (0.15f * val);
                int adjustedMax = (int) (maxCount * scale);
                quantity = random.nextInt(minCount, adjustedMax + 1);
            } else {
                quantity = 1;
            }

            if (random.nextFloat() < (chancePercent / 100F)) {
                stack.setCount(quantity);
                drops.add(stack);
            }
        }

        return drops;
    }
    public List<HitboxesForParts> parts() {
        return List.of();
    }
    public boolean getAdaptation() {
        return false;
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int val, boolean bool) {
        if (level().isClientSide()) {
            return;
        }

        List<ItemStack> loot = getDroppedItems(val);
        List<HitboxesForParts> partList = parts();
        if (partList.isEmpty() || loot.isEmpty()) {
            return;
        }

        int partCount = partList.size();

        List<List<ItemStack>> distributedLoot = new ArrayList<>();
        for (int i = 0; i < partCount; i++) {
            distributedLoot.add(new ArrayList<>());
        }

        for (ItemStack stack : loot) {
            int baseAmount = stack.getCount() / partCount;
            int remainder = stack.getCount() % partCount;

            for (int i = 0; i < partCount; i++) {
                int amount = baseAmount + (i < remainder ? 1 : 0);
                if (amount > 0) {
                    distributedLoot.get(i).add(stack.copyWithCount(amount));
                }
            }
        }
        summonCorpsePart(partCount,distributedLoot,partList);
    }
    public void summonCorpsePart(int partCount,List<List<ItemStack>> distributedLoot,List<HitboxesForParts> partList){
        for (int i = 0; i < partCount; i++) {
            CorpseEntity partEntity = new CorpseEntity(Sentities.CORPSE_PIECE.get(), level());
            for (ItemStack stack : distributedLoot.get(i)) {
                partEntity.addToInventory(stack);
            }
            partEntity.setColor(this.getMutationColor());
            partEntity.moveTo(this.position());
            partEntity.setDeltaMovement(new Vec3(
                    (random.nextDouble() - random.nextDouble()) * 0.9,
                    random.nextDouble() * 0.6 + 0.3,
                    (random.nextDouble() - random.nextDouble()) * 0.9
            ));

            partEntity.setOwnerAda(getAdaptation());
            partEntity.setCorpseType(partList.get(i).getID());

            level().addFreshEntity(partEntity);
        }
    }
    public HitboxesForParts calculateChance(HitboxesForParts part,float val){
        if (Math.random() < val){
            return part;
        }else {
            return null;
        }
    }
    private void summonBiomass(){
        if (level().isClientSide){
            return;
        }
        AABB aabb = this.getBoundingBox().inflate(1);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockState = level().getBlockState(blockpos);
            if (blockState.isAir() && Math.random() < 0.1f){
                BlockState state = states.get(random.nextInt(states.size()));
                FallingBlockEntity.fall(level(),blockpos,state);
            }
        }
    }
    private static final List<BlockState> states = List.of(Sblocks.BIOMASS_BLOCK.get().defaultBlockState()
    ,Sblocks.ROOTED_BIOMASS.get().defaultBlockState(),Sblocks.CALCIFIED_BIOMASS_BLOCK.get().defaultBlockState()
            ,Sblocks.SICKEN_BIOMASS_BLOCK.get().defaultBlockState(),Sblocks.REMAINS.get().defaultBlockState());
}