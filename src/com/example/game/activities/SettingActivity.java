package com.example.game.activities;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;

import android.graphics.Color;
import android.widget.Toast;

import com.example.game.Alignment;
import com.example.game.GameActivityModel;

public class SettingActivity extends GameActivityModel{

	Font subtitle;
	Font text;
	
	@Override
	protected void init_resources() {
		subtitle = create_font("Forque.ttf", 24, Color.BLACK);
		text = create_font("Forque.ttf", 18, Color.BLACK);
	}
	
	ButtonSprite reset_belajar_frame;
	ButtonSprite kembali_frame;
	ButtonSprite option_on, option_off;
	
	@Override
	protected void init_scene() {
		final Text title = create_text(getFontTitle(), "Setting");
		attach(title, Alignment.TOP_CENTER, 0, 10);
		
		final Text suara = create_text(subtitle, "Suara");
		attach(suara, Alignment.CENTER, -80, -70);
		
		final Text hidup = create_text(text, "Hidup");
		attach(hidup, Alignment.CENTER, -20, -30);
		
		final Text mati = create_text(text, "Mati");
		attach(mati, Alignment.CENTER, 80, -30);
		
		option_on = create_button_sprite("gfx/option_on.png", true);
		option_off = create_button_sprite("gfx/option_off.png", true);
		
		attach(option_on, Alignment.CENTER, -75, -30);
		attach(option_off, Alignment.CENTER, 35, -30);
		if(!is_sound_on())switch_option();
		
		reset_belajar_frame = create_button_sprite("gfx/global_button_frame.png", true);
		kembali_frame = create_button_sprite("gfx/global_button_frame.png", true);
		final Text reset_belajar = create_text(subtitle, "Reset Belajar");
		final Text kembali = create_text(subtitle, "Kembali");
		
		attach(reset_belajar_frame, Alignment.CENTER, 0, 40);
		attach(reset_belajar, Alignment.CENTER, reset_belajar_frame);
		
		attach(kembali_frame, Alignment.CENTER, 0, 110);
		attach(kembali, Alignment.CENTER, kembali_frame);
	}
	
	@Override
	public void button_sprite_clicked(ButtonSprite buttonSprite) {
		if(buttonSprite == kembali_frame){
			start_and_finish(MainMenuActivity.class);
		}
		if(buttonSprite == reset_belajar_frame){
			reset_poins();
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					Toast.makeText(SettingActivity.this, "Poin Belajar di Reset!", Toast.LENGTH_SHORT).show();
				}
			});
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
