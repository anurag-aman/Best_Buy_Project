package com.bby.beans;

import java.util.ArrayList;

public class GuideBean {
	
	int guideId;
	ArrayList steps;
	String desc;
	String link;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getGuideId() {
		return guideId;
	}
	public void setGuideId(int guideId) {
		this.guideId = guideId;
	}
	public ArrayList getSteps() {
		return steps;
	}
	public void setSteps(ArrayList steps) {
		this.steps = steps;
	}
	
	
	

}
