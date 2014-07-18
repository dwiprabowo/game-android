package com.example.game;

import java.io.IOException;
import java.io.InputStream;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.shape.RectangularShape;
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
import org.andengine.util.adt.io.in.IInputStreamOpener;
import org.andengine.util.debug.Debug;
import android.graphics.Color;

public abstract class GameActivityModel extends SimpleBaseGameActivity implements Constants{
	
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
	
	public ITextureRegion load_texture_region(ITextureRegion textureRegion, final String path){
		ITexture texture;
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
	
	public void attach(RectangularShape child, Alignment align){
		attach(child, align, null);
	}
	
	public void attach(RectangularShape child, Alignment align, RectangularShape parent){
		if(parent==null){
			scene.attachChild(child);
			align(child, align);
		} else {
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
	
	public void set_position(RectangularShape object, float x, float y){
		object.setPosition(object.getX() + x, object.getY() + y);
	}
}
