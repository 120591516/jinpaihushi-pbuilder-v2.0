package com.afocus.pbuilder.velocity;

import java.io.IOException;
import java.io.Writer;

import javax.script.ScriptException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

import com.afocus.pbuilder.common.utils.ScriptUtils;

public class JavascriptDirective extends Directive {

	private static final Logger logger = Logger
			.getLogger(JavascriptDirective.class);

	@Override
	public String getName() {
		return "javascript";
	}

	@Override
	public int getType() {
		return BLOCK;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer,
			Node node) throws IOException, ResourceNotFoundException,
			ParseErrorException, MethodInvocationException {
		int last = node.jjtGetNumChildren() - 1;
		String[] params = new String[node.jjtGetNumChildren()];
		Object[] args = new Object[node.jjtGetNumChildren()];
		for (int i = 0; i < last; i++) {
			Object value = node.jjtGetChild(i).value(context);
			args[i] = value;
			params[i] = "arg" + i;
		}
		args[last] = context;
		params[last] = "context";

		Node jsNode = node.jjtGetChild(last);
		String javascript;
		try {
			javascript = jsNode.literal();
		} catch (NullPointerException e) {
			return true;
		}

		String functionName = "velocity_script_"
				+ RandomStringUtils.randomAlphanumeric(8) + "_"
				+ System.currentTimeMillis();

		String wrapperScript = new StringBuilder().append("function ")
				.append(functionName).append('(')
				.append(StringUtils.join(params, ", ")).append("){\n")
				.append(javascript).append('}').toString();
		String clearScript = functionName + " = undefined;";
		logger.debug("[velocity script] >>\n" + wrapperScript);
		try {
			ScriptUtils.getScriptEngine().eval(wrapperScript);
			ScriptUtils.getScriptEngine().invokeFunction(functionName, args);
			ScriptUtils.getScriptEngine().eval(clearScript);
		} catch (NoSuchMethodException | ScriptException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
