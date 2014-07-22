package com.example.game.activities.wrapper;

import org.andengine.audio.sound.Sound;

import com.example.game.GameActivityModel;

public abstract class ActivityUsingSound extends GameActivityModel{
	
	private Sound goodSound, badSound;
	
	@Override
	protected void init_resources() {
		goodSound = load_sound(GOOD_SOUND_FILENAME);
		badSound = load_sound(BAD_SOUND_FILENAME);
		load_another_resources();
	}
	
	@Override
	protected void init_scene() {
		activity_logic();
	}
	
	public void play_good_sound(){
		play(goodSound);
	}
	
	public void play_bad_sound(){
		play(badSound);
	}
	
	protected void load_another_resources(){}
	protected abstract void activity_logic();
}
