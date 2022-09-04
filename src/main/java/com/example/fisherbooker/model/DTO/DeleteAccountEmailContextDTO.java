package com.example.fisherbooker.model.DTO;

import com.example.fisherbooker.model.Account;

public class DeleteAccountEmailContextDTO {

	private Account account;
	private String answer;
	
	public DeleteAccountEmailContextDTO() {}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
	
}
