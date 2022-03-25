package com.hostel.converter;

import com.hostel.builder.GuestBuilder;
import com.hostel.builder.GuestDtoBuilder;
import com.hostel.data.Guest;
import com.hostel.dto.GuestDto;

public class GuestConveter {

	public static Guest toEntity(GuestDto guestDto) {
		
		boolean isNull = guestDto == null;

		String firstName = isNull ? null : guestDto.getFirstName();
		String lastName = isNull ? null : guestDto.getLastName();
		String email = isNull ? null : guestDto.getEmail();
		String address = isNull ? null : guestDto.getAddress();
		String country = isNull ? null : guestDto.getCountry();
		String state = isNull ? null : guestDto.getState();
		String phoneNumber = isNull ? null : guestDto.getPhoneNumber();
		Boolean active = isNull ? null : guestDto.getActive();
		
		return GuestBuilder.create()
				.setFirstName(firstName)
				.setLastName(lastName)
				.setEmail(email)
				.setAddress(address)
				.setCountry(country)
				.setState(state)
				.setPhoneNumber(phoneNumber)
				.setActive(active)
				.build();
		
	}
	
	public static GuestDto toDto(Guest guest) {
		
		boolean isNull = guest == null;

		String firstName = isNull ? null : guest.getFirstName();
		String lastName = isNull ? null : guest.getLastName();
		String email = isNull ? null : guest.getEmail();
		String address = isNull ? null : guest.getAddress();
		String country = isNull ? null : guest.getCountry();
		String state = isNull ? null : guest.getState();
		String phoneNumber = isNull ? null : guest.getPhoneNumber();
		Boolean active = isNull ? null : guest.getActive();
		
		return GuestDtoBuilder.create()
				.setFirstName(firstName)
				.setLastName(lastName)
				.setEmail(email)
				.setAddress(address)
				.setCountry(country)
				.setState(state)
				.setPhoneNumber(phoneNumber)
				.setActive(active)
				.build();
		
	}
	
}
