package com.github.awdf.Test3;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class Store {
    private static final int MAX_KEY_LENGTH = 20;
    
    private final Map<Object, String> store;

    public Store() {
        this.store = new HashMap<>();
    }

    public String storeSecret(String key, String secret) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }

        if (key.length() > MAX_KEY_LENGTH) {
            throw new IllegalArgumentException("Key cannot exceed " + MAX_KEY_LENGTH + " characters");
        }

        String normalizedKey = key.toLowerCase(Locale.ROOT);
        store.put(normalizedKey, secret);
        return normalizedKey;
    }

    public Integer storeSecret(Integer key, String secret) {
        if (key == null || key <= 0) {
            throw new IllegalArgumentException("Key cannot be null or negative");
        }

        store.put(key, secret);
        return key;
    }

    public String getSecret(String key) {
        if (key == null || key.isEmpty()) {
            return null;
        }
        String normalizedKey = key.toLowerCase(Locale.ROOT);
        return store.get(normalizedKey);
    }

    public String getSecret(Integer key) {
        if (key == null || key <= 0) {
            return null;
        }
        return store.get(key);
    }

    public int size() {
        return store.size();
    }
}
