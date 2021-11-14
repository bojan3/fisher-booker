package com.example.fisherbooker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CottagePicture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 150)
	private int path;

	public CottagePicture() {
		super();
		// TODO Auto-generated constructor stub
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
		return "CottagePicture [id=" + id + ", path=" + path + "]";
	}

}