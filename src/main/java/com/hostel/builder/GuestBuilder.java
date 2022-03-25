package com.hostel.builder;

import com.hostel.data.Guest;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GuestBuilder {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String address;

	private String country;

	private String state;

	private String phoneNumber;

	private Boolean active;
	
	public static GuestBuilder create() {
		return new GuestBuilder();
	}
	
	public GuestBuilder setId(Long id) {
		this.id = id;
		return this;
	}
	
	public GuestBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public GuestBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public GuestBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public GuestBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public GuestBuilder setCountry(String country) {
		this.country = country;
		return this;
	}
	
	public GuestBuilder setState(String state) {
		this.state = state;
		return this;
	}
	
	public GuestBuilder setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	
	public GuestBuilder setActive(Boolean active) {
		this.active = active;
		return this;
	}
	
	public Guest build() {
		return new Guest(id, firstName, lastName, email, address, country, state, phoneNumber, active);
	}
	
}
