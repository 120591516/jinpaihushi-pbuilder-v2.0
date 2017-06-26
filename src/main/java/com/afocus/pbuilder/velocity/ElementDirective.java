package com.afocus.pbuilder.velocity;

import java.io.IOException;
import java.io.Writer;

import org.apache.log4j.Logger;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

public class ElementDirective extends Directive {

	private static final Logger logger = Logger
			.getLogger(ElementDirective.class);

	@Override
	public String getName() {
		return "element";
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
		Node content = node.jjtGetChild(last);
		if (last < 4) {
			content.render(context, writer);
			logger.debug("#element 参数列表长度不对");
			return true;
		}
		if (!context.containsKey("velocityCount")) {
			logger.debug("#element velocityCount参数未找到，请确定用于#foreach里");
			return false;
		}
		int velocityCount;
		try {
			velocityCount = (int) context.get("velocityCount");
		} catch (ClassCastException e) {
			return false;
		}

		int listSize = toInt(node.jjtGetChild(0).value(context), 1);
		int lineSize = toInt(node.jjtGetChild(1).value(context), 1);
		String separator = toString(node.jjtGetChild(2).value(context), ",");
		String linePrefix = toString(node.jjtGetChild(3).value(context), "");
		if (velocityCount % lineSize == 1 || lineSize == 1) {
			writer.append(linePrefix);
		}
		content.render(context, writer);
		if (listSize != velocityCount) {
			writer.append(separator);
		}
		if (velocityCount % lineSize == 0 || listSize == velocityCount) {
			writer.append('\n');
		}
		return true;
	}

	private int toInt(Object o, int defaultValue) {
		if (o == null)
			return defaultValue;
		try {
			return Integer.parseInt(o.toString());
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	private String toString(Object o, String defaultValue) {
		return o != null ? o.toString() : defaultValue;
	}

}
