package com.afocus.pbuilder.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.oracle.mapper.UserTabColumnsMapper;
import com.afocus.pbuilder.oracle.service.UserTabColumnsService;

@Service("userTabColumnsService")
public class UserTabColumnsServiceImpl implements UserTabColumnsService{

	@Autowired
	private UserTabColumnsMapper userTabColumnsMapper;


}