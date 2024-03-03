package com.ExamGuruOnline.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionID;
	private String question;
	@ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
	private List<String> questionOption = new ArrayList<>();
	@ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
	private List<String> correctOption = new ArrayList<>();
	private Long questionCategoryId;
	private String createdByUser;
	private Long organizationId;
	private boolean isMultipleChoise;

	public Question(Long questionID, String question, List<String> questionOption, List<String> correctOption,
			Long questionCategoryId, String createdByUser, Long organizationId, boolean isMutiChoise) {
		super();
		this.questionID = questionID;
		this.question = question;
		this.questionOption = questionOption;
		this.correctOption = correctOption;
		this.questionCategoryId = questionCategoryId;
		this.createdByUser = createdByUser;
		this.organizationId = organizationId;
		this.isMultipleChoise = isMutiChoise;
	}

	public Question(String question, List<String> questionOption, List<String> correctOption, Long questionCategoryId,
			String createdByUser, Long organizationId, boolean isMultiChoise) {
		super();
		this.question = question;
		this.questionOption = questionOption;
		this.correctOption = correctOption;
		this.questionCategoryId = questionCategoryId;
		this.createdByUser = createdByUser;
		this.organizationId = organizationId;
		this.isMultipleChoise = isMultiChoise;
	}

	public Question() {
		super();
	}

	public Long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getQuestionOption() {
		return questionOption;
	}

	public void setQuestionOption(List<String> questionOption) {
		this.questionOption = questionOption;
	}

	public List<String> getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(List<String> correctOption) {
		this.correctOption = correctOption;
	}

	public Long getQuestionCategoryId() {
		return questionCategoryId;
	}

	public void setQuestionCategoryId(Long questionCategoryId) {
		this.questionCategoryId = questionCategoryId;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public boolean isMultipleChoise() {
		return isMultipleChoise;
	}

	public void setMultipleChoise(boolean isMultipleChoise) {
		this.isMultipleChoise = isMultipleChoise;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", question=" + question + ", questionOption=" + questionOption
				+ ", correctOption=" + correctOption + ", questionCategoryId=" + questionCategoryId + ", createdByUser="
				+ createdByUser + ", organizationId=" + organizationId + ", isMultipleChoise=" + isMultipleChoise
				+ "]";
	}

	
}
