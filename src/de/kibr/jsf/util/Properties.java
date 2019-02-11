package de.kibr.jsf.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Typesafe heterogenous container based on Effective Java, item #29
 */
public class Properties {
    private Map<Key<?>, Object> items = new HashMap<>();

    public <T> void put(Key<T> key, T value) {
        items.put(Objects.requireNonNull(key), key.cast(value));
    }

    public <T> T get(Key<T> key) {
        return key.cast(items.get(key));
    }

    public void clear() {
        items.clear();
    }

    public static class Key<T> {
        private final Class<T> type;

        public Key(Class<T> type) {
            this.type = type;
        }

        T cast(Object value) {
            return value == null ? null : type.cast(value);
        }
    }
}
