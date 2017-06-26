package com.afocus.pbuilder.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.oracle.mapper.UserViewsMapper;
import com.afocus.pbuilder.oracle.service.UserViewsService;

@Service("userViewsService")
public class UserViewsServiceImpl implements UserViewsService{

	@Autowired
	private UserViewsMapper userViewsMapper;


}