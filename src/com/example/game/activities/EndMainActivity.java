package com.example.game.activities;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import com.example.game.Alignment;
import com.example.game.Button;
import com.example.game.GameActivityModel;
import android.graphics.Color;

public class EndMainActivity extends GameActivityModel{
	
	final static int BUTTON_COUNT = 3;
	private Button[] buttons = new Button[BUTTON_COUNT];
	private Sprite frame;
	
	private Font fontInfo;

	@Override
	protected void init_resources() {
		frame = create_sprite(LEVEL_END_FRAME_PATH);
		fontInfo = create_font(FONT_FORQUE_FILENAME, FONT_SMALL_SUBTITLE_SIZE, Color.BLACK);
	}

	@Override
	protected
	void init_scene() {
		set_level_skor(Integer.parseInt(get_extra("poin")), Integer.parseInt(get_extra("level")));
		final Text level_end = create_text(fontInfo, "Level "+(Integer.parseInt(get_extra("level"))+1)+" Selesai");
		final Text skor = create_text(fontInfo, "Skor kamu: "+get_extra("poin")+" poin");
		attach(frame, Alignment.TOP_CENTER, 0, 20);
		attach(level_end, frame, Alignment.CENTER, 0, -20);
		attach(skor, frame, Alignment.CENTER, 0, 20);

		final String[] texts = new String[]{"Ulang Permainan", "Level Lain", "Menu Utama"};
		float posY = 20;
		for(int i = 0;i < BUTTON_COUNT;i++){
			buttons[i] = new Button(create_button_sprite(MIDDLE_BUTTON_FRAME_PATH), create_text(fontInfo, texts[i]), this);
			attach(buttons[i], Alignment.CENTER, 0, posY);
			posY += 40;
		}
	}
	
	@Override
	public void button_sprite_clicked(ButtonSprite buttonSprite) {
		if(buttonSprite == buttons[0].getFrame())start_and_finish(MainActivity.class, "{'level':"+get_extra("level")+"}");
		if(buttonSprite == buttons[1].getFrame())start_and_finish(ChooseLevelActivity.class);
		if(buttonSprite == buttons[2].getFrame())start_and_finish(MainMenuActivity.class);
	}

}
