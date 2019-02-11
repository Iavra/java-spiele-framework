package de.kibr.jsf.util;

@FunctionalInterface
public interface Span<T extends Number> {
    T getValue();

    static <T extends Number> Span<T> fixed(T a) {
        return () -> a;
    }
}
