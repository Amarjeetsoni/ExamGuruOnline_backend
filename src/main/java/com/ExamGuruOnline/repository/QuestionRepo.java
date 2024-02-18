package com.ExamGuruOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamGuruOnline.entity.Question;

public interface QuestionRepo extends JpaRepository<Question, Long>{

}
