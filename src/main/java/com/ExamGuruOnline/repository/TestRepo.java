package com.ExamGuruOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExamGuruOnline.entity.Test;

@Repository
public interface TestRepo extends JpaRepository<Test, Long>{

}
