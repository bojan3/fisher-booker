package com.example.fisherbooker.model.DTO;

import java.sql.Timestamp;

public class DatePeriod {
	private Timestamp startDate;
	private Timestamp endDate;

	public DatePeriod() {
		super();
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

}
