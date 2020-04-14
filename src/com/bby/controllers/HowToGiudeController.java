package com.bby.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.bby.services.GuideService;

@Controller
public class HowToGiudeController {
	
	private GuideService service;
	
	public ModelAndView getHowToGuidePage(@PathVariable("guideId") int guideId){
		ModelAndView v = new ModelAndView("howToGuidesPage");
		v.addObject("guide", service.getGuide(guideId));
		return v;
	}

	public GuideService getService() {
		return service;
	}

	public void setService(GuideService service) {
		this.service = service;
	}
	

}
