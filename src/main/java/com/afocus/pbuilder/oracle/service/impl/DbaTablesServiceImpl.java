package com.afocus.pbuilder.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.oracle.mapper.DbaTablesMapper;
import com.afocus.pbuilder.oracle.service.DbaTablesService;

@Service("dbaTablesService")
public class DbaTablesServiceImpl implements DbaTablesService{

	@Autowired
	private DbaTablesMapper dbaTablesMapper;


}