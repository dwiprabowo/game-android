package com.example.game.activities.wrapper;

public abstract class TimedActivity extends BackgroundedActivity{
	
	@Override
	protected void extend_activity_logic() { 
		super.extend_activity_logic();
		change_activity_in(time_needed(), to_class());
	}
	protected abstract float time_needed();
	protected abstract Class<?> to_class();
}
