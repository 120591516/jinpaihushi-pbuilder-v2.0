package com.afocus.pbuilder.common.event;

import org.apache.velocity.context.Context;
import org.springframework.context.ApplicationEvent;

/**
 * velocity上下文准备完成事件，在上下文准备完毕后， 调用模板引擎之前触发
 * 
 * @author liuwu
 *
 */
@SuppressWarnings("serial")
public class VelocityContextPreparedEvent extends ApplicationEvent {

	private final Context velocityContext;

	public VelocityContextPreparedEvent(Object source, Context velocityContext) {
		super(source);
		this.velocityContext = velocityContext;
	}

	public Context getVelocityContext() {
		return velocityContext;
	}

}
