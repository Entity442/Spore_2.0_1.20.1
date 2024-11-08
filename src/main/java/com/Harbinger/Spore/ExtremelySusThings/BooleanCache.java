package com.Harbinger.Spore.ExtremelySusThings;

import java.util.BitSet;
import java.util.function.Predicate;

/**
 * A simple Boolean Cache for better performance in areas where booleans are calculated and recalculated frequently.
 * Remembers prior visitors and returns the precomputed values associated with that visitor to save on performance.
 * @param <T> T is the type of object to be evaluated
 */
public class BooleanCache<T>{
    //Special thanks to WinVic the GOAT
    /**
     * @param memorySize The max amount of flags the Cache can remember before overwriting old values. Put it as a power of 2 for efficiency reasons
     * @param testPredicate The Predicate or method reference to evaluate the flag of the given object,
     *                      where the argument is T, as defined by the parameter of the Cache
     * @param nullFlag The value to return if the given object T is null when testing. Defaults to false
     */
    public BooleanCache(int memorySize, Predicate<T> testPredicate, boolean nullFlag){
        CACHE_MEMORY = memorySize;
        validityCache = new BitSet(CACHE_MEMORY);
        entityHashCache = new int[CACHE_MEMORY];

        this.TestPredicate = testPredicate;
        this.NullFlag = nullFlag;
    }
    /**
     * @param memorySize The max amount of flags the Cache can remember before overwriting old values. Put it as a power of 2 for efficiency reasons
     * @param testPredicate The Predicate or method reference to evaluate the flag of the given object,
     *                      where the argument is T, as defined by the parameter of the Cache
     */
    public BooleanCache(int memorySize, Predicate<T> testPredicate){
        CACHE_MEMORY = memorySize;
        validityCache = new BitSet(CACHE_MEMORY);
        entityHashCache = new int[CACHE_MEMORY];

        this.TestPredicate = testPredicate;
        this.NullFlag = false;
    }

    /**The value to return if the given object T is null when testing. Defaults to false*/
    public final boolean NullFlag;

    /**The memory of the cache (how much it can "remember" before overwriting old values)*/
    private final int CACHE_MEMORY;
    /**BitSets are most efficient for storing boolean values. Yummers*/
    private final BitSet validityCache;
    /**Store validated hashes to not recompute for returning visitors*/
    private final int[] entityHashCache;
    /**The index of the next hash to check and update. Circulatory, will overflow back to 0 upon reaching the Memory Cap and
     *  rewrite old values*/
    private int cacheIndex = 0;

    /**The predicate to evaluate the flag of the specified object, where T is the parameter defined in the declaration of the Cache*/
    private final Predicate<T> TestPredicate;

    /**
     * If the Cache has already evaluated the given Object T, checks the cache for the flag of that object.
     * <p>
     * Otherwise, tests the given object, updates the Cache with the new flag, and returns the flag.
     * @param t The object to test, where T is defined as the parameter of the Cache
     * @return The flag of the object from the Cache, or computes the flag and updates the Cache before returning
     */
    public boolean Test(T t) {
        int hash = System.identityHashCode(t);
        if (hash == 0 || t == null) return NullFlag;
        for (int i = 0; i < CACHE_MEMORY; i++) {
            if (entityHashCache[i] == hash) {
                return validityCache.get(i);
            }
        }
        boolean flag = TestPredicate.test(t);
        UpdateCache(flag, hash);
        return flag;
    }

    /**
     * Updates the Cache with the given values
     * @param result The flag to add to the Cache
     * @param hash the int Hashcode of the computed object to associate with the flag
     */
    private void UpdateCache(boolean result, int hash){
        entityHashCache[cacheIndex] = hash;
        validityCache.set(cacheIndex, result);
        cacheIndex = (cacheIndex + 1) % CACHE_MEMORY;
    }
}
