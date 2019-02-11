package de.kibr.jsf.engine.zone;

import org.newdawn.slick.geom.Vector2f;

public class PointZone implements Zone {
    private final Vector2f point;

    public PointZone(Vector2f point) {
        this.point = point;
    }

    @Override
    public Vector2f getPoint() {
        return point.copy();
    }

    @Override
    public boolean contains(Vector2f pos) {
        return point.equals(pos);
    }
}
