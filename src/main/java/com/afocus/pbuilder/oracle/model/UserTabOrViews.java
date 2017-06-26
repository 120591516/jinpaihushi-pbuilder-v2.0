package com.afocus.pbuilder.oracle.model;

import java.util.List;

import com.afocus.pbuilder.common.model.BaseModel;

@SuppressWarnings("serial")
public abstract class UserTabOrViews extends BaseModel {

	public abstract String getTableName();
	
	public abstract String getTablespaceName();
	
	public abstract String getComments();
	
	public abstract List<UserTabColumns> getUserTabColumnsList();
	
	public abstract void setUserTabColumnsList(List<UserTabColumns> columns);
	
	/**
	 *
	 * @return  TABLE / VIEW
	 */
	public abstract String getTableType();

}
