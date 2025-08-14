package com.Harbinger.Spore.Sentities.AI.CalamitiesAI;

import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sblocks.CDUBlock;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
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
            calamity.playSound(Ssounds.SPORE_BURST.get());
            AABB boundingBox = calamity.getBoundingBox().inflate(trueCalamity.chemicalRange());
            sporeBurst(trueCalamity.buffs(),trueCalamity.debuffs(),boundingBox);
            killCDUs(boundingBox);
        }
        super.start();
    }
    private void killCDUs(AABB aabb){
        for(BlockPos blockpos : BlockPos.betweenClosed(
                Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ),
                Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            if (calamity.level().getBlockState(blockpos).is(Sblocks.CDU.get())){
                CDUBlock.replaceCDU(blockpos,calamity.level());
            }
        }
    }

    private void sporeBurst(List<? extends String> buffs,List<? extends String> debuffs,AABB boundingBox){
        calamity.playAmbientSound();
        List<Entity> entities = calamity.level().getEntities(calamity, boundingBox);
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity living){
                if (calamity.TARGET_SELECTOR.test(living) && !Utilities.helmetList().contains(living.getItemBySlot(EquipmentSlot.HEAD).getItem())){
                    applyEffects(living,debuffs);
                }
                if (living instanceof UtilityEntity || living instanceof Infected){
                    applyEffects(living,buffs);
                    if (living instanceof Infected infected){
                        infected.setKills(infected.getKills()+calamity.getRandom().nextInt(4));
                    }
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
