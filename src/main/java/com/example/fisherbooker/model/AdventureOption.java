package com.example.fisherbooker.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name="adventure_option")
public class AdventureOption {
	public AdventureOption() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=25)
	private String name;
	@Column(length=350)
	private String description;
	@Column
	private int price;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
//	@JoinTable(name="adventure")
	public Adventure adventure;
	
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "AdventureOption [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ "]";
	}

}