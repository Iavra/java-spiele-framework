package de.kibr.jsf.engine.modifier;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.engine.Particle;
import org.newdawn.slick.geom.Vector2f;

public class RandomDrift implements Behaviour {
    private final float x;
    private final float y;

    public RandomDrift(float x, float y) {
        this.x = x * 2;
        this.y = y * 2;
    }

    @Override
    public void apply(Emitter emitter, Particle target, int index) {
        target.velocity.add(new Vector2f(
                (float) (Math.random() - 0.5) * x,
                (float) (Math.random() - 0.5) * x));
    }
}
