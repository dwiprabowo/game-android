package com.example.game.activities;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;

import android.graphics.Color;

import com.example.game.Alignment;
import com.example.game.GameActivityModel;

public class SkorActivity extends GameActivityModel{

	Font font;
	ButtonSprite back;
	
	@Override
	protected void init_resources() {
		font = create_font(FONT_FORQUE_FILENAME, 16, Color.BLACK);
	}

	@Override
	protected void init_scene() {
		final Text title = create_text(getFontTitle(), "Skor Tertinggi");
		final Text no = create_text(font, "No");
		final Text nama = create_text(font, "Nama");
		final Text skor = create_text(font, "skor");
		back = create_button_sprite("gfx/small_button_frame.png");
		final Text kembali = create_text(font, "kembali");
		
		attach(title, Alignment.TOP_CENTER, 0, 10);
		attach(no, Alignment.LEFT_TOP, 0, 50);
		attach(nama, Alignment.TOP_CENTER, 0, 50);
		attach(skor, Alignment.RIGHT_TOP, 0, 50);
		attach(kembali, Alignment.CENTER, back);
		attach(back, Alignment.RIGHT_BOTTOM);
	}
	
	@Override
	public void button_sprite_clicked(ButtonSprite buttonSprite) {
		if(buttonSprite == back)start_and_finish(MainMenuActivity.class);
	}
	
}
