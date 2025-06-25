package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum VigilVariants {
    DEFAULT(0,"default"),
    STALKER(1,"spore.entity.variant.stalker"),
    TROLL(2,"spore.entity.variant.troll");

    private static final VigilVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(VigilVariants::getId)).toArray(VigilVariants[]::new);
    private final int id;
    private final String name;

    VigilVariants(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName(){
        return name;
    }
    public static VigilVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
