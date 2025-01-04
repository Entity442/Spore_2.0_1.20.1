package com.Harbinger.Spore.Sitems.Agents;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsBaseItem;
import net.minecraft.world.item.ItemStack;

public class HardeningAgent extends MutationAgents{
    public HardeningAgent() {
        super(20);
    }

    @Override
    public void mutateWeapon(ItemStack stack) {
        if (stack.getItem() instanceof SporeToolsBaseItem item){
            int i = SConfig.SERVER.agent_durability.get();
            item.setMaxAdditionalDurability(this.source.nextInt(i/2,i),stack);
        }
    }
}
