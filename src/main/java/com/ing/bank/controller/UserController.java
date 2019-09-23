package com.ing.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.UserRequest;
import com.ing.bank.dto.UserResponse;
import com.ing.bank.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/create")
	public ResponseEntity<UserResponse> createAccount(@RequestBody UserRequest request)
	{
	 return new ResponseEntity<>(userService.createUser(request),HttpStatus.CREATED);	
	}
	
	

}
