package com.ExamGuruOnline.serviceInterface;

import java.util.List;

import com.ExamGuruOnline.customeException.SecurityQuestionException;
import com.ExamGuruOnline.entity.SecurityQuestion;

public interface SecurityQuestionServiceInterface {

	public boolean addSecurityQuestion(String sq);
	public SecurityQuestion updateSecurityQuestion(Long id, String question) throws SecurityQuestionException;
	public boolean deleteSecurityQuestion(Long id) throws SecurityQuestionException;
	public SecurityQuestion getSecurityQuestion(Long id) throws SecurityQuestionException;
	public List<SecurityQuestion> getAllSecurityQuestions() throws SecurityQuestionException;
	public boolean deleteAllSecurityQuestion();
	
}
