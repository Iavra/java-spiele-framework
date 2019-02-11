package de.kibr.jsf;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public interface Entity {
    void update(GameContainer container, StateBasedGame game, int delta) throws SlickException;
    void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException;
}
