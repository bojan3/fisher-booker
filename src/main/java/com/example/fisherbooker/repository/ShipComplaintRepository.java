package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fisherbooker.model.complaint.ShipComplaint;

public interface ShipComplaintRepository extends JpaRepository<ShipComplaint, Long>{

}
