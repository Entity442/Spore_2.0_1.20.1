package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Spotion;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedWallMovementControl;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.UseItemGoal;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
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
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mephetic extends EvolvedInfected implements RangedAttackMob {
    private final List<ItemStack> potions = new ArrayList<>();
    private int attackAnimationTick;
    private int throwAnimationTick;
    private int mouthAnimationTick;
    private int ticksBeforeThrown;
    public Mephetic(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.navigation = new WallClimberNavigation(this,level);
        this.moveControl = new InfectedWallMovementControl(this);
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
        this.goalSelector.addGoal(4, new UseItemGoal<>(this, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER_BREATHING), SoundEvents.WITCH_DRINK, (p_35882_) -> {
            return this.isInWater() && !this.hasEffect(MobEffects.WATER_BREATHING) && SConfig.SERVER.use_potions.get();
        }));
        this.goalSelector.addGoal(4,new DrinkPotionGoal<>(this,SoundEvents.WITCH_DRINK));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_mep_loot.get();
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
    private Potion getAttackPotion(){
        Random rand = new Random();
        List<? extends String> ev = SConfig.SERVER.mep_potions.get();
        int randomIndex = rand.nextInt(ev.size());
        ResourceLocation randomElement1 = new ResourceLocation(ev.get(randomIndex));
        Potion potion = ForgeRegistries.POTIONS.getValue(randomElement1);
        LivingEntity living = this.getTarget();
        if (living != null && living.getMobType().equals(MobType.UNDEAD)){
            if (potion == null){
                return Potions.HEALING;
            }else {
                if (potion.equals(Potions.HARMING)){
                    return Potions.HEALING;
                }
                if (potion.equals(Potions.POISON)){
                    return Spotion.MYCELIUM_POTION.get();
                }
            }
        }
        return potion == null ? Potions.HARMING : potion;
    }
    public void loadPotions(){
        potions.clear();
        for (int i = 0; i<3; i++){
            potions.add(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), getAttackPotion()));
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
        int u = random.nextInt(1,6);
        for(int i = 0;i<u;i++){
            lingeringPotionThrow(living,getAttackPotion());
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.mep_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.mep_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.mep_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32);

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
    public static class DrinkPotionGoal<T extends Mob> extends Goal {
        private final T mob;
        private final ItemStack item = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.HEALING);
        private final ItemStack strength = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRENGTH);
        private final ItemStack speed = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.SWIFTNESS);
        private final ItemStack stack = Math.random() < 0.5 ? strength.copy() : speed.copy();
        @Nullable
        private final SoundEvent finishUsingSound;

        public DrinkPotionGoal(T p_25972_, @Nullable SoundEvent p_25974_) {
            this.mob = p_25972_;
            this.finishUsingSound = p_25974_;
        }

        public boolean canUse() {
            return mob.getHealth() < mob.getMaxHealth();
        }

        public boolean canContinueToUse() {
            return this.mob.isUsingItem();
        }

        public void start() {
            this.mob.setItemSlot(EquipmentSlot.MAINHAND, this.item.copy());
            this.mob.startUsingItem(InteractionHand.MAIN_HAND);
            if (Math.random() < 0.3 ){
                mob.setItemSlot(EquipmentSlot.OFFHAND, stack);
            }
        }

        public void stop() {
            if (!this.mob.getOffhandItem().equals(ItemStack.EMPTY)){
                mob.addEffect(stack.equals(strength) ? new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600) :
                        new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600)  );
            }
            this.mob.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
            this.mob.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
            if (this.finishUsingSound != null) {
                this.mob.playSound(this.finishUsingSound, 1.0F, this.mob.getRandom().nextFloat() * 0.2F + 0.9F);
            }
        }
    }
}
