package com.example.game.activities.wrapper;

import org.andengine.audio.music.Music;

public abstract class ActivityUsingMusic extends ActivityUsingSound{

	private Music music;
	
	@Override
	protected void load_another_resources() {
		music = load_music(MUSIC_FILENAME);
	}
	
	public void play_music(){
		play(music);
	}
	
	@Override
	protected boolean need_music() { return true; }

}
