package com.bby.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bby.services.CreateArticleService;

@Controller
@RequestMapping("/")
public class AddNewArticleController {
	
	private CreateArticleService service;
	
	public CreateArticleService getService() {
		return service;
	}

	public void setService(CreateArticleService service) {
		this.service = service;
	}

	@RequestMapping(value = "/saveArticle", method = RequestMethod.GET)
	public ModelAndView saveArticle(@RequestParam("troubleshooting") String tsdesc , 
			@RequestParam("component") int component , @RequestParam("steps") String tssteps){
		ModelAndView v = new ModelAndView("createNewArticlePage");
		boolean saved = service.saveNewArticle(component , tsdesc,tssteps);
		if(saved){
			v.addObject("message", "Article saved Successfully"); 
			v.addObject("disableSave", true);
		}
		
		return v;
		
	}

}
