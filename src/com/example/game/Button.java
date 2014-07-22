package com.example.game;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.text.Text;

public class Button{
	private ButtonSprite frame;
	private Text label;
	
	public Button(ButtonSprite frame, Text label, GameActivityModel model) {
		this.frame = frame;
		this.label = label;
		model.attach(label, frame, Alignment.CENTER);
	}

	public ButtonSprite getFrame() {
		return frame;
	}

	public void setFrame(ButtonSprite frame) {
		this.frame = frame;
	}

	public Text getLabel() {
		return label;
	}

	public void setLabel(Text label) {
		this.label = label;
	}
}
