package org.algorithms.others;

/*
Design and implement a data structure for the Least Recently Used (LRU) cache that supports the following operations:

    LRUCache(capacity: int): Initialize an LRU cache with the specified capacity.
    get(key: int) -> int: Return the value associated with a key. Return -1 if the key doesn't exist.
    put(key: int, value: int) -> None: Add a key and its value to the cache.

    If adding the key would result in the cache exceeding its size capacity, evict the least recently used element.
    If the key already exists in the cache, update its value.
*/
public class LRUCache {
    private final int[][] cache;
    public LRUCache(int capacity) {
        cache = new int[capacity][3];
        for (int i = 0; i < cache.length; i++)
            replace(i, -1, -1, 0);
    }

    public void put(int key, int value) {
        int i = 0;
        while(cache.length > i && cache[i][0] > -1) {
            if (cache[i][0] == key) {
                replace(i, key, value, cache[i][2]);
                return;
            }
            i++;
        }

        if (isFull()) {
            int lruIndex = 0;
            for (int j = 1; j < cache.length; j++) {
                if (cache[j][2] < cache[lruIndex][2]) lruIndex = j;
            }
            replace(lruIndex, key, value, 0);
        } else {
            replace(i, key, value, 0);
        }
    }

    public int get(int key) {
        for (int i = 0; i < cache.length; i++) {
            if (cache[i][0] == key) {
                incrementWeight(i);
                return cache[i][1];
            }
        }
        return -1;
    }

    public void replace(int idx, int key, int value, int weight) {
        cache[idx][0] = key;
        cache[idx][1] = value;
        cache[idx][2] = weight;
    }

    public void incrementWeight(int idx) {
        cache[idx][2]++;
    }

    public boolean isFull() {
        return cache[cache.length - 1][0] > -1;
    }
}
