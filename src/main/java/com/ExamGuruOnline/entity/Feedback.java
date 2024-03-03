package com.ExamGuruOnline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@Column(name = "feedbackId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long feedbackId;
	private String feedbackStr;
	private String userId;
	private Long quesTestId;
	
	public Feedback(Long feedbackId, String feedbackStr, String userId, Long quesTestId) {
		super();
		this.userId = userId;
		this.feedbackId = feedbackId;
		this.feedbackStr = feedbackStr;
		this.quesTestId = quesTestId;
	}
	public Feedback(String feedbackStr, String userId, Long quesTestId) {
		super();
		this.userId = userId;
		this.feedbackStr = feedbackStr;
		this.quesTestId =  quesTestId;
	}
	public Feedback() {
		super();
	}
	public Long getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getFeedbackStr() {
		return feedbackStr;
	}
	public void setFeedbackStr(String feedbackStr) {
		this.feedbackStr = feedbackStr;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Long getQuesTestId() {
		return quesTestId;
	}
	public void setQuesTestId(Long quesTestId) {
		this.quesTestId = quesTestId;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedbackStr=" + feedbackStr + ", userId=" + userId
				+ ", quesTestId=" + quesTestId + "]";
	}
}
