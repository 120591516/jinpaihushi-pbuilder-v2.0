package com.afocus.pbuilder.common.context;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Column extends Named, Typed, Commented, Alias, Original {

	static final Pattern EL_PATTERN = Pattern.compile("#\\{(\\w+?)\\}");

	boolean isNullable();
	/**
	 * 获取所在表名
	 * 
	 * @return 表名
	 */
	String getTableName();

	/**
	 * 获取（数字类型的）数据长度
	 * 
	 * @return （数字类型的）数据长度
	 */
	Long getPrecision();

	/**
	 * 获取（数字类型的）小数长度
	 * 
	 * @return （数字类型的）小数长度
	 */
	Long getScale();
	
	String getJdbcType();

	/**
	 * 
	 * @param el
	 *            如 SAMPLE_TABLE.#{name} #{alias}
	 * @return
	 */
	default String map(String el) {
		Matcher m = EL_PATTERN.matcher(el);
		StringBuffer out = new StringBuffer();
		while (m.find()) {
			String key = m.group(1);
			// try {
			// System.out.println(key + " : " + ScriptUtils.getAttribute(this,
			// key));
			// } catch (NoSuchMethodException | ScriptException e2) {
			// e2.printStackTrace();
			// }
			// System.out.println(key);
			String getMethod = "get" + Character.toUpperCase(key.charAt(0))
					+ key.substring(1);
			String value = null;
			try {
				Method method = this.getClass().getDeclaredMethod(getMethod,
						new Class<?>[0]);
				Object result = method.invoke(this, new Object[0]);
				value = result == null ? "" : result.toString();
			} catch (NoSuchMethodException | SecurityException
					| IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// e.printStackTrace();
				try {
					Field field = this.getClass().getDeclaredField(key);
					field.setAccessible(true);
					Object result = field.get(this);
					value = result == null ? "" : result.toString();
				} catch (NoSuchFieldException | SecurityException
						| IllegalArgumentException | IllegalAccessException e1) {
					value = "#{" + key + "}";
					// e1.printStackTrace();
				}
			}
			m.appendReplacement(out, value == null ? "" : value);
		}
		m.appendTail(out);
		return out.toString();
	}

}
