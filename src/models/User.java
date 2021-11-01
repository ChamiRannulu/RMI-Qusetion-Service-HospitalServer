
package models;


public class User{

	private int user_id;
	private String name;
	private String phone;
	private String username;
	private String password;
	private int loyalty;

public User(){
}

public User(int user_id){
	this.user_id = user_id;
}
public User(int user_id,String name,String phone,String username,String password,int loyalty){
	this.user_id = user_id;
	this.name = name;
	this.phone = phone;
	this.username = username;
	this.password = password;
	this.loyalty = loyalty;
}

public int getUser_id(){
return user_id;
}

public void setUser_id(int user_id){
	this.user_id = user_id;
}

public String getName(){
return name;
}

public void setName(String name){
	this.name = name;
}

public String getPhone(){
return phone;
}

public void setPhone(String phone){
	this.phone = phone;
}

public String getUsername(){
return username;
}

public void setUsername(String username){
	this.username = username;
}

public String getPassword(){
return password;
}

public void setPassword(String password){
	this.password = password;
}

public int getLoyalty(){
return loyalty;
}

public void setLoyalty(int loyalty){
	this.loyalty = loyalty;
}

}