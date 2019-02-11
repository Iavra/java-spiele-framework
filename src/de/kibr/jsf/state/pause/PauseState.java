package de.kibr.jsf.state.pause;

import de.kibr.jsf.Game;
import de.kibr.jsf.Menu;
import de.kibr.jsf.state.State;
import de.kibr.jsf.state.game.GameState;
import de.kibr.jsf.state.menu.MenuState;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class PauseState extends State {
    public static final int ID = 2;

    private Image background1;
    private Image background2;
    private Menu menu;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        super.enter(container, game);
        background1 = new Image(Game.WIDTH, Game.HEIGHT);
        container.getGraphics().copyArea(background1, 0, 0);
        background2 = new Image("res/images/background/pause/back.png");
        menu = new Menu(
                new Vector2f(210, 130), 0,
                new Menu.Option("Resume",       () -> game.enterState(GameState.ID)),
                new Menu.Option("Back To Menu", () -> game.enterState(MenuState.ID))
        );
        // TODO: blur the image
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        menu.update(gameContainer, stateBasedGame, delta);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background1.draw(0, 0);
        background2.draw(0, 0);
        menu.render(gameContainer, stateBasedGame, graphics);
    }
}
