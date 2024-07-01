package com.Harbinger.Spore.Sitems;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public enum SpawnEggType {
    INFECTED("spore.name.infected"),
    EVOLVED("spore.name.evolved"),
    HYPER("spore.name.hyper"),
    ORGANOID("spore.name.organoid"),
    CALAMITY("spore.name.calamity"),
    EXPERIMENT("spore.name.experiment"),
    UNKNOWN("spore.name.unknown");
    private final Component component;
    SpawnEggType(String string){
        component = Component.translatable(string).withStyle(ChatFormatting.GOLD);
    }

    public Component getName(){
        return component;
    }
}
