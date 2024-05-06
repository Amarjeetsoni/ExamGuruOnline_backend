package com.ExamGuruOnline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExamGuruOnline.entity.Test;

@Repository
public interface TestRepo extends JpaRepository<Test, Long>{

	public List<Test> findByOrganizationId(Long id);
	public List<Test> findByUserId(String userId);
}
