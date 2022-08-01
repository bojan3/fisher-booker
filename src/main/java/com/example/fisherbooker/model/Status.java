package com.example.fisherbooker.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Status_name name;
	private int points;
		
	
	public Status() {
		this.name = Status_name.REGULAR;
		this.points = 0;
	}
	
	public void IncreaseRank() {
		switch(this.name) {
		case REGULAR:
			this.name = Status_name.BRONZE;
			break;
		case BRONZE:
			this.name = Status_name.SILVER;
			break;
		case SILVER:
			this.name = Status_name.GOLD;
			break;
		case GOLD:
			this.name = Status_name.DIAMOND;
			break;
		default:
			break;
		}
	}
	
	
	public int getPoints() {
		return this.points;	
	}
	
	
	

}
