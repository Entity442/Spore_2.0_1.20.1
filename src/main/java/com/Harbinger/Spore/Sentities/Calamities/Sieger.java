package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.CalamityInfectedCommand;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.ScatterShotRangedGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SporeBurstSupport;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SummonScentInCombat;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.FallenMultipart.SiegerTail;
import com.Harbinger.Spore.Sentities.Projectile.ThrownTumor;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class Sieger extends Calamity implements RangedAttackMob, TrueCalamity {
    public static final EntityDataAccessor<Float> TAIL_HP = SynchedEntityData.defineId(Sieger.class, EntityDataSerializers.FLOAT);
    private final CalamityMultipart[] subEntities;
    public final CalamityMultipart lowerbody;
    public final CalamityMultipart head;
    public CalamityMultipart tail;
    public Sieger(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.lowerbody = new CalamityMultipart(this, "lowerbody", 3.0F, 3.0F);
        this.tail = new CalamityMultipart(this, "tail", 1.0F, 1.0F);
        this.head = new CalamityMultipart(this, "head", 1.4F, 1.4F);
        this.subEntities = new CalamityMultipart[]{ this.lowerbody, this.tail,this.head};
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
        if (this.getHealth() >= this.getMaxHealth() && this.getTailHp() < this.getMaxTailHp()){
            if (this.tickCount % 40 == 0){
                this.setTailHp(this.getTailHp() +1);
            }
        }

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
        if (this.getTailHp() > 0){
            this.tickPart(this.tail, (double)(f2), 7.0D, (double)(-f15));
        }else{
            this.tickPart(this.tail, (double)(f2 * 2.0F), 1.0D, (double)(-f15 * 2.0F));
        }
        this.tickPart(this.head, (double)(f2 * -2.5F), 1.4D, (double)(-f15 * -2.5F));
        this.tickPart(this.lowerbody, (double)(f2 * 3.0F), 0.0D, (double)(-f15 * 3.0F));
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
    public CalamityMultipart[] getSubEntities() {
        return this.subEntities;
    }


    boolean calculateHeight(){
        return this.getTarget() != null && this.getTarget().getY() > this.getY() && Math.abs(Math.abs(this.getTarget().getY()) - Math.abs(this.getY())) > 5;
    }

    boolean calculateDistance(){
        return this.getTarget() != null && this.distanceToSqr(this.getTarget()) > 400.0D;
    }

    @Override
    public boolean hasLineOfSight(Entity entity) {
        if (calculateDistance() || calculateHeight()){
            return true;
        }
        return super.hasLineOfSight(entity);
    }

    @Override
    public void registerGoals() {

        this.goalSelector.addGoal(3, new ScatterShotRangedGoal(this,1.5,80,48,3,6){
            @Override
            public boolean canUse() {
                if (Sieger.this.getTailHp() <= 0){
                    return false;
                }
                return super.canUse() && (calculateHeight() || calculateDistance());
            }
        });
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this,0.4F));
        this.goalSelector.addGoal(4, new AOEMeleeAttackGoal(this, 1.5, false,2.5 ,6){
            protected double getAttackReachSqr(LivingEntity entity) {
                float f = Sieger.this.getBbWidth();
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

    public boolean canDisableShield() {
        return true;
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
    public int getDestroySpeed() {
        return SConfig.SERVER.sieger_block_damage.get();
    }

    protected SoundEvent getAmbientSound() {
        if (this.getTarget() != null && this.distanceToSqr(this.getTarget()) > 200){
            return null;
        }
        return Ssounds.SIEGER_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.RAVAGER_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
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

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float p_33318_) {
        if(!level().isClientSide){
            ThrownTumor tumor = new ThrownTumor(level(), this);
            double dx = livingEntity.getX() - this.getX();
            double dy = livingEntity.getY() + livingEntity.getEyeHeight() + 5;
            double dz = livingEntity.getZ() - this.getZ();
            if (SConfig.SERVER.sieger_explosive_effects != null){
                List<? extends String> ev = SConfig.SERVER.sieger_explosive_effects.get();
                for (int i = 0; i < 1; ++i) {
                    int randomIndex = random.nextInt(ev.size());
                    ResourceLocation randomElement1 = new ResourceLocation(ev.get(randomIndex));
                    MobEffect randomElement = ForgeRegistries.MOB_EFFECTS.getValue(randomElement1);
                    tumor.setMobEffect(randomElement);
                }
            }
            tumor.setExplode(Level.ExplosionInteraction.MOB);
            tumor.moveTo(this.getX(),this.getY()+8.2,this.getZ());
            tumor.shoot(dx, dy - tumor.getY() + Math.hypot(dx, dz) * 0.05F, dz, 1f * 2, 12.0F);
            level().addFreshEntity(tumor);
        }
    }

    public void chemAttack() {
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
    public boolean doHurtTarget(Entity entity) {
        this.playSound(Ssounds.SIEGER_BITE.get());
        return super.doHurtTarget(entity);
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TAIL_HP, this.getMaxTailHp());
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("tail_hp", entityData.get(TAIL_HP));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TAIL_HP, tag.getFloat("tail_hp"));
    }
    public float getTailHp(){
        return entityData.get(TAIL_HP);
    }
    public void setTailHp(float i){
        entityData.set(TAIL_HP,i);
    }

    public float getMaxTailHp(){
        return (float) (SConfig.SERVER.sieger_hp.get()/4.0f);
    }

    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        if (calamityMultipart == this.tail){
            if (this.getTailHp() > 0 && value > this.getTailHp()){
                this.playSound(Ssounds.LIMB_SLASH.get());
                SummonDetashedTail();
            }
            this.hurt(source,value * 2);
            this.setTailHp(value > this.getTailHp() ? 0 : this.getTailHp() - value);
        }if (calamityMultipart == this.head){
            this.hurt(source,value * 0.75f);
        }else{
            this.hurt(source,value );
        }
        return true;
    }


    private void SummonDetashedTail(){
        SiegerTail siegerTail = new SiegerTail(Sentities.SIEGER_TAIL.get(),this.level());
        Vec3 vec3 = (new Vec3(-1.7D, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        siegerTail.moveTo(this.getX() + vec3.x, this.getY() + 1.6,this.getZ()+ vec3.z);
        this.level().addFreshEntity(siegerTail);
    }
}
