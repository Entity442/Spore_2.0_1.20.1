package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.Carrier;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class Howler extends EvolvedInfected {
    private boolean scream;

    public Howler(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(2, new HowlerAttackGoal(this, 1.5));
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.2, true));
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
    protected SoundEvent getHurtSound(DamageSource p_33034_) {return Ssounds.INF_DAMAGE.get();}
    @Override
    protected void playStepSound(BlockPos p_20135_, BlockState p_20136_) {
        this.playSound(getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public void tick() {
        if (isAlive() && scream) {
            this.playSound(Ssounds.HOWLER_GROWL.get());
            scream = false;
        }
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

        this.scream = true;
    }

    public void SummonScream(LivingEntity caster) {
        ServerLevelAccessor levelAccessor = (ServerLevelAccessor) caster.level();
        Level level = caster.level();

        int dx = random.nextInt(-8, 9);
        int dz = random.nextInt(-8, 9);
        int dy = random.nextInt(0, 2);

        List<? extends String> summonPool = SConfig.SERVER.howler_summon.get();
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
                this.scream = true;
            }
        }
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

    private class HowlerAttackGoal extends Goal {
        private final Mob mob;
        private final double speed;
        private int screamTimer = 0;

        private HowlerAttackGoal(Mob mob, double speedModifier) {
            this.mob = mob;
            this.speed = speedModifier;
        }

        @Override
        public boolean canUse() {
            return mob.getTarget() != null;
        }

        @Override
        public void tick() {
            if (screamTimer > 0) screamTimer--;

            LivingEntity target = mob.getTarget();
            if (target == null) return;

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
                        SummonScream(mob);
                    }
                }
                screamTimer = 120;
            }
        }
    }
}
