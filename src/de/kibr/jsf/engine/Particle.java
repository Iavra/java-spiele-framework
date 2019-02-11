package de.kibr.jsf.engine;

import org.newdawn.slick.geom.Vector2f;

/**
 * Note: Making mutable instance fields public usually isn't the best idea,
 * but it simplifies things a lot here.
 */
public class Particle {
    public Vector2f position = new Vector2f();
    public Vector2f oldPosition = new Vector2f();
    public Vector2f velocity = new Vector2f();

    public int life = -1;
    public int age = 0;
    public boolean dead = false;
    public float energy = 1;

    Particle() {
        reset();
    }

    void reset() {
        life = -1; // ~infinity
        age = 0;
        dead = false;
        energy = 1;
        position.set(0, 0);
        oldPosition.set(0, 0);
        velocity.set(0, 0);
    }
}
