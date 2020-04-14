package com.bby.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bby.beans.TroubleShootingBean;
import com.bby.reference.Constants;

public class CreateArticleDAO {

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
	public boolean saveNewArticle(int componentId, String steps, String description) {
		this.jdbcTemplate = new JdbcTemplate(ds);
		
		try{

			  this.jdbcTemplate = new JdbcTemplate(ds); 
			  int tsId = jdbcTemplate.queryForInt(Constants.SQL_GET_MAX_TSID);
			  jdbcTemplate.update(Constants.SQL_INSERT_TS, new Object[]{tsId+1,description,steps,componentId});
			 
		}
		catch(Exception e){
			return false;
		}
		
		return true;
	}

}
