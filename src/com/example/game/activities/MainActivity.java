package com.example.game.activities;

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

import android.graphics.Color;

public class MainActivity extends GameActivityModel implements GameData{

	private Font mSubFont;
	private Font mQuestionFont;
	private Font optionFont;
	
	final static int OPTIONS_COUNT = 4;
	
	private ITextureRegion mQuestionFrameTextureRegion;
	private ITextureRegion[] mOptionsFrameTextureRegion = new ITextureRegion[OPTIONS_COUNT];

	@Override
	protected void init_resources() {
		mQuestionFrameTextureRegion = texture_region("gfx/question_frame.png");
		for(int i = 0;i < OPTIONS_COUNT;i++){
			this.mOptionsFrameTextureRegion[i] = texture_region("gfx/option_frame.png");
		}
		FontFactory.setAssetBasePath("font/");
		final ITexture fontSubTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		final ITexture fontQuestionTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		final ITexture fontOptionTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		this.mSubFont = FontFactory.createFromAsset(this.getFontManager(), fontSubTexture, this.getAssets(), "Anonymous.ttf", 16, true, Color.BLACK);
		this.mSubFont.load();
		this.mQuestionFont = FontFactory.createFromAsset(this.getFontManager(), fontQuestionTexture, this.getAssets(), "OpenSans-Regular.ttf", 16, true, Color.BLACK);
		this.mQuestionFont.load();
		optionFont = FontFactory.createFromAsset(this.getFontManager(), fontOptionTexture, this.getAssets(), "Eligible-Regular.ttf", 12, true, Color.BLACK);
		optionFont.load();
	}
	
	static int question_number;

	@Override
	protected void init_scene(){
		int level = 1;
		question_number = 0;
		
		final Sprite question_frame = new Sprite(0, 0, this.mQuestionFrameTextureRegion, getVBOM());
		attach(question_frame, Alignment.CENTER);set_position(question_frame, 0, -30);
		
		final Text title 		= new Text(0, 0, getFontTitle(), "Main", getVBOM());
		final Text level_text 	= new Text(0, 0, mSubFont, "Level", getVBOM());
		final Text level_number = new Text(0, 0, mSubFont, "", 2, getVBOM());
		final Text soal 		= new Text(0, 0, mSubFont, "/10", getVBOM());
		final Text soal_number 	= new Text(0, 0, mSubFont, "", 2, getVBOM());
		final Text question 	= new Text(0, 0, mQuestionFont, "", 200, new TextOptions(HorizontalAlign.CENTER), this.getVertexBufferObjectManager());
		
		attach(title, Alignment.TOP_CENTER);
		attach(level_text, Alignment.LEFT_TOP);set_position(level_text, 10, 25);
		attach(soal, Alignment.RIGHT_TOP);set_position(soal, -10, 25);
		
		level_text.attachChild(level_number);
		level_number.setText(""+level);
		level_number.setPosition(level_text.getWidth()+10, 0);
		
		soal.attachChild(soal_number);
		
		attach(question, Alignment.CENTER, question_frame);
		
		final Text[] options = new Text[OPTIONS_COUNT];
		final Sprite[] options_frame = new Sprite[OPTIONS_COUNT];
		for(int i = 0;i < OPTIONS_COUNT;i++){
			final int max_update = QUESTIONS.length;
			options_frame[i] = new Sprite(0, 0, this.mOptionsFrameTextureRegion[i], this.getVertexBufferObjectManager()){
				@Override
				public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
						float pTouchAreaLocalX, float pTouchAreaLocalY) {
					if(pSceneTouchEvent.isActionUp() && question_number < max_update){
						update_question(question_number, question, question_frame, soal_number, options, options_frame);
						question_number++;
					}
					if(question_number == max_update){
						start_and_finish(EndMainActivity.class);
					}
					return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
				}
			};
			options[i] = new Text(0, 0, optionFont, "", 40, new TextOptions(HorizontalAlign.CENTER), this.getVertexBufferObjectManager());
			options_frame[i].attachChild(options[i]);
			attach(options_frame[i], Alignment.BOTTOM_CENTER);
			getScene().registerTouchArea(options_frame[i]);
		}
		int gap_x = 55;
		int gap_y1 = 55;
		int gap_y2 = 10;
		set_position(options_frame[0], -gap_x, -gap_y1);
		set_position(options_frame[1], gap_x, -gap_y1);
		set_position(options_frame[2], -gap_x, -gap_y2);
		set_position(options_frame[3], gap_x, -gap_y2);
		
		update_question(question_number, question, question_frame, soal_number, options, options_frame);
	}
	
	void update_question(int index, Text question, Sprite parent, Text soal_number, Text[] options, Sprite[] options_frame){
		soal_number.setText(""+(index+1));
		soal_number.setPosition(-(soal_number.getWidth()+2), 0);
		question.setText(QUESTIONS[index].getQuestion());
		set_position(question, Alignment.CENTER);
		for(int i = 0;i < OPTIONS_COUNT;i++){
			options[i].setText(QUESTIONS[index].getOptions()[i]);
			set_position(options[i], Alignment.CENTER);
		}
	}
	
	@Override
	public void onBackPressed() {
		start_and_finish(MainMenuActivity.class);
	}

}
