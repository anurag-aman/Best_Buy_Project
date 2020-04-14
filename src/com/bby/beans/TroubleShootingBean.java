package com.bby.beans;

import java.util.ArrayList;

public class TroubleShootingBean {
	
	private int tblShootingId;
    private String description;
    private String[] steps;
    private int categoryId;
    private double accuracy;
    
	public int getCategoryId() {
		return categoryId;
	}
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getTblShootingId() {
		return tblShootingId;
	}
	public void setTblShootingId(int tblShootingId) {
		this.tblShootingId = tblShootingId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] getSteps() {
		return steps;
	}
    
	public void setSteps(String[] steps) {
		this.steps = steps;
	}
    
    

}
