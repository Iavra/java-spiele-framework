package de.kibr.jsf.engine;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Supplier;

public class Pool {
    private final Queue<Particle> cache = new LinkedList<>();
    private final Supplier<Particle> create;

    public Pool() {
        this(Particle::new);
    }

    public Pool(Supplier<Particle> create) {
        this.create = Objects.requireNonNull(create);
    }

    public Particle create() {
        return cache.isEmpty() ? create.get() : cache.remove();
    }

    public void dispose(Particle particle) {
        particle.reset();
        cache.add(particle);
    }

    public void clear() {
        cache.clear();
    }
}
