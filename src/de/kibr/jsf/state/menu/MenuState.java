package de.kibr.jsf.state.menu;

import de.kibr.jsf.FontLoader;
import de.kibr.jsf.Game;
import de.kibr.jsf.Menu;
import de.kibr.jsf.Parallax;
import de.kibr.jsf.state.State;
import de.kibr.jsf.state.game.GameState;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends State {
    public static final int ID = 0;

    private Image background1;
    private Image background2;
    private Parallax parallax;

    private Menu menu;
    private Version version;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        super.init(container, game);
        background1 = new Image("res/images/background/menu/back1.png");
        background2 = new Image("res/images/background/menu/back2.png");
        parallax = new Parallax(
                new Image("res/images/background/menu/big-planet.png"),
                new Vector2f(100, 50),
                new Vector2f(5, 0));
        menu = new Menu(
                new Vector2f(20, 260),
                new Menu.Option("Start Game", () -> game.enterState(GameState.ID)),
                new Menu.Option("Highscores", () -> {}),
                new Menu.Option("Exit",       container::exit));
        version = new Version(
                Game.VERSION,
                FontLoader.loadSmallFont(),
                new Vector2f(container.getWidth() - 20, container.getHeight() - 20));
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        parallax.update(gameContainer, stateBasedGame, delta);
        menu.update(gameContainer, stateBasedGame, delta);
        version.update(gameContainer, stateBasedGame, delta);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background1.draw(0, 0);
        background2.draw(0, 0);
        parallax.render(gameContainer, stateBasedGame, graphics);
        menu.render(gameContainer, stateBasedGame, graphics);
        version.render(gameContainer, stateBasedGame, graphics);
    }
}
