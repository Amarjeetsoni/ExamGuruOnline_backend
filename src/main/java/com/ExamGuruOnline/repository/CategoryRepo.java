package com.ExamGuruOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExamGuruOnline.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{

}
