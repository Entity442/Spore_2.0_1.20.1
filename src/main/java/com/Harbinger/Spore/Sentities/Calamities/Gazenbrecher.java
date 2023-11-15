package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.CalamityInfectedCommand;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SporeBurstSupport;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SummonScentInCombat;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.MovementControls.WaterXlandMovement;
import com.Harbinger.Spore.Sentities.WaterInfected;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class Gazenbrecher extends Calamity implements WaterInfected {
    public static final EntityDataAccessor<Float> TONGUE = SynchedEntityData.defineId(Gazenbrecher.class, EntityDataSerializers.FLOAT);
    private final CalamityMultipart[] subEntities;
    public final CalamityMultipart lowerbody;
    public final CalamityMultipart tail;
    public final CalamityMultipart tongue;
    public Gazenbrecher(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.moveControl = new WaterXlandMovement(this,0.5f);
        this.lowerbody = new CalamityMultipart(this, "lowerbody", 3.0F, 3.0F);
        this.tail = new CalamityMultipart(this, "tail", 2.5F, 2.5F);
        this.tongue = new CalamityMultipart(this, "tongue", 2.0F, 2.0F);
        this.subEntities = new CalamityMultipart[]{ this.lowerbody, this.tail,this.tongue};

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
    public double setInflation() {
        return 1.0;
    }


    @Override
    public void tick() {
        super.tick();
        if (this.getHealth() < this.getMaxHealth() && !this.hasEffect(MobEffects.REGENERATION) && this.getKills() > 0){
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION,600,0));
            this.setKills(this.getKills()-1);
        }
        if (this.getHealth() >= this.getMaxHealth() && this.getTongueHp() < this.getMaxTongueHp()){
            if (this.tickCount % 40 == 0){
                this.setTongueHp(this.getTongueHp() +1);
            }
        }

    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TONGUE, this.getMaxTongueHp());
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("tongue_hp", entityData.get(TONGUE));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TONGUE, tag.getFloat("tongue_hp"));
    }
    public float getTongueHp(){
        return entityData.get(TONGUE);
    }
    public void setTongueHp(float i){
        entityData.set(TONGUE,i);
    }

    public float getMaxTongueHp(){
        return (float) (SConfig.SERVER.sieger_hp.get()/4.0f);
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.sieger_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.sieger_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.sieger_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2);

    }


    @Override
    public void aiStep() {
        float f14 = this.getYRot() * ((float)Math.PI / 180F);
        float f2 = Mth.sin(f14);
        float f15 = Mth.cos(f14);
        Vec3[] avec3 = new Vec3[this.subEntities.length];
        for(int j = 0; j < this.subEntities.length; ++j) {
            avec3[j] = new Vec3(this.subEntities[j].getX(), this.subEntities[j].getY(), this.subEntities[j].getZ());
        }
        this.tickPart(this.tail, (double)(f2 * 6.0F), 0.0D, (double)(-f15 * 6.0F));
        this.tickPart(this.lowerbody, (double)(f2 * 3.0F), 0.0D, (double)(-f15 * 3.0F));
        this.tickPart(this.tongue, (double)(f2 * -3F), 0.3D, (double)(-f15 * -3F));
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


    private void tickPart(CalamityMultipart part, double e, double i, double o) {
        part.setPos(this.getX() + e, this.getY() + i, this.getZ() + o);
    }
    public CalamityMultipart[] getSubEntities() {
        return this.subEntities;
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
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
    public boolean hurt(DamageSource source, float amount) {
        if(amount > SConfig.SERVER.sieger_dpsr.get() && SConfig.SERVER.sieger_dpsr.get() > 0){
            return super.hurt(source, (float) (SConfig.SERVER.sieger_dpsr.get() * 1F));
        }
        return super.hurt(source, amount);
    }


    private void chemAttack() {
        AABB boundingBox = this.getBoundingBox().inflate(16);
        List<Entity> entities = this.level().getEntities(this, boundingBox);
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity && !(entity instanceof Infected || entity instanceof UtilityEntity || SConfig.SERVER.blacklist.get().contains(entity.getEncodeId()) || livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() == Sitems.GAS_MASK.get())) {
                for (String str : SConfig.SERVER.sieger_debuffs.get()){
                    String[] string = str.split("\\|" );
                    MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(string[0]));
                    if (effect != null && !livingEntity.hasEffect(effect)){
                        livingEntity.addEffect(new MobEffectInstance(effect , Integer.parseUnsignedInt(string[1]), Integer.parseUnsignedInt(string[2])));
                    }
                }
            }else if (entity instanceof LivingEntity livingEntity && (entity instanceof Infected || entity instanceof UtilityEntity || SConfig.SERVER.blacklist.get().contains(entity.getEncodeId()))){
                for (String str : SConfig.SERVER.sieger_buffs.get()){
                    String[] string = str.split("\\|" );
                    MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(string[0]));
                    if (effect != null && !livingEntity.hasEffect(effect)){
                        livingEntity.addEffect(new MobEffectInstance(effect , Integer.parseUnsignedInt(string[1]), Integer.parseUnsignedInt(string[2])));
                    }
                }
            }
        }
    }


    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this,0.4F));
        this.goalSelector.addGoal(4, new AOEMeleeAttackGoal(this, 1.5, false,2.5 ,6){
            protected double getAttackReachSqr(LivingEntity entity) {
                float f = Gazenbrecher.this.getBbWidth();
                return (double)(f * 3.0F * f * 3.0F + entity.getBbWidth());
            }
        });
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.2));
        this.goalSelector.addGoal(6,new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7,new SummonScentInCombat(this));
        this.goalSelector.addGoal(8,new SporeBurstSupport(this){
            @Override
            public void start() {
                super.start();
                chemAttack();
            }
        });
        super.registerGoals();
    }

    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        if (calamityMultipart == this.tongue){
            if (this.getTongueHp() > 0 && value > this.getTongueHp()){
                this.playSound(Ssounds.LIMB_SLASH.get());
            }
            this.hurt(source,value * 2);
            this.setTongueHp(value > this.getTongueHp() ? 0 : this.getTongueHp() - value);
        } else{
            this.hurt(source,value );
        }
        return true;
    }
}
