package com.example.fisherbooker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ShipPicture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 150)
	private int path;

	@ManyToOne
	@JoinColumn(name = "ship_id")
	private Ship ship;

	public ShipPicture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShipPicture(int id, int path) {
		super();
		this.id = id;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPath() {
		return path;
	}

	public void setPath(int path) {
		this.path = path;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	@Override
	public String toString() {
		return "ShipPicture [id=" + id + ", path=" + path + "]";
	}

}