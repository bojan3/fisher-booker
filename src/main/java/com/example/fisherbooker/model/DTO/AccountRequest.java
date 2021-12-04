package com.example.fisherbooker.model.DTO;

import com.example.fisherbooker.model.Address;

//dto za regireciju korisnika
public class AccountRequest {

	private Long id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
		return "AccountRequest [id=" + id + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", role=" + role + "]";
	}

	public AccountRequest(Long id, String username, String password, String firstname, String lastname, String email,
			String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
	}

	public AccountRequest() {
		super();
	}
	
}
