package com.bby.services;

import java.util.ArrayList;

import com.bby.Dao.ComponentPartDAO;
import com.bby.beans.ComponentBean;
import com.bby.beans.SparePartDtlBean;

public class ComponentPartService {
	
	private ComponentPartDAO dao;
	
   
	public ComponentPartDAO getDao() {
		return dao;
	}

	public void setDao(ComponentPartDAO dao) {
		this.dao = dao;
	}
	
	
	public ArrayList getTopTroubleshootingForComponent(int componentId){
		return dao.getTopTroubleshootingForComponent(componentId);
	}
	
	public ArrayList<ComponentBean> getComponentList(int modelID)
	{
		return dao.getComponentList(modelID);
	}
	
	public ArrayList<SparePartDtlBean> getParts(int componentId)
	{
		return dao.getParts(componentId);
	}
	
	public ComponentBean getComponentDetails(int componentId)
	{
		return dao.getComponentDetails(componentId);
	}

	public String getServiceManual(Integer modelId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList getTopTroubleshootingForProduct(Integer modelId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList getHowToGuideComponent(int componentId){
		return dao.getHowToGuideComponent(componentId);
	}

	public Object getTopTroubleshooting(Integer tsId) {
		// TODO Auto-g.enerated method stub
		return dao.getTopTroubleshooting(tsId);
	}
}
