package com.example.fisherbooker.model.DTO;

public class SecureTokenDTO {
	private String token;
	
	public SecureTokenDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "SecureTokenDTO [token=" + token + "]";
	}
	
}
