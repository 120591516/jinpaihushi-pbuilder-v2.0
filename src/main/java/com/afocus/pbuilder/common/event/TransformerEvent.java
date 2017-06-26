package com.afocus.pbuilder.common.event;

import org.springframework.context.ApplicationEvent;

/**
 * 在进行数据转换时时触发
 * @author liuwu
 *
 * @param <F>
 * @param <T>
 */
@SuppressWarnings("serial")
public class TransformerEvent<F, T> extends ApplicationEvent {

	private final F from;

	private final T to;
	
	public TransformerEvent(Object source, F from, T to) {
		super(source);
		this.from = from;
		this.to = to;
	}

	public F getFrom() {
		return from;
	}

	public T getTo() {
		return to;
	}

	@Override
	public String toString() {
		return "TransformerEvent [from=" + from + ", to=" + to + "]";
	}

}
