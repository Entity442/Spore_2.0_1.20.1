package com.Harbinger.Spore.Sentities.AI.CalamitiesAI;

import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class SporeBurstSupport extends Goal {
    private final Calamity calamity;

    public SporeBurstSupport(Calamity calamity){
        this.calamity = calamity;
    }

    @Override
    public boolean canUse() {
        return this.calamity.isAlive() && this.calamity.getRandom().nextInt(300) == 0  && calamity.getTarget() != null && this.calamity.distanceToSqr(this.calamity.getTarget())<200.0D;
    }

    @Override
    public void start() {
        this.calamity.setStun(60);
        if (calamity instanceof TrueCalamity trueCalamity){
            sporeBurst(trueCalamity.buffs(),trueCalamity.debuffs(),trueCalamity.chemicalRange());
        }
        super.start();
    }

    private void sporeBurst(List<? extends String> buffs,List<? extends String> debuffs,int range){
        AABB boundingBox = calamity.getBoundingBox().inflate(range);
        List<Entity> entities = calamity.level().getEntities(calamity, boundingBox);
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity living){
                if (calamity.TARGET_SELECTOR.test(living)){
                    applyEffects(living,debuffs);
                }
                if (living instanceof UtilityEntity || living instanceof Infected){
                    applyEffects(living,buffs);
                }
            }
        }
    }
    private void applyEffects(LivingEntity living,List<? extends String> effects){
        if (!effects.isEmpty()){
            for (String str : effects){
                String[] string = str.split("\\|" );
                MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(string[0]));
                if (effect != null && !living.hasEffect(effect)){
                    living.addEffect(new MobEffectInstance(effect , Integer.parseUnsignedInt(string[1]), Integer.parseUnsignedInt(string[2])));
                }
            }
        }
    }

}
