package com.ExamGuruOnline.serviceInterface;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ExamGuruOnline.entity.Feedback;

@Component
public interface FeedbackServiceInterface {

	public boolean addFeedbackToTest(String comment, String userId, Long testId);
	public boolean addFeedbackToQuestion(String comment, String userId, Long questionId);
	public Feedback getFeedbackById(Long id) throws Exception;
	public List<Feedback> getFeedbackOfListOfIds(List<Long> ids);
	public List<Feedback> getAllFeedbackWithUserId(String userId);
	public List<Feedback> getAllFeedbackByQuestionOrTestId(Long testId) throws Exception;
}
