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

import com.example.fisherbooker.model.Address;
import com.example.fisherbooker.model.Role;

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
		private List<Role> roles;
		public Address address;

		AccountDTO(){}

		@Override
		public String toString() {
			return "AccountDTO [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
					+ ", name=" + name + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", enabled="
					+ enabled + ", lastPasswordResetDate=" + lastPasswordResetDate + ", roles=" + roles + ", address="
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
			this.roles = roles;
			this.address = address;
		}
		
		
		
		
		
		
	
	
	
}
