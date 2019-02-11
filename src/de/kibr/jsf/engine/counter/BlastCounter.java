package de.kibr.jsf.engine.counter;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.util.Span;

public class BlastCounter extends BaseCounter {
    private final Span<Integer> count;

    public BlastCounter(Span<Integer> count) {
        this.count = count;
    }

    @Override
    public int start(Emitter emitter) {
        return this.count.getValue();
    }
}
