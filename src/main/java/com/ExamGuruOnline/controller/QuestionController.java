package com.ExamGuruOnline.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ExamGuruOnline.entity.Question;
import com.ExamGuruOnline.serviceInterface.QuestionServiceInterface;

@RestController
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionServiceInterface questionRepo;
	
	@PostMapping("/addQuestion")
	public ResponseEntity<Object> addNewQuestion(@RequestBody QuestionDetailsFromUser question){
		try {
			Question questionObj = new Question(question.question, question.questionOption, question.correctOption, question.questionCategoryId, question.createdByUser, question.organizationId, question.isMultipleChoise); 
			questionRepo.addNewQuestion(questionObj);
			return new ResponseEntity<Object>("Question Added Successfully!!", HttpStatus.OK);
		}catch (Exception exception) {
			return new ResponseEntity<Object>("Something wents wrong: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateQuestion")
	public ResponseEntity<Object> updateQuestionDetails(@RequestBody Question question){
		try {
			return new ResponseEntity<Object>(questionRepo.updateQuestionDetails(question, question.getCreatedByUser()), HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteQuestion")
	public ResponseEntity<Object> deleteQuestionById(@RequestParam Long questionId, @RequestBody String emailId){
		try {
			return new ResponseEntity<Object>(questionRepo.deleteQuestionById(questionId, emailId), HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getQuestionById")
	public ResponseEntity<Object> getQuestionById(@RequestParam Long questionId, @RequestParam String emailId){
		try {
			return new ResponseEntity<Object>(questionRepo.getQuestionById(questionId, emailId), HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllQuestionByUserId")
	public ResponseEntity<Object> getAllQuestionByUser(@RequestParam String userId, @RequestParam String currUserId){
		try {
			return new ResponseEntity<Object>(questionRepo.getQuestionsByUserId(userId, currUserId), HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllQuestionByOrgId")
	public ResponseEntity<Object> getAllQuestionByOrgId(@RequestParam Long orgId, @RequestParam String currUserId){
		try {
			return new ResponseEntity<Object>(questionRepo.getQuestionsByOrganizationId(orgId, currUserId), HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
class QuestionDetailsFromUser{
	public String question;
	public List<String> questionOption = new ArrayList<>();
	public List<String> correctOption = new ArrayList<>();
	public Long questionCategoryId;
	public String createdByUser;
	public Long organizationId;
	public boolean isMultipleChoise;
}
