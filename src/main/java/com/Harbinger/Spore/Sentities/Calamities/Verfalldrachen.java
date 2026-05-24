package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SAttributes;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AmbientSparks;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkDragonHead;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkDragonTail;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Conductor;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Verfalldrachen extends Calamity implements TrueCalamity {
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
    private static final EntityDataAccessor<Integer> CHARGE_DATA_ID = SynchedEntityData.defineId(Conductor.class, EntityDataSerializers.INT);
    public Verfalldrachen(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.ass = new CalamityMultipart(this, "ass", 2F, 4.0F);
        this.rightWing = new CalamityMultipart(this, "right_wing", 4F, 2.5F);
        this.leftWing = new CalamityMultipart(this, "left_wing", 4F, 2.5F);
        this.soundHead = new CalamityMultipart(this, "sound_head", 1.75F, 1.75F);
        this.tarHead = new CalamityMultipart(this, "tar_head", 1.5F, 1.5F);
        this.lightningHead = new CalamityMultipart(this, "lightning_head", 1.5F, 1.5F);
        this.subEntities = new CalamityMultipart[]{ this.ass, this.rightWing, this.leftWing,this.soundHead,this.tarHead,this.lightningHead};
        this.ikSoundHead =  new IkDragonHead(this,soundHead,8,new Vec3(2,4.25,0.65),new Vec3(5.5,6.5,4));
        this.ikTarHead =  new IkDragonHead(this,tarHead,7,new Vec3(2,4.65,0),new Vec3(5.5,6.5,0));
        this.ikLightningHead =  new IkDragonHead(this,lightningHead,8,new Vec3(2,4.25,-0.65),new Vec3(5.5,6.5,-4));
        this.tail = new IkDragonTail(this,8,new Vec3(-4,3.5,0),new Vec3(-12,1,0));
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
    @Override
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        return hurt(source,value);
    }
    @Override
    public boolean isMultipartEntity() {
        return true;
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
        this.tickPart(this.rightWing, new Vec3(0D,0D,-4),1D);
        this.tickPart(this.leftWing, new Vec3(0D,0D,4),1D);
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

    @Override
    public void tick() {
        super.tick();
        ikSoundHead.applyIK();
        ikTarHead.applyIK();
        ikLightningHead.applyIK();
        tail.applyIK();



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
                .add(SAttributes.TOXICITY.get(), 0.0D)
                .add(SAttributes.REJUVENATION.get(), 0.0D)
                .add(SAttributes.LOCALIZATION.get(), 0.0D)
                .add(SAttributes.LACERATION.get(), 0.0D)
                .add(SAttributes.CORROSIVES.get(), 0.0D)
                .add(SAttributes.BALLISTIC.get(), 0.0D)
                .add(SAttributes.GRINDING.get(), 0.0D);

    }
}
