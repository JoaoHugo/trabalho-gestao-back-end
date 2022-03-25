package com.hostel.builder;

import com.hostel.dto.GuestDto;

public class GuestDtoBuilder {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String address;

	private String country;

	private String state;

	private String phoneNumber;

	private Boolean active;
	
	public static GuestDtoBuilder create() {
		return new GuestDtoBuilder();
	}
	
	public GuestDtoBuilder setId(Long id) {
		this.id = id;
		return this;
	}
	
	public GuestDtoBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public GuestDtoBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public GuestDtoBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public GuestDtoBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public GuestDtoBuilder setCountry(String country) {
		this.country = country;
		return this;
	}
	
	public GuestDtoBuilder setState(String state) {
		this.state = state;
		return this;
	}
	
	public GuestDtoBuilder setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	
	public GuestDtoBuilder setActive(Boolean active) {
		this.active = active;
		return this;
	}
	
	public GuestDto build() {
		return new GuestDto(id, firstName, lastName, email, address, country, state, phoneNumber, active);
	}
	
}
