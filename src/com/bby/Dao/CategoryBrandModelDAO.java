package com.bby.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;   
import com.bby.beans.BrandBean;
import com.bby.beans.CategoryMasterBean;
import com.bby.beans.ModelBean;
import com.bby.beans.TroubleShootingBean;
import com.bby.mapper.*;
import com.bby.reference.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;  


  

public class CategoryBrandModelDAO {
	
	@Autowired  
	DataSource ds;
	
	private JdbcTemplate jdbcTemplate;  
	  


	public DataSource getDs() {
		return ds;
	}


	public void setDs(DataSource ds) {
		this.ds = ds;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public ArrayList<CategoryMasterBean> getTopCategoryList(){
		 ArrayList<CategoryMasterBean> categoryList = null;
		try{

		  this.jdbcTemplate = new JdbcTemplate(ds);  
		   categoryList = (ArrayList<CategoryMasterBean>) jdbcTemplate.query
				                        (Constants.SQL_GET_TOP_CATEGORIES, new CategoryRowMapper()); 
		}
		catch(Exception e)
		{
			System.out.println("error while fetching top categotry  data" + e.getMessage());
		}
		  return categoryList;

		/*ArrayList<CategoryMasterBean> catList = new ArrayList<CategoryMasterBean>();
		CategoryMasterBean catBean;
		
			catBean = new CategoryMasterBean();
			catBean.setCategoryId(1);
			catBean.setCategoryName("Laptop & Tablet");
			catList.add(catBean);
			
			catBean = new CategoryMasterBean();
			catBean.setCategoryId(2);
			catBean.setCategoryName("Cell phones");
			catList.add(catBean);
			
			catBean = new CategoryMasterBean();
			catBean.setCategoryId(3);
			catBean.setCategoryName("Camera");
			catList.add(catBean);
			
			catBean = new CategoryMasterBean();
			catBean.setCategoryId(4);
			catBean.setCategoryName("Appliances");
			catList.add(catBean);
			
			catBean = new CategoryMasterBean();
			catBean.setCategoryId(5);
			catBean.setCategoryName("Wearable Technologies");
			catList.add(catBean);
			
			catBean = new CategoryMasterBean();
			catBean.setCategoryId(6);
			catBean.setCategoryName("TV & Home Theater");
			catList.add(catBean);

		return catList;*/
	}
	
	
	public ArrayList<CategoryMasterBean> getSubCategoryList(int catId){
	    ArrayList<CategoryMasterBean> subCategoryList = null;
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds);  
			  subCategoryList = (ArrayList<CategoryMasterBean>) jdbcTemplate.query
					                        (Constants.SQL_GET_SUB_CATEGORIES, new CategoryRowMapper()); 
			}
			catch(Exception e)
			{
				System.out.println("error while fetching sub categotry  data" + e.getMessage());
			}
			return subCategoryList; 
	}
	
	public ArrayList<BrandBean> getBrandList(int catId){
		
		ArrayList<BrandBean> brandList = null;
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds);  
			  brandList = (ArrayList<BrandBean>) jdbcTemplate.query
					                        (Constants.SQL_GET_BRANDLIST+ catId, new RowMapper(){
				                        	
				                        	 @Override  
				                        	    public BrandBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
				                        		 	BrandBean b=new BrandBean();  
				                        	        b.setBrandId(rs.getInt(1));  
				                        	        b.setBrandName(rs.getString(2));  
				                        	        return b;  
				                        	    }  
					                        	
					                        }); 
			}
			catch(Exception e)
			{
				System.out.println("error while fetching brand  data" + e.getMessage());
			}
		
		return brandList;
		
		/*ArrayList<BrandBean> brandList = new ArrayList<BrandBean>();
		BrandBean brandBean;
		
			brandBean = new BrandBean();
			brandBean.setBrandId(1);
			brandBean.setBrandName("Samsung");
			brandList.add(brandBean);
			
			brandBean = new BrandBean();
			brandBean.setBrandId(2);
			brandBean.setBrandName("Apple");
			brandList.add(brandBean);
			
			brandBean = new BrandBean();
			brandBean.setBrandId(3);
			brandBean.setBrandName("Sony");
			brandList.add(brandBean);
			
			brandBean = new BrandBean();
			brandBean.setBrandId(4);
			brandBean.setBrandName("OnePlus");
			brandList.add(brandBean);
		
		return brandList;*/
	}
	
	public ArrayList<ModelBean> getModelList(int brandId){
		
		
		ArrayList<ModelBean> modelList = null;
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds);  
			  modelList = (ArrayList<ModelBean>) jdbcTemplate.query
					                        (Constants.SQL_GET_MODELLIST + brandId, new RowMapper(){
				                        	
				                        	 @Override  
				                        	    public ModelBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
				                        		 	ModelBean b=new ModelBean();  
				                        	        b.setName(rs.getString(2));  
				                        	        b.setModelId(rs.getInt(1));
				                        	        return b;  
				                        	    }  
					                        	
					                        }); 
			}
			catch(Exception e)
			{
				System.out.println("error while fetching model  data" + e.getMessage());
			}
		
		return modelList;
		
		/*ArrayList<ModelBean> mBeanList = new ArrayList<>();
		ModelBean mBean;
		
		if(brandId ==1)
		{
			mBean = new ModelBean();
			mBean.setBrandId(brandId);
			mBean.setModelId(1);
			mBean.setName("Galaxy S7");
			mBeanList.add(mBean);
			
			mBean = new ModelBean();
			mBean.setBrandId(brandId);
			mBean.setModelId(2);
			mBean.setName("Galaxy S6");
			mBeanList.add(mBean);
			
		}
		else if(brandId ==2)
		{
			mBean = new ModelBean();
			mBean.setBrandId(brandId);
			mBean.setModelId(1);
			mBean.setName("Iphone 7");
			mBeanList.add(mBean);
			
			mBean = new ModelBean();
			mBean.setBrandId(brandId);
			mBean.setModelId(2);
			mBean.setName("Iphone 6s plus");
			mBeanList.add(mBean);
			
		}
		
		return mBeanList;*/
	}

	public ArrayList getTopTSForCategory(int catId) {
		ArrayList<TroubleShootingBean> tsList = null;
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds);  
			  
			  
			  tsList = (ArrayList<TroubleShootingBean>) jdbcTemplate.query
					                        (Constants.SQL_GET_TOP_TS_CATEGORY, new RowMapper(){
				                        	
				                        	 @Override  
				                        	    public TroubleShootingBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
				                        		 TroubleShootingBean b=new TroubleShootingBean();  
				                        	        b.setDescription(rs.getString(2));  
				                        	        b.setTblShootingId(rs.getInt(1));
				                        	        b.setCategoryId(rs.getInt(3));
				                        	        return b;
				                        	    }  
					                        	
					                        } , new Object[]{catId}); 
			}
			catch(Exception e)
			{
				System.out.println("error while fetching ts data for category" + e.getMessage());
			}
		
		return tsList;
	}

}
 
