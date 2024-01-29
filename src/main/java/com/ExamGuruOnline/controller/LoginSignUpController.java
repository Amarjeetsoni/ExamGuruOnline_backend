package com.ExamGuruOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ExamGuruOnline.serviceInterface.LoginSignupServiceInterface;

@RestController
@CrossOrigin("*")
public class LoginSignUpController {

	@Autowired
	private LoginSignupServiceInterface loginSignup;
	
	@PostMapping(value = "/login")
	public ResponseEntity<Object> validateAndLogin(@RequestBody LoginHelper login){
		return new ResponseEntity<Object>("Login Success with Any Check!!", HttpStatus.OK);
	}
}

class LoginHelper{
	public String email;
	public String password;
}
