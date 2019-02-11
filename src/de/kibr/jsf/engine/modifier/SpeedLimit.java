package de.kibr.jsf.engine.modifier;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.engine.Particle;

public class SpeedLimit implements Behaviour {
    private final float min;
    private final float max;
    private final float minSq;
    private final float maxSq;

    public SpeedLimit(float min, float max) {
        this.min = min;
        this.max = max;
        minSq = min * min;
        maxSq = max * max;
    }

    @Override
    public void apply(Emitter emitter, Particle target, int index) {
        float speedSq = target.velocity.lengthSquared();
        if (speedSq < minSq)
            target.velocity.scale(min / (float) Math.sqrt(speedSq));
        if (speedSq > maxSq)
            target.velocity.scale(max / (float) Math.sqrt(speedSq));
    }
}
