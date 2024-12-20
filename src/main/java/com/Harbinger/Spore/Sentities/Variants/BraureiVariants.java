package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum BraureiVariants {
    DEFAULT(0,"default"),
    HAZARD(1,"spore.entity.variant.hazard");

    private static final BraureiVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(BraureiVariants::getId)).toArray(BraureiVariants[]::new);
    private final int id;
    private final String name;

    BraureiVariants(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName(){
        return name;
    }
    public static BraureiVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
