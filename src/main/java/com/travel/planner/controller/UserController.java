package com.travel.planner.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.planner.model.User;
import com.travel.planner.repo.UserRepo;

@RestController
@RequestMapping("/account")
public class UserController {
	@Autowired
	private UserRepo userRepo;
	
//	Signup
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User user){
	
	boolean name=userRepo.existsByUsername(user.getUsername());
	
	System.out.println(name);
	
	if(name)
	{
		String msg = "username already exists";
		return ResponseEntity.status(HttpStatus.OK)
				.body(msg);
				
	}
	User userDetails=userRepo.saveAndFlush(user);
	return ResponseEntity.status(HttpStatus.OK)
			.body(userDetails);
	}
//	Login
	@GetMapping("/check")
    public ResponseEntity<?> getUser(@RequestParam String username,@RequestParam String password) {
			Optional<User> user = userRepo.findByUsernameAndPassword(username,password);
			
			if(user.isPresent()) {
				return ResponseEntity.status(HttpStatus.OK).body(user.get());
			}else {
				return ResponseEntity.status(HttpStatus.OK).body("User not found");
			}
	}
}
