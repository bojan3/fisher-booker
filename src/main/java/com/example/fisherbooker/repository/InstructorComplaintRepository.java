package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fisherbooker.model.complaint.InstructorComplaint;

public interface InstructorComplaintRepository extends JpaRepository<InstructorComplaint, Long>{

}
