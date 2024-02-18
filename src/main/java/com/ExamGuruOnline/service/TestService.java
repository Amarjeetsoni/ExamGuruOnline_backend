package com.ExamGuruOnline.service;

import com.ExamGuruOnline.entity.Test;
import com.ExamGuruOnline.serviceInterface.TestServiceInterface;

public class TestService implements TestServiceInterface{

	@Override
	public boolean addNewTest(Test test) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTestDetails(Test test) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTestById(Long testId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Test getTestById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean activateTestById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addFeedbackToTest(Long feedbackId, Long testId) {
		// TODO Auto-generated method stub
		return false;
	}

}
