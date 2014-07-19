package com.example.game.activities;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;

import com.example.game.Alignment;
import com.example.game.GameActivityModel;

public class SplashActivity extends GameActivityModel{

	@Override
	protected void init_resources() {
	}

	@Override
	protected void init_scene() {
		final Sprite background = create_sprite("gfx/splash_screen.png");
		final Text title = create_text(getFontTitle(), "Uji Ke-Indonesia-anmu!");
		
		attach(background, Alignment.CENTER, 0, 20);
		attach(title, Alignment.CENTER, 0, -80);
		
		change_activity_in(5.0f, MainMenuActivity.class);
	}
}
