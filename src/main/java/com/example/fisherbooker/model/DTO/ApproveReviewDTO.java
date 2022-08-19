package com.example.fisherbooker.model.DTO;

import com.example.fisherbooker.model.AdventureReview;
import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.CottageReview;
import com.example.fisherbooker.model.ShipReview;

public class ApproveReviewDTO {
	
	private Long id;
	
	private String comment;

	private int grade;

	private Long reviewEntityId;

	private Boolean forOwner;
	
	private String type;
	
	private Long client;
	
	private String username;
	
	
	

	public ApproveReviewDTO() {
		super();
	}

	public ApproveReviewDTO(String comment, int grade, Long reviewEntityId, Boolean forOwner) {
		super();
		this.comment = comment;
		this.grade = grade;
		this.reviewEntityId = reviewEntityId;
		this.forOwner = forOwner;
	}
	
	public ApproveReviewDTO(CottageReview cr) {
		super();
	//	this.setClient(cr.getClient());
		this.id=cr.getId();

		this.comment = cr.getComment();
		this.grade = cr.getGrade();
		this.forOwner = cr.getForOwner();
		this.reviewEntityId=cr.getCottageId();
		//this.type="cottage_review";
		this.setType("cottage_review");
		this.username = cr.getClient().getAccount().getUsername();
	}
	
	public ApproveReviewDTO(ShipReview shr) {
		super();
		//this.setClient(shr.getClient());
		this.id=shr.getId();

		this.comment = shr.getComment();
		this.grade = shr.getGrade();
		this.forOwner = shr.getForOwner();
		this.reviewEntityId=shr.getCottageId();
		this.setType("ship_review");
		this.username = shr.getClient().getAccount().getUsername();


	}
	
	public ApproveReviewDTO(AdventureReview ar) {
		super();
		this.id=ar.getId();
		this.setUsername(ar.getClient().getAccount().getUsername());
		this.comment = ar.getComment();
		this.grade = ar.getGrade();
		this.forOwner = ar.getForOwner();
		this.reviewEntityId = ar.getAdventureId();
		//this.type="adventure_review";
		this.setType("adventure_review");

	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long Id) {
		this.id = Id;
	}
	
	
	public Long getReviewEntityId() {
		return reviewEntityId;
	}

	public void setReviewEntityId(Long reviewEntityId) {
		this.reviewEntityId = reviewEntityId;
	}

	public Boolean getForOwner() {
		return forOwner;
	}

	public void setForOwner(Boolean forOwner) {
		this.forOwner = forOwner;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "ApproveReviewDTO [comment=" + comment + ", grade=" + grade + ", reviewEntityId=" + reviewEntityId
				+ ", forOwner=" + forOwner + ", type=" + type + ", client_username =" + username + "]";
	}

   
	
	
}

