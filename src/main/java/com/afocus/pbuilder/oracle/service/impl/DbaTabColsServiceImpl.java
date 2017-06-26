package com.afocus.pbuilder.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.oracle.mapper.DbaTabColsMapper;
import com.afocus.pbuilder.oracle.service.DbaTabColsService;

@Service("dbaTabColsService")
public class DbaTabColsServiceImpl implements DbaTabColsService{

	@Autowired
	private DbaTabColsMapper dbaTabColsMapper;


}