package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SAttributes;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.CalamityInfectedCommand;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SporeBurstSupport;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SummonScentInCombat;
import com.Harbinger.Spore.Sentities.AI.CalamityPathNavigation;
import com.Harbinger.Spore.Sentities.AI.FloatDiveGoal;
import com.Harbinger.Spore.Sentities.AmbientSparks;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkDragonHead;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkDragonTail;
import com.Harbinger.Spore.Sentities.MovementControls.CalamityMovementControl;
import com.Harbinger.Spore.Sentities.MovementControls.DragonFlightMoveControl;
import com.Harbinger.Spore.Sentities.MovementControls.ExperimentalGroundMovementController;
import com.Harbinger.Spore.Sentities.MovementControls.UndergroundPathNavigation;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Verfalldrachen extends Calamity implements TrueCalamity {
    public static final int TAR_HEAD_SEGMENT = 6;
    public static final int SONIC_HEAD_SEGMENT = 7;
    public static final int ELECTRICAL_SEGMENT = 7;
    private final CalamityMultipart[] subEntities;
    public final CalamityMultipart ass;
    public final CalamityMultipart rightWing;
    public final CalamityMultipart leftWing;
    public final CalamityMultipart soundHead;
    public final CalamityMultipart tarHead;
    public final CalamityMultipart lightningHead;
    private final IkDragonHead ikSoundHead;
    private final IkDragonHead ikTarHead;
    private final IkDragonHead ikLightningHead;
    private final IkDragonTail tail;
    protected List<AmbientSparks> sparks = new ArrayList<>();
    private static final EntityDataAccessor<Float> CHARGE = SynchedEntityData.defineId(Verfalldrachen.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> CHARGE_DATA_ID = SynchedEntityData.defineId(Verfalldrachen.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> RIGHT_WING_HP = SynchedEntityData.defineId(Verfalldrachen.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> LEFT_WING_HP = SynchedEntityData.defineId(Verfalldrachen.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> TAR_HEAD_HP = SynchedEntityData.defineId(Verfalldrachen.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> SONIC_HEAD_HP = SynchedEntityData.defineId(Verfalldrachen.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> ELECTRICAL_HP = SynchedEntityData.defineId(Verfalldrachen.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> TAR_HEAD_SEGMENTS = SynchedEntityData.defineId(Verfalldrachen.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SONIC_HEAD_SEGMENTS = SynchedEntityData.defineId(Verfalldrachen.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> ELECTRICAL_SEGMENTS = SynchedEntityData.defineId(Verfalldrachen.class, EntityDataSerializers.INT);
    private final float wingsMaxHp = (float) (SConfig.SERVER.sieger_hp.get() * SConfig.SERVER.global_health.get() * 0.25);
    private final float headsMaxHp = (float) (SConfig.SERVER.sieger_hp.get() * SConfig.SERVER.global_health.get() * 0.35);
    protected final CalamityPathNavigation calamityPathNavigation;
    protected final UndergroundPathNavigation undergroundPathNavigation;
    protected final ExperimentalGroundMovementController groundMovementController;
    protected final DragonFlightMoveControl flightMoveControl;
    private int flapAnimationTicks;
    public Verfalldrachen(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.ass = new CalamityMultipart(this, "ass", 2F, 4.0F);
        this.rightWing = new CalamityMultipart(this, "right_wing", 4F, 2.5F);
        this.leftWing = new CalamityMultipart(this, "left_wing", 4F, 2.5F);
        this.soundHead = new CalamityMultipart(this, "sound_head", 1.75F, 1.75F);
        this.tarHead = new CalamityMultipart(this, "tar_head", 1.5F, 1.5F);
        this.lightningHead = new CalamityMultipart(this, "lightning_head", 1.5F, 1.5F);
        this.subEntities = new CalamityMultipart[]{ this.ass, this.rightWing, this.leftWing,this.soundHead,this.tarHead,this.lightningHead};
        this.ikSoundHead =  new IkDragonHead(this,soundHead,SONIC_HEAD_SEGMENT,new Vec3(3,4.25,1),new Vec3(5.5,6.5,4));
        this.ikTarHead =  new IkDragonHead(this,tarHead,TAR_HEAD_SEGMENT,new Vec3(3,4.65,0),new Vec3(6.5,7.5,0));
        this.ikLightningHead =  new IkDragonHead(this,lightningHead,ELECTRICAL_SEGMENT,new Vec3(3,4.25,-1),new Vec3(5.5,6.5,-4));
        this.tail = new IkDragonTail(this,10,new Vec3(-4,3.5,0),new Vec3(-12,0.5,0));
        this.groundMovementController = new ExperimentalGroundMovementController(this);
        this.flightMoveControl = new DragonFlightMoveControl(this);

        calamityPathNavigation = new CalamityPathNavigation(this,level);
        undergroundPathNavigation = new UndergroundPathNavigation(this,level);

        this.navigation = calamityPathNavigation;
        this.moveControl = groundMovementController;
        this.setMaxUpStep(1.5F);
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.length + 1) + 1);
    }
    @Override
    public void setId(int p_20235_) {
        super.setId(p_20235_);
        for (int i = 0; i < this.subEntities.length; i++)
            this.subEntities[i].setId(p_20235_ + i + 1);
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(CHARGE,1f);
        entityData.define(CHARGE_DATA_ID,-1);
        entityData.define(RIGHT_WING_HP,wingsMaxHp);
        entityData.define(LEFT_WING_HP,wingsMaxHp);
        entityData.define(TAR_HEAD_HP,headsMaxHp);
        entityData.define(SONIC_HEAD_HP,headsMaxHp);
        entityData.define(ELECTRICAL_HP,headsMaxHp);
        entityData.define(TAR_HEAD_SEGMENTS,TAR_HEAD_SEGMENT);
        entityData.define(SONIC_HEAD_SEGMENTS,SONIC_HEAD_SEGMENT);
        entityData.define(ELECTRICAL_SEGMENTS,ELECTRICAL_SEGMENT);
    }
    public List<AmbientSparks> getSparks(){
        return sparks;
    }

    public void setCharge(float val){
        entityData.set(CHARGE,val);
    }
    public float getCharge(){
        return entityData.get(CHARGE);
    }
    public void setRightWing(float val){
        entityData.set(RIGHT_WING_HP,val);
    }
    public void setLeftWing(float val){
        entityData.set(LEFT_WING_HP,val);
    }
    public float getRightWing(){
        return entityData.get(RIGHT_WING_HP);
    }
    public float getLeftWing(){
        return entityData.get(LEFT_WING_HP);
    }
    public void setTarHead(float val){
        entityData.set(TAR_HEAD_HP,val);
    }
    public void setSonicHead(float val){
        entityData.set(SONIC_HEAD_HP,val);
    }
    public void setElectricalHead(float val){
        entityData.set(ELECTRICAL_HP,val);
    }
    public float getTarHead(){
        return entityData.get(TAR_HEAD_HP);
    }
    public float getSonicHead(){
        return entityData.get(SONIC_HEAD_HP);
    }
    public float getElectricalHead(){
        return entityData.get(ELECTRICAL_HP);
    }
    public void setTarHeadSegment(int val){
        entityData.set(TAR_HEAD_SEGMENTS,val);
    }
    public void setSonicHeadSegment(int val){
        entityData.set(SONIC_HEAD_SEGMENTS,val);
    }
    public void setElectricalHeadSegment(int val){
        entityData.set(ELECTRICAL_SEGMENTS,val);
    }
    public int getTarHeadSegment(){
        return entityData.get(TAR_HEAD_SEGMENTS);
    }
    public int getSonicHeadSegment(){
        return entityData.get(SONIC_HEAD_SEGMENTS);
    }
    public int getElectricalHeadSegment(){
        return entityData.get(ELECTRICAL_SEGMENTS);
    }

    public int getFlapAnimationTicks() {
        return flapAnimationTicks;
    }
    public void triggerFlap(){
        flapAnimationTicks = 20;
    }
    public void handleEntityEvent(byte value) {
        if (value == 6) {
            this.flapAnimationTicks = 20;
        }else {
            super.handleEntityEvent(value);
        }
    }

    public void setFlying(boolean value){
        boolean shouldFly = value && getRightWing() > 0 && getLeftWing() > 0;
        if (shouldFly){
            moveControl = flightMoveControl;
            navigation = undergroundPathNavigation;
            setNoGravity(true);
        } else {
            moveControl = groundMovementController;
            navigation = calamityPathNavigation;
            setNoGravity(false);
        }
    }

    @Override
    public void travel(Vec3 vec) {
        if (this.isEffectiveAi() && isNoGravity()) {
            this.moveRelative(0.1F, vec);
            this.move(MoverType.SELF, this.getDeltaMovement().scale(isInWater() ? 0.2 : 1f));
            this.setDeltaMovement(this.getDeltaMovement().scale(0.85D).add(0,-0.01,0));
        } else {
            super.travel(vec);
        }
    }
    @Override
    protected int calculateFallDamage(float p_149389_, float p_149390_) {
        return 0;
    }



    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this, 1.5, false,2.5 ,6, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(6, new FloatDiveGoal(this));
        this.goalSelector.addGoal(6,new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7,new SummonScentInCombat(this));
        this.goalSelector.addGoal(8,new SporeBurstSupport(this));
    }



    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        setRightWing(wingsMaxHp);
        setLeftWing(wingsMaxHp);
        setTarHead(headsMaxHp);
        setSonicHead(headsMaxHp);
        setElectricalHead(headsMaxHp);
        setTarHeadSegment(TAR_HEAD_SEGMENT);
        setSonicHeadSegment(SONIC_HEAD_SEGMENT);
        setElectricalHeadSegment(ELECTRICAL_SEGMENT);
    }

    public int getWingData(){
        if (getRightWing() <= 0 && getLeftWing() <= 0){
            return 3;
        }
        if (getRightWing() <= 0){
            return 2;
        }
        if (getLeftWing() <= 0){
            return 1;
        }
        return 0;
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("right_wing_hp", getRightWing());
        tag.putFloat("left_wing_hp", getLeftWing());
        tag.putFloat("tar_head_hp", getTarHead());
        tag.putFloat("sonic_head_hp", getSonicHead());
        tag.putFloat("electric_head_hp", getElectricalHead());
        tag.putInt("tar_head_seg", getTarHeadSegment());
        tag.putInt("sonic_head_seg", getSonicHeadSegment());
        tag.putInt("electric_head_seg", getElectricalHeadSegment());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setRightWing(tag.getFloat("right_wing_hp"));
        setLeftWing(tag.getFloat("left_wing_hp"));
        setTarHead(tag.getFloat("tar_head_hp"));
        setSonicHead(tag.getFloat("sonic_head_hp"));
        setElectricalHead(tag.getFloat("electric_head_hp"));
        setTarHeadSegment(tag.getInt("tar_head_seg"));
        setSonicHeadSegment(tag.getInt("sonic_head_seg"));
        setElectricalHeadSegment(tag.getInt("electric_head_seg"));
    }
    @Override
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        if (calamityMultipart == rightWing && getRightWing() > 0){
            float lostHealth = this.getDamageAfterArmorAbsorb(source,value);
            setRightWing(lostHealth > getRightWing() ? spawnWingFragments(new Vec3(0,1,4)) : getRightWing()-lostHealth);
        }
        if (calamityMultipart == leftWing && getLeftWing() > 0){
            float lostHealth = this.getDamageAfterArmorAbsorb(source,value);
            setLeftWing(lostHealth > getLeftWing() ? spawnWingFragments(new Vec3(0,1,-4)) : getLeftWing()-lostHealth);
        }
        if (calamityMultipart == tarHead){
            if (getTarHead() > 0){
                float lostHealth = this.getDamageAfterArmorAbsorb(source,value);
                setTarHead(lostHealth > getTarHead() ? cutHead(0) : getTarHead()-lostHealth);
            }else {
                return false;
            }
        }
        if (calamityMultipart == soundHead){
            if (getSonicHead() > 0){
                float lostHealth = this.getDamageAfterArmorAbsorb(source,value);
                setSonicHead(lostHealth > getSonicHead() ? cutHead(1) : getSonicHead()-lostHealth);
            }else {
                return false;
            }
        }
        if (calamityMultipart == lightningHead){
            if (getElectricalHead() > 0){
                float lostHealth = this.getDamageAfterArmorAbsorb(source,value);
                setElectricalHead(lostHealth > getElectricalHead() ? cutHead(2) : getElectricalHead()-lostHealth);
            }else {
                return false;
            }
        }
        return hurt(source,value);
    }
    @Override
    public boolean isMultipartEntity() {
        return true;
    }
    protected float spawnWingFragments(Vec3 vec3i){
        Vec3 vec3 = (vec3i).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        ItemStack stack = new ItemStack(Sitems.WING_MEMBRANE.get(),random.nextInt(3,10));
        ItemEntity item = new ItemEntity(level(),this.getX() + vec3.x, this.getY() + vec3i.y, this.getZ() + vec3.z,stack);
        level().addFreshEntity(item);
        return 0f;
    }
    protected float cutHead(int i){
        if (i == 0){
            setTarHeadSegment(0);
        }
        if (i == 1){
            setSonicHeadSegment(0);
        }
        if (i == 2){
            setElectricalHeadSegment(0);
        }
        return 0f;
    }

    @Override
    public double getDamageCap() {
        return 60;
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.subEntities;
    }
    @Override
    public void aiStep() {
        Vec3[] avec3 = new Vec3[this.subEntities.length];
        for(int j = 0; j < this.subEntities.length; ++j) {
            avec3[j] = new Vec3(this.subEntities[j].getX(), this.subEntities[j].getY(), this.subEntities[j].getZ());
        }
        this.tickPart(this.rightWing, new Vec3(0D,0D,4),1D);
        this.tickPart(this.leftWing, new Vec3(0D,0D,-4),1D);
        this.tickPart(this.ass, new Vec3(-4.5,0D,0),0D);
        for(int l = 0; l < this.subEntities.length; ++l) {
            this.subEntities[l].xo = avec3[l].x;
            this.subEntities[l].yo = avec3[l].y;
            this.subEntities[l].zo = avec3[l].z;
            this.subEntities[l].xOld = avec3[l].x;
            this.subEntities[l].yOld = avec3[l].y;
            this.subEntities[l].zOld = avec3[l].z;
        }
        super.aiStep();
    }
    public void updateFlying(){
        LivingEntity livingEntity = getTarget();
        setFlying(livingEntity != null);
    }


    @Override
    public void tick() {
        super.tick();
        ikSoundHead.applyIK();
        ikTarHead.applyIK();
        ikLightningHead.applyIK();
        tail.applyIK();
        if (flapAnimationTicks > 0){
            flapAnimationTicks--;
        }
        if (this.tickCount % 20 == 0){
            updateFlying();
        }
        if (this.tickCount % 40 == 0 && this.getHealth() >= this.getMaxHealth()){
            if (getRightWing() < wingsMaxHp){
                this.setRightWing(this.getRightWing() +1);
            }
            if (getLeftWing() < wingsMaxHp){
                this.setLeftWing(this.getLeftWing() +1);
            }
            if (getTarHeadSegment() < TAR_HEAD_SEGMENT){
                setTarHeadSegment(getTarHeadSegment()+1);
            }else {
                if (getTarHead() < headsMaxHp){
                    this.setTarHead(this.getTarHead() +1);
                }
            }
            if (getElectricalHeadSegment() < ELECTRICAL_SEGMENT){
                setElectricalHeadSegment(getElectricalHeadSegment()+1);
            }else {
                if (getElectricalHead() < headsMaxHp){
                    this.setElectricalHead(this.getElectricalHead() +1);
                }
            }
            if (getSonicHeadSegment() < SONIC_HEAD_SEGMENT){
                setSonicHeadSegment(getSonicHeadSegment()+1);
            }else {
                if (getSonicHead() < headsMaxHp){
                    this.setSonicHead(this.getSonicHead() +1);
                }
            }
        }


        ///Ambient Electricity why am I writing a comment am I a baka ?
        if (tickCount % 5 == 0 && getCharge() > 0 && level().isClientSide){
            this.playSound(Ssounds.ELECTRIC.get());
            for (int e = 0;e<ikLightningHead.getEntities().length;e++){
                float range = Math.abs(getCharge() * 0.15f);
                int charge = (int) range * 3;
                Vec3 entityPositions = ikLightningHead.getEntities()[e];
                for (int i = 0;i<random.nextInt(3 + charge);i++){
                    Vec3 vec3 = Utilities.generatePositionAway(entityPositions,2+range);
                    if (level().isClientSide){
                        AmbientSparks ambientSparks = new AmbientSparks(vec3,null,this,entityPositions,random.nextInt(5,10));
                        sparks.add(ambientSparks);
                    }
                }
            }
        }
        if (level().isClientSide){
            if (!sparks.isEmpty()){
                Iterator<AmbientSparks> it = sparks.iterator();

                while (it.hasNext()) {
                    AmbientSparks spark = it.next();

                    spark.TickSpark();

                    if (spark.life > spark.maxLife) {
                        it.remove();
                    }
                }
            }
        }
    }

    public IkDragonHead getIkSoundHead(){
        return ikSoundHead;
    }

    public IkDragonHead getIkLightningHead() {
        return ikLightningHead;
    }

    public IkDragonHead getIkTarHead() {
        return ikTarHead;
    }

    public IkDragonTail getTail(){return tail;}

    public CalamityMultipart[] getSubEntities() {
        return this.subEntities;
    }
    public void recreateFromPacket(ClientboundAddEntityPacket p_218825_) {
        super.recreateFromPacket(p_218825_);
        if (true) return;
        CalamityMultipart[] calamityMultiparts = this.getSubEntities();

        for(int i = 0; i < calamityMultiparts.length; ++i) {
            calamityMultiparts[i].setId(i + p_218825_.getId());
        }

    }
    @Override
    public int chemicalRange() {
        return 16;
    }

    @Override
    public List<? extends String> buffs() {
        return List.of();
    }

    @Override
    public List<? extends String> debuffs() {
        return List.of();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.sieger_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.sieger_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.sieger_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2)
                .add(Attributes.FLYING_SPEED, 0.3)
                .add(SAttributes.TOXICITY.get(), 0.0D)
                .add(SAttributes.REJUVENATION.get(), 0.0D)
                .add(SAttributes.LOCALIZATION.get(), 0.0D)
                .add(SAttributes.LACERATION.get(), 0.0D)
                .add(SAttributes.CORROSIVES.get(), 0.0D)
                .add(SAttributes.BALLISTIC.get(), 0.0D)
                .add(SAttributes.GRINDING.get(), 0.0D);

    }
}
