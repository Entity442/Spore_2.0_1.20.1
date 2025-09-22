package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.UseItemGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class Mephetic extends EvolvedInfected implements RangedAttackMob {
    private final List<ItemStack> potions = new ArrayList<>();
    private int attackAnimationTick;
    private int throwAnimationTick;
    private int mouthAnimationTick;
    private int ticksBeforeThrown;
    public Mephetic(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 6.0 + entity.getBbWidth() * entity.getBbWidth();}});
        this.goalSelector.addGoal(4, new UseItemGoal<>(this, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_FIRE_RESISTANCE), SoundEvents.WITCH_DRINK, (p_35882_) -> {
            return this.isOnFire() && !this.hasEffect(MobEffects.FIRE_RESISTANCE) && SConfig.SERVER.use_potions.get();
        }));
        this.goalSelector.addGoal(4, new UseItemGoal<>(this, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.HEALING), SoundEvents.WITCH_DRINK, (p_35882_) -> {
            return this.getHealth() < getMaxHealth() && SConfig.SERVER.use_potions.get();
        }));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_volatile_loot.get();
    }
    public void defineSynchedData() {
        super.defineSynchedData();
    }
    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
        }else if (value == 5) {
            this.mouthAnimationTick = 10;
        }else if (value == 6) {
            this.throwAnimationTick = 10;
        } else {
            super.handleEntityEvent(value);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(entity);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
        if (this.throwAnimationTick > 0) {
            --this.throwAnimationTick;
        }
        if (this.mouthAnimationTick > 0) {
            --this.mouthAnimationTick;
        }
        if (this.ticksBeforeThrown <= 80) {
            ++this.ticksBeforeThrown;
        }
    }
    public int getAttackAnimationTick(){return attackAnimationTick;}
    public int getThrowAnimationTick(){return throwAnimationTick;}
    public int getMouthAnimationTick(){return mouthAnimationTick;}

    @Override
    public void tick() {
        super.tick();
        if (ticksBeforeThrown == 40){
            loadPotions();
        }
        LivingEntity living = this.getTarget();
        if(ticksBeforeThrown >= 79){
            if (living != null && hasLineOfSight(living) && living.distanceToSqr(this) > 20){
                throwPotions(living);
            }
        }
        if (tickCount % 200 == 0){
            if (living != null && hasLineOfSight(living) && living.distanceToSqr(this) > 60){
                throwLingeringPotions(living);
            }
        }
    }

    public void loadPotions(){
        potions.clear();
        for (int i = 0; i<3; i++){
            Potion potion = Math.random() < 0.5 ? Potions.HARMING : Potions.POISON;
            potions.add(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), potion));
        }
    }
    public void throwPotions(LivingEntity living){
        this.throwAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte) 6);
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.WITCH_THROW, this.getSoundSource(), 1.0F, 0.8F + this.random.nextFloat() * 0.4F);
        for(int i = 0;i<potions.size();i++){
            performRangedAttack(living,i);
        }
        potions.clear();
        ticksBeforeThrown = 0;
    }
    public void throwLingeringPotions(LivingEntity living){
        this.mouthAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte) 5);
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.WITCH_THROW, this.getSoundSource(), 1.0F, 0.8F + this.random.nextFloat() * 0.4F);
        for(int i = 0;i<random.nextInt(1,5);i++){
            lingeringPotionThrow(living,Potions.AWKWARD);
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.vola_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.vola_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.vola_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }
    public List<ItemStack> getPotions(){
        return potions;
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.WITCH_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float v) {
        Potion potion = PotionUtils.getPotion(potions.get((int) v));
        Vec3 vec3 = entity.getDeltaMovement();
        double d0 = entity.getX() + vec3.x - this.getX();
        double d1 = entity.getEyeY() - (double)1.1F - this.getY();
        double d2 = entity.getZ() + vec3.z - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        ThrownPotion thrownpotion = new ThrownPotion(this.level(), this);
        thrownpotion.setItem(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), potion));
        thrownpotion.setXRot(thrownpotion.getXRot() - -20.0F);
        thrownpotion.shoot(d0, d1 + d3 * 0.2D, d2, 0.75F, 8.0F);
        this.level().addFreshEntity(thrownpotion);
    }
    public void lingeringPotionThrow(LivingEntity entity, Potion potion) {
        Vec3 vec3 = entity.getDeltaMovement();
        double d0 = entity.getX() + vec3.x - this.getX();
        double d1 = entity.getEyeY() - (double)1.1F - this.getY();
        double d2 = entity.getZ() + vec3.z - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        ThrownPotion thrownpotion = new ThrownPotion(this.level(), this);
        thrownpotion.setItem(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), potion));
        thrownpotion.setXRot(thrownpotion.getXRot() - -20.0F);
        thrownpotion.shoot(d0, d1 + d3 * 0.4D, d2, 1F, 8.0F);
        this.level().addFreshEntity(thrownpotion);
    }
}
