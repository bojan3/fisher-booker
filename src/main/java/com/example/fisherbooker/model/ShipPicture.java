package com.example.fisherbooker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShipPicture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length=150)
	private int path;
	
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
	@Override
	public String toString() {
		return "ShipPicture [id=" + id + ", path=" + path + "]";
	}
	
}