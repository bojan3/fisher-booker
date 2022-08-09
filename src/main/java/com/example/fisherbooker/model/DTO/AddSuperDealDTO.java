package com.example.fisherbooker.model.DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageSuperDeal;
import com.example.fisherbooker.model.RealEstateType;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipSuperDeal;

public class AddSuperDealDTO {
	private Date startDate;
	private Date endDate;
	private int discountedPrice;
	private int capacity;
	private List<Long> options = new ArrayList<Long>();
	private Long realEstateId;
	private RealEstateType type;

	public AddSuperDealDTO() {
		super();
	}

	public CottageSuperDeal toCottageModel() {
		CottageSuperDeal newDeal = new CottageSuperDeal();
		newDeal.setCapacity(this.capacity);
		newDeal.setDiscountedPrice(this.discountedPrice);
		newDeal.setStartDate(this.startDate);
		newDeal.setEndDate(this.endDate);
		newDeal.setCottage(new Cottage(this.realEstateId));
		return newDeal;
	}

	public ShipSuperDeal toShipModel() {
		ShipSuperDeal newDeal = new ShipSuperDeal();
		newDeal.setCapacity(this.capacity);
		newDeal.setDiscountedPrice(this.discountedPrice);
		newDeal.setStartDate(this.startDate);
		newDeal.setEndDate(this.endDate);
		newDeal.setShip(new Ship(this.realEstateId));
		return newDeal;
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

	public int getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
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

	@Override
	public String toString() {
		return "AddSuperDealDTO [startDate=" + startDate + ", endDate=" + endDate + ", discountedPrice="
				+ discountedPrice + ", capacity=" + capacity + ", options=" + options + ", realEstateId=" + realEstateId
				+ ", type=" + type + "]";
	}

}
