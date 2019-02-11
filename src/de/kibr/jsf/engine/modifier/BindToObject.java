package de.kibr.jsf.engine.modifier;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.state.game.GameObject;
import org.newdawn.slick.geom.Vector2f;

public class BindToObject implements Activity {
    private final GameObject target;
    private final Vector2f offset;

    public BindToObject(GameObject target, Vector2f offset) {
        this.target = target;
        this.offset = offset;
    }

    public BindToObject(GameObject target) {
        this(target, new Vector2f());
    }

    @Override
    public void apply(Emitter emitter) {
        emitter.position = target.getPosition().copy().add(offset);
    }
}
