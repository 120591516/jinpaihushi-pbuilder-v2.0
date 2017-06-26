package com.afocus.pbuilder.mysql.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.common.service.TableService;
import com.afocus.pbuilder.mysql.mapper.ColumnsMapper;
import com.afocus.pbuilder.mysql.mapper.TablesMapper;
import com.afocus.pbuilder.mysql.model.Columns;
import com.afocus.pbuilder.mysql.model.Tables;

@Service("mysqlTableService")
public class MysqlTableServiceImpl implements TableService<Tables> {

	@Autowired
	private TablesMapper tablesMapper;
	@Autowired
	private ColumnsMapper columnsMapper;

	@Override
	public Tables loadTable(String tableSchema, String tableName) {
		Tables table = tablesMapper.loadByName(tableSchema, tableName);
		setColumns(table);
		return table;
	}

	@Override
	public List<Tables> listTable(String schema, String... nameLikes) {
		if(nameLikes == null || nameLikes.length == 0){
			return new ArrayList<>();
		}
		List<Tables> tables = tablesMapper.listByNames(schema, nameLikes);
		tables.forEach(this::setColumns);
		return tables;
	}

	private void setColumns(Tables table) {
		if (table == null)
			return;
		List<Columns> columnsList = columnsMapper.listTableColumns(
				table.getTableSchema(), table.getTableName());
		table.setColumnsList(columnsList);
	}

	@Override
	public List<Map<String, ?>> listData(String schema, String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
