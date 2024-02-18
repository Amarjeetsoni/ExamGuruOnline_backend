package com.ExamGuruOnline.service;

import com.ExamGuruOnline.entity.Question;
import com.ExamGuruOnline.serviceInterface.QuestionServiceInterface;

public class QuestionService implements QuestionServiceInterface{

	@Override
	public Question addNewQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateQuestionDetails(Question question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteQuestionById(Long questionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Question getQuestionById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addNewFeedbackOnQuestion(Long feedbackId, Long testId) {
		// TODO Auto-generated method stub
		return false;
	}

}
