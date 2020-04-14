package com.bby.mapper;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bby.beans.CategoryMasterBean;

public class CategoryExtractor implements ResultSetExtractor{
	
	 public CategoryMasterBean extractData(ResultSet resultSet) throws SQLException,  
	   DataAccessException {  
		 CategoryMasterBean cm = new CategoryMasterBean();
		 cm.setCategoryId(resultSet.getInt(1));
		 cm.setCategoryName(resultSet.getString(2));
		 return cm;
	 }

}
