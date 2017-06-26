package com.afocus.pbuilder.mysql.function;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.afocus.pbuilder.common.context.impl.TableImpl;
import com.afocus.pbuilder.common.event.TransformerEvent;
import com.afocus.pbuilder.common.function.NamedTransformer;
import com.afocus.pbuilder.mysql.model.Tables;

@Component
public class MysqlToTableTransformer implements NamedTransformer<Tables, TableImpl>,
		ApplicationContextAware {

	@Autowired
	private MysqlToColumnTransformer mysqlToColumnTransformer;

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public TableImpl apply(Tables from) {
		TableImpl to = new TableImpl();
		
		to.setName(from.getTableName());
		to.setComment(from.getTableComment());
		to.setSchema(from.getTableSchema());

		if (from.getTableType() == null) {
			to.setType(TableImpl.TYPE_TABLE);
		} else if (from.getTableType().contains(TableImpl.TYPE_TABLE)) {
			to.setType(TableImpl.TYPE_TABLE);
		} else if (from.getTableType().contains(TableImpl.TYPE_VIEW)) {
			to.setType(TableImpl.TYPE_VIEW);
		}

		to.setAlias(Stream.of(from.getTableName().split("_"))
				.map(e -> String.valueOf(e.charAt(0)))
				.collect(Collectors.joining("")));

		from.getColumnsList().stream().map(mysqlToColumnTransformer)
				.forEachOrdered(to::add);
		
		to.setOriginal(from);

		applicationContext.publishEvent(new TransformerEvent<>(this, from, to));
		
		return to;
	}

	@Override
	public String getName() {
		return "table";
	}
}
