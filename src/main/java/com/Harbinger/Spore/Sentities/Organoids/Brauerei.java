package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class Brauerei extends Organoid {
    public Brauerei(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    public int getEmerge_tick() {
        return 200;
    }

    @Override
    public int getBorrow_tick() {
        return 200;
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.umarmed_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.umarmed_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.umarmed_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 20)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    public int getColor(){
        return 12738912;
    }
}
