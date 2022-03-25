package com.hostel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hostel.data.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>{

	@Query(value = "SELECT * FROM GUEST WHERE FIRST_NAME = ?1 AND LAST_NAME = ?2 AND EMAIL_ADDRESS = ?3", nativeQuery = true)
	Optional<Guest> findExistingGuest(String firstName, String lastName, String email);
	
}
