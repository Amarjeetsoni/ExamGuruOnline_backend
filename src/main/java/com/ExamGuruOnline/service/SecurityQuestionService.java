package com.ExamGuruOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ExamGuruOnline.customeException.SecurityQuestionException;
import com.ExamGuruOnline.entity.SecurityQuestion;
import com.ExamGuruOnline.repository.SecurityQuestionRepo;
import com.ExamGuruOnline.serviceInterface.SecurityQuestionServiceInterface;

public class SecurityQuestionService implements SecurityQuestionServiceInterface{

	@Autowired
	private SecurityQuestionRepo securityRepo;
	
	@Override
	public boolean addSecurityQuestion(String question) {
		SecurityQuestion sq = new SecurityQuestion(question);
		securityRepo.save(sq);
		return true;
	}

	@Override
	public SecurityQuestion updateSecurityQuestion(Long id, String question) throws SecurityQuestionException {
		Optional<SecurityQuestion> currentQuestion = securityRepo.findById(id);
		if(currentQuestion.isPresent()) {
			currentQuestion.get().setQuestion(question);
			securityRepo.save(currentQuestion.get());
			return currentQuestion.get();
		}else {
			throw new SecurityQuestionException("No Question Found with provide Id: " + id);
		}
	}

	@Override
	public boolean deleteSecurityQuestion(Long id) throws SecurityQuestionException {
		Optional<SecurityQuestion> question = securityRepo.findById(id);
		if(question.isPresent()) {
			securityRepo.deleteById(id);
			return true;
		}else {
			throw new SecurityQuestionException("No Question Found with provide Id: " + id);
		}
	}

	@Override
	public SecurityQuestion getSecurityQuestion(Long id) throws SecurityQuestionException {
		Optional<SecurityQuestion> question = securityRepo.findById(id);
		if(question.isPresent()) {
			return question.get();
		}else {
			throw new SecurityQuestionException("No Question Found with provide Id: " + id);
		}
	}

	@Override
	public List<SecurityQuestion> getAllSecurityQuestions() throws SecurityQuestionException {
		List<SecurityQuestion> allQuestion = securityRepo.findAll();
		if(allQuestion != null && allQuestion.size() > 0) {
			return allQuestion;
		}
		throw new SecurityQuestionException("No Security Question Added Yet!!");
	}

	@Override
	public boolean deleteAllSecurityQuestion() {
		securityRepo.deleteAll();
		return true;
	}

}
