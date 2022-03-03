package com.hostel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hostel.model.Guest;

@Repository
public interface SimpleRepository extends JpaRepository<Guest, Long>{

	@Query("SELECT g FROM GUEST g")
	List<Guest> getAllGuests();
	
}
