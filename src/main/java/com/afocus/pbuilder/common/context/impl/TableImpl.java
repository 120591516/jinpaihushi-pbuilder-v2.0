package com.afocus.pbuilder.common.context.impl;

import com.afocus.pbuilder.common.context.Table;
import com.afocus.pbuilder.common.utils.ArrayList;

@SuppressWarnings("serial")
public class TableImpl extends ArrayList<ColumnImpl> implements
		Table<ColumnImpl>, java.io.Serializable {

	private String name;

	private String type;

	private String comment;

	private String alias;

	private String schema;
	
	private Object original;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public Object getOriginal() {
		return original;
	}

	public void setOriginal(Object original) {
		this.original = original;
	}

	@Override
	public String toString() {
		return "TableImpl [name=" + name + ", type=" + type + ", comment="
				+ comment + ", alias=" + alias + ", schema=" + schema
				+ ", original=" + original + "]";
	}

}
