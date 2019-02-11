package de.kibr.jsf;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {
    private static final String FONT_GAME = "res/fonts/Sabo-Filled.otf";

    private FontLoader() {}

    public static org.newdawn.slick.Font loadGameFont() {
        return loadFont(FONT_GAME, Font.PLAIN, 48);
    }

    public static org.newdawn.slick.Font loadSmallFont() {
        return loadFont(FONT_GAME, Font.PLAIN, 24);
    }

    private static org.newdawn.slick.Font loadFont(String fontFile, int style, float size) {
        try {
            InputStream fontStream = ResourceLoader.getResourceAsStream(fontFile);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(style, size);
            return new TrueTypeFont(font, true);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException("error while loading font: " + fontFile, e);
        }
    }
}
