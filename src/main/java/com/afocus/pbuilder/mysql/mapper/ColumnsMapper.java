package com.afocus.pbuilder.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.afocus.pbuilder.mysql.model.Columns;


/**
 * 
 * @author liuwu
 * @date 2015-09-07
 * @version 5.0
 */
public interface ColumnsMapper{
	
	int count(Columns columns);

	List<Columns> query(Columns columns);
	
	List<Columns> listTableColumns(@Param("tableSchema") String tableSchema,
			@Param("tableName") String tableName);
}
