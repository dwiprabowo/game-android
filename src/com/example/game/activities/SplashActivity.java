package com.example.game.activities;

import com.example.game.activities.wrapper.TimedActivity;

public class SplashActivity extends TimedActivity{

	@Override
	protected float time_needed() { return CHANGE_TIME; }

	@Override
	protected Class<?> to_class() { return MAIN_MENU_ACTIVITY_CLASS; }

	@Override
	protected String background_path() { return BACKGROUND_IMAGE_PATH; }

	@Override
	protected String title() { return GAME_TITLE; }
	
}
