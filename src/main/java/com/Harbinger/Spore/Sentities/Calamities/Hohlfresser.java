package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SAttributes;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.*;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.BaseEntities.HohlMultipart;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.*;

public class Hohlfresser extends Calamity implements TrueCalamity {
    private static final EntityDataAccessor<Optional<UUID>> CHILD_UUID = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> CHILD_ID = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> VULNERABLE = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> ADAPTED = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> UNDERGROUND = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> WORM_ANGLE = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.FLOAT);
    private float spin = 0;

    private HohlMultipart[] parts = null;
    public final float[] ringBuffer = new float[64];
    public int ringBufferIndex = -1;
    public float prevWormAngle;
    public Hohlfresser(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.setMaxUpStep(1.5F);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ADAPTED, false);
        this.entityData.define(UNDERGROUND, true);
        this.entityData.define(VULNERABLE, 0);
        this.entityData.define(CHILD_UUID, Optional.empty());
        this.entityData.define(CHILD_ID, -1);
        this.entityData.define(WORM_ANGLE, 0f);
    }

    @Override
    public void onSyncedDataUpdated(List<SynchedEntityData.DataValue<?>> dataValues) {
        super.onSyncedDataUpdated(dataValues);
        if (dataValues.equals(UNDERGROUND)) {
            if (!entityData.get(UNDERGROUND)) {
                entityData.set(VULNERABLE, 600);
            }
        }
    }
    public float getSpin(){
        float speed = (float) Math.sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x +
                this.getDeltaMovement().z * this.getDeltaMovement().z);
        spin = spin + speed * 0.00025F * tickCount;
        return spin;
    }

    @Override
    public boolean isPushable() {
        return !entityData.get(UNDERGROUND);
    }

    @Override
    public boolean canBeCollidedWith() {
        return !entityData.get(UNDERGROUND);
    }

    public boolean canGoUnderground() {
        return !entityData.get(UNDERGROUND) && entityData.get(VULNERABLE) <= 0;
    }

    public boolean canContinueBeingUnderground() {
        return entityData.get(UNDERGROUND);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("adaptation", entityData.get(ADAPTED));
        tag.putBoolean("underground", entityData.get(UNDERGROUND));
        tag.putInt("vulnerable", entityData.get(VULNERABLE));
        if (getChildId() != null) {
            tag.putUUID("ChildUUID", getChildId());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(ADAPTED, tag.getBoolean("adaptation"));
        entityData.set(UNDERGROUND, tag.getBoolean("underground"));
        entityData.set(VULNERABLE, tag.getInt("vulnerable"));
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
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        this.hurt(source, value);
        return false;
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
        return SConfig.SERVER.sieger_buffs.get();
    }

    @Override
    public List<? extends String> debuffs() {
        return SConfig.SERVER.sieger_debuffs.get();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.sieger_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.23)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.sieger_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.sieger_armor.get() * SConfig.SERVER.global_armor.get())
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

        if (!this.level().isClientSide) {
            final Entity child = getChild();
            if (child == null) {
                float size = 1;
                LivingEntity partParent = this;
                parts = new HohlMultipart[getSegments()];
                Vec3 vec3 = (new Vec3(-2.5,0,1.75)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
                Vec3 prevPos = this.position().add(vec3);
                for (int i = 0; i < getSegments(); i++) {
                    size = size - 0.1f;
                    final float prevReqRot = calcPartRotation(i) + getYawForPart(i);
                    final float reqRot = calcPartRotation(i + 1) + getYawForPart(i);
                    HohlMultipart part = new HohlMultipart(Sentities.HOHLFRESSER_SEG.get(), this.level());
                    part.setParent(partParent);
                    part.setSize(size);
                    part.setIsTail(i == getSegments()-1);
                    if (partParent == this) {
                        this.setChildId(part.getUUID());
                        this.entityData.set(CHILD_ID, part.getId());
                    }
                    if (partParent instanceof HohlMultipart partIndex) {
                        partIndex.setChildId(part.getUUID());
                    }
                    part.setPos(part.tickMultipartPosition(this.getId(), prevPos, this.getXRot(), prevReqRot, reqRot, true));
                    partParent = part;
                    level().addFreshEntity(part);
                    parts[i] = part;
                    prevPos = part.position();
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

    private float calcPartRotation(int i) {
        float angle = (float) (-Math.sin(this.walkDist * 3 - i) * 40);
        return angle * 0.5f * i;
    }
    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.IN_WALL)  || source.is(DamageTypes.FALL);
    }
    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(4, new AOEMeleeAttackGoal(this, 1.5, false, 2.5, 6 ,livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}) {
            protected double getAttackReachSqr(LivingEntity entity) {
                float f = Hohlfresser.this.getBbWidth();
                return f * 3.0F * f * 3.0F + entity.getBbWidth();
            }
        });
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.2));
        this.goalSelector.addGoal(6, new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7, new SummonScentInCombat(this));
        this.goalSelector.addGoal(8, new SporeBurstSupport(this));
        this.goalSelector.addGoal(9, new RandomStrollGoal(this, 1));
        super.registerGoals();
    }
}