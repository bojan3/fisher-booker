package com.example.fisherbooker.model.DTO;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.postgresql.translation.messages_bg;
import org.postgresql.util.LruCache.CreateAction;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Address;
import com.example.fisherbooker.model.Role;

import net.bytebuddy.asm.Advice.This;

public class AccountDTO {

	   
	    private Long id;
	    private String username;
		private String email;
	   	private String password;
		private String name;
		private String lastName;
		private String phoneNumber;
		private boolean enabled;
		private Timestamp lastPasswordResetDate;
		private String role;
		public Address address;

		public AccountDTO(){}

		@Override
		public String toString() {
			return "AccountDTO [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
					+ ", name=" + name + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", enabled="
					+ enabled + ", lastPasswordResetDate=" + lastPasswordResetDate + ", roles=" + role + ", address="
					+ address + "]";
		}

		public AccountDTO(Long id, String username, String email, String password, String name, String lastName,
				String phoneNumber, boolean enabled, Timestamp lastPasswordResetDate, List<Role> roles,
				Address address) {
			super();
			this.id = id;
			this.username = username;
			this.email = email;
			this.password = password;
			this.name = name;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
			this.enabled = enabled;
			this.lastPasswordResetDate = lastPasswordResetDate;
			String split[] = roles.get(0).toString().split("=", 0);
			split[2] = split[2].replace("]", "");
			this.role = split[2];
			System.out.println(this.role);
			this.address = address;
		}
		
		public static AccountDTO createAccountDTO(Account account) {
			return new AccountDTO(account.getId(), account.getUsername(), account.getEmail(), account.getPassword(), account.getName(), account.getLastName(), account.getPhoneNumber(), account.isEnabled(), account.getLastPasswordResetDate(), account.getRoles(), account.getAddress());
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

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public Timestamp getLastPasswordResetDate() {
			return lastPasswordResetDate;
		}

		public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
			this.lastPasswordResetDate = lastPasswordResetDate;
		}

		public List<Role> getRoles() {
			return roles;
		}

		public void setRoles(List<Role> roles) {
			this.roles = roles;
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

		public AccountDTO(Account a) {
			super();
			this.id=a.getId();
			this.username = a.getUsername();
			this.email = a.getEmail();
			this.password = a.getPassword();
			this.name = a.getName();
			this.lastName = a.getLastName();
			this.phoneNumber = a.getPhoneNumber();
			//this.enabled = a.isEnabled();
			//this.lastPasswordResetDate = a.getLastPasswordResetDate();
			//this.roles = a.getRoles();
			this.address = a.address;
			
			
			
		}
		
		
		
		
		
	
	
	
}
