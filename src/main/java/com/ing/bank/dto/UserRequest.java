package com.ing.bank.dto;


public class UserRequest {
	
	private String userName;
	private String place;
	private String gmail;
	private String phoneNumber;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "UserRequest [ userName=" + userName + ", place=" + place + ", gmail=" + gmail
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
