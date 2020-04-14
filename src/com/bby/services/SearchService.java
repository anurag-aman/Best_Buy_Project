package com.bby.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.omg.PortableServer.ServantActivatorHelper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;

import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.bby.Dao.SearchDAO;
import com.bby.beans.SearchNLPBean;
import com.bby.beans.SparePartDtlBean;

import sun.misc.IOUtils;


public class SearchService {
	private SearchDAO dao;
	private String url;
	
	
	   
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SearchDAO getDao() {
		return dao;
	}

	public void setDao(SearchDAO dao) {
		this.dao = dao;
	}
	

	public SearchNLPBean getSearchResult(String searchPattern){
		SearchNLPBean bean = null;
		try{
				RestTemplate restTemplate = new RestTemplate();
				 bean = restTemplate.execute(this.url, HttpMethod.POST, getRequestCallBack(searchPattern), new ResponseExtractor<SearchNLPBean>() {
		
					@Override
					public SearchNLPBean extractData(ClientHttpResponse response) throws IOException {
						// TODO Auto-generated method stub
						BufferedReader br = new BufferedReader(new InputStreamReader(response.getBody()));
					    StringBuilder sb = new StringBuilder();
					    SearchNLPBean bean =new SearchNLPBean();
					    String line;
					    try {
					    	while ((line = br.readLine()) != null) {
					            sb.append(line);
					        }
					    	JSONObject json = new JSONObject(sb.toString());
					    	bean.setAccuracyScore(convertJSONArrToArrayList(json.getJSONArray("accuracy_score")));
					    	bean.setIssueShortDesc(convertJSONArrToArrayList(json.getJSONArray("issue_description")));
					    	bean.setResolution(convertJSONArrToArrayList(json.getJSONArray("resolution")));
					    	bean.setSparePartId(convertJSONArrToArrayList(json.getJSONArray("spare_part_id")));
					    	
					    }catch(Exception e){
					    	System.out.println(e.getMessage());
					    }
					    finally {
					        br.close();
					    }
						return bean;
					}
				});
				
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return bean;
				
	}
	
	private RequestCallback getRequestCallBack(String searchPattern) {
		// TODO Auto-generated method stub
		return new RequestCallback() {
			
			@Override
			public void doWithRequest(ClientHttpRequest request) throws IOException {
				
				HttpHeaders headers = request.getHeaders();
				headers.setContentType(MediaType.parseMediaType("application/json"));
				String data = "{\"question\" : \""+searchPattern+"\"} ";
				request.getBody().write(data.getBytes());
				
			}
		};
	}

	private ArrayList convertJSONArrToArrayList(JSONArray ja){
		ArrayList list = new ArrayList();
		try{
	    int size = ja.length();
	    for (int i = 0; i < size; i++) {
	        list.add(ja.get(i));
	    }
		}catch(JSONException e )
		{
			return null;
		}
		return list;
	}
	
	public SparePartDtlBean getPartDetailbyId(Double partId)
	{
		return dao.getPartDetailbyId(partId.intValue());
	}
	
}