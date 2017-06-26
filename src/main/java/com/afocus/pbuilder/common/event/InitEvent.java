package com.afocus.pbuilder.common.event;

import java.util.Properties;

import org.apache.velocity.context.Context;
import org.springframework.context.ApplicationEvent;

/**
 * 初始化事件，在扫描完模板包，加载配置文件，JavaScript文件后触发
 * @author liuwu
 *
 */
@SuppressWarnings("serial")
public class InitEvent extends ApplicationEvent {

	private final Properties properties;

	private final Context velocityContext;

	public InitEvent(Object source, Properties properties,
			Context velocityContext) {
		super(source);
		this.properties = properties;
		this.velocityContext = velocityContext;
	}

	public Properties getProperties() {
		return properties;
	}

	public Context getVelocityContext() {
		return velocityContext;
	}

}
