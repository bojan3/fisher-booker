package com.example.fisherbooker.model.DTO;

import java.util.Set;

import com.example.fisherbooker.model.Address;
import com.example.fisherbooker.model.AvailabilityPeriod;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.Room;
import com.example.fisherbooker.model.Rule;

public class EditCottageDTO {
	private Long id;
	private String name;
	private String description;
	private Address address;
	private Set<Room> rooms;
	private Set<Rule> rules;
	private AvailabilityPeriod availabilityPeriod;
	private Set<CottageOption> cottageOptions;
	private int pricePerDay;

	public EditCottageDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Set<Rule> getRules() {
		return rules;
	}

	public void setRules(Set<Rule> rules) {
		this.rules = rules;
	}

	public AvailabilityPeriod getAvailabilityPeriod() {
		return availabilityPeriod;
	}

	public void setAvailabilityPeriod(AvailabilityPeriod availabilityPeriod) {
		this.availabilityPeriod = availabilityPeriod;
	}

	public Set<CottageOption> getCottageOptions() {
		return cottageOptions;
	}

	public void setCottageOptions(Set<CottageOption> cottageOptions) {
		this.cottageOptions = cottageOptions;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

}
