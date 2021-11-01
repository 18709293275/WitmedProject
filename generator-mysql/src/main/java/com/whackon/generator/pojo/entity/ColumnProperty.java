package com.whackon.generator.pojo.entity;

import java.io.Serializable;

/**
 * <b>字段属性信息</b>
 */
public class ColumnProperty implements Serializable {
	private String colName;                     // 字段名
	private String colDataType;                    // 字段类型
	private String colComment;                  // 字段注释
	private String tableName;                   // 数据表名
	private String tableAlias;                  // 数据表别名
	private String propName;                    // 属性名
	private String propFullDataType;            // 属性类型全限定名
	private String propShortDataType;           // 属性类型短命
	private String getterMethodName;            // get 方法名
	private String setterMethodName;            // set 方法名
	private String beanName;                    // 实体类名

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getColDataType() {
		return colDataType;
	}

	public void setColDataType(String colDataType) {
		this.colDataType = colDataType;
	}

	public String getColComment() {
		return colComment;
	}

	public void setColComment(String colComment) {
		this.colComment = colComment;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableAlias() {
		return tableAlias;
	}

	public void setTableAlias(String tableAlias) {
		this.tableAlias = tableAlias;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropFullDataType() {
		return propFullDataType;
	}

	public void setPropFullDataType(String propFullDataType) {
		this.propFullDataType = propFullDataType;
	}

	public String getPropShortDataType() {
		return propShortDataType;
	}

	public void setPropShortDataType(String propShortDataType) {
		this.propShortDataType = propShortDataType;
	}

	public String getGetterMethodName() {
		return getterMethodName;
	}

	public void setGetterMethodName(String getterMethodName) {
		this.getterMethodName = getterMethodName;
	}

	public String getSetterMethodName() {
		return setterMethodName;
	}

	public void setSetterMethodName(String setterMethodName) {
		this.setterMethodName = setterMethodName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
}
