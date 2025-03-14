package org.algorithms.iagenerated;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockLRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final ReentrantLock lock = new ReentrantLock();

    public ReentrantLockLRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > ReentrantLockLRUCache.this.capacity;
            }
        };
    }

    public V get(K key) {
        lock.lock();
        try {
            return cache.get(key);
        } finally {
            lock.unlock();
        }
    }

    public void put(K key, V value) {
        lock.lock();
        try {
            cache.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public void remove(K key) {
        lock.lock();
        try {
            cache.remove(key);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return cache.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        lock.lock();
        try {
            return cache.toString();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockLRUCache<Integer, String> cache = new ReentrantLockLRUCache<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println(cache); // {1=A, 2=B, 3=C}

        cache.get(1);  // Access key 1
        cache.put(4, "D"); // Evicts key 2 (Least Recently Used)
        System.out.println(cache); // {3=C, 1=A, 4=D}
    }
}
