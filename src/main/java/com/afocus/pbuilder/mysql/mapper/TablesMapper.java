package com.afocus.pbuilder.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.afocus.pbuilder.mysql.model.Tables;

/**
 * 
 * @author liuwu
 * @date 2015-09-07
 * @version 5.0
 */
public interface TablesMapper {

	int count(Tables tables);

	List<Tables> query(Tables tables);

	Tables loadByName(@Param("tableSchema") String tableSchema,
			@Param("tableName") String tableName);

	List<Tables> listByNames(@Param("tableSchema") String tableSchema,
			@Param("tableNameLikes") String[] tableNameLikes);
}
