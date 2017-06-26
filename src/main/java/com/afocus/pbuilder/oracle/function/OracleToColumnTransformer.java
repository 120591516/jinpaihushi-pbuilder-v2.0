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

import com.afocus.pbuilder.common.context.impl.ColumnImpl;
import com.afocus.pbuilder.common.event.TransformerEvent;
import com.afocus.pbuilder.common.exception.TransformerException;
import com.afocus.pbuilder.oracle.model.UserTabColumns;

@Component
public class OracleToColumnTransformer implements
		Function<UserTabColumns, ColumnImpl>, ApplicationContextAware {
	
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
	public ColumnImpl apply(UserTabColumns from) {
		ColumnImpl to = new ColumnImpl();
		to.setName(from.getColumnName());
		to.setType(from.getDataType());
		to.setComment(from.getComments());
		if(from.getDataPrecision() != null)
			to.setPrecision(from.getDataPrecision().longValue());
		if(from.getDataScale() != null)
			to.setScale(from.getDataScale().longValue());
		to.setNullable("Y".equalsIgnoreCase(from.getNullable()));
		to.setTableName(from.getTableName());
		
		String alias = Stream
				.of(from.getColumnName().split("_"))
				.map(e -> Character.toUpperCase(e.charAt(0))
						+ e.substring(1).toLowerCase())
				.collect(Collectors.joining(""));
		alias = Character.toLowerCase(alias.charAt(0)) + alias.substring(1);
		to.setAlias(alias);
		
		String jdbcType = JDBC_TYPE_MAP.get(from.getDataType().toUpperCase());
		if (jdbcType == null) {
			throw new TransformerException("can not transformer "
					+ from.getDataType() + " to Field.jdbcType");
		}
		to.setJdbcType(jdbcType);

		to.setOriginal(from);
		
		applicationContext.publishEvent(new TransformerEvent<>(this, from, to));
		
		return to;
	}

}
