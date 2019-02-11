package de.kibr.jsf.engine.modifier;

import de.kibr.jsf.util.Util;

public class PolarForce extends Force {
    public PolarForce(float radius, float angle) {
        super(Util.polarVector(radius, angle));
    }
}
