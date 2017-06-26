package com.afocus.pbuilder.common.function;

import java.util.function.Function;

import com.afocus.pbuilder.common.context.Named;

/**
 * 数据转换器<br/>
 * 
 * <code>T apply(F from)</code> ： 把对象从F类型转换成T类型<br/>
 * <code>String getName()</code> ：获取转换结果的名称，这个名称即上下文中改对象的名称<br/>
 * 设置上下文的方式：<code>context.put(transformer.getName(), transformer.apply(data));</code><br/>
 * 
 * @author liuwu
 *
 * @param <F>
 *            数据来源的类型，为了便于实现，此泛型请不要使用interface,且这个类型不可以再带泛型
 * @param <T>
 *            数据结果的类型
 */
public interface NamedTransformer<F, T> extends Named, Function<F, T> {

}
