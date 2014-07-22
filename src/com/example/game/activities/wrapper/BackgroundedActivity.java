package com.example.game.activities.wrapper;

import com.example.game.Alignment;

public abstract class BackgroundedActivity extends TitledActivity{

	@Override
	protected void extend_activity_logic() {
		attach(create_sprite(background_path()), Alignment.CENTER);
	}
	
	protected abstract String background_path();

}
