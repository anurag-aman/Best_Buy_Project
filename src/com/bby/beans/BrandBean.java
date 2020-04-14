package com.bby.beans;

import java.util.ArrayList;

public class BrandBean {
	
	private int brandId;
	private  String brandName;
	private int categoryId;
	private ArrayList models;
	
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public ArrayList getModels() {
		return models;
	}
	public void setModels(ArrayList models) {
		this.models = models;
	}
	

}
