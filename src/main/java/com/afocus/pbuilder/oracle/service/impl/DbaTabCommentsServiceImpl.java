package com.afocus.pbuilder.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.oracle.mapper.DbaTabCommentsMapper;
import com.afocus.pbuilder.oracle.service.DbaTabCommentsService;

@Service("dbaTabCommentsService")
public class DbaTabCommentsServiceImpl implements DbaTabCommentsService{

	@Autowired
	private DbaTabCommentsMapper dbaTabCommentsMapper;


}