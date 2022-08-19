package com.example.fisherbooker.model.DTO;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface DatePeriodDTO {
	@JsonFormat(pattern = "yyyy-MM-dd")
	Timestamp getStartDate();
	@JsonFormat(pattern = "yyyy-MM-dd")
	Timestamp getEndDate();
}
