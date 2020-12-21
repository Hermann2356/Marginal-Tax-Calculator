package com.learning.j10.model;

public class UserLogin{
	private String userId;
	private String encryptedPassword;
	
	public UserLogin(String userId, String encryptedPassword){
	
		this.userId = userId;
		this.encryptedPassword = encryptedPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", encryptedPassword=" + encryptedPassword + "]";
	}
	
		
}
