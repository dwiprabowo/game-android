package com.example.game.constants;

import com.example.game.Alignment;
import com.example.game.Position;

public interface SettingActivityConstants {
	final String SETTING_TITLE = "Setting";
	final String SUARA_TEXT = "Suara";
	final String HIDUP_TEXT = "Hidup";
	final String MATI_TEXT = "Mati";
	final String RESET_BELAJAR_TEXT = "Reset Belajar";
	final String KEMBALI_TEXT = "Kembali";
	final String TOAST_RESET_BELAJAR = "Poin Belajar di Reset!";
	
	final int MIDDLE_BUTTON_COUNT = 2;
	final int BUTTON_RESET = 0;
	final int BUTTON_BACK = 1;
	
	final Position POSITION_SETTING_TITLE = new Position(Alignment.TOP_CENTER, 0, 10);
	final Position POSITION_SUARA = new Position(Alignment.CENTER, -80, -70);
	final Position POSITION_HIDUP = new Position(Alignment.CENTER, -30, -30);
	final Position POSTION_MATI = new Position(Alignment.CENTER, 70, -30);
	final Position OPTION_ON = new Position(Alignment.CENTER, -75, -30);
	final Position OPTION_OFF = new Position(Alignment.CENTER, 35, -30);
	final Position BUTTON_RESET_POSITION = new Position(Alignment.CENTER, 0, 50);
	final Position BUTTON_BACK_POSITION = new Position(Alignment.CENTER, 0, 100);
}
