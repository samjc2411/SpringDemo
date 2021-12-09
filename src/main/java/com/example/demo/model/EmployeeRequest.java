package com.example.demo.model;

import javax.validation.constraints.NotBlank;

public class EmployeeRequest {

	
	@NotBlank(message = "First Name Should not be empty")
	private String firstName;
	@NotBlank(message = "Last Name Should not be empty")
	private String lastName;
	@NotBlank(message = "Email Should not be empty")
	private String email;
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	    
}
