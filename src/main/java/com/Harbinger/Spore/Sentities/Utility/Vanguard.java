package com.Harbinger.Spore.Sentities.Utility;


import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.ExtremelySusThings.ChunkLoadRequest;
import com.Harbinger.Spore.ExtremelySusThings.ChunkLoaderHelper;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.FloatDiveGoal;
import com.Harbinger.Spore.Sentities.ArmorPersentageBypass;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.ChunkLoaderMob;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.StructureTags;
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
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static com.Harbinger.Spore.ExtremelySusThings.Utilities.biomass;

public class Vanguard extends UtilityEntity implements CrossbowAttackMob, Enemy , ArmorPersentageBypass, ChunkLoaderMob {
    private static final EntityDataAccessor<Boolean> IS_CHARGING_CROSSBOW = SynchedEntityData.defineId(Vanguard.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> KILLS = SynchedEntityData.defineId(Vanguard.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> RAID_TIME_OUT = SynchedEntityData.defineId(Vanguard.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<BlockPos> VILLAGE = SynchedEntityData.defineId(Vanguard.class, EntityDataSerializers.BLOCK_POS);
    private int attackAnimationTick;
    public Vanguard(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.navigation = new WallClimberNavigation(this,level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.vanguard_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.35)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.vanguard_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.vanguard_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 48)
                .add(Attributes.ATTACK_KNOCKBACK, 2)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    @Override
    protected void registerGoals() {
        addTargettingGoals();
        this.goalSelector.addGoal(1,new VanguardRangedCrossbowAttackGoal<>(this,12));
        this.goalSelector.addGoal(2, new CustomMeleeAttackGoal(this, 1, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 6.0 + entity.getBbWidth() * entity.getBbWidth();}});
        this.goalSelector.addGoal(2,new VanguardFireGoal(this));
        this.goalSelector.addGoal(3,new VanguardCallRaid(this));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6,new FloatDiveGoal(this));
        super.registerGoals();
    }
    @Override
    protected int calculateFallDamage(float p_21237_, float p_21238_) {
        return super.calculateFallDamage(p_21237_, p_21238_) - 15;
    }
    protected SoundEvent getAmbientSound() {
        return isInvisible() ? null : Ssounds.VANGUARD_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.EVOLVE_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
    }
    public boolean canFireProjectileWeapon(ProjectileWeaponItem projectileWeapon) {
        return projectileWeapon == Items.CROSSBOW;
    }
    public void setKills(int val){
        entityData.set(KILLS,val);
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_CHARGING_CROSSBOW, false);
        this.entityData.define(KILLS, 0);
        this.entityData.define(RAID_TIME_OUT, 0);
        this.entityData.define(VILLAGE, BlockPos.ZERO);
    }
    public BlockPos getVillage(){
        return entityData.get(VILLAGE);
    }
    public void setVillage(BlockPos pos){
        entityData.set(VILLAGE,pos);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(KILLS,tag.getInt("kills"));
        entityData.set(RAID_TIME_OUT,tag.getInt("raid"));
        int x = tag.getInt("villageX");
        int y = tag.getInt("villageY");
        int z = tag.getInt("villageZ");
        setVillage(new BlockPos(x,y,z));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("kills",entityData.get(KILLS));
        tag.putInt("raid",entityData.get(RAID_TIME_OUT));
        tag.putInt("villageX",getVillage().getX());
        tag.putInt("villageY",getVillage().getY());
        tag.putInt("villageZ",getVillage().getZ());
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        if (entity instanceof LivingEntity livingEntity){
            livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),600,0));
        }
        this.playSound(Ssounds.VANGUARD_SLASH.get());
        return super.doHurtTarget(entity);
    }

    @Override
    public void awardKillScore(Entity killed, int scoreValue, DamageSource source) {
        super.awardKillScore(killed, scoreValue, source);
        entityData.set(KILLS,entityData.get(KILLS)+1);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.FIREWORKS)){
            return false;
        }
        if (source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.IN_FIRE)){
            amount = amount/2;
        }
        return super.hurt(source, amount);
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

    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
        this.setItemSlot(EquipmentSlot.MAINHAND,new ItemStack(Items.CROSSBOW));
        ItemStack itemstack = this.getMainHandItem();
        if (itemstack.is(Items.CROSSBOW)) {
            Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemstack);
            map.putIfAbsent(Enchantments.MULTISHOT, 1);
            map.putIfAbsent(Enchantments.QUICK_CHARGE, 3);
            EnchantmentHelper.setEnchantments(map, itemstack);
            this.setItemSlot(EquipmentSlot.MAINHAND, itemstack);
        }
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        if (level instanceof ServerLevel serverLevel){
            locateVillageOnSpawn(serverLevel);
        }
        this.populateDefaultEquipmentSlots(this.random, difficulty);
        return super.finalizeSpawn(level, difficulty, p_21436_, p_21437_, p_21438_);
    }

    private void griefBlocks(LivingEntity livingEntity){
        AABB aabb = (livingEntity != null && livingEntity.getY() > this.getY()) ? this.getBoundingBox().inflate(-0.2D,0.5D,-0.2D).move(0,0.5,0) : this.getBoundingBox().inflate(0.5D).move(0,0.5,0);
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
    public boolean isChargingCrossbow() {
        return this.entityData.get(IS_CHARGING_CROSSBOW);
    }

    public void setChargingCrossbow(boolean p_33302_) {
        this.entityData.set(IS_CHARGING_CROSSBOW, p_33302_);
    }

    @Override
    public void shootCrossbowProjectile(LivingEntity livingEntity, ItemStack itemStack, Projectile projectile, float v) {
        this.performCrossbowAttack(this, 3.2f);
    }

    @Override
    public void onCrossbowAttackPerformed() {
        this.noActionTime = 0;
    }


    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        this.performCrossbowAttack(this, 3.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount % 40 == 0 && horizontalCollision && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)){
            griefBlocks(this.getTarget());
        }
        if (tickCount % 20 == 0 && this.getHealth() < this.getMaxHealth() && !hasEffect(MobEffects.REGENERATION) && entityData.get(KILLS) > 0){
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION,400,0));
            entityData.set(KILLS,entityData.get(KILLS)-1);
        }
        if (entityData.get(RAID_TIME_OUT) > 0){
            entityData.set(RAID_TIME_OUT,entityData.get(RAID_TIME_OUT)-1);
        }
        if (tickCount % 40 == 0 && getVillage() != BlockPos.ZERO && getTarget() == null && level() instanceof ServerLevel serverLevel){
            tickMovement(serverLevel);
        }
    }

    @Override
    public float amountOfDamage(float value) {
        return value * 0.25f;
    }

    @Override
    public String getChunkId() {
        UUID uuid1 = this.getUUID();
        return "vanguard_"+uuid1+"_";
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.vanguard_loot.get();
    }
    @Override
    public boolean shouldLoadChunk() {
        return SConfig.SERVER.vanguard_chunk_load.get() && getVillage() != BlockPos.ZERO;
    }

    @Override
    public int chunkLifeTicks() {
        return 20*30;
    }

    public static class VanguardFireGoal extends Goal {
        private final Vanguard vanguard;
        protected BlockPos targetPos;
        protected List<BlockPos> targetPositions = new ArrayList<>();
        protected List<BlockPos> firePositions = new ArrayList<>();
        private static final ItemStack FLINT = new ItemStack(Items.FLINT_AND_STEEL);
        private int fireCooldown = 0;

        public VanguardFireGoal(Vanguard vanguard) {
            this.vanguard = vanguard;
        }

        boolean searchForFunnyBlocks(){
            targetPositions.clear();
            firePositions.clear();
            AABB aabb = this.vanguard.getBoundingBox().inflate(10, 6, 10);
            boolean thereAreBurnAbleBlocks = false;
            for(BlockPos blockpos : BlockPos.betweenClosed(
                    Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ),
                    Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {

                BlockState blockstate = vanguard.level().getBlockState(blockpos);
                Block block = blockstate.getBlock();

                if (block instanceof BedBlock || block instanceof FurnaceBlock){
                    targetPositions.add(blockpos.immutable());
                }
                if (block instanceof FireBlock){
                    firePositions.add(blockpos.immutable());
                }
                if (block.isFlammable(blockstate,vanguard.level(),blockpos,Direction.UP)){
                    thereAreBurnAbleBlocks = true;
                }
            }

            if (!targetPositions.isEmpty() && thereAreBurnAbleBlocks) {
                this.targetPos = targetPositions.get(vanguard.getRandom().nextInt(targetPositions.size()));
                boolean hasFireNearby = firePositions.stream()
                        .anyMatch(pos -> pos.distSqr(targetPos) < 36);
                return !hasFireNearby;
            }
            return false;
        }

        @Override
        public boolean canUse() {
            // Check every few seconds, not on exact tick counts
            if (vanguard.tickCount % 40 == 0) {
                return searchForFunnyBlocks();
            }
            return false;
        }

        @Override
        public void start() {
            super.start();
            if (targetPos != null){
                // Try to create a path to the target
                Path path = this.vanguard.navigation.createPath(targetPos, 1);
                if (path != null) {
                    this.vanguard.navigation.moveTo(path, 1.0);
                }
                vanguard.setItemSlot(EquipmentSlot.OFFHAND, FLINT);
            }
            fireCooldown = 0;
        }

        @Override
        public void tick() {
            super.tick();
            fireCooldown++;

            if (targetPos != null){
                // Check distance to target
                double distanceSqr = targetPos.distToCenterSqr(vanguard.position());

                if (distanceSqr < 25) { // Within 5 blocks
                    // Set fire and move away
                    if (fireCooldown >= 20) { // Every second
                        setFire();
                        fireCooldown = 0;

                        // Move away from the fire
                        Vec3 awayDirection = vanguard.position().subtract(Vec3.atCenterOf(targetPos)).normalize();
                        Vec3 awayPos = vanguard.position().add(awayDirection.scale(10));

                        Path awayPath = this.vanguard.navigation.createPath(
                                BlockPos.containing(awayPos), 1);
                        if (awayPath != null) {
                            this.vanguard.navigation.moveTo(awayPath, 1.5);
                        }
                        stop();
                    }
                } else {
                    // Keep moving toward target
                    if (this.vanguard.navigation.isDone()) {
                        Path path = this.vanguard.navigation.createPath(targetPos, 1);
                        if (path != null) {
                            this.vanguard.navigation.moveTo(path, 1.0);
                        }
                    }
                }
            }
        }

        @Override
        public boolean canContinueToUse() {
            // Continue if we have a target and haven't reached timeout
            return targetPos != null && vanguard.tickCount % 400 != 0;
        }

        public void setFire(){
            if (targetPos == null) return;

            AABB aabb = new AABB(targetPos).inflate(3, 2, 3);
            for(BlockPos blockpos : BlockPos.betweenClosed(
                    Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ),
                    Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {

                BlockState blockstate = vanguard.level().getBlockState(blockpos);

                // Random chance to set fire
                if (vanguard.getRandom().nextFloat() < 0.3f) {
                    for(Direction direction : Direction.values()) {
                        BlockPos adjacentPos = blockpos.relative(direction);
                        BlockState adjacentState = vanguard.level().getBlockState(adjacentPos);

                        // Check if block is flammable and adjacent position is air
                        if (blockstate.isFlammable(vanguard.level(), blockpos, direction) &&
                                adjacentState.isAir()) {

                            // Try to set fire
                            BlockState fireState = Blocks.FIRE.defaultBlockState();
                            if (FireBlock.canBePlacedAt(vanguard.level(), adjacentPos, direction)) {
                                vanguard.level().setBlock(adjacentPos, fireState, 3);
                                break; // Set fire in one direction only
                            }
                        }
                    }
                }
            }
            vanguard.level().removeBlock(targetPos,true);
            vanguard.playSound(Ssounds.VANGUARD_GRIEF.get());
        }

        @Override
        public void stop() {
            super.stop();
            targetPos = null;
            targetPositions.clear();
            firePositions.clear();
            vanguard.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
            this.vanguard.navigation.stop();
        }
    }

    public static class VanguardRangedCrossbowAttackGoal<T extends Mob & CrossbowAttackMob> extends Goal {

        private final T mob;
        private CrossbowState state = CrossbowState.UNCHARGED;
        private final float attackRadiusSqr;
        private int attackDelay;
        private boolean fireworks;

        public VanguardRangedCrossbowAttackGoal(T mob, float attackRadius) {
            this.mob = mob;
            this.attackRadiusSqr = attackRadius * attackRadius;
        }

        @Override
        public boolean canUse() {
            return isHoldingCrossbow();
        }

        @Override
        public boolean canContinueToUse() {
            return isHoldingCrossbow();
        }

        private boolean isHoldingCrossbow() {
            return mob.isHolding(i -> i.getItem() instanceof CrossbowItem);
        }

        @Override
        public void stop() {
            super.stop();
            if (mob.isUsingItem()) mob.stopUsingItem();
            state = CrossbowState.UNCHARGED;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        // =====================================================
        // PROJECTILE CREATION
        // =====================================================

        private ItemStack createExplosiveRocket() {
            fireworks = true;

            ItemStack rocket = new ItemStack(Items.FIREWORK_ROCKET);
            CompoundTag fw = rocket.getOrCreateTagElement("Fireworks");
            fw.putByte("Flight", (byte) 1);

            ListTag list = new ListTag();
            list.add(makeExplosionNBT(0, new int[]{3887386}, new int[]{4312372}));
            list.add(makeExplosionNBT(1, new int[]{15435844}, new int[]{14602026}));
            list.add(makeExplosionNBT(4, new int[]{2437522}, new int[]{2651799}));
            fw.put("Explosions", list);

            return rocket;
        }

        private CompoundTag makeExplosionNBT(int shape, int[] colors, int[] fades) {
            CompoundTag n = new CompoundTag();
            n.putByte("Type", (byte) shape);
            n.putIntArray("Colors", colors);
            n.putIntArray("FadeColors", fades);
            n.putBoolean("Trail", true);
            n.putBoolean("Flicker", true);
            return n;
        }

        private ItemStack getArrow() {
            fireworks = false;
            return PotionUtils.setPotion(new ItemStack(Items.TIPPED_ARROW), Spotion.MYCELIUM_POTION.get());
        }

        // =====================================================
        // CHARGED PROJECTILE NBT (Vanilla helper is private)
        // =====================================================

        private static void addChargedProjectile(ItemStack crossbow, ItemStack projectile) {
            CompoundTag tag = crossbow.getOrCreateTag();
            ListTag list;

            if (tag.contains("ChargedProjectiles", 9)) {
                list = tag.getList("ChargedProjectiles", 10);
            } else {
                list = new ListTag();
            }

            CompoundTag projTag = new CompoundTag();
            projectile.save(projTag);
            list.add(projTag);

            tag.put("ChargedProjectiles", list);
        }

        private static boolean isCrossbowEmpty(ItemStack crossbow) {
            return !crossbow.getOrCreateTag().contains("ChargedProjectiles");
        }

        // =====================================================
        // TICK LOGIC
        // =====================================================

        @Override
        public void tick() {
            LivingEntity target = this.mob.getTarget();

            boolean hasLOS = target != null && this.mob.getSensing().hasLineOfSight(target);
            double dist = target == null ? 0 : this.mob.distanceToSqr(target);

            ItemStack bow = mob.getItemInHand(
                    ProjectileUtil.getWeaponHoldingHand(mob, i -> i instanceof CrossbowItem));

            if (isCrossbowEmpty(bow) && state == CrossbowState.UNCHARGED) {
                state = CrossbowState.CHARGING;
                mob.startUsingItem(ProjectileUtil.getWeaponHoldingHand(mob, i -> i instanceof CrossbowItem));
            }

            switch (state) {

                case UNCHARGED -> {
                    if (isCrossbowEmpty(bow)) {
                        mob.startUsingItem(ProjectileUtil.getWeaponHoldingHand(mob, i -> i instanceof CrossbowItem));
                        state = CrossbowState.CHARGING;
                    }
                }

                case CHARGING -> {
                    if (!mob.isUsingItem()) {
                        state = CrossbowState.UNCHARGED;
                        return;
                    }

                    int useTicks = mob.getTicksUsingItem();
                    ItemStack using = mob.getUseItem();

                    if (useTicks >= CrossbowItem.getChargeDuration(using)) {
                        mob.releaseUsingItem();

                        ItemStack projectile = Math.random() <= 0.2f ? createExplosiveRocket() : getArrow();
                        addChargedProjectile(bow, projectile);

                        state = CrossbowState.CHARGED;
                        attackDelay = 6;
                    }
                }

                case CHARGED -> {
                    if (--attackDelay <= 0) {
                        state = CrossbowState.READY_TO_ATTACK;
                    }
                }

                case READY_TO_ATTACK -> {
                    if (hasLOS && dist != 0 && dist <= attackRadiusSqr) {
                        mob.performRangedAttack(target, 1.0F);

                        mob.playSound(
                                fireworks ?
                                        Ssounds.VANGUARD_FIREWORKS.get() :
                                        Ssounds.VANGUARD_SHOOT.get()
                        );

                        state = CrossbowState.UNCHARGED;
                    }
                }

            }
        }

        enum CrossbowState {
            UNCHARGED, CHARGING, CHARGED, READY_TO_ATTACK
        }
    }


    public int getVanguardRaid(){
        return entityData.get(RAID_TIME_OUT);
    }
    public void setVanguardRaid(int val){
        entityData.set(RAID_TIME_OUT,val);
    }


    private static class VanguardCallRaid extends Goal {
        private final Vanguard vanguard;
        private static final ItemStack stack = new ItemStack(Items.GOAT_HORN);

        private VanguardCallRaid(Vanguard vanguard) {
            this.vanguard = vanguard;
        }
        public boolean compareTarget(LivingEntity living){
            if (living == null){
                return false;
            }
            return SConfig.SERVER.proto_sapient_target.get().contains(living.getEncodeId()) || living.getHealth() >= 100 || living instanceof Player;
        }

        @Override
        public boolean canUse() {
            return vanguard.tickCount % 20 == 0 && vanguard.getVanguardRaid() <= 0 && compareTarget(vanguard.getTarget());
        }

        @Override
        public void start() {
            super.start();
            this.vanguard.setItemSlot(EquipmentSlot.OFFHAND,stack);
            this.vanguard.callReinforcements();
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }


        @Override
        public void stop() {
            super.stop();
            this.vanguard.setItemSlot(EquipmentSlot.OFFHAND,ItemStack.EMPTY);
        }

    }

    private void callReinforcements(){
        List<String> ids = new ArrayList<>();
        while (ids.size() < SConfig.SERVER.vanguard_raid_size.get()){
            for (String s : SConfig.SERVER.vanguard_members.get()){
                String[] str = s.split("\\|");
                if (Math.random() < (Integer.parseUnsignedInt(str[1])/100f)){
                    ids.add(str[0]);
                    break;
                }
            }
        }

        for (String id : ids){
            Vec3 vec3 = Utilities.generatePositionAway(this.position(),15);
            ResourceLocation entityId =new ResourceLocation(id);
            EntityType<?> entityType = ForgeRegistries.ENTITY_TYPES.getValue(entityId);
            if (entityType != null){
            Entity entity = entityType.create(this.level());
            if (entity instanceof Mob mob && this.level() instanceof ServerLevelAccessor accessor) {
                mob.randomTeleport(vec3.x, this.getY(), vec3.z,false);
                mob.finalizeSpawn(
                        accessor,
                        accessor.getCurrentDifficultyAt(BlockPos.containing(this.position())),
                        MobSpawnType.NATURAL,
                        null,null
                );
                if (mob instanceof Infected infected){
                    infected.setSearchPos(this.getOnPos());
                    infected.setFollowPartner(this);
                }
                accessor.addFreshEntity(mob);
            }}
        }
        this.playSound(Ssounds.VANGUARD_CALL.get());
        this.setVanguardRaid(6000);
    }
    private void tickMovement(ServerLevel serverLevel){
        tryTeleportIfFar(serverLevel);
        moveTowardVillage();
        if (this.distanceToSqr(Vec3.atCenterOf(new Vec3i(getVillage().getX(), (int) this.position().y(),getVillage().getZ()))) < (10 * 10)) {
            playArrivalSound();
            this.setVillage(BlockPos.ZERO);
            removeChunkLoad();
        }
    }

    private void tryTeleportIfFar(ServerLevel serverLevel) {
        if (!serverLevel.isLoaded(getVillage())) return;
        double distSqr = this.distanceToSqr(Vec3.atCenterOf(getVillage()));
        if (distSqr < (200 * 200)) return;

        BlockPos tp = findSafeGround(getVillage());

        if (tp != null) {
            this.teleportTo(tp.getX() + 0.5, tp.getY(), tp.getZ() + 0.5);
            addChunkLoad(tp,serverLevel);
        }
    }

    private void moveTowardVillage() {
        this.navigation.stop();
        Path path = this.navigation.createPath(getVillage(), 1);
        if (path != null){
            this.getNavigation().moveTo(path, 1.2);
        }
    }

    private void playArrivalSound() {
        List<Player> players = this.level().getEntitiesOfClass(
                Player.class,
                this.getBoundingBox().inflate(100)
        );

        for (Player p : players) {
            p.playNotifySound(Ssounds.VANGUARD_RAID.get(), SoundSource.MASTER, 1f, 1f);
        }
    }

    private BlockPos findSafeGround(BlockPos pos) {
        ServerLevel level = (ServerLevel) this.level();

        BlockPos.MutableBlockPos mutable = pos.mutable();

        for (int y = 0; y < 20; y++) {
            if (level.getBlockState(mutable).isAir() &&
                    level.getBlockState(mutable.below()).isSolid()) {
                return mutable.immutable();
            }
            mutable.move(Direction.UP);
        }
        return null;
    }

    private void addChunkLoad(BlockPos pos,ServerLevel serverLevel) {
        ChunkPos chunk = new ChunkPos(pos);

        String id = "vanguard_" + this.getUUID();

        ChunkLoaderHelper.addRequest(new ChunkLoadRequest(
                serverLevel.dimension(),
                new ChunkPos[]{chunk},
                0,
                id,
                this.chunkLifeTicks(),
                this.getUUID()
        ));
    }

    private void removeChunkLoad() {
        String id = "vanguard_" + this.getUUID();
        ChunkLoaderHelper.removeRequest(id);
    }
    @Override
    public boolean removeWhenFarAway(double value) {
        if (this.level() instanceof ServerLevel serverLevel){
            SporeSavedData data = SporeSavedData.getDataLocation(serverLevel);
            return data != null && data.getAmountOfHiveminds() >= SConfig.SERVER.proto_spawn_world_mod.get() && value > 256;
        }
        return false;
    }
    private void locateVillageOnSpawn(ServerLevel serverLevel) {

        List<Villager> villagers =
                serverLevel.getEntitiesOfClass(
                        Villager.class,
                        new AABB(this.blockPosition()).inflate(256)  // search 256 blocks
                );

        if (!villagers.isEmpty()) {
            Villager nearest = villagers.stream()
                    .min((a,b) -> Double.compare(this.distanceToSqr(a), this.distanceToSqr(b)))
                    .orElse(null);

            BlockPos villPos = nearest.blockPosition();
            this.setVillage(villPos);
            return;
        }
        int radius = 128;

        BlockPos foundVillage = serverLevel.findNearestMapStructure(
                StructureTags.VILLAGE,
                this.blockPosition(),
                radius,
                false
        );

        this.setVillage(Objects.requireNonNullElse(foundVillage, BlockPos.ZERO));
    }

}
