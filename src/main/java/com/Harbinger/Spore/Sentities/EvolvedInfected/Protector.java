package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.ArmedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPlayer;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.ProtectorVariants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class Protector extends EvolvedInfected implements ArmedInfected,HasUsableSlot, RangedAttackMob, VariantKeeper {
    public static final EntityDataAccessor<Boolean> SHIELDED = SynchedEntityData.defineId(Protector.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> PEARLS = SynchedEntityData.defineId(Protector.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DAMAGE_POINTS = SynchedEntityData.defineId(Protector.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> RESISTANCE_POINTS = SynchedEntityData.defineId(Protector.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Protector.class, EntityDataSerializers.INT);
    public int ticksUnShielded;
    @Nullable
    private BlockPos Targetpos;
    public Protector(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(2,new SearchAroundGoal(this));
        this.goalSelector.addGoal(3, new ProtectorMeleeGoal(this, (float) (SConfig.SERVER.protector_damage.get() * SConfig.SERVER.global_damage.get())));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_protector_loot.get();
    }
    @Override
    public DamageSource getCustomDamage(LivingEntity entity) {
        if (Math.random() < 0.3){
            return SdamageTypes.knight_damage(this);
        }
        return super.getCustomDamage(entity);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.protector_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.protector_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.protector_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 48)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }
    public boolean getShielded(){return entityData.get(SHIELDED);}
    public void setShielded(boolean value){entityData.set(SHIELDED,value);}

    public int getPearls(){return entityData.get(PEARLS);}
    public void setPearls(int e){this.entityData.set(PEARLS,e);}

    public int getDamagePoints(){return entityData.get(DAMAGE_POINTS);}
    public void setDamagePoints(int e){this.entityData.set(DAMAGE_POINTS,e);}

    public int getResistancePoints(){return entityData.get(RESISTANCE_POINTS);}
    public void setResistancePoints(int e){this.entityData.set(RESISTANCE_POINTS,e);}
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHIELDED,false);
        this.entityData.define(PEARLS,1);
        entityData.define(DAMAGE_POINTS,0);
        entityData.define(RESISTANCE_POINTS,0);
        entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    @Override
    public void awardKillScore(Entity entity, int i, DamageSource damageSource) {
        super.awardKillScore(entity, i, damageSource);
        if (entity instanceof EnderMan){setPearls(getPearls()+random.nextInt(3));}
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setShielded(tag.getBoolean("shield"));
        setPearls(tag.getInt("pearls"));
        setDamagePoints(tag.getInt("damage_points"));
        setResistancePoints(tag.getInt("resistance_points"));
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("shield",getShielded());
        tag.putInt("pearls",getPearls());
        tag.putInt("damage_points",getDamagePoints());
        tag.putInt("resistance_points",getResistancePoints());
        tag.putInt("Variant", this.getTypeVariant());
    }
    protected SoundEvent getAmbientSound() {
        return Ssounds.ADVENTURER_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public void tick() {
        super.tick();
        if (ticksUnShielded > 0){
            ticksUnShielded--;
        }
        if (tickCount % 200 == 0){
            setShielded(false);
        }
        if (this.tickCount % 40 == 0){
            LivingEntity entity = this.getTarget();
            if (entity != null){
                double distance = this.distanceTo(entity);
                if (distance > 20 && this.getPearls() > 0 && this.hasLineOfSight(entity)){
                    this.performRangedAttack(entity, 0);
                }
            }
        }
        if (tickCount % 200 == 0 && this.getVariant() == ProtectorVariants.COLLECTOR){
            searchBlocks();
            spreadEffects();
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        Entity entity = source.getEntity();
        LivingEntity target = this.getTarget();
        if (entity instanceof LivingEntity livingEntity && livingEntity.equals(target)) {
            ItemStack stack = livingEntity.getMainHandItem();
            if (getShielded()) {
                if (stack.canDisableShield(stack, this, livingEntity)) {
                    this.ticksUnShielded = 200;
                    this.playSound(SoundEvents.SHIELD_BREAK);
                    setShielded(false);
                }
            }
            if (getShielded()) {
                if (isLookingAtMe(livingEntity)){
                    if (getVariant() == ProtectorVariants.STUBBED && !source.is(DamageTypes.THORNS) && livingEntity.distanceToSqr(this)<100D){
                        livingEntity.hurt(level().damageSources().thorns(this),amount * 0.1f);
                    }
                    if (getVariant() == ProtectorVariants.MOSS){
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,200,0));
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON,200,0));
                    }
                    this.playSound(SoundEvents.SHIELD_BLOCK);
                    return false;
                }
            }
        }else{
            if (entity != null && this.getShielded()){
                this.playSound(SoundEvents.SHIELD_BREAK);
                this.ticksUnShielded = 100;
            }
        }
        return super.hurt(source, amount);
    }

    @Override
    public void onSyncedDataUpdated(List<SynchedEntityData.DataValue<?>> values) {
        super.onSyncedDataUpdated(values);
        if (values.equals(SHIELDED)){
            AttributeInstance attributes = this.getAttribute(Attributes.MOVEMENT_SPEED);
            if (attributes != null){
                attributes.setBaseValue(this.getShielded() ? 0.15 : 0.2);
            }
        }
        if (values.equals(DATA_ID_TYPE_VARIANT)){
            double prot = 1;
            double knock = 0;
            AttributeInstance protection = this.getAttribute(Attributes.ARMOR);
            AttributeInstance knockbackResistence = this.getAttribute(Attributes.KNOCKBACK_RESISTANCE);
            if (getVariant() == ProtectorVariants.BULK){
                prot = 1.3;
                knock = 1;
            }
            if (protection != null && knockbackResistence != null) {
                protection.setBaseValue(SConfig.SERVER.protector_armor.get() * prot);
                knockbackResistence.setBaseValue(knock);
            }
            this.refreshDimensions();
        }
    }
    boolean isLookingAtMe(LivingEntity entity) {
        Vec3 lookVec = entity.getViewVector(1.0F).normalize();
        Vec3 toThis = new Vec3(this.getX() - entity.getX(), this.getEyeY() - entity.getEyeY(), this.getZ() - entity.getZ()).normalize();
        double dot = lookVec.dot(toThis);

        double angleThreshold = 0.9;

        return dot > angleThreshold && entity.hasLineOfSight(this);
    }
    @Override
    public boolean hasUsableSlot(EquipmentSlot slot) {
        return slot == EquipmentSlot.FEET || slot == EquipmentSlot.HEAD;
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
        InfectedPlayer.createName(this,SConfig.DATAGEN.name.get());
        InfectedPlayer.createItems(this,EquipmentSlot.HEAD,SConfig.DATAGEN.player_h.get());
        InfectedPlayer.createItems(this,EquipmentSlot.FEET,SConfig.DATAGEN.player_b.get());
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance instance, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        this.populateDefaultEquipmentSlots(this.random, instance);
        setVariant(Util.getRandom(ProtectorVariants.values(), random));
        return super.finalizeSpawn(serverLevelAccessor, instance, p_21436_, p_21437_, p_21438_);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        float val = getVariant() == ProtectorVariants.BULK ? 1.2f : 1;
        return super.getDimensions(pose).scale(val);
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        SporeSavedData.removeProtector(this);
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        if (!this.level().isClientSide) {
            ThrownEnderpearl pearl = new ThrownEnderpearl(this.level(), this);
            double d0 = livingEntity.getEyeY() - this.getEyeY();
            double d1 = livingEntity.getX() - this.getX();
            double d2 = d0;
            double d3 = livingEntity.getZ() - this.getZ();
            double d4 = Math.sqrt(d1 * d1 + d3 * d3) * 0.2;
            pearl.setOwner(this);
            pearl.shoot(d1, d2 + d4, d3, 1.6F, 12.0F);
            this.playSound(SoundEvents.ENDER_PEARL_THROW, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            this.level().addFreshEntity(pearl);
            setPearls(getPearls() - 1);
        }
    }

    public ProtectorVariants getVariant() {
        return ProtectorVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void setVariant(int i) {
        this.entityData.set(DATA_ID_TYPE_VARIANT,
                (i >= 0 && i < ProtectorVariants.values().length) ? i : 0);
    }

    @Override
    public int amountOfMutations() {
        return ProtectorVariants.values().length;
    }

    private void setVariant(ProtectorVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    @Override
    public String getMutation() {
        return getTypeVariant() != 0 ? this.getVariant().getName() : super.getMutation();
    }

    public static class ProtectorMeleeGoal extends CustomMeleeAttackGoal{
        private final float meleeDamage;
        public ProtectorMeleeGoal(Protector mob, float meleeDamage) {
            super(mob, 1.2, false);
            this.meleeDamage = meleeDamage;
        }
        @Override
        protected double getAttackReachSqr(LivingEntity entity) {
            return 4.0 + entity.getBbWidth() * entity.getBbWidth();}


        @Override
        protected void checkAndPerformAttack(LivingEntity entity, double at) {
            if (mob instanceof Protector protector){
                double distance = protector.distanceTo(entity);
                protector.setShielded(distance < 15d && protector.ticksUnShielded <= 0);
                if (protector.getShielded() && entity.getHealth() > meleeDamage){
                    double d0 = this.getAttackReachSqr(entity);
                    if (at <= d0 && this.ticksUntilNextAttack <= 0 && protector.hasLineOfSight(entity)) {
                        this.resetAttackCooldown(20);
                        mob.playSound(SoundEvents.SHIELD_BLOCK);
                        this.mob.swing(InteractionHand.MAIN_HAND);
                        entity.hurtMarked = true;
                        if (entity instanceof Mob mob1){
                            mob1.setTarget(mob);
                        }
                        boolean stud = protector.getVariant() == ProtectorVariants.STUBBED;
                        entity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),100,0));
                        entity.knockback(stud ? 2.4 : 1.2F, Mth.sin(mob.getYRot() * ((float) Math.PI / 180F)), (-Mth.cos(mob.getYRot() * ((float) Math.PI / 180F))));
                        if (stud){
                            protector.doHurtTarget(entity);
                            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,100,1));
                        } }
                }else {
                    super.checkAndPerformAttack(entity, at);
                }
            }
        }
    }

    @Nullable
    public BlockPos getTargetPos() {
        return Targetpos;
    }
    public void setTargetPos(@Nullable BlockPos pos) {
        this.Targetpos = pos;
    }
    public boolean hasLineOfSightBlocks(BlockPos pos) {
        BlockHitResult raytraceresult = this.level().clip(new ClipContext(this.getEyePosition(1.0F), new Vec3(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        BlockPos position = raytraceresult.getBlockPos();
        return pos.equals(position) || this.level().isEmptyBlock(pos) || this.level().getBlockEntity(pos) == this.level().getBlockEntity(position);
    }
    public void searchBlocks(){
        AABB aabb = this.getBoundingBox().inflate(32,4,32);
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockEntity block = level().getBlockEntity(blockpos);
            if (block instanceof Container container && items(container)){
                if (hasLineOfSightBlocks(blockpos) && this.random.nextFloat() < 0.5f){
                    setTargetPos(blockpos);
                    break;
                }
            }
        }
    }

    private boolean items(Container container){
        for (int i = 0; i<container.getContainerSize(); i++){
            ItemStack stack = container.getItem(i);
            Item item = stack.getItem();
            if (item.getFoodProperties(stack,this) != null){
                return true;
            }
            if (item instanceof TieredItem){
                return true;
            }
            if (item instanceof ArmorItem){
                return true;
            }
        }
        return false;
    }


    public static class SearchAroundGoal extends Goal {
        private final Protector protector;
        public int tryTicks;

        public SearchAroundGoal(Protector protector){
            this.protector = protector;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if (protector.getVariant() != ProtectorVariants.COLLECTOR){
                return false;
            }
            return protector.getTargetPos() != null && this.protector.getTarget() == null;
        }

        protected void moveToBlock(BlockPos pos){
            if (pos != null)
                protector.navigation.moveTo(pos.getX()+0.5D,pos.getY()+1D,pos.getZ()+0.5D,1);
        }
        @Override
        public void start() {
            this.moveToBlock(protector.getTargetPos());
            this.tryTicks = 0;
            super.start();
        }


        @Override
        public boolean canContinueToUse() {
            return protector.getTarget() == null;
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
            BlockPos pos = protector.getTargetPos();
            if (pos != null && shouldRecalculatePath()){
                moveToBlock(pos);
            }
            if (pos != null && pos.closerToCenterThan(this.protector.position(),3.5f)){
                protector.interactWithBlock(pos);
                openChest(pos);
                protector.setTargetPos((BlockPos) null);
                protector.searchBlocks();
            }
        }
        public void openChest(BlockPos pos) {
            BlockEntity entity = this.protector.level().getBlockEntity(pos);
            if (entity instanceof ChestBlockEntity chestBlock) {
                this.protector.playSound(SoundEvents.CHEST_OPEN);
                this.protector.level().blockEvent(pos, chestBlock.getBlockState().getBlock(), 1, 1);
                this.protector.level().updateNeighborsAt(pos, chestBlock.getBlockState().getBlock());
                this.protector.level().updateNeighborsAt(pos.below(), chestBlock.getBlockState().getBlock());
            }
        }
    }

    public void interactWithBlock(BlockPos pos){
        if (level().getBlockEntity(pos) instanceof Container container && items(container)){
            int food = 0;
            int damage = 0;
            int armor = 0;
            for (int i = 0; i < container.getContainerSize();i++){
                ItemStack stack = container.getItem(i);
                FoodProperties properties = stack.getFoodProperties(this);
                Item item = stack.getItem();
                if (properties != null){
                    int foodCalculation = 0;
                    for (int e = 0; e<stack.getCount();e++){
                        foodCalculation =  (int) (properties.getNutrition() + (properties.getSaturationModifier() * 10));
                    }
                    food = foodCalculation;
                    stack.shrink(stack.getCount());
                }
                if (item instanceof TieredItem tieredItem){
                    damage = (int) tieredItem.getTier().getAttackDamageBonus();
                    stack.shrink(1);
                }
                if (item instanceof ArmorItem tieredItem){
                    armor = tieredItem.getDefense();
                    stack.shrink(1);
                }
            }
            setKills(getKills()+(food/5));
            setDamagePoints(getDamagePoints() + damage);
            setResistancePoints(getResistancePoints() + armor);
        }
    }
    public void spreadEffects(){
        AABB aabb = this.getBoundingBox().inflate(16);
        List<Entity> entities = level().getEntities(this,aabb);
        for (Entity entity : entities){
            if (entity instanceof Infected infected){
                if (!infected.hasEffect(MobEffects.DAMAGE_RESISTANCE) && getResistancePoints() > 0){
                    infected.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,36000,0));
                    setResistancePoints(getResistancePoints()-1);
                }
                if (!infected.hasEffect(MobEffects.DAMAGE_BOOST) && getDamagePoints() > 0){
                    infected.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,36000,0));
                    setDamagePoints(getDamagePoints()-1);
                }
            }
        }
    }
}
