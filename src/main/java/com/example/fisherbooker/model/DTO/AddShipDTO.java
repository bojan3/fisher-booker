package com.example.fisherbooker.model.DTO;

import java.util.Set;

import com.example.fisherbooker.model.Address;
import com.example.fisherbooker.model.CottageAvailabilityPeriod;
import com.example.fisherbooker.model.FishingEquipment;
import com.example.fisherbooker.model.NavigationEquipment;
import com.example.fisherbooker.model.Rule;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipAvailabilityPeriod;
import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.ShipType;

public class AddShipDTO {
	private String name;
	private ShipType type;
	private float length;
	private Address address;
	private String description;
	private int rentPrice;
	private int engineNumber;
	private int enginePower;
	private float maxSpeed;
	private int capacity;
	private float cancelRate;
	private Set<Rule> rules;
	private Set<ShipAvailabilityPeriod> availabilityPeriods;
	private Set<ShipOption> shipOptions;
	private Set<NavigationEquipment> navigationEquipments;
	private Set<FishingEquipment> fishingEquipments;

	public AddShipDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShipType getType() {
		return type;
	}

	public void setType(ShipType type) {
		this.type = type;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public int getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(int engineNumber) {
		this.engineNumber = engineNumber;
	}

	public int getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getCancelRate() {
		return cancelRate;
	}

	public void setCancelRate(float cancelRate) {
		this.cancelRate = cancelRate;
	}

	public Set<Rule> getRules() {
		return rules;
	}

	public void setRules(Set<Rule> rules) {
		this.rules = rules;
	}

	public Set<ShipAvailabilityPeriod> getAvailabilityPeriods() {
		return availabilityPeriods;
	}

	public void setAvailabilityPeriods(Set<ShipAvailabilityPeriod> availabilityPeriods) {
		this.availabilityPeriods = availabilityPeriods;
	}

	public Set<ShipOption> getShipOptions() {
		return shipOptions;
	}

	public void setShipOptions(Set<ShipOption> shipOptions) {
		this.shipOptions = shipOptions;
	}

	public Set<NavigationEquipment> getNavigationEquipments() {
		return navigationEquipments;
	}

	public void setNavigationEquipments(Set<NavigationEquipment> navigationEquipments) {
		this.navigationEquipments = navigationEquipments;
	}

	public Set<FishingEquipment> getFishingEquipments() {
		return fishingEquipments;
	}

	public void setFishingEquipments(Set<FishingEquipment> fishingEquipments) {
		this.fishingEquipments = fishingEquipments;
	}
	
	public Ship toModel() {
		Ship s = new Ship();
		s.setName(this.name);
		s.setDescription(this.description);
		s.setAddress(this.address);
		s.setCancelRate(this.cancelRate);
		s.setCapacity(this.capacity);
		s.setEngineNumber(this.engineNumber);
		s.setEnginePower(this.engineNumber);
		s.setMaxSpeed(this.maxSpeed);
		s.setRentPrice(this.rentPrice);
		s.setType(this.type);
		
		s.setNavigationEquipments(this.navigationEquipments);
		s.setFishingEquipments(this.fishingEquipments);
		s.setShipOptions(this.shipOptions);
		s.setRules(this.rules);
		s.setAvailabilityPeriods(this.availabilityPeriods);
		
		return s;
	}

	@Override
	public String toString() {
		return "AddShipDTO [name=" + name + ", type=" + type + ", length=" + length + ", address=" + address
				+ ", description=" + description + ", rentPrice=" + rentPrice + ", engineNumber=" + engineNumber
				+ ", enginePower=" + enginePower + ", maxSpeed=" + maxSpeed + ", capacity=" + capacity + ", cancelRate="
				+ cancelRate + ", rules=" + rules + ", availabilityPeriods=" + availabilityPeriods + ", shipOptions="
				+ shipOptions + ", navigationEquipments=" + navigationEquipments + ", fishingEquipments="
				+ fishingEquipments + "]";
	}

}
