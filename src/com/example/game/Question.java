package com.example.game;

public class Question {
	
	private String question;
	int OPTIONS_COUNT = 4;
	private String[] options = new String[OPTIONS_COUNT];
	private int answer; 
	
	public Question(String question, String[] options, int answer){
		this.question = question;
		this.options = options;
		this.answer = answer;
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

}
