package com.afocus.pbuilder.oracle.model;

import com.afocus.pbuilder.common.model.BaseModel;

/**
 * DBA_COL_COMMENTS Comments on columns of all tables and views
 * 
 * @author liuwu
 * @date 2015-09-11
 * @company afocus
 * @version 5.0
 */
@SuppressWarnings("serial")
public class DbaColComments extends BaseModel{
	

    /** @column Name of the owner of the object */
	private String owner;

    /** @column Name of the object */
	private String tableName;

    /** @column Name of the column */
	private String columnName;

    /** @column Comment on the object */
	private String comments;

	public DbaColComments(){}


	/**
	 * 获取Name of the owner of the object
	 */
	public String getOwner() {
    	return owner;
    }
  	
	/**
	 * 设置Name of the owner of the object
	 */
	public void setOwner(String owner) {
    	this.owner = owner;
    }

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
	 * 获取Name of the column
	 */
	public String getColumnName() {
    	return columnName;
    }
  	
	/**
	 * 设置Name of the column
	 */
	public void setColumnName(String columnName) {
    	this.columnName = columnName;
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
		return new StringBuilder().append("DbaColComments{").
			append("owner=").append(owner).
			append(",tableName=").append(tableName).
			append(",columnName=").append(columnName).
			append(",comments=").append(comments).
			append('}').toString();
    }
    
    /**
	 * 比较字段：
	 * owner, tableName, columnName, comments
	 */
	public boolean equals(Object o){
		if(!(o instanceof DbaColComments)) return false;
		DbaColComments v = (DbaColComments)o;
		return (owner==null && v.owner==null || owner != null && owner.equals(v.owner))
			&& (tableName==null && v.tableName==null || tableName != null && tableName.equals(v.tableName))
			&& (columnName==null && v.columnName==null || columnName != null && columnName.equals(v.columnName))
			&& (comments==null && v.comments==null || comments != null && comments.equals(v.comments))
		;
	}
	
	/**
	 * 散列字段：
	 * owner, tableName, columnName, comments
	 */
	public int hashCode(){
		int h = 1;
		h = 31 * h + (owner==null ? 0 : owner.hashCode());
		h = 31 * h + (tableName==null ? 0 : tableName.hashCode());
		h = 31 * h + (columnName==null ? 0 : columnName.hashCode());
		h = 31 * h + (comments==null ? 0 : comments.hashCode());
		return h;
	}
	
	/**
	 * 复制对象,复制了以下字段
	 * owner, tableName, columnName, comments
	 */
	public DbaColComments copy(){
		DbaColComments m = new DbaColComments();
     	m.owner = owner;
     	m.tableName = tableName;
     	m.columnName = columnName;
     	m.comments = comments;
		return m;
	}
}
