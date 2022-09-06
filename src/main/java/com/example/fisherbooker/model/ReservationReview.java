package com.example.fisherbooker.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "reservation_reviews")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "image_type", discriminatorType = DiscriminatorType.STRING)
public class ReservationReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String content;
	protected Boolean badReview;
	protected Boolean didntAppear;
	protected Boolean answered = false;
	

	public ReservationReview() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getBadReview() {
		return badReview;
	}

	public void setBadReview(Boolean badReview) {
		this.badReview = badReview;
	}

	public Boolean getDidntAppear() {
		return didntAppear;
	}

	public void setDidntAppear(Boolean didntAppear) {
		this.didntAppear = didntAppear;
	}
	
	public Boolean getAnswered() {
		return this.answered;
	}

	public void setAnswered(Boolean answered) {
		this.answered = answered;
	}

}
