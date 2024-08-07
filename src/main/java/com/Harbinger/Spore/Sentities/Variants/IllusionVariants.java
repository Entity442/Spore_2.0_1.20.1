package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum IllusionVariants {
    KNIGHT(0, "spore:knight"),
    BRAIO(1, "spore:braiomil"),
    EVOKER(2, "spore:inf_evoker"),
    VOLATILE(3, "spore:volatile"),
    VINDI(4, "spore:inf_vindicator"),
    SCAMPER(5, "spore:scamper"),
    SLASHER(6, "spore:slasher"),
    LEAPER(7, "spore:leaper"),
    WENDIGO(8, "spore:wendigo"),
    GRIEFER(9, "spore:griefer"),
    GASTGABER(10, "spore:gastgaber"),
    BROTKATZE(11, "spore:brot"),
    INQUISITOR(12, "spore:inquisitor"),
    CREEPER(13, "minecraft:creeper");

    IllusionVariants(int variant, String entity){
        this.variant = variant;
        this.entity = entity;
    }
    private final int variant;
    private final String entity;


    public String getEntityValue(){
        return entity;
    }
    public int getVariant(){
        return variant;
    }
    private static final IllusionVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(IllusionVariants::getVariant)).toArray(IllusionVariants[]::new);

    public static IllusionVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
