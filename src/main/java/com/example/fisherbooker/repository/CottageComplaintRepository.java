package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fisherbooker.model.complaint.CottageComplaint;

public interface CottageComplaintRepository extends JpaRepository<CottageComplaint, Long>{

}
