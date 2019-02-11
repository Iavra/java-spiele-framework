package de.kibr.jsf.engine.zone;

import de.kibr.jsf.util.Util;
import org.newdawn.slick.geom.Vector2f;

public class CircleZone implements Zone {
    private final Vector2f center;
    private final float radiusOuter;
    private final float radiusInner;
    private final float sqOuter;
    private final float sqInner;

    public CircleZone(Vector2f center, float radiusOuter, float radiusInner) {
        if (radiusOuter < radiusInner)
            throw new IllegalArgumentException("inner radius must not be bigger than outer radius");
        this.center = center;
        this.radiusOuter = radiusOuter;
        this.radiusInner = radiusInner;
        sqOuter = radiusOuter * radiusOuter;
        sqInner = radiusInner * radiusInner;
    }

    public CircleZone(Vector2f center, float radius) {
        this(center, radius, 0);
    }

    @Override
    public Vector2f getPoint() {
        double rand = Math.random();
        return Util.polarVector(
                radiusInner + (1 - rand * rand) * (radiusOuter - radiusInner),
                Math.random() * Math.PI * 2).add(center);
    }

    @Override
    public boolean contains(Vector2f pos) {
        float x = pos.x - center.x;
        float y = pos.y - center.y;
        float distSq = x * x + y * y;
        return distSq <= sqOuter && distSq >= sqInner;
    }
}
