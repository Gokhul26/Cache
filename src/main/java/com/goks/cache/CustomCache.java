package com.goks.cache;

import java.util.concurrent.ConcurrentHashMap;

public class CustomCache<T> {

    private final ConcurrentHashMap<String, CacheEntry<T>> cache = new ConcurrentHashMap<>();

    void put(String key, T value, long ttl){
        cache.put(key, new CacheEntry<>(value, ttl));
    }

    T get(String key){
        CacheEntry<T> entry = cache.get(key);

        if(entry == null){
            return null;
        }
        if(entry.isExpired()){
            cache.remove(key);
            return null;
        }
        return entry.getValue();
    }
}
