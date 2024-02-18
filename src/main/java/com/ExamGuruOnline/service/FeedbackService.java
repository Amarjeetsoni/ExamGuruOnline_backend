package com.ExamGuruOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamGuruOnline.entity.Feedback;
import com.ExamGuruOnline.repository.FeedbackRepo;
import com.ExamGuruOnline.serviceInterface.FeedbackServiceInterface;

@Service
public class FeedbackService implements FeedbackServiceInterface{

	@Autowired
	private FeedbackRepo feedbackRepo;

	@Override
	public boolean addFeedbackToTest(String comment, Long userId, Long testId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addFeedbackToQuestion(String comment, Long userId, Long questionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Feedback getFeedbackById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> getFeedbackOfListOfIds(List<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
