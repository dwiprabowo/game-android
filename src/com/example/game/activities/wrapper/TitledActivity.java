package com.example.game.activities.wrapper;

import com.example.game.Alignment;

public abstract class TitledActivity extends SimpleGameActivity{

	@Override
	protected void activity_logic(){
		attach(create_text(getFontTitle(), title()), Alignment.TOP_CENTER, 0, top_gap());
		extend_activity_logic();
	}
	
	float top_gap(){
		return DEFAULT_TITLE_GAP;
	}
	
	protected abstract String title();
	protected abstract void extend_activity_logic();

}
