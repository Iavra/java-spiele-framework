package de.kibr.jsf.engine.modifier;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.engine.Particle;
import de.kibr.jsf.util.Span;
import de.kibr.jsf.util.Util;

public class PolarVelocity implements Initializer {
    private final Span<Float> radius;
    private final Span<Float> angle;

    public PolarVelocity(Span<Float> radius, Span<Float> angle) {
        this.radius = radius;
        this.angle = angle;
    }

    @Override
    public void initialize(Emitter emitter, Particle target) {
        target.velocity.add(Util.polarVector(radius.getValue(), angle.getValue()));
    }
}
