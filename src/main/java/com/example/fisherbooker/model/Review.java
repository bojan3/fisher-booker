package com.example.fisherbooker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(length = 300)
	private String comment;
	
	@Column
	private int grade;
	
	@Column
	//@JoinColumn(name="client_id", nullable=false)
	Long client_id;
	
	@Column
	Long id_entity;
	
	@Column
	ReviewEntity r_entity;
	
	@Column 
	Boolean published;

	public Review(Long id, String comment, int grade, Long client, Long id_entity, ReviewEntity r_entity) {
		super();
		this.id = id;
		this.comment = comment;
		this.grade = grade;
		this.client_id = client;
		this.id_entity = id_entity;
		this.r_entity = r_entity;
		this.published = false;
	}
	
	public Review() {}
	
	
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

	public long getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Long getClient() {
		return client_id;
	}

	public void setClient(Long client) {
		this.client_id = client;
	}

	public Long getId_entity() {
		return id_entity;
	}

	public void setId_entity(Long id_entity) {
		this.id_entity = id_entity;
	}

	

	public ReviewEntity getR_entity() {
		return r_entity;
	}

	public void setR_entity(ReviewEntity r_entity) {
		this.r_entity = r_entity;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + ", grade=" + grade + ", client=" + client_id + ", id_entity="
				+ id_entity + ", r_entity=" + r_entity + ", published=" + published + "]";
	}
	

	
	
}
