package com.bby.mapper;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;

import com.bby.beans.CategoryMasterBean;  

public class CategoryRowMapper implements RowMapper<CategoryMasterBean>{
	@Override  
	 public CategoryMasterBean mapRow(ResultSet resultSet, int line) throws SQLException {  
	  CategoryExtractor categoryExtractor = new CategoryExtractor();  
	  return categoryExtractor.extractData(resultSet);  
	 }  

}
