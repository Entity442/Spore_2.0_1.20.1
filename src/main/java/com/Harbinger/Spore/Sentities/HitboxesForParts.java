package com.Harbinger.Spore.Sentities;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.world.item.ItemStack;

import java.util.Arrays;
import java.util.Comparator;

public enum HitboxesForParts {
    SIEGER_BODY(0,3.5f,4.5f,CALAMITY_TYPE.GROUND),
    SIEGER_JAW(1,1,1,CALAMITY_TYPE.GROUND),
    SIEGER_RIGHT_LEG(2,1.5f,2,CALAMITY_TYPE.GROUND),
    SIEGER_LEFT_LEG(3,1.5f,2,CALAMITY_TYPE.GROUND),
    SIEGER_BACK_RIGHT_LEG(4,1.75f,1.75f,CALAMITY_TYPE.GROUND),
    SIEGER_BACK_LEFT_LEG(5,1.75f,2,CALAMITY_TYPE.GROUND),
    SIEGER_TAIL(6,3f,1,CALAMITY_TYPE.GROUND),
    GAZEN_TAIL(7,2,2,CALAMITY_TYPE.WATER),
    GAZEN_HEAD(8,2,2,CALAMITY_TYPE.WATER),
    GAZEN_RIGHT_LEG(9,1.75f,1,CALAMITY_TYPE.WATER),
    GAZEN_LEFT_LEG(10,1.75f,1,CALAMITY_TYPE.WATER),
    LICKER(11,1,1,CALAMITY_TYPE.WATER),
    HINDEN_FRONT(12,3.5f,3.5f,CALAMITY_TYPE.AIR),
    HINDEN_BACK(13,3.5f,3.5f,CALAMITY_TYPE.AIR),
    MAW(14,3,1.5f,CALAMITY_TYPE.AIR),
    RIGHT_CANNON(15,1.5f,1,CALAMITY_TYPE.AIR),
    LEFT_CANNON(16,1.5f,1,CALAMITY_TYPE.AIR),
    HOWI_CANNON1(17,2f,3f,CALAMITY_TYPE.GROUND),
    HOWI_CANNON2(18,2f,3f,CALAMITY_TYPE.GROUND),
    HOWI_CANNON3(19,2f,3f,CALAMITY_TYPE.GROUND),
    HOWI_LEFT_LEG(20,1.5f,1.5f,CALAMITY_TYPE.GROUND),
    HOWI_RIGHT_LEG(21,2f,1f,CALAMITY_TYPE.GROUND),
    HOWI_LEFT_ARM(22,3,2,CALAMITY_TYPE.GROUND),
    HOWI_RIGHT_ARM(23,3,2,CALAMITY_TYPE.GROUND),
    HOWI_SACK(24,2,1,CALAMITY_TYPE.GROUND),
    HOHL_JAW(25,3,1.2f,CALAMITY_TYPE.GROUND),
    HOHL_HEAD(26,3,2.5f,CALAMITY_TYPE.GROUND),
    HOHL_SEG1(27,3,3,CALAMITY_TYPE.GROUND),
    HOHL_SEG2(28,3,3,CALAMITY_TYPE.GROUND),
    HOHL_SEG3(29,3,3,CALAMITY_TYPE.GROUND),
    HOHL_TAIL(30,3,3,CALAMITY_TYPE.GROUND),
    GRAKEN_BODY(31,3,3,CALAMITY_TYPE.WATER),
    GRAKEN_BACK_MAW(32,1,1,CALAMITY_TYPE.WATER),
    GRAKEN_FRONT_MAW(33,2,2,CALAMITY_TYPE.WATER),
    GRAKEN_HINGE(34,3,3,CALAMITY_TYPE.WATER),
    STAHL_RIGHT_LEG(35,2,1,CALAMITY_TYPE.GROUND),
    STAHL_LEFT_LEG(36,2,1,CALAMITY_TYPE.GROUND),
    STAHL_BLADE_ARM(37,5,3,CALAMITY_TYPE.GROUND),
    STAHL_ARM_ARM(38,4,1.5f,CALAMITY_TYPE.GROUND),
    STAHL_ARM_ARM2(39,4,1.5f,CALAMITY_TYPE.GROUND),
    STAHL_MOUTH(40,2,2,CALAMITY_TYPE.GROUND);

    private final int ID;
    private final float width;
    private final float height;
    private final CALAMITY_TYPE calamityType;
    private static final HitboxesForParts[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(HitboxesForParts::getID)).toArray(HitboxesForParts[]::new);
    HitboxesForParts(int id, float width, float height, CALAMITY_TYPE calamityType) {
        ID = id;
        this.width = width;
        this.height = height;
        this.calamityType = calamityType;
    }

    public int getID() {
        return ID;
    }

    public float getHeight() {
        return height;
    }
    public CALAMITY_TYPE getCalamityType(){return calamityType;}
    public float getWidth() {
        return width;
    }
    public static HitboxesForParts byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

    public enum CALAMITY_TYPE{
        GROUND(new ItemStack(Sitems.REFORGED_BIOMASS_T.get())),
        WATER(new ItemStack(Sitems.REFORGED_BIOMASS_W.get())),
        AIR(new ItemStack(Sitems.REFORGED_BIOMASS_A.get()));
        private final ItemStack stack;
        CALAMITY_TYPE(ItemStack stack) {
            this.stack = stack;
        }
        public ItemStack getStack() {
            return stack;
        }
    }
}
