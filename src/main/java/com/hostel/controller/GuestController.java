package com.hostel.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hostel.converter.GuestConveter;
import com.hostel.dto.GuestDto;
import com.hostel.exception.ExistingGuestException;
import com.hostel.service.GuestService;

@RestController
@RequestMapping(path = "guests")
public class GuestController {

	@Autowired
	private GuestService guestService;
	
	@GetMapping
	public ResponseEntity<List<GuestDto>> findAll(){
		
		List<GuestDto> guests = guestService.findAll().stream().map(GuestConveter::toDto).collect(Collectors.toList());
		return new ResponseEntity<>(guests ,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GuestDto> findById(@PathVariable(name = "id") Long id) throws NotFoundException{
		
		return new ResponseEntity<>(GuestConveter.toDto(guestService.findById(id)), HttpStatus.OK);
	}
	
	@GetMapping("/search-paginated")
	public ResponseEntity<Page<GuestDto>> searchPaginated(@RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize){
		Page<GuestDto> guests = guestService.searchPaged(pageNumber, pageSize).map(GuestConveter::toDto);
		return new ResponseEntity<>(guests, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<GuestDto> insert(@RequestBody GuestDto guestDto) throws ExistingGuestException{
		
		return new ResponseEntity<>(GuestConveter.toDto(guestService.insert(guestDto)),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody GuestDto guestDto, @PathVariable(name = "id") Long id) throws NotFoundException{
		guestService.update(guestDto, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) throws NotFoundException{
		guestService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
