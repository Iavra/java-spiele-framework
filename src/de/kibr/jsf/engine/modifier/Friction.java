package de.kibr.jsf.engine.modifier;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.engine.Particle;

public class Friction implements Behaviour {
    private final float friction;

    public Friction(float friction) {
        this.friction = friction;
    }

    @Override
    public void apply(Emitter emitter, Particle target, int index) {
        float lengthSq = target.velocity.lengthSquared();
        if(lengthSq == 0) { return; }
        float scale = 1 - friction / (float) Math.sqrt(lengthSq);
        if(scale <= 0)
            target.velocity.set(0, 0);
        else
            target.velocity.scale(scale);
    }
}
