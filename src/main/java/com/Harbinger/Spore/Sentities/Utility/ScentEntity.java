package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ScentEntity extends UtilityEntity {
    private static final EntityDataAccessor<Boolean> OVERCHARGED = SynchedEntityData.defineId(ScentEntity.class, EntityDataSerializers.BOOLEAN);
    public ScentEntity(EntityType<? extends PathfinderMob> mob, Level level) {
        super(mob, level);
    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    @Override
    public void tick() {
        if (this.isAlive()){
            this.getPersistentData().putInt("dissipate", 1 + this.getPersistentData().getInt("dissipate"));
            if (this.getPersistentData().getInt("dissipate") >= SConfig.SERVER.scent_life.get()) {
                this.discard();
            }
            if (SConfig.SERVER.scent_summon.get()){
            this.getPersistentData().putInt("summon", 1 + this.getPersistentData().getInt("summon"));
            if (this.getPersistentData().getInt("summon") >= SConfig.SERVER.scent_summon_cooldown.get()) {
                if (!this.level().isClientSide && (getOvercharged() || checkForNonInfected(this))){
                this.Summon(this);}
            }}
        }
        super.tick();
    }

    boolean checkForNonInfected(Entity entity){
        AABB boundingBox = entity.getBoundingBox().inflate(16);
        List<Entity> entities = entity.level().getEntities(entity, boundingBox ,EntitySelector.NO_CREATIVE_OR_SPECTATOR);

        for (Entity en : entities) {
            if (en instanceof LivingEntity && !(SConfig.SERVER.blacklist.get().contains(en.getEncodeId()) || en instanceof Infected || en instanceof UtilityEntity)){
                return true;
            }
        }
        return false;
    }

    public boolean getOvercharged(){return entityData.get(OVERCHARGED);}
    public void setOvercharged(boolean b) {
        this.entityData.set(OVERCHARGED,b);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("overcharged",entityData.get(OVERCHARGED));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(OVERCHARGED, tag.getBoolean("overcharged"));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(OVERCHARGED, false);
    }
    @Override
    public void setNoGravity(boolean ignored) {
        super.setNoGravity(true);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH,1);
    }

    public void aiStep() {
        super.aiStep();
        if (!this.onGround()){
            this.getDeltaMovement().add(0.0,-0.01,0.0);
        }
        if (SConfig.SERVER.scent_particles.get()) {
            int i = Mth.floor(this.getX());
            int j = Mth.floor(this.getY());
            int k = Mth.floor(this.getZ());
            Level world = this.level();
            RandomSource randomSource = this.random;
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            for (int l = 0; l < 14; ++l) {
                blockpos$mutableblockpos.set(i + Mth.nextInt(randomSource, -6, 6), j + Mth.nextInt(randomSource, -6, 6), k + Mth.nextInt(randomSource, -6, 6));
                BlockState blockstate = world.getBlockState(blockpos$mutableblockpos);
                if (!blockstate.isCollisionShapeFullBlock(world, blockpos$mutableblockpos)) {
                    world.addParticle(Sparticles.SPORE_PARTICLE.get(), (double) blockpos$mutableblockpos.getX() + randomSource.nextDouble(), (double) blockpos$mutableblockpos.getY() + randomSource.nextDouble(), (double) blockpos$mutableblockpos.getZ() + randomSource.nextDouble(), 0.0D, 0.1D, 0.0D);
                    if (getOvercharged()){
                        world.addParticle(Sparticles.BLOOD_PARTICLE.get(), (double) blockpos$mutableblockpos.getX() + randomSource.nextDouble(), (double) blockpos$mutableblockpos.getY() + randomSource.nextDouble(), (double) blockpos$mutableblockpos.getZ() + randomSource.nextDouble(), 0.0D, 0.1D, 0.0D);
                    }
                }
            }
        }
    }


    @Override
    public boolean hurt(DamageSource source, float amount) {
        return false;
    }

    public void Summon(LivingEntity entity) {
        ServerLevelAccessor world = (ServerLevelAccessor) entity.level();
        Level level = entity.level();
        Random rand = new Random();
        int d = random.nextInt(0, 3);
        int r = random.nextInt(-12, 12);
        int c = random.nextInt(-12, 12);
        List<? extends String> ev = SConfig.SERVER.inf_summon.get();

        if (world.isEmptyBlock(new BlockPos((int) this.getX() + r, (int) this.getY() + d, (int) this.getZ() + c))){
            for (int i = 0; i < 1; ++i) {
                int randomIndex = rand.nextInt(ev.size());
                ResourceLocation randomElement1 = new ResourceLocation(ev.get(randomIndex));
                EntityType<?> randomElement = ForgeRegistries.ENTITY_TYPES.getValue(randomElement1);
                Mob waveentity = (Mob) randomElement.create(level);
                assert waveentity != null;
                waveentity.setPos(entity.getX() + r, entity.getY() + 0.5D + d, entity.getZ() + c);
                waveentity.finalizeSpawn(world, level.getCurrentDifficultyAt(new BlockPos((int) entity.getX(),(int)  entity.getY(),(int)  entity.getZ())), MobSpawnType.NATURAL, null, null);
                this.getPersistentData().putInt("summon", 0);
                if (this.getOvercharged()){
                    List<? extends String> buffer = SConfig.SERVER.scent_effects_buff.get();
                    if(waveentity instanceof Infected infected){
                        int k = SConfig.SERVER.scent_kills.get();
                        infected.setKills(random.nextInt(k ,k+3));
                        infected.setEvolution(SConfig.SERVER.evolution_age_human.get() * 10);
                        infected.setLinked(true);
                    }
                    for (int l = 0; l < 1; ++l) {
                        ResourceLocation randomElement2 = new ResourceLocation(buffer.get(randomIndex));
                        MobEffect randomElement3 = ForgeRegistries.MOB_EFFECTS.getValue(randomElement2);
                        assert randomElement3 != null;
                        waveentity.addEffect(new MobEffectInstance(randomElement3,3600,0));
                    }
                }
                level.addFreshEntity(waveentity);
            }
        }
    }
    public boolean addEffect(MobEffectInstance p_182397_, @Nullable Entity p_182398_) {
        return false;
    }
}