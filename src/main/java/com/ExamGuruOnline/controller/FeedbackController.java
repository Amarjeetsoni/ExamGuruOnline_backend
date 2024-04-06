package com.ExamGuruOnline.controller;

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

import com.ExamGuruOnline.serviceInterface.FeedbackServiceInterface;

@RestController
@CrossOrigin("*")
public class FeedbackController {

	@Autowired
	private FeedbackServiceInterface feedback;
	
	@PostMapping(value = "/addFeedbackTest")
	public ResponseEntity<Object> addFeedbackToTest(@RequestBody FeedbackDetails fd) {
		try {
			feedback.addFeedbackToTest(fd.comment, fd.userId, fd.testId);
			return new ResponseEntity<Object>("Feedback Added Successfully!", HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Object>("Something wents Wrong while adding data!", HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PostMapping(value = "/addFeedbackQuestion")
	public ResponseEntity<Object> addFeedbackToQuestiont(@RequestBody FeedbackDetails fd) {
		try {
			feedback.addFeedbackToQuestion(fd.comment, fd.userId, fd.testId);
			return new ResponseEntity<Object>("Feedback Added Successfully!", HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Object>("Something wents Wrong while adding data!", HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping(value = "/getFeedbackByID")
	public ResponseEntity<Object> getFeedbackById(@RequestParam Long id) {
		try {
			return new ResponseEntity<Object>(feedback.getFeedbackById(id), HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PostMapping(value = "/getFeedbackList")
	public ResponseEntity<Object> getFeedbackOfListOfIds(@RequestBody List<Long> ids){
		return new ResponseEntity<Object>(feedback.getFeedbackOfListOfIds(ids), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getFeedbackByUserId")
	public ResponseEntity<Object> getAllFeedbackWithUserId(@RequestParam String id){
		return new ResponseEntity<Object>(feedback.getAllFeedbackWithUserId(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getFeedbackByTestId")
	public ResponseEntity<Object> getAllFeedbackWithTestId(@RequestParam Long id){
		try {
			return new ResponseEntity<Object>(feedback.getAllFeedbackByQuestionOrTestId(id), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}

class FeedbackDetails{
	public String comment;
	public String userId;
	public Long testId;
}
