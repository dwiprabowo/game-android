package com.example.game;

public interface Constants {
	
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
}
