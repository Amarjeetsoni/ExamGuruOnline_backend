package com.ExamGuruOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ExamGuruOnline.configuration.EmailValidator;
import com.ExamGuruOnline.customeException.NoUserFound;
import com.ExamGuruOnline.customeException.UserAlreadyPresentException;
import com.ExamGuruOnline.entity.User;
import com.ExamGuruOnline.serviceInterface.LoginSignupServiceInterface;

@RestController
@CrossOrigin("*")
public class LoginSignUpController {

	@Autowired
	private LoginSignupServiceInterface loginSignup;
	
	@PostMapping(value = "/login")
	public ResponseEntity<Object> validateAndLogin(@RequestBody LoginHelper login){
		try {
			if(!EmailValidator.isValidEmail(login.email)) {
				return new ResponseEntity<Object>("Please provide a Valid Email Format!!", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Object>(loginSignup.validateAndLogin(login.email, login.password), HttpStatus.OK);
		} catch (NoUserFound e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/validateMail")
	public ResponseEntity<Object> validateEmail(@RequestParam String email){
		try {
			if(!EmailValidator.isValidEmail(email)) {
				return new ResponseEntity<Object>("Please provide a Valid Email Format!!", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Object>(loginSignup.validateProvidedEmail(email),HttpStatus.OK);
		} catch (UserAlreadyPresentException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/registerOrganization")
	public ResponseEntity<Object> registerOrganization(@RequestParam String OrgName){
		try {
			return new ResponseEntity<Object>(loginSignup.registerANewOrganization(OrgName), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PostMapping(value = "/validateDetails")
	public ResponseEntity<Object> validateDetailsOnSignUp(@RequestBody User user){
		try {
			return new ResponseEntity<Object>(loginSignup.validateProvidedDetailsOnSignupPage(user), HttpStatus.OK);
		} catch (UserAlreadyPresentException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PostMapping(value = "/signup")
	public ResponseEntity<Object> signUp(@RequestBody User user){
		try {
			if(!EmailValidator.isValidEmail(user.getEmail())) {
				return new ResponseEntity<Object>("Please provide a Valid Email Format!!", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Object>(loginSignup.signUp(user), HttpStatus.OK);
		} catch (UserAlreadyPresentException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
}

class LoginHelper{
	public String email;
	public String password;
}
