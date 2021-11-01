package com.whackon.generator.pojo.vo;

import java.io.Serializable;

/**
 * <b>代码生成视图对象</b>
 */
public class GeneratorVO implements Serializable {
	private static final long serialVersionUID = 5342443082452383889L;
	private String dbIP;                        // 数据库连接 IP 地址
	private String dbPort;                      // 数据库连接端口号
	private String dbName;                      // 数据库名
	private String dbUser;                      // 数据库登录用户名
	private String dbPassword;                  // 数据库登录密码
	private String outFolderPath;               // 生成文件文件夹

	public String getDbIP() {
		return dbIP;
	}

	public void setDbIP(String dbIP) {
		this.dbIP = dbIP;
	}

	public String getDbPort() {
		return dbPort;
	}

	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getOutFolderPath() {
		return outFolderPath;
	}

	public void setOutFolderPath(String outFolderPath) {
		this.outFolderPath = outFolderPath;
	}
}
