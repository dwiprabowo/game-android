package com.example.game.activities;

import java.util.ArrayList;

import org.andengine.audio.sound.Sound;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.util.HorizontalAlign;
import android.graphics.Color;
import com.example.game.Alignment;
import com.example.game.GameActivityModel;
import com.example.game.GameData;
import com.example.game.Question;

public abstract class QuestionActivity extends GameActivityModel{

	ArrayList<Question> questions = new ArrayList<Question>();
	
	Font subTitle, monoFont, questionFont, optionFont;
	Sound goodSound, badSound;
	
	@Override
	protected void init_resources(){
		questions = find_questions(0, GameData.QUESTIONS);
		
		subTitle = create_font(FONT_FORQUE_FILENAME, FONT_SMALL_SUBTITLE_SIZE, Color.BLACK);
		monoFont = create_font(FONT_ANONYMOUS_FILENAME, FONT_MONO_SIZE, Color.BLACK);
		questionFont = create_font(FONT_OPENSANS_FILENAME, FONT_QUESTION_SIZE, Color.BLACK);
		optionFont = create_font(FONT_ELIGIBLE_FILENAME, FONT_OPTION_SIZE, Color.BLACK);
		
		goodSound = load_sound(GOOD_SOUND_FILENAME);
		badSound = load_sound(BAD_SOUND_FILENAME);
	}
	
	static int question_number;
	
	Sprite question_image, question_frame;
	Text question;
	ButtonSprite[] options_frame = new ButtonSprite[OPTIONS_COUNT];
	Text[] options = new Text[OPTIONS_COUNT];
	
	@Override
	protected void init_scene() {
		question_number = 0;
		build_ui_part();
		build_question_part();
	}
	
	abstract void update_question(int number, int category);
	
	String set_title(){
		return "Belajar";
	}
	
	void build_ui_part(){
		final Text title = create_text(getFontTitle(), set_title());
		attach(title, Alignment.TOP_CENTER);
	}
	
	public void build_question_part(){
		question_frame = create_sprite("gfx/question_frame.png");
		question = create_text(questionFont, 200, HorizontalAlign.CENTER);
		attach(question_frame, Alignment.CENTER, 0, -25);
		attach(question, Alignment.CENTER, question_frame);
		
		for(int i = 0;i < OPTIONS_COUNT;i++){
			options_frame[i] = create_button_sprite("gfx/option_frame.png");
			options[i] = create_text(optionFont, 40, HorizontalAlign.CENTER);
			attach(options_frame[i], Alignment.BOTTOM_CENTER);
			attach(options[i], Alignment.CENTER, options_frame[i]);
		}
		int gap_x = 55;
		int gap_y1 = 55;
		int gap_y2 = 10;
		set_position(options_frame[0], -gap_x, -gap_y1);
		set_position(options_frame[1], gap_x, -gap_y1);
		set_position(options_frame[2], -gap_x, -gap_y2);
		set_position(options_frame[3], gap_x, -gap_y2);
	}
	
	@Override
	public void onBackPressed() {
		start_and_finish(MainMenuActivity.class);
	}
	
	ArrayList<Question> find_questions(int category, Question[] questions){
		ArrayList<Question> value = new ArrayList<Question>();
		for(int i = 0;i < questions.length;i++){
			if(questions[i].getKategori() == category)
				value.add(questions[i]);
		}
		return value;
	}
}
