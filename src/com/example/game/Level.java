package com.example.game;

public class Level {
	private int soal;
	private int skor;
	
	public Level(int soal, int skor){
		this.soal = soal;
		this.skor = skor;
	}
	
	public int get_soal(){
		return soal;
	}
	
	public int get_skor(){
		return skor;
	}
	
	public void set_soal(int number){
		soal = number;
	}
	
	public void set_skor(int skor){
		this.skor = skor;
	}
}
