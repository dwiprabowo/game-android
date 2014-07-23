package com.example.game.activities;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.util.HorizontalAlign;

import android.graphics.Color;

import com.example.game.Alignment;
import com.example.game.Button;
import com.example.game.GameActivityModel;

public class AboutActivity extends GameActivityModel{

	@Override
	protected void init_resources() {
		font = create_font(FONT_ELIGIBLE_FILENAME, FONT_OPTION_SIZE, Color.BLACK);
	}

	Font font;
	Button back;
	ButtonSprite next, previous;
	Text content;
	
	@Override
	protected void init_scene() {
		final Text title = create_text(getFontTitle(), "About");
		final Sprite center_frame = create_sprite(QUESTION_FRAME_PATH);
		previous = create_button_sprite(PREVIOUS_BUTTON_PATH);
		next = create_button_sprite(NEXT_BUTTON_PATH);
		back = new Button(create_button_sprite(SMALL_BUTTON_FRAME_PATH), create_text(font, "Kembali"), this);
		content = create_text(font, 200, HorizontalAlign.CENTER);
		
		attach(title, Alignment.TOP_CENTER);
		attach(center_frame, Alignment.CENTER, 0, -30);
		attach(previous, center_frame, Alignment.LEFT_BOTTOM, 0, 40);
		attach(next, center_frame, Alignment.RIGHT_BOTTOM, 0, 40);
		attach(back, Alignment.RIGHT_BOTTOM, -10, -10);
		attach(content, center_frame, Alignment.CENTER);
		
		index = 0;
		update_content(index);
	}
	
	int index;
	void update_content(int index){
		content.setText(TEXT_PAGES[index]);
		set_position(content, Alignment.CENTER);
	}
	
	@Override
	public void button_sprite_clicked(ButtonSprite buttonSprite) {
		if(buttonSprite == back.getFrame())start_and_finish(MainMenuActivity.class);
		if(buttonSprite == next)flip_next_page();
		if(buttonSprite == previous)flip_previous_page();
	}
	
	void flip_next_page(){
		index++;
		if(index == TEXT_PAGES.length)index = 0;
		update_content(index);
	}
	
	void flip_previous_page(){
		index--;
		if(index == -1)index = TEXT_PAGES.length - 1;
		update_content(index);
	}

}
