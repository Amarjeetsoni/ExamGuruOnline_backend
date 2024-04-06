package com.ExamGuruOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ExamGuruOnline.serviceInterface.CategoryServiceInterface;

@RestController
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryServiceInterface catIntf;
	
	@GetMapping("/addCat")
	public ResponseEntity<Object> addCategoryByName(@RequestParam String catDesc){
		try {
			return new ResponseEntity<Object>(catIntf.addNewCategory(catDesc), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getCatById")
	public ResponseEntity<Object> getCategoryById(@RequestParam Long id){
		try {
			return new ResponseEntity<Object>(catIntf.getCategorybyId(id), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getCatAllCat")
	public ResponseEntity<Object> getAllCategory(){
		try {
			return new ResponseEntity<Object>(catIntf.getAllCategory(), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteCatById")
	public ResponseEntity<Object> deleteCategoryById(@RequestParam Long id){
		try {
			return new ResponseEntity<Object>(catIntf.deleteCategoryById(id), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/updateCatById")
	public ResponseEntity<Object> updateCatById(@RequestParam Long id, @RequestParam String desc){
		try {
			return new ResponseEntity<Object>(catIntf.updateCategoryById(id, desc), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
