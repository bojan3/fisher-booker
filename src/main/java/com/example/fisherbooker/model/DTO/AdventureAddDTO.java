package com.example.fisherbooker.model.DTO;

import java.util.Set;

import com.example.fisherbooker.model.Address;
import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureOption;
import com.example.fisherbooker.model.AvailabilityPeriod;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.FishingEquipment;
import com.example.fisherbooker.model.Room;
import com.example.fisherbooker.model.Rule;

public class AdventureAddDTO {

		private String name;
		private String description;
		private Address address;
		private Set<Rule> rules;
		private AvailabilityPeriod availabilityPeriod;
		private Set<AdventureOption> adventureOptions;
		private Set<FishingEquipment> equipment;
		
		
		

		private int pricePerDay;

		public AdventureAddDTO() {
			super();
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

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public Set<Rule> getRules() {
			return rules;
		}

		public void setRules(Set<Rule> rules) {
			this.rules = rules;
		}

		public AvailabilityPeriod getAvailabilityPeriod() {
			return availabilityPeriod;
		}

		public void setAvailabilityPeriod(AvailabilityPeriod availabilityPeriod) {
			this.availabilityPeriod = availabilityPeriod;
		}

		public Set<AdventureOption> getAdventureOptions() {
			return adventureOptions;
		}

		public void setAdventureOptions(Set<AdventureOption> adventureOptions) {
			this.adventureOptions = adventureOptions;
		}

		public int getPricePerDay() {
			return pricePerDay;
		}

		public void setPricePerDay(int pricePerDay) {
			this.pricePerDay = pricePerDay;
		}

		public Adventure toModel() {
			Adventure a = new Adventure();
			a.setName(this.name);
			a.setDescription(this.description);
			a.setAddress(this.address);
			a.setPrice(this.pricePerDay);
			a.setEquipment(this.equipment);
			//a.setAvailabilityPeriod(this.availabilityPeriod);
			a.setFishingOption(this.adventureOptions);
			a.setRule(this.rules);
			return a;
		}

	}
