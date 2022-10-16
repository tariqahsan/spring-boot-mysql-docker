package org.mma.training.java.spring.controller;

import java.util.List;
import java.util.Optional;

import org.mma.training.java.spring.model.User;
import org.mma.training.java.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {

		return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {

		return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") long userId) {

		Optional<User> user = userRepository.findById(userId);
		
		if(user.isPresent()) {
			
			return new ResponseEntity<User>(user.get(), HttpStatus.FOUND);
			
		} else {
			
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			
		} 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long userId) {

		Optional<User> user = userRepository.findById(userId);
		
		if(user.isPresent()) {
			
			userRepository.deleteById(userId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} else {
			
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			
		} 
	}

}
