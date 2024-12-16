package com.Harbinger.Spore.Sentities.BasicInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.ArmedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Scamper;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class InfectedPlayer extends Infected implements RangedAttackMob , ArmedInfected, EvolvingInfected {

    public InfectedPlayer(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }


    @Override
    protected void customServerAiStep() {
        this.setSprinting(isAggressive());
        if (!this.isNoAi() && GoalUtils.hasGroundPathNavigation(this)) {
            ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        }
        super.customServerAiStep();
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_player_loot.get();
    }
    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(3, new RangedBowAttackGoal<InfectedPlayer>(this,1.0D, 20, 15.0F){
            @Override
            public boolean canUse() {
                return super.canUse() && InfectedPlayer.this.getTarget() != null && InfectedPlayer.this.distanceToSqr(InfectedPlayer.this.getTarget()) > 20;
            }
        });
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this,0.3F));
        this.goalSelector.addGoal(4, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();
            }
        });

        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new OpenDoorGoal(this, true) {
            @Override
            public void start() {
                this.mob.swing(InteractionHand.MAIN_HAND);
                super.start();
            }
        });
        super.registerGoals();
    }

    @Override
    public DamageSource getCustomDamage(LivingEntity entity) {
        return super.getCustomDamage(entity);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33282_, DifficultyInstance p_33283_, MobSpawnType p_33284_, @Nullable SpawnGroupData p_33285_, @Nullable CompoundTag p_33286_) {
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        RandomSource randomsource = p_33282_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_33283_);
        this.populateDefaultEquipmentEnchantments(randomsource, p_33283_);
        return super.finalizeSpawn(p_33282_, p_33283_, p_33284_, p_33285_, p_33286_);
    }

    public static void createItems(LivingEntity living,EquipmentSlot slot,List<? extends String> list){
        if (living.getItemBySlot(slot) != ItemStack.EMPTY){
            return;
        }
        ItemStack stack = ItemStack.EMPTY;
        for (String str : list){
            String[] string = str.split("\\|" );
            ItemStack itemStack = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(string[0]))));
            if (Math.random() < Integer.parseUnsignedInt(string[1]) / 100F) {
                stack = itemStack;
            }
        }
        living.setItemSlot(slot, stack);
    }
    public static void createName(LivingEntity living,List<? extends String> list){
        if (living.getCustomName() != null){
            return;
        }
        for (int i = 0; i < 1; ++i) {
            int randomIndex = living.getRandom().nextInt(list.size());
            Component component = Component.nullToEmpty(list.get(randomIndex));
            living.setCustomName(component);
        }
    }


    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
        InfectedPlayer.createName(this,SConfig.DATAGEN.name.get());
        InfectedPlayer.createItems(this,EquipmentSlot.HEAD,SConfig.DATAGEN.player_h.get());
        InfectedPlayer.createItems(this,EquipmentSlot.CHEST,SConfig.DATAGEN.player_c.get());
        InfectedPlayer.createItems(this,EquipmentSlot.LEGS,SConfig.DATAGEN.player_l.get());
        InfectedPlayer.createItems(this,EquipmentSlot.FEET,SConfig.DATAGEN.player_b.get());
        InfectedPlayer.createItems(this,EquipmentSlot.MAINHAND,SConfig.DATAGEN.player_hm.get());
        InfectedPlayer.createItems(this,EquipmentSlot.OFFHAND,SConfig.DATAGEN.player_ho.get());
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.player_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.15)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.player_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.player_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 0.2);

    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_GROWL.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float value) {
        ItemStack itemstack = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.world.item.BowItem)));
        AbstractArrow abstractarrow = this.getArrow(itemstack, value);
        if (this.getMainHandItem().getItem() instanceof net.minecraft.world.item.BowItem)
            abstractarrow = ((net.minecraft.world.item.BowItem)this.getMainHandItem().getItem()).customArrow(abstractarrow);
        double d0 = entity.getX() - this.getX();
        double d1 = entity.getY(0.3333333333333333D) - abstractarrow.getY();
        double d2 = entity.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        if(abstractarrow instanceof Arrow arrow){
            arrow.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 600));
        }
        abstractarrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
        this.playSound(SoundEvents.CROSSBOW_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(abstractarrow);
    }

    protected AbstractArrow getArrow(ItemStack p_32156_, float p_32157_) {
        return ProjectileUtil.getMobArrow(this, p_32156_, p_32157_);
    }

    @Override
    public void tick() {
        super.tick();
        tickEvolution(this,SConfig.SERVER.player_ev.get());
    }

    @Override
    public void Evolve(Infected livingEntity, List<? extends String> value) {
        if (livingEntity != null && value != null && livingEntity.level() instanceof ServerLevel world){
            Level level = livingEntity.level();
            RandomSource random = RandomSource.create();
            if (Math.random() < 0.9) {
                Random rand = new Random();
                for (int i = 0; i < 1; ++i) {
                    int randomIndex = rand.nextInt(value.size());
                    ResourceLocation randomElement1 = new ResourceLocation(value.get(randomIndex));
                    EntityType<?> randomElement = ForgeRegistries.ENTITY_TYPES.getValue(randomElement1);
                    Entity waveentity = randomElement.create(level);
                    waveentity.setPos(livingEntity.getX(), livingEntity.getY() + 0.5D, livingEntity.getZ());
                    waveentity.setCustomName(livingEntity.getCustomName());
                    if (waveentity instanceof LivingEntity entity){
                        Collection<MobEffectInstance> collection = livingEntity.getActiveEffects();
                        for(MobEffectInstance mobeffectinstance : collection) {
                            entity.addEffect(new MobEffectInstance(mobeffectinstance));
                        }
                    }
                    if (waveentity instanceof Infected infected){
                        infected.setKills(livingEntity.getKills());
                        infected.setEvoPoints(livingEntity.getEvoPoints());
                        infected.setSearchPos(livingEntity.getSearchPos());
                        infected.setLinked(livingEntity.getLinked());
                        for(EquipmentSlot slot : EquipmentSlot.values()){
                            infected.setItemSlot(slot,this.getItemBySlot(slot));
                        }
                    }
                    level.addFreshEntity(waveentity);

                    livingEntity.discard();
                }
            }else {
                Scamper scamper = new Scamper(Sentities.SCAMPER.get(), level);
                scamper.setPos(livingEntity.getX(), livingEntity.getY() + 0.5D, livingEntity.getZ());
                scamper.setCustomName(livingEntity.getCustomName());
                scamper.setKills(livingEntity.getKills());
                scamper.setEvoPoints(livingEntity.getEvoPoints());
                scamper.setLinked(livingEntity.getLinked());
                scamper.setSearchPos(livingEntity.getSearchPos());
                Collection<MobEffectInstance> collection = livingEntity.getActiveEffects();
                for(MobEffectInstance mobeffectinstance : collection) {
                    scamper.addEffect(new MobEffectInstance(mobeffectinstance));
                }
                level.addFreshEntity(scamper);
                livingEntity.discard();
            }
            if (level instanceof ServerLevel serverLevel){
                double x0 = livingEntity.getX() - (random.nextFloat() - 0.1) * 0.1D;
                double y0 = livingEntity.getY() + (random.nextFloat() - 0.25) * 0.15D * 5;
                double z0 = livingEntity.getZ() + (random.nextFloat() - 0.1) * 0.1D;
                serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 2, 0, 0, 0, 1);
            }
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        Item item = Items.FLINT_AND_STEEL;
        if (getMainHandItem().getItem() == item || getOffhandItem().getItem() == item){
            entity.setSecondsOnFire(10);
        }
        return super.doHurtTarget(entity);
    }
}
