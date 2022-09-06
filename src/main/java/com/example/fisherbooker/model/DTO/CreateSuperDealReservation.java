package com.example.fisherbooker.model.DTO;

import com.example.fisherbooker.model.ReservationType;

public class CreateSuperDealReservation {

	private ReservationType type;

	private long accountId;

	private long superDealId;

	public CreateSuperDealReservation() {
		super();
	}

	public ReservationType getType() {
		return type;
	}

	public void setType(ReservationType type) {
		this.type = type;
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
