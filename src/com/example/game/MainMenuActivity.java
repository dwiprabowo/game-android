package com.example.game;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.opengl.texture.region.ITextureRegion;
import android.content.Intent;

public class MainMenuActivity extends GameActivityModel implements Constants, IOnMenuItemClickListener{
	
	final static int MENU_MAIN_COUNT = 6;
	protected ITextureRegion[] mainMenuTextureRegion = new ITextureRegion[MENU_MAIN_COUNT];
	
	protected static final int MENU_MAIN = 0;
	protected static final int MENU_BELAJAR = MENU_MAIN + 1;
	protected static final int MENU_SKOR = MENU_BELAJAR + 1;
	protected static final int MENU_SETTING = MENU_SKOR + 1;
	protected static final int MENU_ABOUT = MENU_SETTING + 1;
	protected static final int MENU_KELUAR = MENU_ABOUT + 1;

	@Override
	protected void init_resources() {
		for(int i = 0;i < MENU_MAIN_COUNT;i++){
			mainMenuTextureRegion[i] = texture_region("gfx/menu/menu_main_frame.png");
		}
	}

	@Override
	protected void init_scene() {
		getScene().setChildScene(
			build_menu_scene(
					mainMenuTextureRegion, 
					10, 
					this, 
					new String[]{"Main", "Belajar", "Skor Tertinggi", "Setting", "About", "Keluar"}), 
			false, true, true
		);
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
