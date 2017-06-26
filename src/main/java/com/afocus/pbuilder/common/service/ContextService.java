package com.afocus.pbuilder.common.service;

import org.apache.velocity.context.Context;


public interface ContextService {
	
	/**
	 * 设置上下文
	 * 把数据结构<code>source</code>经过配置的转换器，转化成相应的数据结构，并放置到上下文中去
	 * @param source 源数据结构
	 * @param out 上下文
	 */
	void setContext(Object source, Context out);

}
