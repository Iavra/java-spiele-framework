package de.kibr.jsf.engine.modifier;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.engine.Particle;
import de.kibr.jsf.util.Span;
import org.newdawn.slick.geom.Vector2f;

public class Velocity implements Initializer {
    private final Span<Float> x;
    private final Span<Float> y;

    public Velocity(Span<Float> x, Span<Float> y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void initialize(Emitter emitter, Particle target) {
        target.velocity.add(new Vector2f(x.getValue(), y.getValue()));
    }
}
