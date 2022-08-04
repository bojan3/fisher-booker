package com.example.fisherbooker.model.DTO;

import java.sql.Blob;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.example.fisherbooker.model.Address;
import com.example.fisherbooker.model.CottageAvailabilityPeriod;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.Room;
import com.example.fisherbooker.model.Rule;

public class CottageAddDTO {
	private String name;
	private String description;
	private Address address;
	private Set<Room> rooms;
	private Set<Rule> rules;
	private Set<CottageAvailabilityPeriod> availabilityPeriods;
	private Set<CottageOption> cottageOptions;
	private int pricePerDay;

	public CottageAddDTO() {
		super();
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

	public Set<CottageAvailabilityPeriod> getAvailabilityPeriods() {
		return availabilityPeriods;
	}

	public void setAvailabilityPeriods(Set<CottageAvailabilityPeriod> availabilityPeriods) {
		this.availabilityPeriods = availabilityPeriods;
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

	public Cottage toModel() {
		Cottage c = new Cottage();
		c.setName(this.name);
		c.setDescription(this.description);
		c.setAddress(this.address);
		c.setPricePerDay(this.pricePerDay);
		c.setRooms(this.rooms);
		c.setAvailabilityPeriods(this.availabilityPeriods);
		c.setCottageOptions(this.cottageOptions);
		c.setRules(this.rules);
		return c;
	}

	@Override
	public String toString() {
		return "CottageAddDTO [name=" + name + ", description=" + description + ", address=" + address + ", rooms="
				+ rooms + ", rules=" + rules + ", availabilityPeriods=" + availabilityPeriods + ", cottageOptions="
				+ cottageOptions + ", pricePerDay=" + pricePerDay + "]";
	}

}
