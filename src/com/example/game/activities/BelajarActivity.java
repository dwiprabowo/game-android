package com.example.game.activities;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.text.Text;
import com.example.game.Alignment;
import com.example.game.GameData;
import com.example.game.Question;
import com.example.game.Utils;
import com.example.game.activities.wrapper.QuestionActivity;

public class BelajarActivity extends QuestionActivity{
	
	@Override
	protected void init_resources(){
		super.init_resources();
		category = Integer.parseInt(get_extra("category"));
		questions = find_questions(category, GameData.QUESTIONS);
	}
	
	static int question_number;
	
	ButtonSprite reset_button;
	Text poin_number;
	int category;
	
	@Override
	protected void init_scene() {
		question_number = 0;
		super.init_scene();
		build_ui_part_local();
		update_question(question_number, category);
	}
	
	@Override
	public void update_question(int number, int category){
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
	
	void build_ui_part_local(){
		final Text benar = create_text(subTitle, "Benar :");
		poin_number = create_text(monoFont, 5);
		final Text poin = create_text(subTitle, "poin");
		final Text reset = create_text(subTitle, "reset");
		reset_button = create_button_sprite("gfx/small_button_frame.png");
		
		float subtitle_gap_y = 28;
		attach(reset_button, Alignment.RIGHT_TOP, -10, subtitle_gap_y);
		attach(reset, Alignment.CENTER, reset_button);
		attach(benar, Alignment.LEFT_TOP, 10, subtitle_gap_y+reset.getY());
		attach(poin, Alignment.TOP_CENTER, 10, subtitle_gap_y+reset.getY());
		attach(poin_number, poin, Alignment.MIDDLE_RIGHT, 0, 2);
	}
	
	@Override
	public void button_sprite_clicked(ButtonSprite buttonSprite) {
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
		if(buttonSprite == reset_button){
			Utils.log("reset poin");
			reset_poin();
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
