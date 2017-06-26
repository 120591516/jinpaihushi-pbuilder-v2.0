package com.afocus.pbuilder.common.context;


public interface Field extends Named, Typed, Commented, Original{

	/**
	 * 获取get方法名，如当name=createTime时，getMethod=getCreateTime
	 * @return get方法名
	 */
	String getGetMethod();
	
	/**
	 * 获取set方法名，如当name=createTime时，getMethod=setCreateTime
	 * @return set方法名
	 */
	String getSetMethod();
	
	/**
	 * 获取类型全称，如type=Date时，fullType=java.util.Date;
	 * type=Integer是，fullType=java.lang.Integer
	 * @return 类型全称
	 */
	String getFullType();
	
	String getJdbcType();
	
}
