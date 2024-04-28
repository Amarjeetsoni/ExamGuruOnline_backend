package com.ExamGuruOnline.serviceInterface;

import org.springframework.stereotype.Component;

import com.ExamGuruOnline.customeException.TestRelatedException;
import com.ExamGuruOnline.entity.Test;

@Component
public interface TestServiceInterface {
	public boolean addNewTest(Test test) throws TestRelatedException;
	public boolean updateTestDetails(Test test, String currentUserID) throws TestRelatedException;
	public boolean deleteTestById(Long testId, String currentUserId) throws TestRelatedException;
	public Test getTestById(Long id) throws TestRelatedException;
	public boolean activateTestById(Long id, String currentUser) throws TestRelatedException;
	public boolean deActivateTestById(Long id, String currentUser) throws TestRelatedException;
	public boolean addFeedbackToTest(Long feedbackId, Long testId);
}
