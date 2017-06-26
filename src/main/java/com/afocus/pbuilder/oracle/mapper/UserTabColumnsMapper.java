package com.afocus.pbuilder.oracle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.afocus.pbuilder.oracle.model.UserTabColumns;

public interface UserTabColumnsMapper {

	List<UserTabColumns> listTabColumns(@Param("tableName") String tableName);

}
