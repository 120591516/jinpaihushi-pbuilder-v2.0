package com.afocus.pbuilder.common.context.impl;

import com.afocus.pbuilder.common.context.Column;

@SuppressWarnings("serial")
public class ColumnImpl implements Column, java.io.Serializable {

	private String name;

	private String type;

	private String comment;

	private String alias;

	private String tableName;

	private Long precision;

	private Long scale;
	
	private boolean nullable;
	
	private String jdbcType;
	
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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Long getPrecision() {
		return precision;
	}

	public void setPrecision(Long precision) {
		this.precision = precision;
	}

	public Long getScale() {
		return scale;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public void setScale(Long scale) {
		this.scale = scale;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public Object getOriginal() {
		return original;
	}

	public void setOriginal(Object original) {
		this.original = original;
	}

	@Override
	public String toString() {
		return "ColumnImpl [name=" + name + ", type=" + type + ", comment="
				+ comment + ", alias=" + alias + ", tableName=" + tableName
				+ ", precision=" + precision + ", scale=" + scale
				+ ", nullable=" + nullable + ", jdbcType=" + jdbcType
				+ ", original=" + original + "]";
	}

}
