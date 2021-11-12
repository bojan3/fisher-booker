package com.example.fisherbooker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {
	@Id
	private String email;
	@Column(length=15, nullable=false)
	private String password;
	@Column(length=20, nullable=false)
	private String name;
	@Column(length=25, nullable=false)
	private String lastName;
	@Column(length=15)
	private String phoneNumber;
	
	private UserRoles role;

	@ManyToOne
	public Address address;

	public Account(String email, String password, String name, String lastName, String phoneNumber, UserRoles role,
			Address address) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserRoles getRole() {
		return role;
	}

	public void setRole(UserRoles role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Account [email=" + email + ", password=" + password + ", name=" + name + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", role=" + role + ", address=" + address + "]";
	}
	

}