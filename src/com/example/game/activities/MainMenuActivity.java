package com.example.game.activities;

import com.example.game.activities.wrapper.ActivityUsingMusic;

public class MainMenuActivity extends ActivityUsingMusic{
	
	@Override
	protected void activity_logic(){
		set_menu(MENU_MAIN_FRAME_PATH, MENU_MAIN_ITEMS);
		play_music();
	}
	
	@Override
	public void menu_clicked(int menuID){
		play_menu_sound(menuID);
		switch(menuID){
			case MENU_MAIN:start_and_finish(ChooseLevelActivity.class);break;
			case MENU_BELAJAR:start_and_finish(ChooseCategoryActivity.class);break;
			case MENU_SKOR:start_and_finish(SkorActivity.class);break;
			case MENU_SETTING:start_and_finish(SettingActivity.class);break;
			case MENU_ABOUT:start_and_finish(AboutActivity.class);break;
			case MENU_KELUAR:exit_dialog(KELUAR_DIALOG_MESSAGE, KELUAR_DIALOG_CONFIRM, KELUAR_DIALOG_CANCEL);break;
		}
	}
	
	void play_menu_sound(int menuID){
		if(menuID != MENU_KELUAR)play_good_sound();
		else play_bad_sound();
	}
}
