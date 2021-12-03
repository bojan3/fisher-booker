package com.example.fisherbooker.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fisherbooker.model.Adventure;

public interface AdventureRepository extends JpaRepository<Adventure, Long> {

	Adventure deleteAllById(Long id);

}
