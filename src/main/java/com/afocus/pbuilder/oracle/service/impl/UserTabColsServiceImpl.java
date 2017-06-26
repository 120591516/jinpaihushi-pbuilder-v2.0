package com.afocus.pbuilder.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.oracle.mapper.UserTabColsMapper;
import com.afocus.pbuilder.oracle.service.UserTabColsService;

@Service("userTabColsService")
public class UserTabColsServiceImpl implements UserTabColsService{

	@Autowired
	private UserTabColsMapper userTabColsMapper;


}