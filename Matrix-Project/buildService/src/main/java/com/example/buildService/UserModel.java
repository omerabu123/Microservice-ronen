package com.example.buildService;

public class UserModel {

	private int userID;
	private String userName;
	
	public UserModel() {}
	public UserModel(int userID, String userName) {
		this.userID=userID;
		this.userName=userName;
	}

	@Override
	public String toString() {
		return "UserModel [userID=" + userID + ", userName=" + userName + "]";
	}
	
	public void setUserID(int userID) {
		this.userID=userID;
	}
	
	public int getUserID() {
		return this.userID;
	}
	
	public void setUserName(String userName) {
		this.userName=userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
}

