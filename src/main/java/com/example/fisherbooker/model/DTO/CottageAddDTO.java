package com.example.fisherbooker.model.DTO;

import java.util.List;
import java.util.Set;

import com.example.fisherbooker.model.Address;
import com.example.fisherbooker.model.AvailabilityPeriod;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottagePicture;
import com.example.fisherbooker.model.Room;
import com.example.fisherbooker.model.Rule;

public class CottageAddDTO {
	private String name;
	private String description;
	public Address address;
	public List<Room> room;
	public Set<Rule> rule;
	public AvailabilityPeriod availabilityPeriod;
	public Set<CottagePicture> cottagePicture;
	public Set<CottageOption> cottageOptions;
	
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
	public List<Room> getRoom() {
		return room;
	}
	public void setRoom(List<Room> room) {
		this.room = room;
	}
	public Set<Rule> getRule() {
		return rule;
	}
	public void setRule(Set<Rule> rule) {
		this.rule = rule;
	}
	public AvailabilityPeriod getAvailabilityPeriod() {
		return availabilityPeriod;
	}
	public void setAvailabilityPeriod(AvailabilityPeriod availabilityPeriod) {
		this.availabilityPeriod = availabilityPeriod;
	}
	public Set<CottagePicture> getCottagePicture() {
		return cottagePicture;
	}
	public void setCottagePicture(Set<CottagePicture> cottagePicture) {
		this.cottagePicture = cottagePicture;
	}
	public Set<CottageOption> getCottageOptions() {
		return cottageOptions;
	}
	public void setCottageOptions(Set<CottageOption> cottageOptions) {
		this.cottageOptions = cottageOptions;
	}
	@Override
	public String toString() {
		return "CottageAddDTO [ name=" + name + ", description=" + description + ", address=" + address
				+ ", room=" + room + ", rule=" + rule + ", availabilityPeriod=" + availabilityPeriod
				+ ", cottagePicture=" + cottagePicture + ", cottageOptions=" + cottageOptions + "]";
	}
	
}
