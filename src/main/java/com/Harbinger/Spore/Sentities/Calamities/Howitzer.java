package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.CalamityInfectedCommand;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SporeBurstSupport;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SummonScentInCombat;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.FallenMultipart.HowitzerArm;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class Howitzer extends Calamity implements TrueCalamity {
    public static final EntityDataAccessor<Float> RIGHT_ARM = SynchedEntityData.defineId(Howitzer.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Float> LEFT_ARM = SynchedEntityData.defineId(Howitzer.class, EntityDataSerializers.FLOAT);
    private final CalamityMultipart[] subEntities;
    public final CalamityMultipart rightArm;
    public final CalamityMultipart leftArm;
    public final CalamityMultipart mouth;
    public int getLeapTime = 0;
    public Howitzer(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.rightArm = new CalamityMultipart(this, "rightarm", 2F, 4F);
        this.leftArm = new CalamityMultipart(this, "leftarm", 2F, 4F);
        this.mouth = new CalamityMultipart(this, "mouth", 4F, 3F);
        this.subEntities = new CalamityMultipart[]{ this.rightArm, this.leftArm,this.mouth};
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
    public void chemAttack() {

    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.sieger_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.sieger_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.sieger_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2);

    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4,new AOEMeleeAttackGoal(this,1,true,3,5,e-> {return this.TARGET_SELECTOR.test(e);}){
            @Override
            public boolean canUse() {
                return Howitzer.this.isInMeleeRange() && Howitzer.this.getGetLeapTime() <= 0 && super.canUse();
            }
        });
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.2));
        this.goalSelector.addGoal(6,new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7,new SummonScentInCombat(this));
        this.goalSelector.addGoal(8,new SporeBurstSupport(this));
        this.goalSelector.addGoal(9,new RandomStrollGoal(this , 1));
    }

    @Override
    public void aiStep() {
        float f14 = this.getYRot() * ((float)Math.PI/180);
        float f2 = Mth.sin(f14);
        float f15 = Mth.cos(f14);
        Vec3[] avec3 = new Vec3[this.subEntities.length];
        for(int j = 0; j < this.subEntities.length; ++j) {
            avec3[j] = new Vec3(this.subEntities[j].getX(), this.subEntities[j].getY(), this.subEntities[j].getZ());
        }
        this.tickPart(this.mouth, (double)(f2*0.5f), 5.0D, (double)(-f15 *0.5f));
        if (getRightArmHp()>0){
            this.tickPart(this.rightArm, (double)(f2 * 5F), 0.0D, (double)(-f15*3f));
        }else{
            this.tickPart(this.rightArm, (double)(f2), 0.0D, (double)(-f15));
        }
        if (getLeftArmHp() >0){
            this.tickPart(this.leftArm, (double)(f2 *-5.2F), 0.0D, (double)(-f15 * -2f));
        }else{
            this.tickPart(this.leftArm, (double)(f2), 0.0D, (double)(-f15));
        }
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
    public boolean hasBothArms(){
        return this.getRightArmHp()>0 && this.getLeftArmHp()>0;
    }
    public boolean isInMeleeRange(){
        LivingEntity living = this.getTarget();
        return living != null && this.distanceToSqr(living) < 200;
    }
    public int getGetLeapTime(){
        return getLeapTime;
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
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        if (calamityMultipart == this.mouth){
            this.hurt(source,value*2f);
        }else if (calamityMultipart == this.rightArm){
            this.hurt(source,value *1.5f);
            float lostHealth = getRightArmHp()-value;
            this.setRightArmHp(lostHealth > 0 ? lostHealth : summonDetashedPart(true));
        }else if (calamityMultipart == this.leftArm){
            this.hurt(source,value*1.5f);
            float lostHealth = getLeftArmHp()-value;
            this.setLeftArmHp(lostHealth > 0 ? lostHealth : summonDetashedPart(false));
        } else{
            this.hurt(source,value );
        }
        return true;
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RIGHT_ARM, this.getMaxArmHp());
        this.entityData.define(LEFT_ARM, this.getMaxArmHp());
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("right_arm", entityData.get(RIGHT_ARM));
        tag.putFloat("left_arm",entityData.get(LEFT_ARM));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(RIGHT_ARM, tag.getFloat("right_arm"));
        entityData.set(LEFT_ARM,tag.getFloat("left_arm"));
    }
    public float getRightArmHp(){
        return entityData.get(RIGHT_ARM);
    }
    public void setRightArmHp(float i){
        entityData.set(RIGHT_ARM,i);
    }
    public float getLeftArmHp(){
        return entityData.get(LEFT_ARM);
    }
    public void setLeftArmHp(float i){
        entityData.set(LEFT_ARM,i);
    }
    public float getMaxArmHp(){
        return (float) (SConfig.SERVER.sieger_hp.get()/5.0f);
    }

    @Override
    protected int calculateFallDamage(float p_149389_, float p_149390_) {
        if (super.calculateFallDamage(p_149389_, p_149390_) > 1){
            damageStomp(this.level(),this.getOnPos(),8,10);
        }
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 20 == 0 && this.getHealth() == this.getMaxHealth()){
            if (this.getRightArmHp() < this.getMaxArmHp()){
                this.setRightArmHp(getRightArmHp()+1);
            }
            if (this.getLeftArmHp() < this.getMaxArmHp()){
                this.setLeftArmHp(getLeftArmHp()+1);
            }
        }
    }

    public float summonDetashedPart(boolean isRight){
        double offset = isRight ? 3D : -3D;
        Vec3 vec3 = (new Vec3(0.0D, 0.0D, offset)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        HowitzerArm arm = new HowitzerArm(Sentities.HOWIT_ARM.get(),this.level());
        arm.setRight(isRight);
        arm.moveTo(this.getX() + vec3.x, this.getY() + 1.6,this.getZ()+ vec3.z);
        level().addFreshEntity(arm);
        this.playSound(Ssounds.LIMB_SLASH.get());
        return 0;
    }

    protected void damageStomp(Level level, BlockPos pos, double range, double damageRange){
        AABB aabb = this.getBoundingBox().inflate(damageRange);
        List<Entity> entities = level.getEntities(this,aabb,entity -> {return entity instanceof LivingEntity living && TARGET_SELECTOR.test(living);});
        for(int i = 0; i <= 2*range; ++i) {
            for(int j = 0; j <= 2*range; ++j) {
                for(int k = 0; k <= 2*range; ++k) {
                    double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                    if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                        if (distance<range+(0.5)){
                            BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                            BlockState state = level.getBlockState(blockpos);
                            boolean airAbove = level.getBlockState(blockpos.above()).isAir();
                            boolean airBelow = level.getBlockState(blockpos.below()).isAir();
                            if (state.isSolidRender(level,blockpos) && level instanceof ServerLevel serverLevel){
                                if (airAbove){
                                    ItemStack stack = new ItemStack(state.getBlock().asItem());
                                    serverLevel.sendParticles(new ItemParticleOption(ParticleTypes.ITEM,stack),blockpos.getX(), blockpos.getY()+0.3f, blockpos.getZ(),3,(this.random.nextFloat() - 1D) * 0.08D, (this.random.nextFloat() - 1D) * 0.08D, (this.random.nextFloat() - 1D) * 0.08D,0.15F);
                                }
                                if (airBelow){
                                    FallingBlockEntity.fall(serverLevel,blockpos,state);
                                    serverLevel.removeBlock(blockpos,false);
                                }
                            }

                        }}}}}
        for (Entity entity : entities){
            if (entity instanceof LivingEntity living)
            for (int i = 0;i<2;i++){
                this.doHurtTarget(living);
                living.hurtTime = 0;
                living.invulnerableTime = 0;
            }
        }
    }
}
