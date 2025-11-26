package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.ArmedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.Utility.Illusion;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.DelusionerVariants;
import net.minecraft.Util;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Delusionare extends Organoid implements VariantKeeper {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Delusionare.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SPELL_TIME = SynchedEntityData.defineId(Delusionare.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SPELL_ID = SynchedEntityData.defineId(Delusionare.class, EntityDataSerializers.INT);
    private static final List<Enchantment> protectionEnchants = List.of(Enchantments.ALL_DAMAGE_PROTECTION,Enchantments.PROJECTILE_PROTECTION,Enchantments.BLAST_PROTECTION,Enchantments.FIRE_PROTECTION);
    private static final List<Enchantment> speed = List.of(Enchantments.FROST_WALKER,Enchantments.FALL_PROTECTION,Enchantments.DEPTH_STRIDER);
    public Delusionare(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    @Override
    public int getEmerge_tick() {
        return 100;
    }

    @Override
    public int getBorrow_tick() {
        return 100;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("spell_timer",entityData.get(SPELL_TIME));
        tag.putInt("spell_id",entityData.get(SPELL_ID));
        tag.putInt("Variant",this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(SPELL_TIME, tag.getInt("spell_timer"));
        entityData.set(SPELL_ID, tag.getInt("spell_id"));
        entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SPELL_TIME,0);
        this.entityData.define(SPELL_ID,0);
        this.entityData.define(DATA_ID_TYPE_VARIANT,0);
    }
    public int getSpellById(){
        return entityData.get(SPELL_ID);
    }

    public boolean isCasting(){
        return this.entityData.get(SPELL_TIME)>0;
    }

    public void setSpellTime(int value){
        this.entityData.set(SPELL_TIME,value);
    }
    public void setSpellId(int value){
        this.entityData.set(SPELL_ID,value);
    }

    protected void tickSpell(){
        this.entityData.set(SPELL_TIME,this.entityData.get(SPELL_TIME)+1);
        if (entityData.get(SPELL_TIME) == 40){
            this.playSound(Ssounds.DELUSIONER_CASTING.get());
        }
        if (entityData.get(SPELL_TIME) > 80){
            this.castSpell(this.getSpellById());
            this.entityData.set(SPELL_TIME,0);
        }
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.delusioner_loot.get();
    }

    @Override
    public void tick() {
        super.tick();
        if (entityData.get(SPELL_TIME)>0){
            this.tickSpell();
        }
        if (tickCount % 1200 == 0 && this.getTarget() == null){
            tickBurrowing();
        }
    }

    @Override
    public void tickBurrowing(){
        int burrowing = this.entityData.get(BORROW);
        if (burrowing > this.getBorrow_tick()) {
            this.discard();
            burrowing = -1;
        }
        this.entityData.set(BORROW, burrowing + 1);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.delusioner_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.delusioner_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addTargettingGoals();
        this.goalSelector.addGoal(4,new CastMagicGoal(this));
    }

    public static class CastMagicGoal extends Goal{
        Delusionare delusionare;
        public CastMagicGoal(Delusionare delusionare){
            this.delusionare = delusionare;
        }
        @Override
        public boolean canUse() {
            if (delusionare.isCasting()){
                return false;
            }
            return delusionare.getTarget() != null;
        }

        private boolean hasAlliesAround(){
            AABB aabb = delusionare.getBoundingBox().inflate(8);
            List<Entity> possible_allies = delusionare.level().getEntities(delusionare,aabb);
            List<Infected> allies = new ArrayList<>();
            for (Entity entity : possible_allies){
                if (entity instanceof Infected infected){
                    allies.add(infected);
                }
            }
            return allies.size() > 2;
        }
        private boolean isFar(){
            LivingEntity entity = this.delusionare.getTarget();
            if (entity == null){
                return false;
            }
            return delusionare.distanceToSqr(entity) > 140;
        }

        @Override
        public void start() {
            super.start();
            if (hasAlliesAround() && isFar()){
                this.delusionare.setSpellId(3);
            }
            if (hasAlliesAround() && !isFar()){
                this.delusionare.setSpellId(2);
            }
            if (!hasAlliesAround() && isFar()){
                this.delusionare.setSpellId(1);
            }
            if (!hasAlliesAround() && !isFar()){
                this.delusionare.setSpellId(0);
            }
            this.delusionare.setSpellTime(1);
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.DELUSIONER_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    public void castSpell(int value){
        LivingEntity entity = this.getTarget();
        if (entity == null){
            return;
        }
        if (this.getVariant() == DelusionerVariants.DEFAULT){
        if (value == Spells.SUMMON_ILLUSION.getId()){
            for (int i = 0;i<this.random.nextInt(2,5);i++){
                Illusion illusion = new Illusion(Sentities.ILLUSION.get(),this.level());
                illusion.setSeeAble(true);
                illusion.moveTo(this.getX(),this.getY(),this.getZ());
                if (level() instanceof ServerLevel serverLevel)
                    illusion.finalizeSpawn(serverLevel,serverLevel.getCurrentDifficultyAt(this.getOnPos()), MobSpawnType.MOB_SUMMONED,null,null);
                illusion.setTarget(entity);
                level().addFreshEntity(illusion);
            }
        }
        if (value == Spells.CAST_ARROWS.getId() && hasLineOfSight(entity)){
            for (int i = 0;i<this.random.nextInt(3,7);i++){
                int randomX = this.random.nextInt(-4,4);
                int randomZ =this.random.nextInt(-4,4);
                Arrow arrow = new Arrow(EntityType.ARROW,this.level());
                arrow.moveTo(entity.getX() + randomX,entity.getY()+3,entity.getZ()+randomZ);
                arrow.setOwner(this);
                if (Math.random() < 0.3){
                    arrow.setSecondsOnFire(4);
                }
                double d0 = entity.getX() - arrow.getX();
                double d1 = entity.getY(0.3333333333333333D) - arrow.getY();
                double d2 = entity.getZ() - arrow.getZ();
                double d3 = Math.sqrt(d0 * d0 + d2 * d2);
                arrow.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 600));
                arrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
                level().addFreshEntity(arrow);
            }
        }
        if (value == Spells.CAST_INVISIBILITY.getId()){
            AABB aabb = this.getBoundingBox().inflate(32);
            List<Entity> entities =  this.level().getEntities(this,aabb);
            for (Entity entity1 : entities){
                if (entity1 instanceof Infected infected){
                    infected.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,600));
                }
            }
        }
        if (value == Spells.CAST_TELEPORTATION.getId()){
            AABB aabb = this.getBoundingBox().inflate(32);
            List<Entity> entities =  this.level().getEntities(this,aabb);
            for (Entity entity1 : entities){
                double randomX = entity.getX() + this.random.nextInt(-4,4);
                double randomZ = entity.getZ() + this.random.nextInt(-4,4);
                if (entity1 instanceof Infected infected){
                    infected.randomTeleport(randomX, entity.getY(),randomZ,true);
                    infected.playSound(SoundEvents.ENDERMAN_TELEPORT);
                }
            }
        }
        }else {
        if (value == Spells.CAST_FIREBALL.getId()) {
            int amount = random.nextInt(1, 4);
            for (int i = 0; i < amount; i++) {
                Vec3 look = this.getLookAngle();
                Vec3 spawnPos = this.position()
                        .add(look.scale(0.5))
                        .add(0, 1.2, 0);
                SmallFireball fireball = new SmallFireball(
                        level(),
                        this,
                        0, 0, 0
                );
                fireball.setPos(spawnPos.x, spawnPos.y, spawnPos.z);
                double dx = entity.getX() - spawnPos.x;
                double dy = entity.getY(0.33D) - spawnPos.y;
                double dz = entity.getZ() - spawnPos.z;
                float accuracy = (float)(14 - level().getDifficulty().getId() * 4);
                dx += random.nextGaussian() * 0.15;
                dy += random.nextGaussian() * 0.15;
                dz += random.nextGaussian() * 0.15;
                fireball.shoot(dx, dy, dz, 1.6F, accuracy);
                level().addFreshEntity(fireball);
            }
        }
        if (value == Spells.CAST_LIGHTING.getId()){
            if (!hasLineOfSight(entity)){
                return;
            }
            LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT,level());
            AABB aabb = entity.getBoundingBox().inflate(8);
            List<Entity> entities = level().getEntities(entity,aabb,e -> {return e instanceof PowerableMob powerableMob && !powerableMob.isPowered();});
            if (entities.isEmpty()){
                double randomX = (this.random.nextDouble() - this.random.nextDouble()) * 4;
                double randomZ = (this.random.nextDouble() - this.random.nextDouble()) * 4;
                Vec3 vec3 = entity.position().add(randomX,0,randomZ);
                bolt.moveTo(vec3);
            }else {
                Entity powerMob = entities.get(random.nextInt(entities.size()));
                bolt.moveTo(powerMob.position());
            }
            level().addFreshEntity(bolt);
        }
        if (value == Spells.CAST_PROTECTION.getId()){
            AABB aabb = this.getBoundingBox().inflate(8);
            List<Entity> entities = level().getEntities(this,aabb);
            for (Entity mob : entities){
                if (mob instanceof LivingEntity living  && living instanceof Infected){
                    if (living instanceof ArmedInfected){
                        for (EquipmentSlot slot : EquipmentSlot.values()){
                            Enchantment enchantment = protectionEnchants.get(random.nextInt(protectionEnchants.size()));
                            ItemStack stack = living.getItemBySlot(slot);
                            if (stack.getItem() instanceof ArmorItem){
                                Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(stack);
                                enchants.put(enchantment, enchantment.getMaxLevel());
                                EnchantmentHelper.setEnchantments(enchants, stack);
                            }
                        }
                    }else {
                        living.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,12000,random.nextInt(0,2),false,false,false));
                    }
                }
            }
        }
        if (value == Spells.CAST_ENDURANCE.getId()){
            AABB aabb = this.getBoundingBox().inflate(8);
            List<Entity> entities = level().getEntities(this,aabb);
            for (Entity mob : entities){
                if (mob instanceof LivingEntity living && living instanceof Infected){
                    if (living instanceof ArmedInfected){
                        Enchantment enchantment = speed.get(random.nextInt(speed.size()));
                        ItemStack stack = living.getItemBySlot(EquipmentSlot.FEET);
                        if (stack.getItem() instanceof ArmorItem){
                            Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(stack);
                            enchants.put(enchantment, enchantment.getMaxLevel());
                            EnchantmentHelper.setEnchantments(enchants, stack);
                        }
                    }else {
                        living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,6000,random.nextInt(0,3),false,false,false));
                    }
                }
            }
        }
        }
        awardHivemind();
    }

    public enum Spells{
        SUMMON_ILLUSION(0),
        CAST_ARROWS(1),
        CAST_INVISIBILITY(2),
        CAST_TELEPORTATION(3),
        CAST_FIREBALL(0),
        CAST_LIGHTING(1),
        CAST_PROTECTION(2),
        CAST_ENDURANCE(3);
        private final int id;
        Spells(int id) {
            this.id = id;
        }
        public int getId(){
            return id;
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide && this.isCasting()) {
            for(int i = 0; i < 2; ++i) {
                this.level().addParticle(ParticleTypes.ENCHANT, this.getRandomX(0.5D), this.getRandomY() - 0.25D, this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
            }
        }
    }
    @Override
    public boolean hurt(DamageSource p_21016_, float p_21017_) {
        if (this.isEmerging()){
            return false;
        }
        return super.hurt(p_21016_, p_21017_);
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33282_, DifficultyInstance p_33283_, MobSpawnType p_33284_, @Nullable SpawnGroupData p_33285_, @Nullable CompoundTag p_33286_) {
        DelusionerVariants variant = Util.getRandom(DelusionerVariants.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_33282_, p_33283_, p_33284_, p_33285_, p_33286_);
    }

    public DelusionerVariants getVariant() {
        return DelusionerVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
    @Override
    public void setVariant(int i) {
        this.entityData.set(DATA_ID_TYPE_VARIANT,i > DelusionerVariants.values().length || i < 0 ? 0 : i);
    }

    @Override
    public int amountOfMutations() {
        return DelusionerVariants.values().length;
    }

    private void setVariant(DelusionerVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public String getMutation() {
        if (getTypeVariant() != 0){
            return this.getVariant().getName();
        }
        return super.getMutation();
    }
}
