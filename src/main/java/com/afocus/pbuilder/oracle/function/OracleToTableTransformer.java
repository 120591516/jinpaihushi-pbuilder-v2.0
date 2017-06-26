package com.afocus.pbuilder.oracle.function;

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
import com.afocus.pbuilder.oracle.model.UserTabOrViews;

@Component
public class OracleToTableTransformer implements
		NamedTransformer<UserTabOrViews, TableImpl>, ApplicationContextAware {

	@Autowired
	private OracleToColumnTransformer oracleToColumnTransformer;

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public String getName() {
		return "table";
	}

	@Override
	public TableImpl apply(UserTabOrViews from) {
		TableImpl to = new TableImpl();

		to.setName(from.getTableName());
		to.setComment(from.getComments());
		to.setSchema(from.getTablespaceName());
		to.setType(from.getTableType());

		to.setAlias(Stream.of(from.getTableName().split("_"))
				.map(e -> String.valueOf(e.charAt(0)))
				.collect(Collectors.joining("")));

		from.getUserTabColumnsList().stream().map(oracleToColumnTransformer)
				.forEachOrdered(to::add);

		to.setOriginal(from);

		applicationContext.publishEvent(new TransformerEvent<>(this, from, to));

		return to;
	}

}
