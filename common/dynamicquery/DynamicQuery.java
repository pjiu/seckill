package com.seckill.common.dynamicquery;
import java.util.List;

public interface DynamicQuery {

	public void save(Object entity);

	public void update(Object entity);

	public <T> void delete(Class<T> entityClass, Object entityid);

	public <T> void delete(Class<T> entityClass, Object[] entityids);
	
	

	<T> List<T> nativeQueryList(String nativeSql, Object... params);
	

	<T> List<T> nativeQueryListMap(String nativeSql,Object... params);

	 /**
     * 查询对象列表，返回List<组合对象>
     * @param resultClass
     * @param nativeSql
     * @param params
     */
	<T> List<T> nativeQueryListModel(Class<T> resultClass, String nativeSql, Object... params);
	
	/**
	 * 执行nativeSql统计查询
	 * @param nativeSql
	 * @param params 占位符参数(例如?1)绑定的参数值
	 * @return 统计条数
	 */
	Object nativeQueryObject(String nativeSql, Object... params);
	/**
	 * 执行nativeSql统计查询
	 * @param nativeSql
	 * @param params 占位符参数(例如?1)绑定的参数值
	 * @return 统计条数
	 */
	Object[] nativeQueryArray(String nativeSql, Object... params);

	/**
	 * 执行nativeSql的update,delete操作
	 * @param nativeSql
	 * @param params
	 * @return
	 */
	int nativeExecuteUpdate(String nativeSql, Object... params);
}
