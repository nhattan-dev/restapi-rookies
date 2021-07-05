package com.nhattan.restapi.dto;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class EmployeeDTO {
	@Min(value = 0, message = "must-be-greater-than-0")
	private int employeeID;
	@NotBlank(message = "cannot-be-empty")
	private String firstName;
	@NotBlank(message = "cannot-be-empty")
	private String lastName;
	private String gender;
	@NotBlank(message = "cannot-be-empty")
	private String email;
	private String address;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
