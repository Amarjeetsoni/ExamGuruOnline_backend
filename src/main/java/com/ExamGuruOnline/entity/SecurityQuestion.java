package com.ExamGuruOnline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SecurityQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private String question;
	
	public SecurityQuestion() {
		super();
	}

	public SecurityQuestion(Long questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	public SecurityQuestion(String question) {
		super();
		this.question = question;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "SecurityQuestion [questionId=" + questionId + ", question=" + question + "]";
	}
	
	
	
	
}
