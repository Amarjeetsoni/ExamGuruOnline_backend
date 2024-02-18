package com.ExamGuruOnline.serviceInterface;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ExamGuruOnline.entity.Feedback;

@Component
public interface FeedbackServiceInterface {

	public boolean addFeedbackToTest(String comment, Long userId, Long testId);
	public boolean addFeedbackToQuestion(String comment, Long userId, Long questionId);
	public Feedback getFeedbackById(Long id);
	public List<Feedback> getFeedbackOfListOfIds(List<Long> ids);
}
