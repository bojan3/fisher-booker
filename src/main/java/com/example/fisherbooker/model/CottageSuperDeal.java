package com.example.fisherbooker.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CottageSuperDeal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date startDate;
	private int discountedPrice;
	private Date endDate;
	private int duration;
	private int capacity;

	@ManyToOne
	@JoinColumn(name="cottage_id", nullable=false)
	public Cottage cottage;
	
	

}