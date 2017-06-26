package com.afocus.pbuilder.common.event;

import org.springframework.context.ApplicationEvent;

import com.afocus.pbuilder.TemplatePackage;

@SuppressWarnings("serial")
public class CompleteEvent extends ApplicationEvent {

	private final TemplatePackage templatePackage;

	public CompleteEvent(Object source, TemplatePackage templatePackage) {
		super(source);
		this.templatePackage = templatePackage;
	}

	public TemplatePackage getTemplatePackage() {
		return templatePackage;
	}

}
