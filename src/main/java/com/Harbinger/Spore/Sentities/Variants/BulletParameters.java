package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum BulletParameters {
    INFECTIOUS(0,-10092544, 8),
    EXPLOSIVE(1, -13434880, 6),
    CORROSIVE(2,-13382656, 8),
    FLAMMABLE(3,-26368, 12);


    private static final BulletParameters[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(BulletParameters::getId)).toArray(BulletParameters[]::new);
    private final int id;
    private final int particle;
    private final float damage;

    BulletParameters(int id, int particle, float damage) {
        this.id = id;
        this.particle = particle;
        this.damage = damage;
    }
    public int getParticle(){
        return this.particle;
    }
    public float getDamage(){
        return this.damage;
    }

    public int getId() {
        return this.id;
    }

    public static BulletParameters byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
