package com.ExamGuruOnline.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ExamGuruOnline.entity.Test;
import com.ExamGuruOnline.serviceInterface.CategoryServiceInterface;
import com.ExamGuruOnline.serviceInterface.TestServiceInterface;

@RestController
@CrossOrigin("*")
public class TestController {

	@Autowired
	private TestServiceInterface testService;
	
	@Autowired
	private CategoryServiceInterface catIntf;
	
	@PostMapping("/addTest")
	public ResponseEntity<Object> addANewQuestion(@RequestBody TestObjectFromUser testObj){
			try {
				Test test = new Test(testObj.userId, testObj.testName, testObj.testCategoryId, testObj.organizationId, testObj.totalMarks, testObj.testDuration, testObj.isActive, testObj.questionId, null);
				testService.addNewTest(test);
				return new ResponseEntity<>("Test Registered Successfully!!", HttpStatus.OK);
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
	
	@GetMapping("/getTestByOrgId")
	public ResponseEntity<Object> getTestDetailsByOrgId(@RequestParam Long orgId){
		try {
			return new ResponseEntity<Object>(testService.getTestByOrganizationID(orgId), HttpStatus.OK);
		}catch(Exception exp) {
			return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/getTestByUser")
	public ResponseEntity<Object> getTestDetailsByUser(@RequestParam String userId){
		try {
			return new ResponseEntity<Object>(testService.getTestByUserID(userId), HttpStatus.OK);
		}catch(Exception exp) {
			return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/getActiveStatus")
	public ResponseEntity<Object> getTestNameWithActiveStatusByUserId(@RequestParam String userId){
		try {
			List<Test> tests = testService.getTestByUserID(userId);
			List<TestActiveDetails> testActiveDetails = new ArrayList<>();
			for(Test tmp : tests) {
				TestActiveDetails td = new TestActiveDetails();
				td.testName = tmp.getTestName();
				td.isActive = tmp.isActive();
				td.testCategory = catIntf.getCategorybyId(tmp.getTestCategoryId()).getCategoryDesc();
				td.testId = tmp.getTestId();
				testActiveDetails.add(td);
			}
			return new ResponseEntity<Object>(testActiveDetails, HttpStatus.OK);
			
		}catch(Exception exp) {
			return new ResponseEntity<Object>("Something wents Wrong while fetching Test Data, Please try again in some time !!", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PostMapping("/updateStatus")
	public ResponseEntity<Object> updateTestStatusByTestID(@RequestBody TestActiveDetails tst){
		try {
			testService.updateTestStatus(tst.testId, tst.isActive);
			return new ResponseEntity<Object>("Test Status Updated Sucessfully", HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
}

class TestActiveDetails{
	public String testName;
	public String testCategory;
	public boolean isActive;
	public Long testId;
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
}

