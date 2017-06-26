package com.afocus.pbuilder.velocity;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

public class DateDirective extends Directive {

	private static final String DEFAULT_FMT = "yyyy-MM-dd HH:mm:ss";

	private static final Logger logger = Logger.getLogger(DateDirective.class);

	@Override
	public String getName() {
		return "date";
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer,
			Node node) throws IOException, ResourceNotFoundException,
			ParseErrorException, MethodInvocationException {
		Date date = null;
		String fmt = DEFAULT_FMT;
		int params = node.jjtGetNumChildren();
		if (params == 0) {
			date = new Date();
		} else if (params == 1) {
			try {
				Object param1 = node.jjtGetChild(0).value(context);
				if (param1 instanceof Date) {
					date = (Date) param1;
				} else if (param1 instanceof CharSequence) {
					date = new Date();
					fmt = param1.toString();
				} else {
					date = new Date();
				}
			} catch (Exception e) {
				date = new Date();
				fmt = DEFAULT_FMT;
				logger.warn("error while get first param from #date directive");
			}
		} else{
			try {
				date = (Date) node.jjtGetChild(0).value(context);
			} catch (Exception e) {
				date = new Date();
				logger.warn("error while get first param from #date directive");
			}
			try {
				fmt = (String) node.jjtGetChild(1).value(context);
			} catch (Exception e) {
				fmt = DEFAULT_FMT;
				logger.warn("error while get second param from #date directive");
			}
		}
		writer.append(com.afocus.pbuilder.common.utils.Date.format(date, fmt));
		return true;
	}
}
