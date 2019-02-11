package de.kibr.jsf.state.game;

import de.kibr.jsf.Entity;
import de.kibr.jsf.Game;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public abstract class GameObject implements Entity {
    final Vector2f position;
    private final Shape hitbox;
    private final Vector2f hitboxOffset;

    GameObject(Vector2f position, Shape hitbox) throws SlickException {
        this.position = position;
        this.hitbox = hitbox;
        this.hitboxOffset = new Vector2f(hitbox.getX(), hitbox.getY());
    }

    public boolean collides(GameObject other) {
        return hitbox.intersects(other.hitbox);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) {
        image().drawCentered(position.x, position.y);
        if (Game.DEBUG) {
            graphics.setColor(Color.red);
            graphics.draw(hitbox);
        }
    }

    public void updateHitbox() {
        hitbox.setX(position.x + hitboxOffset.x);
        hitbox.setY(position.y + hitboxOffset.y);
    }

    public Vector2f getPosition() {
        return position;
    }

    abstract Image image();
}
