package com.example.game.constants;

import com.example.game.Alignment;
import com.example.game.Position;

public interface SplashActivityConstants {
	
	static final String BACKGROUND_IMAGE_PATH = "gfx/splash_screen.png";
	static final String GAME_TITLE = "Uji Ke-Indonesia-anmu!";
	
	final float CHANGE_TIME = 5.0f;
	
	final Position POSITION_BACKGROUND = new Position(Alignment.CENTER, 0, 20);
	final Position POSITION_TITLE = new Position(Alignment.CENTER, 0, -80);
	
}
