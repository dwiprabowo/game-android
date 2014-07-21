package com.example.game.activities;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.util.HorizontalAlign;

import android.graphics.Color;

import com.example.game.Alignment;
import com.example.game.GameActivityModel;

public class AboutActivity extends GameActivityModel{

	@Override
	protected void init_resources() {
		font = create_font(FONT_FORQUE_FILENAME, 12, Color.BLACK);
	}

	Font font;
	ButtonSprite next, previous, back;
	Text content;
	
	final String[] texts = {
			"Pembuat: Agsha Ayudya",
			"Lorem Opsum\nLorem Opsum dolor sit amet",
			"Lorem Opsum\nLorem Opsum dolor sit amet\nLorem Opsum dolor sit amet"
	};
	
	@Override
	protected void init_scene() {
		final Text title = create_text(getFontTitle(), "About");
		final Sprite center_frame = create_sprite("gfx/question_frame.png");
		previous = create_button_sprite("gfx/previous.png");
		next = create_button_sprite("gfx/next.png");
		back = create_button_sprite("gfx/small_button_frame.png");
		final Text kembali = create_text(font, "Kembali");
		content = create_text(font, 200, HorizontalAlign.CENTER);
		
		attach(title, Alignment.TOP_CENTER);
		attach(center_frame, Alignment.CENTER);
		attach(previous, Alignment.LEFT_BOTTOM, center_frame);
		attach(next, Alignment.RIGHT_BOTTOM, center_frame);
		attach(back, Alignment.RIGHT_BOTTOM);
		attach(kembali, Alignment.CENTER, back);
		attach(content, Alignment.CENTER);
		
		index = 0;
		update_content(index);
	}
	
	int index;
	void update_content(int index){
		content.setText(texts[index]);
		set_position(content, Alignment.CENTER);
	}
	
	@Override
	public void button_sprite_clicked(ButtonSprite buttonSprite) {
		if(buttonSprite == back){
			start_and_finish(MainMenuActivity.class);
		}
		if(buttonSprite == next){
			index++;
			if(index == texts.length){
				index = 0;
			}
			update_content(index);
		}
		if(buttonSprite == previous){
			index--;
			if(index == -1){
				index = texts.length - 1;
			}
			update_content(index);
		}
	}

}
