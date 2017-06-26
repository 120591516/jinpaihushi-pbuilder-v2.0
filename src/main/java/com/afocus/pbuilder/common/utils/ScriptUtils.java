package com.afocus.pbuilder.common.utils;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.NashornScriptEngine;

public class ScriptUtils {

	private static NashornScriptEngine nashorn = null;

	public static NashornScriptEngine getScriptEngine() {
		if (nashorn == null) {
			nashorn = (NashornScriptEngine) new ScriptEngineManager()
					.getEngineByName("nashorn");
		}
		return nashorn;
	}

	public static <E> void trigger(String eventType, E event) {
		try {
			getScriptEngine().invokeFunction("trigger", eventType, event);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

}
