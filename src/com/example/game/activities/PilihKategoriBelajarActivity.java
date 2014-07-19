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
		font = create_font("Forque.ttf", 20, Color.BLACK);
	}

	@Override
	protected void init_scene() {
		final Text title = create_text(getFontTitle(), "Pilih Kategori");
		attach(title, Alignment.TOP_CENTER, 0, 10);
		set_menu(
				"gfx/menu/pilih_kategori_frame.png",
				new String[]{
						"Ibu Kota", 
						"Tari Tradisional", 
						"Nama Pahlawan", 
						"Lagu Daerah", 
						"Nama Bandara", 
						"Alat Musik", 
						"Nama Kerajaan"
				},
				5,
				font,
				20
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
