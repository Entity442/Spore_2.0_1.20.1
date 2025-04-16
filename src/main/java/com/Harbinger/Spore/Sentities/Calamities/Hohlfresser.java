package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.*;
import com.Harbinger.Spore.Sentities.AI.CalamityPathNavigation;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.BaseEntities.HohlMultipart;
import com.Harbinger.Spore.Sentities.MovementControls.CalamityMovementControl;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class Hohlfresser extends Calamity implements TrueCalamity {
    private final List<HohlMultipart> subEntities = new ArrayList<>();
    public final HohlMultipart seg1;
    public final HohlMultipart seg2;
    public final HohlMultipart seg3;
    public final HohlMultipart seg4;
    public final HohlMultipart seg5;
    private int segmentTime = 0;
    private float bufferedYRot = 0f;
    private static final float ROTATION_SMOOTHING = 0.15f;
    public static final EntityDataAccessor<Integer> VULNERABLE = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> ADAPTED = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> UNDERGROUND = SynchedEntityData.defineId(Hohlfresser.class, EntityDataSerializers.BOOLEAN);
    private final CalamityMovementControl defaultControl;
    private final CalamityPathNavigation defaultNavigation;
    private final UndergroundMovementControl undergroundMovementController;
    private final UndergroundPathNavigation undergroundPathNavigation;
    public Hohlfresser(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.seg1 = new HohlMultipart(this, "seg1", 2F, 2F,new Vec3(-1.5D,0D,0D),1.1f);
        this.seg2 = new HohlMultipart(this, "seg2", 2F, 2F,new Vec3(-4.75D,0D,0D),1f);
        this.seg3 = new HohlMultipart(this, "seg3", 1.9F, 1.9F,new Vec3(-8D,0D,0D),0.8f);
        this.seg4 = new HohlMultipart(this, "seg4", 1.8F, 1.8F,new Vec3(-11.25D,0D,0D),0.7f);
        this.seg5 = new HohlMultipart(this, "seg5", 1F, 1F,new Vec3(-14.5D,0D,0D),0.6f);
        this.subEntities.add(seg1);
        this.subEntities.add(seg2);
        this.subEntities.add(seg3);
        this.subEntities.add(seg4);
        this.subEntities.add(seg5);
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.size() + 1) + 1);
        this.defaultControl = new CalamityMovementControl(this,20);
        this.defaultNavigation = new CalamityPathNavigation(this,level);;
        this.undergroundMovementController = new UndergroundMovementControl(this,0.15f);
        this.undergroundPathNavigation = new UndergroundPathNavigation(this,level);
    }
    @Override
    public void setId(int p_20235_) {
        super.setId(p_20235_);
        for (int i = 0; i < this.subEntities.size(); i++)
            this.subEntities.get(i).setId(p_20235_ + i + 1);
    }
    public List<HohlMultipart> getSubEntities() {
        return this.subEntities;
    }
    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return subEntities.toArray(new net.minecraftforge.entity.PartEntity<?>[0]);
    }

    @Override
    protected PathNavigation createNavigation(Level p_21480_) {
        try {
            return entityData.get(UNDERGROUND) ? undergroundPathNavigation : defaultNavigation;
        }catch (Exception ignored){
            System.out.print("Failed to create path for "+this.getEncodeId());
        }
        return super.createNavigation(p_21480_);
    }

    @Override
    public MoveControl getMoveControl() {
        try {
            return entityData.get(UNDERGROUND) ? undergroundMovementController : defaultControl;
        }catch (Exception ignored){
            System.out.print("Failed to create movement for "+this.getEncodeId());
        }
        return super.getMoveControl();
    }
    

    @Override
    public void onSyncedDataUpdated(List<SynchedEntityData.DataValue<?>> dataValues) {
        super.onSyncedDataUpdated(dataValues);
        if (UNDERGROUND.equals(dataValues)){
            if (!entityData.get(UNDERGROUND)){
                entityData.set(VULNERABLE,600);
            }
        }
    }
    @Override
    public boolean isPushable() {
        return !entityData.get(UNDERGROUND);
    }

    @Override
    public boolean canBeCollidedWith() {
        return !entityData.get(UNDERGROUND);
    }
    public boolean canGoUnderground(){return !entityData.get(UNDERGROUND) && entityData.get(VULNERABLE) <= 0;}

    public boolean canContinueBeingUnderground(){return entityData.get(UNDERGROUND);}

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        CalamityMultipart[] calamityMultiparts = this.getSubEntities()
                .toArray(new CalamityMultipart[0]);

        for (int i = 0; i < calamityMultiparts.length; ++i) {
            calamityMultiparts[i].setId(i + packet.getId());
        }
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ADAPTED, false);
        this.entityData.define(UNDERGROUND, true);
        this.entityData.define(VULNERABLE, 0);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("adaptation",entityData.get(ADAPTED));
        tag.putBoolean("underground",entityData.get(UNDERGROUND));
        tag.putInt("vulnerable",entityData.get(VULNERABLE));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(ADAPTED,tag.getBoolean("adaptation"));
        entityData.set(UNDERGROUND,tag.getBoolean("underground"));
        entityData.set(VULNERABLE,tag.getInt("vulnerable"));
    }

    @Override
    public void setDefaultAdaptation(ServerLevelAccessor level) {
        super.setDefaultAdaptation(level);
        entityData.set(ADAPTED,true);
    }

    @Override
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        this.hurt(source,value);
        return false;
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
                .add(Attributes.ATTACK_KNOCKBACK, 2);

    }

    @Override
    public void aiStep() {
        super.aiStep();
        bufferedYRot += (this.getYRot() - bufferedYRot) * ROTATION_SMOOTHING;
        segmentTime++;
        if (entityData.get(VULNERABLE)>0){
            entityData.set(VULNERABLE,entityData.get(VULNERABLE)-1);
        }
        if (entityData.get(UNDERGROUND)) {
            checkInsideBlocks();
            this.setNoGravity(true);
            this.noPhysics = true;
        } else {
            this.setNoGravity(false);
            this.noPhysics = false;
        }
    }
    public float getBufferedYRot() {
        return bufferedYRot;
    }
    @Override
    public void tick() {
        super.tick();
        applyIK();
    }

    public void applyIK() {
        List<HohlMultipart> parts = getSubEntities();
        for (int i = 0; i < parts.size(); i++) {
            HohlMultipart prev = (i > 0) ? parts.get(i - 1) : null;
            parts.get(i).tickMovement(segmentTime, i, prev);
        }
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(4, new AOEMeleeAttackGoal(this, 1.5, false,2.5 ,6, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}){
            protected double getAttackReachSqr(LivingEntity entity) {
                float f = Hohlfresser.this.getBbWidth();
                return (double)(f * 3.0F * f * 3.0F + entity.getBbWidth());
            }
        });
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.2));
        this.goalSelector.addGoal(6,new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7,new SummonScentInCombat(this));
        this.goalSelector.addGoal(8,new SporeBurstSupport(this));
        this.goalSelector.addGoal(9,new RandomStrollGoal(this , 1));
        super.registerGoals();
    }
}
