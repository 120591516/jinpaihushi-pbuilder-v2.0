package com.afocus.pbuilder.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afocus.pbuilder.mysql.mapper.ColumnsMapper;
import com.afocus.pbuilder.mysql.service.ColumnsService;

/**
 * 
 * @author liuwu
 * @date 2015-09-07
 * @version 5.0
 */
@Service("columnsService")
public class ColumnsServiceImpl implements ColumnsService{

	@Autowired
	private ColumnsMapper columnsMapper;

}