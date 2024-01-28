package com.ExamGuruOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ExamGuruOnline.customeException.NoUserFound;
import com.ExamGuruOnline.customeException.UserAlreadyPresentException;
import com.ExamGuruOnline.entity.User;
import com.ExamGuruOnline.serviceInterface.UserServiceInterface;

@RestController
@RequestMapping(value = "user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserServiceInterface userInterface;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
	@PostMapping(value = "/registerUser", consumes= {"application/json"})
	public ResponseEntity<Object> AddNewUser(@RequestBody User user){
		try {
			userInterface.validateNewUser(user.getEmail());
//			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userInterface.addNewUser(user);
			return new ResponseEntity<Object>("User Created Successfully :)", HttpStatus.OK);
		}catch(UserAlreadyPresentException exception) {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
		}catch(Exception exception) {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "/updateUser", consumes= {"application/json"})
	public ResponseEntity<Object> UpdateUserDetails(@RequestBody User user){
		try {
			userInterface.updateUserDetails(user);
			return new ResponseEntity<Object>("User Updated Successfully :)", HttpStatus.OK);
		}catch(NoUserFound exception) {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
		}catch(Exception exception) {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/validateMail")
	public ResponseEntity<Object> validateEmailId(@RequestParam String email){
		try {
			userInterface.validateNewUser(email);
			return new ResponseEntity<Object>("Valid Email", HttpStatus.OK);
		}catch(UserAlreadyPresentException exception) {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
		}catch(Exception exception) {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<Object> deleteUser(@RequestParam String email){
		try {
			userInterface.deleteUser(email);
			return new ResponseEntity<Object>("User Delete Successfully!!", HttpStatus.OK);
		}catch(NoUserFound exception) {
			return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
		}catch(Exception exception) {
			return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<Object> getUserById(@RequestParam String email){
		try {
			return new ResponseEntity<Object>(userInterface.getUserById(email), HttpStatus.OK);
		}catch(NoUserFound exception) {
			return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
		}catch(Exception exception) {
			return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/validateChangePassword", consumes= {"application/json"})
	public ResponseEntity<Object> validateUserForChangePassword(@RequestBody ValidateChangePasswordHelper helper){
		try {
			return new ResponseEntity<Object>(userInterface.validateUserForChangePassword(helper.email, helper.question, helper.answer),HttpStatus.OK);
		}catch(NoUserFound exception) {
			return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
		}catch(Exception exception) {
			return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "/changePassword", consumes= {"application/json"})
	public ResponseEntity<Object> changePasswordAfterValidation(@RequestBody ChangePasswordHelper helper){
		try {
//			return new ResponseEntity<Object>(userInterface.changePassword(helper.email, passwordEncoder.encode(helper.password)),HttpStatus.OK);
			return new ResponseEntity<Object>(userInterface.changePassword(helper.email, helper.password),HttpStatus.OK);
		}catch(NoUserFound exception) {
			return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
		}catch(Exception exception) {
			return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<Object> getAllUser(){
		try {
			List<User> allUsers = userInterface.getAllUsers();
			return new ResponseEntity<Object>(allUsers, HttpStatus.OK);
		}catch(NoUserFound exception) {
			return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
		}catch(Exception exception) {
			return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}

class ValidateChangePasswordHelper{
	public String email;
	public Long question;
	public String answer;
}

class ChangePasswordHelper{
	public String email;
	public String password;
}
