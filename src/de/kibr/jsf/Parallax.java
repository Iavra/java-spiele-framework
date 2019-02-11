package de.kibr.jsf;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Parallax implements Entity {
    private final Image image;
    private final Vector2f position;
    private final Vector2f speed;

    public Parallax(Image image, Vector2f position, Vector2f speed) {
        this.image = image;
        this.position = position;
        this.speed = speed;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        position.add(new Vector2f(speed).scale(delta / 1000f));
        if (position.x > container.getWidth())
            position.x -= (container.getWidth() + image.getWidth());
        // TODO: Modulo to keep the image on screen
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) {
        graphics.drawImage(image, position.x, position.y);
        if (speed.x > 0)
            graphics.drawImage(image, position.x - container.getWidth() - image.getWidth(), position.y);
    }
}
