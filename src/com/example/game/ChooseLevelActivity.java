package com.example.game;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.debug.Debug;

import android.content.Intent;
import android.graphics.Color;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga
 *
 * @author Nicolas Gramlich
 * @since 11:54:51 - 03.04.2010
 */
public class ChooseLevelActivity extends SimpleBaseGameActivity implements Constants, OnClickListener {

	private Font mFont;
	private Font mTextFont;
	private Font mButtonFont;
	private Font mMonoFont;
	
	private ITextureRegion mLevelTextureRegion;
	private BuildableBitmapTextureAtlas mBitmapTextureAtlas;

	@Override
	public EngineOptions onCreateEngineOptions() {
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	}

	@Override
	public void onCreateResources() {
		final ITexture fontTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		final ITexture textFontTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		final ITexture monoFontTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		final ITexture buttonFontTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);

		FontFactory.setAssetBasePath("font/");
		this.mFont = FontFactory.createFromAsset(this.getFontManager(), fontTexture, this.getAssets(), "Forque.ttf", 30, true, Color.BLACK);
		this.mFont.load();
		this.mTextFont = FontFactory.createFromAsset(this.getFontManager(), textFontTexture, this.getAssets(), "OpenSans-Regular.ttf", 18, true, Color.WHITE);
		this.mTextFont.load();
		this.mMonoFont = FontFactory.createFromAsset(this.getFontManager(), monoFontTexture, this.getAssets(), "Anonymous.ttf", 12, true, Color.WHITE);
		this.mMonoFont.load();
		this.mButtonFont = FontFactory.createFromAsset(this.getFontManager(), buttonFontTexture, this.getAssets(), "OpenSans-Regular.ttf", 16, true, Color.BLACK);
		this.mButtonFont.load();
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		this.mBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 512, 512);
		this.mLevelTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "level.png");
		try {
			this.mBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.mBitmapTextureAtlas.load();
		} catch (TextureAtlasBuilderException e) {
			Debug.e(e);
		}
	}

	@Override
	public Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		final Scene scene = new Scene();
		scene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));

		final VertexBufferObjectManager vertexBufferObjectManager = this.getVertexBufferObjectManager();
		final Text text = new Text(0, 30, this.mFont, "Pilih Level", vertexBufferObjectManager);
		text.setX(CAMERA_WIDTH/2 - text.getWidth()/2);
		scene.attachChild(text);
		
		final Text text_level = new Text(0, 0, mTextFont, "Level 1", this.getVertexBufferObjectManager());
		final Text text_skor = new Text(0, 0, mMonoFont, "Skor =", vertexBufferObjectManager);
		final Text text_soal  = new Text(0, 0, mMonoFont, "Soal =", vertexBufferObjectManager);
		final Text text_skor_number = new Text(0, 0, mMonoFont, "50,00", vertexBufferObjectManager);
		final Text text_soal_number = new Text(0, 0, mMonoFont, "10", vertexBufferObjectManager);
		final Text mulai = new Text(0, 0, mButtonFont, "Mulai", vertexBufferObjectManager);
		
		final float centerX = (CAMERA_WIDTH - this.mLevelTextureRegion.getWidth()) / 2;
		final float centerY = (CAMERA_HEIGHT - this.mLevelTextureRegion.getHeight()) / 2;
		final Sprite level = new ButtonSprite(centerX, centerY, this.mLevelTextureRegion, this.getVertexBufferObjectManager(), this);
		
		scene.registerTouchArea(level);
		scene.attachChild(level);
		level.attachChild(text_level);
		level.attachChild(text_skor);
		level.attachChild(text_soal);
		level.attachChild(text_skor_number);
		level.attachChild(text_soal_number);
		level.attachChild(mulai);
		text_level.setX(level.getWidth()/2 - text_level.getWidth()/2);
		text_skor.setX(level.getWidth()/2 - (text_skor.getWidth() + 10));text_skor.setY(26);
		text_soal.setX(level.getWidth()/2 - (text_soal.getWidth() + 10));text_soal.setY(42);
		text_skor_number.setX(level.getWidth()/2);text_skor_number.setY(26);
		text_soal_number.setX(level.getWidth()/2);text_soal_number.setY(42);
		mulai.setX(level.getWidth()/2 - mulai.getWidth()/2);mulai.setY(level.getHeight() - (mulai.getHeight()+12));
		
		Utils.log("test sprite touch");
		
		return scene;
	}

	@Override
	public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
			float pTouchAreaLocalY) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				ChooseLevelActivity.this.startActivity(new Intent(ChooseLevelActivity.this, MainActivity.class));
				ChooseLevelActivity.this.finish();
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		startActivity(new Intent(this, Game.class));
		finish();
	}
}
