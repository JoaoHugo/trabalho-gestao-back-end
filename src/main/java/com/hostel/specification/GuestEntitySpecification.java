package com.hostel.specification;

import org.springframework.data.jpa.domain.Specification;

import com.hostel.data.Guest;

public class GuestEntitySpecification {

	private static final String FIRST_NAME = "firstName";
	
	public static Specification<Guest> firstNameEquals(final String firstName) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(FIRST_NAME), firstName);
	}
	
}
