package com.example.fisherbooker.model.DTO;

import java.util.Set;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.FishingInstructor;

public class FishingInstructorDTO {

	private Long id;
	private Account account;
	private String biography;
	private Set<Adventure> adventures;
	
	
	FishingInstructorDTO(Account account, Long id, String biography, Set<Adventure> adventures) {
		this.account = account;
		this.id = id;
		this.biography = biography;
	    this.adventures= adventures;
	}

	public FishingInstructorDTO(FishingInstructor instructor) {
		this.account = instructor.getAccount();
		this.id = instructor.getId();
		this.biography = instructor.getBiography();
	}

	public static FishingInstructorDTO createFishingInstructorDTO(FishingInstructor fi) {
		
		return new FishingInstructorDTO(fi.getAccount(), fi.getId(), fi.getBiography());

	}	

	
	public static FishingInstructorDTO createFishingInstructorDTOincludeAdventures(FishingInstructor fi) {
		
		return new FishingInstructorDTO(fi.getAccount(), fi.getId(), fi.getBiography(),fi.getAdventure());

		
		
	} 
	
public  FishingInstructorDTO(FishingInstructor fishingInstructor) {
		this.setAccount(fishingInstructor.getAccount());
		this.setBiography(fishingInstructor.getBiography());
		this.setId(fishingInstructor.getId());
		
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
