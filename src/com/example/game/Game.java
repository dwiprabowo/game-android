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
import org.andengine.entity.text.Text;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.content.Intent;
import android.graphics.Color;
import android.opengl.GLES20;

public class Game extends SimpleBaseGameActivity implements Constants, IOnMenuItemClickListener{
	
	protected Camera mCamera;
	protected Scene mMainScene;
	protected MenuScene mMenuScene;
	private BitmapTextureAtlas mMenuTexture;
	private Font mMenuFont;
	
	final static int MENU_MAIN_COUNT = 6;
	
	protected ITextureRegion[] mMenuMainTextureRegion = new ITextureRegion[MENU_MAIN_COUNT];
//	protected ITextureRegion mMenuBelajarTextureRegion;
//	protected ITextureRegion mMenuSkorTextureRegion;
//	protected ITextureRegion mMenuSettingTextureRegion;
//	protected ITextureRegion mMenuAboutTextureRegion;
//	protected ITextureRegion mMenuKeluarTextureRegion;
	
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
		int texturePos = 0;
		for(int i = 0;i < MENU_MAIN_COUNT;i++){
			this.mMenuMainTextureRegion[i] = 
				BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "menu_main_frame.png", 0, texturePos);
			texturePos+=50;
		}
		this.mMenuTexture.load();
		
		final ITexture menuFontTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		FontFactory.setAssetBasePath("font/");
		this.mMenuFont = FontFactory.createFromAsset(this.getFontManager(), menuFontTexture, this.getAssets(), "Forque.ttf", 24, true, Color.BLACK);
		this.mMenuFont.load();
	}

	@Override
	protected Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());
		this.createMenuScene();
		this.mMainScene = new Scene();
		this.mMainScene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));
		this.mMainScene.setChildScene(mMenuScene, false, true, true);
		return this.mMainScene;
	}
	
	protected void createMenuScene(){
		this.mMenuScene = new MenuScene(this.mCamera);
		final SpriteMenuItem[] mainMenuItems = new SpriteMenuItem[MENU_MAIN_COUNT];
		for(int i = 0;i < MENU_MAIN_COUNT;i++){
			mainMenuItems[i] = new SpriteMenuItem(i, this.mMenuMainTextureRegion[i], this.getVertexBufferObjectManager());
			mainMenuItems[i].setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
			this.mMenuScene.addMenuItem(mainMenuItems[i]);
		}
		
		this.mMenuScene.buildAnimations();
		this.mMenuScene.setBackgroundEnabled(false);
		this.mMenuScene.setOnMenuItemClickListener(this);
		
		final String[] menu_string = {"Main", "Belajar", "Skor Tertinggi", "Setting", "About", "Keluar"};
		
		for(int i = 0;i < MENU_MAIN_COUNT;i++){
			final Text menu_text = new Text(0, 0, mMenuFont, menu_string[i], this.getVertexBufferObjectManager());
			mainMenuItems[i].attachChild(menu_text);
			menu_text.setX(mainMenuItems[i].getWidth()/2 - menu_text.getWidth()/2);
			menu_text.setY(mainMenuItems[i].getHeight()/2 - menu_text.getHeight()/2);
		}
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		switch(pMenuItem.getID()) {
			case MENU_MAIN:
				startActivity(new Intent(this, ChooseLevelActivity.class));
				finish();
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
				finish();
				return true;
			default:
				return false;
		}
	}

}
