package com.afocus.pbuilder.oracle.model;

import com.afocus.pbuilder.common.model.BaseModel;

/**
 * USER_TAB_COMMENTS Comments on the tables and views owned by the user
 * 
 * @author liuwu
 * @date 2015-09-11
 * @company afocus
 * @version 5.0
 */
@SuppressWarnings("serial")
public class UserTabComments extends BaseModel{
	

    /** @column Name of the object */
	private String tableName;

    /** @column Type of the object:  "TABLE" or "VIEW" */
	private String tableType;

    /** @column Comment on the object */
	private String comments;

	public UserTabComments(){}


	/**
	 * 获取Name of the object
	 */
	public String getTableName() {
    	return tableName;
    }
  	
	/**
	 * 设置Name of the object
	 */
	public void setTableName(String tableName) {
    	this.tableName = tableName;
    }

	/**
	 * 获取Type of the object:  "TABLE" or "VIEW"
	 */
	public String getTableType() {
    	return tableType;
    }
  	
	/**
	 * 设置Type of the object:  "TABLE" or "VIEW"
	 */
	public void setTableType(String tableType) {
    	this.tableType = tableType;
    }

	/**
	 * 获取Comment on the object
	 */
	public String getComments() {
    	return comments;
    }
  	
	/**
	 * 设置Comment on the object
	 */
	public void setComments(String comments) {
    	this.comments = comments;
    }

	@Override
    public String toString() {
		return new StringBuilder().append("UserTabComments{").
			append("tableName=").append(tableName).
			append(",tableType=").append(tableType).
			append(",comments=").append(comments).
			append('}').toString();
    }
    
    /**
	 * 比较字段：
	 * tableName, tableType, comments
	 */
	public boolean equals(Object o){
		if(!(o instanceof UserTabComments)) return false;
		UserTabComments v = (UserTabComments)o;
		return (tableName==null && v.tableName==null || tableName != null && tableName.equals(v.tableName))
			&& (tableType==null && v.tableType==null || tableType != null && tableType.equals(v.tableType))
			&& (comments==null && v.comments==null || comments != null && comments.equals(v.comments))
		;
	}
	
	/**
	 * 散列字段：
	 * tableName, tableType, comments
	 */
	public int hashCode(){
		int h = 1;
		h = 31 * h + (tableName==null ? 0 : tableName.hashCode());
		h = 31 * h + (tableType==null ? 0 : tableType.hashCode());
		h = 31 * h + (comments==null ? 0 : comments.hashCode());
		return h;
	}
	
	/**
	 * 复制对象,复制了以下字段
	 * tableName, tableType, comments
	 */
	public UserTabComments copy(){
		UserTabComments m = new UserTabComments();
     	m.tableName = tableName;
     	m.tableType = tableType;
     	m.comments = comments;
		return m;
	}
}
