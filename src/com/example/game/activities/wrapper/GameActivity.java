package com.example.game.activities.wrapper;

import com.example.game.GameActivityModel;

public abstract class GameActivity extends GameActivityModel{

	@Override
	protected void init_resources() {}

	@Override
	protected void init_scene() {
		game_logic();
	}
	
	protected abstract void game_logic();

}
