package com.example.game;

public class Position {
	private Alignment alignment;
	private float x;
	private float y;
	
	public Position(float x, float y){
		this(Alignment.NONE, x, y);
	}
	
	public Position(Alignment alignment, float x, float y) {
		super();
		this.alignment = alignment;
		this.x = x;
		this.y = y;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
