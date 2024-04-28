package com.ExamGuruOnline.serviceInterface;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ExamGuruOnline.entity.Question;

@Component
public interface QuestionServiceInterface {
	
	public boolean addNewQuestion(Question question);
	public boolean updateQuestionDetails(Question question, String emailId) throws Exception;
	public boolean deleteQuestionById(Long questionId, String emailId) throws Exception;
	public Question getQuestionById(Long id, String emailId) throws Exception;
	public List<Question> getQuestionsByUserId(String userId, String currUserId) throws Exception;
	public List<Question> getQuestionsByOrganizationId(Long orgId, String userId) throws Exception;
	public List<Question> getMultipleQuestionById(List<Long> questionsId, String userId) throws Exception;
}
