package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum ChemistVariants {
    DEFAULT(0,"default"),
    MECHANIC(1,"spore.entity.variant.mechanic"),
    FUMING(2,"spore.entity.variant.fuming"),
    BURST(3,"spore.entity.variant.burst"),
    SPREADER(4,"spore.entity.variant.spreader");

    private static final ChemistVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ChemistVariants::getId)).toArray(ChemistVariants[]::new);
    private final int id;
    private final String name;

    ChemistVariants(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName(){
        return name;
    }
    public static ChemistVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
