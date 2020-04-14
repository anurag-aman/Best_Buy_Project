package com.bby.services;

import com.bby.Dao.GuideDao;
import com.bby.beans.GuideBean;

public class GuideService {

   GuideDao dao;
	
	public GuideBean getGuide(int guideId) {
		return dao.getGuide(guideId);
	}

}
