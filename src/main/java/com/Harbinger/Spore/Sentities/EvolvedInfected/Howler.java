package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.ArmorPersentageBypass;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.Carrier;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.HowlerVariants;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class Howler extends EvolvedInfected implements VariantKeeper, ArmorPersentageBypass {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Spitter.class, EntityDataSerializers.INT);
    private static final List<String> sculkSummon = List.of("sculkhorde:sculk_mite", "sculkhorde:sculk_mite_aggressor");
    public Howler(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(2, new HowlerAttackGoal(this, 1.5));
        this.goalSelector.addGoal(3,new BansheeMeleeGoal(this,this.random));
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.2, true){
            @Override
            public boolean canUse() {
                return super.canUse() && getVariant() == HowlerVariants.DEFAULT;
            }
        });
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.how_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.15)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.how_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.how_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 24)
                .add(Attributes.ATTACK_KNOCKBACK, 3);
    }

    @Override protected SoundEvent getAmbientSound() { return Ssounds.INF_PILLAGER_AMBIENT.get(); }
    @Override protected SoundEvent getDeathSound() { return Ssounds.INF_DAMAGE.get(); }
    protected SoundEvent getStepSound() { return SoundEvents.ZOMBIE_STEP; }
    @Override
    protected void playStepSound(BlockPos p_20135_, BlockState p_20136_) {
        this.playSound(getStepSound(), 0.15F, 1.0F);
    }
    public HowlerVariants getVariant() {
        return HowlerVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
    @Override
    public void setVariant(int i) {
        if (i > HowlerVariants.values().length || i < 0){
            this.entityData.set(DATA_ID_TYPE_VARIANT, 0);
        }else {
            this.entityData.set(DATA_ID_TYPE_VARIANT, i);
        }
    }

    @Override
    public int amountOfMutations() {
        return HowlerVariants.values().length;
    }

    private void setVariant(HowlerVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public String getMutation() {
        if (getTypeVariant() != 0){
            return this.getVariant().getName();
        }
        return super.getMutation();
    }
    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_howler_loot.get();
    }

    public void ScreamAOE(Entity origin) {
        AABB area = origin.getBoundingBox().inflate(12);
        List<Entity> targets = origin.level().getEntities(origin, area, EntitySelector.NO_CREATIVE_OR_SPECTATOR);

        for (Entity target : targets) {
            if (target instanceof Infected infected) {
                infected.addEffect(new MobEffectInstance(Seffects.MARKER.get(), 400, 0));
            } else if (target instanceof Player player) {
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0));
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 0));
            }
        }
    }

    public void ScreamBuffInfected(Entity origin) {
        AABB area = origin.getBoundingBox().inflate(6);
        List<Entity> allies = origin.level().getEntities(origin, area);

        int duration = switch (origin.level().getDifficulty()) {
            case EASY -> 100;
            case NORMAL -> 200;
            case HARD -> 400;
            default -> 0;
        };
        int amplifier = origin.level().getDifficulty() == Difficulty.HARD ? 1 : 0;

        List<? extends String> buffs = SConfig.SERVER.howler_effects_buff.get();
        String randomBuff = buffs.get(random.nextInt(buffs.size()));
        MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(randomBuff));

        if (effect != null) {
            for (Entity ally : allies) {
                if (ally instanceof Infected infected) {
                    infected.addEffect(new MobEffectInstance(effect, duration, amplifier));
                }
            }
        }

        this.playSound(Ssounds.HOWLER_GROWL.get());
    }
    public void SummonScream(LivingEntity caster,boolean isSkulk) {
        ServerLevelAccessor levelAccessor = (ServerLevelAccessor) caster.level();
        Level level = caster.level();

        int dx = random.nextInt(-8, 9);
        int dz = random.nextInt(-8, 9);
        int dy = random.nextInt(0, 2);
        List<? extends String> summonPool = isSkulk && ModList.get().isLoaded("sculkhorde") ? sculkSummon : SConfig.SERVER.howler_summon.get();
        String chosen = summonPool.get(random.nextInt(summonPool.size()));
        ResourceLocation entityId = new ResourceLocation(chosen);

        EntityType<?> entityType = ForgeRegistries.ENTITY_TYPES.getValue(entityId);
        if (entityType != null) {
            Mob summoned = (Mob) entityType.create(level);
            if (summoned != null) {
                summoned.teleportRelative(caster.getX() + dx, caster.getY() + 0.5D + dy, caster.getZ() + dz);
                summoned.finalizeSpawn(
                        levelAccessor,
                        level.getCurrentDifficultyAt(BlockPos.containing(caster.position())),
                        MobSpawnType.NATURAL,
                        null,
                        null
                );
                level.addFreshEntity(summoned);
                this.playSound(Ssounds.HOWLER_GROWL.get());
            }
        }
    }
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }
    public boolean dampensVibrations() {
        return getVariant() == HowlerVariants.SONIC;
    }
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    public boolean checkForInfected(Entity origin) {
        AABB area = origin.getBoundingBox().inflate(4);
        List<Entity> nearby = origin.level().getEntities(origin, area, EntitySelector.NO_CREATIVE_OR_SPECTATOR);

        for (Entity entity : nearby) {
            if (entity instanceof Infected && !(SConfig.SERVER.support.get().contains(entity.getEncodeId()) || entity instanceof Carrier)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public float amountOfDamage(float value) {
        return getVariant () == HowlerVariants.BANSHEE ? (float) ((SConfig.SERVER.how_damage.get() * SConfig.SERVER.global_damage.get())/2f) : 0;
    }

    private class HowlerAttackGoal extends Goal {
        private final Howler mob;
        private final double speed;
        private int screamTimer = 0;

        private HowlerAttackGoal(Howler mob, double speedModifier) {
            this.mob = mob;
            this.speed = speedModifier;
        }

        @Override
        public boolean canUse() {
            return mob.getTarget() != null && mob.getVariant() != HowlerVariants.BANSHEE;
        }

        @Override
        public void tick() {
            if (screamTimer > 0) screamTimer--;
            LivingEntity target = mob.getTarget();
            if (target == null) return;
            boolean isSkulk = this.mob.getVariant() == HowlerVariants.SONIC && SConfig.SERVER.skulk_target.get();
            mob.getLookControl().setLookAt(target, 10.0F, mob.getMaxHeadXRot());
            double dist = mob.distanceToSqr(target);

            if (dist > 120.0D) {
                mob.getNavigation().moveTo(target, speed);
            } else if (screamTimer <= 0) {
                if (checkForInfected(mob)) {
                    ScreamAOE(mob);
                    ScreamBuffInfected(mob);
                } else {
                    int summons = random.nextInt(1, 3);
                    for (int i = 0; i < summons; i++) {
                        SummonScream(mob,isSkulk);
                    }
                }
                if (this.mob.getVariant() == HowlerVariants.SONIC){
                    shootSonicBoom(target,(float)(SConfig.SERVER.how_damage.get() * SConfig.SERVER.global_damage.get()));
                }
                screamTimer = 120;
            }
        }
        public void shootSonicBoom(LivingEntity target, float damage) {
            if (target == null || !target.isAlive()) return;
            mob.level().playSound(
                    null,
                    mob.getX(), mob.getY(), mob.getZ(),
                    SoundEvents.WARDEN_SONIC_BOOM,
                    SoundSource.HOSTILE,
                    3.0F,
                    1.0F
            );
            if (mob.level() instanceof ServerLevel serverLevel) {
                double dx = target.getX() - mob.getX();
                double dy = target.getY(0.5D) - mob.getEyeY();
                double dz = target.getZ() - mob.getZ();
                for (int i = 0; i < 10; i++) {
                    double px = mob.getX() + dx * i / 10.0D;
                    double py = mob.getEyeY() + dy * i / 10.0D;
                    double pz = mob.getZ() + dz * i / 10.0D;
                    serverLevel.sendParticles(ParticleTypes.SONIC_BOOM, px, py, pz, 1, 0, 0, 0, 0);
                }
            }
            target.hurt(mob.damageSources().mobAttack(mob), damage);
            Vec3 push = new Vec3(
                    target.getX() - mob.getX(),
                    target.getEyeY() - mob.getEyeY(),
                    target.getZ() - mob.getZ()
            ).normalize().scale(1.5D);

            target.push(push.x, push.y * 0.5D, push.z);
        }
    }

    private static class BansheeMeleeGoal extends CustomMeleeAttackGoal{
        private int timeBeforeBigScream;
        private final RandomSource randomSource;
        public BansheeMeleeGoal(PathfinderMob mob, RandomSource randomSource) {
            super(mob, 1.75f, true);
            this.randomSource = randomSource;
        }

        @Override
        public void tick() {
            super.tick();
            if (timeBeforeBigScream < 200){
                timeBeforeBigScream++;
            }else {
                callOrSummon();
                timeBeforeBigScream = 0;
                mob.playSound(Ssounds.HOWLER_GROWL.get());
            }
        }
        public void callOrSummon(){
            List<Infected> brothers = getBrothers();
            if (brothers.isEmpty() || brothers.size() < 6){
                Vec3 vec3 = Utilities.generatePositionAway(this.mob.position(), 16);
                for (int i = 0;i<randomSource.nextInt(3,10);i++){
                    summonAtDistance(vec3);
                }
            }else {
                for (Infected infected : brothers){
                    if (infected.isAlive() && infected.getTarget() == null){
                        infected.setTarget(mob.getTarget());
                    }
                }
            }
        }
        public void summonAtDistance(Vec3 vec3){
            List<? extends String> summonPool = SConfig.SERVER.howler_summon.get();
            String chosen = summonPool.get(randomSource.nextInt(summonPool.size()));
            ResourceLocation entityId = new ResourceLocation(chosen);
            EntityType<?> entityType = ForgeRegistries.ENTITY_TYPES.getValue(entityId);
            if (entityType != null) {
                Mob summoned = (Mob) entityType.create(mob.level());
                if (summoned != null && mob.level() instanceof ServerLevelAccessor accessor) {
                    summoned.teleportTo(vec3.x, mob.getY()+0.5, vec3.z);
                    summoned.finalizeSpawn(
                            accessor,
                            accessor.getCurrentDifficultyAt(BlockPos.containing(mob.position())),
                            MobSpawnType.NATURAL,
                            null,
                            null
                    );
                    summoned.setTarget(mob.getTarget());
                    accessor.addFreshEntity(summoned);
                }
            }
        }

        public List<Infected> getBrothers(){
          return mob.level().getEntitiesOfClass(Infected.class,mob.getBoundingBox().inflate(32,8,32));
        }

        @Override
        public boolean canUse() {
            return super.canUse() && mob instanceof Howler howler && howler.getVariant() == HowlerVariants.BANSHEE;
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        HowlerVariants variant = Util.getRandom(HowlerVariants.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }
}
