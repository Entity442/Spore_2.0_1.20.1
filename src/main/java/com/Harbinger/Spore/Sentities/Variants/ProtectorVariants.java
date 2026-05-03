package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum ProtectorVariants {
    DEFAULT(0,"default"),
    STUBBED(1,"spore.entity.variant.stubbed"),
    COLLECTOR(2,"spore.entity.variant.collector"),
    MOSS(3,"spore.entity.variant.moss"),
    BULK(4,"spore.entity.variant.bulk"),;

    private static final ProtectorVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ProtectorVariants::getId)).toArray(ProtectorVariants[]::new);
    private final int id;
    private final String name;

    ProtectorVariants(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName(){
        return name;
    }
    public static ProtectorVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
