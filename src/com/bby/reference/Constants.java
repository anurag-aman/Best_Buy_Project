package com.bby.reference;

public class Constants {
	
	//sqls 
	
	public static final String SQL_GET_TOP_CATEGORIES = "select id,name from category";
	public static final String SQL_GET_SUB_CATEGORIES = "select category_id,description from category_master where category_id =";
	public static final String SQL_GET_MODELLIST = "select model_id,model_name from model where brand_id =";
	public static final String SQL_GET_BRANDLIST = "select id,brand_name from brand where category_id =";
	public static final String SQL_GET_TOP_TS = "select ts_id,ts_short_desc,ts_steps from trouble_shooting where component_id =";
	public static final String SQL_GET_COMPONENT_LIST = "select component_id , name , image from component where model_id =";
	public static final String SQL_GET_PARTS = "select id, part_name,img_mini,inventory_status,location from part_detail where component_id =";
	public static final String SQL_GET_COMPONENT_DTL = "select component_id, name ,image,image_large from component where component_id = ";
	public static final String SQL_GET_TOP_TS_BYDESC = "select ts_id,ts_short_desc,ts_steps from trouble_shooting where ts_short_desc like '%";
	public static final String SQL_GET_GUIDES = "select id, short_desc,html_link from guides where component_id =";
	public static final String SQL_GET_TOP_TS_CATEGORY = "select ts_id,ts_short_Desc,component_id from trouble_shooting where "
			+ "component_id in (select component_id from component where model_id in "
			+ "(select model_id from model where brand_id in (SELECT id from brand where category_id = ?))) "
			+ "order by ranking";
	public static final String SQL_GET_TS = "select ts_id,ts_short_desc,ts_steps from trouble_shooting where ts_id =";
	public static final String SQL_INSERT_TS = "insert into trouble_shooting (ts_id,ts_short_desc,ts_steps,component_id) values(?,?,?,?) ";
	public static final String SQL_GET_MAX_TSID = "select max(ts_id) from trouble_shooting";
	public static final String SQL_GET_PART_BYID = "select id, part_name,img_mini,inventory_status,location from part_detail where id =";
	

}
