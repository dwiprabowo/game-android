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
import com.example.game.Utils;

public class BelajarActivity extends GameActivityModel{

	ArrayList<Question> questions = new ArrayList<Question>();
	
	Font subTitle, monoFont, questionFont, optionFont;
	private Sound goodSound, badSound;
	
	@Override
	protected void init_resources() {
		Utils.log("category id : "+get_extra("category"));
		category = Integer.parseInt(get_extra("category"));
		questions = find_questions(category, GameData.QUESTIONS);
		
		subTitle = create_font("Forque.ttf", 20, Color.BLACK);
		monoFont = create_font("Anonymous.ttf", 16, Color.BLACK);
		questionFont = create_font("OpenSans-Regular.ttf", 16, Color.BLACK);
		optionFont = create_font("Eligible-Regular.ttf", 12, Color.BLACK);
		
		goodSound = load_sound("good.wav");
		badSound = load_sound("bad.mp3");
	}
	
	static int question_number;
	
	Sprite question_image;
	ButtonSprite reset_button;
	Sprite question_frame;
	Text question;
	ButtonSprite[] options_frame = new ButtonSprite[OPTIONS_COUNT];
	Text[] options = new Text[OPTIONS_COUNT];
	Text poin_number;
	int category;
	
	@Override
	protected void init_scene() {
		question_number = 0;
		build_ui_part();
		build_question_part();
		update_question(question_number, category);
	}
	
	void update_question(int number, int category){
		Question question = questions.get(number);
		if(question.getPath() != null){
			if(question_image != null)
				question_image.detachSelf();
			question_image = create_sprite(question.getPath());
			attach(question_image, question_frame, Alignment.TOP_CENTER, 0, 4);
		}
		
		Utils.log(get_poin(category));
		poin_number.setText(String.valueOf(get_poin(category)));
		
		poin_number.setX(-(poin_number.getWidth()+4));
		
		this.question.setText(question.getQuestion());
		if(question.getPath() != null){
			set_position(this.question, Alignment.BOTTOM_CENTER);
		} else {
			set_position(this.question, Alignment.CENTER);
		}
		
		for(int i = 0;i < OPTIONS_COUNT;i++){
			options[i].setText(question.getOptions()[i]);
			set_position(options[i], Alignment.CENTER);
		}
	}
	
	void build_ui_part(){
		final Text title = create_text(getFontTitle(), "Belajar");
		final Text benar = create_text(subTitle, "Benar :");
		poin_number = create_text(monoFont, 5);
		final Text poin = create_text(subTitle, "poin");
		final Text reset = create_text(subTitle, "reset");
		reset_button = create_button_sprite("gfx/small_button_frame.png");
		
		float subtitle_gap_y = 28;
		attach(title, Alignment.TOP_CENTER);
		attach(reset_button, Alignment.RIGHT_TOP, -10, subtitle_gap_y);
		attach(reset, Alignment.CENTER, reset_button);
		attach(benar, Alignment.LEFT_TOP, 10, subtitle_gap_y+reset.getY());
		attach(poin, Alignment.TOP_CENTER, 10, subtitle_gap_y+reset.getY());
		attach(poin_number, poin, Alignment.MIDDLE_RIGHT, 0, 2);
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
		start_and_finish(PilihKategoriBelajarActivity.class);
	}
	
	ArrayList<Question> find_questions(int category, Question[] questions){
		ArrayList<Question> value = new ArrayList<Question>();
		for(int i = 0;i < questions.length;i++){
			if(questions[i].getKategori() == category)
				value.add(questions[i]);
		}
		return value;
	}
	
	@Override
	public void button_sprite_clicked(ButtonSprite buttonSprite) {
		if(buttonSprite == reset_button){
			Utils.log("reset poin");
			reset_poin();
		}
		Question question = questions.get(question_number);
		for(int i = 0;i < OPTIONS_COUNT;i++){
			if(buttonSprite == options_frame[i]){
				if(question.getAnswer() == i){
					set_poin((int) (get_poin(category)+question.getPoin()), category);
					play(goodSound);
				}else{
					play(badSound);
				}
				question_number++;
				if(question_number == questions.size())
					question_number = 0;
				update_question(question_number, category);
				break;
			}
		}
	}
	
	void reset_poin(){
		question_number++;
		if(question_number == questions.size())
			question_number = 0;
		set_poin( 0, category);
		update_question(question_number, category);
	}
	
}
