package com.example.game.activities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.text.Text;

import com.example.game.Alignment;
import com.example.game.GameData;
import com.example.game.Question;
import com.example.game.Utils;

public class MainActivity extends QuestionActivity{
	
	int poin;
	Text soal_no;
	
	@Override
	protected void init_scene() {
		super.init_scene();
		questions = find_random_questions();
		final Text level_x = create_text(subTitle, "Level "+(Integer.parseInt(get_extra("level"))+1));
		final Text soal = create_text(subTitle, "/"+get_soal(Integer.parseInt(get_extra("level"))));
		soal_no = create_text(subTitle, 4);
		attach(level_x, Alignment.LEFT_TOP, 10, 30);
		attach(soal, Alignment.RIGHT_TOP, -10, 30);
		attach(soal_no, Alignment.MIDDLE_LEFT, soal);
		poin = 0;
		update_question(question_number, 0);
	}
	
	@Override
	public void onBackPressed() {
		start_and_finish(MainMenuActivity.class);
	}

	@Override
	void update_question(int number, int category) {
		soal_no.setText(number+1+"");
		soal_no.setPosition( -(soal_no.getWidth()+2), 0);
		Question question = questions.get(number);
		if(question_image!=null)question_image.detachSelf();
		if(question.getPath() != null){
			question_image = create_sprite(question.getPath());
			attach(question_image, question_frame, Alignment.TOP_CENTER, 0, 4);
		}
		
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
	
	@Override
	public void button_sprite_clicked(ButtonSprite buttonSprite) {
		Question question = questions.get(question_number);
		for(int i = 0;i < OPTIONS_COUNT;i++){
			if(buttonSprite == options_frame[i]){
				if(question.getAnswer() == i){
					poin += question.getPoin();
					play(goodSound);
				}else{
					play(badSound);
				}
				question_number++;
				if(question_number == questions.size())start_and_finish(EndMainActivity.class, "{ 'poin': "+poin+", 'level': "+get_extra("level")+"}");
				else update_question(question_number, 0);
				break;
			}
		}
	}
	
	@Override
	String set_title() { return "Main"; }
	
	ArrayList<Question> find_random_questions(){
		ArrayList<Question> value = new ArrayList<Question>();
		ArrayList<Integer> index_soal = new ArrayList<Integer>();
		for(int i = 0;i < KATEGORI_COUNT;i++){
			int randomNumber = i*10+randInt(0, 9);
			index_soal.add(randomNumber);
			value.add(GameData.QUESTIONS[randomNumber]);
		}

		for(int i = 0;i < get_soal(Integer.parseInt(get_extra("level")))-KATEGORI_COUNT;i++){
			boolean finish = false;
			int randomBefore = -1;
			while(!finish){
				if(value.size() == get_soal(Integer.parseInt(get_extra("level")))){
					Utils.log("finish!!!");
					finish = true;
					continue;
				}
				int randomKategori = randInt(0, KATEGORI_COUNT-1);
				int randomNumber = randomKategori*10+randInt(0, 9);
				Utils.log("kategori "+randomKategori);
				Utils.log("number "+randomNumber);
				if(randomBefore == randomKategori)
					continue;
				boolean same = false;
				for(int j = 0; j < index_soal.size();j++){
					if(randomNumber == index_soal.get(j)){
						same = true;break;
					}
				}
				if(!same){
					index_soal.add(randomNumber);
					value.add(GameData.QUESTIONS[randomNumber]);
					randomBefore = randomKategori;
				}
				Utils.log("value size: "+value.size());
				Utils.log("size needed :"+get_soal(Integer.parseInt(get_extra("level"))));
			}
		}
		long seed = System.nanoTime();
		Collections.shuffle(value, new Random(seed));
		return value;
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

}
