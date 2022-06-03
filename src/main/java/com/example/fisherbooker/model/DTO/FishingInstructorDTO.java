package com.example.fisherbooker.model.DTO;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.FishingInstructor;

public class FishingInstructorDTO {

	private Long id;
	private Account account;
	private String biography;

	FishingInstructorDTO(Account account, Long id, String biography) {
		this.account = account;
		this.id = id;
		this.biography = biography;
	}

	public FishingInstructorDTO(FishingInstructor instructor) {
		this.account = instructor.getAccount();
		this.id = instructor.getId();
		this.biography = instructor.getBiography();
	}

	public static FishingInstructorDTO createFishingInstructorDTO(FishingInstructor fi) {
		
		return new FishingInstructorDTO(fi.getAccount(), fi.getId(), fi.getBiography());

	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	
}
