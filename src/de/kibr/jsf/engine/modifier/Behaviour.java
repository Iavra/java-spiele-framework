package de.kibr.jsf.engine.modifier;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.engine.Particle;

public interface Behaviour {
    void apply(Emitter emitter, Particle target, int index);
}
