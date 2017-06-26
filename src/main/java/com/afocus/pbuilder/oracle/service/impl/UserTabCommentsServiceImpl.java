package com.afocus.pbuilder.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.oracle.mapper.UserTabCommentsMapper;
import com.afocus.pbuilder.oracle.service.UserTabCommentsService;

@Service("userTabCommentsService")
public class UserTabCommentsServiceImpl implements UserTabCommentsService{

	@Autowired
	private UserTabCommentsMapper userTabCommentsMapper;


}