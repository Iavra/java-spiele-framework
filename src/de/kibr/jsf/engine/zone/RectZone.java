package de.kibr.jsf.engine.zone;

import org.newdawn.slick.geom.Vector2f;

import java.util.Random;

public class RectZone implements Zone {
    private static final Random random = new Random();

    private final float left;
    private final float right;
    private final float top;
    private final float bottom;
    private final float width;
    private final float height;

    public RectZone(Vector2f pos, float width, float height) {
        this.width = width;
        this.height = height;
        this.left = pos.x;
        this.top = pos.y;
        this.right = this.left + this.width;
        this.bottom = this.top + this.height;
    }

    @Override
    public Vector2f getPoint() {
        return new Vector2f(
                left + random.nextFloat() * width,
                top + random.nextFloat() * height
        );
    }

    @Override
    public boolean contains(Vector2f pos) {
        return pos.x >= left && pos.x <= right && pos.y >= top && pos.y <= bottom;
    }
}
