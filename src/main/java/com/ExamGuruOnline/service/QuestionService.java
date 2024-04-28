package com.ExamGuruOnline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamGuruOnline.entity.Question;
import com.ExamGuruOnline.repository.QuestionRepo;
import com.ExamGuruOnline.serviceInterface.QuestionServiceInterface;

@Service
public class QuestionService implements QuestionServiceInterface{

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public boolean addNewQuestion(Question question) {
		questionRepo.save(question);
		return true;
	}

	@Override
	public boolean updateQuestionDetails(Question question, String emailId) throws Exception {
		try {
			Optional<Question> ques = questionRepo.findById(question.getQuestionID());
			if(ques.isPresent()) {
				if(question.getCreatedByUser().equals(ques.get().getCreatedByUser())) {
					if(question.getQuestion() != null) {
						ques.get().setQuestion(question.getQuestion());
					}
					if(question.getQuestionCategoryId() != null) {
						ques.get().setQuestionCategoryId(question.getQuestionCategoryId());
					}
					if(question.getCorrectOption() != null) {
						ques.get().setCorrectOption(question.getCorrectOption());
					}
					if(question.getQuestionOption() != null) {
						ques.get().setQuestionOption(question.getQuestionOption());
					}
					questionRepo.save(ques.get());
					return true;
				}else {
					throw new Exception("You are not allowed to update Question Deatils, Only user who has created the question has access to modify details!!");				}
			}else {
				throw new Exception("No Question Details Found with the provided Details!!");
			}
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public boolean deleteQuestionById(Long questionId, String email) throws Exception {
		try {
			Optional<Question> ques = questionRepo.findById(questionId);
			if(ques.isPresent()) {
				if(email.equals(ques.get().getCreatedByUser())) {
					questionRepo.deleteById(questionId);
					return true;
				}else {
					throw new Exception("You are not allowed to update Question Deatils, Only user who has created the question has access to modify details!!");				
			}
			}else {
				throw new Exception("No Question Details found with the provided Id!!");
			}
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public Question getQuestionById(Long id, String emailId) throws Exception {
		try {
			Optional<Question> ques = questionRepo.findById(id);
			if(ques.isPresent()) {
				if(!emailId.equals(ques.get().getCreatedByUser())) {
					ques.get().setCorrectOption(null);
				}
				return ques.get();
			}else {
				throw new Exception("No Question Details found with the provided Id!!");
			}
		}catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
	
	@Override
	public List<Question> getQuestionsByUserId(String userId, String currentUserID) throws Exception {
		try {
			List<Question> ques = questionRepo.findByCreatedByUser(userId);
			if(ques.size() != 0) {
				if(!userId.equals(currentUserID)) {
					ques = ques.stream().map(temp -> {
						if(!temp.getCreatedByUser().equals(currentUserID)) {
							temp.setCorrectOption(null);
						}
						return temp;
					}).collect(Collectors.toList());
				}
				return ques;
			}
			throw new Exception("No Question is added by User Id: "+ userId) ;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public List<Question> getQuestionsByOrganizationId(Long orgId, String userId) throws Exception {
		try {
			List<Question> ques = questionRepo.findByOrganizationId(orgId);
			if(ques.size() != 0) {
				ques = ques.stream().map(temp -> {
					if(!temp.getCreatedByUser().equals(userId)) {
						temp.setCorrectOption(null);
					}
					return temp;
				}).collect(Collectors.toList());
				return ques;
			}
			throw new Exception("No Question is added by Your Organization Yet.");
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Question> getMultipleQuestionById(List<Long> questionsIds, String userId) throws Exception {
		try {
			List<Question> ques = new ArrayList<>();
			for(int i = 0; i < questionsIds.size(); i++) {
				Optional<Question> q = questionRepo.findById(questionsIds.get(i));
				if(!q.isPresent()) {
					throw new Exception("No Question Detail found with the Id : " + questionsIds.get(i));
				}
				if(!q.get().getCreatedByUser().equals(userId)) {
					q.get().setCorrectOption(null);
				}
				ques.add(q.get());
			}
			return ques;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
	
}
