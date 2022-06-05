package com.example.fisherbooker.model.DTO;

import java.text.SimpleDateFormat;
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
	private String startDate;
	private String endDate;
	private int capacity;
	private Set<AdventureOption> adventureOption;
	private int price;
	private AdventureDTO adventureDTO;
	private boolean canCancel;
	private boolean isFinished;
	
	public AdventureReservationDTO(Long id, String startDate, String endDate, int capacity,
			Set<AdventureOption> adventureOption, int price, boolean canCancel, boolean isFinished, AdventureDTO adventureDTO) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.capacity = capacity;
		this.adventureOption = adventureOption;
		this.price = price;
		this.canCancel = canCancel;
		this.isFinished = isFinished;
		this.adventureDTO = adventureDTO;
	}
	
	public AdventureReservationDTO(AdventureReservation adventureReservation) {
		super();
		this.id = adventureReservation.getId();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		this.startDate = formatter.format(adventureReservation.getStartDate());
		this.endDate = formatter.format(adventureReservation.getEndDate());
		this.capacity = adventureReservation.getCapacity();
		this.adventureOption = adventureReservation.getAdventureOption();
		this.price = adventureReservation.getPrice();
		this.adventureDTO =  new AdventureDTO(adventureReservation.getAdventure());
		
		Date nowDate = new Date();
		if (adventureReservation.getStartDate().after(nowDate)) {
			this.isFinished = false;
		}else {
			this.isFinished = true;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public AdventureDTO getAdventureDTO() {
		return adventureDTO;
	}

	public void setAdventureDTO(AdventureDTO adventureDTO) {
		this.adventureDTO = adventureDTO;
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
		return "AdventureReservationDTO [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", capacity="
				+ capacity + ", adventureOption=" + adventureOption + ", price=" + price + ", adventureDTO="
				+ adventureDTO + ", canCancel=" + canCancel + ", isFinished=" + isFinished + "]";
	}
	
}
