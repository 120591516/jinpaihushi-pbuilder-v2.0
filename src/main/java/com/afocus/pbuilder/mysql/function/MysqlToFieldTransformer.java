package com.afocus.pbuilder.mysql.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.afocus.pbuilder.common.context.impl.FieldImpl;
import com.afocus.pbuilder.common.event.TransformerEvent;
import com.afocus.pbuilder.common.exception.TransformerException;
import com.afocus.pbuilder.mysql.model.Columns;

@Component
public class MysqlToFieldTransformer implements Function<Columns, FieldImpl>,
		ApplicationContextAware {

	private static final Map<String, String> TYPE_MAP = new HashMap<String, String>();
	static {
		TYPE_MAP.put("TINYINT", "Byte");
		TYPE_MAP.put("SMALLINT", "Short");
		TYPE_MAP.put("MEDIUMINT", "Integer");
		TYPE_MAP.put("INT", "Integer");
		TYPE_MAP.put("INTEGER", "Integer");
		TYPE_MAP.put("BIGINT", "Long");
		TYPE_MAP.put("FLOAT", "Float");
		TYPE_MAP.put("DOUBLE", "Double");
		TYPE_MAP.put("DECIMAL", "Double");// 不准确
		TYPE_MAP.put("DATE", "Date");
		TYPE_MAP.put("TIME", "Date");
		TYPE_MAP.put("YEAR", "Integer");
		TYPE_MAP.put("DATETIME", "Date");
		TYPE_MAP.put("TIMESTAMP", "Date");

		TYPE_MAP.put("CHAR", "String");
		TYPE_MAP.put("VARCHAR", "String");
		TYPE_MAP.put("TINYBLOB", "String");
		TYPE_MAP.put("TINYTEXT", "String");
		TYPE_MAP.put("BLOB", "String");
		TYPE_MAP.put("TEXT", "String");
		TYPE_MAP.put("MEDIUMBLOB", "String");
		TYPE_MAP.put("MEDIUMTEXT", "String");
		TYPE_MAP.put("LONGBLOB", "String");
		TYPE_MAP.put("LONGTEXT", "String");
		TYPE_MAP.put("BIT", "Boolean");
	}

	private static final Map<String, String> JDBC_TYPE_MAP = new HashMap<String, String>();
	static {
		JDBC_TYPE_MAP.put("TINYINT", "TINYINT");
		JDBC_TYPE_MAP.put("SMALLINT", "SMALLINT");
		JDBC_TYPE_MAP.put("MEDIUMINT", "INTEGER");
		JDBC_TYPE_MAP.put("INT", "INTEGER");
		JDBC_TYPE_MAP.put("INTEGER", "INTEGER");
		JDBC_TYPE_MAP.put("BIGINT", "BIGINT");
		JDBC_TYPE_MAP.put("FLOAT", "FLOAT");
		JDBC_TYPE_MAP.put("DOUBLE", "DOUBLE");
		JDBC_TYPE_MAP.put("DECIMAL", "DECIMAL");
		JDBC_TYPE_MAP.put("DATE", "DATE");
		JDBC_TYPE_MAP.put("TIME", "TIME");
		JDBC_TYPE_MAP.put("YEAR", "Integer");
		JDBC_TYPE_MAP.put("DATETIME", "TIMESTAMP");
		JDBC_TYPE_MAP.put("TIMESTAMP", "TIMESTAMP");

		JDBC_TYPE_MAP.put("CHAR", "CHAR");
		JDBC_TYPE_MAP.put("VARCHAR", "VARCHAR");
		JDBC_TYPE_MAP.put("TINYBLOB", "BLOB");
		JDBC_TYPE_MAP.put("TINYTEXT", "VARCHAR");
		JDBC_TYPE_MAP.put("BLOB", "BLOB");
		JDBC_TYPE_MAP.put("TEXT", "VARCHAR");
		JDBC_TYPE_MAP.put("MEDIUMBLOB", "BLOB");
		JDBC_TYPE_MAP.put("MEDIUMTEXT", "VARCHAR");
		JDBC_TYPE_MAP.put("LONGBLOB", "BLOB");
		JDBC_TYPE_MAP.put("LONGTEXT", "VARCHAR");
		JDBC_TYPE_MAP.put("BIT", "BOOLEAN");
	}

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public FieldImpl apply(Columns from) {
		FieldImpl to = new FieldImpl();

		String _name = Stream
				.of(from.getColumnName().split("_"))
				.map(e -> e.isEmpty() ? ""
						: (Character.toUpperCase(e.charAt(0)) + e.substring(1)
								.toLowerCase()))
				.collect(Collectors.joining(""));
		String name = Character.toLowerCase(_name.charAt(0))
				+ _name.substring(1);

		String type = TYPE_MAP.get(from.getDataType().toUpperCase());
		if (type == null) {
			throw new TransformerException("can not transformer "
					+ from.getDataType() + " to Field.type");
		}

		String jdbcType = parseJdbcType(from);

		to.setName(name);
		to.setType(type);
		to.setJdbcType(jdbcType);
		to.setComment(from.getColumnComment());
		to.setGetMethod("get" + _name);
		to.setSetMethod("set" + _name);

		if ("Date".equals(type)) {
			to.setFullType("java.util.Date");
		} else {
			to.setFullType("java.lang." + type);
		}

		to.setOriginal(from);

		applicationContext.publishEvent(new TransformerEvent<>(this, from, to));
		return to;
	}

	public String parseJdbcType(Columns from) {
		String jdbcType = JDBC_TYPE_MAP.get(from.getDataType().toUpperCase());
		if (jdbcType == null) {
			throw new TransformerException("can not transformer "
					+ from.getDataType() + " to Field.jdbcType");
		}
		return jdbcType;
	}

}
