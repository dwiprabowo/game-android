package com.example.game;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.content.Intent;
import android.opengl.GLES20;

public class Game extends SimpleBaseGameActivity implements Constants, IOnMenuItemClickListener{
	
	protected Camera mCamera;
	protected Scene mMainScene;
	protected MenuScene mMenuScene;
	private BitmapTextureAtlas mMenuTexture;
	protected ITextureRegion mMenuMainTextureRegion;
	protected ITextureRegion mMenuBelajarTextureRegion;
	protected ITextureRegion mMenuSkorTextureRegion;
	protected ITextureRegion mMenuSettingTextureRegion;
	protected ITextureRegion mMenuAboutTextureRegion;
	protected ITextureRegion mMenuKeluarTextureRegion;
	
	protected static final int MENU_MAIN = 0;
	protected static final int MENU_BELAJAR = MENU_MAIN + 1;
	protected static final int MENU_SKOR = MENU_BELAJAR + 1;
	protected static final int MENU_SETTING = MENU_SKOR + 1;
	protected static final int MENU_ABOUT = MENU_SETTING + 1;
	protected static final int MENU_KELUAR = MENU_ABOUT + 1;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera);
	}

	@Override
	protected void onCreateResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		this.mMenuTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 512, TextureOptions.BILINEAR);
		this.mMenuMainTextureRegion = 
				BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "menu_main.png", 0, 0);
		this.mMenuBelajarTextureRegion = 
				BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "menu_belajar.png", 0, 50);
		this.mMenuSkorTextureRegion = 
				BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "menu_skor.png", 0, 100);
		this.mMenuSettingTextureRegion = 
				BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "menu_setting.png", 0, 150);
		this.mMenuAboutTextureRegion = 
				BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "menu_about.png", 0, 200);
		this.mMenuKeluarTextureRegion = 
				BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "menu_keluar.png", 0, 250);
		this.mMenuTexture.load();
	}

	@Override
	protected Scene onCreateScene() {
		SplashActivity.getInstance().finish();
		this.mEngine.registerUpdateHandler(new FPSLogger());
		this.createMenuScene();
		this.mMainScene = new Scene();
		this.mMainScene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));
		this.mMainScene.setChildScene(mMenuScene, false, true, true);
		return this.mMainScene;
	}
	
	protected void createMenuScene(){
		this.mMenuScene = new MenuScene(this.mCamera);
		final SpriteMenuItem mainMenuItem = 
				new SpriteMenuItem(MENU_MAIN, this.mMenuMainTextureRegion, this.getVertexBufferObjectManager());
		mainMenuItem.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
		this.mMenuScene.addMenuItem(mainMenuItem);
		final SpriteMenuItem belajarMenuItem = 
				new SpriteMenuItem(MENU_BELAJAR, this.mMenuBelajarTextureRegion, this.getVertexBufferObjectManager());
		belajarMenuItem.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
		this.mMenuScene.addMenuItem(belajarMenuItem);
		final SpriteMenuItem skorMenuItem = 
				new SpriteMenuItem(MENU_SKOR, this.mMenuSkorTextureRegion, this.getVertexBufferObjectManager());
		skorMenuItem.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
		this.mMenuScene.addMenuItem(skorMenuItem);
		final SpriteMenuItem settingMenuItem = 
				new SpriteMenuItem(MENU_SETTING, this.mMenuSettingTextureRegion, this.getVertexBufferObjectManager());
		settingMenuItem.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
		this.mMenuScene.addMenuItem(settingMenuItem);
		final SpriteMenuItem aboutMenuItem = 
				new SpriteMenuItem(MENU_ABOUT, this.mMenuAboutTextureRegion, this.getVertexBufferObjectManager());
		aboutMenuItem.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
		this.mMenuScene.addMenuItem(aboutMenuItem);
		final SpriteMenuItem keluarMenuItem = 
				new SpriteMenuItem(MENU_KELUAR, this.mMenuKeluarTextureRegion, this.getVertexBufferObjectManager());
		aboutMenuItem.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
		this.mMenuScene.addMenuItem(keluarMenuItem);
		
		this.mMenuScene.buildAnimations();
		this.mMenuScene.setBackgroundEnabled(false);
		this.mMenuScene.setOnMenuItemClickListener(this);
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		switch(pMenuItem.getID()) {
			case MENU_MAIN:
				this.startActivity(new Intent(this, ChooseLevelActivity.class));
				return true;
			case MENU_BELAJAR:
				System.out.println("belajar...");
				return true;
			case MENU_SKOR:
				System.out.println("skor...");
				return true;
			case MENU_SETTING:
				System.out.println("setting...");
				return true;
			case MENU_ABOUT:
				System.out.println("about...");
				return true;
			case MENU_KELUAR:
				this.finish();
				return true;
			default:
				return false;
		}
	}

}
