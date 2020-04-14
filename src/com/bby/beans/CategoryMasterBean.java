package com.bby.beans;

import java.util.ArrayList;

public class CategoryMasterBean {
	private int categoryId;
	private String categoryName;
	private String categoryDesc;
	private ArrayList subCategories ;
	private ArrayList brands;
	private boolean hasSubCategories;
	
	public CategoryMasterBean(){}
	
	
	public ArrayList getSubCategories() {
		return subCategories;
	}


	public void setSubCategories(ArrayList subCategories) {
		this.subCategories = subCategories;
	}


	public ArrayList getBrands() {
		return brands;
	}


	public void setBrands(ArrayList brands) {
		this.brands = brands;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public String getCategoryDesc() {
		return categoryDesc;
	}


	public boolean hasSubCategories() {
		return hasSubCategories;
	}


	public void setHasSubCategories(boolean hasSubCategories) {
		this.hasSubCategories = hasSubCategories;
	}
    

}
