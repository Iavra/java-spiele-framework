package de.kibr.jsf.engine.zone;

import org.newdawn.slick.geom.Vector2f;

public interface Zone {
    Vector2f getPoint();
    boolean contains(Vector2f pos);
}
