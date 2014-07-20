package com.example.game;

import com.example.game.constants.MainMenuActivityConstants;
import com.example.game.constants.SettingActivityConstants;
import com.example.game.constants.SplashActivityConstants;

public interface Constants extends SplashActivityConstants, MainMenuActivityConstants, SettingActivityConstants{
	
	static final String PREFS_NAME = "game_data";
	
	static final int CAMERA_WIDTH = 240;
	static final int CAMERA_HEIGHT = 320;

	static final int OPTIONS_COUNT = 4;
	static final float DEFAULT_POIN = 10;
	
	static final String IMAGE_PATH = "gfx/game_images/";
	
	final int KATEGORI_IBU_KOTA = 0;
	final int KATEGORI_TARI_TRADISIONAL = KATEGORI_IBU_KOTA + 1;
	final int KATEGORI_NAMA_PAHLAWAN = KATEGORI_TARI_TRADISIONAL + 1;
	final int KATEGORI_LAGU_DAERAH = KATEGORI_NAMA_PAHLAWAN + 1;
	final int KATEGORI_NAMA_BANDARA = KATEGORI_LAGU_DAERAH + 1;
	final int KATEGORI_ALAT_MUSIK = KATEGORI_NAMA_BANDARA + 1;
	final int KATEGORI_NAMA_KERAJAAN = KATEGORI_ALAT_MUSIK + 1;
	final int KATEGORI_COUNT = KATEGORI_NAMA_KERAJAAN + 1;
	
	final int FONT_TITLE_SIZE = 28;
	final int FONT_SUBTITLE_SIZE = 24;
	final int FONT_LABEL_SIZE = 18;
	final String FONT_FORQUE_FILENAME = "Forque.ttf";
	
	final String GLOBAL_BUTTON_FRAME_PATH = "gfx/global_button_frame.png";
}
