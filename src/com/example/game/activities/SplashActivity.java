package com.example.game.activities;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;

import com.example.game.Alignment;
import com.example.game.activities.wrapper.GameActivity;

public class SplashActivity extends GameActivity{

	@Override
	protected void game_logic() {
		final Sprite background = create_sprite(BACKGROUND_IMAGE_PATH);
		final Text title = create_text(GAME_TITLE);
		
		attach(background, Alignment.CENTER);
		attach(title, Alignment.TOP_CENTER, 0, 50);
		
		change_activity_in(5, MainMenuActivity.class);
	}

}