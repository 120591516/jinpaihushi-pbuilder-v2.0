package com.afocus.pbuilder.common.context.impl;

import com.afocus.pbuilder.common.context.Field;

@SuppressWarnings("serial")
public class FieldImpl implements Field, java.io.Serializable {

	private String name;

	private String type;

	private String comment;

	private String getMethod;

	private String setMethod;

	private String fullType;
	
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

	public String getGetMethod() {
		return getMethod;
	}

	public void setGetMethod(String getMethod) {
		this.getMethod = getMethod;
	}

	public String getSetMethod() {
		return setMethod;
	}

	public void setSetMethod(String setMethod) {
		this.setMethod = setMethod;
	}

	public String getFullType() {
		return fullType;
	}

	public void setFullType(String fullType) {
		this.fullType = fullType;
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
		return "FieldImpl [name=" + name + ", type=" + type + ", comment="
				+ comment + ", getMethod=" + getMethod + ", setMethod="
				+ setMethod + ", fullType=" + fullType + ", jdbcType="
				+ jdbcType + ", original=" + original + "]";
	}
}
