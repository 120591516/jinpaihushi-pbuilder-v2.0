package com.afocus.pbuilder.oracle.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.common.service.TableService;
import com.afocus.pbuilder.oracle.mapper.UserTabColumnsMapper;
import com.afocus.pbuilder.oracle.mapper.UserTablesMapper;
import com.afocus.pbuilder.oracle.mapper.UserViewsMapper;
import com.afocus.pbuilder.oracle.model.UserTabColumns;
import com.afocus.pbuilder.oracle.model.UserTabOrViews;
import com.afocus.pbuilder.oracle.model.UserTables;
import com.afocus.pbuilder.oracle.model.UserViews;

@Service("oracleTableService")
public class OracleTableServiceImpl implements TableService<UserTabOrViews> {

	@Autowired
	private UserTablesMapper userTablesMapper;
	@Autowired
	private UserViewsMapper userViewsMapper;

	@Autowired
	private UserTabColumnsMapper userTabColumnsMapper;

	@Override
	public UserTabOrViews loadTable(String tablespace, String name) {
		if (name == null || name.isEmpty()) {
			return null;
		}
		UserTables table = userTablesMapper.loadByName(name);
		setColumns(table);
		if(table != null) return table;
		
		UserViews view = userViewsMapper.loadByName(name);
		setColumns(view);
		return view;
	}

	@Override
	public List<UserTabOrViews> listTable(String tablespace, String... nameLikes) {
		if (nameLikes == null || nameLikes.length == 0) {
			return new ArrayList<>();
		}
		List<UserTables> tables = userTablesMapper.listByNames(nameLikes);
		tables.forEach(this::setColumns);
		
		List<UserViews> views = userViewsMapper.listByNames(nameLikes);
		views.forEach(this::setColumns);
		
		List<UserTabOrViews> tableOrViews = new ArrayList<>(tables.size() + views.size());
		tableOrViews.addAll(tables);
		tableOrViews.addAll(views);
		
		return tableOrViews;
	}

	private void setColumns(UserTabOrViews tabOrView) {
		if (tabOrView == null)
			return;
		List<UserTabColumns> columns = userTabColumnsMapper
				.listTabColumns(tabOrView.getTableName());
		tabOrView.setUserTabColumnsList(columns);
	}

	@Override
	public List<Map<String, ?>> listData(String schema, String name) {
		return userTablesMapper.listData(name);
	}

}
