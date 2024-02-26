package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.AerialRangedGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.CalamityInfectedCommand;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SporeBurstSupport;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SummonScentInCombat;
import com.Harbinger.Spore.Sentities.AI.FlyingWanderAround;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.FlyingInfected;
import com.Harbinger.Spore.Sentities.Projectile.ThrownTumor;
import com.Harbinger.Spore.Sentities.TrueCalamity;
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
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class Hinderburg extends Calamity implements FlyingInfected , TrueCalamity , RangedAttackMob {
    public static final EntityDataAccessor<Integer> BOMB = SynchedEntityData.defineId(Hinderburg.class, EntityDataSerializers.INT);
    private final CalamityMultipart[] subEntities;
    public final CalamityMultipart lowerbody;
    public final CalamityMultipart forwardbody;
    public final CalamityMultipart rightcannon;
    public final CalamityMultipart leftcannon;
    public final CalamityMultipart mouth;
    public Hinderburg(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.lowerbody = new CalamityMultipart(this, "lowerbody", 4.0F, 4.0F);
        this.forwardbody = new CalamityMultipart(this, "forwardbody", 4.0F, 4.0F);
        this.rightcannon = new CalamityMultipart(this, "rightcannon", 1.5F, 1.5F);
        this.leftcannon = new CalamityMultipart(this, "leftcannon", 1.5F, 1.5F);
        this.mouth = new CalamityMultipart(this, "mouth", 3.0F, 0.5F);
        this.subEntities = new CalamityMultipart[]{ this.lowerbody, this.forwardbody,this.rightcannon,this.leftcannon,this.mouth};
        this.moveControl = new HindenMovementController(this );
        this.lookControl = new HindenLookControl(this);
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.length + 1) + 1);
    }

    @Override
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) {
        return false;
    }
    public void travel(Vec3 vec) {
        if (this.onGround()){
            this.setDeltaMovement(this.getDeltaMovement().add(0,0.1,0));
        }
        if (this.isEffectiveAi() && !this.onGround()) {
            this.moveRelative(0.1F, vec);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.95D));
        } else {
            super.travel(vec);
        }
    }

    @Override
    public boolean isNoGravity() {
        return true;
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
        if(this.getBomb() < 2450){
            this.setBomb(this.getBomb() +1);
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.hinden_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.FLYING_SPEED, 0.25)
                .add(Attributes.ARMOR, SConfig.SERVER.hinden_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.hinden_damage.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2);

    }

    @Override
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        if (calamityMultipart == this.mouth){
            this.hurt(source,value * 2f);
        }else if(calamityMultipart == this.rightcannon || calamityMultipart == this.leftcannon){
            this.level().explode(this,this.getX(),this.getY(),this.getZ(),2, Level.ExplosionInteraction.NONE);
            this.hurt(source,value * 1.5f);
        }else {
            this.hurt(source,value);
        }
        return true;
    }

    @Override
    public void chemAttack() {
        AABB boundingBox = this.getBoundingBox().inflate(32);
        List<Entity> entities = this.level().getEntities(this, boundingBox);
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity && !(entity instanceof Infected || entity instanceof UtilityEntity || SConfig.SERVER.blacklist.get().contains(entity.getEncodeId()) || livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() == Sitems.GAS_MASK.get())) {
                for (String str : SConfig.SERVER.hinden_debuffs.get()){
                    String[] string = str.split("\\|" );
                    MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(string[0]));
                    if (effect != null && !livingEntity.hasEffect(effect)){
                        livingEntity.addEffect(new MobEffectInstance(effect , Integer.parseUnsignedInt(string[1]), Integer.parseUnsignedInt(string[2])));
                    }
                }
            }else if (entity instanceof LivingEntity livingEntity && (entity instanceof Infected || entity instanceof UtilityEntity || SConfig.SERVER.blacklist.get().contains(entity.getEncodeId()))){
                for (String str : SConfig.SERVER.hinden_buffs.get()){
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
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this,1,true,2,4){
            @Override
            public boolean canUse() {
                return super.canUse() && this.mob.getTarget() != null && (!Hinderburg.this.hasLineOfSight(this.mob.getTarget())
                || this.mob.distanceToSqr(this.mob.getTarget()) < 10);
            }
        });
        this.goalSelector.addGoal(4,new NukeMob(this));
        this.goalSelector.addGoal(5,new AerialRangedGoal(this,1.3,40,16,3,8){
            @Override
            public boolean canUse() {
                return super.canUse() && !Hinderburg.this.isArmed();
            }
        });
        this.goalSelector.addGoal(6,new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7,new SummonScentInCombat(this));
        this.goalSelector.addGoal(8,new SporeBurstSupport(this));
        this.goalSelector.addGoal(9,new FlyingWanderAround(this,1));
        super.registerGoals();
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

        this.tickPart(this.forwardbody, (double)(f2 * -5F), 0.0D, (double)(f15 * 5F));
        this.tickPart(this.lowerbody, (double)(f2 * 5.0F), 0.0D, (double)(-f15 * 5.0F));
        this.tickPart(this.mouth, (double)(f2 * -0.5F), -0.5D, (double)(f15 * 0.5F));

        this.tickPart(this.rightcannon, (double)(f2 * -4F), 0.3D, (double)(f15 * -4F));
        this.tickPart(this.leftcannon, (double)(f2 * 4F), 0.3D, (double)(f15 * 4F));
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
    public int getDestroySpeed() {
        return SConfig.SERVER.hinden_block_damage.get();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(amount > SConfig.SERVER.hinden_dpsr.get() && SConfig.SERVER.hinden_dpsr.get() > 0){
            return super.hurt(source, (float) (SConfig.SERVER.hinden_dpsr.get() * 1F));
        }
        return super.hurt(source, amount);
    }

    private static class NukeMob extends Goal{
        private final Hinderburg mob;
        public NukeMob(Hinderburg mob){
            this.mob = mob;
        }
        @Override
        public boolean canUse() {
            return mob.getTarget() != null && mob.isArmed();
        }

        @Override
        public void tick() {
            super.tick();
            if (mob.getTarget() != null){
                this.mob.getNavigation().moveTo(mob.getTarget() ,1.5);
            }
        }

        @Override
        public void start() {
            super.start();
            if (mob.getTarget() != null){
                if (tryToSummonNUKE(mob.getTarget())){
                    mob.SummonNuke();
                }
            }
        }
        public  boolean tryToSummonNUKE(Entity entity){
            if (entity != null && this.mob.isArmed()){
                double x = Math.abs(entity.getX())  - Math.abs(this.mob.getX());
                double z = Math.abs(entity.getZ()) - Math.abs(this.mob.getZ());
                return entity.getY() < this.mob.getY() && (Math.abs(x) < 6) && (Math.abs(z) < 6);
            }
            return false;
        }
    }

    public void SummonNuke(){
        PrimedTnt tnt = new PrimedTnt(this.level(),this.getX(),this.getY(),this.getZ(),this);
        this.level().addFreshEntity(tnt);
        this.setBomb(0);
    }

    private static class HindenMovementController extends MoveControl{
        private final Hinderburg mob;
        private int floatDuration;

        public HindenMovementController(Hinderburg mob) {
            super(mob);
            this.mob = mob;
        }

        public void tick() {
            if (this.operation == MoveControl.Operation.MOVE_TO) {
                if (this.floatDuration-- <= 0) {
                    this.floatDuration += this.mob.getRandom().nextInt(4) + 2;
                    Vec3 vec3 = new Vec3(this.wantedX - this.mob.getX(), this.wantedY - this.mob.getY(), this.wantedZ - this.mob.getZ());
                    vec3 = vec3.normalize();
                    this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(vec3.scale(0.1D)));
                }

            }
            if (this.operation == Operation.WAIT){
                if (!this.hasWanted() && this.mob.getTarget() == null){
                    this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0,-0.01,0));
                }
            }
        }
    }


    private static class HindenLookControl extends LookControl{
        public HindenLookControl(Mob mob) {
            super(mob);
        }

        @Override
        public void tick() {
            super.tick();
            if (this.mob.getTarget() == null) {
                Vec3 vec3 = this.mob.getDeltaMovement();
                this.mob.setYRot(-((float)Mth.atan2(vec3.x, vec3.z)) * (180F / (float)Math.PI));
                this.mob.yBodyRot = this.mob.getYRot();
            } else {
                LivingEntity livingentity = this.mob.getTarget();
                if (livingentity.distanceToSqr(this.mob) < 4096.0D) {
                    double d1 = livingentity.getX() - this.mob.getX();
                    double d2 = livingentity.getZ() - this.mob.getZ();
                    this.mob.setYRot(-((float)Mth.atan2(d1, d2)) * (180F / (float)Math.PI));
                    this.mob.yBodyRot = this.mob.getYRot();
                }
            }
        }
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BOMB, 0);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("bomb", entityData.get(BOMB));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(BOMB, tag.getInt("bomb"));
    }
    public int getBomb(){
        return entityData.get(BOMB);
    }
    public void setBomb(int i){
        entityData.set(BOMB,i);
    }


    public boolean isArmed(){
        return this.getBomb() >= 2400;
    }


    @Override
    public boolean tryToDigDown() {
        return super.tryToDigDown() || this.verticalCollision;
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float p_33318_) {
        if(!level().isClientSide){
            ThrownTumor tumor = new ThrownTumor(level(), this);
            double dx = livingEntity.getX() - this.getX();
            double dy = livingEntity.getY() + livingEntity.getEyeHeight() - 1.5;
            double dz = livingEntity.getZ() - this.getZ();
            Vec3 vec3;
            if (random.nextFloat() < 0.5f){
                vec3 = (new Vec3(2D, 0.0D, 5D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            }else{
                vec3 = (new Vec3(2D, 0.0D, -5D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            }
            if (SConfig.SERVER.hinden_explosive_effects != null){
                List<? extends String> ev = SConfig.SERVER.hinden_explosive_effects.get();
                for (int i = 0; i < 1; ++i) {
                    int randomIndex = random.nextInt(ev.size());
                    ResourceLocation randomElement1 = new ResourceLocation(ev.get(randomIndex));
                    MobEffect randomElement = ForgeRegistries.MOB_EFFECTS.getValue(randomElement1);
                    tumor.setMobEffect(randomElement);
                }
            }
            tumor.setExplode(Level.ExplosionInteraction.MOB);
            tumor.moveTo(this.getX() +vec3.x(),this.getY()+1.3,this.getZ() + vec3.z());
            tumor.shoot(dx, dy - tumor.getY() + Math.hypot(dx, dz) * 0.05F, dz, 1f * 2, 12.0F);
            level().addFreshEntity(tumor);
            this.setDeltaMovement(this.getDeltaMovement().add(new Vec3(dx, dy, dz).normalize().scale(0.2D)));
        }
    }


    @Override
    public boolean doHurtTarget(Entity entity) {
        this.playSound(Ssounds.SIEGER_BITE.get());
        return super.doHurtTarget(entity);
    }
}
