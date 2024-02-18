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
	private Long userId;
	
	public Feedback(Long feedbackId, String feedbackStr, Long userId) {
		super();
		this.userId = userId;
		this.feedbackId = feedbackId;
		this.feedbackStr = feedbackStr;
	}
	public Feedback(String feedbackStr, Long userId) {
		super();
		this.userId = userId;
		this.feedbackStr = feedbackStr;
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
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedbackStr=" + feedbackStr + "]";
	}
	
	
}
