package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum InfPlayerSkins {
    STEVE(0),
    ALEX(1),
    EFE(2),
    MAKENA(3),
    SUNNY(4),
    ZURI(5),
    ARI(6),
    KAI(7),
    NO0R(8);

    private static final InfPlayerSkins[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(InfPlayerSkins::getId)).toArray(InfPlayerSkins[]::new);
    private final int id;

    InfPlayerSkins(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    public static InfPlayerSkins byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
