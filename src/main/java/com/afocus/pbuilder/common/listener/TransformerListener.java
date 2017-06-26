package com.afocus.pbuilder.common.listener;

import javax.script.ScriptException;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.afocus.pbuilder.common.event.TransformerEvent;
import com.afocus.pbuilder.common.utils.ScriptUtils;

@Component
public class TransformerListener implements
		ApplicationListener<TransformerEvent<?, ?>> {

	@Override
	public void onApplicationEvent(TransformerEvent<?, ?> event) {
		try {
			ScriptUtils.getScriptEngine().invokeFunction("trigger",
					"transformer", event);
		} catch (NoSuchMethodException | ScriptException e) {
			e.printStackTrace();
		}
	}

}
