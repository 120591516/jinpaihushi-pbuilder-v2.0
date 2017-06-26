package com.afocus.pbuilder.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.mysql.mapper.ColumnsMapper;
import com.afocus.pbuilder.mysql.mapper.TablesMapper;
import com.afocus.pbuilder.mysql.service.TablesService;

@Service("tablesService")
public class TablesServiceImpl implements TablesService {

	@Autowired
	private TablesMapper tablesMapper;
	@Autowired
	private ColumnsMapper columnsMapper;

}
