package de.kibr.jsf.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public abstract class State extends BasicGameState {
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        container.getInput().enableKeyRepeat();
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        container.getInput().clearKeyPressedRecord();
    }
}
