package com.example.game;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;
import android.content.Intent;

public class SplashActivity extends GameActivityModel{
	
	private ITextureRegion textureRegion;

	@Override
	protected void init_resources() {
		textureRegion = texture_region("gfx/splash_screen.png");
	}

	@Override
	protected void init_scene() {
		final Sprite background = new Sprite(0, 0, textureRegion, getVBOM());
		final Text title = new Text(0, 0, getFontTitle(), "Uji Ke-Indonesia-anmu!", getVBOM());
		
		attach(background, Alignment.CENTER);set_position(background, 0, 20);
		attach(title, Alignment.CENTER);set_position(title, 0, -80);
		
		getScene().registerUpdateHandler(new TimerHandler(5.0f, new ITimerCallback(){
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				SplashActivity.this.getScene().unregisterUpdateHandler(pTimerHandler);
				SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainMenuActivity.class));
				SplashActivity.this.finish();
			}
		}));
	}
}
