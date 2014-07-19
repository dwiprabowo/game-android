package com.example.game.activities;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.region.ITextureRegion;

import com.example.game.Alignment;
import com.example.game.GameActivityModel;

import android.content.Intent;
import android.graphics.Color;

public class ChooseLevelActivity extends GameActivityModel implements OnClickListener {

	private Font smallerTitleFont;
	private Font mMonoFont;
	
	private ITextureRegion mLevelTextureRegion;

	@Override
	public void init_resources() {
		final ITexture fontTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		final ITexture monoFontTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR);

		FontFactory.setAssetBasePath("font/");
		this.smallerTitleFont = FontFactory.createFromAsset(this.getFontManager(), fontTexture, this.getAssets(), "Forque.ttf", 20, true, Color.WHITE);
		this.smallerTitleFont.load();
		this.mMonoFont = FontFactory.createFromAsset(this.getFontManager(), monoFontTexture, this.getAssets(), "Anonymous.ttf", 16, true, Color.WHITE);
		this.mMonoFont.load();
		
		mLevelTextureRegion = texture_region("gfx/menu/level.png");
	}

	@Override
	public void init_scene() {
		int level = 1;
		
		final Text title = new Text(0, 0, getFontTitle(), "Pilih Level", getVBOM());
		attach(title, Alignment.TOP_CENTER);set_position(title, 0, 20);
		
		final Text text_level = new Text(0, 0, smallerTitleFont, "Level "+level, getVBOM());
		final Text text_skor = new Text(0, 0, mMonoFont, "Skor =", getVBOM());
		final Text text_soal  = new Text(0, 0, mMonoFont, "Soal =", getVBOM());
		final Text text_skor_number = new Text(0, 0, mMonoFont, "50,00", getVBOM());
		final Text text_soal_number = new Text(0, 0, mMonoFont, "10", getVBOM());
		final Text mulai = new Text(0, 0, smallerTitleFont, "Mulai", getVBOM());
		
		final Sprite level_frame = new ButtonSprite(0, 0, mLevelTextureRegion, this.getVertexBufferObjectManager(), this);
		
		getScene().registerTouchArea(level_frame);
		attach(level_frame, Alignment.CENTER);
		attach(text_level, Alignment.TOP_CENTER, level_frame);
		attach(text_skor, Alignment.MIDDLE_LEFT, level_frame);set_position(text_skor, 30, -13);
		attach(text_soal, Alignment.MIDDLE_LEFT, level_frame);set_position(text_soal, 30, 7);
		attach(text_skor_number, Alignment.MIDDLE_RIGHT, level_frame);set_position(text_skor_number, -30, -13);
		attach(text_soal_number, Alignment.MIDDLE_RIGHT, level_frame);set_position(text_soal_number, -30, 7);
		attach(mulai, Alignment.BOTTOM_CENTER, level_frame);set_position(mulai, 0, -6);
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
		startAndFinish(MainMenuActivity.class);
	}
}
