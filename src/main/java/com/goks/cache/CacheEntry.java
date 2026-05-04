package com.goks.cache;

import lombok.Getter;

public class CacheEntry<T> {

    @Getter
    private final T value;
    private final long expiryTime;

    public CacheEntry(T value, long ttl) {
        this.value = value;
        this.expiryTime = ttl + System.currentTimeMillis();
    }

    public boolean isExpired(){
        return System.currentTimeMillis() > expiryTime;
    }
}
