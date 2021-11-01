package com.whackon.generator.util;

import com.whackon.generator.pojo.entity.ColumnProperty;
import com.whackon.generator.pojo.entity.TableBean;

/**
 * <b>数据类型工具类</b>
 * @author Arthur
 * @version 1.0.0
 */
public class DataTypeUtil {
	/**
	 * <b>根据数据库字段获得属性类型</b>
	 * @param colProp
	 * @param tableBean
	 */
	public static void getPropertyDataTypeFromColumn(ColumnProperty colProp, TableBean tableBean) {
		if ("int".equalsIgnoreCase(colProp.getColDataType())) {
			colProp.setPropShortDataType("Integer");
			colProp.setPropFullDataType("java.lang.Integer");
		} else if ("varchar".equalsIgnoreCase(colProp.getColDataType())) {
			colProp.setPropShortDataType("String");
			colProp.setPropFullDataType("java.lang.String");
		} else if ("decimal".equalsIgnoreCase(colProp.getColDataType())) {
			colProp.setPropShortDataType("Double");
			colProp.setPropFullDataType("java.lang.Double");
		} else if ("date".equalsIgnoreCase(colProp.getColDataType())
				|| "timestamp".equals(colProp.getColDataType())) {
			colProp.setPropShortDataType("Date");
			colProp.setPropFullDataType("java.util.Date");
			tableBean.setHasDate(true);
		}
	}
}
