package de.kibr.jsf.engine.modifier;

import de.kibr.jsf.engine.Easing;
import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.engine.Particle;
import de.kibr.jsf.util.Span;

public class Life implements Initializer, Behaviour {
    private final Span<Integer> life;
    private final Easing easing;

    public Life(Span<Integer> life, Easing easing) {
        this.life = life;
        this.easing = easing;
    }

    @Override
    public void initialize(Emitter emitter, Particle target) {
        target.life = life.getValue();
    }

    @Override
    public void apply(Emitter emitter, Particle target, int index) {
        target.energy = target.dead ? 0 : 1 - (float) easing.ease((float) target.age / target.life);
    }
}
