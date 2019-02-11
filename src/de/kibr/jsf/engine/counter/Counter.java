package de.kibr.jsf.engine.counter;

import de.kibr.jsf.engine.Emitter;

public interface Counter {
    int start(Emitter emitter);
    int update(Emitter emitter);
}
