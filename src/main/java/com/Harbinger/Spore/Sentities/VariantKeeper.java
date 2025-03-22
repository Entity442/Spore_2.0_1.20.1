package com.Harbinger.Spore.Sentities;

public interface VariantKeeper {
    int getTypeVariant();
    void setVariant(int i);
    default void increaseVariant(){
        setVariant(getTypeVariant()+1);
    }
    int amountOfMutations();
}
