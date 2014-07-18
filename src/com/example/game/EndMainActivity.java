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
import org.andengine.util.adt.io.in.IInputStreamOpener;
import org.andengine.util.debug.Debug;

import android.content.Intent;
import android.graphics.Color;

public class EndMainActivity extends SimpleBaseGameActivity implements Constants{
	
	final static int BUTTON_COUNT = 3;
	private ITexture[] mButtonsFrameTexture = new ITexture[BUTTON_COUNT];
	private ITextureRegion[] mButtonsFrameTextureRegion = new ITextureRegion[BUTTON_COUNT];
	
	private ITexture mFrameLevelEndTexture;
	private ITextureRegion mFrameLevelEndTextureRegion;
	
	private Font mFont;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	}

	@Override
	protected void onCreateResources() {
		for(int i = 0;i < BUTTON_COUNT;i++){
			try{
				this.mButtonsFrameTexture[i] = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
					@Override
					public InputStream open() throws IOException {
						return getAssets().open("gfx/global_button_frame.png");
					}
				});
				this.mButtonsFrameTexture[i].load();
				this.mButtonsFrameTextureRegion[i] = TextureRegionFactory.extractFromTexture(this.mButtonsFrameTexture[i]);
			} catch (IOException e){
				Debug.e(e);
			}
		}
		try{
			this.mFrameLevelEndTexture = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
				@Override
				public InputStream open() throws IOException {
					return getAssets().open("gfx/level_end_frame.png");
				}
			});
			this.mFrameLevelEndTexture.load();
			this.mFrameLevelEndTextureRegion = TextureRegionFactory.extractFromTexture(this.mFrameLevelEndTexture);
		} catch (IOException e){
			Debug.e(e);
		}
		FontFactory.setAssetBasePath("font/");
		final ITexture fontTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		this.mFont = FontFactory.createFromAsset(this.getFontManager(), fontTexture, this.getAssets(), "OpenSans-Regular.ttf", 16, true, Color.BLACK);
		this.mFont.load();
	}

	@Override
	protected Scene onCreateScene() {
		final Scene scene = new Scene();
		scene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));
		
		final Sprite frame_level_end = new Sprite(0, 0, mFrameLevelEndTextureRegion, this.getVertexBufferObjectManager());
		final Text level_end = new Text(0, 0, mFont, "Level 1 Selesai", this.getVertexBufferObjectManager());
		final Text skor = new Text(0, 0, mFont, "Skor kamu: "+10+" poin", this.getVertexBufferObjectManager());
		scene.attachChild(frame_level_end);
		frame_level_end.setX(CAMERA_WIDTH/2 - frame_level_end.getWidth()/2);
		frame_level_end.setY(20);
		frame_level_end.attachChild(level_end);
		frame_level_end.attachChild(skor);
		level_end.setX(frame_level_end.getWidth()/2 - level_end.getWidth()/2);level_end.setY(20);
		skor.setX(frame_level_end.getWidth()/2 - skor.getWidth()/2);skor.setY(60);
		
		final Sprite[] button_frame = new Sprite[BUTTON_COUNT];
		final Text[] button_text = new Text[BUTTON_COUNT];
		final String[] texts = new String[]{"Ulang Permainan", "Level Lain", "Menu Utama"};
		int startPosY = 130;
		for(int i = 0;i < BUTTON_COUNT;i++){
			final int number = i;
			button_frame[i] = new Sprite(0, 0, mButtonsFrameTextureRegion[i], this.getVertexBufferObjectManager()){
				@Override
				public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
						float pTouchAreaLocalX, float pTouchAreaLocalY) {
					if(pSceneTouchEvent.isActionUp())
						menu(number);
					return super
							.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
				}
			};
			button_text[i] = new Text(0, 0, mFont, texts[i], this.getVertexBufferObjectManager());
			button_frame[i].attachChild(button_text[i]);
			button_text[i].setPosition(button_frame[i].getWidth()/2 - button_text[i].getWidth()/2, button_frame[i].getHeight()/2 - button_text[i].getHeight()/2);
			scene.attachChild(button_frame[i]);
			button_frame[i].setX(CAMERA_WIDTH/2 - button_frame[i].getWidth()/2);
			button_frame[i].setY(startPosY);startPosY+=60;
			scene.registerTouchArea(button_frame[i]);
		}
		
		return scene;
	}
	
	void menu(int number){
		switch (number) {
		case 0:
				startActivity(new Intent(this, MainActivity.class));
			break;
		case 1:
				startActivity(new Intent(this, ChooseLevelActivity.class));
			break;
		case 2:
				startActivity(new Intent(this, Game.class));
			break;
		default:
			break;
		}
		finish();
	}

}
