package com.whackon.generator.dao;

import com.whackon.generator.pojo.entity.TableBean;

import java.sql.Connection;
import java.util.List;

/**
 * <b>生成器数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 */
public interface GeneratorDao {
	/**
	 * <b>根据数据库名获得该库所有表字段信息</b>
	 * @param dbName
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	List<TableBean> findTableBeanListByDBName(String dbName, Connection connection) throws Exception;
}
