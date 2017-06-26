package com.afocus.pbuilder.common.listener;

import javax.script.ScriptException;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.afocus.pbuilder.common.event.VelocityContextPreparedEvent;
import com.afocus.pbuilder.common.utils.ScriptUtils;

@Component
public class VelocityContextPreparedListener implements
		ApplicationListener<VelocityContextPreparedEvent> {
	
	@Override
	public void onApplicationEvent(VelocityContextPreparedEvent event) {
		try {
			ScriptUtils.getScriptEngine().invokeFunction("trigger",
					"velocityContextPrepared", event);
		} catch (NoSuchMethodException | ScriptException e) {
			e.printStackTrace();
		}
	}

}
