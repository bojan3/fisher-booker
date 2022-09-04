package com.example.fisherbooker.model.DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.RealEstateType;
import com.example.fisherbooker.model.ReservationSupportData;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.ShipReservationSupportData;
import com.example.fisherbooker.model.GlobalNumber;


public class AddReservationDTO {
	private Date startDate;
	private Date endDate;
	private int price;
	private int capacity;
	private List<Long> options = new ArrayList<Long>();
	private Long realEstateId;
	private RealEstateType type;

	public AddReservationDTO() {
		super();
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

	public List<Long> getOptions() {
		return options;
	}

	public void setOptions(List<Long> options) {
		this.options = options;
	}

	public Long getRealEstateId() {
		return realEstateId;
	}

	public void setRealEstateId(Long realEstateId) {
		this.realEstateId = realEstateId;
	}

	public RealEstateType getType() {
		return type;
	}

	public void setType(RealEstateType type) {
		this.type = type;
	}

	public ShipReservation toShipModel() {
		ShipReservation newReservation = new ShipReservation();

		
		newReservation.setCapacity(this.capacity);
		newReservation.setPrice(this.price);
		newReservation.setStartDate(this.startDate);
		newReservation.setEndDate(this.endDate);
		newReservation.setShip(new Ship(this.realEstateId));
		
		ShipReservationSupportData suppdata = (ShipReservationSupportData) new ReservationSupportData(new Long(newReservation.getId()),  new String(), 2,  newReservation.getPrice());
		newReservation.setReservationsd(suppdata);
		
		return newReservation;
	}

	public CottageReservation toCottageModel() {
		CottageReservation newReservation = new CottageReservation();
		newReservation.setCapacity(this.capacity);
		newReservation.setPrice(this.price);
		newReservation.setStartDate(this.startDate);
		newReservation.setEndDate(this.endDate);
		newReservation.setCottage(new Cottage(this.realEstateId));
		return newReservation;
	}

}
