package com.bby.services;

import com.bby.Dao.CreateArticleDAO;

public class CreateArticleService {
	
	CreateArticleDAO dao;


	public CreateArticleDAO getDao() {
		return dao;
	}

	public void setDao(CreateArticleDAO dao) {
		this.dao = dao;
	}

	public boolean saveNewArticle(int component, String tsdesc, String tssteps) {
		 try{
	        	dao.saveNewArticle(component,tssteps,tsdesc);
	        }
			catch(Exception e){
				return false;
			}    
			return true;
	}
	
	

}
