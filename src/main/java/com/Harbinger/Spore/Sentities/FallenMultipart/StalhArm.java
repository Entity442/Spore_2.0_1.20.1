package com.Harbinger.Spore.Sentities.FallenMultipart;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.BaseEntities.FallenMultipartEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

import java.util.List;

public class StalhArm extends FallenMultipartEntity {
    public StalhArm(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.sta_blade_loot.get();
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, (SConfig.SERVER.sta_hp.get()/4) * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, (SConfig.SERVER.sta_armor.get()/4) * SConfig.SERVER.global_armor.get())
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);
    }
}
