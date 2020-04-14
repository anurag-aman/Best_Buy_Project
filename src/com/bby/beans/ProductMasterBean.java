package com.bby.beans;

import java.awt.Image;

public class ProductMasterBean {
	private int productId;
	private String name;
	private String desc;
	private Image image;
	private int brandId;
	private int modelId;

public ProductMasterBean(int productId,String name,String desc, Image image,int brandId, int modelId){
	this.productId=productId;
	this.name=name;
	this.desc=desc;
	this.image=image;
	this.brandId=brandId;
	this.modelId=modelId;
}

public int getProductId() {
	return productId;
}

public String getName() {
	return name;
}

public String getDesc() {
	return desc;
}

public Image getImage() {
	return image;
}

public int getBrandId() {
	return brandId;
}

public int getModelId() {
	return modelId;
}


}
