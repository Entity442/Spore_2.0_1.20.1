package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.HurtTargetGoal;
import com.Harbinger.Spore.Sentities.AI.HybridPathNavigation;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.WaterInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;

import java.util.*;

public class Naiad extends EvolvedInfected implements WaterInfected {
    public static final EntityDataAccessor<BlockPos> TERRITORY = SynchedEntityData.defineId(Naiad.class, EntityDataSerializers.BLOCK_POS);
    public Naiad(EntityType<? extends EvolvedInfected> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
        this.moveControl = new NaiadSwimControl(this);
        this.navigation = new HybridPathNavigation(this,this.level());
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3, new BreakBoatsGoal(this,1.2));
        this.goalSelector.addGoal(4, new CustomMeleeAttackGoal(this, 1, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 4.0 + entity.getBbWidth() * entity.getBbWidth();}});
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new FindWaterTerritoryGoal(this));
    }

    @Override
    public boolean isNoGravity() {
        return isInWater();
    }

    @Override
    protected void addTargettingGoals(){
        this.goalSelector.addGoal(2, new HurtTargetGoal(this , livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}, Infected.class).setAlertOthers(Infected.class));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> {return livingEntity instanceof Player || SConfig.SERVER.whitelist.get().contains(livingEntity.getEncodeId());}){
            @Override
            protected AABB getTargetSearchArea(double targetDistance) {
                return this.mob.getBoundingBox().inflate(targetDistance);
            }
        });
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true, livingEntity -> {return SConfig.SERVER.at_mob.get() && TARGET_SELECTOR.test(livingEntity);}){
            @Override
            protected AABB getTargetSearchArea(double targetDistance) {
                return this.mob.getBoundingBox().inflate(targetDistance);
            }
        });
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TERRITORY,BlockPos.ZERO);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("TerritoryX",entityData.get(TERRITORY).getX());
        tag.putInt("TerritoryY",entityData.get(TERRITORY).getY());
        tag.putInt("TerritoryZ",entityData.get(TERRITORY).getZ());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        int tX = tag.getInt("TerritoryX");
        int tY = tag.getInt("TerritoryY");
        int tZ = tag.getInt("TerritoryZ");
        entityData.set(TERRITORY,new BlockPos(tX,tY,tZ));
    }
    public BlockPos getTerritory(){
        return entityData.get(TERRITORY);
    }
    public void setTerritory(BlockPos pos){
        entityData.set(TERRITORY,pos);
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    public void travel(Vec3 p_32858_) {
        if (this.isEffectiveAi() && this.isInFluidType()) {
            this.moveRelative(0.1F, p_32858_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.85D));
        } else {
            super.travel(p_32858_);
        }
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.naiad_loot.get();
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
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.naiad_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.15)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.naiad_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.naiad_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity.isInFluidType()){
            if (entity instanceof LivingEntity living){
                living.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),  600, 0), this);
                living.addEffect(new MobEffectInstance(Seffects.MARKER.get(),200,1));
            }
            entity.setDeltaMovement(getDeltaMovement().add(0f,-1f,0));
        }
        return super.doHurtTarget(entity);
    }
    protected SoundEvent getAmbientSound() {
        return Ssounds.DROWNED_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.DROWNED_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }
    public static class FindWaterTerritoryGoal extends Goal {
        private final Naiad naiad;
        private BlockPos targetPos;
        public int tryTicks;

        public FindWaterTerritoryGoal(Naiad naiad) {
            this.naiad = naiad;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            BlockPos territory = naiad.getTerritory();
            return territory.equals(BlockPos.ZERO) || territory.distToCenterSqr(naiad.position()) > 400;
        }

        @Override
        public void start() {
            Level level = naiad.level();
            BlockPos currentTerritory = naiad.getTerritory();
            this.tryTicks = 0;
            if (currentTerritory.equals(BlockPos.ZERO)) {
                // Find new territory
                targetPos = findNearestWaterBiome(level, naiad.blockPosition());
                if (targetPos != null) {
                    naiad.setTerritory(targetPos);
                }
            } else {
                // Use existing territory
                targetPos = currentTerritory;
            }
            moveToBlock();
        }
        public void moveToBlock(){
            naiad.getNavigation().moveTo(targetPos.getX(), targetPos.getY(), targetPos.getZ(), 1.0);
        }

        @Override
        public void tick() {
            super.tick();
            ++this.tryTicks;
            if (naiad.isInWater()){
                Vec3 motion = naiad.getDeltaMovement();
                BlockPos pos = naiad.getTerritory();
                Vec3 target = new Vec3(
                        pos.getX() - naiad.getX(),
                        pos.getY() - naiad.getY(),
                        pos.getZ() - naiad.getZ()
                );

                if (target.lengthSqr() > 1e-7) {
                    target = target.normalize().scale(0.1).add(motion.scale(0.9));
                }
                naiad.setDeltaMovement(target);
                naiad.getLookControl().setLookAt(target.x, target.y, target.z, 30F, 30F);
            }else {
                if (this.naiad.getTerritory() != BlockPos.ZERO && shouldRecalculatePath()) {
                    this.moveToBlock();
                }
            }
        }

        @Override
        public boolean canContinueToUse() {
            return targetPos != null &&
                    targetPos.distToCenterSqr(naiad.position()) > 9;
        }
        public boolean shouldRecalculatePath() {
            return this.tryTicks % 40 == 0;
        }


        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        private BlockPos findNearestWaterBiome(Level level, BlockPos origin) {
            int range = 128;
            int step = 4;

            for (int r = 4; r <= range; r += step) {
                for (int i = 0; i < r * 2; i += step) {
                    BlockPos pos1 = origin.offset(r, 0, i - r);
                    BlockPos pos2 = origin.offset(-r, 0, i - r);
                    BlockPos pos3 = origin.offset(i - r, 0, r);
                    BlockPos pos4 = origin.offset(i - r, 0, -r);

                    BlockPos[] positions = {pos1, pos2, pos3, pos4};

                    for (BlockPos pos : positions) {
                        if (level.isLoaded(pos)) {
                            var biome = level.getBiome(pos);
                            if (biome.is(BiomeTags.IS_OCEAN) || biome.is(BiomeTags.IS_DEEP_OCEAN) || biome.is(BiomeTags.IS_RIVER)) {
                                BlockPos surfacePos = findWaterSurface(level, pos);
                                return surfacePos != null ? surfacePos : pos;
                            }
                        }
                    }
                }
            }
            return null;
        }

        private BlockPos findWaterSurface(Level level, BlockPos pos) {
            for (int y = level.getSeaLevel(); y > level.getMinBuildHeight(); y--) {
                BlockPos checkPos = new BlockPos(pos.getX(), y, pos.getZ());
                if (!level.getFluidState(checkPos).isEmpty() &&
                        level.getBlockState(checkPos.above()).isAir()) {
                    return checkPos;
                }
            }
            return null;
        }
    }
    public static class BreakBoatsGoal extends Goal {
        private final Naiad naiad;
        private Boat targetBoat;
        private int breakTime;
        private final double speedModifier;

        public BreakBoatsGoal(Naiad naiad, double speedModifier) {
            this.naiad = naiad;
            this.speedModifier = speedModifier;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            List<Boat> boats = naiad.level().getEntitiesOfClass(Boat.class,
                    naiad.getBoundingBox().inflate(16,32,16),
                    boat -> boat != null && !boat.isRemoved());

            if (boats.isEmpty()) return false;

            Boat closestBoat = null;
            double closestDistance = Double.MAX_VALUE;

            for (Boat boat : boats) {
                double distance = naiad.distanceToSqr(boat);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestBoat = boat;
                }
            }

            if (closestBoat != null) {
                this.targetBoat = closestBoat;
                return true;
            }

            return false;
        }

        @Override
        public void start() {
            this.breakTime = 0;
            if (targetBoat != null && naiad.tickCount % 20 == 0) {
                naiad.getNavigation().moveTo(targetBoat, speedModifier);
            }
        }

        @Override
        public boolean canContinueToUse() {
            return targetBoat != null &&
                    !targetBoat.isRemoved() &&
                    naiad.distanceToSqr(targetBoat) <= 256.0;
        }

        @Override
        public void tick() {
            if (targetBoat == null || targetBoat.isRemoved()) {
                return;
            }
            if (naiad.isEyeInFluidType(naiad.getEyeInFluidType())){
                Vec3 vec3 = this.naiad.getDeltaMovement();
                Vec3 vec31 = new Vec3(targetBoat.getX() - this.naiad.getX(), targetBoat.getY() - this.naiad.getY(), targetBoat.getZ() - this.naiad.getZ());
                if (vec31.lengthSqr() > 1.0E-7D) {
                    vec31 = vec31.normalize().scale(0.5D).add(vec3.scale(0.01D));
                }
                this.naiad.setDeltaMovement(vec31.x, vec31.y, vec31.z);
            }
            naiad.getLookControl().setLookAt(targetBoat, 30.0F, 30.0F);

            double distance = naiad.distanceToSqr(targetBoat);
            if (naiad.tickCount % 20 == 0){
                naiad.getNavigation().moveTo(targetBoat, speedModifier);
            }
            if (distance < 9.0) {
                naiad.getLookControl().setLookAt(targetBoat, 30.0F, 30.0F);
                breakTime++;
                if (breakTime >= 20) {
                    breakBoat();
                }
            }
        }

        @Override
        public void stop() {
            this.targetBoat = null;
            this.breakTime = 0;
            naiad.getNavigation().stop();
        }

        private void breakBoat() {
            if (targetBoat != null && !targetBoat.isRemoved()) {
                Level level = naiad.level();
                if (level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.SPLASH,
                            targetBoat.getX(), targetBoat.getY() + 0.5, targetBoat.getZ(),
                            10, 0.5, 0.5, 0.5, 0.1);

                    serverLevel.playSound(null, targetBoat.blockPosition(),
                            SoundEvents.WOOD_BREAK, SoundSource.HOSTILE, 1.0F, 1.0F);
                }

                if (!targetBoat.hasCustomName() && naiad.getRandom().nextFloat() < 0.8F) {
                    targetBoat.spawnAtLocation(new ItemStack(Items.STICK));
                }

                targetBoat.discard();

                stop();
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
    @Override
    public boolean hasLineOfSight(Entity entity) {
        if (entity instanceof LivingEntity living && living.isInWater() && living.getHealth() < living.getMaxHealth()){
            return true;
        }
        return super.hasLineOfSight(entity);
    }

    private static class NaiadSwimControl extends MoveControl {
        public NaiadSwimControl(Mob mob) {
            super(mob);
        }

        @Override
        public void tick() {
            if (!mob.isInWater()) {
                super.tick();
                return;
            }
            if (this.operation == MoveControl.Operation.MOVE_TO) {

                this.operation = MoveControl.Operation.WAIT;

                double dx = this.wantedX - mob.getX();
                double dy = this.wantedY - mob.getY();
                double dz = this.wantedZ - mob.getZ();


                // Look toward target
                float targetYaw = (float)(Mth.atan2(dz, dx) * 180F / Math.PI) - 90F;
                mob.setYRot(rotlerp(mob.getYRot(), -targetYaw, 10.0F));

                // Speed modifier
                double speed = this.speedModifier * mob.getAttributeValue(Attributes.MOVEMENT_SPEED);

                mob.setZza((float) speed);

                if (Math.abs(dy) > 1e-4) {
                    mob.setYya(dy > 0 ? (float)speed : (float)-speed);
                }
            }

        }
    }

}
