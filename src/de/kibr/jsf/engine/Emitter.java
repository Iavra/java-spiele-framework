package de.kibr.jsf.engine;

import de.kibr.jsf.engine.counter.Counter;
import de.kibr.jsf.engine.modifier.Activity;
import de.kibr.jsf.engine.modifier.Behaviour;
import de.kibr.jsf.engine.modifier.Initializer;

import java.util.ArrayList;
import java.util.List;

public class Emitter extends Particle {
    private final Counter counter;
    private final Pool pool;
    private final List<Particle> children = new ArrayList<>();

    private final List<Activity> activities = new ArrayList<>();
    private final List<Initializer> initializers = new ArrayList<>();
    private final List<Behaviour> behaviours = new ArrayList<>();

    private boolean started = false;
    private boolean running = false;

    public Emitter(Counter counter, Pool pool) {
        this.counter = counter;
        this.pool = pool;
    }

    public Emitter(Counter counter) {
        this(counter, new Pool());
    }

    public Emitter addModifier(Object modifier) {
        if (modifier instanceof Activity)
            activities.add((Activity) modifier);
        if (modifier instanceof Initializer)
            initializers.add((Initializer) modifier);
        if (modifier instanceof Behaviour)
            behaviours.add((Behaviour) modifier);
        return this;
    }

    public Emitter addModifiers(Object... modifiers) {
        for (Object modifier : modifiers)
            addModifier(modifier);
        return this;
    }

    public Emitter removeModifier(Object modifier) {
        if (modifier instanceof Activity)
            activities.remove(modifier);
        if (modifier instanceof Initializer)
            initializers.remove(modifier);
        if (modifier instanceof Behaviour)
            behaviours.remove(modifier);
        return this;
    }

    public Emitter removeAllModifiers() {
        initializers.clear();
        behaviours.clear();
        return this;
    }

    public Emitter start() {
        if (!started) {
            started = running = true;
            for (int i = 0, max = counter.start(this); i < max; i++)
                createParticle();
        }
        return this;
    }

    public Emitter stop() {
        running = false;
        return this;
    }

    public Emitter resume() {
        if (started)
            running = true;
        return this;
    }

    public Emitter skip(int count) {
        for (int i = 0; i < count; i++)
            update();
        return this;
    }

    public Emitter clear() {
        for (int i = children.size(); i-- > 0; )
            disposeParticle(i);
        return this;
    }

    public void update() {
        if (!running)
            return;
        for (int i = 0, max = counter.update(this); i < max; i++)
            createParticle();
        for (Activity activity : activities)
            activity.apply(this);
        if (children.isEmpty())
            return;
        int numChildren = children.size();
        for(int i = 0; i < numChildren; i++)
            updateParticle(children.get(i), i);
        for(int i = numChildren; i-- > 0; )
            if (children.get(i).dead)
                disposeParticle(i);
    }

    private void createParticle() {
        Particle particle = pool.create();
        for (Initializer initializer : initializers)
            initializer.initialize(this, particle);
        children.add(particle);
    }

    private void updateParticle(Particle particle, int index) {
        if (++particle.age > particle.life)
            particle.dead = true;
        for (Behaviour behaviour : behaviours)
            behaviour.apply(this, particle, index);
        particle.oldPosition.set(particle.position);
        particle.position.add(particle.velocity);
    }

    private void disposeParticle(int index) {
        pool.dispose(children.remove(index));
    }
}
