package com.ExamGuruOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ExamGuruOnline.entity.Test;
import com.ExamGuruOnline.serviceInterface.TestServiceInterface;

@RestController
@CrossOrigin("*")
public class TestController {

	@Autowired
	private TestServiceInterface testService;
	
	@PostMapping("/addTest")
	public ResponseEntity<Object> addANewQuestion(@RequestBody TestObjectFromUser testObj){
			try {
				Test test = new Test(testObj.userId, testObj.testName, testObj.testCategoryId, testObj.organizationId, testObj.totalMarks, testObj.testDuration, testObj.isActive, testObj.questionId, testObj.feedbackId);
				testService.addNewTest(test);
				return new ResponseEntity<>("Test Details Added Successfully!!", HttpStatus.OK);
			}catch(Exception ex) {
				return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
			}
	}
	
	@PostMapping("/updateTest")
	public ResponseEntity<Object> updateQuestionDetails(@RequestBody Test testObj){
		try {
			testService.updateTestDetails(testObj, testObj.getUserId());
			return new ResponseEntity<>("Test Details Updated Successfully!!", HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
}
	
}

class TestObjectFromUser{
	public String userId;
	public String testName;
	public Long testCategoryId;
	public Long organizationId;
	public double totalMarks;
	public Long testDuration;
	public boolean isActive;
	public List<Long> questionId;
	public List<Long> feedbackId;
}

