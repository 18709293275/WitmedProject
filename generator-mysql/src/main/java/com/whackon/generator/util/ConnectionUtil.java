package com.whackon.generator.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <b>数据库连接工具类</b>
 * @author Arthur
 * @version 1.0.0
 */
public class ConnectionUtil {
	static {
		try {
			Class.forName(SystemConstants.JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>根据用户所给定连接信息，获得 Connection 对象</b>
	 * @param dbIP
	 * @param dbPort
	 * @param dbName
	 * @param dbUser
	 * @param dbPassword
	 * @return
	 */
	public static Connection getConnection(String dbIP, String dbPort, String dbName,
	                                       String dbUser, String dbPassword) {
		// 根据用户信息拼接完整的 URL
		String url = SystemConstants.JDBC_URL_PREFIX + dbIP + ":" + dbPort + "/" + dbName + SystemConstants.JDBC_URL_SUFFIX;

		try {
			// 根据连接信息创建连接对象
			return DriverManager.getConnection(url, dbUser, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
