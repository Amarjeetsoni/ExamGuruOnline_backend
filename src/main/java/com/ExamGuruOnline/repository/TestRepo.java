package com.ExamGuruOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamGuruOnline.entity.Test;

public interface TestRepo extends JpaRepository<Test, Long>{

}
