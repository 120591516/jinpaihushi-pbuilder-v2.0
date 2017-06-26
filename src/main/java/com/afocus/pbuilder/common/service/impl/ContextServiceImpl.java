package com.afocus.pbuilder.common.service.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.velocity.context.Context;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.common.event.VelocityContextPreparedEvent;
import com.afocus.pbuilder.common.function.NamedTransformer;
import com.afocus.pbuilder.common.service.ContextService;

@Service("contextService")
public class ContextServiceImpl implements ContextService,
		ApplicationContextAware {

	private ApplicationContext applicationContext;
	private List<NamedTransformer<?, ?>> namedTransformers = new ArrayList<>();
	private @Value("${template.transformers:}") String transformers;

	private Type[] getGenericOfTransformer(NamedTransformer<?, ?> function) {
		Type[] types = function.getClass().getGenericInterfaces();
		for (Type type : types) {
			if (!(type instanceof ParameterizedType)) {
				continue;
			}
			ParameterizedType pt = (ParameterizedType) type;
			if (NamedTransformer.class.equals(pt.getRawType())) {
				Type[] typeArguments = pt.getActualTypeArguments();
				return typeArguments;
			}
		}
		throw new IllegalArgumentException("请直接继承NamedTransformer ："
				+ function.getClass());
	}

	private boolean isSubOrEqual(Class<?> sub, Class<?> sup) {
		if (Object.class.equals(sub) && !Object.class.equals(sup))
			return false;
		if (sub.equals(sup))
			return true;
		return isSubOrEqual(sub.getSuperclass(), sup);
	}

	@Override
	public void setContext(Object source, Context context) {
		namedTransformers.forEach(transformer -> {
			Type[] types = getGenericOfTransformer(transformer);
			if (isSubOrEqual(source.getClass(), (Class<?>) types[0])) {
				Object value = transformer.apply(cast(source));
				context.put(transformer.getName(), value);
			}
		});
		applicationContext.publishEvent(new VelocityContextPreparedEvent(this,
				context));
	}

	@SuppressWarnings("unchecked")
	private <T> T cast(Object source) {
		return (T) source;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

		if (transformers.isEmpty())
			return;
		Stream.of(transformers.split(","))
				.distinct()
				.forEach(
						name -> {
							try {
								namedTransformers
										.add((NamedTransformer<?, ?>) this.applicationContext
												.getBean(name));
							} catch (ClassCastException e) {
								e.printStackTrace();
							}
						});

	}

}
