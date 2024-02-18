package com.ExamGuruOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamGuruOnline.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
