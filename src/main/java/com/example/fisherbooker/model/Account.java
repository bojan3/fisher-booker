package com.example.fisherbooker.model;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.fisherbooker.security.auth.SecureToken;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account implements UserDetails {
	public Account() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 15, nullable = false)
	private String username;
	@Column(nullable = false)
	private String email;
	@Column(length = 100, nullable = false)
	private String password;
	@Column(length = 20, nullable = false)
	private String name;
	@Column(length = 25, nullable = false)
	private String lastName;
	@Column(length = 15)
	private String phoneNumber;

	private boolean emailVerified;

	private boolean adminVerified;

	public boolean isAdminVerified() {
		return adminVerified;
	}

	public void setAdminVerified(boolean adminVerified) {
		this.adminVerified = adminVerified;
		if (emailVerified && adminVerified) {
			this.enabled = true;
		}
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
		if (emailVerified && adminVerified) {
			this.enabled = true;
		}
	}

	private boolean enabled;
	private Timestamp lastPasswordResetDate;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Role> roles;

	@ManyToOne(cascade = CascadeType.ALL)
	public Address address;

//  tokeni za verifkaciju e-mail adrese
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	private Set<SecureToken> tokens;

	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private Set<DeleteAccountRequest> deleteAccountRequests;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", name=" + name + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", enabled=" + enabled
				+ ", lastPasswordResetDate=" + lastPasswordResetDate + ", roles=" + roles + ", address=" + address
				+ "]";
	}

	public Timestamp getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public Set<DeleteAccountRequest> getDeleteAccountRequests() {
		return deleteAccountRequests;
	}

	public void setDeleteAccountRequests(Set<DeleteAccountRequest> deleteAccountRequests) {
		this.deleteAccountRequests = deleteAccountRequests;
	}

}