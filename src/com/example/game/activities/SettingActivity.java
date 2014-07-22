package com.example.game.activities;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;

import android.graphics.Color;

import com.example.game.Alignment;
import com.example.game.Button;
import com.example.game.GameActivityModel;

public class SettingActivity extends GameActivityModel{

	Font subtitle,text;
	
	@Override
	protected void init_resources() {
		subtitle 	= create_font(FONT_FORQUE_FILENAME, FONT_SUBTITLE_SIZE, Color.BLACK);
		text 		= create_font(FONT_FORQUE_FILENAME, FONT_LABEL_SIZE, Color.BLACK);
	}
	
	Button buttons[] = new Button[MIDDLE_BUTTON_COUNT];
	ButtonSprite option_on, option_off;
	
	@Override
	protected void init_scene() {
		final Text title 	= create_text(getFontTitle(), SETTING_TITLE);
		final Text suara 	= create_text(subtitle, SUARA_TEXT);
		final Text hidup 	= create_text(text, HIDUP_TEXT);
		final Text mati 	= create_text(text,	MATI_TEXT);
		option_on 	= create_button_sprite(OPTION_ON_PATH);
		option_off 	= create_button_sprite(OPTION_OFF_PATH);
		buttons[BUTTON_RESET] = new Button(create_button_sprite(MIDDLE_BUTTON_FRAME_PATH), create_text(subtitle, RESET_BELAJAR_TEXT), this);
		buttons[BUTTON_BACK] = new Button(create_button_sprite(MIDDLE_BUTTON_FRAME_PATH), create_text(subtitle, KEMBALI_TEXT), this);
		
		attach(title, Alignment.TOP_CENTER, 0, 10);
		attach(suara, Alignment.CENTER, -80, -70);
		attach(hidup, Alignment.CENTER, -20, -30);
		attach(mati, Alignment.CENTER, 80, -30);
		attach(option_on, Alignment.CENTER, -75, -30);
		attach(option_off, Alignment.CENTER, 35, -30);
		attach(buttons[BUTTON_RESET], Alignment.CENTER, 0, 40);
		attach(buttons[BUTTON_BACK], Alignment.CENTER, 0, 110);
		
		if(!is_sound_on())switch_option();
	}
	
	@Override
	public void button_sprite_clicked(ButtonSprite buttonSprite){
		if(buttonSprite == buttons[BUTTON_BACK].getFrame())start_and_finish(MainMenuActivity.class);
		if(buttonSprite == buttons[BUTTON_RESET].getFrame()){
			reset_poins();
			toast(TOAST_RESET_BELAJAR);
		}
		if(buttonSprite == option_off){
			set_sound_on(!is_sound_on());
			switch_option();
		}
	}
	
	void switch_option(){
		float temp_x = 0;
		float temp_y = 0;
		temp_x = option_on.getX();
		temp_y = option_on.getY();
		option_on.setX(option_off.getX());
		option_on.setY(option_off.getY());
		option_off.setX(temp_x);
		option_off.setY(temp_y);
	}

}
