package com.ExamGuruOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamGuruOnline.customeException.TransactionError;
import com.ExamGuruOnline.entity.Category;
import com.ExamGuruOnline.repository.CategoryRepo;
import com.ExamGuruOnline.serviceInterface.CategoryServiceInterface;

@Service
public class CategoryService implements CategoryServiceInterface{

	@Autowired
	private CategoryRepo catRepo; 
	
	@Override
	public boolean addNewCategory(String categoryDesc) throws TransactionError {
		Category cat = new Category(categoryDesc);
		try {
			catRepo.save(cat);
		}catch(Exception ex) {
			throw new TransactionError("Error While Saving Data! Please try after Some time!!");
		}
		return true;
	}

	@Override
	public Category getCategorybyId(Long id) throws Exception {
		Optional<Category> cat = catRepo.findById(id);
		if(cat.isPresent()) {
			return cat.get();
		}else {
			throw new Exception("No Category found with the provided Id, Please try with the new ID");
		}
	}

	@Override
	public List<Category> getAllCategory() throws Exception {
		List<Category> allCat = catRepo.findAll();
		if(allCat.size() != 0) {
			return allCat;
		}else {
			throw new Exception("No Category added Yet!, Please add new Category and proceed!");
		}
	}

	@Override
	public boolean deleteCategoryById(Long id) {
		catRepo.deleteById(id);
		return true;
	}

	@Override
	public boolean updateCategoryById(Long id, String desc) throws Exception {
		Optional<Category> cat = catRepo.findById(id);
		if(cat.isPresent()) {
			cat.get().setCategoryDesc(desc);
			catRepo.save(cat.get());
			return true;
			
		}else {
			throw new Exception("No category found with the Provided Id.");
		}	
	}

	
}
