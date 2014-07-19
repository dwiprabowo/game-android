package com.example.game.activities;

import java.io.IOException;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.util.debug.Debug;

import com.example.game.Constants;
import com.example.game.GameActivityModel;
import com.example.game.Utils;

public class MainMenuActivity extends GameActivityModel implements Constants{
	
	protected static final int MENU_MAIN = 0;
	protected static final int MENU_BELAJAR = MENU_MAIN + 1;
	protected static final int MENU_SKOR = MENU_BELAJAR + 1;
	protected static final int MENU_SETTING = MENU_SKOR + 1;
	protected static final int MENU_ABOUT = MENU_SETTING + 1;
	protected static final int MENU_KELUAR = MENU_ABOUT + 1;
	
	private Music mMusic;
	private Sound mGoodSound, mBadSound;

	@Override
	protected void init_resources() {
		MusicFactory.setAssetBasePath("mfx/");
		SoundFactory.setAssetBasePath("sfx/");
		try {
			this.mMusic = MusicFactory.createMusicFromAsset(this.mEngine.getMusicManager(), this, "FamiliarRoads.mid");
			this.mMusic.setLooping(true);
		} catch (final IOException e) {
			Debug.e(e);
		}
		try {
			this.mGoodSound = SoundFactory.createSoundFromAsset(this.mEngine.getSoundManager(), this, "good.wav");
		} catch (final IOException e) {
			Debug.e(e);
		}
		try {
			this.mBadSound = SoundFactory.createSoundFromAsset(this.mEngine.getSoundManager(), this, "bad.mp3");
		} catch (final IOException e) {
			Debug.e(e);
		}
	}

	@Override
	protected void init_scene() {
		set_menu(
			"gfx/menu/menu_main_frame.png",
			new String[]{"Main", "Belajar", "Skor Tertinggi", "Setting", "About", "Keluar"}
		);
		mMusic.play();
	}
	
	@Override
	public void menu_clicked(int menuID) {
		if(menuID != MENU_KELUAR){
			mGoodSound.play();
		} else {
			mBadSound.play();
		}
		switch(menuID){
			case MENU_MAIN:
				start_and_finish(ChooseLevelActivity.class);
				break;
			case MENU_BELAJAR:
				start_and_finish(PilihKategoriBelajarActivity.class);
				break;
			case MENU_SKOR:
				Utils.log("skor...");
				break;
			case MENU_SETTING:
				Utils.log("setting...");
				break;
			case MENU_ABOUT:
				Utils.log("about...");
				break;
			case MENU_KELUAR:
				exit_dialog("Anda Yakin Keluar?", "Ya", "Tidak");
				break;
			default:
				break;
		}
	}
	
	@Override
	protected boolean need_music() {
		return true;
	}

}
