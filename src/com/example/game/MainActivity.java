package com.example.game;

import java.io.IOException;
import java.io.InputStream;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.adt.io.in.IInputStreamOpener;
import org.andengine.util.debug.Debug;

import android.content.Intent;
import android.graphics.Color;

public class MainActivity extends SimpleBaseGameActivity implements Constants{

	private Font mTitleFont;
	private Font mSubFont;
	private Font mQuestionFont;
	
	final static int OPTIONS_COUNT = 4;
	
	private ITexture mQuestionFrameTexture;
	private ITexture[] mOptionsFrameTexture = new ITexture[OPTIONS_COUNT];
	private ITextureRegion mQuestionFrameTextureRegion;
	private ITextureRegion[] mOptionsFrameTextureRegion = new ITextureRegion[OPTIONS_COUNT];
	
	Question[] questions = {
			new Question("Apakah nama Ibukota\nProvinsi Bali?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"
					}, 3),
			new Question("Apakah nama Ibukota\nProvinsi Banten?", 
					new String[]{
					"Jakarta", 
					"Bandung", 
					"Bogor", 
					"Banten"
					}, 3),
			new Question("Apakah nama Ibukota\nProvinsi Jawa Timur?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3),
			new Question("Apakah nama Ibukota\nProvinsi Kalimantan Timur?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3),
			new Question("Apakah nama Ibukota\nProvinsi Bangka Belitung?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3),
			new Question("Apakah nama Ibukota\nProvinsi Maluku Utara?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3),
			new Question("Apakah nama Ibukota\nProvinsi Nusa Tenggara Barat?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3),
			new Question("Apakah nama Ibukota\nProvinsi Papua?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3),
			new Question("Apakah nama Ibukota\nProvinsi Sulawesi Barat?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3),
			new Question("Apakah nama Ibukota\nProvinsi Sumatera Selatan?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3),
	};

	@Override
	public EngineOptions onCreateEngineOptions() {
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	}

	@Override
	protected void onCreateResources() {
		
		try {
			this.mQuestionFrameTexture = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
				@Override
				public InputStream open() throws IOException {
					return getAssets().open("gfx/question_frame.png");
				}
			});
			this.mQuestionFrameTexture.load();
			this.mQuestionFrameTextureRegion = TextureRegionFactory.extractFromTexture(this.mQuestionFrameTexture);
		} catch (IOException e) {
			Debug.e(e);
		}
		
		for(int i = 0;i < OPTIONS_COUNT;i++){
			try{
				this.mOptionsFrameTexture[i] = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
					@Override
					public InputStream open() throws IOException {
						return getAssets().open("gfx/option_frame.png");
					}
				});
				this.mOptionsFrameTexture[i].load();
				this.mOptionsFrameTextureRegion[i] = TextureRegionFactory.extractFromTexture(this.mOptionsFrameTexture[i]);
			} catch (IOException e){
				Debug.e(e);
			}
		}
		
		final ITexture fontTitleTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		final ITexture fontSubTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		final ITexture fontQuestionTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		FontFactory.setAssetBasePath("font/");
		this.mTitleFont = FontFactory.createFromAsset(this.getFontManager(), fontTitleTexture, this.getAssets(), "Forque.ttf", 30, true, Color.BLACK);
		this.mTitleFont.load();
		this.mSubFont = FontFactory.createFromAsset(this.getFontManager(), fontSubTexture, this.getAssets(), "OpenSans-Regular.ttf", 20, true, Color.BLACK);
		this.mSubFont.load();
		this.mQuestionFont = FontFactory.createFromAsset(this.getFontManager(), fontQuestionTexture, this.getAssets(), "OpenSans-Regular.ttf", 14, true, Color.BLACK);
		this.mQuestionFont.load();
	}
	
	static int question_number;

	@Override
	protected Scene onCreateScene() {
		question_number = 0;
		
		final Scene scene = new Scene();
		scene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));
		
		final Sprite question_frame = new Sprite(0, 0, this.mQuestionFrameTextureRegion, this.getVertexBufferObjectManager());
		scene.attachChild(question_frame);
		question_frame.setPosition(CAMERA_WIDTH/2 - question_frame.getWidth()/2, CAMERA_HEIGHT/2 - question_frame.getHeight()/2);
		
		final Text title = new Text(0, 0, mTitleFont, "Main", this.getVertexBufferObjectManager());
		scene.attachChild(title);
		title.setPosition(CAMERA_WIDTH/2 - title.getWidth()/2, 10);
		final Text level = new Text(0, 0, mSubFont, "Level", this.getVertexBufferObjectManager());
		scene.attachChild(level);
		level.setPosition(10, 50);
		final Text level_number = new Text(0, 0, mSubFont, "", 2, this.getVertexBufferObjectManager());
		level.attachChild(level_number);
		level_number.setText("1");
		level_number.setPosition(level.getWidth()+10, 0);
		final Text soal = new Text(0, 0, mSubFont, "/10", this.getVertexBufferObjectManager());
		scene.attachChild(soal);
		soal.setPosition(CAMERA_WIDTH - (soal.getWidth()+10), 50);
		final Text soal_number = new Text(0, 0, mSubFont, "", 2, this.getVertexBufferObjectManager());
		final Text question = new Text(0, 0, mQuestionFont, "", 200, new TextOptions(HorizontalAlign.CENTER), this.getVertexBufferObjectManager());
		soal.attachChild(soal_number);
		question_frame.attachChild(question);
		question.setPosition(question_frame.getWidth()/2 - question.getWidth()/2, question_frame.getHeight()/2 - question.getHeight()/2);
		final Text[] options = new Text[OPTIONS_COUNT];
		final Sprite[] options_frame = new Sprite[OPTIONS_COUNT];
		for(int i = 0;i < OPTIONS_COUNT;i++){
			final int max_update = questions.length;
			options_frame[i] = new Sprite(0, 0, this.mOptionsFrameTextureRegion[i], this.getVertexBufferObjectManager()){
				@Override
				public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
						float pTouchAreaLocalX, float pTouchAreaLocalY) {
					if(pSceneTouchEvent.isActionUp() && question_number < max_update){
						update_question(question_number, question, question_frame, soal_number, options, options_frame);
						question_number++;
					}
					if(question_number == max_update){
						startActivity(new Intent(MainActivity.this, EndMainActivity.class));
						finish();
					}
					return super
							.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
				}
			};
			options[i] = new Text(0, 0, mQuestionFont, "", 40, new TextOptions(HorizontalAlign.CENTER), this.getVertexBufferObjectManager());
			options_frame[i].attachChild(options[i]);
			scene.attachChild(options_frame[i]);
			scene.registerTouchArea(options_frame[i]);
		}
		options_frame[0].setPosition(CAMERA_WIDTH/4 - options_frame[0].getWidth()/2, 245 - options_frame[0].getHeight()/2);
		options_frame[1].setPosition(CAMERA_WIDTH/4 - options_frame[1].getWidth()/2, 290 - options_frame[1].getHeight()/2);
		options_frame[2].setPosition(CAMERA_WIDTH/2 + CAMERA_WIDTH/4 - options_frame[2].getWidth()/2, 245 - options_frame[2].getHeight()/2);
		options_frame[3].setPosition(CAMERA_WIDTH/2 + CAMERA_WIDTH/4 - options_frame[3].getWidth()/2, 290 - options_frame[3].getHeight()/2);
		
		update_question(question_number, question, question_frame, soal_number, options, options_frame);
		
		return scene;
	}
	
	void update_question(int index, Text question, Sprite parent, Text soal_number, Text[] options, Sprite[] options_frame){
		soal_number.setText(""+(index+1));
		soal_number.setPosition(-(soal_number.getWidth()+2), 0);
		question.setText(questions[index].getQuestion());
		question.setPosition(parent.getWidth()/2 - question.getWidth()/2, parent.getHeight()/2 - question.getHeight()/2);
		for(int i = 0;i < OPTIONS_COUNT;i++){
			options[i].setText(questions[index].getOptions()[i]);
			options[i].setPosition(options_frame[i].getWidth()/2 - options[i].getWidth()/2, options_frame[i].getHeight()/2 - options[i].getHeight()/2);
		}
	}
	
	@Override
	public void onBackPressed() {
		startActivity(new Intent(this, Game.class));
		finish();
	}

}
