package com.Harbinger.Spore.Sitems.Agents;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsBaseItem;
import net.minecraft.world.item.ItemStack;

public class ConnectingAgent extends MutationAgents{
    public ConnectingAgent() {
        super(30);
    }

    @Override
    public void mutateWeapon(ItemStack stack) {
        if (stack.getItem() instanceof SporeToolsBaseItem item){
            int i = SConfig.SERVER.agent_enchantability.get();
            item.setLuck(this.source.nextInt(1,i),stack);
        }
    }
}
