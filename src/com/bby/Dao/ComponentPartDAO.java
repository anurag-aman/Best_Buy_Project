package com.bby.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bby.beans.BrandBean;
import com.bby.beans.ComponentBean;
import com.bby.beans.GuideBean;
import com.bby.beans.SparePartDtlBean;
import com.bby.beans.TroubleShootingBean;
import com.bby.reference.Constants;

public class ComponentPartDAO {
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
   
	public ArrayList<TroubleShootingBean> getTopTroubleshootingForComponent(int componentId){
		
		//list of trouble shooting  - trouble shooting id ,description , steps
		
		ArrayList<TroubleShootingBean> tsList = null;
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds);  
			  tsList = (ArrayList<TroubleShootingBean>) jdbcTemplate.query
					                        (Constants.SQL_GET_TOP_TS+componentId, new RowMapper(){
				                        	
				                        	 @Override  
				                        	    public TroubleShootingBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
				                        		 	TroubleShootingBean b=new TroubleShootingBean();  
				                        		 	String steps = rs.getString(3);
				                        		 	String[] stepsArr = steps.split("@");
				                        	        b.setTblShootingId(rs.getInt(1));  
				                        	        b.setDescription(rs.getString(2));
				                        	        b.setSteps(stepsArr);  
				                        	        return b;  
				                        	    }  
					                        	
					                        }); 
			}
			catch(Exception e)
			{
				System.out.println("error while fetching ts  data" + e.getMessage());
			}
		
		return tsList;
		
	}
	
	public ArrayList<ComponentBean> getComponentList(int modelID)
	{
		
		ArrayList<ComponentBean> componentList = null;
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds);  
			  componentList = (ArrayList<ComponentBean>) jdbcTemplate.query
					                        (Constants.SQL_GET_COMPONENT_LIST + modelID, new RowMapper(){
				                        	
				                        	 @Override  
				                        	    public ComponentBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
				                        		 	ComponentBean b=new ComponentBean();  
				                        	        b.setComponentId(rs.getInt(1));  
				                        	        b.setName(rs.getString(2)); 
				                        	        b.setImage(rs.getString(3));
				                        	        return b;  
				                        	    }  
					                        	
					                        }); 
			}
			catch(Exception e)
			{
				System.out.println("error while fetching component  data" + e.getMessage());
			}
		
		return componentList;
		
		
	}
	
	public ArrayList<SparePartDtlBean> getParts(int componentId)
	{	
		
		ArrayList<SparePartDtlBean> partList = null;
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds);  
			  partList = (ArrayList<SparePartDtlBean>) jdbcTemplate.query
					                        (Constants.SQL_GET_PARTS + componentId, new RowMapper(){
				                        	
				                        	 @Override  
				                        	    public SparePartDtlBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
				                        		 	SparePartDtlBean b=new SparePartDtlBean();  
				                        	        b.setPartId(rs.getInt(1));  
				                        	        b.setPartName(rs.getString(2)); 
				                        	        b.setPartImgMini(rs.getString(3));
				                        	        b.setInventoryStatus(rs.getString(4));
				                        	        b.setLocation(rs.getString(5));
				                        	        return b;  
				                        	    }  
					                        	
					                        }); 
			}
			catch(Exception e)
			{
				System.out.println("error while fetching component  data" + e.getMessage());
			}
		
		return partList;
		
		
		//details like name , inventory status , location , image
		/*ArrayList<SparePartDtlBean> s = new ArrayList<>();
		
		SparePartDtlBean b;
		
		b = new SparePartDtlBean();
		b.setPartId(1);
		b.setPartName("Battery Replacement");
		b.setPartImgMini("images/iphoneImg/iphoneBatRep.mini");
		b.setInventoryStatus("available");
		b.setLocation("In Store");
		s.add(b);
		
		b = new SparePartDtlBean();
		b.setPartId(2);
		b.setPartName("Battery Connector");
		b.setPartImgMini("images/iphoneImg/batConnBracket.jpg");
		b.setInventoryStatus("available");
		b.setLocation("Service Center");
		s.add(b);
		
		
		return s;*/
	}

	public ComponentBean getComponentDetails(int componentId) {
		// TODO Auto-generated method stub
		
		
		ArrayList<ComponentBean> componentDtl = null;
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds);  
			  componentDtl =( ArrayList<ComponentBean>)jdbcTemplate.query
					                        (Constants.SQL_GET_COMPONENT_DTL+ componentId, new RowMapper(){
				                        	
				                        	 @Override  
				                        	    public ComponentBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
				                        		 	ComponentBean b=new ComponentBean();  
				                        	        b.setComponentId(rs.getInt(1));  
				                        	        b.setName(rs.getString(2)); 
				                        	        b.setImage(rs.getString(3));
				                        	        b.setImgLarge(rs.getString(4));
				                        	        return b;  
				                        	    }  
					                        	
					                        }); 
			}
			catch(Exception e)
			{
				System.out.println("error while fetching component  data" + e.getMessage());
			}
		
		return componentDtl== null?null:componentDtl.get(0);
		
		
		
		//detail like component_id, name, image_medium, image_large 
		/*ComponentBean b = new ComponentBean();
		b.setComponentId(1);
		b.setName("Battery");
		b.setImage("images/iphoneImg/battery.standard");
		b.setImgLarge("images/iphoneImg/battery.large");
		
		return b;*/
	}


	public ArrayList getHowToGuideComponent(int componentId) {
		
		ArrayList<GuideBean> guideList = null;
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds);  
			  guideList = (ArrayList<GuideBean>) jdbcTemplate.query
					                        (Constants.SQL_GET_GUIDES + componentId, new RowMapper(){
				                        	
				                        	 @Override  
				                        	    public GuideBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
				                        		 GuideBean b=new GuideBean();  
				                        	        b.setGuideId(rs.getInt(1));  
				                        	        b.setDesc(rs.getString(2)); 
				                        	        b.setLink(rs.getString(3));
				                        	        return b;  
				                        	    }  
					                        	
					                        }); 
			}
			catch(Exception e)
			{
				System.out.println("error while fetching guide  data" + e.getMessage());
			}
		
		return guideList;
	}


	public ArrayList getTopTroubleshooting(Integer tsId) {

		ArrayList<TroubleShootingBean> tsList = null;
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds);  
			  tsList = (ArrayList<TroubleShootingBean>) jdbcTemplate.query
					                        (Constants.SQL_GET_TS+tsId, new RowMapper(){
				                        	
				                        	 @Override  
				                        	    public TroubleShootingBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
				                        		 	TroubleShootingBean b=new TroubleShootingBean();  
				                        		 	String steps = rs.getString(3);
				                        		 	String[] stepsArr = steps.split("@");
				                        	        b.setTblShootingId(rs.getInt(1));  
				                        	        b.setDescription(rs.getString(2));
				                        	        b.setSteps(stepsArr);  
				                        	        return b;  
				                        	    }  
					                        	
					                        }); 
			}
			catch(Exception e)
			{
				System.out.println("error while fetching ts  data" + e.getMessage());
			}
		
		return tsList;
	}
	
	

}
