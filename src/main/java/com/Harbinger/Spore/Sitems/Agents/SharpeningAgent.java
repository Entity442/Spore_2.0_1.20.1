package com.Harbinger.Spore.Sitems.Agents;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsBaseItem;
import net.minecraft.world.item.ItemStack;

public class SharpeningAgent extends MutationAgents{
    public SharpeningAgent() {
        super(25);
    }

    @Override
    public void mutateWeapon(ItemStack stack) {
        if (stack.getItem() instanceof SporeToolsBaseItem item){
            int i = SConfig.SERVER.agent_damage.get();
            item.setAdditionalDamage(this.source.nextInt(i/2,i),stack);
        }
    }
}
