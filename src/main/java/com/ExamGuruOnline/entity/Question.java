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
	@ElementCollection(targetClass = Long.class, fetch = FetchType.LAZY)
	private List<String> questionOption = new ArrayList<>();
	private String correctOption;
	private Long questionCategoryId;
	private String createdByUser;
	private Long organizationId;
	private boolean isMultipleChoise;
	@ElementCollection(targetClass = Long.class, fetch = FetchType.LAZY)
	private List<Long> feedbackId = new ArrayList<>();

	public Question(Long questionID, String question, List<String> questionOption, String correctOption,
			Long questionCategoryId, String createdByUser, Long organizationId, List<Long> feedbackId, boolean isMutiChoise) {
		super();
		this.questionID = questionID;
		this.question = question;
		this.questionOption = questionOption;
		this.correctOption = correctOption;
		this.questionCategoryId = questionCategoryId;
		this.createdByUser = createdByUser;
		this.organizationId = organizationId;
		this.feedbackId = feedbackId;
		this.isMultipleChoise = isMutiChoise;
	}

	public Question(String question, List<String> questionOption, String correctOption, Long questionCategoryId,
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

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
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

	public List<Long> getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(List<Long> feedbackId) {
		this.feedbackId = feedbackId;
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
				+ ", feedbackId=" + feedbackId + "]";
	}

	
}
