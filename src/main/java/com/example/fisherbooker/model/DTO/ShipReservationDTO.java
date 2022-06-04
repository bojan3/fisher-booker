package com.example.fisherbooker.model.DTO;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.ShipReservation;

public class ShipReservationDTO {

	private int id;
	private Date startDate;
	private Date endDate;
	public Set<ShipOption> shipOption;
	public ShipDTO shipDTO;
	private boolean canCancel;
	private boolean isFinished;
	
	
	public ShipReservationDTO(int id, Date startDate, Date endDate, Set<ShipOption> shipOption, ShipDTO shipDTO,
			boolean canCancel, boolean isFinished) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.shipOption = shipOption;
		this.shipDTO = shipDTO;
		this.canCancel = canCancel;
		this.isFinished = isFinished;
	}
	
	public ShipReservationDTO(ShipReservation shipReservation) {
		super();
		this.id = shipReservation.getId();
		this.startDate = shipReservation.getStartDate();
		this.endDate = shipReservation.getEndDate();
		this.shipOption = shipReservation.getShipOption();
		this.shipDTO = new ShipDTO(shipReservation.getShip());
		Date nowDate = new Date();
		if (shipReservation.getStartDate().after(nowDate)) {
			this.isFinished = true;
		}else {
			this.isFinished = false;
		}
		
		Date lastCancellationDate = this.addDays(shipReservation.getStartDate(), 3);
		if (nowDate.after(lastCancellationDate)) {
			this.canCancel = false;
		}else {
			this.canCancel = true;
		}	
	}
	
	private Date addDays(Date nowDate, int days) {
		LocalDateTime localDateTime = nowDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localDateTime = localDateTime.plusDays(days);
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Set<ShipOption> getShipOption() {
		return shipOption;
	}
	public void setShipOption(Set<ShipOption> shipOption) {
		this.shipOption = shipOption;
	}
	public ShipDTO getShipDTO() {
		return shipDTO;
	}
	public void setShipDTO(ShipDTO shipDTO) {
		this.shipDTO = shipDTO;
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
		return "ShipReservationDTO [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", shipOption="
				+ shipOption + ", shipDTO=" + shipDTO + ", canCancel=" + canCancel + ", isFinished=" + isFinished + "]";
	}
	
	
}
