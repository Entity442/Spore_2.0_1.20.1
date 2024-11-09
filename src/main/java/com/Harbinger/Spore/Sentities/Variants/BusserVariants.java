package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum BusserVariants {
    DEFAULT(0,"default"),
    ENHANCED(1,"spore.entity.variant.kidnapper"),
    BOMBER(2,"spore.entity.variant.kamikaze"),
    TOXIC(3,"spore.entity.variant.noxious");

    private static final BusserVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(BusserVariants::getId)).toArray(BusserVariants[]::new);
    private final int id;
    private final String name;

    BusserVariants(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public int getId() {
        return this.id;
    }

    public static BusserVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
