package com.example.fisherbooker.model.DTO;

import java.sql.Date;

public class DateSpamDTO {

	private Date startDate;
	private Date endDate;
	private float totalIncome;
	
	public DateSpamDTO(){}
	public DateSpamDTO(Date d1, Date d2){
		
		this.startDate=d1;
		this.endDate=d2;
	}
	
	
	
}
