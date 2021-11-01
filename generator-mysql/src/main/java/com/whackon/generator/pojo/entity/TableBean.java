package com.whackon.generator.pojo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * <b>数据表对象实体信息</b>
 */
public class TableBean implements Serializable {
	private static final long serialVersionUID = 1360869488379493240L;
	private String tableName;                       // 数据库表明
	private String tableComment;                    // 数据库表注释
	private String tableAlias;                      // 数据表别名
	private String beanName;                        // 类名
	private boolean hasDate;                        // 是否包含有 Date 类型
	private List<ColumnProperty> colPropList;       // 对应字段属性列表

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public String getTableAlias() {
		return tableAlias;
	}

	public void setTableAlias(String tableAlias) {
		this.tableAlias = tableAlias;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public boolean getHasDate() {
		return hasDate;
	}

	public void setHasDate(boolean hasDate) {
		this.hasDate = hasDate;
	}

	public List<ColumnProperty> getColPropList() {
		return colPropList;
	}

	public void setColPropList(List<ColumnProperty> colPropList) {
		this.colPropList = colPropList;
	}
}
