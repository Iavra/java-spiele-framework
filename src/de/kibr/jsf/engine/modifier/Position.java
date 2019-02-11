package de.kibr.jsf.engine.modifier;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.engine.Particle;
import de.kibr.jsf.engine.zone.Zone;
import org.newdawn.slick.geom.Vector2f;

public class Position implements Initializer {
    private final Zone zone;

    public Position(Zone zone) {
        this.zone = zone;
    }

    @Override
    public void initialize(Emitter emitter, Particle target) {
        Vector2f pos = zone.getPoint();
        target.position.set(pos);
        target.oldPosition.set(pos);
    }
}
