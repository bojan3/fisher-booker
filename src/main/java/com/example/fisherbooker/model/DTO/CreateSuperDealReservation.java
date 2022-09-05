package com.example.fisherbooker.model.DTO;

public class CreateSuperDealReservation {

	private long accountId;

	private long superDealId;

	public CreateSuperDealReservation() {
		super();
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getSuperDealId() {
		return superDealId;
	}

	public void setSuperDealId(long superDealId) {
		this.superDealId = superDealId;
	}

}
