package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class Inebriator extends EvolvedInfected {
    public Inebriator(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    private LivingEntity patient;
    public void setPatient(LivingEntity patient){
        this.patient = patient;
    }
    public LivingEntity getPatient(){
        return this.patient;
    }

    public void checkForPatients(){
        Level level = this.level();
        if (!level.isClientSide()){
            AABB aabb = this.getBoundingBox().inflate(4,1,4);
            List<Entity> entities = level.getEntities(this,aabb, entity -> {return entity instanceof LivingEntity livingEntity
             && (livingEntity instanceof Infected || livingEntity instanceof UtilityEntity);});
            if (entities.isEmpty()){return;}
            Entity entity = entities.get(random.nextInt(entities.size()));
            if (entity instanceof LivingEntity livingEntity){setPatient(livingEntity);}
        }
    }

    public void InjectMedicine(List<MobEffectInstance> effects){
        LivingEntity entity = this.getPatient();
        if (entity != null){
            for (MobEffectInstance instance : effects){
                entity.addEffect(instance);
            }
        }
    }
}
