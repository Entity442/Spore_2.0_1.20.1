package com.Harbinger.Spore.Sentities.Experiments;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Experiment;
import com.Harbinger.Spore.Sentities.Projectile.AcidBall;
import com.Harbinger.Spore.Sentities.Projectile.BileProjectile;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;

import java.util.List;

public class Biobloob extends Experiment implements RangedAttackMob {
    public Biobloob(EntityType<? extends Monster> type, Level level) {
        super(type, level);

    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.lacerator_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FLYING_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.lacerator_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.lacerator_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 30)
                .add(Attributes.ATTACK_KNOCKBACK, 1);
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.lacerator_loot.get();
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 6.0 + entity.getBbWidth() * entity.getBbWidth();}});
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }
    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        if (!level().isClientSide){
            if (Math.random() <= 0.5){
                BileProjectile bileProjectile = new BileProjectile(level(),this,TARGET_SELECTOR);
                double dx = livingEntity.getX() - this.getX();
                double dy = livingEntity.getY() + livingEntity.getEyeHeight() - 1;
                double dz = livingEntity.getZ() - this.getZ();
                bileProjectile.setDamage((float) (SConfig.SERVER.spit_damage_l.get()*1f));
                bileProjectile.moveTo(this.getX(),this.getY()+1.5,this.getZ());
                bileProjectile.shoot(dx, dy - bileProjectile.getY() + Math.hypot(dx, dz) * 0.05F, dz, 1f * 2, 12.0F);
                level().addFreshEntity(bileProjectile);
            }else {
                AcidBall.shoot(this, livingEntity,(float) (SConfig.SERVER.spit_damage_l.get() * SConfig.SERVER.global_damage.get()));
                this.playSound(SoundEvents.SLIME_JUMP, 1, 0.5f);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount % 60 == 0){
            LivingEntity living = getTarget();
            if (living != null){
                performRangedAttack(living,0);
            }
        }
    }
    @Override
    public void aiStep() {
        super.aiStep();
    }

}
