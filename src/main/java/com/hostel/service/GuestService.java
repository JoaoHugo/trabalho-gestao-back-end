package com.hostel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hostel.converter.GuestConveter;
import com.hostel.data.Guest;
import com.hostel.dto.GuestDto;
import com.hostel.exception.ExistingGuestException;
import com.hostel.repository.GuestRepository;

@Service
public class GuestService {

	@Autowired
	private GuestRepository guestRepository;

	public List<Guest> findAll(){
		return guestRepository.findAll();
	}
	
	public Guest findById(Long id) throws NotFoundException{
		return guestRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	public Page<Guest> searchPaged(Integer pageNumber, Integer pageSize){
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return guestRepository.findAll(pageable);
	}
	
	public Guest insert(GuestDto guestDto) throws ExistingGuestException{
		validateExistingGuest(guestDto.getFirstName(), guestDto.getLastName(), guestDto.getEmail());
		return guestRepository.save(GuestConveter.toEntity(guestDto));
	}
	
	public void update(GuestDto guestDto, Long id) throws NotFoundException{
		validateExistsById(id);
		Guest guest = GuestConveter.toEntity(guestDto);
		guest.setId(id);
		guestRepository.save(guest);
	}
	
	public void delete(Long id) throws NotFoundException{
		validateExistsById(id);
		
		guestRepository.deleteById(id);
	}
	
	public void validateExistsById(Long id) throws NotFoundException{
		if (!guestRepository.existsById(id)) {
			throw new NotFoundException();
		}
	}
	
	public void validateExistingGuest(String firstName, String lastName, String email) throws ExistingGuestException{
		if(guestRepository.findExistingGuest(firstName, lastName, email).isPresent()) {
			throw new ExistingGuestException("Hóspede já cadastrado!");
		}
	}
	
}
