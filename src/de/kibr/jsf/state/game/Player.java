package de.kibr.jsf.state.game;

import de.kibr.jsf.engine.Emitter;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

import static de.kibr.jsf.Controls.*;

public class Player extends GameObject {
    private static final float SPEED = 150f / 1000;
    private final Image image = new Image("res/images/player/player.png");
    private final float halfWidth = image.getWidth() / 2f;
    private final float halfHeight = image.getHeight() / 2f;

    Player(Vector2f position) throws SlickException {
        super(position, new Circle(-6, 0, 5));
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        updatePosition(container, delta);
        updateHitbox();
    }

    private void updatePosition(GameContainer container, int delta) {
        Input input = container.getInput();
        float distance = SPEED * delta;

        if (input.isKeyDown(KEY_UP))    position.y -= distance;
        if (input.isKeyDown(KEY_DOWN))  position.y += distance;
        if (input.isKeyDown(KEY_LEFT))  position.x -= distance;
        if (input.isKeyDown(KEY_RIGHT)) position.x += distance;

        position.x = Math.max(halfWidth, Math.min(position.x, container.getWidth() - halfWidth));
        position.y = Math.max(halfHeight, Math.min(position.y, container.getHeight() - halfHeight));
    }

    @Override
    Image image() {
        return image;
    }
}
