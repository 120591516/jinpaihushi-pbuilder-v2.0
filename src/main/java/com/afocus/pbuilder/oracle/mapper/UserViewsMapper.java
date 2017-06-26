package com.afocus.pbuilder.oracle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.afocus.pbuilder.oracle.model.UserViews;

public interface UserViewsMapper {

	UserViews loadByName(@Param("viewName") String viewName);

	List<UserViews> listByNames(@Param("viewNameLikes") String[] viewNameLikes);

}
