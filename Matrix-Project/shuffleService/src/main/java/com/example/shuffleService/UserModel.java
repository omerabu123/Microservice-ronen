package com.example.shuffleService;

import org.json.JSONObject;

public class UserModel {
	

	public int userID;
	public String userName;
	public UserModel(int userID, String userName) {
		this.userID=userID;
		this.userName=userName;
	}
	
	public UserModel() {}
	@Override
	public String toString() {
		return "UserModel [userID=" + userID + ", userName=" + userName + "]";
	}
}
