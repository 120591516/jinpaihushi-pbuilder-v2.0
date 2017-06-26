package com.afocus.pbuilder.common.utils;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Date extends java.util.Date {

	private static final long serialVersionUID = 8397982340308623002L;

	private static Map<String, SimpleDateFormat> FORMATS = new HashMap<String, SimpleDateFormat>();
	static {
		FORMATS.put("yyyy-MM-dd HH:mm:ss", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"));
		FORMATS.put("yyyy/MM/dd HH:mm:ss", new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss"));
		FORMATS.put("yyyy-MM-dd hh:mm:ss", new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss"));
		FORMATS.put("yyyy/MM/dd hh:mm:ss", new SimpleDateFormat(
				"yyyy/MM/dd hh:mm:ss"));
		FORMATS.put("yyyy-MM-dd", new SimpleDateFormat("yyyy-MM-dd"));
		FORMATS.put("yy-MM-dd", new SimpleDateFormat("yy-MM-dd"));
		FORMATS.put("MM-dd", new SimpleDateFormat("MM-dd"));
		FORMATS.put("MM/dd", new SimpleDateFormat("MM/dd"));

		FORMATS.put("yyyy年MM月dd日 HH时mm分ss秒", new SimpleDateFormat(
				"yyyy年MM月dd日 HH时mm分ss秒"));
		FORMATS.put("yyyy年MM月dd日", new SimpleDateFormat("yyyy年MM月dd日"));
		FORMATS.put("yy年MM月dd日", new SimpleDateFormat("yy年MM月dd日"));
		FORMATS.put("MM月dd日", new SimpleDateFormat("MM月dd日"));
	}

	public Date() {
		super();
	}

	public Date(long date) {
		super(date);
	}

	public String formatDateTime() {
		return format(this, "yyyy-MM-dd HH:mm:ss");
	}

	public String formatDate() {
		return format(this, "yyyy-MM-dd");
	}

	public String format(String formatString) {
		return format(this, formatString);
	}

	public static String format(java.util.Date date, String formatString) {
		SimpleDateFormat sdf = FORMATS.get(formatString);
		if (sdf == null) {
			sdf = new SimpleDateFormat(formatString);
		}
		return sdf.format(date);
	}

}
