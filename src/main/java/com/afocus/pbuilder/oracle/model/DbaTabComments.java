package com.afocus.pbuilder.oracle.model;

import com.afocus.pbuilder.common.model.BaseModel;

/**
 * DBA_TAB_COMMENTS Comments on all tables and views in the database
 * 
 * @author liuwu
 * @date 2015-09-11
 * @company afocus
 * @version 5.0
 */
@SuppressWarnings("serial")
public class DbaTabComments extends BaseModel{
	

    /** @column Owner of the object */
	private String owner;

    /** @column Name of the object */
	private String tableName;

    /** @column Type of the object */
	private String tableType;

    /** @column Comment on the object */
	private String comments;

	public DbaTabComments(){}


	/**
	 * 获取Owner of the object
	 */
	public String getOwner() {
    	return owner;
    }
  	
	/**
	 * 设置Owner of the object
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
	 * 获取Type of the object
	 */
	public String getTableType() {
    	return tableType;
    }
  	
	/**
	 * 设置Type of the object
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
		return new StringBuilder().append("DbaTabComments{").
			append("owner=").append(owner).
			append(",tableName=").append(tableName).
			append(",tableType=").append(tableType).
			append(",comments=").append(comments).
			append('}').toString();
    }
    
    /**
	 * 比较字段：
	 * owner, tableName, tableType, comments
	 */
	public boolean equals(Object o){
		if(!(o instanceof DbaTabComments)) return false;
		DbaTabComments v = (DbaTabComments)o;
		return (owner==null && v.owner==null || owner != null && owner.equals(v.owner))
			&& (tableName==null && v.tableName==null || tableName != null && tableName.equals(v.tableName))
			&& (tableType==null && v.tableType==null || tableType != null && tableType.equals(v.tableType))
			&& (comments==null && v.comments==null || comments != null && comments.equals(v.comments))
		;
	}
	
	/**
	 * 散列字段：
	 * owner, tableName, tableType, comments
	 */
	public int hashCode(){
		int h = 1;
		h = 31 * h + (owner==null ? 0 : owner.hashCode());
		h = 31 * h + (tableName==null ? 0 : tableName.hashCode());
		h = 31 * h + (tableType==null ? 0 : tableType.hashCode());
		h = 31 * h + (comments==null ? 0 : comments.hashCode());
		return h;
	}
	
	/**
	 * 复制对象,复制了以下字段
	 * owner, tableName, tableType, comments
	 */
	public DbaTabComments copy(){
		DbaTabComments m = new DbaTabComments();
     	m.owner = owner;
     	m.tableName = tableName;
     	m.tableType = tableType;
     	m.comments = comments;
		return m;
	}
}
