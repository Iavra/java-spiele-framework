package de.kibr.jsf.engine.modifier;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.engine.Particle;
import org.newdawn.slick.geom.Vector2f;

public class Force implements Behaviour {
    private final Vector2f force;

    public Force(Vector2f force) {
        this.force = force;
    }

    @Override
    public void apply(Emitter emitter, Particle target, int index) {
        target.velocity.add(force);
    }
}
