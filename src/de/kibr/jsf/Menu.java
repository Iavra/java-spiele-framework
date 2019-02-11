package de.kibr.jsf;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import static de.kibr.jsf.Controls.*;

public class Menu implements Entity {
    private static final int SPACING = 60;

    private final Font font = FontLoader.loadGameFont();
    private final Vector2f position;
    private final Option[] options;
    private final int cancelAction;
    private int selection = 0;

    public Menu(Vector2f position, Option... options) {
        this(position, -1, options);
    }

    public Menu(Vector2f position, int cancelAction, Option... options) {
        this.position = position;
        this.options = options;
        this.cancelAction = cancelAction;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        Input input = container.getInput();
        updateSelection(input);
        if (input.isKeyPressed(KEY_ACTION))
            options[selection].action.run();
        else if (cancelAction >= 0 && input.isKeyPressed(KEY_CANCEL))
            options[cancelAction].action.run();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) {
        for (int i = 0; i < options.length; i++) {
            float x = i == selection ? position.x + 20 : position.x;
            font.drawString(x, position.y + i * SPACING, options[i].label);
        }
    }

    private void updateSelection(Input input) {
        if (input.isKeyPressed(KEY_UP))
            selection--;
        if (input.isKeyPressed(KEY_DOWN))
            selection++;
        selection = Math.max(0, Math.min(selection, options.length - 1));
    }

    public static class Option {
        private final String label;
        private final Runnable action;

        public Option(String label, Runnable action) {
            this.label = label;
            this.action = action;
        }
    }
}
