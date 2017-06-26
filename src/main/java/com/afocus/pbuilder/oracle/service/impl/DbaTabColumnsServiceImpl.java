package com.afocus.pbuilder.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.oracle.mapper.DbaTabColumnsMapper;
import com.afocus.pbuilder.oracle.service.DbaTabColumnsService;

@Service("dbaTabColumnsService")
public class DbaTabColumnsServiceImpl implements DbaTabColumnsService{

	@Autowired
	private DbaTabColumnsMapper dbaTabColumnsMapper;


}