package com.afocus.pbuilder.oracle.function;

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
import com.afocus.pbuilder.oracle.model.UserTabOrViews;

@Component
public class OracleToBeanTransformer implements
		NamedTransformer<UserTabOrViews, BeanImpl>, ApplicationContextAware {
	
	@Autowired
	private OracleToFieldTransformer oracleToFieldTransformer;
	
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public String getName() {
		return "bean";
	}

	@Override
	public BeanImpl apply(UserTabOrViews from) {
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
		to.setComment(from.getComments());

		from.getUserTabColumnsList().stream().map(oracleToFieldTransformer)
				.forEachOrdered(to::add);
		
		to.setOriginal(from);

		applicationContext.publishEvent(new TransformerEvent<>(this, from, to));
		
		return to;
	}

}
