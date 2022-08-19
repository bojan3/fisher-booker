package com.example.fisherbooker.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.fisherbooker.model.DTO.CreateReviewDTO;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(name = "review_type")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String comment;

	@Column
	private int grade;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	@Column
	private Boolean approved;

	@Column
	private Boolean forOwner;

	public Review() {
		super();
	}

	public Review(CreateReviewDTO createReviewDTO, Client client) {
		super();
		this.comment = createReviewDTO.getComment();
		this.grade = createReviewDTO.getGrade();
		this.client = client;
		this.approved = false;
		this.forOwner = createReviewDTO.getForOwner();
	}

	
	public Review(String comment, int grade, Client client, Boolean approved, Boolean forOwner) {
		super();
		this.comment = comment;
		this.grade = grade;
		this.client = client;
		this.forOwner = forOwner;
		this.approved = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Boolean getForOwner() {
		return forOwner;
	}

	public void setForOwner(Boolean forOwner) {
		this.forOwner = forOwner;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + ", grade=" + grade + ", client=" + client + ", approved="
				+ approved + ", forOwner=" + forOwner + "]";
	}
	
	

}
