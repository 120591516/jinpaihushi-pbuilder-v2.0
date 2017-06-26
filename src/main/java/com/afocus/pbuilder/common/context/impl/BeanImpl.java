package com.afocus.pbuilder.common.context.impl;

import com.afocus.pbuilder.common.context.Bean;
import com.afocus.pbuilder.common.utils.ArrayList;

@SuppressWarnings("serial")
public class BeanImpl extends ArrayList<FieldImpl> implements Bean<FieldImpl>,
		java.io.Serializable {

	private String name;

	private String comment;

	private String alias;

	private Object original;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Object getOriginal() {
		return original;
	}

	public void setOriginal(Object original) {
		this.original = original;
	}

	@Override
	public String toString() {
		return "BeanImpl [name=" + name + ", comment=" + comment + ", alias="
				+ alias + ", original=" + original + "]";
	}
}
