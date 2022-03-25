package com.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestDto {
	
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String address;

	private String country;

	private String state;

	private String phoneNumber;

	private Boolean active;
	
}
