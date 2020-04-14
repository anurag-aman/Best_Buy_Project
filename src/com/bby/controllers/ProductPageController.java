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
import com.bby.beans.ComponentBean;
import com.bby.services.CategoryBrandModelService;
import com.bby.services.ComponentPartService;

@Controller
@RequestMapping("/")
public class ProductPageController {
	
	private ComponentPartService service;

	public ComponentPartService getService() {
		return service;
	}

	public void setService(ComponentPartService service) {
		this.service = service;
	}

	@RequestMapping(value = "/getComponents", method = RequestMethod.POST)
	public ModelAndView componentPage(@RequestParam("modelId") Integer modelId) {
		
		/*ModelAndView v = new ModelAndView("componentListPage", "modelId" , modelId);
		
		if(modelId != null){
			ArrayList<ComponentBean> componentList =  service.getComponentList(modelId);
			v.addObject("list ", componentList);
		}	*/
		return new ModelAndView("componentListPage" ,"list",service.getComponentList(modelId)) ;
	}
	
	@RequestMapping(value = "/getComponentDD", method = RequestMethod.POST)
	public ModelAndView getComponentDD(@RequestParam("modelId") Integer modelId) {
		 
		//ArrayList<BrandBean> brandList = service.getComponentList(modelId);
		return new ModelAndView("componentDDPage" ,"list",service.getComponentList(modelId));
	}
	
	@RequestMapping(value = "/getTSForProduct", method = RequestMethod.POST)
	public ArrayList getTopTroubleshootingForProduct(@RequestParam("modelId") Integer modelId){
		return service.getTopTroubleshootingForProduct(modelId);
	}
	
	@RequestMapping(value = "/getProductServiceManual", method = RequestMethod.POST)
	public String getProductServiceManual(@RequestParam("modelId") Integer modelId){
		return service.getServiceManual(modelId);
	}

	
	@RequestMapping(value = "/getComponentPage", method = RequestMethod.GET)
	public ModelAndView getComponentPage(@RequestParam("componentId") Integer componentId){
		ComponentBean cBean = service.getComponentDetails(componentId);
		ModelAndView v = new ModelAndView("componentPage");
		v.addObject("cBean" , cBean);
		v.addObject("parts", service.getParts(componentId));
		v.addObject("tsSteps", service.getTopTroubleshootingForComponent(componentId));
		v.addObject("howToGuide" ,service.getHowToGuideComponent(componentId));
		return v;
	}
	
	
	@RequestMapping(value = "/getTroubleShootingPage", method = RequestMethod.GET)
	public ModelAndView getTroubleShootingPage(@RequestParam("tsId") Integer tsId,@RequestParam("componentId") Integer componentId ){
		ComponentBean cBean = service.getComponentDetails(componentId);
		ModelAndView v = new ModelAndView("componentPage");
		v.addObject("cBean" , cBean);
		v.addObject("parts", service.getParts(componentId));
		v.addObject("tsSteps", service.getTopTroubleshooting(tsId));
		v.addObject("howToGuide" ,service.getHowToGuideComponent(componentId));
		return v;
	}
	 
}
