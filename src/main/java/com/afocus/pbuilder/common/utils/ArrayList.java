package com.afocus.pbuilder.common.utils;

import java.util.Collection;

@SuppressWarnings("serial")
public class ArrayList<T> extends java.util.ArrayList<T> implements List<T>{

	public ArrayList() {
		super();
	}

	public ArrayList(Collection<? extends T> c) {
		super(c);
	}

	public ArrayList(int initialCapacity) {
		super(initialCapacity);
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		java.util.List<T> sub = super.subList(fromIndex, toIndex);
		ArrayList<T> list = new ArrayList<>(sub.size());
		list.addAll(sub);
		return list;
	}

}
