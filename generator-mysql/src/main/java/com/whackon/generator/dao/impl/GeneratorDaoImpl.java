package com.whackon.generator.dao.impl;

import com.whackon.generator.dao.GeneratorDao;
import com.whackon.generator.pojo.entity.ColumnProperty;
import com.whackon.generator.pojo.entity.TableBean;
import com.whackon.generator.util.DataTypeUtil;
import com.whackon.generator.util.NameUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>生成器数据持久层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 */
@Component("generatorDao")
public class GeneratorDaoImpl implements GeneratorDao {
	/**
	 * <b>根据数据库名获得该库所有表字段信息</b>
	 * @param dbName
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TableBean> findTableBeanListByDBName(String dbName, Connection connection) throws Exception {
		List<TableBean> tableBeanList = new ArrayList<TableBean>();
		// 根据数据库名查询所有的数据表信息
		String SQL = "select table_name tableName, table_comment tableComment from information_schema.tables " +
				"where table_schema=?";
		// 使用 Connection 创建 PreparedStatement 对象
		PreparedStatement statement = connection.prepareStatement(SQL);
		statement.setString(1, dbName);
		// 查询获得结果
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			// 创建 TableBean 对象
			TableBean tableBean = new TableBean();
			// 分别设定属性
			tableBean.setTableName(resultSet.getString("tableName"));
			tableBean.setTableComment(resultSet.getString("tableComment"));
			tableBean.setTableAlias(NameUtil.getTableAliasNameFromTable(tableBean.getTableName()));
			tableBean.setBeanName(NameUtil.getBeanNameFromTable(tableBean.getTableName()));

			// 根据数据库表，获得该表的所有字段
			findColPropListByTable(dbName, tableBean, connection);

			tableBeanList.add(tableBean);
		}
		return tableBeanList;
	}

	private void findColPropListByTable(String dbName, TableBean tableBean, Connection connection)
			throws Exception {
		List<ColumnProperty> colPropList = new ArrayList<ColumnProperty>();
		String SQL = "select table_name tableName, column_name columnName, data_type dataType, " +
				"column_comment columnComment from information_schema.columns " +
				"where table_schema=? and table_name=? order by ordinal_position asc";
		// 使用 Connection 创建 PreparedStatement 对象
		PreparedStatement statement = connection.prepareStatement(SQL);
		statement.setString(1, dbName);
		statement.setString(2, tableBean.getTableName());
		// 进行查询
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			ColumnProperty colProp = new ColumnProperty();
			colProp.setColName(resultSet.getString("columnName"));
			colProp.setColDataType(resultSet.getString("dataType"));
			colProp.setColComment(resultSet.getString("columnComment"));
			colProp.setTableName(resultSet.getString("tableName"));
			colProp.setTableAlias(tableBean.getTableAlias());
			colProp.setPropName(NameUtil.getPropertyNameFromColumn(colProp.getColName()));
			DataTypeUtil.getPropertyDataTypeFromColumn(colProp, tableBean);
			colProp.setGetterMethodName("get" + colProp.getPropName().substring(0,1).toUpperCase()
					+ colProp.getPropName().substring(1, colProp.getPropName().length()));
			colProp.setSetterMethodName("set" + colProp.getGetterMethodName().substring(
					3, colProp.getGetterMethodName().length()));
			colProp.setBeanName(tableBean.getBeanName());

			colPropList.add(colProp);
		}

		tableBean.setColPropList(colPropList);
	}
}
