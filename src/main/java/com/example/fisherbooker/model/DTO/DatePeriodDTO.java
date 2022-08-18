package com.example.fisherbooker.model.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface DatePeriodDTO {
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date getStartDate();
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date getEndDate();
}
