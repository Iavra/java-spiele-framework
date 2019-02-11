package de.kibr.jsf.engine.modifier;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.engine.Particle;

public interface Initializer {
    void initialize(Emitter emitter, Particle target);
}
