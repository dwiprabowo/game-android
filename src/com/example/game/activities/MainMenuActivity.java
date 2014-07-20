package com.example.game.activities;

import org.andengine.audio.music.Music;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;

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
	
	private Music music;
	private Sound goodSound, badSound;

	@Override
	protected void init_resources() {
		SoundFactory.setAssetBasePath("sfx/");
		music = load_music("FamiliarRoads.mid");
		goodSound = load_sound("good.wav");
		badSound = load_sound("bad.mp3");
	}

	@Override
	protected void init_scene() {
		set_menu(
			"gfx/menu/menu_main_frame.png",
			new String[]{"Main", "Belajar", "Skor Tertinggi", "Setting", "About", "Keluar"}
		);
		play_music(music);
	}
	
	@Override
	public void menu_clicked(int menuID) {
		if(menuID != MENU_KELUAR){
			play_sound(goodSound);
		} else {
			play_sound(badSound);
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
				start_and_finish(SettingActivity.class);
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
