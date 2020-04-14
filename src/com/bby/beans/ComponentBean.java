package com.bby.beans;

import java.util.ArrayList;

public class ComponentBean {

	private int componentId;
	private int modelId;
	private String name;
	private String desc;
	private String image;
	private String imgLarge;
	private ArrayList<SparePartDtlBean> parts;
	
	
	
	
	
	public String getImgLarge() {
		return imgLarge;
	}
	public void setImgLarge(String imgLarge) {
		this.imgLarge = imgLarge;
	}
	public int getComponentId() {
		return componentId;
	}
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public ArrayList<SparePartDtlBean> getParts() {
		return parts;
	}
	public void setParts(ArrayList<SparePartDtlBean> parts) {
		this.parts = parts;
	}
	
	
    
    
}
