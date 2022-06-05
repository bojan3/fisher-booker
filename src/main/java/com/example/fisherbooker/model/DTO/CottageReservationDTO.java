package com.example.fisherbooker.model.DTO;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageReservation;

public class CottageReservationDTO {

	private Long id;
	private String startDate;
	private String endDate;
	private int price;
	private int capacity;
	private Set<CottageOption> cottageOption;
	public CottageDTO cottageDTO;
	private boolean canCancel;
	private boolean isFinished;

	public CottageReservationDTO(Long id, String startDate, String endDate, int price, int capacity,
			Set<CottageOption> cottageOption, CottageDTO cottageDTO, boolean canCancel, boolean isFinished) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.capacity = capacity;
		this.cottageOption = cottageOption;
		this.cottageDTO = cottageDTO;
		this.canCancel = canCancel;
		this.isFinished = isFinished;
	}

	public CottageReservationDTO(CottageReservation cottageReservation) {
		super();
		this.id = cottageReservation.getId();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		this.startDate = formatter.format(cottageReservation.getStartDate());
		this.endDate = formatter.format(cottageReservation.getEndDate());
		this.price = cottageReservation.getPrice();
		this.capacity = cottageReservation.getCapacity();
		this.cottageOption = cottageReservation.getCottageOption();
		this.cottageDTO = new CottageDTO(cottageReservation.getCottage());
		Date nowDate = new Date();
		if (cottageReservation.getStartDate().after(nowDate)) {
			this.isFinished = false;
		} else {
			this.isFinished = true;
		}

		Date lastCancellationDate = this.addDays(cottageReservation.getStartDate(), 3);
		if (nowDate.after(lastCancellationDate)) {
			this.canCancel = false;
		} else {
			this.canCancel = true;
		}
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Set<CottageOption> getCottageOption() {
		return cottageOption;
	}

	public void setCottageOption(Set<CottageOption> cottageOption) {
		this.cottageOption = cottageOption;
	}

	public CottageDTO getCottageDTO() {
		return cottageDTO;
	}

	public void setCottageDTO(CottageDTO cottageDTO) {
		this.cottageDTO = cottageDTO;
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

	@Override
	public String toString() {
		return "CottageReservationDTO [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", price="
				+ price + ", capacity=" + capacity + ", cottageOption=" + cottageOption + ", cottageDTO=" + cottageDTO
				+ ", canCancel=" + canCancel + ", isFinished=" + isFinished + "]";
	}

}
