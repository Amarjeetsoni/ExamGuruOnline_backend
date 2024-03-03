package com.ExamGuruOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ExamGuruOnline.serviceInterface.QuestionServiceInterface;

@RestController
public class OrganizerController {

	@Autowired
	private QuestionServiceInterface questionRepo;
	
	
}
