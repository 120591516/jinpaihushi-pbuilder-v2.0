package com.afocus.pbuilder.oracle.model;

import com.afocus.pbuilder.common.model.BaseModel;

/**
 * USER_COL_COMMENTS Comments on columns of user's tables and views
 * 
 * @author liuwu
 * @date 2015-09-11
 * @company afocus
 * @version 5.0
 */
@SuppressWarnings("serial")
public class UserColComments extends BaseModel{
	

    /** @column Object name */
	private String tableName;

    /** @column Column name */
	private String columnName;

    /** @column Comment on the column */
	private String comments;

	public UserColComments(){}


	/**
	 * 获取Object name
	 */
	public String getTableName() {
    	return tableName;
    }
  	
	/**
	 * 设置Object name
	 */
	public void setTableName(String tableName) {
    	this.tableName = tableName;
    }

	/**
	 * 获取Column name
	 */
	public String getColumnName() {
    	return columnName;
    }
  	
	/**
	 * 设置Column name
	 */
	public void setColumnName(String columnName) {
    	this.columnName = columnName;
    }

	/**
	 * 获取Comment on the column
	 */
	public String getComments() {
    	return comments;
    }
  	
	/**
	 * 设置Comment on the column
	 */
	public void setComments(String comments) {
    	this.comments = comments;
    }

	@Override
    public String toString() {
		return new StringBuilder().append("UserColComments{").
			append("tableName=").append(tableName).
			append(",columnName=").append(columnName).
			append(",comments=").append(comments).
			append('}').toString();
    }
    
    /**
	 * 比较字段：
	 * tableName, columnName, comments
	 */
	public boolean equals(Object o){
		if(!(o instanceof UserColComments)) return false;
		UserColComments v = (UserColComments)o;
		return (tableName==null && v.tableName==null || tableName != null && tableName.equals(v.tableName))
			&& (columnName==null && v.columnName==null || columnName != null && columnName.equals(v.columnName))
			&& (comments==null && v.comments==null || comments != null && comments.equals(v.comments))
		;
	}
	
	/**
	 * 散列字段：
	 * tableName, columnName, comments
	 */
	public int hashCode(){
		int h = 1;
		h = 31 * h + (tableName==null ? 0 : tableName.hashCode());
		h = 31 * h + (columnName==null ? 0 : columnName.hashCode());
		h = 31 * h + (comments==null ? 0 : comments.hashCode());
		return h;
	}
	
	/**
	 * 复制对象,复制了以下字段
	 * tableName, columnName, comments
	 */
	public UserColComments copy(){
		UserColComments m = new UserColComments();
     	m.tableName = tableName;
     	m.columnName = columnName;
     	m.comments = comments;
		return m;
	}
}
