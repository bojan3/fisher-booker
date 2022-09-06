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
			this.points = 0;
			break;
		case BRONZE:
			this.name = Status_name.SILVER;
			this.points = 0;
			break;
		case SILVER:
			this.name = Status_name.GOLD;
			this.points = 0;
			break;
		case GOLD:
			this.name = Status_name.DIAMOND;
			this.points = 0;
			break;
		default:
			break;
		}
	}
	
	public Status_name getName() {
		return this.name;	
	}
	
	public int getPoints() {
		return this.points;	
	}
	
	public void increasePoints(){
		this.points = points+1;
		this.ScalePoinsts();
		
	}
	
	public void ScalePoinsts() {
		switch(this.points+"|"+this.name) {
			case ("20|Status_name.GOLD"):
				this.IncreaseRank();
				break;
				
		    case ("15|Status_name.SILVER"):
				this.IncreaseRank();
				break;
				
			case ("10| Status_name.BRONZE"):
				this.IncreaseRank();
				break;
				
			case ("5|Status_name.REGULAR"):
				this.IncreaseRank();	
				break;
			default:
				break;
			}
		}

	@Override
	public String toString() {
		return "Status [id=" + id + ", name=" + name + ", points=" + points + "]";
	}
		
	
	}
	


