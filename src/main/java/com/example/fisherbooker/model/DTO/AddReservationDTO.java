package com.example.fisherbooker.model.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.CottageSuperDeal;
import com.example.fisherbooker.model.RealEstateType;
import com.example.fisherbooker.model.ReservationSupportData;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.ShipReservationSupportData;
import com.example.fisherbooker.model.ShipSuperDeal;

public class AddReservationDTO {
	private Date startDate;
	private Date endDate;
	private int price;
	private int capacity;
	private List<Long> options = new ArrayList<Long>();
	private Long realEstateId;
	private RealEstateType type;
	private Long clientId;

	public AddReservationDTO() {
		super();
	}

	public AddReservationDTO(CottageSuperDeal cottageSuperDeal) {
		this.startDate = cottageSuperDeal.getStartDate();
		this.endDate = cottageSuperDeal.getEndDate();
		this.price = cottageSuperDeal.getDiscountedPrice();
		this.capacity = cottageSuperDeal.getCapacity();
		this.options = this.getCottageOptions(cottageSuperDeal);
		this.realEstateId = cottageSuperDeal.getCottage().getId();
		this.type = RealEstateType.COTTAGE;
	}

	public AddReservationDTO(ShipSuperDeal shipSuperDeal) {
		this.startDate = shipSuperDeal.getStartDate();
		this.endDate = shipSuperDeal.getEndDate();
		this.price = shipSuperDeal.getDiscountedPrice();
		this.capacity = shipSuperDeal.getCapacity();
		this.options = this.getShipOptions(shipSuperDeal);
		this.realEstateId = shipSuperDeal.getShip().getId();
		this.type = RealEstateType.SHIP;
	}

	private List<Long> getCottageOptions(CottageSuperDeal cottageSuperDeal) {
		List<Long> cottageOptions = new ArrayList<>();
		Iterator<CottageOption> it = cottageSuperDeal.getOptions().iterator();
		while(it.hasNext()) {
			cottageOptions.add(it.next().getId());
		}
		return cottageOptions;
	}

	private List<Long> getShipOptions(ShipSuperDeal shipSuperDeal){
		List<Long> shipOptions = new ArrayList<>();
		Iterator<ShipOption> it = shipSuperDeal.getOptions().iterator();
		while(it.hasNext()) {
			shipOptions.add(it.next().getId());
		}
		return shipOptions;
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

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public ShipReservation toShipModel() {
		ShipReservation newReservation = new ShipReservation();

		newReservation.setCapacity(this.capacity);
		newReservation.setPrice(this.price);
		newReservation.setStartDate(this.startDate);
		newReservation.setEndDate(this.endDate);
		newReservation.setShip(new Ship(this.realEstateId));

		ShipReservationSupportData suppdata = (ShipReservationSupportData) new ReservationSupportData(
				new Long(newReservation.getId()), new String(), 2, newReservation.getPrice());
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

	@Override
	public String toString() {
		return "AddReservationDTO [startDate=" + startDate + ", endDate=" + endDate + ", price=" + price + ", capacity="
				+ capacity + ", options=" + options + ", realEstateId=" + realEstateId + ", type=" + type
				+ ", clientId=" + clientId + "]";
	}

	public AdventureReservation toAdventureModel() {
		AdventureReservation newReservation = new AdventureReservation();
		newReservation.setCapacity(this.capacity);
		newReservation.setPrice(this.price);
		newReservation.setStartDate(this.startDate);
		newReservation.setEndDate(this.endDate);
		newReservation.setAdventure(new Adventure(this.realEstateId));
		return newReservation;
	}

}
