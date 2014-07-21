package com.example.game.activities;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;

import android.graphics.Color;

import com.example.game.Alignment;
import com.example.game.GameActivityModel;
import com.example.game.Level;
import com.example.game.Utils;

public class ChooseLevelActivity extends GameActivityModel{

	private Font smallerTitleFont;
	private Font monoFont;
	private ButtonSprite button_level, next, previous;
	
	Level[] level;

	@Override
	public void init_resources(){
		level = new Level[get_level_count()];
		smallerTitleFont = create_font("Forque.ttf", 20, Color.WHITE);
		monoFont = create_font("Anonymous.ttf", 16, Color.WHITE);
	}
	
	Text text_level, text_skor_number, text_soal_number;

	int index_level;
	@Override
	public void init_scene(){
		index_level = 0;
		final Text title = new Text(0, 0, getFontTitle(), "Pilih Level", getVBOM());
		attach(title, Alignment.TOP_CENTER);set_position(title, 0, 20);
		
		text_level 		= create_text(smallerTitleFont, 7);
		final Text text_skor 		= create_text(monoFont, "Skor =");
		final Text text_soal  		= create_text(monoFont, "Soal =");
		text_skor_number = create_text(monoFont, 4);
		text_soal_number = create_text(monoFont, 4);
		final Text mulai 			= create_text(smallerTitleFont, "Mulai");
		
		button_level = create_button_sprite("gfx/menu/level.png");
		
		attach(button_level, Alignment.CENTER);
		attach(text_level, Alignment.TOP_CENTER, button_level);
		attach(text_skor, button_level, Alignment.MIDDLE_LEFT, 30, -13);
		attach(text_soal, button_level, Alignment.MIDDLE_LEFT, 30, 7);
		attach(text_skor_number, button_level, Alignment.MIDDLE_RIGHT, -30, -13);
		attach(text_soal_number, button_level, Alignment.MIDDLE_RIGHT, -30, 7);
		attach(mulai, button_level, Alignment.BOTTOM_CENTER, 0, -6);
		
		next = create_button_sprite("gfx/next.png");
		previous = create_button_sprite("gfx/previous.png");
		
		attach(next, Alignment.CENTER, 40, 80);
		attach(previous, Alignment.CENTER, -40, 80);
		
		update_level(index_level);
	}
	
	void update_level(int level){
		text_level.setText("Level "+(level+1));
		set_position(text_level, Alignment.TOP_CENTER);
		text_skor_number.setText(String.valueOf(get_skor(level)));
		set_position(text_skor_number, -30, -13, Alignment.MIDDLE_RIGHT);
		text_soal_number.setText(String.valueOf(get_soal(level)));
		set_position(text_soal_number, -30, 7, Alignment.MIDDLE_RIGHT);
	}
	
	@Override
	public void button_sprite_clicked(ButtonSprite buttonSprite){
		if(buttonSprite == button_level){
			start_and_finish(MainActivity.class, "{'level': "+index_level+"}");
		}
		if(buttonSprite == next){
			index_level++;
			if(index_level == level.length){
				index_level = 0;
			}
			update_level(index_level);
		}
		if(buttonSprite == previous){
			index_level--;
			if(index_level < 0){
				index_level = level.length-1;
			}
			update_level(index_level);
		}
	}

	@Override
	public void onBackPressed(){
		start_and_finish(MainMenuActivity.class);
	}
}