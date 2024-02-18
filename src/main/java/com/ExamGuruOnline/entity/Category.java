package com.ExamGuruOnline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	private String categoryDesc;
	public Category(Long categoryId, String categoryDesc) {
		super();
		this.categoryId = categoryId;
		this.categoryDesc = categoryDesc;
	}
	public Category() {
		super();
	}
	public Category(String catDesc) {
		this.categoryDesc = catDesc;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryDesc=" + categoryDesc + "]";
	}

}
