package com.ExamGuruOnline.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long testId;
	private Long userId;
	private String testName;
	private Long testCategoryId;
	private Long organizationId;
	private double totalMarks;
	private Long testDuration;
	private boolean isActive;
	private boolean isLocked;
	@ElementCollection(targetClass = Long.class, fetch = FetchType.LAZY)
	private List<Long> questionId;
	@ElementCollection(targetClass = Long.class, fetch = FetchType.LAZY)
	private List<Long> feedbackId;
	
	public Test(Long testId, Long userId, String testName, Long testCategoryId, Long organizationId, double totalMarks,
			Long testDuration, boolean isActive, boolean isLocked, List<Long> questionId, List<Long> feedbackId) {
		super();
		this.testId = testId;
		this.userId = userId;
		this.testName = testName;
		this.testCategoryId = testCategoryId;
		this.organizationId = organizationId;
		this.totalMarks = totalMarks;
		this.testDuration = testDuration;
		this.isActive = isActive;
		this.isLocked = isLocked;
		this.questionId = questionId;
		this.feedbackId = feedbackId;
	}

	public Test() {
		super();
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Long getTestCategoryId() {
		return testCategoryId;
	}

	public void setTestCategoryId(Long testCategoryId) {
		this.testCategoryId = testCategoryId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public double getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Long getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(Long testDuration) {
		this.testDuration = testDuration;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public List<Long> getQuestionId() {
		return questionId;
	}

	public void setQuestionId(List<Long> questionId) {
		this.questionId = questionId;
	}

	public List<Long> getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(List<Long> feedbackId) {
		this.feedbackId = feedbackId;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", userId=" + userId + ", testName=" + testName + ", testCategoryId="
				+ testCategoryId + ", organizationId=" + organizationId + ", totalMarks=" + totalMarks
				+ ", testDuration=" + testDuration + ", isActive=" + isActive + ", isLocked=" + isLocked
				+ ", questionId=" + questionId + ", feedbackId=" + feedbackId + "]";
	}
	
	
}
