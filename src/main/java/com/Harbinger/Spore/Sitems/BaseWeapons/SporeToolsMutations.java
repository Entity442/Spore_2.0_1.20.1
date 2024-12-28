package com.Harbinger.Spore.Sitems.BaseWeapons;

import java.util.Arrays;
import java.util.Comparator;

public enum SporeToolsMutations {
    DEFAULT(0,-1,"default"),
    VAMPIRIC(1,-52429,"vampiric"),
    CALCIFIED(2,-103,"calcified"),
    BEZERK(3,-26368,"bezerk"),
    TOXIC(4, -16751104,"toxic"),
    ROTTEN(5,-6710887,"rotten");

    private final int id;
    private final int color;
    private final String name;

    SporeToolsMutations(int id, int color, String name) {
        this.id = id;
        this.color = color;
        this.name = name;
    }

    public int getId(){
        return id;
    }
    public int getColor(){
        return color;
    }

    public String getName() {
        return "spore.item.mutation."+name;
    }

    private static final SporeToolsMutations[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SporeToolsMutations::getId)).toArray(SporeToolsMutations[]::new);
    public static SporeToolsMutations byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
