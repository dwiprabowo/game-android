package com.example.game;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.opengl.texture.region.ITextureRegion;

import android.app.AlertDialog;
import android.content.DialogInterface;

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
				startAndFinish(ChooseLevelActivity.class);
				return true;
			case MENU_BELAJAR:
				Utils.log("belajar...");
				return true;
			case MENU_SKOR:
				Utils.log("skor...");
				return true;
			case MENU_SETTING:
				Utils.log("setting...");
				return true;
			case MENU_ABOUT:
				Utils.log("about...");
				return true;
			case MENU_KELUAR:
				final AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setMessage("Anda Yakin Keluar?").setPositiveButton("Ya", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						MainMenuActivity.this.finish();
					}
				}).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						AlertDialog dialog = builder.create();
						dialog.show();
					}
				});
				return true;
			default:
				return false;
		}
	}

}
