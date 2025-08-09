package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SAttributes;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.*;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.BaseEntities.HohlMultipart;
import com.Harbinger.Spore.Sentities.MovementControls.UndergroundMovementControl;
import com.Harbinger.Spore.Sentities.MovementControls.UndergroundPathNavigation;
import com.Harbinger.Spore.Sentities.Projectile.ThrownTumor;
import com.Harbinger.Spore.Sentities.Projectile.VomitHohlBall;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.fluids.FluidType;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;

public class Hohlfresser extends Calamity implements TrueCalamity, RangedAttackMob {
    private static final EntityDataAccessor<Optional<UUID>> CHILD_UUID = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> CHILD_ID = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> VULNERABLE = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> ADAPTED = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> UNDERGROUND = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> WORM_ANGLE = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> ORES = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.FLOAT);
    private float spin = 0;
    private HohlMultipart[] parts = null;
    public final float[] ringBuffer = new float[64];
    public int ringBufferIndex = -1;
    public float prevWormAngle;
    private int ticksUnder;
    private static final Map<BlockState, Integer> cache = new WeakHashMap<>();
    public Hohlfresser(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.setMaxUpStep(2F);
        this.moveControl = new UndergroundMovementControl(this);
        this.navigation = new UndergroundPathNavigation(this,level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ADAPTED, false);
        this.entityData.define(UNDERGROUND, false);
        this.entityData.define(VULNERABLE, 0);
        this.entityData.define(CHILD_UUID, Optional.empty());
        this.entityData.define(CHILD_ID, -1);
        this.entityData.define(WORM_ANGLE, 0f);
        this.entityData.define(ORES, 0f);
    }
    public float getSpin(){
        float speed = (float) Math.sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x +
                this.getDeltaMovement().z * this.getDeltaMovement().z);
        spin = spin + speed * 0.00025F * tickCount;
        return spin;
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.hohl_loot.get();
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean canGoUnderground() {
        return !entityData.get(UNDERGROUND) && entityData.get(VULNERABLE) <= 0;
    }
    @Override
    public double getDamageCap() {
        return SConfig.SERVER.hohl_dpsr.get();
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("adaptation", entityData.get(ADAPTED));
        tag.putBoolean("underground", entityData.get(UNDERGROUND));
        tag.putInt("vulnerable", entityData.get(VULNERABLE));
        tag.putFloat("ores", entityData.get(ORES));
        if (getChildId() != null) {
            tag.putUUID("ChildUUID", getChildId());
        }
    }
    public boolean isInWall(LivingEntity mob){
        float f = mob.getBbWidth() * 0.8F;
        AABB aabb = AABB.ofSize(mob.getEyePosition().add(0,-0.05,0), (double)f, 1.0E-6, (double)f);
        return BlockPos.betweenClosedStream(aabb).anyMatch((p_201942_) -> {
            BlockState blockstate = mob.level().getBlockState(p_201942_);
            return !blockstate.isAir() && blockstate.isSuffocating(mob.level(), p_201942_) && Shapes.joinIsNotEmpty(blockstate.getCollisionShape(mob.level(), p_201942_).move((double)p_201942_.getX(), (double)p_201942_.getY(), (double)p_201942_.getZ()), Shapes.create(aabb), BooleanOp.AND);
        });
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(ADAPTED, tag.getBoolean("adaptation"));
        entityData.set(UNDERGROUND, tag.getBoolean("underground"));
        entityData.set(VULNERABLE, tag.getInt("vulnerable"));
        entityData.set(ORES, tag.getFloat("ores"));
        if (tag.hasUUID("ChildUUID")) {
            setChildId(tag.getUUID("ChildUUID"));
        }
    }

    @Override
    public void setDefaultAdaptation(ServerLevelAccessor level) {
        super.setDefaultAdaptation(level);
        entityData.set(ADAPTED, true);
    }

    @Override
    protected void grief(AABB aabb) {
        if (!isUnderground() && tickCount % 20 == 0){
            DamageSource source = this.getLastDamageSource();
            AABB box = source == null ? aabb : aabb.move(new Vec3(0,1,0));
            if (Math.random() < 0.2f){
                handleDigIn();
            }
            super.grief(box);
        }
    }
    public boolean isUnderground(){
        return entityData.get(UNDERGROUND);
    }
    public void setUnderground(boolean val) {
        if (val) {
            this.playSound(Ssounds.WORM_DIGGING.get());
            ticksUnder = 40;
        } else {
            entityData.set(VULNERABLE, 200);
        }
        entityData.set(UNDERGROUND, val);
        this.noPhysics = val;
    }

    @Override
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        return this.hurt(source, value);
    }
    public void setWormAngle(float angle){
        this.entityData.set(WORM_ANGLE,angle);
    }
    public float getWormAngle(){
        return entityData.get(WORM_ANGLE);
    }

    @Override
    public int chemicalRange() {
        return 16;
    }

    @Override
    public List<? extends String> buffs() {
        return SConfig.SERVER.hohl_buffs.get();
    }

    @Override
    public List<? extends String> debuffs() {
        return SConfig.SERVER.hohl_debuffs.get();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.hohl_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.23)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.hohl_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.hohl_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2)
                .add(SAttributes.TOXICITY.get(), 0.0D)
                .add(SAttributes.REJUVENATION.get(), 0.0D)
                .add(SAttributes.LOCALIZATION.get(), 0.0D)
                .add(SAttributes.LACERATION.get(), 0.0D)
                .add(SAttributes.CORROSIVES.get(), 0.0D)
                .add(SAttributes.BALLISTIC.get(), 0.0D)
                .add(SAttributes.GRINDING.get(), 0.0D);
    }


    public HohlMultipart[] getHolfParts() {
        return parts;
    }

    @Nullable
    public UUID getChildId() {
        return this.entityData.get(CHILD_UUID).orElse(null);
    }

    public void setChildId(@Nullable UUID uniqueId) {
        this.entityData.set(CHILD_UUID, Optional.ofNullable(uniqueId));
    }
    public Entity getChild() {
        UUID id = getChildId();
        if (id != null && !level().isClientSide) {
            return ((ServerLevel) level()).getEntity(id);
        }
        return null;
    }
    private int getSegments(){return 5;}

    private boolean shouldReplaceParts() {
        if (parts == null || parts[0] == null)
            return true;

        for (int i = 0; i < getSegments(); i++) {
            if (parts[i] == null) {
                return true;
            }
        }
        return false;
    }

    public void tick() {
        super.tick();
        prevWormAngle = this.getWormAngle();
        if (this.yRotO - this.getYRot() > 0.05F) {
            this.setWormAngle(this.getWormAngle() + 15);
        } else if (this.yRotO - this.getYRot() < -0.05F) {
            this.setWormAngle(this.getWormAngle() - 15);
        } else if (this.getWormAngle() > 0) {
            this.setWormAngle(Math.max(this.getWormAngle() - 20, 0));
        } else if (this.getWormAngle() < 0) {
            this.setWormAngle(Math.min(this.getWormAngle() + 20, 0));
        }
        if (entityData.get(VULNERABLE) > 0){
            entityData.set(VULNERABLE,entityData.get(VULNERABLE)-1);
        }

        if (!this.level().isClientSide) {
            final Entity child = getChild();
            if (child == null) {
                float size = 1;
                LivingEntity partParent = this;
                parts = new HohlMultipart[getSegments()];
                for (int i = 0; i < getSegments(); i++) {
                    size = size - 0.1f;
                    HohlMultipart part = new HohlMultipart(Sentities.HOHLFRESSER_SEG.get(), this.level());
                    part.setPos(this.getX(),this.getY(),this.getZ());
                    part.setParent(partParent);
                    part.setSize(size);
                    part.setColor(this.getMutationColor());
                    part.setVariant();
                    part.setIsTail(i == getSegments()-1);
                    if (partParent == this) {
                        this.setChildId(part.getUUID());
                        this.entityData.set(CHILD_ID, part.getId());
                    }
                    if (partParent instanceof HohlMultipart partIndex) {
                        partIndex.setChildId(part.getUUID());
                    }
                    partParent = part;
                    level().addFreshEntity(part);
                    parts[i] = part;
                }
            }
            if (shouldReplaceParts() && this.getChild() instanceof HohlMultipart) {
                parts = new HohlMultipart[getSegments()];
                parts[0] = (HohlMultipart) this.getChild();
                this.entityData.set(CHILD_ID, parts[0].getId());
                int i = 1;
                while (i < parts.length && parts[i - 1].getChild() instanceof HohlMultipart) {
                    parts[i] = (HohlMultipart) parts[i - 1].getChild();
                    i++;
                }
            }
            Vec3 prev = this.position();
            float xRot = this.getXRot();
            for (int i = 0; i < getSegments(); i++) {
                if (this.parts[i] != null) {
                    final float yaw = getYawForPart(i); // or just use head YRot
                    prev = parts[i].tickMultipartPosition(
                            this.getId(), prev, xRot, this.getYRot(), yaw, true
                    );
                    xRot = parts[i].getXRot();
                }
            }
        }
        if (isUnderground()) {
            handleUnearthing();
        }
        if (tickCount % 20 == 0){
            handleDigIn();
        }
        if (ticksUnder > 0){ticksUnder--;}
        if (tickCount % 20 == 0 && isMoving() && isUnderground() && this.getTarget() != null){
            tryAndCrumbleBlocks();
        }
        if (tickCount % 80 == 0 && isUnderground() && isInWall(this)){
            this.playSound(Ssounds.WORM_DIGGING.get());
        }
        if (tickCount % 10 == 0){
            handleShooting();
        }
    }
    void handleShooting(){
        LivingEntity living = this.getTarget();
        if (living != null && living.distanceToSqr(this)> 100 && hasSight(living)){
            performRangedAttack(living,0);
        }
    }
    public boolean hasSight(Entity entity) {
        if (entity.level() != this.level()) {
            return false;
        } else {
            Vec3 vec3 = new Vec3(this.getX(), this.getEyeY(), this.getZ());
            Vec3 vec31 = new Vec3(entity.getX(), entity.getEyeY(), entity.getZ());
            if (vec31.distanceTo(vec3) > 128.0) {
                return false;
            } else {
                return this.level().clip(new ClipContext(vec3, vec31, ClipContext.Block.COLLIDER, net.minecraft.world.level.ClipContext.Fluid.NONE, this)).getType() == HitResult.Type.MISS;
            }
        }
    }
    public static final TagKey<Block> ORE_TAG = TagKey.create(Registries.BLOCK,new ResourceLocation("forge:ores"));
    public float getOres(){return entityData.get(ORES);}
    public void tryAndCrumbleBlocks(){
        if (level().isClientSide){return;}
        if (level() instanceof ServerLevel serverLevel && !checkForNearbyPlayers(serverLevel)){
            return;
        }
        boolean canGrief = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this);
        if (!canGrief){
            return;
        }
        AABB aabb = this.getBoundingBox().inflate(8);
        for(BlockPos blockpos : BlockPos.betweenClosed(
                Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ),
                Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState state = this.level().getBlockState(blockpos);
            BlockState stateBelow = this.level().getBlockState(blockpos.below());
            boolean canFall = stateBelow.isAir() || stateBelow.liquid();
            if (canFall && Math.random() <0.01f){
                double speed = state.getDestroySpeed(this.level(),blockpos);
                if (speed > 0 && speed <= SConfig.SERVER.calamity_bd.get()){
                    this.level().removeBlock(blockpos,false);
                    FallingBlockEntity.fall(this.level(),blockpos,state);
                }
            }
            if ((state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT)) && Math.random() < 0.2){
                level().setBlock(blockpos,Math.random() < 0.5f ? Blocks.DIRT.defaultBlockState() : Blocks.COARSE_DIRT.defaultBlockState(),3);
            }
            if (state.is(ORE_TAG) && Math.random() < 0.005f){
                this.entityData.set(ORES,entityData.get(ORES)+1);
                level().setBlock(blockpos,blockpos.getY() < 0 ? Blocks.COBBLED_DEEPSLATE.defaultBlockState() : Blocks.COBBLESTONE.defaultBlockState(),3);
            }
        }
    }

    private boolean checkForNearbyPlayers(ServerLevel serverLevel){
        List<ServerPlayer> playerList = serverLevel.getPlayers(p -> true);
        if (playerList.isEmpty()){
            return false;
        }
        for (ServerPlayer player : playerList){
            if (player.distanceTo(this) < 400){
                return true;
            }
        }
        return false;
    }
    public static final int FLAG_MINEABLE = 1; // 0b001
    public static final int FLAG_HARD = 2;     // 0b010
    public static final int FLAG_WRONG = 4;    // 0b100

    public int analyzeBlock(BlockState state, BlockPos pos, Map<BlockState, Integer> cache) {
        return cache.computeIfAbsent(state, s -> {
            double hardness = s.getDestroySpeed(level(), pos);
            if (hardness == -1) {
                return FLAG_HARD | FLAG_WRONG; // Not mineable, hard, and wrong
            }

            boolean isMineable = (
                    s.isAir() ||
                            s.canBeReplaced() ||
                            s.is(BlockTags.MINEABLE_WITH_SHOVEL) ||
                            s.is(BlockTags.MINEABLE_WITH_PICKAXE) ||
                            s.liquid() ||
                            hardness == 0
            );

            boolean isHard = hardness > 3;
            boolean isWrong = !isMineable;

            int result = 0;
            if (isMineable) result |= FLAG_MINEABLE;
            if (isHard) result |= FLAG_HARD;
            if (isWrong) result |= FLAG_WRONG;

            return result;
        });
    }

    private boolean checkBlocksUnder() {
        AABB aabb = this.getBoundingBox().move(0, -0.6, 0);

        for (BlockPos pos : BlockPos.betweenClosed(
                Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ),
                Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {

            BlockState state = level().getBlockState(pos);
            int result = analyzeBlock(state, pos, cache);

            if ((result & FLAG_HARD) != 0 || (result & FLAG_MINEABLE) == 0) return false;

            BlockState aboveState = level().getBlockState(pos.above());
            int aboveResult = analyzeBlock(aboveState, pos.above(), cache);

            if ((aboveResult & FLAG_MINEABLE) == 0 || (aboveResult & FLAG_HARD) != 0) return false;
        }

        return true;
    }
    public void handleDigIn(){
        if (!isUnderground() && entityData.get(VULNERABLE) <= 0){
            boolean tooDeep =  level().getMinBuildHeight() < this.getY() - 5;
            boolean below = moveControl.getWantedY() < this.getY();
            boolean above = moveControl.getWantedY() > this.getY()+1;
            if (below || above){
                if (checkBlocksUnder() && tooDeep){
                    setUnderground(true);
                }
            }
        }
    }

    public void handleUnearthing(){
        AABB aabb = this.getBoundingBox().inflate(1, 1.4, 1);
        int airAmount = 0;
        boolean meetsHardBlock = false;
        boolean meetsWrongBlock = false;

        for (BlockPos pos : BlockPos.betweenClosed(
                Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ),
                Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {

            BlockState state = level().getBlockState(pos);
            int result = analyzeBlock(state, pos, cache);

            if (level().canSeeSky(pos) && ticksUnder <= 0) {
                airAmount++;
            }
            if ((result & FLAG_WRONG) != 0) {
                meetsWrongBlock = true;
                break;
            }
            if ((result & FLAG_HARD) != 0) {
                meetsHardBlock = true;
                break;
            }
        }
        if (airAmount >= 4 || meetsHardBlock || meetsWrongBlock){
            setUnderground(false);
        }
    }
    private float getYawForPart(int i) {
        return this.getRingBuffer(4 + i * 2, 1.0F);
    }

    public float getRingBuffer(int bufferOffset, float partialTicks) {
        if (this.isDeadOrDying()) {
            partialTicks = 0.0F;
        }

        partialTicks = 1.0F - partialTicks;
        final int i = this.ringBufferIndex - bufferOffset & 63;
        final int j = this.ringBufferIndex - bufferOffset - 1 & 63;
        final float d0 = this.ringBuffer[i];
        final float d1 = this.ringBuffer[j] - d0;
        return Mth.wrapDegrees(d0 + d1 * partialTicks);
    }
    public boolean isMoving(){
        return Math.sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x +
                this.getDeltaMovement().z * this.getDeltaMovement().z) > 0;
    }
    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.IN_WALL)  || source.is(DamageTypes.FALL);
    }
    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(4,new HohlChargeGoal(this,0.5D,300,100));
        this.goalSelector.addGoal(5, new HohlfresserMeleeAttack(this, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(6, new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7, new SummonScentInCombat(this));
        this.goalSelector.addGoal(8, new SporeBurstSupport(this));
        super.registerGoals();
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }
    private boolean checkVectorForSeeing(Entity target) {
        Vec3 startVec = this.position();
        Vec3 endVec = target.position();
        Vec3 direction = endVec.subtract(startVec).normalize();
        double distance = startVec.distanceTo(endVec);

        for (double i = 0; i <= distance; i += 0.5) {
            Vec3 current = startVec.add(direction.scale(i));
            BlockPos pos = BlockPos.containing(current);
            BlockState state = this.level().getBlockState(pos);
            int result = this.analyzeBlock(state, pos, cache);

            if ((result & FLAG_HARD) != 0 || (result & FLAG_MINEABLE) == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean hasLineOfSight(Entity entity) {
        if (this.getSearchArea() != BlockPos.ZERO){
            return super.hasLineOfSight(entity);
        }
        return super.hasLineOfSight(entity) || checkVectorForSeeing(entity);
    }
    public int getShootingAmount(){
        AttributeInstance instance = this.getAttribute(SAttributes.BALLISTIC.get());
        if (instance != null && instance.getValue() > 0){
            int value = (int) (instance.getValue()*3);
            return random.nextInt(value+1);
        }
        return 1;
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        if (Math.random() < 0.1f){
            for (int i = 0;i<getShootingAmount();i++){
                shootTumor(livingEntity);
            }
        }else {
            float extraDamage = (float) (SConfig.SERVER.hohl_r_damage.get() + getOres() * 0.2f);
            double maxDamage = SConfig.SERVER.hohl_damage.get()/2;
            double damage = maxDamage <= extraDamage ? maxDamage : extraDamage;
            VomitHohlBall.shoot(this,livingEntity,(float) damage,getOres() > 0,getKills() > 0);
        }
    }
    void shootTumor(LivingEntity livingEntity){
        if (level().isClientSide){
            return;
        }
        ThrownTumor tumor = new ThrownTumor(level(),this);
        double dx = livingEntity.getX() - this.getX();
        double dy = livingEntity.getY() + livingEntity.getEyeHeight();
        double dz = livingEntity.getZ() - this.getZ();
        tumor.setExplode(Level.ExplosionInteraction.MOB);
        tumor.shoot(dx, dy - tumor.getY() + Math.hypot(dx, dz) * 0.05F, dz, 1f, 12.0F);
        level().addFreshEntity(tumor);
    }

    static class HohlfresserMeleeAttack extends AOEMeleeAttackGoal{
        public HohlfresserMeleeAttack(Hohlfresser mob, Predicate<LivingEntity> targets) {
            super(mob, 1.5, false, 2.5, 6 ,targets);
        }
        protected double getAttackReachSqr(LivingEntity entity) {
            float f = mob.getBbWidth();
            return f * 1.5F * f + entity.getBbWidth();
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.playSound(Ssounds.SIEGER_BITE.get());
        return super.doHurtTarget(entity);
    }

    @Override
    protected void onEffectAdded(MobEffectInstance instance, @Nullable Entity source) {
        super.onEffectAdded(instance, source);
        HohlMultipart[] parts = getHolfParts();
        if (parts == null) return;
        for (HohlMultipart part : parts) {
            MobEffectInstance existing = part.getEffect(instance.getEffect());
            if (existing == null || existing.getDuration() < instance.getDuration() - 5) {
                part.addEffect(new MobEffectInstance(instance)); // copy to avoid shared timer
            }
        }
    }

    @Override
    protected void onEffectRemoved(MobEffectInstance instance) {
        super.onEffectRemoved(instance);
        if (getHolfParts() == null){
            return;
        }else {
            for (HohlMultipart hohlMultipart : getHolfParts()){
                hohlMultipart.removeEffect(instance.getEffect());
            }
        }
    }

    static class HohlChargeGoal extends Goal {
        private final Hohlfresser mob;
        private final double speed;
        private final int chargeDelay;
        private int chargeTimer = 0;
        private final float distance;

        HohlChargeGoal(Hohlfresser mob, double speed, int chargeDelay, float distance) {
            this.mob = mob;
            this.speed = speed;
            this.chargeDelay = chargeDelay;
            this.distance = distance;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = mob.getTarget();
            if (target == null || !target.isAlive()) {
                chargeTimer = 0;
                return false;
            }

            if (chargeTimer < chargeDelay) {
                chargeTimer++;
                return false;
            }else {
                if (checkVectorForCharging(target)) {
                    return true;
                }
            }
            chargeTimer = 0;
            return false;
        }

        @Override
        public void start() {
            LivingEntity target = mob.getTarget();
            if (target != null && target.distanceTo(mob) < distance) {
                mob.setUnderground(true);
                Vec3 direction = target.position().subtract(mob.position());
                mob.setDeltaMovement(mob.getDeltaMovement().add(direction.scale(speed)));
            }
            chargeTimer = 0;
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

        private boolean checkVectorForCharging(Entity target) {
            Map<BlockState, Integer> cache = new HashMap<>();
            Vec3 startVec = mob.position();
            Vec3 endVec = target.position();
            Vec3 direction = endVec.subtract(startVec).normalize();
            double distance = startVec.distanceTo(endVec);

            for (double i = 0; i <= distance; i += 0.5) {
                Vec3 current = startVec.add(direction.scale(i));
                BlockPos pos = BlockPos.containing(current);
                BlockState state = mob.level().getBlockState(pos);
                int result = mob.analyzeBlock(state, pos, cache);

                if ((result & FLAG_HARD) != 0 || (result & FLAG_MINEABLE) == 0) {
                    return false;
                }
            }
            return true;
        }

    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.HOHL_AMBIENT.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.RAVAGER_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

}