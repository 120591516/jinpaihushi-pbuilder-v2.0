package com.afocus.pbuilder.common.service;

import java.util.List;
import java.util.Map;

public interface TableService<T> {

	T loadTable(String schema, String name);
	
	List<T> listTable(String schema, String... nameLikes);

	List<Map<String, ?>> listData(String schema, String name);
}
