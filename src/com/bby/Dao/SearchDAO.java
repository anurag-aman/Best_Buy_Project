package com.bby.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bby.beans.SparePartDtlBean;
import com.bby.beans.TroubleShootingBean;
import com.bby.reference.Constants;

public class SearchDAO {
	
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
	
	public ArrayList<TroubleShootingBean> getSearchResult(String searchPattern){
		
		/*ArrayList<TroubleShootingBean> a = new ArrayList<>();
		
		TroubleShootingBean b = new TroubleShootingBean();
		
		b =new TroubleShootingBean();
		b.setTblShootingId(1);
		b.setDescription("Cellphone battery is dead");
		String steps ="Remove the battery and charge it in the jump starter@If the problem is not solved then change the Battery and Check.@Problem still persisting? check Voltage of the Battery Connector using a Multimeter. Voltage must be 1.5 to 3.7 DC Volts.";
		String[] stepsArr = steps.split("@");
		b.setSteps(stepsArr);
		a.add(b);
		
		return a;*/
		
		
		ArrayList<TroubleShootingBean> tsList = null;
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds);  
			  tsList = (ArrayList<TroubleShootingBean>) jdbcTemplate.query
					                        (Constants.SQL_GET_TOP_TS_BYDESC+searchPattern+"%'", new RowMapper(){
				                        	
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
	
	public SparePartDtlBean getPartDetailbyId(int partId)
	{	
		
		SparePartDtlBean partList = null;
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds);  
			  partList = (SparePartDtlBean) jdbcTemplate.queryForObject
					                        (Constants.SQL_GET_PART_BYID +partId , new RowMapper(){
				                        	
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
	}

}
