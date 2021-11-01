
package models;


public class Answer{

	private int answer_id;
	private int question_id;
	private int user_id;
	private String answer;
	private String date_time;

public Answer(){
}

public Answer(int answer_id){
	this.answer_id = answer_id;
}
public Answer(int answer_id,int question_id,int user_id,String answer,String date_time){
	this.answer_id = answer_id;
	this.question_id = question_id;
	this.user_id = user_id;
	this.answer = answer;
	this.date_time = date_time;
}

public int getAnswer_id(){
return answer_id;
}

public void setAnswer_id(int answer_id){
	this.answer_id = answer_id;
}

public int getQuestion_id(){
return question_id;
}

public void setQuestion_id(int question_id){
	this.question_id = question_id;
}

public int getUser_id(){
return user_id;
}

public void setUser_id(int user_id){
	this.user_id = user_id;
}

public String getAnswer(){
return answer;
}

public void setAnswer(String answer){
	this.answer = answer;
}

public String getDate_time(){
return date_time;
}

public void setDate_time(String date_time){
	this.date_time = date_time;
}

}