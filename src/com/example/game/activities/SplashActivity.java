package com.example.game.activities;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import com.example.game.activities.wrapper.SimpleGameActivity;

public class SplashActivity extends SimpleGameActivity{
	@Override
	protected void activity_logic(){
		final Sprite background = create_sprite(BACKGROUND_IMAGE_PATH);
		final Text title = create_text(getFontTitle(), GAME_TITLE);
		attach(background, POSITION_BACKGROUND);
		attach(title, POSITION_TITLE);
		change_activity_in(CHANGE_TIME, MAIN_MENU_ACTIVITY_CLASS);
	}
}
