package com.example.fisherbooker.model.DTO;

public class CreateReviewDTO {

	private String comment;

	private int grade;

	private Long reviewEntityId;

	private Boolean forOwner;

	public CreateReviewDTO() {
		super();
	}

	public CreateReviewDTO(String comment, int grade, Long reviewEntityId, Boolean forOwner) {
		super();
		this.comment = comment;
		this.grade = grade;
		this.reviewEntityId = reviewEntityId;
		this.forOwner = forOwner;
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

}
