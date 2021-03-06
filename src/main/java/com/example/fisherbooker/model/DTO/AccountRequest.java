package com.example.fisherbooker.model.DTO;

import com.example.fisherbooker.model.Address;

//dto za regireciju korisnika
public class AccountRequest {

	private Long id;
	private String username;
	private String password;
	private String name;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Address address;
	private String role;
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public void setLastname(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
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
		return "AccountRequest [id=" + id + ", username=" + username + ", password=" + password + ", name="
				+ name + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", role=" + role + "]";
	}

	public AccountRequest(Long id, String username, String password, String name, String lastName, String email,
			String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}
	
	public AccountRequest(String username, String password ) {
		
		
	}
	
	
	

	public AccountRequest() {
		super();
	}
	
}
