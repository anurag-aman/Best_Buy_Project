package com.bby.beans;

import java.awt.Image;

public class SparePartDtlBean {
	
	private int partId;
	private String partName;
	private String partImgMini;
	private int cId;
	private String inventoryStatus;
	private String location;
	
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartImgMini() {
		return partImgMini;
	}
	public void setPartImgMini(String partImgMini) {
		this.partImgMini = partImgMini;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getInventoryStatus() {
		return inventoryStatus;
	}
	public void setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}


}
