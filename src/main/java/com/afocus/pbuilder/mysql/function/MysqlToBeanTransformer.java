package com.afocus.pbuilder.mysql.function;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.afocus.pbuilder.common.context.impl.BeanImpl;
import com.afocus.pbuilder.common.event.TransformerEvent;
import com.afocus.pbuilder.common.function.NamedTransformer;
import com.afocus.pbuilder.mysql.model.Tables;

@Component
public class MysqlToBeanTransformer implements NamedTransformer<Tables, BeanImpl>,
		ApplicationContextAware {

	@Autowired
	private MysqlToFieldTransformer mysqlToFieldTransformer;

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public BeanImpl apply(Tables from) {
		String name = Stream
				.of(from.getTableName().split("_"))
				.map(e -> Character.toUpperCase(e.charAt(0))
						+ e.substring(1).toLowerCase())
				.collect(Collectors.joining(""));
		String alias = Character.toLowerCase(name.charAt(0))
				+ name.substring(1);
		
		BeanImpl to = new BeanImpl();
		to.setName(name);
		to.setAlias(alias);
		to.setComment(from.getTableComment());

		from.getColumnsList().stream().map(mysqlToFieldTransformer)
				.forEachOrdered(to::add);
		
		to.setOriginal(from);

		applicationContext.publishEvent(new TransformerEvent<>(this, from, to));
		
		return to;
	}

	@Override
	public String getName() {
		return "bean";
	}
}
