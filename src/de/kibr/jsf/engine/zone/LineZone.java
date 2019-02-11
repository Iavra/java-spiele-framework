package de.kibr.jsf.engine.zone;

import org.newdawn.slick.geom.Vector2f;

public class LineZone implements Zone {
    private static final float EPSILON = 0.001f;

    private final Vector2f from;
    private final Vector2f to;
    private final float m;
    private final float b;

    public LineZone(Vector2f from, Vector2f to) {
        this.from = from;
        this.to = to;
        this.m = (to.y - from.y) / (to.x - from.x);
        this.b = from.y - m * from.x;
    }

    @Override
    public Vector2f getPoint() {
        float scale = (float) Math.random();
        return from.copy().scale(1 - scale).add(to.copy().scale(scale));
    }

    @Override
    public boolean contains(Vector2f pos) {
        // Note: slope can't handle vertical lines, if this should become relevant
        return Math.abs(pos.y - (m * pos.x + b)) < EPSILON;
    }
}
