package de.kibr.jsf;

import de.kibr.jsf.state.game.GameState;
import de.kibr.jsf.state.menu.MenuState;
import de.kibr.jsf.state.pause.PauseState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {
    public static final String VERSION = "v 0.0.1 Pre-Alpha";
    public static final boolean DEBUG = true;

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final int FPS = 60;

    private Game() {
        super("Game");
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new MenuState());
        addState(new GameState());
        addState(new PauseState());
    }

    public static void main(String[] args) throws Exception {
        AppGameContainer gameContainer = new AppGameContainer(new Game());
        gameContainer.setDisplayMode(WIDTH, HEIGHT, false);
        gameContainer.setTargetFrameRate(FPS);
        gameContainer.setShowFPS(false);
        gameContainer.start();
    }
}

