package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sitems.BaseWeapons.DamagePiercingModifier;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsBaseItem;

public class InfectedMace extends SporeToolsBaseItem implements DamagePiercingModifier {
    public InfectedMace() {
        super(SConfig.SERVER.mace_damage.get(), 2f, 3, SConfig.SERVER.mace_durability.get(), 1);
    }

    @Override
    public float getMinimalDamage(float damage) {
        return SConfig.SERVER.mace_damage.get() * 0.15f;
    }

    @Override
    public boolean doesExtraKnockBack() {
        return true;
    }
}
