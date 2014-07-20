package com.example.game.activities;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import com.example.game.Alignment;
import com.example.game.GameActivityModel;
import android.graphics.Color;

public class ChooseLevelActivity extends GameActivityModel{

	private Font smallerTitleFont;
	private Font monoFont;
	private ButtonSprite button_level;

	@Override
	public void init_resources(){
		smallerTitleFont = create_font("Forque.ttf", 20, Color.WHITE);
		monoFont = create_font("Anonymous.ttf", 16, Color.WHITE);
	}

	@Override
	public void init_scene(){
		int level = 1;
		
		final Text title = new Text(0, 0, getFontTitle(), "Pilih Level", getVBOM());
		attach(title, Alignment.TOP_CENTER);set_position(title, 0, 20);
		
		final Text text_level 		= create_text(smallerTitleFont, "Level "+level);
		final Text text_skor 		= create_text(monoFont, "Skor =");
		final Text text_soal  		= create_text(monoFont, "Soal =");
		final Text text_skor_number = create_text(monoFont, "50,00");
		final Text text_soal_number = create_text(monoFont, "10");
		final Text mulai 			= create_text(smallerTitleFont, "Mulai");
		
		button_level = create_button_sprite("gfx/menu/level.png");
		
		attach(button_level, Alignment.CENTER);
		attach(text_level, Alignment.TOP_CENTER, button_level);
		attach(text_skor, button_level, Alignment.MIDDLE_LEFT, 30, -13);
		attach(text_soal, button_level, Alignment.MIDDLE_LEFT, 30, 7);
		attach(text_skor_number, button_level, Alignment.MIDDLE_RIGHT, -30, -13);
		attach(text_soal_number, button_level, Alignment.MIDDLE_RIGHT, -30, 7);
		attach(mulai, button_level, Alignment.BOTTOM_CENTER, 0, -6);
	}
	
	@Override
	public void button_sprite_clicked(ButtonSprite buttonSprite){
		if(buttonSprite == button_level){
			start_and_finish(MainActivity.class);
		}
	}

	@Override
	public void onBackPressed(){
		start_and_finish(MainMenuActivity.class);
	}
}