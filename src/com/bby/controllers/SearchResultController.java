package com.bby.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bby.beans.CategoryMasterBean;
import com.bby.beans.SearchNLPBean;
import com.bby.beans.SparePartDtlBean;
import com.bby.beans.TroubleShootingBean;
import com.bby.services.CategoryBrandModelService;
import com.bby.services.SearchService;

@Controller
@RequestMapping("/")
public class SearchResultController {
	
	private SearchService service;

	public SearchService getService() {
		return service;
	}

	public void setService(SearchService service) {
		this.service = service;
	}


	@RequestMapping(value = "/search")
	public ModelAndView search(@RequestParam("searchPattern") String searchPattern ) {
		 
		SearchNLPBean bean = service.getSearchResult(searchPattern);		
		
		ModelAndView v = new ModelAndView("searchResultPage");
		if(bean != null){
			if (bean.getResolution() != null & !bean.getResolution().isEmpty())
				  {
						String resolution = (String) bean.getResolution().get(0);
						if(resolution.equalsIgnoreCase("ERR_NOMATCHFOUND"))
						{
							v.addObject("errMsg", "No results found");
							return v;
						}
						else{							
							v.addObject("tsSteps", populateTSList(bean));
							v.addObject("parts", populatePartDetails(bean));
						}
							
				  }
		}
		else{
			v.addObject("errMsg", "No results found");
			
		}

		return v;
		
		
	}

	private ArrayList<TroubleShootingBean> populateTSList(SearchNLPBean bean) {
		// TODO Auto-generated method stub
		int size = bean.getIssueShortDesc().size();
		ArrayList tsList = new ArrayList<TroubleShootingBean>();
		TroubleShootingBean tBean;
		String steps;
		for(int i=0 ; i< size ; i++)
		{
			tBean = new TroubleShootingBean();
			tBean.setAccuracy((double)bean.getAccuracyScore().get(i));
			tBean.setDescription((String)bean.getIssueShortDesc().get(i));
			steps = (String)bean.getResolution().get(i);
		 	tBean.setSteps(steps.split("\\^"));
		 	tsList.add(tBean);
		}
		
		return tsList;
	}
	
	private ArrayList<SparePartDtlBean> populatePartDetails(SearchNLPBean bean)
	{
		ArrayList<SparePartDtlBean> list = new ArrayList();
		int size = bean.getSparePartId().size();
		SparePartDtlBean partBean ;
		for(int i=0 ; i< size ; i++)
		{
			partBean = service.getPartDetailbyId((Double)bean.getSparePartId().get(i));
			list.add(partBean);
			
		}
		
		return  list;
	}
	
	 
}
