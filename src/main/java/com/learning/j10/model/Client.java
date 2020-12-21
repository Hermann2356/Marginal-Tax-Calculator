package com.learning.j10.model;

public class Client {
	private int clientId;
	private String firstName;
	private String lastName;
	private float currentSalary;
	private String status;
	
	
	
	
	public Client() {};

	public Client(int clientId, String firstName, String lastName, float currentSalary, String status) {
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.currentSalary = currentSalary;
		this.status = status;
	}
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientID) {
		this.clientId = clientID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public float getCurrentSalary() {
		return currentSalary;
	}
	public void setCurrentSalary(float salary) {
		this.currentSalary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", firstName=" + firstName + ", lastName=" + lastName + ", currentSalary="
				+ currentSalary + ", status=" + status + "]";
	}
	
}
