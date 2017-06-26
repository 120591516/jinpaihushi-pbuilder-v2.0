package com.afocus.pbuilder.common.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.afocus.pbuilder.common.utils.ScriptUtils;

@Component
public class SpringContextRefreshedListener implements
		ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ScriptUtils.trigger("springContextRefreshed", event);
	}

}
