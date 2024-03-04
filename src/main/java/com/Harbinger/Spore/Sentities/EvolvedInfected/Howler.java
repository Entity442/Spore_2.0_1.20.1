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
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Random;

public class Howler extends EvolvedInfected {
    public Howler(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    private boolean scream;

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this,1.2,true));
        this.goalSelector.addGoal(2, new HowlerAttackGoal( this,1.5));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));


        super.registerGoals();
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_howler_loot.get();
    }
    @Override
    public void tick() {
        if (isAlive() && scream){
            this.playSound(Ssounds.HOWLER_GROWL.get());
            scream = false;
        }
        super.tick();
    }

    private class HowlerAttackGoal extends Goal {
        private int screamTimer = 0;
        private final double speedModifier;
        protected Mob mob;
        protected Level level;

        private HowlerAttackGoal(Mob mob , double speedModifier) {
            this.level = mob.level();
            this.mob = mob;
            this.speedModifier = speedModifier;
        }


        @Override
        public boolean canUse() {
            return this.mob.getTarget() != null;
        }

        @Override
        public void tick() {
            if (screamTimer > 0){
            --screamTimer;
            }if (this.mob.getTarget() != null) {

                double ze = mob.distanceToSqr(mob.getTarget());
                this.mob.getLookControl().setLookAt(this.mob.getTarget(), 10.0F, (float) this.mob.getMaxHeadXRot());

                if (ze > 120.0D) {
                    this.mob.getNavigation().moveTo(this.mob.getTarget(), this.speedModifier);
                } else{
                    if (checkForInfected(this.mob) && screamTimer <= 0) {
                    ScreamAOE(this.mob);
                    ScreamBuffInfected(this.mob);
                        this.screamTimer = 120;
                    }
                    if (!checkForInfected(this.mob) && screamTimer <= 0){
                        int r = random.nextInt(1, 3);
                        for (int index0 = 0; index0 < r; index0++) {
                            SummonScream(this.mob);
                        }
                        this.screamTimer = 120;
                    }
                 }
            }
        }
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


    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_GROWL.get();
    }

    protected SoundEvent getHurtSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound() {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    public void ScreamAOE(Entity entity){
            AABB boundingBox = entity.getBoundingBox().inflate(12);
            List<Entity> entities = entity.level().getEntities(entity, boundingBox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);

            for (Entity entity1 : entities) {
                if(entity1 instanceof Infected livingEntity) {
                    livingEntity.addEffect( new MobEffectInstance(Seffects.MARKER.get() ,  400, 0));

                }
                if (entity1 instanceof Player  livingEntity) {
                    livingEntity.addEffect( new MobEffectInstance(MobEffects.CONFUSION ,  100, 0));
                    livingEntity.addEffect( new MobEffectInstance(MobEffects.WEAKNESS ,  200, 0));
                }
            }
    }


    public void SummonScream(LivingEntity entity) {
        ServerLevelAccessor world = (ServerLevelAccessor) entity.level();
        Level level = entity.level();
        Random rand = new Random();
        int d = random.nextInt(0 ,2);
        int r = random.nextInt(-8, 8);
        int c = random.nextInt(-8, 8);
        List<? extends String> ev = SConfig.SERVER.howler_summon.get();

        for (int i = 0; i < 1; ++i) {
            int randomIndex = rand.nextInt(ev.size());
            ResourceLocation randomElement1 = new ResourceLocation(ev.get(randomIndex));
            EntityType<?> randomElement = ForgeRegistries.ENTITY_TYPES.getValue(randomElement1);
            Mob waveentity = (Mob) randomElement.create(level);
            waveentity.setPos(entity.getX() + r, entity.getY() + 0.5D + d, entity.getZ() + c);
            waveentity.finalizeSpawn(world, level.getCurrentDifficultyAt(new BlockPos((int) entity.getX()  ,(int) entity.getY() ,(int) entity.getZ() )), MobSpawnType.NATURAL, null,null);
            level.addFreshEntity(waveentity);
            this.scream = true;
        }
    }


    boolean checkForInfected(Entity entity){
        AABB boundingBox = entity.getBoundingBox().inflate(4);
        List<Entity> entities = entity.level().getEntities(entity, boundingBox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);

        for (Entity en : entities) {
            if (en instanceof Infected && !(SConfig.SERVER.support.get().contains(en.getEncodeId()) || en instanceof Carrier)){
                return true;
            }
        }
        return false;
    }


    public void ScreamBuffInfected(Entity entity){
        Level level = entity.level();
        AABB boundingBox = entity.getBoundingBox().inflate(6);
        List<Entity> entities = entity.level().getEntities(entity, boundingBox);
        Random rand = new Random();
        List<? extends String> buffer = SConfig.SERVER.howler_effects_buff.get();
        int j=0,k=0;
        if (isAlive()){
            if (level.getDifficulty() == Difficulty.EASY){
                k = 100;
            }else  if (level.getDifficulty() == Difficulty.NORMAL){
                k = 200;
            } else if (level.getDifficulty() == Difficulty.HARD){
                j = 1; k = 400;
            }
        }

        for (int i = 0; i < 1; ++i) {
            int randomIndex = rand.nextInt(buffer.size());
            ResourceLocation randomElement1 = new ResourceLocation(buffer.get(randomIndex));
            MobEffect randomElement = ForgeRegistries.MOB_EFFECTS.getValue(randomElement1);
            for (Entity en : entities) {
                if (en instanceof Infected buff){
                    assert randomElement != null;
                    buff.addEffect(new MobEffectInstance(randomElement , k, j));
                }
            }
        }
        this.scream = true;
    }
}
