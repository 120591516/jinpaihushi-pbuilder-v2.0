package com.afocus.test;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import junit.framework.TestCase;

public class NashornTest {

	//@Test
	public void testNashorn() {
		ScriptEngineManager sem = new ScriptEngineManager();
		NashornScriptEngine nashorn1 = (NashornScriptEngine) sem
				.getEngineByName("nashorn");
		NashornScriptEngine nashorn2 = (NashornScriptEngine) sem
				.getEngineByName("nashorn");
		//TestCase.assertTrue(nashorn1 != nashorn2);
	}
	
	//@Test
	public void testSingal() throws ScriptException, NoSuchMethodException {
		ScriptEngineManager sem = new ScriptEngineManager();
		NashornScriptEngine nashorn1 = (NashornScriptEngine) sem
				.getEngineByName("nashorn");
		nashorn1.eval("function a(){print('-nashorn1');}");
		nashorn1.eval("function a(){print('-nashorn2');}");
		nashorn1.invokeFunction("a");
	}
	
	//@Test
	public void testMuti() throws ScriptException, NoSuchMethodException {
		ScriptEngineManager sem = new ScriptEngineManager();
		NashornScriptEngine nashorn1 = (NashornScriptEngine) sem
				.getEngineByName("nashorn");
		NashornScriptEngine nashorn2 = (NashornScriptEngine) sem
				.getEngineByName("nashorn");
		nashorn1.eval("function a(){print('nashorn1');}");
		nashorn2.eval("function a(){print('nashorn2');}");
		nashorn1.invokeFunction("a");
		nashorn2.invokeFunction("a");
	}

}
