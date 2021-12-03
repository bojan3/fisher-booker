package com.example.fisherbooker.model.DTO;

import org.springframework.core.NestedCheckedException;

import com.example.fisherbooker.model.Ship;

public class ShipDTO {
	private Long id;
	private String name;
	private String shipType;
	private float length;
	private String description;
	private float averageMark;
	private int rentPrice;
	private int engineNumber;
	private int enginePower;
	private float maxSpeed;
	private int capacity;
	private float cancelRate;

	public ShipDTO(Long id, String name, String shipType, float length, String description, float averageMark,
			int rentPrice, int engineNumber, int enginePower, float maxSpeed, int capacity, float cancelRate) {
		super();
		this.id = id;
		this.name = name;
		this.shipType = shipType;
		this.length = length;
		this.description = description;
		this.averageMark = averageMark;
		this.rentPrice = rentPrice;
		this.engineNumber = engineNumber;
		this.enginePower = enginePower;
		this.maxSpeed = maxSpeed;
		this.capacity = capacity;
		this.cancelRate = cancelRate;
	}
	
	public ShipDTO(Long id, String name, float length, String description, float averageMark,
			int rentPrice, int engineNumber, int enginePower, float maxSpeed, int capacity, float cancelRate) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
		this.description = description;
		this.averageMark = averageMark;
		this.rentPrice = rentPrice;
		this.engineNumber = engineNumber;
		this.enginePower = enginePower;
		this.maxSpeed = maxSpeed;
		this.capacity = capacity;
		this.cancelRate = cancelRate;
	}
	
	public static ShipDTO createShipDTO(Ship ship) {
		return new ShipDTO(ship.getId(), ship.getName(), ship.getLength(),
				ship.getDescription(), ship.getAverageMark(), ship.getRentPrice(), ship.getEngineNumber(),
				ship.getEnginePower(), ship.getMaxSpeed(), ship.getCapacity(), ship.getCancelRate());
	}

	public ShipDTO() {}
	
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

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(float averageMark) {
		this.averageMark = averageMark;
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

}
