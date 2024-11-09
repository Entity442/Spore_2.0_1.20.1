package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum SpitterVariants {
    DEFAULT(0,"default"),
    EXPLOSIVE(1,"spore.entity.variant.bomber"),
    BILE(2,"spore.entity.variant.bile");

    private static final SpitterVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SpitterVariants::getId)).toArray(SpitterVariants[]::new);
    private final int id;
    private final String name;
    SpitterVariants(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getId() {
        return this.id;
    }

    public static SpitterVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
