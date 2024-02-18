package com.ExamGuruOnline.serviceInterface;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ExamGuruOnline.customeException.TransactionError;
import com.ExamGuruOnline.entity.Category;

@Component
public interface CategoryServiceInterface {
	
	public boolean addNewCategory(String categoryDesc) throws TransactionError;
	public Category getCategorybyId(Long id) throws Exception;
	public List<Category> getAllCategory() throws Exception;
	public boolean deleteCategoryById(Long id);
	public boolean updateCategoryById(Long id, String desc) throws Exception;
	
}
