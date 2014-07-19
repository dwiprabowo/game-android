package com.example.game.activities;

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

	@Override
	protected void init_resources() {
	}

	@Override
	protected void init_scene() {
		set_menu(
			"gfx/menu/menu_main_frame.png",
			new String[]{"Main", "Belajar", "Skor Tertinggi", "Setting", "About", "Keluar"}
		);
	}
	
	@Override
	public void menu_clicked(int menuID) {
		switch(menuID){
			case MENU_MAIN:
				startAndFinish(ChooseLevelActivity.class);
				break;
			case MENU_BELAJAR:
				Utils.log("belajar...");
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

}
