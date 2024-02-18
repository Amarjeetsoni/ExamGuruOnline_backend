package com.ExamGuruOnline.serviceInterface;

import org.springframework.stereotype.Component;

import com.ExamGuruOnline.entity.Test;

@Component
public interface TestServiceInterface {
	public boolean addNewTest(Test test);
	public boolean updateTestDetails(Test test);
	public boolean deleteTestById(Long testId);
	public Test getTestById(Long id);
	public boolean activateTestById(Long id);
	public boolean addFeedbackToTest(Long feedbackId, Long testId);
}
