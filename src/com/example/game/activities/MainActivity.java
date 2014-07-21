package com.example.game.activities;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.HorizontalAlign;

import com.example.game.Alignment;
import com.example.game.GameActivityModel;
import com.example.game.GameData;
import com.example.game.Question;
import com.example.game.Utils;

import android.graphics.Color;

public class MainActivity extends QuestionActivity{
	
	int poin;
	
	@Override
	protected void init_scene() {
		super.init_scene();
		poin = 0;
		update_question(question_number, 0);
	}
	
	@Override
	public void onBackPressed() {
		start_and_finish(MainMenuActivity.class);
	}

	@Override
	void update_question(int number, int category) {
		Question question = questions.get(number);
		if(question.getPath() != null){
			if(question_image != null)
				question_image.detachSelf();
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

}
