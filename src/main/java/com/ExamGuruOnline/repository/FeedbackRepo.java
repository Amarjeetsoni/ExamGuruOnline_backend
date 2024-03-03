package com.ExamGuruOnline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamGuruOnline.entity.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Long> {
	public List<Feedback> findByUserId(String userId);
	public List<Feedback> findByQuesTestId(Long quesTestId);
	
	
}
