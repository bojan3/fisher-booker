package com.example.fisherbooker.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cottage")
public class Cottage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30)
	private String name;
	@Column(length = 300)
	private String description;
	@Transient
	private float averageMark;

	@OneToOne
	public Address address;
	
	@OneToMany
	public List<Room> room;
	
	
	/*public Set<Rule> rule;
	public Set<CottageFastReservation> cottageFastReservation;
	public AvailabilityPeriod availabilityPeriod;
	public Set<CottagePicture> cottagePicture;
	public Set<CottageReservation> cottageReservation;
	public CottageOption cottageOption;

	public java.util.List<Room> getRoom() {
		if (room == null)
			room = new java.util.ArrayList<Room>();
		return room;
	}

	public java.util.Iterator getIteratorRoom() {
		if (room == null)
			room = new java.util.ArrayList<Room>();
		return room.iterator();
	}

	public void setRoom(java.util.List<Room> newRoom) {
		removeAllRoom();
		for (java.util.Iterator iter = newRoom.iterator(); iter.hasNext();)
			addRoom((Room) iter.next());
	}

	public void addRoom(Room newRoom) {
		if (newRoom == null)
			return;
		if (this.room == null)
			this.room = new java.util.ArrayList<Room>();
		if (!this.room.contains(newRoom))
			this.room.add(newRoom);
	}

	public void removeRoom(Room oldRoom) {
		if (oldRoom == null)
			return;
		if (this.room != null)
			if (this.room.contains(oldRoom))
				this.room.remove(oldRoom);
	}

	public void removeAllRoom() {
		if (room != null)
			room.clear();
	}

	public java.util.Set<Rule> getRule() {
		if (rule == null)
			rule = new java.util.HashSet<Rule>();
		return rule;
	}

	public java.util.Iterator getIteratorRule() {
		if (rule == null)
			rule = new java.util.HashSet<Rule>();
		return rule.iterator();
	}

	public void setRule(java.util.Set<Rule> newRule) {
		removeAllRule();
		for (java.util.Iterator iter = newRule.iterator(); iter.hasNext();)
			addRule((Rule) iter.next());
	}

	public void addRule(Rule newRule) {
		if (newRule == null)
			return;
		if (this.rule == null)
			this.rule = new java.util.HashSet<Rule>();
		if (!this.rule.contains(newRule))
			this.rule.add(newRule);
	}

	public void removeRule(Rule oldRule) {
		if (oldRule == null)
			return;
		if (this.rule != null)
			if (this.rule.contains(oldRule))
				this.rule.remove(oldRule);
	}

	public void removeAllRule() {
		if (rule != null)
			rule.clear();
	}

	public java.util.Collection<CottageFastReservation> getCottageFastReservation() {
		if (cottageFastReservation == null)
			cottageFastReservation = new java.util.HashSet<CottageFastReservation>();
		return cottageFastReservation;
	}

	public java.util.Iterator getIteratorCottageFastReservation() {
		if (cottageFastReservation == null)
			cottageFastReservation = new java.util.HashSet<CottageFastReservation>();
		return cottageFastReservation.iterator();
	}

	public void setCottageFastReservation(java.util.Collection<CottageFastReservation> newCottageFastReservation) {
		removeAllCottageFastReservation();
		for (java.util.Iterator iter = newCottageFastReservation.iterator(); iter.hasNext();)
			addCottageFastReservation((CottageFastReservation) iter.next());
	}

	public void addCottageFastReservation(CottageFastReservation newCottageFastReservation) {
		if (newCottageFastReservation == null)
			return;
		if (this.cottageFastReservation == null)
			this.cottageFastReservation = new java.util.HashSet<CottageFastReservation>();
		if (!this.cottageFastReservation.contains(newCottageFastReservation)) {
			this.cottageFastReservation.add(newCottageFastReservation);
			newCottageFastReservation.setCottage(this);
		}
	}

	public void removeCottageFastReservation(CottageFastReservation oldCottageFastReservation) {
		if (oldCottageFastReservation == null)
			return;
		if (this.cottageFastReservation != null)
			if (this.cottageFastReservation.contains(oldCottageFastReservation)) {
				this.cottageFastReservation.remove(oldCottageFastReservation);
				oldCottageFastReservation.setCottage((Cottage) null);
			}
	}

	public void removeAllCottageFastReservation() {
		if (cottageFastReservation != null) {
			CottageFastReservation oldCottageFastReservation;
			for (java.util.Iterator iter = getIteratorCottageFastReservation(); iter.hasNext();) {
				oldCottageFastReservation = (CottageFastReservation) iter.next();
				iter.remove();
				oldCottageFastReservation.setCottage((Cottage) null);
			}
		}
	}

	public java.util.Set<CottagePicture> getCottagePicture() {
		if (cottagePicture == null)
			cottagePicture = new java.util.HashSet<CottagePicture>();
		return cottagePicture;
	}

	public java.util.Iterator getIteratorCottagePicture() {
		if (cottagePicture == null)
			cottagePicture = new java.util.HashSet<CottagePicture>();
		return cottagePicture.iterator();
	}

	public void setCottagePicture(java.util.Set<CottagePicture> newCottagePicture) {
		removeAllCottagePicture();
		for (java.util.Iterator iter = newCottagePicture.iterator(); iter.hasNext();)
			addCottagePicture((CottagePicture) iter.next());
	}

	public void addCottagePicture(CottagePicture newCottagePicture) {
		if (newCottagePicture == null)
			return;
		if (this.cottagePicture == null)
			this.cottagePicture = new java.util.HashSet<CottagePicture>();
		if (!this.cottagePicture.contains(newCottagePicture))
			this.cottagePicture.add(newCottagePicture);
	}

	public void removeCottagePicture(CottagePicture oldCottagePicture) {
		if (oldCottagePicture == null)
			return;
		if (this.cottagePicture != null)
			if (this.cottagePicture.contains(oldCottagePicture))
				this.cottagePicture.remove(oldCottagePicture);
	}

	public void removeAllCottagePicture() {
		if (cottagePicture != null)
			cottagePicture.clear();
	}

	public java.util.Set<CottageReservation> getCottageReservation() {
		if (cottageReservation == null)
			cottageReservation = new java.util.HashSet<CottageReservation>();
		return cottageReservation;
	}

	public java.util.Iterator getIteratorCottageReservation() {
		if (cottageReservation == null)
			cottageReservation = new java.util.HashSet<CottageReservation>();
		return cottageReservation.iterator();
	}

	public void setCottageReservation(java.util.Set<CottageReservation> newCottageReservation) {
		removeAllCottageReservation();
		for (java.util.Iterator iter = newCottageReservation.iterator(); iter.hasNext();)
			addCottageReservation((CottageReservation) iter.next());
	}

	public void addCottageReservation(CottageReservation newCottageReservation) {
		if (newCottageReservation == null)
			return;
		if (this.cottageReservation == null)
			this.cottageReservation = new java.util.HashSet<CottageReservation>();
		if (!this.cottageReservation.contains(newCottageReservation)) {
			this.cottageReservation.add(newCottageReservation);
			newCottageReservation.setCottage(this);
		}
	}

	public void removeCottageReservation(CottageReservation oldCottageReservation) {
		if (oldCottageReservation == null)
			return;
		if (this.cottageReservation != null)
			if (this.cottageReservation.contains(oldCottageReservation)) {
				this.cottageReservation.remove(oldCottageReservation);
				oldCottageReservation.setCottage((Cottage) null);
			}
	}

	public void removeAllCottageReservation() {
		if (cottageReservation != null) {
			CottageReservation oldCottageReservation;
			for (java.util.Iterator iter = getIteratorCottageReservation(); iter.hasNext();) {
				oldCottageReservation = (CottageReservation) iter.next();
				iter.remove();
				oldCottageReservation.setCottage((Cottage) null);
			}
		}
	}*/

}