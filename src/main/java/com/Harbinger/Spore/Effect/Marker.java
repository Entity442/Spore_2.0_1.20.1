package com.Harbinger.Spore.Effect;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.extensions.IForgeMobEffect;

import java.util.ArrayList;
import java.util.List;

public class Marker extends MobEffect implements IForgeMobEffect {
    public Marker() {
        super(MobEffectCategory.NEUTRAL, 8412043);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        MobEffectInstance instance = pLivingEntity.getEffect(Seffects.MARKER.get());
        if (instance == null){
            return;
        }
        int j = instance.getDuration();
        if (!(pLivingEntity instanceof Infected || pLivingEntity instanceof UtilityEntity)){
        AABB boundingBox = pLivingEntity.getBoundingBox().inflate(16 * (pAmplifier + 1));
        List<Entity> entities = pLivingEntity.level().getEntities(pLivingEntity, boundingBox);

        for (Entity entity : entities) {
            if(entity instanceof Infected livingEntity) {
                livingEntity.addEffect( new MobEffectInstance(Seffects.MARKER.get() , j * 2,pAmplifier + 1, false,false));
            }
        }
        }
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> ret = new ArrayList<>();
        ret.add(ItemStack.EMPTY);
        return ret;
    }

    public boolean isDurationEffectTick(int duration, int intensity) {
        if (this == Seffects.MARKER.get()) {
            int i = 80 >> intensity;
            if (i > 0) {
                return duration % i == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
