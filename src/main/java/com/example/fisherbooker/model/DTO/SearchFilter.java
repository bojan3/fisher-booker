package com.example.fisherbooker.model.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SearchFilter {

	private Date startDate;
	private Date endDate;
	private String locationCity;
	private Integer minGrade;
	private Integer minCapacity;

	public SearchFilter() {
		super();
	}

	public SearchFilter(Date startDate, Date endDate, String locationCity, String minGrade, String minCapacity) {
		super();
//		&& endDate != null
//		if (startDate != null) {
//			setPeriod(startDate, endDate);
//		}
		this.startDate = startDate;
		this.endDate = endDate;
		if (!locationCity.equals("null"))
			this.locationCity = locationCity;
		if (!minGrade.equals("null"))
			this.minGrade = Integer.parseInt(minGrade);
		if (!minCapacity.equals("null"))
			this.minCapacity = Integer.parseInt(minCapacity);
	}

	private void setPeriod(String startDate, String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.startDate = formatter.parse(startDate);
//			this.endDate = formatter.parse(endDate);
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public Integer getMinGrade() {
		return minGrade;
	}

	public void setMinGrade(Integer minGrade) {
		this.minGrade = minGrade;
	}

	public Integer getMinCapacity() {
		return minCapacity;
	}

	public void setMinCapacity(Integer minCapacity) {
		this.minCapacity = minCapacity;
	}

	@Override
	public String toString() {
		return "SearchFilter [startDate=" + startDate + ", endDate=" + endDate + ", locationCity=" + locationCity
				+ ", minGrade=" + minGrade + ", minCapacity=" + minCapacity + "]";
	}

}
