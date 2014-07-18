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
	private ITexture mTexture;
	private ITextureRegion mBackgroundTextureRegion;

	@Override
	public EngineOptions onCreateEngineOptions() {
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	}

	@Override
	protected void onCreateResources() {
		try {
			this.mTexture = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
				@Override
				public InputStream open() throws IOException {
					return getAssets().open("gfx/main_background.png");
				}
			});
			this.mTexture.load();
			this.mBackgroundTextureRegion = TextureRegionFactory.extractFromTexture(this.mTexture);
		} catch (IOException e) {
			Debug.e(e);
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

	@Override
	protected Scene onCreateScene() {
		final Scene scene = new Scene();
		scene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));
		
		final Sprite background = new Sprite(0, 0, this.mBackgroundTextureRegion, this.getVertexBufferObjectManager());
		scene.attachChild(background);
		
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
		final Text soal_number = new Text(0, 0, mSubFont, "1", 2, this.getVertexBufferObjectManager());
		soal.attachChild(soal_number);
		soal_number.setPosition(-(soal_number.getWidth()+10), 0);
		
		final Text question = new Text(0, 0, mQuestionFont, "Lorem ipsum dolor sit amat\nLorem ipsum dolor sit amat...?", 200, new TextOptions(HorizontalAlign.CENTER), this.getVertexBufferObjectManager());
		scene.attachChild(question);
		question.setPosition(CAMERA_WIDTH/2 - question.getWidth()/2, CAMERA_HEIGHT/2 - question.getHeight()/2);
		
		final Text[] options = new Text[4];
		final String[] options_text = { "asdf asdf\nasdf", "asdf", "qwerteq", "zxcvasdf asd" };
		for(int i = 0;i < options.length;i++){
			options[i] = new Text(0, 0, mQuestionFont, options_text[i], 40, new TextOptions(HorizontalAlign.CENTER), this.getVertexBufferObjectManager());
			scene.attachChild(options[i]);
		}
		options[0].setPosition(CAMERA_WIDTH/4 - options[0].getWidth()/2, 245 - options[0].getHeight()/2);
		options[1].setPosition(CAMERA_WIDTH/4 - options[1].getWidth()/2, 290 - options[1].getHeight()/2);
		options[2].setPosition(CAMERA_WIDTH/2 + CAMERA_WIDTH/4 - options[2].getWidth()/2, 245 - options[2].getHeight()/2);
		options[3].setPosition(CAMERA_WIDTH/2 + CAMERA_WIDTH/4 - options[3].getWidth()/2, 290 - options[3].getHeight()/2);
		
		return scene;
	}
	
	@Override
	public void onBackPressed() {
		startActivity(new Intent(this, Game.class));
		finish();
	}

}
