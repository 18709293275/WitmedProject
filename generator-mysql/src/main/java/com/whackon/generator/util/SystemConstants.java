package com.whackon.generator.util;

import java.util.Properties;

/**
 * <b>系统常量工具类</b>
 * @author Arthur
 * @version 1.0.0
 */
public class SystemConstants {
	private static Properties props = new Properties();

	static {
		try {
			props.load(SystemConstants.class.getClassLoader().getResourceAsStream("props/system.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>Freemarker 模板路径</b>
	 */
	public static final String FREEMARKER_TEMPLATE_PATH = props.getProperty("freemarker.template.path");

	/**
	 * <b>JDBC 连接信息：连接驱动类</b>
	 */
	public static final String JDBC_DRIVER = props.getProperty("jdbc.driver");

	/**
	 * <b>JDBC 连接信息：链接地址前缀</b>
	 */
	public static final String JDBC_URL_PREFIX = props.getProperty("jdbc.url.prefix");

	/**
	 * <b>JDBC 连接信息：链接地址后缀</b>
	 */
	public static final String JDBC_URL_SUFFIX = props.getProperty("jdbc.url.suffix");
}
