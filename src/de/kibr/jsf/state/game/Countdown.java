package de.kibr.jsf.state.game;

import de.kibr.jsf.Entity;
import de.kibr.jsf.FontLoader;
import de.kibr.jsf.Game;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Countdown implements Entity {
    private static final int MAX_DELAY = 1000;

    private final Font font = FontLoader.loadGameFont();
    private int timer = 0;
    private int delay = 0;

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        if (finished()) return;
        delay -= delta;
        if (delay <= 0) {
            delay = MAX_DELAY;
            timer--;
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) {
        if (finished()) return;
        String timerString = String.valueOf(timer);
        float x = (Game.WIDTH - font.getWidth(timerString)) / 2f;
        float y = (Game.HEIGHT - font.getHeight(timerString)) / 2f;
        font.drawString(x, y, timerString);
    }

    public void start(int timer) {
        this.timer = timer;
        delay = MAX_DELAY;
    }

    public boolean finished() {
        return timer <= 0;
    }
}
