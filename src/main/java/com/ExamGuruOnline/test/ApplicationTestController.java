package com.ExamGuruOnline.test;


import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
@CrossOrigin("*")
public class ApplicationTestController {

	@GetMapping(value = "/getName")
	public ResponseEntity<Object> getNameString() {
		return new ResponseEntity<>(Arrays.asList("Abhay", "Abhi", "Ati", "Ashi", "Ashu", "Amar", "Abhinav"), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getHello")
	public ResponseEntity<Object> getHelloWord() {
		return new ResponseEntity<>("Hello World!!", HttpStatus.OK);
	}
	
}
