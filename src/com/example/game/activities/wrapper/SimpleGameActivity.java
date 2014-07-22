package com.example.game.activities.wrapper;

import com.example.game.GameActivityModel;

public abstract class SimpleGameActivity extends GameActivityModel{
	
	@Override
	protected void init_resources() {}
	
	@Override
	protected void init_scene() {
		activity_logic();
	}
	
	protected abstract void activity_logic();
}
