package com.ExamGuruOnline.controller;

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

import com.ExamGuruOnline.customeException.SecurityQuestionException;
import com.ExamGuruOnline.serviceInterface.SecurityQuestionServiceInterface;

@RestController
@RequestMapping(value = "/security")
@CrossOrigin("*")
public class SecurityQuestionController {
	
	@Autowired
	private SecurityQuestionServiceInterface securityQeustion;
	
	@PostMapping("/addQestion")
	public ResponseEntity<Object> addNewSecurityQuestion(@RequestBody String question){
			try {
				securityQeustion.addSecurityQuestion(question);
				return new ResponseEntity<Object>("Security Question Added Successfully!!", HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
			}
	}
	
	@PutMapping("/updateQuestion")
	public ResponseEntity<Object> updateSecurityQuestion(@RequestParam Long id, @RequestParam String question){
		try {
			securityQeustion.updateSecurityQuestion(id, question);
			return new ResponseEntity<Object>("Question Updated Successfully!!", HttpStatus.OK);
		}catch(SecurityQuestionException ex) {
			return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteQuestion")
	public ResponseEntity<Object> deleteQuestion(@RequestParam Long id){
		try {
			securityQeustion.deleteSecurityQuestion(id);
			return new ResponseEntity<Object>("Question Removed!!", HttpStatus.OK);
		}catch (SecurityQuestionException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getSecurityQuestion")
	public ResponseEntity<Object> getSecurityQuestionById(@RequestParam Long id){
		try {
			return new ResponseEntity<Object>(securityQeustion.getSecurityQuestion(id), HttpStatus.OK);
		}catch (SecurityQuestionException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllSecurityQuestion")
	public ResponseEntity<Object> getAllSecurityQuestion(){
		try {
			return new ResponseEntity<Object>(securityQeustion.getAllSecurityQuestions(), HttpStatus.OK);
		}catch (SecurityQuestionException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/deleteAllQuestion")
	public ResponseEntity<Object> deleteAllSecurityQuestion(){
		try {
			return new ResponseEntity<Object>(securityQeustion.deleteAllSecurityQuestion(), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
