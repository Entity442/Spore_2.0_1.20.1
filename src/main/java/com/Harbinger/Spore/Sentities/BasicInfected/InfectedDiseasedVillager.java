package com.Harbinger.Spore.Sentities.BasicInfected;

import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.Utility.Reaper;
import com.Harbinger.Spore.Sentities.Variants.ScamperVariants;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import java.util.List;

public class InfectedDiseasedVillager extends InfectedVillager{
    public InfectedDiseasedVillager(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.POISON,200,0));
            living.addEffect(new MobEffectInstance(MobEffects.CONFUSION,200,0));
        }
        return super.doHurtTarget(entity);
    }

    @Override
    public void Evolve(Infected livingEntity, List<? extends String> value, ScamperVariants variants) {
        if (this.getLinked()){
            Reaper reaper = new Reaper(Sentities.REAPER.get(),level());
            reaper.setBiomass(this.getKills() + this.getEvoPoints());
            reaper.setCustomName(this.getCustomName());
            reaper.moveTo(this.getX(),this.getY(),this.getZ());
            level().addFreshEntity(reaper);
            this.discard();
            if (level() instanceof ServerLevel serverLevel){
                double x0 = livingEntity.getX() - (random.nextFloat() - 0.1) * 0.1D;
                double y0 = livingEntity.getY() + (random.nextFloat() - 0.25) * 0.15D * 5;
                double z0 = livingEntity.getZ() + (random.nextFloat() - 0.1) * 0.1D;
                serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 2, 0, 0, 0, 1);
            }
        }else {
            super.Evolve(livingEntity, value, variants);
        }
    }
}
