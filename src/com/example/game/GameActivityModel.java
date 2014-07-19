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
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.animator.AlphaMenuAnimator;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.shape.RectangularShape;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.ButtonSprite;
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
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.adt.io.in.IInputStreamOpener;
import org.andengine.util.debug.Debug;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.opengl.GLES20;

public abstract class GameActivityModel extends SimpleBaseGameActivity implements Constants, IOnMenuItemClickListener, OnClickListener{
	
	private Camera camera;
	private Scene scene;
	private Font font_title;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	}
	
	@Override
	protected void onCreateResources() {
		load_fonts();
		init_resources();
	}
	
	@Override
	protected Scene onCreateScene() {
		scene = new Scene();
		scene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));
		init_scene();
		return scene;
	}
	
	protected abstract void init_resources();
	protected abstract void init_scene();
	
	public Camera getCamera(){
		return camera;
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public Font getFontTitle(){
		return font_title;
	}
	
	private void load_fonts(){
		FontFactory.setAssetBasePath("font/");
		final ITexture fontTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		this.font_title = FontFactory.createFromAsset(this.getFontManager(), fontTexture, this.getAssets(), "Forque.ttf", 28, true, Color.BLACK);
		this.font_title.load();
	}
	
	public ITextureRegion texture_region(final String path){
		ITexture texture;
		ITextureRegion textureRegion = null;
		try {
			texture = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
				@Override
				public InputStream open() throws IOException {
					return getAssets().open(path);
				}
			});
			texture.load();
			textureRegion = TextureRegionFactory.extractFromTexture(texture);
		} catch (IOException e) {
			Debug.e(e);
		}
		return textureRegion;
	}
	
	public VertexBufferObjectManager getVBOM(){
		return getVertexBufferObjectManager();
	}
	
	public void attach(RectangularShape child, Alignment align, float x, float y){
		attach(child, align);
		set_position(child, x, y);
	}
	
	public void attach(RectangularShape child, RectangularShape parent, Alignment align, float x, float y){
		attach(child, align, parent);
		set_position(child, x, y);
	}
	
	public void attach(RectangularShape child, Alignment align){
		attach(child, align, null);
	}
	
	public void attach(RectangularShape child, Alignment align, RectangularShape parent){
		if(parent==null){
			scene.attachChild(child);
			align(child, align);
		} else {
			parent.attachChild(child);
			align(child, parent, align);
		}
	}
	
	public void align(RectangularShape child, Alignment align){
		align(child, null, align);
	}
	
	public void align(RectangularShape child, RectangularShape parent, Alignment align){
		float w, h;
		if(parent!=null){
			w = parent.getWidth();
			h = parent.getHeight();
		}
		else {
			w = CAMERA_WIDTH;
			h = CAMERA_HEIGHT;
		}
		switch(align){
		case CENTER:
		case TOP_CENTER:
		case BOTTOM_CENTER:
			child.setX(w/2 - child.getWidth()/2);
			break;
		case MIDDLE_RIGHT:
		case RIGHT_TOP:
		case RIGHT_BOTTOM:
			child.setX(w - child.getWidth());
			break;
		default:
			break;
		}
		switch(align){
			case MIDDLE_LEFT:
			case CENTER:
			case MIDDLE_RIGHT:
				child.setY(h/2 - child.getHeight()/2);
				break;
			case LEFT_BOTTOM:
			case BOTTOM_CENTER:
			case RIGHT_BOTTOM:
				child.setY(h - child.getHeight());
				break;
			default:
				break;
		}
	}
	
	public void set_position(RectangularShape object, Alignment align){
		set_position(object, 0, 0, align);
	}
	
	public void set_position(RectangularShape object, float x, float y){
		set_position(object, x, y, null);
	}
	
	public void set_position(RectangularShape object, float x, float y, Alignment align){
		if(align != null){
			if(object.getParent() == scene){
				align(object, align);
			} else {
				align(object, (RectangularShape) object.getParent(), align);
			}
		}
		object.setPosition(object.getX() + x, object.getY() + y);
	}
	
	public MenuScene build_menu_scene(String path, String[] ids, Font font){
		return build_menu_scene(path, ids, 10, font, 0);
	}
	
	public MenuScene build_menu_scene(String path, String[] ids, float spacing, Font font, float offsetY){
		final MenuScene menuScene = new MenuScene(camera);
		final SpriteMenuItem[] items = new SpriteMenuItem[ids.length];
		for(int i = 0;i < ids.length;i++){
			items[i] = create_sprite_menu_item(i, path);
			items[i].setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
			menuScene.addMenuItem(items[i]);
			final Text menu_text = new Text(0, 0, font, ids[i], getVBOM());
			attach(menu_text, Alignment.CENTER, items[i]);
		}
		menuScene.setMenuAnimator(new AlphaMenuAnimator(spacing));
		menuScene.buildAnimations();
		menuScene.setBackgroundEnabled(false);
		menuScene.setOnMenuItemClickListener(this);
		menuScene.setY(offsetY);
		return menuScene;
	}
	
	public void set_menu(String path, String[] ids){
		set_menu(path, ids, 10, font_title, 0);
	}
	
	public void set_menu(String path, String[] ids, float spacing, Font font, float offsetY){
		scene.setChildScene(build_menu_scene(path, ids, spacing, font, offsetY),false, true, true);
	}
	
	public void start_and_finish(Class<?> cls){
		start_and_finish(cls, null);
	}
	
	public void start_and_finish(Class<?> cls, String json_string){
		Intent intent = new Intent(this, cls);
		if(json_string != null)
			intent.putExtra("json_data", json_string);
		startActivity(intent);
		finish();
	}
	
	public String json(String json_string){
		JSONObject json = null;
		try {
			json = new JSONObject(json_string);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}
	
	public String get_extra(String name){
		Intent intent = getIntent();
		JSONObject json = null;
		String json_string = intent.getStringExtra("json_data");
		try {
			json = new JSONObject(json_string);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String value = null;
		try {
			value = json.getString(name);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public Sprite create_sprite(String path){
		ITextureRegion textureRegion = texture_region(path);
		Sprite sprite = new Sprite(0, 0, textureRegion, getVBOM());
		return sprite;
	}
	
	public ButtonSprite create_button_sprite(String path, boolean registerTouchArea){
		ITextureRegion textureRegion = texture_region(path);
		ButtonSprite sprite = new ButtonSprite(0, 0, textureRegion, getVBOM(), this);
		if(registerTouchArea)scene.registerTouchArea(sprite);
		return sprite;
	}
	
	public SpriteMenuItem create_sprite_menu_item(int id, String path){
		ITextureRegion textureRegion = texture_region(path);
		return new SpriteMenuItem(id, textureRegion, getVBOM());
	}
	
	public Text create_text(Font font, int maximumChars, HorizontalAlign align){
		return new Text(0, 0, font, "", maximumChars, new TextOptions(align), getVBOM());
	}
	
	public Text create_text(Font font, int maximumChars){
		return new Text(0, 0, font, "", maximumChars, getVBOM());
	}
	
	public Text create_text(Font font, String text){
		return new Text(0, 0, font, text, getVBOM());
	}
	
	public void change_activity_in(float miliseconds, final Class<?> cls){
		scene.registerUpdateHandler(new TimerHandler(miliseconds, new ITimerCallback(){
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				GameActivityModel.this.scene.unregisterUpdateHandler(pTimerHandler);
				GameActivityModel.this.start_and_finish(cls);
			}
		}));
	}
	
	public void menu_clicked(int menuID){}
	
	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		menu_clicked(pMenuItem.getID());
		return true;
	}

	public void exit_dialog(String msg, String yes, String no){
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg).setPositiveButton(yes, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				GameActivityModel.this.finish();
			}
		}).setNegativeButton(no, new DialogInterface.OnClickListener() {
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
	}
	
	public Font create_font(String path, float size, int color){
		FontFactory.setAssetBasePath("font/");
		final ITexture fontTexture = new BitmapTextureAtlas(getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		Font font = FontFactory.createFromAsset(getFontManager(), fontTexture, getAssets(), path, size, true, color);
		font.load();
		return font;
	}
	
	public void button_sprite_clicked(ButtonSprite buttonSprite){}
	
	@Override
	public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
			float pTouchAreaLocalY) {
		button_sprite_clicked(pButtonSprite);
	}

}
