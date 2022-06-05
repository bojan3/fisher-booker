package com.example.fisherbooker.model.DTO;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import com.example.fisherbooker.model.AdventureOption;
import com.example.fisherbooker.model.AdventureReservation;

public class AdventureReservationDTO {

	private Long id;
	private Date startDate;
	private Date endDate;
	private int duration;
	private int capacity;
	private Set<AdventureOption> adventureOption;
	private int price;
	private boolean canCancel;
	private boolean isFinished;
	private float cancelRate;
	
	public AdventureReservationDTO(Long id, Date startDate, Date endDate, int duration, int capacity,
			Set<AdventureOption> adventureOption, int price, boolean canCancel, boolean isFinished) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.capacity = capacity;
		this.adventureOption = adventureOption;
		this.price = price;
		this.canCancel = canCancel;
		this.isFinished = isFinished;
		
	}
	
	public AdventureReservationDTO(AdventureReservation adventureReservation) {
		super();
		this.id = adventureReservation.getId();
		this.startDate = adventureReservation.getStartDate();
		this.endDate = adventureReservation.getEndDate();
		this.duration = adventureReservation.getDuration();
		this.capacity = adventureReservation.getCapacity();
		this.adventureOption = adventureReservation.getAdventureOption();
		this.price = adventureReservation.getPrice();
		
		Date nowDate = new Date();
		if (adventureReservation.getStartDate().after(nowDate)) {
			this.isFinished = true;
		}else {
			this.isFinished = false;
		}
		
		Date lastCancellationDate = this.addDays(adventureReservation.getStartDate(), 3);
		if (nowDate.after(lastCancellationDate)) {
			this.canCancel = false;
		}else {
			this.canCancel = true;
		}
	}
	
	public boolean isCanCancel() {
		return canCancel;
	}

	public void setCanCancel(boolean canCancel) {
		this.canCancel = canCancel;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	private Date addDays(Date nowDate, int days) {
		LocalDateTime localDateTime = nowDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localDateTime = localDateTime.plusDays(days);
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Set<AdventureOption> getAdventureOption() {
		return adventureOption;
	}
	public void setAdventureOption(Set<AdventureOption> adventureOption) {
		this.adventureOption = adventureOption;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "AdventureReservationDTO [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", duration="
				+ duration + ", capacity=" + capacity + ", adventureOption=" + adventureOption + ", price=" + price
				+ "]";
	}
	

	public float getCancelRate() {
		return cancelRate;
	}


	public void setCancelRate(float cancelRate) {
		this.cancelRate = cancelRate;
	}
	

}
