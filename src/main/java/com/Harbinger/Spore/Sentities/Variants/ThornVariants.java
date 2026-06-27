package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum ThornVariants {
    DEFAULT(0,"default"),
    TOXIC(1,"spore.entity.variant.laced"),
    CACTUS(2,"spore.entity.variant.cactus"),
    SKEWER(3,"spore.entity.variant.skewer"),
    ROLLER(4,"spore.entity.variant.roller");


    private static final ThornVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ThornVariants::getId)).toArray(ThornVariants[]::new);
    private final int id;
    private final String name;

    ThornVariants(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public int getId() {
        return this.id;
    }

    public static ThornVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
