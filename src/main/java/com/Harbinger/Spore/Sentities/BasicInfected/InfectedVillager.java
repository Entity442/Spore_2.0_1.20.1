package com.Harbinger.Spore.Sentities.BasicInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Scamper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Random;

public class InfectedVillager extends Infected {
    public InfectedVillager(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }


    @Override
    protected void registerGoals() {


        this.goalSelector.addGoal(1, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();
            }
        });

        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(3, new OpenDoorGoal(this, true) {
            @Override
            public boolean canUse() {
                return super.canUse() && SConfig.SERVER.higher_thinking.get();
            }
            @Override
            public void start() {
                this.mob.swing(InteractionHand.MAIN_HAND);
                super.start();
            }
        });
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        super.registerGoals();
    }


    protected void customServerAiStep() {
        if (!this.isNoAi() && GoalUtils.hasGroundPathNavigation(this) && SConfig.SERVER.higher_thinking.get()) {
            ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        }

        super.customServerAiStep();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.inf_vil_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.inf_vil_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.ATTACK_KNOCKBACK, 0.3);

    }
    @Override
    public void baseTick() {
        super.baseTick();

        if (entityData.get(EVOLUTION) >= (20 * SConfig.SERVER.evolution_age_human.get()) && this.entityData.get(KILLS) >= SConfig.SERVER.min_kills.get()) {
            this.entityData.set(KILLS,this.entityData.get(KILLS) - SConfig.SERVER.min_kills.get());
            Evolve(this);
        }else{
            if (!isFreazing() && this.entityData.get(KILLS) >= SConfig.SERVER.min_kills.get()) {
                this.entityData.set(EVOLUTION,entityData.get(EVOLUTION) + 1);
            }
        }
    }


    public void Evolve(LivingEntity entity) {
        if (Math.random() < 0.9) {
            Random rand = new Random();
            List<? extends String> ev = SConfig.SERVER.villager_ev.get();
            for (int i = 0; i < 1; ++i) {
                int randomIndex = rand.nextInt(ev.size());
                ResourceLocation randomElement1 = new ResourceLocation(ev.get(randomIndex));
                EntityType<?> randomElement = ForgeRegistries.ENTITY_TYPES.getValue(randomElement1);
                Entity waveentity = randomElement.create(level());
                waveentity.setPos(entity.getX(), entity.getY() + 0.5D, entity.getZ());
                waveentity.setCustomName(entity.getCustomName());
                if (waveentity instanceof Infected infected){infected.setKills(entityData.get(KILLS));}
                level().addFreshEntity(waveentity);
                if (this.level() instanceof ServerLevel serverLevel){
                    double x0 = this.getX() - (random.nextFloat() - 0.1) * 0.1D;
                    double y0 = this.getY() + (random.nextFloat() - 0.25) * 0.15D * 5;
                    double z0 = this.getZ() + (random.nextFloat() - 0.1) * 0.1D;
                    serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 2, 0, 0, 0, 1);
                }
                entity.discard();
            }
        }else {
            Scamper scamper = new Scamper(Sentities.SCAMPER.get(), level());
            scamper.setPos(entity.getX(), entity.getY() + 0.5D, entity.getZ());
            scamper.setCustomName(entity.getCustomName());
            scamper.setKills(entityData.get(KILLS));
            level().addFreshEntity(scamper);
            entity.discard();
        }
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

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

}
