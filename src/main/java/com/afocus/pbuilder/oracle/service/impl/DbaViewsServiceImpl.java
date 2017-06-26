package com.afocus.pbuilder.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.oracle.mapper.DbaViewsMapper;
import com.afocus.pbuilder.oracle.service.DbaViewsService;

@Service("dbaViewsService")
public class DbaViewsServiceImpl implements DbaViewsService{

	@Autowired
	private DbaViewsMapper dbaViewsMapper;


}