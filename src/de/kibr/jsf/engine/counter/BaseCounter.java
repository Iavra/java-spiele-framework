package de.kibr.jsf.engine.counter;

import de.kibr.jsf.engine.Emitter;

public abstract class BaseCounter implements Counter {
    @Override
    public int start(Emitter emitter) {
        return 0;
    }

    @Override
    public int update(Emitter emitter) {
        return 0;
    }
}
