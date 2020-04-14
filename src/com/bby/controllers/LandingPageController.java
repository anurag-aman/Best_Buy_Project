package com.bby.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bby.beans.BrandBean;
import com.bby.beans.CategoryMasterBean;
import com.bby.beans.ModelBean;
import com.bby.services.CategoryBrandModelService;

@Controller
public class LandingPageController {
	
	private CategoryBrandModelService service;

	public CategoryBrandModelService getService() {
		return service;
	}


	public void setService(CategoryBrandModelService service) {
		this.service = service;
	}


	@RequestMapping(value = "/landingPage", method = RequestMethod.GET)
	public ModelAndView loadLandingPage() {
		 
		ArrayList<CategoryMasterBean> catList = service.getTopCategoryList();
		return new ModelAndView("categoryLandingPage", "catList", catList);
	}
	
	@RequestMapping(value = "/createArticlePage", method = RequestMethod.GET)
	public ModelAndView createArticlePage() {
		 
		ArrayList<CategoryMasterBean> catList = service.getTopCategoryList();
		return new ModelAndView("createNewArticlePage", "catList", catList);
	}
	
	@RequestMapping(value = "/getBrands", method = RequestMethod.POST)
	public ModelAndView getBrands(@RequestParam("catId") Integer catId) {
		 
		ArrayList<BrandBean> brandList = service.getBrandList(catId);
		return new ModelAndView("brandList", "brandList", brandList);
	}
	
	
	

	
	private ArrayList<CategoryMasterBean> getSubcategories( int catId) {
		return service.getSubCategoryList(catId);
		
		 
	}
	
	@RequestMapping(value = "/selectBrandModel", method = RequestMethod.GET)
	public ModelAndView getBrandList(@RequestParam("catId") Integer catId) {
		
		ArrayList<CategoryMasterBean> catList = null;//getSubcategories(catId);
		
		if(catList != null && !catList.isEmpty()){
			return new ModelAndView("categoryLandingPage", "catList", catList);
		}
		else{	
			ArrayList<BrandBean> brandList =  service.getBrandList(catId);
			//getTopTSforCategory();
			ModelAndView v = new ModelAndView("productPage", "brandList", brandList);
			ArrayList topTs = (ArrayList) service.getTopTSForCategory(catId);
			v.addObject("selectModel", true);
			v.addObject("showComponent",false);
			v.addObject("topTS" ,topTs);
			return v;
		}
		 
	}
	
	@RequestMapping(value = "/getModels", method = RequestMethod.POST)
	public ModelAndView getModelList(@RequestParam("brandId") Integer brandId) {
			
			ArrayList<ModelBean> modelList =  service.getModelList(brandId);
			ModelAndView v = new ModelAndView("modelList", "modelList", modelList);
			return v;
		}		 
	
	
	
}
