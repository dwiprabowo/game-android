package com.example.game.activities;

import org.andengine.audio.music.Music;
import org.andengine.audio.sound.Sound;
import com.example.game.GameActivityModel;
import com.example.game.Utils;

public class MainMenuActivity extends GameActivityModel{
	
	private Music music;
	private Sound goodSound, badSound;

	@Override
	protected void init_resources(){
		music = load_music(MUSIC_FILENAME);
		goodSound = load_sound(GOOD_SOUND_FILENAME);
		badSound = load_sound(BAD_SOUND_FILENAME);
	}

	@Override
	protected void init_scene(){
		set_menu(MENU_MAIN_FRAME_PATH, MENU_MAIN_ITEMS);
		play(music);
	}
	
	@Override
	public void menu_clicked(int menuID){
		switch(menuID){
			case MENU_MAIN:start_and_finish(ChooseLevelActivity.class);break;
			case MENU_BELAJAR:start_and_finish(PilihKategoriBelajarActivity.class);break;
			case MENU_SKOR:start_and_finish(SkorActivity.class);break;
			case MENU_SETTING:start_and_finish(SettingActivity.class);break;
			case MENU_ABOUT:start_and_finish(AboutActivity.class);break;
			case MENU_KELUAR:exit_dialog(KELUAR_DIALOG_MESSAGE, KELUAR_DIALOG_CONFIRM, KELUAR_DIALOG_CANCEL);break;
		}
		
		if(menuID != MENU_KELUAR)play(goodSound);
		else play(badSound);
	}
	
	@Override
	protected boolean need_music(){ return true; }

}
