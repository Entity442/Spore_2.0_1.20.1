package com.Harbinger.Spore.Sitems.Agents;

import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorData;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeWeaponData;
import com.Harbinger.Spore.Core.SConfig;
import net.minecraft.world.item.ItemStack;

public class ConnectingAgent extends MutationAgents{
    public ConnectingAgent() {
        super(30);
    }

    @Override
    public void mutateWeapon(ItemStack stack) {
        if (stack.getItem() instanceof SporeWeaponData item){
            int i =1+ SConfig.SERVER.agent_enchantability.get();
            if (i > 2){
                item.setLuck(this.source.nextInt(1,i),stack);
            }
        }
        if (stack.getItem() instanceof SporeArmorData item){
            int i =1+ SConfig.SERVER.agent_enchantability.get();
            if (i > 2){
                item.setLuck(this.source.nextInt(1,i),stack);
            }
        }
    }
}
