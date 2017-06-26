package com.afocus.pbuilder.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.oracle.mapper.UserColCommentsMapper;
import com.afocus.pbuilder.oracle.service.UserColCommentsService;

@Service("userColCommentsService")
public class UserColCommentsServiceImpl implements UserColCommentsService{

	@Autowired
	private UserColCommentsMapper userColCommentsMapper;


}