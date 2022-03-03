package com.hostel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostel.model.Guest;
import com.hostel.model.Model;
import com.hostel.repository.SimpleRepository;

@RestController
public class HostelController {
	
	@Autowired
	private SimpleRepository simpleRepository;
	
    @GetMapping(path = "hello-world")
    public ResponseEntity<Model> getMessage(){
    	
    	Model model = new Model();
        model.setMessage("Hello World");
        
        return new ResponseEntity<>(model ,HttpStatus.OK);
    }
    
    @GetMapping(path = "guests")
    public ResponseEntity<List<Guest>> getGuests(){
  
        return new ResponseEntity<>(simpleRepository.getAllGuests() ,HttpStatus.OK);
    }
 
}
