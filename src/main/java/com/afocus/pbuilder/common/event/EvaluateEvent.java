package com.afocus.pbuilder.common.event;

import java.io.File;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class EvaluateEvent extends ApplicationEvent {
	
	private final File template;
	
	private final File result;

	public EvaluateEvent(Object source, File template, File result) {
		super(source);
		this.template = template;
		this.result = result;
	}

	public File getTemplate() {
		return template;
	}

	public File getResult() {
		return result;
	}

}
