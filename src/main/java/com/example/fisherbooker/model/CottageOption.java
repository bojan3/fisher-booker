package com.example.fisherbooker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CottageOption {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20)
	private String name;
	@Column(length = 350)
	private String description;
	private int price;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cottage_id")
	private Cottage cottage;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	Set<CottageSuperDeal> superDeals = new HashSet<CottageSuperDeal>();

	public CottageOption() {
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}

	public static CottageOption toModel(CottageOption newOption) {
		CottageOption option = new CottageOption();
		if(newOption.getId() != 0) {
			option.setId(newOption.getId());
		}
		option.setName(newOption.getName());
		option.setDescription(newOption.getDescription());
		option.setPrice(newOption.getPrice());
		option.setCottage(newOption.getCottage());
		return option;
	}

	public Set<CottageSuperDeal> getSuperDeals() {
		return superDeals;
	}

	public void setSuperDeals(Set<CottageSuperDeal> superDeals) {
		this.superDeals = superDeals;
	}

	public void addSuperDeal(CottageSuperDeal newdeal) {
		if (newdeal == null)
			return;
		if (this.superDeals == null)
			this.superDeals = new java.util.HashSet<CottageSuperDeal>();
		if (!this.superDeals.contains(newdeal))
			this.superDeals.add(newdeal);
	}

	@Override
	public String toString() {
		return this.name + " -- " + this.description + " -- " + this.price;
	}

}