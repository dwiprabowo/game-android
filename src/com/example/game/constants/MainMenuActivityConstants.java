package com.example.game.constants;

public interface MainMenuActivityConstants {
	
	static final int MENU_MAIN = 0;
	static final int MENU_BELAJAR = MENU_MAIN + 1;
	static final int MENU_SKOR = MENU_BELAJAR + 1;
	static final int MENU_SETTING = MENU_SKOR + 1;
	static final int MENU_ABOUT = MENU_SETTING + 1;
	static final int MENU_KELUAR = MENU_ABOUT + 1;
	
	static final String MUSIC_FILENAME = "FamiliarRoads.mid";
	
	static final String MENU_MAIN_FRAME_PATH = "gfx/menu/menu_main_frame.png";
	static final String[] MENU_MAIN_ITEMS = new String[]{"Main", "Belajar", "Skor Tertinggi", "Setting", "About", "Keluar"};
	
	static final String KELUAR_DIALOG_MESSAGE = "Anda Yakin Keluar?";
	static final String KELUAR_DIALOG_CONFIRM = "Ya";
	static final String KELUAR_DIALOG_CANCEL = "Tidak";
}
