package com.afocus.pbuilder.common.utils;

import java.util.HashSet;
import java.util.Set;

import com.afocus.pbuilder.common.context.Named;

/**
 * 扩展的列表接口<br/>
 * 本接口的扩展方法目的在于提高集合操作的易用性，部分方法可能是低效的
 * 
 * @author liuwu
 *
 * @param <T>
 */
public interface NamedList<T extends Named> extends List<T> {

	/**
	 * 过滤掉<code>element.name</code>属性在<code>names</code>数组中的字段
	 * 
	 * @param names
	 *            字段名数组
	 * @return
	 */
	default List<T> filter(Set<String> names) {
		if (names == null || names.isEmpty())
			return this;
		return this.stream().filter(e -> !names.contains(e.getName()))
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	}

	/**
	 * 返回当前对象里<code>element.name</code>与<code>names</code>数组交叉后所得的字段列表
	 * 
	 * @param names
	 *            字段名数组
	 * @return
	 */
	default List<T> in(Set<String> names) {
		if (names == null || names.isEmpty())
			return new ArrayList<>(0);
		List<T> list = this.stream().filter(e -> names.contains(e.getName()))
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		return list;
	}

	default List<T> filter(String names) {
		if (names == null || names.isEmpty())
			return this;
		Set<String> nameSet = new HashSet<>(names.length());
		for (String name : names.split(",")) {
			nameSet.add(name);
		}
		return this.filter(nameSet);
	}

	default List<T> in(String names) {
		if (names == null || names.isEmpty())
			return this;
		Set<String> nameSet = new HashSet<>(names.length());
		for (String name : names.split(",")) {
			nameSet.add(name);
		}
		return this.in(nameSet);
	}

	default boolean has(String name) {
		if (name == null)
			return false;
		return this.stream()
				.anyMatch(element -> name.equals(element.getName()));
	}
}
