package de.kibr.jsf.state.game;

import de.kibr.jsf.Controls;
import de.kibr.jsf.state.State;
import de.kibr.jsf.state.pause.PauseState;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends State {
    public static final int ID = 1;

    private Player player;
    private Countdown countdown;

    private ParticleSystem particles = new ParticleSystem("res/images/bullet.png");

    @Override
    public int getID() {
        return ID;
    }

    // TODO: init is only called once ever. Need to reset player position/countdown/etc when starting a game

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        super.init(gameContainer, stateBasedGame);
        player = new Player(new Vector2f(50, gameContainer.getHeight() / 2f));
        countdown = new Countdown();
        countdown.start(3);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        player.update(gameContainer, stateBasedGame, delta);
        countdown.update(gameContainer, stateBasedGame, delta);
        checkForPause(gameContainer.getInput(), stateBasedGame);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        player.render(gameContainer, stateBasedGame, graphics);
        countdown.render(gameContainer, stateBasedGame, graphics);
    }

    private void checkForPause(Input input, StateBasedGame game) {
        if (input.isKeyPressed(Controls.KEY_CANCEL))
            game.enterState(PauseState.ID);
    }
}
