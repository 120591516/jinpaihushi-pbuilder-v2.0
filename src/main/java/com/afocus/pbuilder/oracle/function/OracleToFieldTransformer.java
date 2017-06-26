package com.afocus.pbuilder.oracle.function;

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
import com.afocus.pbuilder.oracle.model.UserTabColumns;

@Component
public class OracleToFieldTransformer implements
		Function<UserTabColumns, FieldImpl>, ApplicationContextAware {
	
	private static final Map<String, String> TYPE_MAP = new HashMap<String, String>();
	static {
		TYPE_MAP.put("NUMBER", "Integer");//不准确
		TYPE_MAP.put("CHAR", "String");
		TYPE_MAP.put("VARCHAR", "String");
		TYPE_MAP.put("VARCHAR2", "String");
		TYPE_MAP.put("CLOB", "String");
		TYPE_MAP.put("DATE", "Date");
		TYPE_MAP.put("TIMESTAMP", "Date");
		TYPE_MAP.put("FLOAT", "Float");
		TYPE_MAP.put("BINARY_DOUBLE", "Double");
		TYPE_MAP.put("BINARY_FLOAT", "Float");
		TYPE_MAP.put("NCHAR", "String");
		TYPE_MAP.put("NVARCHAR2", "String");
		TYPE_MAP.put("BLOB", "Object");
		TYPE_MAP.put("LONG", "String");
		TYPE_MAP.put("RAW", "Object");
	}

	private static final Map<String, String> JDBC_TYPE_MAP = new HashMap<String, String>();
	static {
		JDBC_TYPE_MAP.put("NUMBER", "NUMERIC");
		JDBC_TYPE_MAP.put("CHAR", "VARCHAR");
		JDBC_TYPE_MAP.put("VARCHAR", "VARCHAR");
		JDBC_TYPE_MAP.put("VARCHAR2", "VARCHAR");
		JDBC_TYPE_MAP.put("CLOB", "CLOB");
		JDBC_TYPE_MAP.put("BLOB", "BLOB");
		JDBC_TYPE_MAP.put("DATE", "TIMESTAMP");
		JDBC_TYPE_MAP.put("TIMESTAMP", "TIMESTAMP");
		JDBC_TYPE_MAP.put("FLOAT", "FLOAT");
		JDBC_TYPE_MAP.put("BINARY_DOUBLE", "DOUBLE");
		JDBC_TYPE_MAP.put("BINARY_FLOAT", "FLOAT");
		JDBC_TYPE_MAP.put("NCHAR", "NCHAR");
		JDBC_TYPE_MAP.put("NVARCHAR2", "NVARCHAR");
		JDBC_TYPE_MAP.put("LONG", "VARBINARY");
		JDBC_TYPE_MAP.put("RAW", "VARBINARY");
	}
	
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public FieldImpl apply(UserTabColumns from) {
		FieldImpl to = new FieldImpl();

		String _name = Stream
				.of(from.getColumnName().split("_"))
				.map(e -> Character.toUpperCase(e.charAt(0))
						+ e.substring(1).toLowerCase())
				.collect(Collectors.joining(""));
		String name = Character.toLowerCase(_name.charAt(0))
				+ _name.substring(1);

		String type = null;
		if("NUMBER".equalsIgnoreCase(from.getDataType())){
			type = applyNumber(from);
		}else{
			type = TYPE_MAP.get(from.getDataType().toUpperCase());
			if (type == null) {
				throw new TransformerException("can not transformer "
						+ from.getDataType() + " to Field.type");
			}
		}

		String jdbcType = JDBC_TYPE_MAP.get(from.getDataType().toUpperCase());
		if (jdbcType == null) {
			throw new TransformerException("can not transformer "
					+ from.getDataType() + " to Field.jdbcType");
		}
		
		to.setName(name);
		to.setType(type);
		to.setJdbcType(jdbcType);
		to.setComment(from.getComments());
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
	
	private String applyNumber(UserTabColumns input) {
		Integer precision = input.getDataPrecision();
		Integer scale = input.getDataScale();
		if(precision==null){
			return "Integer";
		}else if(scale==null){
			return transStr(precision);
		}else if(scale==0){
			return transStr(precision);
		}else{
			return "Double";
		}
	}
	
	private String transStr(Integer length){
		if(length!=null){//Byte
			if(length<=3){
				return "Byte";	
			}
			else if(length>3&&length<12){
				return "Integer";
			}
			else {
				return "Long";
			}
		}
		return "Integer";
	}

}
