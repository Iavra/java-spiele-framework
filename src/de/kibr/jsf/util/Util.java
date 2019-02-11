package de.kibr.jsf.util;

import org.newdawn.slick.geom.Vector2f;

public class Util {
    private Util() {}

    public static Vector2f polarVector(double radius, double angle) {
        double x = radius * Math.cos(angle);
        double y = -radius * Math.sin(angle);
        return new Vector2f((float) x, (float) y);
    }
}
