package com.afocus.pbuilder.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.oracle.mapper.UserTablesMapper;
import com.afocus.pbuilder.oracle.service.UserTablesService;

@Service("userTablesService")
public class UserTablesServiceImpl implements UserTablesService{

	@Autowired
	private UserTablesMapper userTablesMapper;


}