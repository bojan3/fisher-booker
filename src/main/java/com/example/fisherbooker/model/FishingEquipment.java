package com.example.fisherbooker.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FishingEquipment {
	@Id
	private String name;
}