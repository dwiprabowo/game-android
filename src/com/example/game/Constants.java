package com.example.game;

import com.example.game.activities.AboutActivity;
import com.example.game.activities.BelajarActivity;
import com.example.game.activities.ChooseLevelActivity;
import com.example.game.activities.EndMainActivity;
import com.example.game.activities.MainActivity;
import com.example.game.activities.MainMenuActivity;
import com.example.game.activities.ChooseCategoryActivity;
import com.example.game.activities.SettingActivity;
import com.example.game.activities.SkorActivity;
import com.example.game.activities.SplashActivity;
import com.example.game.constants.MainMenuActivityConstants;
import com.example.game.constants.PilihKategoriBelajarActivityConstants;
import com.example.game.constants.SettingActivityConstants;
import com.example.game.constants.SplashActivityConstants;

public interface Constants extends 	SplashActivityConstants, 
									MainMenuActivityConstants, 
									SettingActivityConstants, 
									PilihKategoriBelajarActivityConstants{
	
	Class<SplashActivity> 			SPLASH_ACTIVITY_CLASS 			= SplashActivity.class;
	Class<MainMenuActivity> 		MAIN_MENU_ACTIVITY_CLASS 		= MainMenuActivity.class;
	Class<ChooseLevelActivity> 		CHOOSE_LEVEL_ACTIVITY_CLASS 	= ChooseLevelActivity.class;
	Class<ChooseCategoryActivity> 	CHOOSE_CATEGORY_ACTIVITY_CLASS 	= ChooseCategoryActivity.class;
	Class<SkorActivity> 			SKOR_ACTIVITY_CLASS 			= SkorActivity.class;
	Class<SettingActivity> 			SETTING_ACTIVITY_CLASS 			= SettingActivity.class;
	Class<AboutActivity> 			ABOUT_ACTIVITY_CLASS 			= AboutActivity.class;
	Class<MainActivity> 			MAIN_ACTIVITY_CLASS 			= MainActivity.class;
	Class<BelajarActivity> 			BELAJAR_ACTIVITY_CLASS 			= BelajarActivity.class;
	Class<EndMainActivity> 			END_MAIN_ACTIVITY_CLASS 		= EndMainActivity.class;
	
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
	final int FONT_SMALL_SUBTITLE_SIZE = 20;
	final int FONT_LABEL_SIZE = 18;
	final int FONT_MONO_SIZE = 16;
	final int FONT_QUESTION_SIZE = 16;
	final int FONT_OPTION_SIZE = 12;
	
	final String FONT_FORQUE_FILENAME = "Forque.ttf";
	final String FONT_ANONYMOUS_FILENAME = "Anonymous.ttf";
	final String FONT_OPENSANS_FILENAME = "OpenSans-Regular.ttf";
	final String FONT_ELIGIBLE_FILENAME = "Eligible-Regular.ttf";
	
	final String GLOBAL_BUTTON_FRAME_PATH = "gfx/global_button_frame.png";

	static final String MUSIC_FILENAME = "FamiliarRoads.mid";
	static final String GOOD_SOUND_FILENAME = "good.wav";
	static final String BAD_SOUND_FILENAME = "bad.mp3";
	
	final int LEVEL_COUNT = 5;
	
	final String BIG_BUTTON_FRAME_PATH = "gfx/button_frames/big_button_frame.png";
	final String MIDDLE_BUTTON_FRAME_PATH = "gfx/button_frames/middle_button_frame.png";
	final String SMALL_BUTTON_FRAME_PATH = "gfx/button_frames/small_button_frame.png";
	final String OPTION_OFF_BUTTON_FRAME_PATH = "gfx/button_frames/option_off.png";
	final String OPTION_ON_BUTTON_FRAME_PATH = "gfx/button_frames/option_on.png";
	
	final float DEFAULT_TITLE_GAP = 2;
}
