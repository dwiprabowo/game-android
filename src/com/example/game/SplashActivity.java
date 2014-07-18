package com.example.game;

import java.io.IOException;
import java.io.InputStream;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.util.FPSLogger;
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

public class SplashActivity extends SimpleBaseGameActivity implements Constants{

	protected Camera mCamera;
	protected Scene mMainScene;
	private Font mTitleFont;
	private ITexture mTexture;
	private ITextureRegion mSplashTextureRegion;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera);
	}

	@Override
	protected void onCreateResources() {
		try {
			this.mTexture = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
				@Override
				public InputStream open() throws IOException {
					return getAssets().open("gfx/splash_screen.png");
				}
			});
			this.mTexture.load();
			this.mSplashTextureRegion = TextureRegionFactory.extractFromTexture(this.mTexture);
		} catch (IOException e) {
			Debug.e(e);
		}
		
		final ITexture fontTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		FontFactory.setAssetBasePath("font/");
		this.mTitleFont = FontFactory.createFromAsset(this.getFontManager(), fontTexture, this.getAssets(), "Forque.ttf", 28, true, Color.BLACK);
		this.mTitleFont.load();
	}

	@Override
	protected Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());
		this.mMainScene = new Scene();
		final Sprite face = new Sprite(0, 0, this.mSplashTextureRegion, this.getVertexBufferObjectManager());
		final Text title = new Text(0, 0, mTitleFont, "Uji Ke-Indonesia-anmu!", this.getVertexBufferObjectManager());
		
		mMainScene.attachChild(face);
		mMainScene.attachChild(title);
		
		title.setX(CAMERA_WIDTH/2 - title.getWidth()/2);title.setY(100);
		
		mMainScene.registerUpdateHandler(new TimerHandler(5.0f, new ITimerCallback() {
			
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				SplashActivity.this.mMainScene.unregisterUpdateHandler(pTimerHandler);
				SplashActivity.this.startActivity(new Intent(SplashActivity.this, Game.class));
				SplashActivity.this.finish();
			}
		}));
		return mMainScene;
	}
}
