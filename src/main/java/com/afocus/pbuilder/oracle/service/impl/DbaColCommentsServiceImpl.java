package com.afocus.pbuilder.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.oracle.mapper.DbaColCommentsMapper;
import com.afocus.pbuilder.oracle.service.DbaColCommentsService;

@Service("dbaColCommentsService")
public class DbaColCommentsServiceImpl implements DbaColCommentsService{

	@Autowired
	private DbaColCommentsMapper dbaColCommentsMapper;


}