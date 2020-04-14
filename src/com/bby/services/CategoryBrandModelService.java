package com.bby.services;

import java.util.ArrayList;

import com.bby.Dao.CategoryBrandModelDAO;
import com.bby.beans.BrandBean;
import com.bby.beans.CategoryMasterBean;
import com.bby.beans.ModelBean;

public class CategoryBrandModelService {
	
	private CategoryBrandModelDAO dao;
	
	public ArrayList<CategoryMasterBean> getTopCategoryList(){
		return dao.getTopCategoryList();
	}
	
	public ArrayList<CategoryMasterBean> getSubCategoryList(int catId){
		return dao.getSubCategoryList(catId);
	}
	
	public ArrayList<BrandBean> getBrandList(int catId){
		return dao.getBrandList(catId);
	}
	
	public ArrayList<ModelBean> getModelList(int brandId){
		return dao.getModelList(brandId);
	}

	public CategoryBrandModelDAO getDao() {
		return dao;
	}

	public void setDao(CategoryBrandModelDAO dao) {
		this.dao = dao;
	}

	public ArrayList getTopTSForCategory(Integer catId) {
		return dao.getTopTSForCategory(catId);
	}

}
