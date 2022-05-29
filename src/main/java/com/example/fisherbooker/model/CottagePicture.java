package com.example.fisherbooker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CottagePicture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 150)
	private String path;

	@ManyToOne
	@JoinColumn(name = "cottage_id")
	private Cottage cottage;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}

	@Override
	public String toString() {
		return "CottagePicture [id=" + id + ", path=" + path + "]";
	}

}