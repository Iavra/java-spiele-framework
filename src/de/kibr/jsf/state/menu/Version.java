package de.kibr.jsf.state.menu;

import de.kibr.jsf.Entity;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Version implements Entity {
    private final String versionString;
    private final Font font;
    private final Vector2f position;

    public Version(String versionString, Font font, Vector2f position) {
        this.versionString = versionString;
        this.font = font;
        this.position = position.add(new Vector2f(
                - font.getWidth(versionString),
                - font.getHeight(versionString)));
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) {
        font.drawString(position.x, position.y, versionString);
    }
}
