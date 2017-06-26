package com.afocus.pbuilder.common.context;

import com.afocus.pbuilder.common.utils.NamedList;

/**
 * 表数据结构
 * 
 * @author liuwu
 *
 */
public interface Table<T extends Column> extends Named, Typed, Commented,
		Alias, Original,  NamedList<T> {

	/**
	 * 表类型
	 */
	static final String TYPE_TABLE = "TABLE";

	/**
	 * 视图类型
	 */
	static final String TYPE_VIEW = "VIEW";

	/**
	 * 获取表空间名
	 * 
	 * @return 表空间名
	 */
	String getSchema();

}
