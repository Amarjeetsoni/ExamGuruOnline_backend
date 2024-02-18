package com.ExamGuruOnline.serviceInterface;

import org.springframework.stereotype.Component;

import com.ExamGuruOnline.entity.Question;

@Component
public interface QuestionServiceInterface {
	
	public Question addNewQuestion(Question question);
	public boolean updateQuestionDetails(Question question);
	public boolean deleteQuestionById(Long questionId);
	public Question getQuestionById(Long id);
	public boolean addNewFeedbackOnQuestion(Long feedbackId, Long testId);
	
}
