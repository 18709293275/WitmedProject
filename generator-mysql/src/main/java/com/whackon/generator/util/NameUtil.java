package com.whackon.generator.util;

/**
 * <b>名称工具类</b>
 */
public class NameUtil {
	/**
	 * <b>根据数据库表名获得表的别名</b>
	 * @param tableName
	 * @return
	 */
	public static String getTableAliasNameFromTable(String tableName) {
		// 使用 “_” 对数据库表名进行切割
		String[] tableNameArys = tableName.split("_");
		StringBuffer sb = new StringBuffer();
		for (String tableNamePart : tableNameArys) {
			sb.append(tableNamePart.substring(0, 1).toLowerCase());
		}
		return sb.toString();
	}

	/**
	 * <b>根据数据表名获得类名</b>
	 * @param tableName
	 * @return
	 */
	public static String getBeanNameFromTable(String tableName) {
		// 使用 “_” 对数据库表名进行切割
		String[] tableNameArys = tableName.split("_");
		if (tableNameArys.length == 1) {
			// 此时数据表只有一个名字
			return tableName.substring(0,1).toUpperCase() + tableName.substring(1, tableName.length());
		} else {
			// 数据库表有若干部分组成
			// 去掉第一个部分的前缀信息
			StringBuffer sb = new StringBuffer();
			for (int i = 1; i < tableNameArys.length; i++) {
				sb.append(tableNameArys[i].substring(0, 1).toUpperCase());
				sb.append(tableNameArys[i].substring(1, tableNameArys[i].length()));
			}
			return sb.toString();
		}
	}

	public static String getPropertyNameFromColumn(String colName) {
		String[] colNameArys = colName.split("_");
		StringBuffer sb = new StringBuffer();
		// 生成属性名
		sb.append(colNameArys[0].substring(0,1).toLowerCase());
		sb.append(colNameArys[0].substring(1,colNameArys[0].length()));
		if (colNameArys.length > 1) {
			for (int i = 1; i < colNameArys.length; i++) {
				sb.append(colNameArys[i].substring(0, 1).toUpperCase());
				sb.append(colNameArys[i].substring(1, colNameArys[i].length()));
			}
		}
		return sb.toString();
	}
}
