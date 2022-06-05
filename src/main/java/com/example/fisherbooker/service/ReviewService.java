package com.example.fisherbooker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Review;
import com.example.fisherbooker.repository.ReviewRepository;
@Service
public class ReviewService {

	public ReviewRepository rr;
	@Autowired
	public ReviewService (ReviewRepository rr) {
		this.rr=rr;	
	}
	
	
	public boolean checkIfClientHasEntity(String username, Review review) {
		// TODO Auto-generated method stub
		return false;
	}

	public void saveReview(Review review) {
		this.rr.save(review);
		
	}
	
	public Boolean deleteReview(Long review_id) {
		this.rr.deleteById(review_id);
		return true;
	}


	public List<Review> getAllByGrade() {
		return this.rr.findByOrderByGrade();
	}


	public void publish(Long reviewID) {
	Review r =	this.rr.findById(reviewID).get();
	r.setPublished(true);
	this.rr.save(r);
		
	}


	public List<Review> getAllUnpublished() {
		List<Review> sve = this.rr.findAll();
		List<Review> neobjavljene = new ArrayList<Review>();
		
		 for(Review r : sve){
			if(r.getPublished().equals(false)) 
				neobjavljene.add(r);
		 }	
		return neobjavljene;
	}
	

}
