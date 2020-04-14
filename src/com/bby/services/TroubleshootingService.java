package com.bby.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.bby.Dao.TrobleshootingDao;


public class TroubleshootingService {
	
	TrobleshootingDao dao;
	
	
	public HashMap getTopTroubleshootingForModel(int modelId){
		
		return dao.getTopTroubleshootingForModel(modelId);
		
	}
	
	public ArrayList getComponentTroubleshooting(int componentId){
		return dao.getComponentTroubleshooting(componentId);
	}
	
	
	
}