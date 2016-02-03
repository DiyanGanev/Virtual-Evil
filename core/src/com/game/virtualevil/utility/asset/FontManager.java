package com.game.virtualevil.utility.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

/* The FontManager class contains all the fonts.
 * If there are more fonts: create a hashmap
 * and access them by a string. */
public class FontManager {

	private final String path = "fonts/", format = ".ttf";
	private BitmapFont debugFont;
	private BitmapFont startScreenDigits;
	
	public FontManager() {
		debugFont = new BitmapFont();
	}
	
	public BitmapFont getDebugFont() {
		return debugFont;
	}
	
	public BitmapFont getStartScreenDigits(int fontSize) {
		if (startScreenDigits == null) {
			FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(path + "VeraMono" + format));
			FreeTypeFontParameter parameter = new FreeTypeFontParameter();
			parameter.size = fontSize;
			parameter.color = com.badlogic.gdx.graphics.Color.GREEN;
			parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS;
			startScreenDigits = generator.generateFont(parameter);
			generator.dispose();
		}
		return startScreenDigits;
	}
	
	public void disposeAllFonts() {
		debugFont.dispose();
		startScreenDigits.dispose();
	}
}
