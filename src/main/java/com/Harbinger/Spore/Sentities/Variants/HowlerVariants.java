package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum HowlerVariants {
    DEFAULT(0,"default"),
    BANSHEE(1,"spore.entity.variant.banshee"),
    SONIC(2,"spore.entity.variant.sonic");

    private static final HowlerVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(HowlerVariants::getId)).toArray(HowlerVariants[]::new);
    private final int id;
    private final String name;

    HowlerVariants(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName(){
        return name;
    }
    public static HowlerVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
