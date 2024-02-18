package com.ExamGuruOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamGuruOnline.entity.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Long> {

}
