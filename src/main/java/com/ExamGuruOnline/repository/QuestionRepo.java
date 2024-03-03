package com.ExamGuruOnline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExamGuruOnline.entity.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{
	public List<Question> findByCreatedByUser(String createdByUser);
	public List<Question> findByOrganizationId(Long organizationId);
	
	
}
