package de.kibr.jsf.state.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

// FIXME
public abstract class Enemy extends GameObject {
    Enemy(Vector2f position, Shape hitbox) throws SlickException {
        super(position, hitbox);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        // FIXME
    }
}
