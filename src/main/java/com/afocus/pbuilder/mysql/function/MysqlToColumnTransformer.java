package com.afocus.pbuilder.mysql.function;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.afocus.pbuilder.common.context.impl.ColumnImpl;
import com.afocus.pbuilder.common.event.TransformerEvent;
import com.afocus.pbuilder.mysql.model.Columns;

@Component
public class MysqlToColumnTransformer implements Function<Columns, ColumnImpl>,
		ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Autowired
	private MysqlToFieldTransformer mysqlToFieldTransformer;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public ColumnImpl apply(Columns from) {
		ColumnImpl to = new ColumnImpl();
		to.setName(from.getColumnName());
		to.setType(from.getDataType());
		to.setComment(from.getColumnComment());
		to.setPrecision(from.getNumericPrecision());
		to.setScale(from.getNumericScale());
		to.setNullable("yes".equalsIgnoreCase(from.getIsNullable()));
		to.setTableName(from.getTableName());
		to.setJdbcType(mysqlToFieldTransformer.parseJdbcType(from));

		String alias = Stream
				.of(from.getColumnName().split("_"))
				.map(e -> e.isEmpty() ? ""
						: (Character.toUpperCase(e.charAt(0)) + e.substring(1)
								.toLowerCase()))
				.collect(Collectors.joining(""));
		
		alias = Character.toLowerCase(alias.charAt(0)) + alias.substring(1);
		to.setAlias(alias);

		to.setOriginal(from);

		applicationContext.publishEvent(new TransformerEvent<>(this, from, to));
		return to;
	}

}
