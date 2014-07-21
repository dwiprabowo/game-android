package com.example.game.activities;

import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;

import android.graphics.Color;

import com.example.game.Alignment;
import com.example.game.GameActivityModel;

public class PilihKategoriBelajarActivity extends GameActivityModel {
	
	private Font font;
	
	@Override
	protected void init_resources() {
		font = create_font(FONT_FORQUE_FILENAME, MENU_FONT_SIZE, Color.BLACK);
	}

	@Override
	protected void init_scene() {
		final Text title = create_text(getFontTitle(), PILIH_KATEGORI_TITLE);
		attach(title, Alignment.TOP_CENTER, 0, 10);
		set_menu(
				MENU_KATEGORI_FRAME_PATH,
				MENU_KATEGORI_ITEMS,
				MENU_KATEGORI_SPACE,
				font,
				MENU_KATEGORI_OFFSET_Y
			);
	}
	
	@Override
	public void onBackPressed() {
		start_and_finish(MainMenuActivity.class);
	}
	
	@Override
	public void menu_clicked(int menuID) {
		start_and_finish(BelajarActivity.class, json("{'category': "+menuID+"}"));
	}

}
