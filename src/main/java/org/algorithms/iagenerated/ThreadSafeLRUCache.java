package org.algorithms.iagenerated;

import java.util.LinkedHashMap;
import java.util.Map;

public class ThreadSafeLRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;

    public ThreadSafeLRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > ThreadSafeLRUCache.this.capacity;
            }
        };
    }

    public synchronized V get(K key) {
        return cache.get(key);
    }

    public synchronized void put(K key, V value) {
        cache.put(key, value);
    }

    public synchronized void remove(K key) {
        cache.remove(key);
    }

    public synchronized int size() {
        return cache.size();
    }

    @Override
    public synchronized String toString() {
        return cache.toString();
    }

    public static void main(String[] args) {
        ThreadSafeLRUCache<Integer, String> cache = new ThreadSafeLRUCache<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println(cache); // {1=A, 2=B, 3=C}

        cache.get(1);  // Access key 1
        cache.put(4, "D"); // Evicts key 2 (Least Recently Used)
        System.out.println(cache); // {3=C, 1=A, 4=D}
    }
}
