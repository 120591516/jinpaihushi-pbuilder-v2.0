package com.afocus.pbuilder.oracle.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.afocus.pbuilder.oracle.model.UserTables;

public interface UserTablesMapper {

	UserTables loadByName(@Param("tableName") String tableName);

	List<UserTables> listByNames(
			@Param("tableNameLikes") String[] tableNameLikes);

	List<Map<String, ?>> listData(@Param("tableName") String tableName);
}
