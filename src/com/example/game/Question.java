package com.example.game;

public class Question implements Constants{
	
	private String path;
	private String question;
	private String[] options = new String[OPTIONS_COUNT];
	private int answer;
	private int kategori;
	private float poin;
	
	public Question(String path, String question, String[] options, int answer, int kategori){
		this(path, question, options, answer, kategori, DEFAULT_POIN);
	}
	
	public Question(String question, String[] options, int answer, int kategori){
		this(null, question, options, answer, kategori, DEFAULT_POIN);
	}
	
	public Question(String question, String[] options, int answer, int kategori, float poin){
		this(null, question, options, answer, kategori, poin);
	}
	
	public Question(String path, String question, String[] options, int answer, int kategori, float poin){
		this.path = path;
		this.question = question;
		this.options = options;
		this.answer = answer;
		this.kategori = kategori;
		this.poin = poin;
	}
	
	public String getPath(){
		if(path == null){
			return null;
		}
		return IMAGE_PATH+path+".png";
	}
	
	public String getQuestion(){
		return question;
	}
	
	public String[] getOptions(){
		return options;
	}
	
	public int getAnswer(){
		return answer;
	}
	
	public int getKategori(){
		return kategori;
	}
	
	public float getPoin(){
		return poin;
	}

}
